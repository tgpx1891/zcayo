查看版本号：node --version

创建文件`server.js`

```js
var http = require('http');         // 引入 http 模块
var url=require('url');;         // 引入url 模块，帮助解析
var querystring=require('querystring');;         // 引入 querystring 库，也是帮助解析用的
function service(request, response) {         // 准备处理请求和响应的 service 函数
    var arg = url.parse(req.url).query;         // 获取返回的url对象的query属性值
    var params = querystring.parse(arg);         // 将arg参数字符串反序列化为一个对象
    console.log("method - " + req.method);         // 请求的方式
    console.log("url - " + req.url);         // 请求的url
    console.log("id- " + params.id);         // 获取参数id
    response.writeHead(200, {'Content-Type': 'text/plain'});         // 设置返回代码，以及返回格式
    response.end('Hello Node.js');         // 设置返回内容
}
var server = http.createServer(service);         // 基于service函数来创建服务器
server.listen(8088);         // 服务器监听于8088端口
```

进入文件所在目录，执行如下命令

```
cd e:\project\nodejs\src
node server.js
```

然后访问地址`http://127.0.0.1:8088/`，就可以看到屏幕输出的内容。注意别把命令行窗口关闭了，关闭后浏览器就不能访问了

### npm 和 cnpm

npm 命令用于从国外的服务器上下载别人做好的模块。 因为是在国外的服务器，有的时候网速会很受影响，其结果就是导致下载会非常卡顿。所以这个时候就会用到 cnpm了。这里的c 是 copy的意思，即复制 npm 上面的库。把 npm 上面的库复制到 国内的服务器上，当需要用的时候，使用 cnpm 命令获取，就会快很多了

```
npm install -g cnpm --registry=https://registry.npm.taobao.org         # 安装 cnpm
cnpm -v         # 检查当前的版本
cnpm install how2java         # 安装 how2java
```

其中的-g 是-global 的意思，即全局安装，而不是安装在当前目录下。 一旦全局安装过了，项目就不需要在本地安装也可以使用了。与npm类似的，通过 cnpm 可以检查当前的版本

cnpm 本质上是复制库，它只负责从源库定期复制国内库，所以不支持通过 cnpm publish 发布到复制库上。
要发布，还是要通过 npm 发布到源库，然后耐心等待复制库同步。 （一般说来是十几分钟）