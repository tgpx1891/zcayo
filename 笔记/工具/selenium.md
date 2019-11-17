 Selenium是最广泛使用的开源Web UI（用户界面）自动化测试套件之一 ，支持跨不同浏览器，平台和编程语言的自动化 。 通过使用特定于每种语言的驱动程序支持各种编程语言 ，Selenium可用于自动化功能测试，并可与Maven，Jenkins和Docker等自动化测试工具集成，以实现持续测试。 它还可以与TestNG和JUnit等工具集成，以管理测试用例和生成报告

 Selenium有以下功能特性

-    Selenium是一个开源和可移植的 Web 测试框架 ， Selenium IDE 为创作测试提供了回放和录制功能，而无需学习测试脚本语言 
- 支持并行测试执行，从而减少了时间并提高了测试效率 ， 与其他自动化测试工具相比，Selenium 需要的资源更少 
- 可以与Ant和Maven等框架集成，用于源代码编译 ； 与 TestNG 等测试框架集成，以进行应用程序测试和生成报告 
-  Selenium Web 驱动程序不需要服务器安装，测试脚本直接与浏览器交互 

### Selenium 工具套件

Selenium 不仅仅是一个工具，而是一套软件，每个软件都有不同的方法来支持自动化测试。 它由四个主要组成部分组成，包括:

- Selenium集成开发环境(IDE)：实现为 Firefox 扩展，在测试脚本上提供记录和回放功能 

- Selenium远程控制器(现已弃用)

  Selenium RC(由selenium正式弃用)允许测试人员使用任何支持的编程语言编写自动化Web应用程序UI测试。 它还涉及一个HTTP代理服务器，它使浏览器能够相信正在测试的Web应用程序来自代理服务器提供的域。Selenium RC有两个组件：Selenium RC Server(充当Web请求的HTTP代理)和Selenium RC Client(包含编程语言代码的库)。 Selenium RC在连续集成系统下测试复杂的基于AJAX的Web用户界面非常有效 

- webdriver

   Selenium WebDriver(Selenium 2)是 Selenium RC 的继承者，也是 Selenium Suite 最重要的组件。 它提供了一个编程接口来创建和执行测试用例。 编写测试脚本是为了识别网页上的Web元素，然后对这些元素执行所需的操作。与Selenium RC相比，Selenium WebDriver 执行速度更快，因为它可以直接调用Web浏览器。 另一方面，RC需要RC服务器与Web浏览器进行交互。WebDriver 直接调用不同浏览器的方法，每个浏览器都有单独的驱动程序 

- Selenium Grid

  Selenium Grid 也是 Selenium Suite 的一个重要组件，它允许在不同的机器上并行运行不同浏览器的测试。 简单来说，可以在运行不同浏览器和操作系统的不同机器上同时运行测试。Selenium Grid 遵循 Hub-Node 架构来实现测试脚本的并行执行。Hub 被视为网络的主设备，另一个将是节点。 Hub 控制在网络的各个节点上执行测试脚本

Selenium 版本2将 Selenium RC 和 Selenium WebDriver 的最佳功能合并到 Selenium WebDriver 中 。  一些最广泛使用的Web驱动程有 Mozilla Firefox驱动程序(Gecko驱动程序)、谷歌Chrome驱动程序、Internet Explorer驱动程序、Opera驱动程序、Safari驱动程序、HTML单元驱动程序(一个特殊的无头驱动程序)

####  Selenium IDE 

Selenium IDE(集成开发环境)是 Selenium Suite 下的开源Web自动化测试工具。 与 Selenium WebDriver 和RC不同，它不需要任何编程逻辑来编写其测试脚本，而只需记录与浏览器的交互以创建测试用例。 之后，可以使用播放选项重新运行测试用例

**注意**：Selenium IDE仅作为Mozilla Firefox和Chrome插件提供，它无法在Firefox和Chrome以外的浏览器上记录测试用例。记录的测试脚本也可以导出到C#，Java，Ruby或Python等编程语言

##### 每个组件的特性和功能

1. 菜单栏

   - 项目名
   - 打开项目
   - 保存项目

2. 工具栏

   - 全部运行
   - 运行测试
   - 步骤功能
   - 速度控制选项

   ![084952_97808](E:\我的电脑\图片\学习\测试\084952_97808.png)

3. 地址栏

4. 测试用例窗格

   在测试用例窗格的底部，可以看到测试执行结果摘要，其中包括各种测试用例的通过/失败状态

5. 测试脚本编辑器框

   - 命令
   - 目标
   - 值

日志窗格在执行期间显示运行时消息。 它提供IDE执行的操作的实时更新。 它可以分为四种类型：信息，错误，调试和警告。引用窗格在编辑器中显示当前所选`selenese`命令的完整详细信息。测试脚本以`.side` 格式保存

单击 Selenium IDE -> Assert Title 。 Assert Title 命令确保页面标题正确