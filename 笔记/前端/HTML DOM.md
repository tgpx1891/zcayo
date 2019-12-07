## HTML DOM

DOM 是Document Object Model( 文档对象模型 )的缩写，DOM 是把 html 里面的各种数据当作对象进行操作的一种思路。比如一个超链，作为一个 DOM 对象，就可以使其隐藏，修改其 href 指向的地址

### DOM 节点

```html
<html>
<div id="d" class="d" align="center">hello HTML DOM</div>
<input name="userName" id="input" class="class1 class2" test="t" value="这是一个输入框">
<script>
function p(s){
    document.write(s);
    document.write("<br>");
}
var  div = document.getElementById("d");			// 获取某个元素对应的元素节点对象
p("文档节点" + document);			// 结果为 [object HTMLDocument]
p("元素" + div);			// 结果为 [object HTMLDivElement]
p("属性节点" + div.attributes[0]);			// 结果为 [object Attr]
p("内容节点" + div.childNodes[0]);			// 结果为 [object Text]
var  divs = document.getElementsByTagName("div");			// 通过标签名称获取元素节点
for(i=0;i<divs.length;i++){
  document.write(divs[i]);			// 结果为 [object HTMLDivElement]
  document.write("<br>");
}
var elements = document.getElementsByClassName("d");			// 通过类名获取元素节点
var  elements= document.getElementsByName("userName");			// 通过表单元素的name获取元素节点
// 获取属性节点
var as = div.attributes;			
document.write("div总共有"+as.length +" 个属性，分别是：");
for(i = 0; i< as.length; i++){
document.write("<br>" + as[i].nodeName + ":");			// 分别是 id、class 和 align
document.write(as[i].nodeValue);
}
p("<br>"+"div的id属性值是："+ as["id"].nodeValue);
// 获取内容节点
var content = div.childNodes[0];
p("div的内容节点名是:"+content.nodeName+"<br>");			// #text
p("div的内容节点值是:"+content.nodeValue);			// hello HTML DOM
 var content = div.childNodes[1];
// p("div的内容节点值是:"+content.childNodes[0].nodeValue); 	如果 div 中有子 div
// 节点名称  
p("document的节点名称:"+document.nodeName);			// 结果为 #document
p("div元素节点的节点名称:"+div.nodeName);			// 结果为 DIV
p("div下属性节点的节点名称:"+div1.attributes[0].nodeName);		// 结果为 id
p("div下内容节点的节点名称:"+div1.childNodes[0].nodeName);		// 结果为 #text
// 节点值
p("document是没有nodeValue的："+document.nodeValue);			// 结果为 null
p("元素节点是没有nodeValue的："+div.nodeValue);			// 结果为 null
p("属性节点id的nodeValue："+div.attributes[0].nodeValue);			// 结果为 d
p("内容节点的nodeValue："+div.childNodes[0].nodeValue);			// 结果为 hello HTML DOM
// 节点类型
p("document的nodeType是："+document.nodeType);			// 结果为 9
p("元素节点的nodeType是："+div.nodeType);			// 结果为 1
p("属性节点的nodeType是："+div.attributes[0].nodeType);			// 结果为 2
p("内容节点的nodeType是："+div.childNodes[0].nodeType);			// 结果为 3
document.getElementById("d").childNodes[0].nodeValue= "通过childNode[0].value改变内容";
document.getElementById("d").innerHTML= "通过innerHTML改变内容";
// 获取元素上的属性
var input = document.getElementById("input");
var s = "id="+input.id + "<br>";
s += "value="+input.value + "<br>";
s += "class="+input.className + "<br>";
s += "test="+input.getAttribute("test")+ "<br>";
s += "test="+input.attributes["test"].nodeValue+ "<br>";
document.getElementById("d").innerHTML= s;
</script>
</html>
```

 nodeType 表示一个节点的类型，不同的节点类型，对应的节点类型值是不一样的。元素 1，属性 2，文本 3，注释 8， 文档 9。因为 javascript 是解释语言，是顺序执行的。 在执行到 document.getElementById 的时候，div 标签还没有加载，所以无法获取 

```html
<html>
<script>
var  div1 = document.getElementById("d1");			// 结果为 null
document.write(div1);
</script>
</html>
<div id="d1">hello HTML DOM</div>
```

### 样式

```html
<button onclick="hide()">隐藏div</button>
<div id="d" style="background-color:pink">这是一个div</div>
<script>
function hide(){
 var d = document.getElementById("d");
 d.style.display="none";			// 隐藏div
 d1.style.backgroundColor="green";			// 改变背景色
}
function show(){
 var d = document.getElementById("d");
 d.style.display="block";			// 显示div
}
</script>
```

 DOM 的 style 样式和 CSS的不同， 可以通过 JQuery 设置 CSS `d.css("background-color","green");` 

### 事件 

```html
<body onload="loadBody()">			<!-- 加载body -->
<form action="/study/login.jsp" onsubmit="return login()">			<!-- 提交 -->
<input type="text" onfocus="f()" onblur="b()" onchange="change()" id="input1" placeHolder="输入框1" >
<!-- 分别是获得焦点、失去焦点、内容改变 -->
<input type="submit" value="登录">
</form>
<input type="button" onmousedown="down()" onmouseup="up()" onmousemove="move()" onmouseover="over()" onmouseout="out()" onkeydown="down(event)" onkeypress="press(event)" onkeyup="up()" onclick="singleClick()" ondblclick="doubleClick()" onclick="singleClick(this)" value="用于演示按下和弹起" >
<!-- 分别是鼠标按下、鼠标弹起、鼠标经过、鼠标进入、鼠标退出、键盘按下、键盘按下、键盘弹起、单击、双击 -->
<div id="message"></div>
<img onload="loadImg()" src="https://how2j.cn/example.gif"/>		<!-- 加载图片 -->
</body>
<script>
// 焦点
function f(){
 document.getElementById("message").innerHTML="输入框1获取了焦点";
}
// 鼠标 
var number = 0;
function down(){
document.getElementById("message").innerHTML="按下了鼠标";
}
function move(){
document.getElementById("message").innerHTML="鼠标经过次数:"+(++number);
}
function over(){
document.getElementById("message").innerHTML="鼠标进入次数:"+(++number);
}
function out(){
document.getElementById("message").innerHTML="鼠标退出";
number = 0;
}
// 键盘
var number =0;
function down(e){
var text = "按下了键" + e.keyCode;			// keyCode为键的代码（97）
if(e.shiftKey==1)
   text += " 并且按下了shift键";
document.getElementById("message").innerHTML=text ;
}
function singleClick(button){			// 可以通过 this 获取值
document.getElementById("message").innerHTML="被点击的按钮上的文本是: "+button.value;
}
function login(){			// 当onSubmit得到的返回值是false的时候，表单的提交功能被取消
   var name = document.getElementById("name");
   if(name.value.length==0){
     alert("用户名不能为空");
     return false;
   }
   return true;
}
</script>
```

-  无论鼠标在组件上如何移动，onmouseover只会触发一次，onmousemove 每次移动都会触发 
- onkeydown 可以获取所有键，除了打印键 Prts，可以获取用户是否点击了修饰键 (ctrl,shift,alt)，不能判断输入的是大写还是小写。onkeypress 只能获取字符键，不能获取用户是否点击了修饰键 (ctrl,shift,alt)，可以判断输入的是大写还是小写。但是在不同的浏览器上，以上规则都是不同的
-  在组件上，按下空格或则回车键也可以造成单击的效果，但是却不能造成双击的效果。自定义函数不要使用click()，这是保留函数名 

### 节点的关系

```html
<script>
var node = null;
function showParent(){
   if(null==node)
      node = document.getElementById("d1");
   if(document == node)
      alert("已是根节点:document");
   else{
      alert(node.parentNode);			
      node = node.parentNode;
   }
}
// [object HTMLDivElement],[object HTMLBodyElement],[object HTMLHtmlElement],[object HTMLDocument]
function showPre(){
    var d2 = document.getElementById("d2");
    alert(d2.previousSibling.innerHTML);		// 获取 d2 的前一个同胞的节点内容（第一个div）
    alert(d2.nextSibling.nodeName);			// 获取 d2 的后一个同胞的节点名（#text，前面有换行）
    var div = document.getElementById("parentDiv");
    alert(div.firstChild.nodeName);			// 第一个子节点（#text，前面有换行）
    alert(div.lastChild.nodeName);			// 最后一个子节点（DIV）
    alert(div.childNodes.length);		// 所有子节点数量，会包含文本节点，结果为 6
    alert(div.children.length);			// 会排除文本节点，结果为 3
}
</script>
<div id="parentDiv">
    父Div的内容
    <div id="d1">第一个div</div><div id="d2">第二个div</div>
    <div id="d3">第三个div</div></div>
<button onclick="showParent()">不断递归d1的父节点</button>
```

如果 d2 和 d3 不是紧挨着的，标签之间有任何字符、空白、换行都会产生文本元素，获取到的节点会是 #text

### 节点处理

```html
<script>
function add(){
  var hr=document.createElement("hr");			// 创建一个新的元素节点 hr
  var div = document.getElementById("d");
  div.appendChild(hr);			// 在 div 中追加一个hr元素
  var p=document.createElement("p");			
  var text = document.createTextNode("这是通过DOM创建出来的<p>");			// 创建一个内容节点
  p.appendChild(text);			// 在 div 中追加一个p元素
  var a=document.createElement("a");			
  var content = document.createTextNode("http://12306.com");
  a.appendChild(content);			// 在 div 中追加一个超链
  var href = document.createAttribute("href");			// 创建一个属性节点
  href.nodeValue="http://12306.com";
  a.setAttributeNode(href);			// 把属性设置到元素节点 a 上
  var parentDiv = document.getElementById("parentDiv");
  var d2= document.getElementById("d2");
  parentDiv.removeChild(d2);			// 先获取元素节点，再删除元素节点
  var link= document.getElementById("link");
  link.removeAttribute("href");			// 删除属性节点，删除超链的 href 属性
  var textNode = parentDiv.childNodes[0];
  parentDiv.removeChild(textNode);			// 删除 div 下的文本节点
  parentDiv.innerHTML="";			// 或者通过 innerHTML 让内容置空
  var d3=  document.createElement("div");
  var text = document.createTextNode("第三个div");
  d3.appendChild(text);
  var d2 = document.getElementById("d2");
  parentDiv.replaceChild(d3,d2);			// 替换第2个div
  parentDiv.insertBefore(d3,d2);			// 在第2个div之前插入一个div
}
</script>
<button onclick="add()">在div中追加一个hr元素</button>
<div id="parentDiv">
<div id="d">Hello HTML DOM</div>
<div id="d2">即将被删除的div</div>
</div>
<a id="link" href="http://12306.com">http://12306.com</a>
```

## JSON

 JSON（JavaScript Object Notation，JavaScript 对象表示法） 是一种存储数据的方式 

```html
<script>
var gareen = {"name":"盖伦","hp":616};			// 创建JSON对象
document.write("这是一个JSON对象: "+gareen);			// [object Object]
document.write("英雄名称: " + gareen.name + "<br>");			// 访问JSON对象的属性，盖伦
var heros=			// 创建JSON 数组
[
    {"name":"盖伦","hp":616},
    {"name":"提莫","hp":313},
    {"name":"死歌","hp":432},
    {"name":"火女","hp":389}
]
document.write("JSON数组大小"+heros.length);			// 数组长度，4
document.write( "第4个英雄是:" +  heros[3].name);			// 访问JSON数组，火女
var s1 = "{\"name\":\"盖伦\"";
var s2 = ",\"hp\":616}";
var s3 = s1 + s2;			// 通过字符串拼接得到一个JSON结构的字符串
var gareen2 = eval("("+s3+")");			// 字符串转为JSON对象，eval 函数要以（ 开头，）结尾
var heroString = JSON.stringify(gareen);			// JSON 对象转换为字符串
document.write("这是一个json 字符串："+ heroString );			// 结果为 {"name":"盖伦","hp":"616"}
</script>
```

 JavaScript 对象分内置对象(Number,String,Array,Date,Math)和自定义对象，JSON 就是自定义对象，只不过是以 JSON这样的数据组织方式表达出来，所以不存在 JSON 对象与 JavaScript 对象的转换问题 

## AJAX  

 通过AJAX（Asynchronous JavaScript And XML）实现异步刷新。 准备一个 JSP 页面，叫做 checkName.jsp 用于校验提交的用户名是否存在。如果提交的用户名是 abc 就打印存在，否则就可以使用  

```html
<a href="https://how2j.cn/study/checkName.jsp?name=abc">checkName.jsp?name=abc</a>
<form action="https://how2j.cn/study/checkName.jsp">
<input name="name" type="text" value="abc">
<input type="submit" value="验证账号是否存在">
</form>
<!-- 使用AJAX 通过无刷新验证账号是否存在 -->
<input id="name" name="name" onkeyup="check()" type="text"> 
<span id="checkResult"></span>
<script>
var xmlhttp;
function check(){
  var name = document.getElementById("name").value;
  var url = "https://how2j.cn/study/checkName.jsp?name="+name;
  xmlhttp =new XMLHttpRequest();		// 创建XHR对象 XMLHttpRequest（[object XMLHttpRequest]）
  xmlhttp.onreadystatechange=checkResult; // 设置响应函数
  xmlhttp.open("GET",url,true);   // 设置访问的页面
  xmlhttp.send(null);
  // POST 方式 xmlhttp.send("user="+username+"&password="+password)
}
function checkResult(){
  if (xmlhttp.readyState==4 && xmlhttp.status==200)			// 4表示请求已完成，200表示响应成功
    document.getElementById('checkResult').innerHTML=xmlhttp.responseText;	  // 获取服务端传回来的文本
}
</script>
```

![1232](https://stepimagewm.how2j.cn/1232.png)

 XHR对象是一个 javascript 对象，它可以在用户没有感觉的情况下，就像背后运行的一根小线程一般，悄悄的和服务器进行数据交互，AJAX 就是通过它做到无刷新效果的 。readyState 存有 XMLHttpRequest 的状态，0 请求未初始化，1 服务器连接已建立，2 请求已接收，3 请求处理中，4 请求已完成，响应已就绪。status 200 请求成功，404 未找到页面。以下是  checkName.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String name = request.getParameter("name");
    if("abc".equals(name))
        out.print("<font color='red'>已经存在</font>");
    else
        out.print("<font color='green'>可以使用</font>");
%>
```

## node.js

 vue.js 开发时候用的 vue-cli 和 webpack，需要用到 node.js 。javascript 是在浏览器上运行的脚本语言，主要用来控制 html 元素，即 html dom 对象，是纯粹的客户端语言 。 而 vue.js 是在服务端运行的 javascript， node.js 上的应用可以使用 javascript 开发，这样方便前端人员，node.js 的 I/O 操作是非阻塞式的，比起 tomcat 这种 阻塞式 的更有优势 

 检验安装成功与否 ，看版本号`node --version`

在`e:\project\nodejs\src`目录下创建文件`server.js`

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
    response.writeHead(200, {'Content-Type': 'text/plain'});        // 设置返回代码，以及返回格式
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

然后访问地址`http://127.0.0.1:8088/`，就可以看到屏幕输出的内容。注意别把命令行窗口关闭了，关闭后浏览器就不能访问了。 在日志里，会出现 /favicon.ico 信息，这个 favion 是 favorite icon 的缩写，即网站图标。用 node.js 就会有这么一个默认的访问。	运行结果如下：

![](https://stepimagewm.how2j.cn/7863.png)

### 引入外部模块

 在 server.js 同一个目录下创建 how2j.js 

```js
// how2j.js 文件
function service(request, response) {
    response.writeHead(200, {'Content-Type': 'text/plain'});
    response.end('Hello Node.js');
}
function sayHello(){
    console.log('hello from how2j.js');			// 在控制台（命令行输出）
}
exports.hi = sayHello;			// 允许外部通过 hi() 这个函数名称调用 sayHello()
exports.service = service;			// 允许外部通过 service() 同名调用
// server.js 文件
var http = require('http');
var how2j = require('./how2j');
how2j.hi();
var server = http.createServer(how2j.service);
server.listen(8088);
```

### 路由

 如果没有路由的概念，那么无论是访问 `/listCategory` 路径 还是访问 `/listProduct` 路径，都是在`service(request,response)` 函数里做的。那么引入路由的概念的话，就是指访问 `/listCategory` 路径，会访问 listCategory 函数。 而访问 `/listProduct` 路径，就会访问 listProduct 函数 

```js
// 业务处理模块 requestHandlers.js
function listCategory() { 
    return "a lot of categorys";
} 
function listProduct() { 
    return "a lot of products";
} 
exports.listCategory = listCategory; 
exports.listProduct = listProduct; 
// 路由模块 router.js
function route(handle, pathname) {			// 第一个参数是一个数组，第二个参数是路径
  if (typeof handle[pathname] === 'function') { 
    return handle[pathname](); 
  } else {
    return pathname + ' is not defined';
  } 
} 
exports.route = route; 	
// 服务器模块 server.js
var http = require("http"); 
var url = require("url"); 
function start(route, handle) { 
  function onRequest(request, response) { 
    var pathname = url.parse(request.url).pathname; 
    var html = route(handle, pathname); 
    response.writeHead(200, {"Content-Type": "text/plain"}); 
    response.write(html); 
    response.end(); 
  } 
  http.createServer(onRequest).listen(8088); 
} 
exports.start = start;
// 入口主模块 index.js	
var server = require("./server"); 
var router = require("./router"); 
var requestHandlers = require("./requestHandlers"); 
var handle = {} 
handle["/listCategory"] = requestHandlers.listCategory; 
handle["/listProduct"] = requestHandlers.listProduct; 
server.start(router.route, handle); 
```

 与以往启动使用 server.js不同，带路由功能，一般都会通过 index.js 启动。 通过如下方式启动服务器`node index.js`，然后访问`http://127.0.0.1:8088/listCategory`。整体思路如下：

- index.js 调用了 server.start 函数，并且传递了 router.js 里route 函数和 handle 数组作为参数 	
- serverl.js 通过了8088端口启动了服务， 然后用 onRequest 函数来处理业务。 在 onRequest 中，首先获取访问路径 pathname。然后调用 router.js 的 route 函数，并把 pathname 和 handle 数组传递进去  
- 在router.js 中，通过 pathname 为下标获调用真正的业务函数，并把业务函数的返回值返回出去 。 如果找不到，比如访问`/listUser`这个路径就没有在 handle 数组中找到对应，那么就会返回 `listUser is not defined.` 
- 当访问地址是`/listCategory`的时候， 真正的业务函数 requestHandlers.js 中的 listCategory() 就会被调用，并返回业务 Html 代码`: "a lots of categorys".` 

#### 读写文件

 在 src 目录下 新建 how2j.html 文件，并在其中敲入`hello from how2j`。 重启后访问测试地址观察效果  `http://127.0.0.1:8088/readFile`和 `http://127.0.0.1:8088/writeFile`

```js
 // requestHandlers.js 
var fs = require("fs");			// 引入文件模块
function readFile(){
    var html = fs.readFileSync('how2j.html');
    return html;			// 输出 hello from how2j
}
function writeFile(){
    fs.writeFile('how2java.html', 'hello from how2java'); // 致创建文件 how2java.html, 并且向其中写入文字
    return "write successful";
}
exports.readFile = readFile; 
exports.writeFile = writeFile; 
// index.js
handle["/readFile"] = requestHandlers.readFile; 
handle["/writeFile"] = requestHandlers.writeFile; 
```

### npm 和 cnpm

 npm 是用来下载别人的模块和发布自己的模块用的工具，伴随着 node 的安装， npm 是自动安装的。  

```js
cd E:\project\nodejs\src			// 首先切换到项目目录下
npm install how2java			// 安装模块库，成功后会出现 node_modules/how2java 目录
npm -v			// 查看当前 npm 的版本

// 测试 test.js
var how2java = require("how2java"); 
how2java.hello();
// 新建目录和文件 e:\project\how2java a.js
function hello(){
  console.log("hello from how2java");
}
exports.hello=hello;
```

#### 发布模块

所有 npm 都是发布在 https://www.npmjs.com/ 上面的，所以在发布之前，需要到 npmjs 上去注册一个账号，才有权限发布自己定义模块

```
npm init			# 新建 package.json（用 npm 命令或手动）
/* 内容如下
{
  "name": "how2java",
  "version": "1.0.3",
  "description": "npm of how2java",
  "main": "a.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [
    "how2java"
  ],
  "author": "how2j",
  "license": "ISC"
} */
npm adduser			# 先登陆账号
npm publish			# 发布模块
```

npm 命令用于从国外的服务器上下载别人做好的模块，因为是在国外的服务器，有的时候网速会很受影响，其结果就是导致下载会非常卡顿。所以这个时候就会用到 cnpm了。这里的 c 是 copy 的意思，即复制 npm 上面的库。把 npm 上面的库复制到 国内的服务器上，当需要用的时候，使用 cnpm 命令获取，就会快很多了

```
npm install -g cnpm --registry=https://registry.npm.taobao.org         # 安装 cnpm
cnpm -v         # 检查当前的版本
cnpm install how2java         # 安装 how2java
```

其中的 -g 是 -global 的意思，即全局安装，而不是安装在当前目录下。 一旦全局安装过了，项目就不需要在本地安装也可以使用了。cnpm 本质上是复制库，它只负责从源库定期复制国内库，所以不支持通过 cnpm publish 发布到复制库上。
要发布，还是要通过 npm 发布到源库，然后耐心等待复制库同步

### mysql

首先准备数据库

```mysql
create database nodejs
use nodejs;
CREATE TABLE category_ (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(30),
  PRIMARY KEY (id)
) DEFAULT CHARSET=UTF8;
insert into category_ values(null,"category1");
insert into category_ values(null,"category2");
insert into category_ values(null,"category3");
insert into category_ values(null,"category4");
insert into category_ values(null,"category5");
```

查询数据库中的数据

```js
// e:/project/nodejs/db.js
var mysql = require("mysql");
var connection;
function openConnection(){			// 连接数据库	
    connection = mysql.createConnection({
          host     : "127.0.0.1",
          user     : "root",
          password : "admin",
          database : "nodejs"
        });
    connection.connect();
}
function closeConnection(){			// 关闭连接
    connection.end();  
}
function showAll(){			// 查询所有
    openConnection();
    var  sql = "SELECT * FROM category_ order by id asc";
    connection.query(sql,function (err, results) {
        if(err){
            console.log("[SELECT ERROR] - ",err.message);
            return;
        }
        if(results)
        {
            for(var i = 0; i < results.length; i++)
            {
                console.log("%d\t%s", results[i].id, results[i].name);
            }
        }  
    });
    closeConnection();     
}
function add(name){			// 增加
    openConnection();
    var params = [null,name];  
    var  sql = "insert into category_ values (?,?)";
    connection.query(sql,params,function (err, result) {
        if(err){
         console.log("[INSERT ERROR] - ",err.message);
         return;
        }       
       console.log("insert success, the generated id is:",result.insertId);       
    });
    closeConnection(); 
}
function remove(id){			// 删除
    openConnection();
    var params = [id]; 
    var  sql = "delete from category_ where id = ?";
    connection.query(sql,params,function (err, result) {
        if(err){
         console.log("[REMOVE ERROR] - ",err.message);
         return;
        }       
       console.log("remove id=%d success ",id);       
    });
    closeConnection(); 
}
function get(id){			// 获取
    openConnection();
    var params = [id]; 
    var  sql = "select * from category_ where id = ?";
    connection.query(sql,params,function (err, result) {
        if(err){
         console.log("[GET ERROR] - ",err.message);
         return;
        }       
        if(result.length !=0){
            var category = {id:result[0].id,name:result[0].name};
            console.log("get category:"+ JSON.stringify(result))
        }
        else{
            console.log("not found with id :" + id);
        }
    });
    closeConnection(); 
}
function update(id,name){			// 更新
    openConnection();
    var params = [name,id];
    var sql = "update category_ set name = ? where id = ?";
    connection.query(sql,params,function (err, result) {
        if(err){
         console.log("[UPDATE ERROR] - ",err.message);
         return;
        }       
         
        console.log("update success"+result.affectedRows);
 
    });
    closeConnection(); 
}
// app.js
var db = require("./db");
db.showAll();
db.add("category test");
db.remove(1);
db.get(2);

npm install mysql --save			// 安装模块
node app.js			// 运行测试
```

### EXPRESS 框架

 Express 是一个方便开发者的 web 框架，可以让开发者可以方便地处理路由，Cookie, 静态文件，上传文件， RESTFULL 风格等等常见操作 

```
cd e:\project\nodejs
npm init			# 然后一直回车
npm install express --save			# 安装 express 框架
```

 --save 的意思是，创建好之后，会修改 package.json 文件，表示当前项目要依赖 express 

```js
// app.js
var express = require('express');
var app = express();			// 创建 express对象
app.get('/', function (req, res) {			// 分别对/路径和/abc路径进行路由
   res.send('Hello from express');
}); 
app.get('/abc', function (req, res) {
       res.send('abc page from express');
}); 
var server = app.listen(8088);
```

分别访问`http://127.0.0.1:808 `和`http://127.0.0.1:8088/abc` 观察 app.js 中的路由效果 ?

#### 访问 静态文件

 默认情况下， nodejs 是不提供静态文件访问的，即在工作目录下有一个 test.html，也无法直接通过如下地址直接访问 

 `http://127.0.0.1:8088/test.html `

准备静态文件

`e:/project/nodejs/public/test.html`

```html
// public/est.html
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="static/css/style.css" />
    </head>
    <body>
        <div class="content">
            Hello Express      
        </div>
    </body>
    <script src="static/js/how2j.js"></script> 
</html>
// public/static/css/style.css
div.content{
    border:1px solid gray;
    width:500px;
    margin:50px auto;
    color:skyblue;
    padding:20px;
}
// public/static/js/how2j.js
alert("hello from static/js/how2j.js");
```



```js
// app.js
var express = require('express');
var path = require('path');
var app = express();
app.use(express.static(path.join(__dirname, 'public'))); 			// 设置静态访问目录
app.listen(8088);
```

__dirname 是工作目录，path_join 用于关联父目录和子目录，express.static 指定静态目录的位置。测试地址`http://127.0.0.1:8088/test.htm `

#### 上传文件 

```
npm install express
npm install multer	
npm init
```

创建`public/upload.html`文件

```js
// public/upload.html 
<!DOCTYPE html> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<form action="uploadPhoto" method="post" enctype="multipart/form-data">
  上传图片 : <input type="file" name="image" accept="image/*" /> <br>
  <input type="submit" value="上传">
</form>
// app.js
var express = require('express');
var path = require('path');
var fs = require("fs");
var multer  = require('multer');
var app = express();
app.use(express.static(path.join(__dirname, 'public')));
// 上传之后放在工作目录下的 tmp 目录下。 上传的时候上传控件的 name 必须是 image
app.use(multer({ dest: path.join(__dirname, 'tmp') }).array('image'));
function getExtName(fileName){			//获取后缀名
    var index1=fileName.lastIndexOf(".");
    var index2=fileName.length;
    var extName=fileName.substring(index1+1,index2);
    return extName;
}
app.post('/uploadPhoto', function (req, res) {
   var extName = getExtName(req.files[0].originalname);			// 获取上传图片的后缀名
   var rundomNumber = Math.ceil(Math.random()*10000000);			// 随机数
   var randomFileName =  rundomNumber + "."+extName;			// 以随机数作为文件名
   var imgFolder = __dirname + "/public/img/";				// 创建图片目录
   if(!fs.exists(imgFolder))
       fs.mkdir(imgFolder);
   var imgFile = __dirname + "/public/img/" + randomFileName;			// 图片路径
   var uploadedTempFilePath = req.files[0].path;			// 上传临时文件的路径
   fs.readFile( uploadedTempFilePath, function (err, data) {			// 读取临时文件
        fs.writeFile(imgFile, data, function (err) {			// 读取成功之后，复制到图片路径
            // 写成功之后，返回img元素显示上传之后的图片
            res.writeHead(200, {'Content-Type': 'text/html'});
            res.end("<img src='img/"+randomFileName+"'/>");
       });
   });
})
var server = app.listen(8088);
```

 ceil() 返回的是大于或等于函数参数。测试页面`http://127.0.0.1:8088/upload.html`

## webpack

webpack 把各种各样的静态资源，打包成了一个 assets，这样浏览器加载起来就快多了。webpack 的运行，是需要依赖 node.js 的运行环境的。在 windows 里用 cnpm 方式安装 @1.13.2 版本是可以正常运行的

```
cd E:\project\webpack-demo			# 创建项目目录
cnpm install -g webpack@1.13.2			# 安装 webpack
webpack a.js bundle.js			# a.js 被打包到 bundle.js
```

打开 index.html ，即可看到引用 bunlde.js 之后的效果

```html
// 在项目目录下创建 a.js 
document.write("hello webpack");
<!-- index.html -->
<html>
    <head>
        <script src="bundle.js"></script>
    </head>
</html>
```

可以采用配置文件的方式，就不需要使用参数了，而是直接运行 webpack 命令，因为参数已经都放在 webpack.config.js 文件里面了

```
module.exports = {
  entry: './a.js',
  output: {
    filename: 'bundle.js'
  }
  devServer: {			# 可以修改端口（默认8080），然后重新运行
        port:8088
    }
};
```

### webpack-dev-server

webpack-dev-server 是一个微服务器，运行它也就启动了一个 web 服务器，可以方便地从服务器上打开这个 index.html 了。安装与 webpack 1.32.2 兼容的版本： webpack-dev-server@1.15.0

```
cnpm install -g webpack-dev-server@1.15.0
webpack-dev-server --open			
```

会自动打开与 http 协议关联的浏览器，并显示默认的 index.html 页面`http://localhost:8080/webpack-dev-server/`

webpack-dev-server 支持热更新，在 webpack.config.js 中的 entry 文件 ( a.js ) 发生了改变之后，会自动运行 webpack, 并且自动刷新页面，立即看到修改之后的效果。因为 webpack-dev-server 的热更新是基于 entry 入口的文件： a.js，即使html 和 css 更新了，也不会被监视到。但是要监视 html 和 css 的更新也是可以的，用 livereload

```
# webpack.config.js 文件
var webpack = require('webpack')
module.exports = {
    entry: './a.js',
    output: {
        filename: 'bundle.js'
    },
   plugins:[
        new webpack.HotModuleReplacementPlugin()
    ],
   devServer: {
        port:8088,
        inline:true,
        hot:true
    }
}
```

因为 webpack 模块是全局的，有的时候通过这种方式导入不能够被识别，需要进行一次链接`npm link webpack`，然后重新启动`webpack-dev-server --open`

### npm 启动方式

前面的方式，是直接运行 webpack-dev-server 的方式，测试地址`http://localhost:8088/`

```
npm init -y			# 进行 package.json 配置文件的初始化，-y 表示都同意
# 修改 package.json
{
  "name": "webpack-demo",
  "version": "1.0.0",
  "main": "a.js",
  "scripts": {
    "dev": "webpack-dev-server --open"			# 增加脚本
  },
  "keywords": [],
  "author": "",
  "license": "ISC",
  "dependencies": {
    "webpack": "^1.13.2"
  },
  "devDependencies": {},
  "description": ""
}
npm run dev			# 和单独运行的效果是一样的
```

### 多个入口文件

测试地址`http://localhost:8080/webpack-dev-server/`

```js
// 新增 b.js 
document.write("hello webpack from b.js<br>"); 	
// 修改配置文件
module.exports = {
    entry: {
        bundle1: './a.js',
        bundle2: './b.js'
    },
    output: {
        filename: '[name].js'
    },
    devServer: {
        port:8088
    }
}
// 修改 index.html
<html>
    <head>
        <script src="bundle1.js"></script>
        <script src="bundle2.js"></script>       
    </head>
</html>

npm run dev

/* 运行结果
hello webpack from a.js
hello webpack from b.js */
```

### BABEL-LOADER

ES6 的全称是 ECMAScript 6.0，是下一代的 javascript 语言标准。因为当前 javascript 标准 (ES5) 对于开发大型的 javascritp 应用支持力度不足够

```js
// ES5 方式
var name = "ES5"
document.write(`hello `+ES5)
// ES6 方式
const name = 'ES6'
document.write(`hello ${name}`)
```

babel 安装

运行 webpack, 会把 a.js 转换为 bundle.js，打开 bundle.js 翻到最后几行，可以看到已经是普通的 javascript 语句了

```
# babel 安装
npm install --save-dev babel-loader@6.2.7 babel-core@6.18.0 babel-preset-latest@6.24.1
# 修改 package.config.js
module.exports = {
    entry: './a.js',
    output: {
        filename: 'bundle.js'
    },
    devServer: {
        port:8088
    },
    module: {
        loaders: [
            {
                test: /\.js$/,			# 仅转换 .js 文件
                loader: 'babel',			# 使用babel loader进行 es6 转换
                query:{
                    presets: ['latest']			# 用最新的语法规则进行
                }
            }
        ]
    }
}

webpack
npm run dev
```

### CSS-LOADER

用 css-loader 和 style-loader 把 css 文件作为一个模块打包到 bundle.js 文件。运行命令，在浏览器可以看到背景都变成黑色了

```
# style.css
body {
    background-color: blue;
}
# 修改 package.config.js
...
        loaders: [
            ...
            },
            {
                test:/\.css/,
                loader:'style-loader!css-loader'			# 增加 style-loader 和 css-loader
            }
...
# a.js
require("./style.css")
const name = 'ES6'
document.write(`hello ${name}`)

npm run dev
```

其它 HtmlWebpackPlugin, ExtractTextPlugin, Image-loader

## chartjs

chartjs 就是可以画各种图表的一款前端工具

```html
<script src="http://how2j.cn/study/js/chartjs/2.8.0/chart.min.js"></script>
<div style="width:400px;margin:0px auto">
    <canvas id="myChart" ></canvas>			<!-- canvas 就是画布,作为各种图表的基础 -->
</div>
<script>
var ctx = document.getElementById('myChart').getContext('2d');	// 获取 myChart 对象的 2d 上下文
var myChart = new Chart(ctx, {			// 曲线图
    type: 'line',			// 表示是一个线型图表，柱状图就修改成 'bar' 
    data: {
        labels: ['红', '蓝', '黄', '绿', '紫', '橙'],			// 表示数据下方的文字
        datasets: [{			// 表示数据集合，一个数据只有一条线
            label: '示例',			// 这组数据的名称
            data: [12, 19, 3, 5, 2, 3],			// 具体数据
            borderColor:'blue',			// 线条颜色
            borderWidth: 1,			// 线条宽度
            fill: false,			// 不进行填充
            yAxisID: 'y-axis-1',
        },
        {			// 多曲线
            label: '示例2',
            data: [182, 51, 133, 54, 105, 96],
            borderColor:'red',
            backgroundColor:'pink',
            borderWidth: 1,
            fill: false,
            yAxisID: 'y-axis-2',
            borderDash: [5, 5],			// 表示虚线，[5，5] 分别表示虚线的长度和距离
        },
        ]
    },
    options: {			// 表示鼠标移动到图标的时候的提示信息
        tooltips: {
            // 出现位置中间
            intersect: false,			// 表示鼠标不放在数据点上时，也会显示提示信息			
            mode: 'index'			// 显示模式
            // 交叉点
            intersect: true,
            // 非交叉点
            mode: 'nearest',
		   intersect: false,
            callbacks: {			// 通过回调函数可以自定义提示文字里的显示信息
                label: function(tooltipItem, myData) {
                    var label = myData.datasets[tooltipItem.datasetIndex].label || '';
                    if (label) {
                        label += '的数值是: ';
                    }
                    label += parseFloat(tooltipItem.value).toFixed(2); // 四舍五入为指定小数位数
                    return label;
                }
            },
        },
        scales:{			// 多轴
            yAxes: [{
                type: 'linear',
                display: true,
                position: 'left',
                id: 'y-axis-1',
            }, {
                type: 'linear',
                display: true,
                position: 'right',
                id: 'y-axis-2',
                gridLines: {
                    drawOnChartArea: false
                }
            }],      
        }
    }
});
var myChart = new Chart(ctx, {			// 柱状图
    type: 'bar',			// 垂直，horizontalBar 水平
    data: {
        labels: ['红', '蓝', '黄', '绿', '紫', '橙'],
        datasets: [
       {
            label: '示例',
            data: [12, 19, 3, 5, 0, 3],
            borderColor:'blue',
            backgroundColor:'skyBlue',
            borderWidth: 1,
            yAxisID: 'y-axis-1',
        }
        {			// 多条数据，因为红变色的比蓝色的落差大，所以蓝的会变得很小
            label: '示例2',
            data: [182, 51, 133, 54, 105, 96],
            borderColor:'red',
            backgroundColor:'pink',
            borderWidth: 1,
            yAxisID: 'y-axis-2',
        },       
        ]
    },
    options:{			// 左边 y 轴显示蓝色的，右边 y 轴显示红色的
        scales:{
            yAxes: [{
                type: 'linear',
                display: true,
                position: 'left',
                id: 'y-axis-1',
            }, {
                type: 'linear',
                display: true,
                position: 'right',
                id: 'y-axis-2',
                gridLines: {
                    drawOnChartArea: false
                }
            }],       
        }
    }
});
var myChart = new Chart(ctx, {			// 饼状图
    type: 'pie',			// 饼状图
    type: 'doughnut',			// 甜甜圈			
    data: {
        labels: ['红', '蓝', '黄', '绿', '紫', '橙'],
        datasets: [{
            label: '示例',
            data: [12, 19, 3, 5, 0, 3],
            borderColor:'lightGray',
            backgroundColor:['pink','skyblue','LightYellow','LawnGreen','MediumPurple','orange'],
            borderWidth: 1
        }]
    }
});
</script>
```

![捕获](E:\我的电脑\图片\学习\前端\捕获.PNG)

chartjs 官方使用手册：https://www.chartjs.org/>