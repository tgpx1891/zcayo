### 性能测试

软件性能测试是一种非功能性测试，让应用程序的性能在预期或更高负载下进行评估。进行性能测试以测量系统的不同性能属性，如响应时间(速度)，可靠性，资源使用，可扩展性，各种负载条件下的稳定性等。在推出市场上的最终软件产品之前，应针对各种负载条件下的速度，可扩展性和稳定性对产品进行测试。如果产品在没有进行性能测试的情况下直接上线，可能会导致处理速度慢和可用性差等问题，从而可能获得不良声誉并直接影响预期的销售目标

负载测试是一种性能测试，可模拟任何软件、应用程序或网站上的实际负载。它有助于确定系统在正常和峰值条件下的行为方式。可以在受控的实验室条件下执行负载测试，以比较不同系统的功能或准确测量单个系统的功能。压力测试也是一种性能测试，也称为疲劳测试，有助于确定计算机、网络、程序或设备在不利条件下保持一定效率的能力

### JMeter 介绍

JMeter 也称为“Apache JMeter”，它是一个开源的，100%基于 Java 的应用程序，带有图形界面。 它旨在分析和衡量 Web应用程序和各种服务的性能和负载功能行为。JMeter 主要用于测试 Web 应用程序或FTP应用程序，但目前，它适用于功能测试，JDBC 数据库连接，Web服务，通用 TCP 连接和 OS 本机进程。 您可以执行各种测试活动，如性能，负载，压力，回归和功能测试，以便针对您的 Web 服务器获得准确的性能指标。Web 服务器包含大量应用程序和用户，因此有必要知道 Web 服务器处理同时访问用户或应用程序的能力。 例如; 当许多用户同时访问网站时，网站服务器将如何执行，基本上要使用 JMeter 等性能测试工具进行性能测试。以下是 JMeter 支持的协议列表：

- Web Services：SOAP / XML-RPC
- Web：HTTP、HTTPS sites web 1.0 web 2.0（ajax、flex 和 flex-ws-amf）
- 通过 JDBC 驱动程序的数据库
- 目录 ：LDAP
- 通过 JMS 面向消息传递的服务
- 服务 ：POP3、IMAP、SMTP

### JMeter 特性

- **开源应用程序：**JMeter 是一个免费的开源应用程序，可以帮助用户或开发人员使用源代码开发其他应用程序；
- **用户友好的GUI：**JMeter 带有简单的交互式 GUI；
- **支持各种测试方法：**JMeter 支持各种测试方法，如负载测试，分布式测试和功能测试等；
- **支持多协议：**JMeter 支持 HTTP，JDBC，LDAP，SOAP，JMS 和 FTP 等协议；
- **模拟：**JMeter 可以使用虚拟用户或唯一用户模拟多个用户，以便对正在测试的 Web 应用程序产生大量负载；
- **框架：**JMeter 是一个多线程框架，允许许多或单独的线程组同时和同时采样不同的函数；
- **远程分布式测试：**JMeter 具有用于分布式测试的主从概念，其中主服务器将在所有从服务器之间分配测试，而从服务器将针对服务器执行脚本；
- **测试结果可视化：**测试结果可以以不同的格式查看，如图形，表格，树型和报告等

### 工作流程

JMeter 通过模拟一组用户将请求发送到目标服务器。 随后，收集数据以通过各种格式计算目标服务器的统计和显示性能度量

![164815_79832](E:\我的电脑\图片\学习\测试\164815_79832.png)

### 下载和启动

JMeter 下载：`http://jmeter.apache.org/download_jmeter.cgi`，Windows 系统，转到`bin`目录点击 jmeter.bat 文件，以 GUI 模式启动 JMeter

### 构建测试计划

可以将测试计划可视化为用于运行测试的 JMeter 脚本。测试计划由测试元素组成，例如线程组，逻辑控制器，样本生成控制器，监听器，定时器，断言和配置元素。每个测试计划中至少应有一个线程组。 我们可以根据要求添加或删除元素

- 默认的 JMeter 界面包含一个测试计划节点，其中保留了真实的测试计划。“测试计划(Test plan)”节点包含测试计划的名称和用户定义的变量。当您在测试计划的多个部分中有重复值时，可使用用户定义变量，它提供了灵活性；
- 添加/删除测试计划元素：选择测试计划节点，然后右键单击所选项目，鼠标悬停在 Add 选项上，然后单击选择所需的选项。要删除元素，请选择所需的元素，右键单击元素，然后选择 Remove 选项；
- 加载并保存测试计划元素：要将元素加载到 JMeter 测试计划树，请选择并右键单击要添加已加载元素的任何树元素。选择`Merge`选项，保存元素的`.jmx`文件后元素将合并到 JMeter 测试计划树中。要保存树元素，请右键单击元素，选择 Save Selection As 选项，将文件保存在所需位置； 
- 配置树元素：可以使用 JMeter 右侧框架上的控件配置测试计划中的元素。例如，可以配置线程组元素的名称、线程数（正在测试的用户数）、加速时间（希望允许线程组从0到3个用户的时间）和循环计数（应该循环测试的次数）；
- 保存JMeter测试计划：可以通过从文件菜单中选择`Save`或`Save Test Plan As`来保存整个测试计划；
- 运行JMeter测试计划：可以通过单击菜单项中的`Start(Control + r)`来运行测试计划，也可以单击绿色播放按钮。当测试计划开始运行时，JMeter 界面在菜单栏正下方的部分的右端显示一个绿色圆圈。绿色圆圈左侧的数字表示：活动线程数/总线程数；
- 停止JMeter测试计划：可以使用`Stop(Control +’.’)`停止测试计划，它会立即停止线程。还可以使用`Shutdown(Control +’，’)`，它请求线程在任何正在进行的任务结束时停止；
- 检查 JMeter 测试计划执行日志：JMeter 将测试运行详细信息，警告和错误存储到 jmeter.log 文件中。可以通过单击菜单栏正下方部分右侧的黄色惊叹号来访问 JMeter 日志

### 测试计划元素

JMeter 包含各种相互关联但为不同目的而设计的元素

#### 测试计划

可以将测试计划(Test Plan)可视化为用于运行测试的 JMeter 脚本。 测试计划由测试元素组成，例如线程组，逻辑控制器，样本生成控制器，监听器，定时器，断言和配置元素。测试计划包含执行脚本的所有步骤，包含的所有内容都按照从上到下的顺序执行，或者按照测试计划中定义的顺序执行。在运行整个测试计划之前，应保存测试计划。JMeter 文件或测试计划以`.JMX`扩展文件的形式保存。JMX是一种基于开放测试的格式，它使测试计划能够在文本编辑器中启动。还可以将测试计划的一部分保存为不同的选择。例如，如果要使用侦听器保存 HTTP 请求采样器，可以将其保存为测试片段，以便它也可以在其他测试场景中使用

#### 线程组

线程组(Thread Group)表示 JMeter 在测试期间将使用的线程组。 线程组元素是任何测试计划的起点，线程组提供的控件允许设置线程数、设置加速期和设置执行测试的次数。线程组控制面板包括线程组名称、线程数(您正在测试的用户数)、加速时间(您希望允许线程组从0到3个用户的时间)、循环计数(应该循环测试的次数)和调度程序复选框(“线程组”面板底部的复选框用于启用/禁用额外字段，您可以在其中输入测试持续时间，启动延迟，运行的开始和结束时间)

#### 控制器

控制器(Controllers)分为采样器和逻辑控制器。采样器是允许JMeter将特定类型的请求发送到服务器的组件，它模拟用户对目标服务器的页面的请求。采样器是必须将组件添加到测试计划中的，因为它只能让JMeter知道需要将哪种类型的请求发送到服务器。 请求可以是 HTTP，HTTP(s)，FTP，TCP，SMTP(邮件)，SOAP、JDBC、JAVA 对象、JMS、JUnit、LDAP、操作系统进程等。可以通过点击 Thread Group -> Sampler 添加采样器到线程组中

逻辑控制器可帮助您控制线程中采样器处理顺序的流程，它还可以更改来自其子元素的请求的顺序。有运行时控制器、IF控制器、事务控制器、录音控制器、简单控制器、while 控制器、Switch 控制器、ForEach 控制器、模块控制器、包括控制器、循环控制器、仅一次控制器、交错控制器、随机控制器、随机顺序控制器、吞吐量控制器。可以通过点击 Thread Group -> Logic Controller 将控制器添加到测试计划中

#### 监听器

性能测试就是以各种形式分析服务器响应，然后将其呈现给客户端。当 JMeter 的采样器组件被执行时，监听器(Listeners)提供 JMeter 收集的关于那些测试用例的数据的图形表示。它便于用户在某些日志文件中以表格，图形，树或简单文本的形式查看采样器结果。监听器可以在测试的任何地方进行调整，直接包括在测试计划下。JMeter提供了大约15个监听器，但主要使用的是表，树和图形。监听器有图表结果、样条曲线可视化器、断言结果、简单的数据编写者、监控结果、分布图(alpha)、聚合图、梅勒展示台、BeanShell监听器、总结报告、示例结果保存配置、图表完整结果、查看结果树、汇总报告、查看表格中的结果。可以通过点击 Thread Group -> Listener 添加监听器到测试计划中

#### 计时器

您在网站或应用程序上执行任何操作时，它们自然会有暂停和延迟，这些可以使用计时器(Timers)进行模拟。

JMeter发送请求时不会在每个采样器/请求之间应用延迟。 如果在服务器上执行负载/压力测试没有指定延迟，它将会超载。 这可能不完全是我们想要的。可以添加一个计时器元素，该元素允许您定义在每个请求到达时间等待的终止。计时器有同步定时器、JSR223 时间、BeanShell 时间、高斯随机定时器、统一随机定时器、恒定吞吐量计时器、BSF 时间、泊松随机时间。可以通过点击 Thread Group -> Timer 添加计时器

计时器(Timers)

#### 配置元素

配置元素(Configuration Elements)的工作与采样器的工作类似，但是它不发送请求，允许修改采样器发出的请求。这是一个简单的元素，您可以在其中收集所有采样器的关联配置值，如 webserver 的主机名或数据库 URL 等。配置元素只能从放置元素的分支内部访问。配置元素有Java请求默认值 LDAP 请求默认值、LDAP 扩展请求默认值、密钥库配置、JDBC连接配置、登录配置元素、CSV 数据集配置、FTP 请求默认值、TCP 采样器配置、用户定义的变量、HTTP 授权管理器、HTTP 缓存管理器、HTTP Cookie 管理器、HTTP 代理服务器、HTTP 请求默认值、HTTP 标头管理器、简单的配置元素、随机变量。可以通过点击 Thread Group -> Config Element 将配置元素添加到测试计划中

#### 预处理器元素

预处理器元素(Pre-Processor Elements)在采样器发出请求之前执行，如果预处理器附加到采样器元素，那么它将在该采样器元素运行之前执行。预处理器元素用于在运行之前修改样本请求的设置，或更新未从响应文本中提取的变量。预处理元素有 JDBC 预处理器、JSR223 预处理器、RegEx 用户参数、BeanShell 预处理器、BSF 预处理器、HTML 链接解析器、HTTP URL 重写修饰符、HTTP 用户参数修饰符、用户参数。可以通过点击 Thread Group -> Pre Processors 将预处理器元素添加到测试计划中

#### 后处理器元素

在发出采样器请求之后执行后处理器元素(Post-Processor Elements)，如果后处理器连接到 Sampler 元素，那么它将在该sampler 元素运行之后执行。后处理器最常用于处理响应数据，例如，为了将来目的而提取特定值。后处理器元素有CSS/JQuery 抽取器、BeanShell 后处理器、JSR223 后处理器、JDBC 后处理器、调试后处理器、正则表达式提取器、XPath抽取器、结果状态操作处理程序、BSF后处理器。可以通过点击 Thread Group -> Post Processors 将预处理器元素添加到测试计划中

#### JMeter 函数

JMeter 函数可以称为特殊值，可以填充测试树中任何Sampler或其他元素的字段。函数的语法为`${__functionName(var1,var2,var3)} `，如果函数参数包含逗号，那么请务必使用`“\”`对其进行转义，否则 JMeter 会将其视为参数分隔符。JMeter 函数和变量始终区分大小写

| 函数类型 | 名称                 | 注解                                   |
| -------- | -------------------- | -------------------------------------- |
| 信息     | threadNum            | 获取线程号                             |
| 信息     | samplerName          | 获取采样器名称(标签)。                 |
| 信息     | log                  | 记录(或显示)消息(并返回值)。           |
| 信息     | machineName          | 获取本地计算机名称。                   |
| 输入     | StringFromFile       | 从文件中读取一行。                     |
| 输入     | FileToString         | 读取整个文件。                         |
| 输入     | CSVRead              | 从CSV分隔文件中读取。                  |
| 输入     | XPath                | 使用XPath表达式从文件中读取。          |
| 计算     | Counter              | 生成递增数字。                         |
| 计算     | intSum               | 相加int数字。                          |
| 计算     | longSum              | 相加long数字。                         |
| 计算     | Random               | 生成一个随机数。                       |
| 计算     | RandomString         | 生成随机字符串。                       |
| 脚本     | BeanShell            | 运行BeanShell脚本。                    |
| 脚本     | javaScript           | 运行javaScript脚本。                   |
| 脚本     | jexl, jexl2          | 评估Commons Jexl表达式。               |
| 属性     | Property             | 读取property文件。                     |
| 属性     | P                    | 读取一个属性(速记方法)。               |
| 变量     | Split                | 将字符串拆分为变量。                   |
| 变量     | eval                 | 评估变量表达式。                       |
| 字符串   | regexFunction        | 使用正则表达式解析先前的响应。         |
| 字符串   | escapeOroRegexpChars | 引用ORO正则表达式使用的元字符。        |
| 字符串   | Char                 | 从数字列表生成Unicode char值。         |
| 字符串   | Unescape             | 包含Java转义的进程字符串(例如\n＆\t)。 |
| 字符串   | unescapeHtml         | 解码HTML编码的字符串。                 |
| 字符串   | escapeHtml           | 使用HTML编码对字符串进行编码。         |
| 字符串   | TestPlanName         | 返回当前测试计划的名称。               |

- 在线程组中添加一个 HTTP 请求采样器，配置 HTTP Request Sampler 的字段，Server名称或IP：`www.yiibai.com`，Path：/，表示我们想要服务器的根页面；
- 复制整个线程组1并将其粘贴在测试计划中三次，分别重命名为线程组123，将其他采样器分别重命名为 HTTP Request 123；
- 右击 Test Plan 节点，添加 Summary Report 监听器；
- 保存后执行测试计划，日志函数`${__log("Hello World")}`会在控制台打印 Hello World，时间函数`${__time(dd MM YYYY HH mm ss)}`获取当前时间

### 测试计划

#### 数据库测试

创建名为 testdb 的数据库，创建表`tb_user`，将记录插入到`tb_user`表中。需要将相应的 JDBC 驱动程序复制到 apache-jmeter-4.0 文件夹的“lib”目录中

- 将线程组重命名为 JDBC Users，右击 Thread Group，选择 Config Element -> JDBC Connection Configuration 添加配置元素，需要设置一些重要的字段，这些字段将决定数据库和JMeter之间的正确连接；
  - 绑定到池的变量名称 - 它唯一地标识配置，JDBC Sampler 将进一步使用此名称来标识要使用的配置，这里将其命名为 test；
  - 数据库 URL - `jdbc:mysql://localhost:3306/testdb`；
  - JDBC 驱动程序类 - `com.mysql.jdbc.Driver`；
  - 用户名 - `root`；密码 - root 用户的密码
- 右击 Thread Group，选择 Sampler -> JDBC request，名字 - `JDBC Request`，输入池名称 - 测试(与配置元素中的相同)，查询类型 - 选择语句，查询 - 输入SQL查询字符串字段`select * from testdb.tb_user;`
- 右击 Thread Group，选择 Listener -> View Results Tree 添加监听器，单击 Run -> Start 以执行测试计划。JMeter 的绿色表示测试计划的成功执行，响应数据选项卡显示数据库 “testdb” 的记录

#### web 测试

- 将测试计划重命名为 *Demo Test*，将线程组重命名为 Users，Users 元素表示访问网站主页的用户数。右击 Thread Group，选择 Sampler -> HTTP request，添加一个空的 HTTP 请求采样器；
- 配置 HTTP Request Sampler 的字段，服务器名称或IP`www.yiibai.com`，路径  /(斜杠)，表示想要服务器的根页面；
- 右击 Thread Group，选择 Listener -> View Results Tree 添加监听器。“View Result Tree” 面板的第一个选项卡是“Sampler result”，它显示了 JMeter 数据以及 Web 服务器返回的数据，包括 Web 服务器发送的所有响应标头。第二个选项卡是“请求”，它显示作为请求的一部分发送到 Web 服务器的所有数据，最后一个选项卡是响应数据。 它以文本格式显示从服务器接收的数据

#### FTP 测试

将使用公共可用的 FTP 位置，可以使用它来测试文件的下载

- 将此测试计划节点重命名为`DemoFTPtest`，修改线程组的以下属性。名称：FTPusers，线程数(用户) ：4，加速期：保留默认值(1)，循环计数：1；
- 右击 FTPusers元素(线程组)，选择 Sampler> FTP Request，然后设置字段。名称：FTP请求获取，服务器名称或IP：ftp.dlptest.com，远程文件：`.ftpquota`(您可以选择所需FTP位置上的任何目录文件)，本地文件：`D:\demotxt.txt`，选择 get(RETR)，用户名：`dlpuser@dlptest.com`，密码：`3D6XZV9MKdhM5fF`；
- 右击 FTPusers 元素，选择 Listener> View Results Tree 选项。将整个测试计划保存为 *FTP_test.jmx*；
- FTP请求会发出四个请求，检索到的GET请求信息存储在`D:\demotxt.txt`文件中。 可以通过查看“View Results Tree listener”侦听器元素的“Request”选项卡来验证此结果 ?停止不了

#### Webservice API测试

Web 服务被定义为旨在通过网络支持两台机器之间交互的软件系统，它被设计为具有以通常在 Web 服务描述语言(WSDL)中指定的机器可处理格式描述的接口。 通常，“HTTP”是最常用的通信协议，Web 服务还使用 SOAP，REST 和 XML-RPC 作为通信手段。Web 服务可能不包含完整的规范集，有时可能无法执行完整 API 可能执行的所有任务。API充当两个不同应用程序之间的接口，以便它们可以相互通信。 这是第三方供应商可以编写与其他程序轻松连接的程序的方法。API 可以使用任何通信方式来启动应用程序之间的交互。 例如，Linux 内核 API 使用中断调用系统调用。API 包含一套完整的规则和规范，供软件程序遵循以便于交互

Web API 可以被视为 Web 服务中的一种开发，其中重点已经转移到更简单的基于表示状态转移(REST)的通信。 Restful API 不需要基于 XML 的Web服务协议(SOAP和WSDL)来支持其接口。Web 服务大致分为两类：简单对象访问协议(SOAP)和代示状态转移(REST)

可以在 Internet 上搜索各种可公开使用的REST API。并获取API密钥以在JMeter中设置测试。 您还可以使用任何开发环境构建整个 Web 服务项目，并将其部署在 JMeter 上以运行测试计划。接下来测试使用的是开放天气地图网站在 URL 下提供的 API`https://openweathermap.org/api`，可以在此网站上注册以访问您的 API 密钥，该密钥随后用于获取正确的天气报告。在我们的例子中，生成的 API 密钥`3f25ec8eed9e1951e21407a34312c2c8`。我们将使用此 API 密钥以及调用 API 的方法来获得所需的结果，调用 API 的方法包括服务器名称，后跟城市代码/城市名称和 API 密钥。

- 将测试计划节点重命名为 *WebServiceTest*，修改线程组属性，名称：Webservice user，线程数(用户)：2，加速期 ：保留默认值(1)，循环计数：1；

- 右击 Webservice user 元素(线程组)，选择 `Sampler> HTTP Request`，设置 HTTP Request 的属性。名称：HTTP 请求，服务器名称或IP：`api.openweathermap.org`，路径：`data/2.5/weather`，参数：q = London，appid =`3f25ec8eed9e1951e21407a34312c2c8`。其实就是形成了如下链接

  ```
  http://api.openweathermap.org/data/2.5/weather?q=London&appid=3f25ec8eed9e1951e21407a34312c2c8
  ```

- 右击 Webservice user 元素(线程组)， 选择 Listener> View Results Tree 选项，将整个测试计划保存为HTTP_test.jmx。在响应数据选项卡中，可以看到 OpenWeatherMap 网站提供的实际天气报告

#### JMS 测试

出于测试目的，我们使用Apache ActiveMQ。有各种JMS服务器，如 glassfish3，IBM WebSphere MQ(以前称为MQSeries)，Tibco等。先下载最新版本的 Apache ActiveMQ，解压文件到目录`D:/apache-activemq-5.15.3`，从命令控制台运行以下命令以启动ActiveMQ服务器:`activemq start`。可以通过访问地址的管理界面来验证 ActiveMQ 服务器是否已启动`http://localhost:8161/admin/`，此地址会将您重定向到其身份验证页面，其中需要用户名和密码，输入用户名和密码为:`admin`。将`activemq-all-5.15.3.jar`文件从ActiveMQ解压缩目录复制到`C:\\JMeter\\apache-jmeter-4.0\\lib`文件夹。JMS 支持两种类型的消息传递：点对点消息传递、主题消息或发布/订阅消息

##### 点对点测试

- 将测试计划节点重命名为 JMSpoint_to_point，将此线程组元素重命名为 JMS User，将循环计数( loop count )更改为2；
- 右击 JMS 用户元素(线程组)元素，选择 Sampler> JMS Point-to-point 添加 JMS 点对点采样器，设置 JMS Point-to-point sampler 元素字段。
  - QueueuConnectionFactory：ConnectionFactory(活动 MQ 中连接工厂的缺省 JNDI 条目)；
  - JNDI 名称请求队列：Q.REQ(JMeter 的 JNDI 名称，用于建立连接工厂和队列之间的连接)；
  - JNDI 名称接收队列：Q.REQ(同样的 JNDI 名称也用于响应)；
  - 通信方式：request_reply，使用请求消息ID：已选中，使用响应消息 ID：已选中；
  - 时间(毫秒)：2000(如果没有及时恢复，则 JMeter 收到消息时会使用超时，然后该项被标记为错误)；
  - 内容：点对点测试，`Initial Context Factory`：`org.apache.activemq.jndi.ActiveMQInitialContextFactory`(Active MQ 的标准InitialContextFactory)；
  - JNDI 属性：名称`queue.Q.REQ`，值`example.A`，提供者URL：`tcp://localhost:61616`(攻击ActiveMQ的地址和端口) 
- 右击 JMS 用户元素(线程组)元素，选择 *Listener -> View Results Tree* 选项，将整个测试计划保存为 *JMS Point-to-Point.jmx*。运行后就可以在 ActiveMQ 管理控制台 queues 页面`http://localhost:8161/admin/queues.jsp`中看到队列中的消息状态选项

##### 主题测试

对于此测试，我们必须创建一个订阅者和一个发布者

- 将 测试计划节点重命名为 *JMS_topic_test*，将 Thread Group 元素重命名为 *JMS pub-sub user*，将循环计数(*loop count*)更改为`2`；
- 右击 JMS pub-sub user元素(线程组)，选择 *Sampler -> JMS Publisher* 添加JMS发布服务器，设置 JMS Publisher sampler 元素字段。
  - 名称：*Sample Publisher，jndi.properties文件：未选中(JMeter 使用“JNDI初始上下文工厂”和“提供者URL”字段来创建连接)；
  - 初始上下文工厂：`org.apache.activemq.jndi.Active MQ`初始上下文工厂；
  - 提供者 URL：`tcp://localhost:61616`，连接工厂：连接工厂（ConnectionFactory），目的地：动态主题/我的静态主题1（dynamicTopics/MyStaticTopic1）；
  - 要聚合的样本数：2(要聚合的样本数)，消息来源：Textarea，消息类型：文本(用于文本或对象消息的消息)；
  - 右击 JMS pub-sub user元素(线程组)，选择 *Sampler -> JMS Subscriber *添加一个订阅者，设置 JMS Subscriber sampler 元素字段。
    - 名称：Sample Subscriber**，jndi.properties文件：未选中(JMeter 使用“JNDI初始上下文工厂”和“提供者URL”字段来创建连接)；
    - 初始上下文工厂：`org.apache.activemq.jndi.Active MQ`初始上下文工厂；
    - 提供者URL：tcp://localhost:61616`，连接工厂：连接工厂，目的地：动态主题/我的静态主题1；
    - 要聚合的样本数：2(要聚合的样本数)，存储响应：打勾(采样器应读取响应。如果不是，则仅返回响应长度。)，超时：2000
  - 右击 JMS pub-sub user 元素(线程组)，选择 Listener> View Results Tree 添加监听器，将整个测试计划保存为*JMS_topic_test.jmx*。可以在 ActiveMQ 管理控制台的主题选项中查看消息状态

#### 分布式负载测试

使用吞吐量控制器在 JMeter 中创建分布式负载测试计划，出于测试目的，我们将在我们网站`www.yiibai.com`的 URL 下的某些网页上创建分布式负载。假设创建了10个虚拟用户(线程)来在网站上执行分布式负载测试，然后所有其他网页将由10个虚拟用户的持续负载进行测试。 但是，这不是一个现实世界的场景。 在现实世界中，同一URL下不同网页的负载可能存在差异。首先创建一个分布式负载测试计划，而不使用吞吐量控制器

- 将测试计划节点重命名为 Distributed Test，右击 Thread Group，选择 Sampler > HTTP request 选项添加一个空的HTTP 请求采样器；
- 配置 HTTP Request Sampler的字段，*Name*：Home Page，服务器名称或IP：`www.yiibai.com`；
- 复制线程组并将其粘贴到测试计划中三次，根据测试的网页重命名每个 HTTP 请求采样器，每个 HTTP 请求采样器的服务器名称都相同，然后分别配置 Java（/java），C_Programming（/cprogramming）和 Cpp（/python）采样器的路径名；
- 右击“Distributed Test Plan”元素，选择 Listener -> Aggregate Report 添加监听器，将整个测试计划保存为Distributed_test1.jmx。可以在 #Samples 标签中查看每个网页的加载分布，比例为 1

现在已经成功执行了分布式负载测试计划，但是不使用吞吐量控制器。 但是，在应用程序的实际负载测试期间，我们无法确定实际用户的数量。 在这种情况下，需要使用吞吐量控制器

- 选择“Threads (Users)” -> “Thread Group”，将线程组重命名为 Master Thread Group，将主线程组中的用户总数配置为“10”。然后右击 Master Thread Group，选择 Logic Controller -> Throughput Controller 添加吞吐量控制器
- 复制“主页”采样器并将其粘贴到吞吐量控制器中，再创建三个吞吐量控制器并复制粘贴其余的网页采样器，禁用/删除分布式测试计划节点下的线程组（右击线程组点击 disable）;
- 每个吞吐量控制器的“%”执行将根据主线程组中的用户总数进行分配，10% 为主页（在吞吐量控制器面板的 Throughput 填 10.0）、20% 为 Java、C_Programming为 20%、Cpp 为 50%。主线程组中的线程数(用户)可以根据应用程序的实际预期负载而变化.比例为`1:2:2:5`

#### 录制登录测试

将使用 OrangeHRM 在 URL`http://opensource.demo.orangehrmlive.com`下提供的公开网站来记录成功登录其网站，还将使用 BlazeMeter 提供的 chrome 扩展，通过该扩展可以在 chrome 中记录用户操作，然后导出测试脚本，随后可以在JMeter 中使用这些脚本来运行测试计划。BlazeMeter 的 Chrome 扩展程序会记录通过用户浏览器发出的所有 HTTP/S 请求，并创建一个 JMeter 脚本并自动将其上传到 BlazeMeter 的平台。 在那里，只需单击即可执行脚本，或者用户可以选择在本地下载生成的 JMeter 脚本(.jmx 文件)。

- 首先将 BlazeMeter 插件成功集成到 Chrome 浏览器中，在谷歌网上商店搜索 BlazeMeter 然后添加。在 BlazeMeter.com 上建立账户，他们的记录器是免费的帐户创建；
- 启动 chrome 并点击 OrangeHRM 登录页面，填写登录凭据。单击工具栏菜单上的 Blazemeter 图标，输入测试名称“LOGIN_TEST”，单击红色按钮开始重新编码；
- 然后，单击登录按钮以登录网站。登录后，单击停止录制按钮以进一步停止录制操作，再单击 .jmx 按钮下载录制脚本的 .jmx 文件；
- 将测试计划节点重命名为 Login Test，转到 File -> Open，选择下载的 login_Test.jmx 文件。可以看到 login_Test.jmx包含了所有必要的组件，如标题管理器，缓存管理器，采样器等。单击线程组下的第一个采样器，在这里可以查看用于登录 OrangeHRM 网站的登录凭据；
- 右击 login_Test 计划节点，选择 Listener -> View Results Tree 选项

### 修改 Jmeter 界面字体

打开 bin 目录下的 `jmeter.properties`，添加以下两行，要把前面的 # 号去掉

```
jmeter.hidpi.mode=true
jmeter.hidpi.scale.factor=2.0
```

