### 简介

Fiddler（中文名称：小提琴）是一个 HTTP 的调试代理，以代理服务器的方式，监听系统的 HTTP 网络数据流动。Fiddler 也可以让你检查所有的 HTTP 通讯，设置断点，以及 Fiddle 所有的“进出”的数据（用来抓包）。Fiddler还包含一个简单却功能强大的基于 JScript .NET 事件脚本子系统，它可以支持众多的 HTTP 调试任务。Fiddler 官方网站提供了大量的帮助文档和视频教程，这是学习 Fiddler 的最好资料

- Fiddler 官方网站`http://www.telerik.com/fiddler`
- Fiddler 官方文档`https://docs.telerik.com/fiddler/configure-fiddler/tasks/configurefiddler`
- Fiddler 官方视频`https://www.youtube.com/playlist?list=PLvmaC-XMqeBbw72l2G7FG7CntDTErjbHc`
- Fiddler 官方插件`http://www.telerik.com/fiddler/add-ons`

### 工作原理

Fiddler 是以代理 WEB 服务器的形式工作的，浏览器与服务器之间通过建立 TCP 连接以 HTTP 协议进行通信，浏览器默认通过自己发送 HTTP 请求到服务器，它使用代理地址`127.0.0.1`，端口 8888。当 Fiddler 开启会自动设置代理， 退出的时候它会自动注销代理，这样就不会影响别的程序。不过如果 Fiddler 非正常退出，这时候因为 Fiddler 没有自动注销，会造成网页无法访问，解决的办法是重新启动下Fiddler。只要是支持 HTTP 代理服务器的任意程序都可以被 Fiddler 嗅探到，Fiddler 的运行机制其实就是本机上监听 8888 端口的 HTTP 代理。代理服务器的知识`https://blog.csdn.net/abcnull/article/details/84787954`

Fiddler 的代理模式有流模式和缓冲模式，其中流模式是一种实时通信模式，请求之后实时的返回，更接近浏览器真实行为。另外一种是缓冲模式，等所有请求到了再一起返回，可以来控制最后的服务器响应，实际中我们可以根据具体场景选用不同代理模式，fiddler 默认缓冲模式，在工具栏的 Stream 可以切换

### 软件面板

主要讲解 fiddler 界面上的 7 大板块，从菜单栏→工具栏→底端状态栏→命令行控制台→ session 栏→ request 栏→ response 栏来依次讲解

#### 菜单栏

File

- Capture Traffic：默认勾选，勾选此项才可抓包，与点击左下角状态栏的 Capture 效果一样；
- New Viewer：开启一个新的 fiddler 的 viewer，注意这里不是再开一个新的 fiddler，而是开一个新的 fiddler 的 viewer；
- Load Archive…：用于重新加载之前捕获到的 SAZ 文件格式保存的流量，Session Archive Zip 文件用于保存 http 请求信息；
- Recent Archives：查看最近之前捕获到的 SAZ 文件格式保存的流量；
- Import Sessions…：从目标文件夹及其子文件夹加载所有 SAZ 文件、缓存和重用密码。支持导入从其他工具获得的流量；
- Export sessions：支持用 fiddler 把捕捉到的 sesison 用多种方式保存，CURL 脚本由 CURL 回放

Edit

- Copy：用来拷贝请求的相关信息。用于复制在 web session 列表中选中的 session 信息，包括 just URL（把选中的 session 的 URL 复制到剪切板中）、this column（拷贝菜单所在列的文本）、terse summary（选中 session 的简要说明复制到剪切板里）、header only （把 session 请求头复制到剪切板里）、session（把整个的 session 列表都复制到剪切板里）、full summary（把列表中显示的所有 session 信息复制到剪切板里）这些功能；
- Undelete：恢复之前删除的 session，Paste as Sessions：把剪切板里的 sesisongs 复制到 web sessions 中，把以前的会话粘贴回来；
- Mark：自定义不同 session 的显示颜色；
- Unlock for Editing：把锁定的 session 进行解锁，可以进行编辑，默认情况下是不可进行编辑的，默认可以看到选定的 session 前是“锁”的图形 ，点击此按钮后变成可编辑按钮；
- Find Sessions…：搜索 session

Rules

- Hide Image Requests：可以隐藏图片请求，让图片类的 session 不在 session 框中显示出来；
- Hide CONNECTs：可以隐藏 CONNECT 方法的请求，让这类 session 不在 session 框中显示出来；
- Automatic Breakpoints：自动断点，控制是否自动在 Before Request 或 After Request 处断点，来修改请求或响应的内容；
- Customize Rules…：来打开 fiddler script 工具，调取脚本操作，多用于网络修改，其他自定义时使用；
- Require proxy authentication：若选中此项，则所有未提交 Require proxy authentication 的请求头的请求会返回 HTTP/407 响应，要求客户安装证书；
- Apply GZIP Encoding：请求 GZIP 编码，若选中此项，则只要请求包含了 gzip 标识的 Accept-Encoding 请求头就会对除了图片以外的所有相应使用 GZIP HTTP 进行压缩；
- Remove All Encoding：若选中此项，会删除所有请求相应的 http 内容编码和传输编码；
- Hide 304s：在session框中隐藏所有的 304 的 session；
- Request Japanese Content：把所有的 Accept-Encoding 请求头设置替换成 ja 标示，标示客户端希望以日语的形式发送；
- Automatically Authenticate：自动进行身份验证；
- User-Agents：选择相应的用户代理模式，默认是选择 disabled。ua 是头域的组成部分，简单来说就是你向访问的网站提供你所用的浏览器的类型等信息，ua 字符串在每次浏览器 http 请求时被发送到服务器端；
- Performance：此项提供影响 web 性能的简单选项。若选中了 simulate modem speeds，它会设置所有后续 session 的 flag，把 request-trickle-delay 标志设置为 300，所有上传数据延迟 300ms/kb，若把 response-trickle-delay 标志位设为 150，会使所有下载数据延迟 150ms/kb。若选中了 disable caching，将会删除所有 If-None-Match 和 If-Modified-Since 请求头，并添加 Pragma:no-cache 请求头，选中该项还会删除响应中的所有 Expires 头，并把 Cache-Control 响应头设置成 no-cache，该项无法阻止浏览器重用在所用该选项之前所缓存的响应，在选中该选项后，为了得到最佳结果，最好是清空浏览器中缓存。若选择 Catch Always Fresh 会自动响应所有包含 http/304 响应的有条件的 http 请求，表示客户端缓存是最新的，当访问的站点无法正确的设置缓存失效日期时，该选项可以极大的提高性能

Tools

- Options…：打开 Options 窗口，是 fiddler 抓包的一些设置项，包括对抓取接口是 http 还是 https 的设置，获取证书，设置代理端口号等功能；
- WinINET Options…：打开 IE 浏览器的 options 进行设置；
- Clear WinINET Catch：清空 IE 和其他应用中所使用的 WinINET 的缓存文件；
- Clear WinINET Cookies：清空 IE 和其他应用中所使用的 WinINET 的 Cookies 文件；
- TextWizard：文本向导工具，是一个非常好用的可以轻松将 text 文本 encode 和 decode 的小工具；
- New Session Clipboard…：打开一个新的 session 剪贴板，可以把侧边栏中的 session 拖到这个剪贴板中具体来查看；
- HOSTS：主机重定向工具。若在其中勾选 Enable 框，然后在下面加入 host 配置，点击保存之后，这个配置并不会修改到本地 hosts 中，取消勾选就会失效。若点击 Import Windows Hosts File 将会导入本地的 host 文件内容；
- Reset Script：重置脚本，Sandbox：fiddler sanbox 官方文档；
- View IE Cache：打开本地文件系统，查看 ie 缓存；
- Win8 Loopback Exemptions：Win8 回环豁免工具，这个时候会弹出一个“AppContainer 回环豁免实用程序”的窗口，若要将所有的程序使用豁免，点击“全部免除”，然后点击“保存更改”

view

- Show Toolbar：显示工具栏，默认是勾选的；
- Default Layout：默认 layout，session 在左，请求和响应在右边的上下处；
- Stacked Layout：session 在上，请求在下方；
- Wide layout：session 在上，请求和响应在下方的左右处；
- Tabs：打开标签页面，其中有三个标签可以打开，分别是 Preferences（fiddler 偏好属性），AutoSave（fiddler 自动保存的设置），APITest（api 的测试）；
- Statistics：查看一个请求的统计数据，Inspectors：嗅探，用来查看会话的内容，上面是请求，下面是响应；
- Composer：设计构造，在 Composer 中进行请求的修改，可以把 session 框中的数据先清除，然后点击 Composer 中的 Excute 按钮来发送请求，请求出现在 session 框中；
- Minimize To Tray：最小化托盘，Stay On Top：保持置顶，Squish Session List：挤压 session 框；
- AutoScroll Session List：自动滚动会话列表，默认是勾选此项的，勾选此项后，session 框中的每出现新的 session，session 框中就会不断向下滚动，若不勾选此项，就很方便具体某一个 session 的定位，即使出现了新的 session 也不会自动向下滚动

help

- Get Fiddler Book…：fiddler book 的网页；
- Discussions：fiddler 的讨论网页，这个需要魔法上网；
- Http Preferences：进入 http preferences 相关网站；
- Troubleshoot…：会捕获所有请求，对于哪些被过滤的请求用删除线表示出来并给出原因，使用时候会打开一个网页；
- Get Priority Support…：打开网页购买 fiddler 的优先级服务

#### 工具栏

- WinConfig：windows 使用了一种叫做“AppContainer”的隔离技术，使得一些流量无法正常捕获，在 fiddler 中点击 WinConfig 按钮可以解除这个诅咒，这个与菜单栏 Tools→Win8 Loopback Exemptions 功能是一致的；
- ![comment](https://img-blog.csdnimg.cn/20190403170134105.png)按钮来给选定的 session 添加注释，Replay 重发按钮，选定请求重发按钮；
- Remove 移除按钮，其中有 Remove all 移除所有，Images，CONNECTs，Non-200s，Non-Browser，Complete & Unmarked，Duplicate response bodies，这些都是移除 session 中的这些状态的选项；
- Go 重跑 sessions，依据断点暂停。Stream 流模式是一种实时通信模式，请求之后实时的返回，更接近浏览器真实行为，但 fiddler 默认是缓冲模式而不是流模式；
- Decode 解码，这里可以将 session 中乱码进行解码方便查看；
- All sessions：这里可以保持 session 框中存在多少个 sessions；
- Any Process 点击此按钮并且拖动到你想要捕获的浏览器从而实现只捕获某个浏览器的请求；
- Find 查询，Save 保存按钮，截图，计时器：手动点击运行，手动点击暂停终止；
- Browser 打开浏览器来查看响应数据，Clear Cache 清除 WinINET 的缓存，按住 CTRL 键点击可以清除已经存在的 cookies；
- TextWizard 此工具可以将某一编码过的或者未编码过的字串拿到此处解码和编码，在菜单栏中的 Tools 中也有此项可以打开；
- Tearoff 此功能用来将右边栏里的请求和响应部分给单独拆成一个新窗口，方便视察，关掉会恢复默认；
- MSDN Search… 在网页版的微软开发中去搜索，online 鼠标悬停显示本机的一些 ip 信息

#### 底端状态栏

- capturing 与菜单栏中 File→Capture Traffic 效果是一致的，默认底端状态栏此处是有 Caturing，有它才表示 fiddler 捕获请求；
- All Processes：这里有 All Processes，Web Browsers，Non-Browser，Hide All 几个选项，这个几个选项顾名思义，但要注意的是这些不是筛选当前 session 框中的 session，而是选中需要筛选的状态之后，后面的请求会按照此状态来筛选；
- 数字/数字：第一个数字表示这一个请求，第二个数字表示 session 框中共有多少 session；
- 底端自带命令行控制台，有许多自己的快捷键和命令来方便快速的操作 fiddler，拿到自己想要的 session

#### Session 栏

当右键点击 session 框中的列时，可以发现有5个功能，分别是仅搜索该列；标记列中的相同项并将相同项背景滤为黄色；隐藏该列；确保所有的列都是可视的；定制列，可以增加其他的列名，并且还可以改变列名

- #：这一列是 http request 的顺序，从 1 开始，有多种图标；
- Result：这一列返回的是响应码，Protocol：这里是协议，一般是显示 http；
- Host：host 地址，URL：也就是请求接口，知道 protocol+host+URL 可以发送一个请求；
- Body：这一列显示的是响应返回的字节数，Caching：请求的缓存过期时间或者缓存控制值；
- Content-Type：返回的数据类型，Process：这一列标明了进程名和进程 PID；
- Comments：这一列是 session 的注释，可以通过工具栏的![comment](https://img-blog.csdnimg.cn/20190403170134105.png)按钮来添加注释
- Custom：这一列允许用户通过 fiddlerscript 脚本设置自定义值

![](https://img-blog.csdnimg.cn/20190403165721500.png)

![](https://img-blog.csdnimg.cn/2019040316573342.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2FiY251bGw=,size_16,color_FFFFFF,t_70)

在 session 一栏中右键点击会出现

- Decode Selected Sessions：这里 Decode Selected Sessions 是将选中的 session 进行解码，这样在响应中出现的乱码也可以成功被解码；
- AutoScroll Session List：AutoScroll Session List 是默认勾选，session 滚动条自动滑动；
- Filter Now：过滤当前 session，Comment…：添加评论注释；
- Mark：将选中的 session 标记成不同的颜色，Replay：请求重发的相关功能；
- Select：选择需要的 session，Compare：选中两个 session 进行比较；
- COMETPeek：COMETPeek 命令会保留正在执行的响应的“快照”，在响应完成前就可以查看部分内容。当 web 应用采用 COMET 模式以流式向客户端返回数据时，可以使用该命令。由于“流式”的含义就是永不结束，直有当服务端停止连接后，Fiddler 才会返回响应；
- Abort Session 终止当前正在执行的请求；
- Clone Response：当 session 列表选中两个 session，并且其中一个 session 在断点处终止，而另一个 session 已经运行完成时才有用，该命令会把已完成的 session 响应拷贝给暂停运行的 session；
- Unlock For Editing：使 session 的请求和响应都可以在 Inspector 中编辑，这个还是蛮有用的；
- Inspect in New Window…：在一个新的窗口中来查看请求信息；
- Properties…：session 的属性窗口，显示当前 session 的属性

#### Request 栏

- Inspector：这里是查看某个 session 的请求和响应，请求的话又可分为 10 个小的标签页。并且右键点击这 10 个标签页可以查看 Inspector 的属性还有复制为图片（copy as image）和隐藏标签页的功能。包括 request 和 response 

  request：

  - Headers：这里是请求头中的信息，包括 cache、cookies 等信息，点击右边黄色的 Raw 可以以新窗口的形式来显示原生头信息，而 Header Definitions 可以查看 fiddler 官方的头信息的网页版帮助文档，可能需要魔法上网；
  - TextView：TextView 方式显示传送过去的请求体数据；
  - SyntaxView：SyntaxView 方式显示传送过去的请求体数据；
  - WebForms：网页表单方式显示传送过去的请求体数据；
  - HexView：十六进制视图的方式显示传过去的数据；
  - Auth：显示请求中的身份认证信息；
  - cookies：显示该请求的 cookies 信息，Raw：显示该原生的请求体；
  - JSON：json 显示请求，XML：xml 显示请求

  response：

  - Transformer：这里显示了响应体的字节数，其中的 Chunked Transfer-Encoding 和 HTTP Compression 是分块传输编码和 HTTP 压缩技术；
  - Headers：这里可以看到响应头部分，包括 http 的协议，返回状态码，连接情况等；
  - TextView：这里返回 TextView 形式的响应体信息；
  - SyntaxView：这里返回 SyntaxView 形式的响应体信息；
  - ImageView：如果是返回图片的话这里将有显示，并且左边会显示图片的信息；
  - HexView：这里会显示响应体的十六进制信息；
  - WebView：这里会用网页的形式来显示响应体的信息；
  - Auth：显示身份验证，Caching：显示缓存信息；
  - Cookies：显示 Cookies 信息，Raw：显示原生的响应信息；
  - JSON：响应体中的数据 json 显示，XML：响应体中的数据 XML 显示

- AutoResponder：重定向，本机代替服务器发送响应

- Composer：Composer 和 Inspector 都可以篡改数据，Inspector是篡改输入的数据，但是 Composer 却可以篡改 Cookies 中的数据，并通过 Execute 发送重新篡改后的请求，界面上的控件比较简单

- Fiddler Orchestra Beta

- Fiddler Script：fiddler 在 Web 前端开发时候经常使用，用户再修改请求头信息时候经常需要设置断点，但是设置后会在断点处停下，之后点击重启才行。而 fiddler script 本质是 JScript.NET 语言写的脚本文件 CustomRules.js，语法类似 C#，若是修改 CustomRules.js 其实可以很容易的修改 http 的请求的应答，不用中断程序，还可以针对不同 URI 做特殊处理，甚至可以根据开发者的需要去定制菜单，功能可以说是非常强大的。脚本文件 CustomRules.js 位于 `C:\Documents and Settings[your user]\My Documents\Fiddler2\Scripts\CustomRules.js`下，你也可以在 Fiddler 中打开 CustomRules.js 文件， 启动 Fiddler, 点击菜单 Rules->Customize Rules。可以直接编辑 CustomRules.js 文件，也可以下载 Fiddler Script Editor 来编辑。Fiddler Script Editor 提供了语法高亮，以及智能提示的功能，方便编辑

- Log：查看 fiddler 的 event log 信息，不同请求的 log 信息应该是一致的，每当更新一次页面，event log 会自动刷新一次，若将上方的 any process 拖动到指定浏览器后，fiddler 会单独记录该浏览器页面的通信信息

- Filters：这个可以用来过滤 session 中的请求

- Timeline：可以查看请求响应的时间轴

- Statistics：里头包含该 session 请求的统计数据，包括请求次数，请求与响应字节数，信息头和体各有多少字节，以及连接时间点，响应信息类型，最后，下面有个全球性能估计的数据

### 具有功能

#### 捕获火狐会话

Fiddler 默认 IE 的代理为 127.0.0.1:8888 其他浏览器需要手动设置，将火狐的代理改为 127.0.0.1:8888 即可。默认情况下，firefox是没有启用代理的（如果你安装了proxy等代理工具或插件，是另外一种情况）

- 第一种方法：在 firefox 中点击 右上角->选项->常规->划到最下面的网络设置->设置，点击“手动代理配置”，HTTP 代理填 127.0.0.1，端口填 8888；
- 第二种方法：打开 fiddler，选择 Tools/Fiddler options/Connetions，点击 Copy Browser...，然后参照方法1打开设置，在自动代理配置中填上拷贝的 fiddler 的 BrowserProxy Configuration URL

#### 捕获 HTTPS 协议的会话

默认情况下 Fiddler 不会捕获 HTTPS 的会话，需要打开 Fiddler 的 Tools → Options… → HTTPS，勾选上 Capture HTTPS CONNECTs 和 Decrypt HTTPS traffic，再点击 OK 即可

#### 简单的模拟性能测试的并发测试

首先鼠标选中需要的 HTTP 请求，然后把键盘设为大写模式，按下 Shift + R，会弹出模拟并发的次数，然后输入你需要并发的次数，然后发送请求即可。右键 session 栏中选择 Replay → Ressue Requests 也可以并发但是不能选择次数，工具栏中 Replay 按钮同样也是这个功能。除此之外，右键 session 栏中的 Replay 中从上到下依次是无条件重发选中的请求，重发请求并编辑（会打开一个加了断点的请求可进行请求和响应数据的修改）、重发并验证（重发并验证请求结果，会自动加颜色标识）、重发序列（打开数量设置界面，标识需要重发多少次请求）、重发并打开 composer 界面（可编辑或发送）、在 IE 上直接发起这个请求

#### 捕获特定浏览器的请求

通过将 Fiddler 状态栏中的 Any Process 按钮进行拖动，拖动到指定浏览器的标题栏上，可以实现 Fiddler 只捕获通过该浏览器的请求

#### 模拟请求发送并查看响应

在 Request 栏中的 Composer 中，在 Parsed 中机型请求方式，请求 url，请求协议，请求头，请求体的编辑，然后点击 Excute 进行发送请求，而响应结果可以在左侧 sessions 栏中出现，所以说在执行 Excute 之前最好清空一下 sessions 框中的 sessions，Composer 中数据具体该怎么写，可以将 sessions 框中的某一 session 拖动到 Composer 中来模仿着写

#### AutoResponder 利用本机模拟远端服务器进行响应

这里是使用 Fiddler 的 request 栏中的 AutoResponder 自动响应功能，通过选中 Enable Rules，然后选中session，来点击 Add rules 按钮来添加规则，Enable Rules 右边有两个选项依次是跳过不匹配的请求和启用延时（ms），Fiddler 支持 url 的正则匹配，下方有个蓝色的 Test…，点击这个可以用来测试 url 是否匹配。这个功能非常牛，因为我们可以使用 Fiddler 截取某些软件激活的信息（如果它们使用 HTTP 协议），然后利用这个能模拟返回服务器的信息，这样一来我们就可以伪造一个假的服务器了

#### Fiddler 远程抓包功能

大家知道的基本都是 Fiddler 捕获本机数据包，实际上 Fiddler 也可以远程抓包，假如有 A和 B 两台设备，现在想用 A 设备中的 Fiddler 捕获 B 设备中的 HTTP 数据包，先查看 A 设备中的 IP 和 Fiddler 设置的端口号并保留下来，打开 A 的 Fiddler 通过 Tools → Options… → Connections 勾选 Allow remote computer to connect，在 B 设备中打开浏览器修改代理，HTTP 代理为 A 机器上的 IP，端口为 A 机器上 Fiddler 的端口， 这样 A 设备中的 Fiddler 就可以成功看到 B 设备的数据包了，其实一旦在 B 设备指定了代理机，无论 Fiddler 是打开还是关闭或者抓远端包的功能是打开还是关闭，数据都会传到 A 机器。原理还是代理服务器，远端服务器与 B 机器做数据传递，A 机器充当了代理机的缘故，能成功抓取流向 B 机器的数据包

#### QuickExec 命令行控制台

Fiddler 的命令行操作可参见 Fiddler 命令操作官方帮助页：http://docs.telerik.com/fiddler/knowledgebase/quickexec

快捷键 Alt + Q：快速将焦点定位到 QuickExec 命令行，Ctrl + I：当选择了一个 session 时候，可以快速将此 session 的 url 插入到当前命令行光标处。多数命令是存储在本地的 CustomRules.js 文件中，新版本的 Fiddler 会增加新的命令，旧版的 Fiddler 想使用新命令，就可以更新 CustomRules.js 文件中的 ExecAction 即可。除了输入默认命令，也可以自定义命令，你可以通过编辑 FiddlerScript 来增加新命令，找到 OnExecAction 函数增加新命令。这里仅介绍默认命令。

- ?sometext：此命令可以高亮所有 url 匹配问号后的字符的全部 session
- \>数字：选择响应尺寸大于指定数字大小的全部 session，比如说 >40000，这是响应大于 40kb 的请求，比如说 <5k，这是响应小于 5kb 的请求；
- =状态码：选择响应 HTTP 状态码等于指定值的全部 session，如 =200；
- =请求方法：选择请求中的指定的请求方法的所有 session；
- @host名：选择包含指定 host 的全部 session，如 @csdn；
- bold url 中字符：可以来加粗显示包含 url 指定字符的 session；
- bpafter url 中字符：可以来中断 url 中包含指定字符的 session；
- bps：清空所有设置断点的 session，bps 状态码：中断所有响应为指定状态码的 session;
- bpv：清空所有设置断点的 session，bpm：同上；
- bpv 请求方法：中断所有为指定请求方法的 session，bpm 请求方法：同上；
- bpu：清空所有设置断点的 session，bpu url 中字符：众多所有 url 中包含指定字符的 session；
- clear：清除所有 session，cls：同上；
- dump：将所有 session 打包到 C 盘的一个 zip 压缩包中；
- go：继续运行所有中断的 session，g：同上；
- help：浏览器打开 Fiddler 的命令行控制台帮助页，hide：将 Fiddler 隐藏到任务栏图标中；
- urlreplace 替换前的字串 替换后的字串：将 url 中字符串替换成特定串；
- urlreplace：清空之前的替换设置，start：将 Fiddler 设为系统代理；
- stop：将 Fiddler 从系统代理中注销，show：将 Fiddler 从任务图标回复为图形界面；
- select 类型：选择响应类型为指定类型的 session，比如 select image；
- select 指定内容：选择 header 或者 sessionFlag 中包含指定内容的 session；
- allbut 响应类型：选择响应类型不是这个指定的响应类型的所有 session，比如allbut xml 表示选择除了 xml 响应之外的所有；
- keeponly 响应类型：同上，quit：退出 Fiddler；
- !dns 主机名：对目标主机进行 dns 查找，并在 LOG 选项卡上显示结果，如 !dns www.example.com 可以将这个域名的 IP 解析并输出出来；
- !listen 端口号：可以在另一个端口上设置一个额外的监听器，可选由 HTTPS 证书保护

#### 断点设置

在 Fiddler 菜单栏的 Rules → Automatic Breakpoints 中可以选择断点设置方式，默认不设断点，可以选择请求发送前设断点或者请求发送后设断点，还可以勾选是否忽略返回图片的请求，默认是勾选的。

- Before Requests：在请求前设断点。在请求前就设置断点，这样点进 session 可以看到是没有响应的，因为请求还未发出，自然浏览器页面是空白的，不会收到响应结果，除了通过点击的方式设置断点和恢复断点，还可以通过命令行的方式，通过`bpu 服务器地址`，这样的方式来对特定的请求设置断点，要清除原来的断点，可以在命令行输入`bpu`来清除之前所有断点。点击工具栏中的 Go 按钮可以让所有断点恢复运行；
- After Responses：在响应之后设断点。这个断点是设置在数据响应已经发到本机，但是未到浏览器界面上显示的时候，所以浏览器的页面应该也是空白，可以更改返回数据信息，之后点击继续运行，可以看到浏览器页面出现了自己在响应信息中更改的字段，这里同样也可以通过命令行`bpafter 服务器地址`，这样的方式来设置指定服务器的断点，通过 bpafter 来清除之前断点。点击工具栏中的 Go 按钮可以让所有的断点恢复运行

#### 编码和解码功能

Fiddler 中有非常强大的编码以及解码功能

- Decode 解码功能：
  - 在 respond 栏中解码：通过点击`Response Body is encoded...`，可以将响应体中的乱码进行解码；
  - 工具栏中的 Decode 按钮：默认是不选中此项的，一旦选中此项，之后通过fiddler截获显示的请求将全部都是已经解码过的；
  - 菜单栏中 Rules → Remove All Encodings 按钮：与上面一样；
  - 工具栏中的 TextWizard 工具：点击打开此工具，这里可以拷贝字串进行编解码，功能比较强大；
  - Session 栏右键 Decode Selected Sessions：此项可以解码所选中的session，与在 respond 栏中解码一样，不过这个可以批量
- Encode 编码功能：
  - 菜单栏中 Rules → Apply GZIP Encoding 按钮：默认是不勾选的，若选择了此项，则只要请求中包含了 gzip 标识的 Accept-Encoding 请求头，就会对除了图片以外的所有相应使用 GZIP HTTP 压缩；
  - 工具栏中的 TextWizard 工具：点击打开此工具，这里可以拷贝字串进行编解码，功能比较强大；
  - 有响应体的 Respond 栏中的分块传输编码和 HTTP 压缩技术：在 Respond 栏中，有勾选框为 Chunked Transfer-Encoding，这个是分块传输编码。下面的 HTTP Compress 可以勾选不同的压缩技术

#### Fiddler 工具的属性偏好设置

在 View → Tabs → Preferences 中设置 Fiddler 这个工具的属性值，具体设置的数值可以参照网络

#### Fiddler Script

Fiddler Script 可以设置断点，在 request 栏中点击 FiddlerScript 可以打开。这里可以修改样式，限速，断点，这属于 Fiddler 的高级用法，具体添加以及修改方法可参见网络

### HTTP 代理

HTTP 代理知识：https://blog.csdn.net/abcnull/article/details/84787954