 Selenium是最广泛使用的开源Web UI（用户界面）自动化测试套件之一 ，支持跨不同浏览器，平台和编程语言的自动化 。 通过使用特定于每种语言的驱动程序支持各种编程语言 ，Selenium可用于自动化功能测试，并可与Maven，Jenkins 和 Docker 等自动化测试工具集成，以实现持续测试。 它还可以与 TestNG 和 JUnit 等工具集成，以管理测试用例和生成报告

 Selenium有以下功能特性：

-    Selenium是一个开源和可移植的 Web 测试框架 ， Selenium IDE 为创作测试提供了回放和录制功能，而无需学习测试脚本语言 
- 支持并行测试执行，从而减少了时间并提高了测试效率 ， 与其他自动化测试工具相比，Selenium 需要的资源更少 
- 可以与 Ant 和 Maven 等框架集成，用于源代码编译 ； 与 TestNG 等测试框架集成，以进行应用程序测试和生成报告 
-  Selenium Web 驱动程序不需要服务器安装，测试脚本直接与浏览器交互 

## Selenium 工具套件

Selenium 不仅仅是一个工具，而是一套软件，每个软件都有不同的方法来支持自动化测试。 它由四个主要组成部分组成，包括:

- Selenium集成开发环境(IDE)

   实现为 Firefox 扩展，在测试脚本上提供记录和回放功能 

- Selenium远程控制器(现已弃用)

  Selenium RC(由 selenium 正式弃用)允许测试人员使用任何支持的编程语言编写自动化 Web 应用程序 UI 测试。 它还涉及一个 HTTP 代理服务器，它使浏览器能够相信正在测试的 Web 应用程序来自代理服务器提供的域。Selenium RC有两个组件：Selenium RC Server(充当 Web 请求的 HTTP 代理)和 Selenium RC Client(包含编程语言代码的库)。 Selenium RC在连续集成系统下测试复杂的基于 AJAX 的 Web 用户界面非常有效 

- webdriver

   Selenium WebDriver(Selenium 2)是 Selenium RC 的继承者，也是 Selenium Suite 最重要的组件。 它提供了一个编程接口来创建和执行测试用例。 编写测试脚本是为了识别网页上的Web元素，然后对这些元素执行所需的操作。与Selenium RC相比，Selenium WebDriver 执行速度更快，因为它可以直接调用Web浏览器。 另一方面，RC 需要 RC服务器与 Web 浏览器进行交互。WebDriver 直接调用不同浏览器的方法，每个浏览器都有单独的驱动程序 

- Selenium Grid

  Selenium Grid 也是 Selenium Suite 的一个重要组件，它允许在不同的机器上并行运行不同浏览器的测试。 简单来说，可以在运行不同浏览器和操作系统的不同机器上同时运行测试。Selenium Grid 遵循 Hub-Node 架构来实现测试脚本的并行执行。Hub 被视为网络的主设备，另一个将是节点。 Hub 控制在网络的各个节点上执行测试脚本

Selenium 版本2将 Selenium RC 和 Selenium WebDriver 的最佳功能合并到 Selenium WebDriver 中 。 一些最广泛使用的Web驱动程有 Mozilla Firefox驱动程序(Gecko 驱动程序)、谷歌 Chrome 驱动程序、Internet Explorer 驱动程序、Opera驱动程序、Safari 驱动程序、HTML单元驱动程序(一个特殊的无头驱动程序)

###  Selenium IDE 

Selenium IDE(集成开发环境)是 Selenium Suite 下的开源Web自动化测试工具。 与 Selenium WebDriver 和RC不同，它不需要任何编程逻辑来编写其测试脚本，而只需记录与浏览器的交互以创建测试用例。 之后，可以使用播放选项重新运行测试用例

**注意**：Selenium IDE仅作为 Mozilla Firefox 和 Chrome 插件提供，它无法在 Firefox和Chrome 以外的浏览器上记录测试用例。记录的测试脚本也可以导出到 C#，Java，Ruby 或 Python 等编程语言

#### 每个组件的特性和功能

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

日志窗格在执行期间显示运行时消息，它提供IDE执行的操作的实时更新。 它可以分为四种类型：信息，错误，调试和警告。引用窗格在编辑器中显示当前所选`selenese`命令的完整详细信息。测试脚本以`.side` 格式保存

单击 Selenium IDE -> Assert Title 。 Assert Title 命令确保页面标题正确

####  Selenium IDE命令（Selenese） 	 				 				 				 			

Selenium命令，也称为 Selenese，是运行测试的Selenium IDE 中使用的命令集， 一系列 Selenium 命令(Selenese)一起称为测试脚本。Selenium命令基本上分为三类：操作、访问器和断言

##### 1. 操作

操作(动作)是通常操纵应用程序状态的selenium命令。 执行操作会生成诸如单击此链接，选择该选项，键入此框等事件。如果操作失败或有错误，则停止执行当前测试

| 命令(语法)                          | 描述                                                         |
| ----------------------------------- | ------------------------------------------------------------ |
| open (url)                          | 它在指定的浏览器中启动所需的URL，并接受相对和绝对URL         |
| `type (locator,value)`              | 它设置输入字段的值，类似于用户输入操作                       |
| `typeKeys (locator,value)`          | 此命令模拟指定元素上的击键事件                               |
| `click (locator)`                   | 此命令可以单击链接，按钮，复选框或单选按钮                   |
| `clickAt (locator,coordString)`     | 此命令可在定位器和坐标的帮助下启用元素的单击                 |
| `doubleClick (locator)`             | 此命令允许基于指定的元素双击web元素                          |
| `focus (locator)`                   | 它将焦点移动到指定的元素                                     |
| `highlight (locator)`               | 它将指定元素的背景颜色更改为黄色以突出显示，这对于调试目的很有用 |
| `close()`                           | 此命令模拟用户单击弹出窗口或选项卡标题栏中的“关闭”按钮       |
| `store (expression,variableName)`   | 此命令指定要在其中存储结果的变量的名称，`expression`是要存储的值 |
| `waitForCondition (script,timeout)` | 此命令重复执行指定的JavaScript代码段，直到它的计算结果为 true |

##### 2. 访问器

访问器(Accessors)是selenium命令，用于检查应用程序的状态并将结果存储在变量中，它们还用于自动生成断言。

| 命令(语法)                                  | 描述                                        |
| ------------------------------------------- | ------------------------------------------- |
| `storeTitle (variableName)`                 | 此命令获取当前页面的标题                    |
| `storeText (locator, variableName)`         | 此命令获取元素的文本                        |
| storeValue (locator,variableName)           | 此命令获取输入字段的(空白修剪)值            |
| storeTable (tableCellAddress, variableName) | 此命令从表的单元格中获取文本                |
| storeLocation (variableName)                | 此命令获取当前页面的绝对 URL                |
| storeElementIndex (locator, variableName)   | 此命令获取元素与其父元素的相对索引(从0开始) |
| `storeBodyText (variableName)`              | 此命令获取页面的整个文本                    |
| storeAllButtons (variableName)              | 它返回页面上所有按钮的 ID                   |
| storeAllFields (variableName)               | 它返回页面上所有输入字段的 ID               |
| `storeAllLinks (variableName)`              | 它返回页面上所有链接的 ID                   |

##### 3. 断言

断言是使测试人员能够验证应用程序状态的命令。 断言通常用于断言，验证和等待三种模式

| 命令/语法                                      | 描述                                                      |
| ---------------------------------------------- | --------------------------------------------------------- |
| `verifySelected(selectLocator, optionLocator)` | 此命令验证下拉列表的选定选项是否满足`optionSpecifier`     |
| `verifyAlert (pattern)`                        | 此命令验证警报文本; 与`accessorstoreAlert`一起使用        |
| `verifyAllButtons (pattern)`                   | 此命令验证使用`withaccessorstoreAllButtons`的按钮         |
| `verifyAllLinks (pattern)`                     | 此命令验证所有链接; 与`accessorstoreAllLinks`一起使用     |
| `verifyBodyText(pattern)`                      | 此命令验证正文; 与`accessorstoreBodyText`一起使用         |
| `verifyAttribute(attributeLocator, pattern)`   | 此命令验证元素的属性; 与`accessorstoreAttribute`一起使用  |
| `waitForErrorOnNext (message)`                 | 此命令启用等待错误; 与`accessorassertErrorOnNext`一起使用 |
| `waitForAlert (pattern)`                       | 此命令启用等待警报; 与`accessorstoreAlert`一起使用        |
| `verifyAllWindowIds (pattern)`                 | 此命令验证窗口 ID; 与`accessorstoreAllWindowIds`一起使用  |

####  手动创建测试用例

使用 Selenium IDE 中手动创建测试用例 ， 通过插入 selenium 命令而不是记录选项来创建测试用例 

1. 启动Firefox浏览器，单击浏览器右上角的Selenium图标，将启动Selenium IDE的默认界面。输入项目名称为“手动测试”，输入测试用例名称为：搜索测试 。单击“测试脚本编辑器”框中的命令文本框，将第一个命令的属性修改为 命令(Command)：`open`，目标(Target)：https://www.baidu.com。在执行测试用例期间，此命令将在Firefox浏览器上加载百度搜索引擎首页
2. 添加一个命令，单击百度搜索引擎文本框。 需要文本框的唯一标识元素，这将帮助IDE识别目标位置。用于查找唯一标识元素的方法涉及检查HTML代码。 右键单击搜索文本框，然后选择*Inspect Element*  ，选择包含文本框ID名称的*input* 标记元素 。将第二个命令的属性修改为 命令：`click at`，目标：`id=kw`。在执行测试用例期间，此命令将单击百度搜索引擎网页上的搜索文本框
3. 第三个命令使用相同的标识ID，第三个命令将在百度搜索文本框中键入指定的文本。将第三个命令的属性修改为 命令：`type`，目标：`id=kw`，值：`yiibai JavaFX教程`。在执行测试用例期间，此命令将在百度搜索文本框中键入指定的文本
4.  接下来，添加一个命令，该命令将在网页上生成按钮的单击事件。 要生成此事件，需要搜索提交按钮的唯一标识元素 。将第四个命令的属性修改为 命令：`click at`，目标：`id=su`。在执行测试用例期间，此命令将单击百度搜索引擎网页上的搜索按钮
5.  点击IDE的工具栏菜单上的按钮“运行当前测试”。 它将在浏览器上执行所有插入的命令，并提供已执行测试脚本的总体摘要 

####  Selenium IDE定位策略 

 对于大多数Selenium命令，都需要一个目标位置，该位置在Web应用程序的上下文中唯一地定义Web元素 。 在Selenium IDE中，目标使用六种指定特定Web元素位置的模式 

#####  按标识符定位

标识符之前被用作默认类型，现在不推荐使用，因为WebDriver不支持它。使用标识符，可以使用ID和Name等定位策略。使用具有匹配ID属性的第一个元素，如果没有元素具有匹配的ID属性，则使用具有匹配`name`属性的第一个元素。例如，`id=login`(可以是ID或Name)

##### 按ID元素定位

##### 按名称查找

名称(name)定位器类型将定位具有匹配名称属性的第一个元素，也就是说，如果页面中有多个相同名称的元素，第一个元素之后的元素无效。 例如，`name=username` 

```php+HTML
<?php
    if($_POST){
        $username = isset($_POST['username'])? trim($_POST['username']):'';
        $password = isset($_POST['password'])? trim($_POST['password']):'';
        if($username=='yiibai' && $password = '123456'){
            echo "<p>您好，{$username} !</p>";
        }
    }
    ?>
  <form id="loginForm" method="POST">
   <input name="username" type="text" class="form-control" id="username" placeholder="UserName"/>
   <input name="password" type="password" class="form-control" id="password" placeholder="Password"/>
   <input name="continue" type="submit" id="continue" class="btn" value="登录" />
  </form>
```

 创建一个登录测试 

| Command  | Target         | Value  |
| -------- | -------------- | ------ |
| open     | http:localhost |        |
| click at | name=username  |        |
| type     | name=username  | yiibai |
| click at | name=password  |        |
| type     | name=password  | 123456 |
| click at | name=continue  |        |

##### 通过XPath定位 				 				 				 			

XPath是一种用于在XML文档中定位节点的语言。当没有适合要查找的元素的`id`或`name`属性时，可以使用XPath作为替代。XPath提供了以下定位策略：XPath 绝对和 XPath属性。

XPath Absolute 使用户能够提及从根HTML标记到特定元素的完整XPath位置。建议不要这样做，因为它需要完整的XPath位置，如果Web元素的位置发生更改或者属于其他父级，则XPath将无法找到所需的元素

```
语法：`//html/body/tag1[index]/tag2[index]/.../tagN[index]`
示例：`//html/body/div[2]/div/div[2]/div/div/div/fieldset/form/div[1]/input[1]`
```

创建一个登录测试 

| Command  | Target        | Value     |
| -------- | ------------- | --------- |
| open     | /             | localhost |
| click at | name=username |           |
| type     | name=username | yiibai    |
| click at | name=password |           |
| type     | name=password | 123456    |
| click at | name=continue |           |

如果没有适合要查找的元素的`id`或`name`属性，则始终建议使用 XPath 属性。XPath属性允许使用不同的属性定位Web元素。

```
语法：`//htmltag[@attribute1='value1' and @attribute2='value2']`
示例：`//input[@id='passwd' and @placeholder='password']`
```

创建另一个登录测试 

| Command  | Target                                       | Value     |
| -------- | -------------------------------------------- | --------- |
| open     | /                                            | localhost |
| click at | //input[@id="username" and @name="username"] |           |
| type     | //input[@id="username" and @name="username"] | yiibai    |
| click at | //input[@id="password" and @name="password"] |           |
| type     | //input[@id="password" and @name="password"] | 123456    |
| click at | //input[@id="continue" and @type="submit"]   |           |

##### 通过CSS定位			 				 				 				 			

CSS 代表 Cascading Style Sheets，它是一种样式表语言，用于描述用标记语言编写的文档的外观和格式。通过 CSS 定位 Web 元素涉及使用 CSS Selector，它基于 HTML 标记、id、类和属性的组合来标识元素。与先前的定位策略相比，通过 CSS Selector 定位Web元素要复杂得多。与XPath一样，CSS也具有查找没有ID，类或名称的元素的功能。CSS Selector以六种模式工作，以识别和定位Web元素。

1.按ID查找

| Command  | Target             | Value     |
| -------- | ------------------ | --------- |
| open     | /                  | localhost |
| click at | css=input#username |           |
| type     | css=input#username | yiibai    |
| click at | css=input#password |           |
| type     | css=input#password | 123456    |
| click at | css=input#continue |           |

2.按类定位

| Command  | Target                 | Value     |
| -------- | ---------------------- | --------- |
| open     | /                      | localhost |
| click at | css=input.form-control |           |
| type     | css=input.form-control | yiibai    |
| click at | css=input#password     |           |
| type     | css=input#password     | 123456    |
| click at | css=input#continue     |           |

3.按属性定位

| Command  | Target                     | Value     |
| -------- | -------------------------- | --------- |
| open     | /                          | localhost |
| click at | css=input[name='username'] |           |
| type     | css=input[name='username'] | yiibai    |
| click at | css=input[name='password'] |           |
| type     | css=input[name='password'] | 123456    |
| click at | css=input[name='continue'] |           |

4.按ID/类和属性定位

属性值表示在使用特定属性时正在访问的值。还可以添加两个以上的属性来定位所需的Web元素。 例如，`css=input#Passwd[type='password'][name='Passwd']`

| Command  | Target                                                       | Value     |
| -------- | ------------------------------------------------------------ | --------- |
| open     | /                                                            | localhost |
| click at | css=input#username[name='username']\[placeholder='UserName'] |           |
| type     | css=input#username[name='username']\[placeholder='UserName'] | yiibai    |
| click at | css=input#password[name='password']\[placeholder='Password'] |           |
| type     | css=input#password[name='password']\[placeholder='Password'] | 123456    |
| click at | css=input[name='continue']                                   |           |

5.按子字符串定位

Selenium允许匹配部分字符串以定位特定的Web元素。有三种机制可以使用CSS Selector完成字符串的匹配：匹配前缀、匹配后缀和匹配子字符串

例如，上面本地的登录页面的“密码”文本框定义CSS选择器:`css=input#password[name^='pass']`，`^` 是使用前缀匹配字符串的符号表示法。密码”文本框定义CSS选择器：`css=input#password[name$='ord']`，`$`是使用后缀匹配字符串的符号表示法。“密码”文本框定义CSS选择器：`css=input#password[name*='word']`，`*` 是使用子字符串匹配字符串的符号表示法

6.按内部文本定位

内部文本是HTML标记在网页上显示的字符串模式。例如，要测验登录页面的“登录”提交按钮定义CSS选择器定位如下：`css=button:contains("Login")`

##### 按DOM定位

### Selenium WebDriver

Selenium WebDriver是Selenium Tool套件中最重要的组件。 最新版本“Selenium 2.0”与WebDriver API集成，提供更简单，更简洁的编程接口。Selenium WebDriver最初作为Selenium v2.0的一部分推出。 Selenium的初始版本即Selenium v1仅由IDE，RC和Grid组成。 但是，随着Selenium v3的发布，RC已被弃用并转移到旧版程序包。在WebDriver中，可以使用任何支持的编程语言开发测试脚本，并且可以在大多数现代Web浏览器中直接运行。WebDriver支持的语言包括C#，Java，Perl，PHP，Python和Ruby

![163641_66048](E:\我的电脑\图片\学习\测试\163641_66048.png)

#### WebDriver 架构

Selenium WebDriver API提供编程语言和浏览器之间的通信工具，WebDriver架构有四个基本组件

- Selenium语言绑定/Selenium客户端库

  Selenium开发人员已经构建了语言绑定/Selenium客户端库以支持多种语言。 例如，如果要在java中使用浏览器驱动程序，请使用java绑定	

- JSON有线协议

  JSON(JavaScript Object Notation)是一种用于在Web上交换数据的开放标准。 它支持对象和数组等数据结构。 因此，从JSON编写和读取数据很容易。JSON Wire Protocol提供了一种在服务器和客户端之间传输数据的传输机制，是各种REST Web服务的行业标准

- 浏览器驱动

  Selenium使用特定于每个浏览器的驱动程序，以便与浏览器建立安全连接，而不会泄露浏览器功能的内部逻辑。 浏览器驱动程序也特定于用于自动化的语言，如 Java，C# 等。当使用 WebDriver 执行测试脚本时，将在内部执行以下操作：

  - 生成 HTTP 请求并将其发送到每个 Selenium 命令的浏览器驱动程序。
  - 驱动程序通过 HTTP 服务器接收 HTTP 请求。
  - HTTP Server 决定执行在浏览器上执行的指令的所有步骤。
  - 执行状态将发送回 HTTP Server，随后将其发送回自动化脚本

- 真正的浏览器

  Selenium WebDriver支持的浏览器：Internet Explorer、Mozilla Firefox、Google Chrome 和 Safari

#### 功能特性

- 多浏览器支持 ：Selenium WebDriver支持各种Web浏览器，如 Firefox，Chrome，Internet Explorer，Opera 等等。它还支持一些非传统或罕见的浏览器，如 HTMLUnit

- 多编程语言支持：WebDriver 还支持大多数常用的编程语言，如 Java，C#，JavaScript，PHP，Ruby，Pearl 和Python。 因此，用户可以基于自己的能力选择任何一种受支持的编程语言并开始构建测试脚本

- 速度：与 Selenium Suite 的其他工具相比，WebDriver 的执行速度更快。与 RC 不同，它不需要任何中间服务器与浏览器通信，此工具直接与浏览器通信

- 简单命令：Selenium WebDriver 中使用的大多数命令都易于实现。 例如，要使用以下命令在WebDriver中启动浏览器

  ```java
  WebDriver driver = new FirefoxDriver(); 			// (Firefox浏览器)
  WebDriver driver = new ChromeDriver(); 			// (Chrome浏览器)
  WebDriver driver = new InternetExplorerDriver(); 			// (Internet Explorer浏览器)
  ```

- WebDriver方法和类 ：WebDriver 提供多种解决方案来应对自动化测试中的一些潜在挑战。WebDriver 还允许测试人员通过动态查找器处理复杂类型的 Web 元素，如复选框，下拉列表和警报

#### WebDriver 和 RC 的差别

1. 架构：Selenium RC的体系结构很复杂，因为它使用中间RC Server与浏览器进行通信。 RC Server最初在运行测试脚本之前安装，并充当Selenium命令和浏览器之间的中介。与Selenium RC相比，Selenium WebDriver的架构更简单，浏览器直接从OS(操作系统)级别控制。 在WebDriver上运行测试脚本的基本要求是：IDE(集成开发环境)，支持任何受支持的编程语言，如Java，C#等；用于执行测试脚本生成的指令的浏览器
2. 速度：Selenium WebDriver 比 Selenium RC执行速度更快，因为它可以直接与浏览器交互，而无需使用任何外部代理服务器。 另一方面，Selenium RC 使用中间RC服务器与浏览器进行通信。在 Selenium RC 中执行测试脚本比 WebDriver需要更多时间，因为它使用 JavaScript 命令作为浏览器的指令
3. 面向对象：Selenium WebDriver 纯粹是面向对象的 API，而 WebDriver完全基于面向对象的编程语言，如Java，C#等
4.  测试移动应用程序：Selenium WebDriver 支持 iOS(iOS，Windows Mobile和Android)等移动应用程序的 OS(操作系统)。 另一方面，Selenium RC 不支持移动应用程序的测试
5. 浏览器支持：Selenium WebDriver 还支持无头 HTMLUnit浏览器(Invisible Browser)，Selenium RC 不支持无头 HTMLUnit 浏览器，因为它需要真正的浏览器才能使用。注意 HTMLUnit是一个不可见的浏览器，它有助于更快地执行测试，因为它没有时间等待页面元素加载

当在Selenium RC中执行测试脚本时，将在内部执行以下操作：服务器将称为 Selenium Core 的 JavaScript程序注入浏览器。随后，Selenium Core 将开始从 RC Server 接收指令(Selenium命令)。收到所有指令后，Selenium Core 将作为 JavaScript 命令执行它们，这些JavaScript命令充当浏览器的指令。浏览器将执行Selenium Core提供的所有指令，并将总体摘要返回给服务器。 此总体摘要充当最终结果，显示在用户屏幕上

#### 安装过程

- 下载并安装Java 8或更高版本
- 下载并配置Eclipse（建议 Eclipse IDE for Java Developers）或选择其它Java IDE
- 下载Selenium WebDriver Java客户端
- 配置Selenium WebDriver：在Eclipse中创建一个新的Java项目并加载所有必要的jar文件，以便创建Selenium Test Scripts
  1. 启动Eclipse IDE，点击 *File* -> *New* -> *Java Project* 创建一个新的Java Project。将项目名称设为“Demo_Test”，保持其他字段不变，然后单击“完成”按钮；
  2. 键单击*“src”* 文件夹，然后从 *New* -> *Class* 创建一个新的类文件。将类名称命名为*“FirstTestCase”* ，然后单击“完成”按钮；
  3. 右键单击“Demo_Test”文件夹，然后选择“Properties”，单击左侧面板中的*“Java Build Path”* 选项。切换到*Libraries* 选项卡，然后单击*“Add External JARs”* 按钮。找到已下载*Selenium jar* 文件的目录，选择相应的jar并单击“打开”按钮（两个 jar 包和 libs目录下的 jar 包）。获得*Libraries* 选项卡中的所有*Selenium jar* 文件后，单击*Apply and Close* 按钮

#### 常用命令 

```java
driver.navigate().back();			// 在浏览器历史记录中向后导航
driver.navigate().forward();			// 在浏览器历史记录中向前导航
driver.navigate().refresh();			// 刷新/重新加载网页
driver.switchTo().window("windowName");			// 在Windows之间移动
driver.switchTo().frame("frameName");			// 在 frame 之间移动
```

一个测试网页：已放于 E:\file\test 目录下

要在Selenium中调用浏览器，必须下载特定于该浏览器的可执行文件。 例如，Chrome浏览器使用名为`ChromeDriver.exe` 的可执行文件实现WebDriver协议。 这些可执行文件在您的系统上启动服务器，而该服务器又负责在Selenium中运行测试脚本

```java
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver; 			// 引用实例化新Web浏览器所需的WebDriver接口
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.openqa.selenium.remote.DesiredCapabilities;  
import org.openqa.selenium.support.ui.Select; 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxBinary;			// 这两个好像没用到
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;
// 引用将 Chrome 专用驱动程序实例化到WebDriver类实例化的浏览器所需的ChromeDriver类
import org.openqa.selenium.chrome.ChromeDriver;
public class Second {  
    public static void main(String[] args) { 
        System.setProperty("webdriver.gecko.driver", "E:\\file\\resources\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = (WebDriver) new FirefoxDriver();
        // 使用 DesiredCapabilities 初始化
        System.setProperty("webdriver.gecko.driver", "D:\\software\\WebDriver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();  
        capabilities.setCapability("marionette",true);  
        WebDriver driver= new FirefoxDriver(capabilities);
        // 使用 marionette 属性初始化，此方法不需要 DesiredCapabilities 的代码
     System.setProperty("webdriver.firefox.marionette","D:\\software\\webdriver\\geckodriver.exe");
        // 使用Firefox选项，Firefox 47或更高版本将 marionette 驱动程序作为遗留系统
        FirefoxOptions options = new FirefoxOptions();  
	    options.setLegacy(true);
        // Chrome浏览器
        System.setProperty("webdriver.chrome.driver", "E:\\file\\resources\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        // IE 浏览器
        System.setProperty("webdriver.ie.driver", "D:\\IE Driver Server\\IEDriverServer.exe");  
	    WebDriver driver=new InternetExplorerDriver();
        driver.get("http://www.baidu.com/"); 
        // 或者 driver.navigate().to("http://www.baidu.com/");，需要绝对地址
        String titile = driver.getTitle();
        System.out.println("title is => " + titile);
        driver.findElement(By.id("kw")).sendKeys("易百教程");  		// 点击搜索框并输入"易百教程"
        driver.findElement(By.id("su")).click(); 			// 点击搜索按钮
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // driver.quit();			关闭浏览器和与驱动程序关联的其他所有其他窗口
        driver.navigate().to("file:///E:/file/test/testing.html"); 
        driver.manage().window().maximize();			// 最大化浏览器窗口
        // 获取通过任何web元素写入的数据和在控制台输出
        String sampleText = driver.findElement(By.className("col-md-12")).getText();  
        System.out.println(sampleText);   
        driver.findElement(By.linkText("This is a link")).click();		// 通过链接文本定位
        driver.findElement(By.id("fname")).sendKeys("JavaTpoint");  
        driver.findElement(By.id("fname")).clear();			// 从文本框中清除用户输入
        driver.findElement(By.id("idOfButton")).click();  
        driver.findElement(By.id("male")).click();  
        driver.findElement(By.cssSelector("input.Automation")).click(); // 点击通过 CSS 选择器标识的元素
        // 使用选择器类来选择值
        WebElement testDropDown = driver.findElement(By.id("testingDropdown"));
        Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));  
        dropdown.selectByIndex(5);			// 根据索引选择一个选项，从0开始
        dropdown.selectByValue("Database");			// 根据“value” 属性选择一个选项
        dropdown.selectByVisibleText("Automation Testing");			// 根据选项上的文本选择选项
        // 拖和放？
        WebElement from = driver.findElement(By.id("sourceImage"));   
        WebElement to = driver.findElement(By.id("targetDiv"));
        Actions act = new Actions(driver);   
        act.dragAndDrop(from,to).build().perform();			
        // 警告框
        driver.findElement(By.linkText("Generate Alert Box")).click();  
        Alert alert = (Alert) driver.switchTo().alert();			// 获取当前页面上的警告框
        alert.getText();			// 捕获警报消息
        alert.sendKeys("Text");			// 数据发送到警报框
        alert.accept();			// 单击警报的“确定”按钮
        driver.findElement(By.linkText("Generate Confirm Box")).click();  
        Alert confirmBox = (Alert) driver.switchTo().alert();			 
        ((Alert) confirmBox).dismiss();			// 单击警报的“取消”按钮
        // 滚动
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, 100)");			// 向下滚动100像素浏览网页
        driver.close();			// 关闭浏览器
    }  
}
```

Gecko Driver是Selenium和Firefox浏览器中测试之间的链接。 它充当W3C WebDriver兼容客户端(Eclipse，Netbeans等)之间的代理，以与基于Gecko的浏览器(Mozilla Firefox)进行交互。要执行复杂的用户交互，例如拖放，可以使用`Actions`类。首先构建一系列复合事件，然后使用 Action(一个代表单个用户交互的接口)执行它。 

`clickAndHold(WebElement element)`单击中间的Web元素(不释放)；`moveToElement(WebElement element)`将鼠标指针移动到web元素的中间而不单击；`release(WebElement element)`释放左键单击(处于按下状态)；`build()`生成复合动作

#### 定位策略 

与Selenium IDE一样，WebDriver使用相同的定位策略集来指定特定Web元素的位置。因为，正在使用带有Java的WebDriver; 每个定位策略在Java中都有自己的命令来定位 Web 元素

- 按ID定位策略：`driver.findElement(By.id("fname")).sendKeys("Yiibai");`

- 按名称查找策略：`driver.findElement(By.id("idOfButton")).click();`

- 按类名定位策略：`driver.findElement(By.className("Automation")).click();`

- 按标签名称定位策略：`driver.findElement(By.tagName("button")).click();`

- 通过链接文本定位策略：`driver.findElement(By.linkText("Link to Yiibai")).click();`

- 通过部分链接文本定位策略：`driver.findElement(By.partialLinkText("Link to")).click();`

- 通过CSS定位策略

  - 标签和ID：`driver.findElement(By.cssSelector("input#fname"));`

  - 标签和Class：`driver.findElement(By.cssSelector("input.Automation"));`

  - 标签和属性：`driver.findElement(By.cssSelector("input[id=fname]"));`

  - 标签，类和属性

    ?

  - 子串匹配
    以(^)开头 ：`driver.findElement(By.cssSelector("input[id^='fna']"));`

    以($)结尾 ：`driver.findElement(By.cssSelector("input[id$='me']"));`

    包含(*) ：`driver.findElement(By.cssSelector("input[id='nam']"));`或者 `driver.findElement(By.cssSelector("input:contains('nam')"))`

- 通过 XPath 定位策略

  当没有适合要查找的元素的`id`或`name`属性时，可以使用XPath作为替代。XPath允许选择单个元素，属性和XML文档的其他部分，以指定特定Web元素的位置

  - 使用单斜杠：单斜杠机制也称为使用绝对 XPath 查找元素，单斜杠用于创建具有绝对XPath的XPath，即将创建XPath 以从文档节点/开始节点/父节点开始选择findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div[1]/div/div/input[1]"));

  - 使用双斜杠：双斜线机制也称为使用Relative XPath查找元素。 双斜杠用于创建具有相对路径的XPath，即创建XPath以从文档中的任何位置开始选择，在整个页面(DOM)中搜索前面的字符串。`findElement(By.xpath("//form/div[1]/div/div[1]/div/div/input[1]"));`

  - 通过单属性：在浏览器上右击需要定位的元素，点击检查，再右击突出显示的代码，选择 “Copy” -> “XPath”，例如`//*[@id="kw"]`（百度搜索框），双斜杠后的`*`用于匹配任何带有所需文本的标签

    `findElement(By.xpath("//*[@id="lst-ib"]"));`

  - 通过多属性：`findElement(By.xpath("//*[@id='lst-ib'][@class='gsfi lst-d-f']"));`

  - 使用And：`findElement(By.xpath("//*[@id='lst-ib' and @class='gsfi lst-d-f']"));`

  - 使用Or：`findElement(By.xpath("//*[@id='lst-ib' or @class='gsfi lst-d-f']"));`

  - 使用 contains()：`findElement(By.xpath("//*[contains(@id,'lst-ib')]"));`

  - 使用 starts-with()：`findElement(By.xpath("//*[starts-with(@id,'lst')]"));`

  - 使用 text()：`findElement(By.xpath("//*[text()='Google offered in')]"));`

  - 使用 last()：`last()`方法从存在的所有输入元素中选择最后一个元素(提到类型)

    `findElement(By.xpath("(//input[@type='text'])[last()]"))`

    