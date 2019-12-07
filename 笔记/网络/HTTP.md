## HTTP协议学习

### 一、HTTP协议

HTTP协议（Hyper Text Transfer Protocol，超文本传输协议）是因特网上应用最为广泛的一种网络传输协议，所有的WWW 文件都必须遵守这个标准，基于 TCP/IP 通信协议来传递数据（HTML 文件, 图片文件, 查询结果等）

MIME(Multipurpose Internet Mail Extensions)多用途互联网邮件扩展类型

HTTP三个特点

1. 无连接：无连接的含义是限制每次连接只处理一个请求。服务器处理完客户的请求，并收到客户的应答后，即断开连接。采用这种方式可以节省传输时间
2. 媒体独立：这意味着，只要客户端和服务器知道如何处理的数据内容，任何类型的数据都可以通过HTTP发送。客户端以及服务器指定使用适合的 MIME-type 内容类型
3. 无状态：HTTP协议是无状态协议。无状态是指协议对于事务处理没有记忆能力。缺少状态意味着如果后续处理需要前面的信息，则它必须重传，这样可能导致每次连接传送的数据量增大。另一方面，在服务器不需要先前信息时它的应答就较快

HTTP使用统一资源标识符（Uniform Resource Identifiers, URI）来传输数据和建立连接，URI由两个主要的子集URL（Uniform Resource Locator）和URN（Uniform Resource Name）组成。一旦建立连接后，数据消息就通过类似Internet 邮件所使用的格式[ RFC5322 ]和多用途 Internet 邮件扩展（MIME）[RFC2045]来传送

#### 客户端请求消息

![2012072810301161](https://massionter-images-1258860804.cos.ap-guangzhou.myqcloud.com/zcayo/2012072810301161.png)

请求头部

- Host：接受请求的服务器地址，可以是IP或者是域名
- User-Agent：发送请求的应用名称
- Connection：指定与连接相关的属性，例如（Keep_Alive，长连接）
- Accept-Charset：通知服务器端可以发送的编码格式
- Accept-Encoding：通知服务器端可以发送的数据压缩格式
- Accept-Language：通知服务器端可以发送的语言

#### 服务器响应消息

![httpmessage](https://massionter-images-1258860804.cos.ap-guangzhou.myqcloud.com/zcayo/httpmessage.jpg)

#### HTTP 请求方法

| 序号 | 方法    |                             描述                             |
| :--- | :------ | :----------------------------------------------------------: |
| 1    | GET     |              请求指定的页面信息，并返回实体主体              |
| 2    | HEAD    | 类似于 GET 请求，只不过返回的响应中没有具体的内容，用于获取报头 |
| 3    | POST    | 向指定资源提交数据进行处理请求（例如提交表单或者上传文件）。数据被包含在请求体中。POST 请求可能会导致新的资源的建立和/或已有资源的修改 |
| 4    | PUT     |        从客户端向服务器传送的数据取代指定的文档的内容        |
| 5    | DELETE  |                   请求服务器删除指定的页面                   |
| 6    | CONNECT |   HTTP/1.1 协议中预留给能够将连接改为管道方式的代理服务器    |
| 7    | OPTIONS |                  允许客户端查看服务器的性能                  |
| 8    | TRACE   |           回显服务器收到的请求，主要用于测试或诊断           |
| 9    | PATCH   |       是对 PUT 方法的补充，用来对已知资源进行局部更新        |

Java的GZIPOutputStream 可以很方便地进行 gzip 压缩，查看 Accept-Encoding 头：request.getHeader("Accept-Encoding")

#### HTTP 响应头信息

| 应答头           |                             说明                             |
| :--------------- | :----------------------------------------------------------: |
| Allow            |           服务器支持哪些请求方法（如GET、POST等）            |
| Content-Encoding |                   文档的编码（Encode）方法                   |
| Content-Length   |                         表示内容长度                         |
| Content-Type     | 表示后面的文档属于什么MIME类型。HttpServletResponse.setContentType |
| Date             |                 当前的GMT时间。setDateHeader                 |
| Expires          |                   什么时候认为文档已经过期                   |
| Last-Modified    |                      文档的最后改动时间                      |
| Location         | 表示客户应当到哪里去提取文档。HttpServletResponse.sendRedirect方法，状态代码为302。 |
| Refresh          | 表示浏览器应该在多少时间之后刷新文档，setHeader("Refresh", "5; URL=http://host/path")，HTML页面HEAD区的＜META HTTP-EQUIV="Refresh" CONTENT="5;URL=http://host/path"＞ |
| Server           |                          服务器名字                          |
| Set-Cookie       |    设置和页面关联的Cookie。HttpServletResponse.addCookie     |
| WWW-Authenticate |      客户应该在Authorization头中提供什么类型的授权信息       |

#### HTTP状态码分类

| 分类 |                    分类描述                    |
| :--- | :--------------------------------------------: |
| 1**  |  信息，服务器收到请求，需要请求者继续执行操作  |
| 2**  |           成功，操作被成功接收并处理           |
| 3**  |       重定向，需要进一步的操作以完成请求       |
| 4**  |   客户端错误，请求包含语法错误或无法完成请求   |
| 5**  | 服务器错误，服务器在处理请求的过程中发生了错误 |

常见的HTTP状态码

- 200 - 请求成功；
- 301 - 资源（网页等）被永久转移到其它URL；302 - 跳转，重定向
- 403 - 服务器拒绝提供服务；404 - 请求的资源（网页等）不存在；
- 500 - 内部服务器错误

#### HTTP和HTTPS的区别

- http协议以明文方式进行传递，使用HTTP协议传输隐私信息非常不安全，HTTPS协议是由SSL（Secure Sockets Layer）+HTTP协议构建的可进行加密传输、身份认证的网络协议，比http协议安全
- http和https使用的是完全不同的连接方式，用的端口也不一样，HTTP的默认端口为80，HTTPS的默认端口为443

#### HTTPS工作原理

![20181204122336858](https://massionter-images-1258860804.cos.ap-guangzhou.myqcloud.com/zcayo/20181204122336858.png)

### 二、TCP/IP协议

TCP/IP 指传输控制协议/网际协议（*T*ransmission *C*ontrol *P*rotocol / *I*nternet *P*rotocol），是供已连接因特网的计算机进行通信的通信协议，定义了电子设备（比如计算机）如何连入因特网，以及数据如何在它们之间传输的标准

在 TCP/IP 中包含一系列用于处理数据通信的协议：

- TCP (传输控制协议) - 应用程序之间通信
- UDP (用户数据报协议) - 应用程序之间的简单通信
- IP (网际协议) - 计算机之间的通信
- ICMP (因特网消息控制协议) - 针对错误和状态
- DHCP (动态主机配置协议) - 针对动态寻址

TCP 负责应用软件（比如您的浏览器）和网络软件之间的通信，负责将数据分割并装入 IP 包，然后在它们到达的时候将它们重组；IP 负责计算机之间的通信，负责将包发送至接受者

IP 是无连接的通信协议，它不会占用两个正在通信的计算机之间的通信线路。

![捕获2](https://massionter-images-1258860804.cos.ap-guangzhou.myqcloud.com/zcayo/%E6%8D%95%E8%8E%B72.PNG)

![1569143670747](https://massionter-images-1258860804.cos.ap-guangzhou.myqcloud.com/zcayo/1569143670747.png)

![1569143897027](https://massionter-images-1258860804.cos.ap-guangzhou.myqcloud.com/zcayo/1569143897027.png)

IPv6 （Internet Protocol Version 6），IPv6 地址的 128 位（16 个字节）写成8个十六进制的无符号整数，每个整数用 4 个十六进制位表示，这些数之间用冒号（:）分开，例如

```
686E：8C64：FFFF：FFFF：0：1180：96A：FFFF
```

### 三、其它协议

邮件程序使用 SMTP 来发送邮件，使用 POP 从邮件服务器下载邮件，使用 IMAP 连接到邮件服务器

- SMTP - 简单邮件传输协议：用于传输电子邮件，负责把邮件发送到另一台计算机。SMTP 可以传送纯文本，无法传输诸如图片、声音或者电影之类的二进制数据。但是可以使用 MIME 协议通过 TCP/IP 网络来发送二进制数据。MIME 协议会将二进制数据转换为纯文本

- POP - 邮局协议：POP 协议被邮件程序用来取回邮件服务器上面的邮件

- IMAP - 因特网消息访问协议

  IMAP 协议与 POP 协议之间的主要差异是：如果 IMAP 连上了邮件服务器，它不会自动地将邮件下载到邮件程序之中。IMAP 使您有能力在下载邮件之前先通过邮件服务器端查看他们

- SSL - 安全套接字层（Secure Sockets Layer）：用于为安全数据传输加密数据

- FTP - 文件传输协议：负责计算机之间的文件传输

- ARP - 地址解析协议：用于通过 IP 来查找基于 IP 地址的计算机网卡的硬件地址

- RARP - 反向地址转换协议：用于通过 IP 查找基于硬件地址的计算机网卡的 IP 地址

- DHCP - 动态主机配置协议：用于向网络中的计算机分配动态 IP 地址