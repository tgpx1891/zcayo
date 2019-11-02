### 启动方式

直接双击`nginx.exe`会有个屏幕一闪而过，这个时候，其实已经启动成功了。 只需要打开访问地址`http://127.0.0.1`。可以用任务管理器关闭

注： nginx启动之后，在任务管理里有两个nginx进程，这个是正常的，一个是1个守护进程 1个工作进程，得手动分别关闭。如果文件解压目录下文件夹名称含有中文，会启动不成功

或者用命令行方式，进入 nginx 目录

```
start nginx         # 开启
nginx -s stop         # 关闭
```

### 端口号修改

打开nginx目录下的conf/nginx.conf文件，然后找到 listen 80，修改为 9090，关闭 nginx 再启动，就可以通过如下地址访问`http://127.0.0.1:9090/`，或者用命令`nginx -s reload` 

nginx.conf 是nginx的核心配置文件，里面的内容也不少

```
listen       80;         # 端口号
root html;         # 页面存放位置
index  index.html index.htm;         # 欢迎页面
```

端口被占用？

端口被占用就无法启动tomcat所以要找到端口被占用的程序是哪一个，然后再关闭对应的程序即可  

```
netstat -ano|findstr "80"         # 查看80端口被哪些程序占用了
tasklist|findstr "1828"         # 根据pid（进程id）查询对应的应用程序
taskkill /f /t /im         # java.exe根据名称结束该程序
taskkill /f /pid 1828         # 或者通过pid终止
```

最后一列是进程号 pid