### 启动方式

直接双击`nginx.exe`会有个屏幕一闪而过，这个时候，已经启动成功了。 只需要打开访问地址`http://127.0.0.1`。可以用任务管理器关闭。nginx启动之后，在任务管理里有两个nginx进程，这个是正常的，一个是守护进程一个是工作进程，得手动分别关闭。如果文件解压目录下文件夹名称含有中文，会启动不成功。或者用命令行方式

```
cd d:/software/nginx
start nginx         # 开启
nginx -s stop         # 关闭
```

### 端口号修改

打开 nginx 目录下的 conf/nginx.conf 文件，然后找到 listen 80，修改为 9090，关闭 nginx 再启动，就可以通过如下地址访问`http://127.0.0.1:9090/`。或者用命令`nginx -s reload` 重启。nginx.conf 是nginx的核心配置文件，里面的内容也不少

```
listen       80;         # 端口号
root html;         # 页面存放位置
index  index.html index.htm;         # 欢迎页面
```

端口被占用就无法启动 tomcat，所以要找到端口被占用的程序是哪一个，然后再关闭对应的程序即可  

```
netstat -ano|findstr "80"         # 查看80端口被哪些程序占用了，最后一列是进程号 pid
tasklist|findstr "1828"         # 根据pid（进程id）查询对应的应用程序
taskkill /f /t /im         # java.exe根据名称结束该程序
taskkill /f /pid 1828         # 或者通过pid终止
```

### 多个 Tomcat

 Nginx 是一个 web 服务器，很快速，但是不能作为 Servlet 容器独立运行，所以通常的工作方式是 Nginx 配合Tomcat来协同工作。 这就是为什么要单独提供 Tomcat，以方便配合 Nginx 进行工作。教程中的两个 tomcat 端口号分别是8111和8222。启动之后访问地址`http://127.0.0.1:8111/`，会自动跳转到`http://127.0.0.1:8111/login.jsp`。 在 login.jsp 这个页面上有图片，访问图片会在 tomcat 里跟踪信息输出，用于观察图片静态资源的访问是否是在当前 tomcat 上发生。 做负载均衡的话，要准备里两个一模一样的 tomcat，只是他们的端口号不一样。 登陆之后，会把登陆信息记录在 session里 

### 反向代理

正向代理，比如要访问 youtube，但是不能直接访问，只能先找个翻墙软件，通过翻墙软件才能访问 youtube。翻墙软件就叫做正向代理。而反向代理指的是用户要访问 youtube，但是 youtube 悄悄地把这个请求交给 bilibili 来做，那么 bilibili 就是反向代理了。比如访问 nginx，但是 nginx 把请求交给 tomcat 来做 

- 首先启动多个 Tomcat 中端口号是 8111 的 tomcat；
- 然后修改 nginx.conf，主要是 30-42 行；
- 使用命令`nginx -s reload`重启 nginx， 然后访问地址`http://127.0.0.1/`， 就会观察到已经反向代理到 tomcat 了 

```java
// 修改 nginx.conf
location / {
	proxy_pass http://127.0.0.1:8111;
}
// 修改 nginx.conf 2
location ~\.(css|js|png)$ {
	root C:/Users/X7TI/Downloads/tomcat_8111/webapps/ROOT;
}
```

 因为 nginx 在处理静态文件的吞吐量上面比 tomcat 好很多，通常他们俩配合，不会把所有的请求都交给tomcat，而是把静态请求交给 nginx，动态请求如 jsp、servlet、ssm、struts 等请求交给 tomcat，从而达到动静分离的效果 

### 动静分离 

动静分离就是指图片，css、js 之类的都交给 nginx 来处理，nginx 处理不了的，比如 jsp 就交给 tomcat 来处理。好处是nginx 处理静态内容的吞吐量很高，这样无形中提升了性能。 

- 修改 nginx.conf， 在 locaction 下面添加一个新的 location， 表示所有的 css js png 访问都由 nginx 来做；
- 访问地址`http://127.0.0.1/login.jsp`，观察到静动都有的效果；
- 再到 tomcat 的输出日志里观察，就会发现，只访问了 jsp，所有的 css、js、png 都不会经过 tomcat，而是由 nginx 自己负责处理了

### 负载均衡 

负载均衡就是当访问量很大的时候，一个 Tomcat 吃不消了，这时候就准备多个 Tomcat，由 Nginx 按照权重来对请求进行分配，从而缓解单独一个 Tomcat 受到的压力 

- 启动 8111 和 8222 两个tomcat（不会冲突，因为端口不同）；
- 修改 nginx.conf，首先在30行增加一个 upstream ，用来指向这两个 tomcat；
- 重启 nginx 并使劲访问`http://127.0.0.1/login.jsp`，就可以观察到对 jsp 的访问，被分配到了不同的 Tomcat上 

```java 
// 修改 nginx.conf
...
#gzip  on;
 
upstream tomcat_8111_8222{
server  127.0.0.1:8111  weight=1;
server  127.0.0.1:8222 weight=2;
ip_hash;			# 通过 ip 地址标记用户
}

server {
    listen       80;
    server_name  localhost;

    #charset koi8-r;

    #access_log  logs/host.access.log  main;

    location / {
        proxy_pass http://tomcat_8111_8222;
 }
```

### session  共享

 通过负载均衡，我们可以把请求分发到不同的 Tomcat 来缓解服务器的压力，但是这里存在一个问题：当同一个用户第一次访问 tomcat_8111 并且登录成功， 而第二次访问却被分配到了 tomcat_8222，这里并没有记录他的登陆状态，那么就会呈现未登录状态了，严重伤害了用户体验 

#### 解决办法

1. 通过 ip 地址标记用户，如果多次请求都是从同一个ip来的，那么就都分配到同一个tomcat。这样就不会出现负载均衡 session 问题了. 处理手段也很简单，只要在 upstream 最后加上 ip_hash; 就行了。 不过这种方案并不完美，当如下几种情况发生时就有问题：大量请求来之某个局域网，那么相当于就没有负载均衡了；如果 tomcat_8111 挂了，那么此时 nginx 只能把请求交给 tomcat_8222，但是这里却没有记录 session，用户体验依然受影响；
2. 用Redis来存取session。 这样当 tomcat1 需要保存 session 值的时候，就可以把它放在 Redis 上，需要取的时候，也从 Redis 上取。  用户提交账号密码的行为被分配在了 tomcat8111 上，登陆信息被存放在 redis 里。当用户第二次访问的时候，被分配到了 tomcat8222 上。那么此时 tomcat8222 就会从redis去获取相关信息，一看有对应信息，那么就会呈现登陆状态。这样就规避了通过 ip 地址标记用户里会出现的两种问题了
   - 启动 redis 服务器， Tomcat 需要链接 redis 就需要专门的 jar 包，包括 jedis-2.5.2.jar、commons-pool2-2.0.jar 和 tomcat-redis-session-manager1.2.jar， 放在 tomat8111 的 lib 目录下；
   - 修改 tomcat/conf/context.xml， 两个 tomcat 都要改，然后重启 tomcat；
   - 测试访问 tomcat8111： `http://127.0.0.1:8111/login.jsp`， 然后登陆，并观察到已登陆状态； 测试访问 tomcat8222： `http://127.0.0.1:8222/login.jsp`， 虽然没有在 tomcat8222 上登陆，但是可以观察到已经呈现为登陆状态了 

```java
// 修改 tomcat/conf/context.xml
...
<Valve className="com.orangefunction.tomcat.redissessions.RedisSessionHandlerValve" />  
  <Manager className="com.orangefunction.tomcat.redissessions.RedisSessionManager"  
   host="127.0.0.1"  
   port="6379"  
   database="0"  
   maxInactiveInterval="60" /> 
 
</Context>
```

