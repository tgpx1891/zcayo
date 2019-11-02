PHP （全称：PHP：Hypertext Preprocessor，即"PHP：超文本预处理器"）是一种创建动态交互性站点的强有力的服务器端脚本语言，PHP 代码在服务器上执行，结果以纯 HTML 形式返回给浏览器。

## PHP 语法

PHP 脚本可以放在文档中的任何位置，以 **<?php** 开始，以 **?>** 结束，文件的默认文件扩展名是 ".php"，每个代码行都必须以分号结束

```php+HTML
<!DOCTYPE html>
<html>
<body>
<?php
// 这是 PHP 单行注释
/*
这是
PHP 多行
注释
*/
$x=5;
$y=6;
$z=$x+$y;
echo $z;
echo "Hello World!";
?>
</body>
</html>
```

### PHP 变量

变量以 $ 符号开始，后面跟着变量的名称；必须以字母或者下划线字符开始；只能包含字母数字字符以及下划线（A-z、0-9 和 _ ）；不能包含空格；区分大小写的（$y 和 $Y 是两个不同的变量）。PHP 没有声明变量的命令，变量在您第一次赋值给它的时候被创建。PHP 是一门弱类型语言。在上面的实例中，我们注意到，不必向 PHP 声明该变量的数据类型。PHP 会根据变量的值，自动把变量转换为正确的数据类型。在强类型的编程语言中，我们必须在使用变量前先声明（定义）变量的类型和名称

#### 全局变量和局部变量

在所有函数外部定义的变量，拥有全局作用域。全局变量可以被脚本中的任何部分访问但是不能被函数访问，要在一个函数中访问一个全局变量，需要使用 global 关键字。在 PHP 函数内部声明的变量是局部变量，仅能在函数内部访问。PHP 将所有全局变量存储在一个名为 $GLOBALS[*index*] 的数组中。 *index* 保存变量的名称。这个数组可以在函数内部访问，也可以直接用来更新全局变量

```php
<?php
$x=5; // 全局变量
$z=10;
function myTest()
{
    $y=10; // 局部变量
    echo "变量 x 为: $x<br>";  // 不能被访问
    echo "变量 y 为: $y";
} 
function myTest1()
{
    global $x,$z;  // 或者用另一种方式 $GLOBALS['z']=$GLOBALS['x']+$GLOBALS['z'];
    $z=$x+$z;
}
myTest();
echo "变量 x 为: $x<br>";
echo "变量 y 为: $y";  // 不能被访问
myTest1();
echo $z; // 输出 15
?>
```

当一个函数完成时，它的所有变量通常都会被删除。然而，有时候您希望某个局部变量不要被删除。要做到这一点，请在您第一次声明变量时使用 **static** 关键字，但是该变量仍然是函数的局部变量

```php
<?php
function myTest($x)   //局部变量
{
    static $y=0;   //静态变量
    echo $y;
    $y++;
    echo PHP_EOL;    // 换行符
}
myTest(5);
myTest(5);
?>
```

#### 超级全局变量

超级全局变量在PHP 4.1.0之后被启用, 是PHP系统中自带的变量，在一个脚本的全部作用域中都可用，不需要特别说明，就可以在函数及类中使用

PHP 超级全局变量列表

- $GLOBALS：是一个包含了全部变量的全局组合数组。变量的名字就是数组的键
- $_SERVER：是一个包含了诸如头信息(header)、路径(path)、以及脚本位置(script locations)等等信息的数组。这个数组中的项目由 Web 服务器创建。不能保证每个服务器都提供全部项目；服务器可能会忽略一些，或者提供一些没有在这里列举出来的项目
- $_REQUEST：用于收集HTML表单提交的数据
- $_POST：被广泛应用于收集表单数据，在HTML form标签的指定该属性："method="post"
- $_GET：同样被广泛应用于收集表单数据，在HTML form标签的指定该属性："method="get"，也可以收集URL中发送的数据
- $_FILES
- $_ENV
- $_COOKIE
- $_SESSION

```php
<?php 
$x = 75; 
$y = 25;
function addition() 
{ 
    $GLOBALS['z'] = $GLOBALS['x'] + $GLOBALS['y']; 
}
addition(); 
echo $z;         //z 是一个 $GLOBALS 数组中的超级全局变量，该变量同样可以在函数外访问
// 以下实例中展示了如何使用$_SERVER中的元素
echo $_SERVER['PHP_SELF']."<br>";         // /try/demo_source/demo_global_server.php
echo $_SERVER['SERVER_NAME']."<br>";         // www.runoob.com
echo $_SERVER['HTTP_HOST']."<br>";         // www.runoob.com
echo $_SERVER['HTTP_REFERER']."<br>";              
// https://www.runoob.com/try/showphp.php?filename=demo_global_server
echo $_SERVER['HTTP_USER_AGENT']."<br>";                // Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36
echo $_SERVER['SCRIPT_NAME']."<br>";         // /try/demo_source/demo_global_server.php
?>
```

下表列出了$_SERVER 变量中的重要元素

| 元素/代码                | 描述                                                         |
| :----------------------- | :----------------------------------------------------------- |
| $_SERVER['PHP_SELF']     | 当前执行脚本的文件名，与 document root 有关。例如，在地址为 http://example.com/test.php/foo.bar 的脚本中使用 $_SERVER['PHP_SELF'] 将得到 /test.php/foo.bar。\__FILE\_ 常量包含当前(例如包含)文件的完整路径和文件名。 从 PHP 4.3.0 版本开始，如果 PHP 以命令行模式运行，这个变量将包含脚本名。之前的版本该变量不可用 |
| $_SERVER['SERVER_NAME']  | 当前运行脚本所在的服务器的主机名。如果脚本运行于虚拟主机中，该名称是由那个虚拟主机所设置的值决定。(如: www.runoob.com) |
| $_SERVER['HTTP_HOST']    | 当前请求头中 Host: 项的内容，如果存在的话。                  |
| $_SERVER['HTTP_REFERER'] | 引导用户代理到当前页的前一页的地址（如果存在）。由 user agent 设置决定。并不是所有的用户代理都会设置该项，有的还提供了修改 HTTP_REFERER 的功能。简言之，该值并不可信 |
| $_SERVER['HTTP_ACCEPT']  | 当前请求头中 Accept: 项的内容，如果存在的话                  |
| $_SERVER['SCRIPT_NAME']  | 包含当前脚本的路径。这在页面需要指向自己时非常有用。\__FILE\__ 常量包含当前脚本(例如包含文件)的完整路径和文件名 |

当用户点击链接 "Test $GET", 参数 "subject" 和 "web" 将发送至"test_get.php",你可以在 "test_get.php" 文件中使用 $_GET 变量来获取这些数据

```php+HTML
<html>
<body>
<form method="post" action="<?php echo $_SERVER['PHP_SELF'];?>">     <!-- 或者 method="post" -->
Name: <input type="text" name="fname">
<input type="submit">
</form>
<?php 
$name = $_REQUEST['fname'];          // 或者 $name = $_POST['fname'];  
echo $name; 
?>
<a href="test_get.php?subject=PHP&web=runoob.com">Test $GET</a>
<!-- 以下为 test_get.php 包含的内容 -->
<?php 
echo "Study " . $_GET['subject'] . " @ " . $_GET['web'];
?>
</body>
</html>
```

#### 魔术常量

PHP 向它运行的任何脚本提供了大量的预定义常量。不过很多常量都是由不同的扩展库定义的，只有在加载了这些扩展库时才会出现，或者动态加载后，或者在编译时已经包括进去了。有八个魔术常量它们的值随着它们在代码中的位置改变而改变。例如 \__LINE\__的值就依赖于它在脚本中所处的行来决定。这些特殊的常量不区分大小写

-  \__LINE\__ ：文件中的当前行号
- \__FILE\__：文件的完整路径和文件名。如果用在被包含文件中，则返回被包含的文件名。自 PHP 4.0.2 起，\__FILE\__ 总是包含一个绝对路径（如果是符号连接，则是解析后的绝对路径），而在此之前的版本有时会包含一个相对路径
- \__DIR\__：文件所在的目录。如果用在被包括文件中，则返回被包括的文件所在的目录。它等价于 dirname(\__FILE\__)。除非是根目录，否则目录中名不包括末尾的斜杠。（PHP 5.3.0中新增）
- \__FUNCTION\__：函数名称（PHP 4.3.0 新加）。自 PHP 5 起本常量返回该函数被定义时的名字（区分大小写），在 PHP 4 中该值总是小写字母的
- \_CLASS\_：类的名称（PHP 4.3.0 新加）。自 PHP 5 起本常量返回该类被定义时的名字（区分大小写），在 PHP 4 中该值总是小写字母的。类名包括其被声明的作用区域（例如 Foo\Bar）。注意自 PHP 5.4 起 \_CLASS\__ 对 trait 也起作用。当用在 trait 方法中时，\__CLASS\__ 是调用 trait 方法的类的名字
- \__TRAIT\__：Trait 的名字（PHP 5.4.0 新加）。自 PHP 5.4.0 起，PHP 实现了代码复用的一个方法，称为 traits。Trait 名包括其被声明的作用区域（例如 Foo\Bar）
- \__METHOD\__：类的方法名（PHP 5.0.0 新加）。返回该方法被定义时的名字（区分大小写）
- \__NAMESPACE\__：当前命名空间的名称（区分大小写）。此常量是在编译时定义的（PHP 5.3.0 新增）

注：变量的名称中的下划线应为两个

```php
<?php
echo '这是第 " '  . __LINE__ . ' " 行';         // 这是第 “ 2 ” 行
echo '该文件位于 " '  . __FILE__ . ' " ';         // 该文件位于 “ E:\wamp\www\test\index.php ”
echo '该文件位于 " '  . __DIR__ . ' " ';         // 该文件位于 “ E:\wamp\www\test ”
echo '命名空间为："', __NAMESPACE__, '"';         // 输出 "MyProject"
function test() {
    echo  '函数名为：' . __FUNCTION__ ;         // 函数名为：test
}
function test() {
    echo  '函数名为：' . __METHOD__ ;         // 函数名为：test
}
class test {
    function _print() {
        echo '类名为：'  . __CLASS__ . "<br>";
        echo  '函数名为：' . __FUNCTION__ ;
    }
}
$t = new test();
$t->_print();         // 调用类中的函数
/* 结果
类名为：test
函数名为：_print
*/
?>
```

从基类继承的成员被插入的 SayWorld Trait 中的 MyHelloWorld 方法所覆盖，优先顺序是当前类中的方法会覆盖 trait 方法，而 trait 方法又会覆盖了基类中的方法

```php
<?php
class Base {
    public function sayHello() {
        echo 'Hello ';
    }
}
trait SayWorld {
    public function sayHello() {
        parent::sayHello();
        echo 'World!';
    }
}
class MyHelloWorld extends Base {
    use SayWorld;
}
$o = new MyHelloWorld();
$o->sayHello();
?>
// 结果为 Hello World!
```

### echo/print

有两种在浏览器输出文本的基础指令：echo 和 print，字符串可以包含 HTML 标签。echo 可以输出一个或多个字符串， 输出的速度比 print 快，没有返回值；print 只允许输出一个字符串，返回值总为 1。echo 是一个语言结构，使用的时候可以不用加括号，也可以加上括号： echo 或 echo()；print 同样是一个语言结构，可以使用括号，也可以不使用括号： print 或 print()

```php
<?php
$txt1="学习 PHP";
$txt2="RUNOOB.COM";
$cars=array("Volvo","BMW","Toyota");
echo "<h2>PHP 很有趣!</h2>";
echo "Hello world!<br>";
echo "这是一个", "字符串，", "使用了", "多个", "参数。";  // 中间无空格
echo $txt1;
echo "<br>";
echo "在 $txt2 学习 PHP<br>";
echo "我车的品牌是 {$cars[0]}";
?>
```

使用 print 的格式跟上面差不多。echo 和 print 都不会自动换行

#### EOF(heredoc) 使用

PHP EOF(heredoc)是一种在命令行 shell（如sh、csh、ksh、bash、PowerShell 和 zsh）和程序语言（像Perl、PHP、Python 和 Ruby）里定义一个字符串的方法

使用概述：

1. EOF 可以用任意其它字符代替，只需保证结束标识与开始标识一致。比如常用大写的 **EOT、EOD、EOF** 来表示，但是不只限于那几个(也可以用：JSON、HTML等)，只要保证开始标记和结束标记不在正文中出现即可
2. 以 **<<<EOF** 开始标记开始，以 **EOF** 结束标记结束，结束标记必须顶头写，不能有缩进和空格，且在结束标记末尾要有分号
3. 开始标识可以不带引号或带单双引号，不带引号与带双引号效果一致，解释内嵌的变量和转义符号，带单引号则不解释内嵌的变量和转义符号。
4. 当内容需要内嵌引号（单引号或双引号）时，不需要加转义符，本身对单双引号转义，此处相当与 q 和 qq 的用法。位于开始标记和结束标记之间的变量可以被正常解析，但是函数则不可以。在 heredoc 中，变量不需要用连接符 **.** 或 **,** 来拼接

```php
<?php
echo <<<EOF
    <h1>我的第一个标题</h1>
    <p>我的第一个段落。</p>
EOF;
// 结束需要独立一行且前后不能空格
$name="runoob";
$a= <<<EOF
    "abc"$name   //变量不需要用连接符 . 或 , 来拼接
    "123"
EOF;
echo $a;
?>
```

### PHP 数据类型

String（字符串）, Integer（整型）, Float（浮点型）, Boolean（布尔型）, Array（数组）, Object（对象）, NULL（空值）

整数没有小数点，可以用三种格式来指定：十进制， 十六进制（ 以 0x 为前缀）或八进制（前缀为 0）。

```php
<?php 
$x = "Hello world!";         // 字符串
$x = 5985;         // 整型
var_dump($x);         // var_dump() 函数返回变量的数据类型和十进制值，结果为 int(5985)
echo "<br>"; 
$x = 0x8C;         // 十六进制数
var_dump($x);         // int(140)
$x = 10.365;         // 浮点型
var_dump($x);         // 结果为 float(10.365)
var_dump(2.4e3);         // 结果为 float(2400)
var_dump(8E-5);         // 结果为 float(8.0E-5)
$x=true;         // 布尔类型
$cars=array("Volvo","BMW","Toyota");   // 数组
var_dump($cars);
// 输出结果 array(3) { [0]=> string(5) "Volvo" [1]=> string(3) "BMW" [2]=> string(6) "Toyota" }
$x=null;         // 可以通过设置变量值为 NULL 来清空变量数据
var_dump($x);         // 结果为 NULL
```

对象数据类型也可以用于存储数据，必须使用 class 关键字声明类对象。类是可以包含属性和方法的结构。在类中定义数据类型，然后在实例化的类中使用数据类型

```php
<?php
class Car
{
  var $color;
  function __construct($color="green") {
    $this->color = $color;         // 关键字 this 就是指向当前对象实例的指针，不指向任何其他对象或类
  }
  function what_color() {
    return $this->color;
  }
}
?>
```

松散比较：使用两个等号 **==** 比较，只比较值，不比较类型；严格比较：用三个等号 **===** 比较，除了比较值，也比较类型

```php
<?php
if(42 == "42") {
    echo '1、值相等';
}
echo PHP_EOL;
if(42 === "42") {
    echo '2、类型相等';
} else {
    echo '3、不相等';
}
?>
/*
1、值相等
3、不相等 
*/
```

 比较 0、false、null

```
0 == false: bool(true)
0 === false: bool(false)
0 == null: bool(true)
0 === null: bool(false)
false == null: bool(true)
false === null: bool(false)
"0" == false: bool(true)
"0" === false: bool(false)
"0" == null: bool(false)         // 将 NULL 转换为 ""
"0" === null: bool(false)
"" == false: bool(true)
"" === false: bool(false)
"" == null: bool(true)
"" === null: bool(false)
```

gettype()、empty()、is_null()、isset()：isset() 函数用于检测变量是否已设置并且非 NULL、boolean:if($x)

常量值被定义后，在脚本的其他任何地方都不能被改变，在整个脚本中**都可以**使用。一个常量由英文字母、下划线、和数字组成,但数字不能作为首字母出现(常量名不需要加 $ 修饰符)。设置常量，使用 define() 函数，函数语法如下

```ph
bool define ( string $name , mixed $value [, bool $case_insensitive = false ] )
```

name：必选参数，常量名称，即标志符；value：必选参数，常量的值；case_insensitive ：可选参数，如果设置为 TRUE，该常量则大小写不敏感。默认是大小写敏感的

```php
<?php
// 区分大小写的常量名
define("GREETING", "欢迎访问 Runoob.com");
echo GREETING;    // 输出 "欢迎访问 Runoob.com"
echo '<br>';
echo greeting;   // 输出 "greeting"
// 不区分大小写的常量名
define("GREETING", "欢迎访问 Runoob.com", true);
echo greeting;  // 输出 "欢迎访问 Runoob.com"
?>
```

#### 字符串变量

```php
<?php
$txt1="Hello world!";
$txt2="What a nice day!";
echo $txt1 . " " . $txt2;         // 并置运算符 (.) 用于把两个字符串值连接起来
echo strlen("Hello world!");         // 返回字符串的长度
echo strpos("Hello world!","world");      // 会返回第一个匹配的字符位置 6。如果未找到匹配，则返回 FALSE
?>
```

##### String 函数

| 函数                                                         | 描述                                                         |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| addcslashes()                                                | 返回在指定的字符前添加反斜杠的字符串。addcslashes("Hello World!","W")，结果为Hello \World! |
| [addslashes()](https://www.runoob.com/php/func-string-addslashes.html) | 返回在预定义的字符前添加反斜杠的字符串。addslashes('What does "yolo" mean?')，What does \"yolo\" mean? |
| [bin2hex()](https://www.runoob.com/php/func-string-bin2hex.html) | 把 ASCII 字符的字符串转换为十六进制值。                      |
| [chop()](https://www.runoob.com/php/func-string-chop.html)   | 移除字符串右侧的空白字符或其他字符。chop("Hello World!","World!")，"Hello " |
| [chr()](https://www.runoob.com/php/func-string-chr.html)     | 从指定 ASCII 值返回字符。                                    |
| [chunk_split()](https://www.runoob.com/php/func-string-chunk-split.html) | 把字符串分割为一连串更小的部分。                             |
| [convert_cyr_string()](https://www.runoob.com/php/func-string-convert-cyr-string.html) | 把字符串由一种 Cyrillic 字符集转换成另一种。                 |
| [convert_uudecode()](https://www.runoob.com/php/func-string-convert-uudecode.html) | 对 uuencode 编码的字符串进行解码。                           |
| [convert_uuencode()](https://www.runoob.com/php/func-string-convert-uuencode.html) | 使用 uuencode 算法对字符串进行编码。                         |
| [count_chars()](https://www.runoob.com/php/func-string-count-chars.html) | 返回字符串所用字符的信息。                                   |
| [crc32()](https://www.runoob.com/php/func-string-crc32.html) | 计算一个字符串的 32 位 CRC（循环冗余校验）。                 |
| [crypt()](https://www.runoob.com/php/func-string-crypt.html) | 单向的字符串加密法（hashing）。                              |
| [echo()](https://www.runoob.com/php/func-string-echo.html)   | 输出一个或多个字符串。                                       |
| [explode()](https://www.runoob.com/php/func-string-explode.html) | 把字符串打散为数组。                                         |
| [fprintf()](https://www.runoob.com/php/func-string-fprintf.html) | 把格式化的字符串写入到指定的输出流。                         |
| [get_html_translation_table()](https://www.runoob.com/php/func-string-get-html-translation-table.html) | 返回 htmlspecialchars() 和 htmlentities() 使用的翻译表。     |
| [hebrev()](https://www.runoob.com/php/func-string-hebrev.html) | 把希伯来（Hebrew）文本转换为可见文本。                       |
| [hebrevc()](https://www.runoob.com/php/func-string-hebrevc.html) | 把希伯来（Hebrew）文本转换为可见文本，并把新行（\n）转换为 `<br>`。 |
| [hex2bin()](https://www.runoob.com/php/func-string-hex2bin.html) | 把十六进制值的字符串转换为 ASCII 字符。                      |
| [html_entity_decode()](https://www.runoob.com/php/func-string-html-entity-decode.html) | 把 HTML 实体转换为字符。                                     |
| [htmlentities()](https://www.runoob.com/php/func-string-htmlentities.html) | 把字符转换为 HTML 实体。                                     |
| [htmlspecialchars_decode()](https://www.runoob.com/php/func-string-htmlspecialchars-decode.html) | 把一些预定义的 HTML 实体转换为字符。                         |
| [htmlspecialchars()](https://www.runoob.com/php/func-string-htmlspecialchars.html) | 把一些预定义的字符转换为 HTML 实体。                         |
| [implode()](https://www.runoob.com/php/func-string-implode.html) | 返回一个由数组元素组合成的字符串。                           |
| [join()](https://www.runoob.com/php/func-string-join.html)   | implode() 的别名。                                           |
| [lcfirst()](https://www.runoob.com/php/func-string-lcfirst.html) | 把字符串中的首字符转换为小写。                               |
| [levenshtein()](https://www.runoob.com/php/func-string-levenshtein.html) | 返回两个字符串之间的 Levenshtein 距离。                      |
| [localeconv()](https://www.runoob.com/php/func-string-localeconv.html) | 返回本地数字及货币格式信息。                                 |
| [ltrim()](https://www.runoob.com/php/func-string-ltrim.html) | 移除字符串左侧的空白字符或其他字符。                         |
| [md5()](https://www.runoob.com/php/func-string-md5.html)     | 计算字符串的 MD5 散列。                                      |
| [md5_file()](https://www.runoob.com/php/func-string-md5-file.html) | 计算文件的 MD5 散列。                                        |
| [metaphone()](https://www.runoob.com/php/func-string-metaphone.html) | 计算字符串的 metaphone 键。                                  |
| [money_format()](https://www.runoob.com/php/func-string-money-format.html) | 返回格式化为货币字符串的字符串。                             |
| [nl_langinfo()](https://www.runoob.com/php/func-string-nl-langinfo.html) | 返回指定的本地信息。                                         |
| [nl2br()](https://www.runoob.com/php/func-string-nl2br.html) | 在字符串中的每个新行之前插入 HTML 换行符。                   |
| [number_format()](https://www.runoob.com/php/func-string-number-format.html) | 通过千位分组来格式化数字。                                   |
| [ord()](https://www.runoob.com/php/func-string-ord.html)     | 返回字符串中第一个字符的 ASCII 值。                          |
| [parse_str()](https://www.runoob.com/php/func-string-parse-str.html) | 把查询字符串解析到变量中。                                   |
| [print()](https://www.runoob.com/php/func-string-print.html) | 输出一个或多个字符串。                                       |
| [printf()](https://www.runoob.com/php/func-string-printf.html) | 输出格式化的字符串。                                         |
| [quoted_printable_decode()](https://www.runoob.com/php/func-string-quoted-printable-decode.html) | 把 quoted-printable 字符串转换为 8 位字符串。                |
| [quoted_printable_encode()](https://www.runoob.com/php/func-string-quoted-printable-encode.html) | 把 8 位字符串转换为 quoted-printable 字符串。                |
| [quotemeta()](https://www.runoob.com/php/func-string-quotemeta.html) | 引用元字符。                                                 |
| [rtrim()](https://www.runoob.com/php/func-string-rtrim.html) | 移除字符串右侧的空白字符或其他字符。                         |
| [setlocale()](https://www.runoob.com/php/func-string-setlocale.html) | 设置地区信息（地域信息）。                                   |
| [sha1()](https://www.runoob.com/php/func-string-sha1.html)   | 计算字符串的 SHA-1 散列。                                    |
| [sha1_file()](https://www.runoob.com/php/func-string-sha1-file.html) | 计算文件的 SHA-1 散列。                                      |
| [similar_text()](https://www.runoob.com/php/func-string-similar-text.html) | 计算两个字符串的相似度。                                     |
| [soundex()](https://www.runoob.com/php/func-string-soundex.html) | 计算字符串的 soundex 键。                                    |
| [sprintf()](https://www.runoob.com/php/func-string-sprintf.html) | 把格式化的字符串写入一个变量中。                             |
| [sscanf()](https://www.runoob.com/php/func-string-sscanf.html) | 根据指定的格式解析来自一个字符串的输入。                     |
| [str_getcsv()](https://www.runoob.com/php/func-string-str-getcsv.html) | 把 CSV 字符串解析到数组中。                                  |
| [str_ireplace()](https://www.runoob.com/php/func-string-str-ireplace.html) | 替换字符串中的一些字符（大小写不敏感）。                     |
| [str_pad()](https://www.runoob.com/php/func-string-str-pad.html) | 把字符串填充为新的长度。                                     |
| [str_repeat()](https://www.runoob.com/php/func-string-str-repeat.html) | 把字符串重复指定的次数。                                     |
| [str_replace()](https://www.runoob.com/php/func-string-str-replace.html) | 替换字符串中的一些字符（大小写敏感）。                       |
| [str_rot13()](https://www.runoob.com/php/func-string-str-rot13.html) | 对字符串执行 ROT13 编码。                                    |
| [str_shuffle()](https://www.runoob.com/php/func-string-str-shuffle.html) | 随机地打乱字符串中的所有字符。                               |
| str_split()                                                  | 把字符串分割到数组中。                                       |
| [str_word_count()](https://www.runoob.com/php/func-string-str-word-count.html) | 计算字符串中的单词数。                                       |
| [strcasecmp()](https://www.runoob.com/php/func-string-strcasecmp.html) | 比较两个字符串（大小写不敏感）。                             |
| strchr()                                                     | 查找字符串在另一字符串中的第一次出现。（strstr() 的别名。）  |
| [strcmp()](https://www.runoob.com/php/func-string-strcmp.html) | 比较两个字符串（大小写敏感）。                               |
| [strcoll()](https://www.runoob.com/php/func-string-strcoll.html) | 比较两个字符串（根据本地设置）。                             |
| [strcspn()](https://www.runoob.com/php/func-string-strcspn.html) | 返回在找到任何指定的字符之前，在字符串查找的字符数。         |
| [strip_tags()](https://www.runoob.com/php/func-string-strip-tags.html) | 剥去字符串中的 HTML 和 PHP 标签。                            |
| [stripcslashes()](https://www.runoob.com/php/func-string-stripcslashes.html) | 删除由 addcslashes() 函数添加的反斜杠。                      |
| [stripslashes()](https://www.runoob.com/php/func-string-stripslashes.html) | 删除由 addslashes() 函数添加的反斜杠。                       |
| stripos()                                                    | 返回字符串在另一字符串中第一次出现的位置（大小写不敏感）。   |
| [stristr()](https://www.runoob.com/php/func-string-stristr.html) | 查找字符串在另一字符串中第一次出现的位置（大小写不敏感）。   |
| [strlen()](https://www.runoob.com/php/func-string-strlen.html) | 返回字符串的长度。                                           |
| [strnatcasecmp()](https://www.runoob.com/php/func-string-strnatcasecmp.html) | 使用一种"自然排序"算法来比较两个字符串（大小写不敏感）。     |
| [strnatcmp()](https://www.runoob.com/php/func-string-strnatcmp.html) | 使用一种"自然排序"算法来比较两个字符串（大小写敏感）。       |
| [strncasecmp()](https://www.runoob.com/php/func-string-strncasecmp.html) | 前 n 个字符的字符串比较（大小写不敏感）。                    |
| [strncmp()](https://www.runoob.com/php/func-string-strncmp.html) | 前 n 个字符的字符串比较（大小写敏感）。                      |
| [strpbrk()](https://www.runoob.com/php/func-string-strpbrk.html) | 在字符串中搜索指定字符中的任意一个。                         |
| [strpos()](https://www.runoob.com/php/func-string-strpos.html) | 返回字符串在另一字符串中第一次出现的位置（大小写敏感）。     |
| [strrchr()](https://www.runoob.com/php/func-string-strrchr.html) | 查找字符串在另一个字符串中最后一次出现。                     |
| [strrev()](https://www.runoob.com/php/func-string-strrev.html) | 反转字符串。                                                 |
| [strripos()](https://www.runoob.com/php/func-string-strripos.html) | 查找字符串在另一字符串中最后一次出现的位置(大小写不敏感)。   |
| [strrpos()](https://www.runoob.com/php/func-string-strrpos.html) | 查找字符串在另一字符串中最后一次出现的位置(大小写敏感)。     |
| [strspn()](https://www.runoob.com/php/func-string-strspn.html) | 返回在字符串中包含的特定字符的数目。                         |
| strstr()                                                     | 查找字符串在另一字符串中的第一次出现（大小写敏感）。         |
| [strtok()](https://www.runoob.com/php/func-string-strtok.html) | 把字符串分割为更小的字符串。                                 |
| [strtolower()](https://www.runoob.com/php/func-string-strtolower.html) | 把字符串转换为小写字母。                                     |
| [strtoupper()](https://www.runoob.com/php/func-string-strtoupper.html) | 把字符串转换为大写字母。                                     |
| [strtr()](https://www.runoob.com/php/func-string-strtr.html) | 转换字符串中特定的字符。                                     |
| [substr()](https://www.runoob.com/php/func-string-substr.html) | 返回字符串的一部分。                                         |
| [mb_substr()](https://www.runoob.com/php/func-string-mb_substr.html) | 返回中文字符串的一部分。                                     |
| [substr_compare()](https://www.runoob.com/php/func-string-substr-compare.html) | 从指定的开始位置（二进制安全和选择性区分大小写）比较两个字符串。 |
| substr_count()                                               | 计算子串在字符串中出现的次数。                               |
| [substr_replace()](https://www.runoob.com/php/func-string-substr-replace.html) | 把字符串的一部分替换为另一个字符串。                         |
| [trim()](https://www.runoob.com/php/func-string-trim.html)   | 移除字符串两侧的空白字符和其他字符。                         |
| [ucfirst()](https://www.runoob.com/php/func-string-ucfirst.html) | 把字符串中的首字符转换为大写。                               |
| [ucwords()](https://www.runoob.com/php/func-string-ucwords.html) | 把字符串中每个单词的首字符转换为大写。                       |
| [vfprintf()](https://www.runoob.com/php/func-string-vfprintf.html) | 把格式化的字符串写到指定的输出流。                           |
| [vprintf()](https://www.runoob.com/php/func-string-vprintf.html) | 输出格式化的字符串。                                         |
| [vsprintf()](https://www.runoob.com/php/func-string-vsprintf.html) | 把格式化字符串写入变量中。                                   |
| [wordwrap()](https://www.runoob.com/php/func-string-wordwrap.html) | 按照指定长度对字符串进行折行处理。                           |

#### 数组

在 PHP 中，有三种类型的数组：数值数组 - 带有数字 ID 键的数组，关联数组 - 带有指定的键的数组，每个键关联一个值，多维数组 - 包含一个或多个数组的数组

```php
<?php
$cars=array("Volvo","BMW","Toyota");
echo "I like " . $cars[0] . ", " . $cars[1] . " and " . $cars[2] . ".";
$arrlength=count($cars);         // 获取数组的长度
for($x=0;$x<$arrlength;$x++)         // 遍历数组
{
    echo $cars[$x];
    echo "<br>";
}
$age=array("Peter"=>"35","Ben"=>"37","Joe"=>"43");         // 关联数组
// 或者 $age['Peter']="35"; $age['Ben']="37"; $age['Joe']="43";
echo "Peter is " . $age['Peter'] . " years old.";
foreach($age as $x=>$x_value)         // 遍历关联数组
{
    echo "Key=" . $x . ", Value=" . $x_value;
    echo "<br>";
}
?>
```

##### Array 函数

完整的 PHP Array 参考手册：https://www.runoob.com/php/php-ref-array.html

##### 数组排序函数

```php
<?php
$numbers=array(4,6,2,22,11);
sort($numbers);         // 对数组进行升序排列
rsort($numbers);         // 对数组进行降序排列
$age=array("Peter"=>"35","Ben"=>"37","Joe"=>"43");
asort($age);         // 根据关联数组（普通数组也可）的值，对数组进行升序排列
ksort($age);         // 根据关联数组的键，对数组进行升序排列
arsort($age);         // 根据关联数组的值，对数组进行降序排列
krsort($age);         // 根据关联数组的键，对数组进行降序排列
?>
```

### PHP 运算符

```php
<?php 
$x=10; 
$y=6;
echo ($x + $y);
var_dump(intdiv(10, 3));         // 整除运算符 intdiv()，结果为 int(3)
$x = array("a" => "red", "b" => "green"); 
$y = array("c" => "blue", "d" => "yellow"); 
$z = $x + $y; // $x 和 $y 数组合并
var_dump($z);         // array(4) { ["a"]=> string(3) "red" ["b"]=> string(5) "green" ["c"]=> string(4) "blue" ["d"]=> string(6) "yellow" }
?>
```

a .= b 等同于 a = a . b，连接两个字符串。不等于 x != y 或 x <> y。逻辑运算符：与 x and y；或 x or y；异或 x xor y，如果 x 和 y 有且仅有一个为 true，则返回 true；与 x && y；或 x || y；非 ! x。数组运算符：x + y，x == y，x === y，x != y，x <> y，x !== y

自 PHP 5.3 起，可以省略三元运算符中间那部分。表达式 expr1 ?: expr3 ，在 expr1 求值为 TRUE 时返回 expr1，否则返回 expr3。在 PHP7+ 版本多了一个 NULL 合并运算符 ??（相当于 5.3 写法中的 ?:）。PHP7+ 支持组合比较符（combined comparison operator）也称之为太空船操作符，符号为 **<=>**。组合比较运算符可以轻松实现两个变量的比较，当然不仅限于数值类数据的比较。`$c = $a <=> $b`，如果 $a > $b, 则 $c 的值为 1；如果 $a == $b, 则 $c 的值为 0；如果 $a < $b, 则 $c 的值为 -1

```php
<?php
$test = '菜鸟教程';
$username = isset($test) ? $test : 'nobody';         // 普通写法
echo $username, PHP_EOL;
$username = $test ?: 'nobody';         // PHP 5.3+ 版本写法
echo $username, PHP_EOL;
// 如果 $_GET['user'] 不存在返回 'nobody'，否则返回 $_GET['user'] 的值
$username = $_GET['user'] ?? 'nobody';
$username = isset($_GET['user']) ? $_GET['user'] : 'nobody';       // 类似的三元运算符
echo 1 <=> 1; // 结果为 0
?>
```

#### 运算符优先级

下表按照优先级从高到低列出了运算符。同一行中的运算符具有相同优先级，此时它们的结合方向决定求值顺序。左 ＝ 从左到右，右 ＝ 从右到左

| 结合方向 | 运算符                                                      | 附加信息                 |
| :------- | :---------------------------------------------------------- | :----------------------- |
| 无       | clone new                                                   | clone 和 new             |
| 左       | [                                                           | array()                  |
| 右       | ++，--，~，(int) (float) (string) (array) (object) (bool) @ | 类型和递增／递减         |
| 无       | instanceof                                                  | 类型                     |
| 右       | !                                                           | 逻辑运算符               |
| 左       | * / %                                                       | 算术运算符               |
| 左       | + – .                                                       | 算术运算符和字符串运算符 |
| 左       | << >>                                                       | 位运算符                 |
| 无       | == != === !== <>                                            | 比较运算符               |
| 左       | &                                                           | 位运算符和引用           |
| 左       | ^                                                           | 位运算符                 |
| 左       | \|                                                          | 位运算符                 |
| 左       | &&                                                          | 逻辑运算符               |
| 左       | \|\|                                                        | 逻辑运算符               |
| 左       | ? :                                                         | 三元运算符               |
| 右       | =，+=，-=，*=，/=，.=，%=，&=，\|=，^=，<<=，>>=，=>        | 赋值运算符               |
| 左       | and                                                         | 逻辑运算符               |
| 左       | xor                                                         | 逻辑运算符               |
| 左       | or                                                          | 逻辑运算符               |
| 左       | ,                                                           | 多处用到                 |

运算符优先级中，or 和 ||，&& 和 and 都是逻辑运算符，效果一样，但是其优先级却不一样

```php
<?php
// 优先级： &&  >  =  >  and，||  >  =  >  or
$a = 3;
$b = false;
$c = $a or $b;
var_dump($c);          // 这里的 $c 为 int 值 3，而不是 boolean 值 true
$d = $a || $b;
var_dump($d);          //这里的 $d 就是 boolean 值 true 
?>
```

### If...Else 语句

if 语句 、if...else 语句、if...elseif....else 语句、switch 语句

```php
<?php          // H 为小时二十四制，如果当前时间小于 10
$t=date("H");         // if...elseif....else 语句
if ($t<"10")
{
    echo "Have a good morning!";
}
elseif ($t<"20")
{
    echo "Have a good day!";
}
else
{
    echo "Have a good night!";
}
$favcolor="red";         // switch 语句
switch ($favcolor)
{
case "red":
    echo "你喜欢的颜色是红色!";
    break;
case "blue":
    echo "你喜欢的颜色是蓝色!";
    break;
default:
    echo "你喜欢的颜色不是 红, 蓝, 或绿色!";
}
?>
```

### PHP 循环

while、do...while、for、foreach

```php
<?php
$i=1;         // while 循环
while($i<=5)
{
    echo "The number is " . $i . "<br>";
    $i++;
}
do         // do...while 循环
{
    $i++;
    echo "The number is " . $i . "<br>";
}
while ($i<=5);
for ($i=1; $i<=5; $i++)         // for 循环
{
    echo "The number is " . $i . "<br>";
}
$x=array("one","two","three");         // foreach 循环
foreach ($x as $value)
{
    echo $value . "<br>";
}
?>
    
```

for 循环中的初始值和增量参数可为空，或者有多个表达式（用逗号分隔）

### PHP 函数

在 PHP 中，提供了超过 1000 个内建的函数。如要在页面加载时执行脚本，您可以把它放到函数里。函数是通过调用函数来执行的，你可以在页面的任何位置调用函数。函数的名称应该提示出它的功能，以字母或下划线开头（不能以数字开头）

```php
<?php
function writeName($fname,$punctuation)
{
    echo $fname . " Refsnes" . $punctuation . "<br>";
}
echo "My name is ";
writeName("Kai Jim",".");
function add($x,$y)
{
    $total=$x+$y;
    return $total;
}
echo "1 + 16 = " . add(1,16);
?>
// 结果为 My name is Kai Jim Refsnes.
```

### PHP 命名空间

命名空间可以解决以下两类问题：

1. 用户编写的代码与PHP内部的类/函数/常量或第三方类/函数/常量之间的名字冲突。
2. 为很长的标识符名称(通常是为了缓解第一类问题而定义的)创建一个别名（或简短）的名称，提高源代码的可读性

如果一个文件中包含命名空间，它必须在其它所有代码之前声明命名空间。将全局的非命名空间中的代码与命名空间中的代码组合在一起，只能使用大括号形式的语法。全局代码必须用一个不带名称的 namespace 语句加上大括号括起来。在声明命名空间之前唯一合法的代码是用于定义源文件编码方式的 declare 语句。所有非 PHP 代码包括空白符都不能出现在命名空间的声明之前，命名空间必须是程序脚本的第一条语句

```php
<?php
declare(encoding='UTF-8');         // 定义多个命名空间和不包含在命名空间中的代码
namespace MyProject {         // 建议使用下面的大括号形式的语法
    const CONNECT_OK = 1;
    class Connection { /* ... */ }
    function connect() { /* ... */  }
}
namespace { // 全局代码
session_start();
$a = MyProject\connect();
echo MyProject\Connection::start();
}
?>
```

与目录和文件的关系很像，PHP 命名空间也允许指定层次化的命名空间的名称。因此，命名空间的名字可以使用分层次的方式定义

```php
<?php
namespace MyProject\Sub\Level;  //声明分层次的单个命名空间，创建了 MyProject\Sub\Level 常量、类和函数
const CONNECT_OK = 1;
class Connection { /* ... */ }
function Connect() { /* ... */  }
?>
```

PHP 命名空间中的类名可以通过三种方式引用

1. 非限定名称，或不包含前缀的类名称。 警告：如果命名空间中的函数或常量未定义，则该非限定的函数名称或常量名称会被解析为全局函数名称或常量名称。
2. 限定名称，或包含前缀的名称
3. 完全限定名称，或包含了全局前缀操作符的名称

```php
<?php         // file1.php 文件代码
namespace Foo\Bar\subnamespace; 
const FOO = 1;
function foo() {}
class foo
{
    static function staticmethod() {}
}
?>
<?php
namespace Foo\Bar;
include 'file1.php';
const FOO = 2;
function foo() {}
class foo
{
    static function staticmethod() {}
}
/* 非限定名称 */
foo();         // 解析为函数 Foo\Bar\foo
foo::staticmethod();         // 解析为类 Foo\Bar\foo ，方法为 staticmethod
echo FOO;         // 解析为常量 Foo\Bar\FOO
/* 限定名称 */
subnamespace\foo();         // 解析为函数 Foo\Bar\subnamespace\foo
subnamespace\foo::staticmethod();     // 解析为类 Foo\Bar\subnamespace\foo,以及类的方法 staticmethod
echo subnamespace\FOO;         // 解析为常量 Foo\Bar\subnamespace\FOO                               
/* 完全限定名称 */
\Foo\Bar\foo();         // 解析为函数 Foo\Bar\foo
\Foo\Bar\foo::staticmethod();         // 解析为类 Foo\Bar\foo, 以及类的方法 staticmethod
echo \Foo\Bar\FOO;         // 解析为常量 Foo\Bar\FOO
?>
```

注意访问任意全局类、函数或常量，都可以使用完全限定名称，例如 \strlen() 或 \Exception 或 \INI_ALL

```php
<?php
namespace Foo;
function strlen() {}
const INI_ALL = 3;
class Exception {}
$a = \strlen('hi');         // 调用全局函数strlen
$b = \INI_ALL;         // 访问全局常量 INI_ALL
$c = new \Exception('error');         // 实例化全局类 Exception
?>
```

#### 动态语言特征

PHP 命名空间的实现受到其语言自身的动态特征的影响。动态访问命名空间的元素的代码如下：

```php
<?php         // example1.php 文件代码
class classname
{
    function __construct()         // 类的构造函数
    {
        echo __METHOD__,"\n";
    }
}
function funcname()
{
    echo __FUNCTION__,"\n";
}
const constname = "global";
$a = 'classname';
$obj = new $a; // prints classname::__construct
$b = 'funcname';
$b(); // prints funcname
echo constant('constname'), "\n"; // prints global，直接用 constname 也可以
?>
<?php         // 动态访问命名空间的元素
namespace namespacename;
class classname
{
    function __construct()
    {
        echo __METHOD__,"\n";
    }
}
function funcname()
{
    echo __FUNCTION__,"\n";
}
const constname = "namespaced";
include 'example1.php';
$a = 'classname';
$obj = new $a; // 输出 classname::__construct
$b = 'funcname';
$b(); // 输出函数名
echo constant('constname'), "\n"; // 输出 global
/* 如果使用双引号，使用方法为 "\\namespacename\\classname" */
$a = '\namespacename\classname';
$obj = new $a; // 输出 namespacename\classname::__construct
$a = 'namespacename\classname';
$obj = new $a; // 输出 namespacename\classname::__construct
$b = 'namespacename\funcname';
$b(); // 输出 namespacename\funcname
$b = '\namespacename\funcname';
$b(); // 输出 namespacename\funcname
echo constant('\namespacename\constname'), "\n"; // 输出 namespaced
echo constant('namespacename\constname'), "\n"; // 输出 namespaced
?>
```

PHP支持两种抽象的访问当前命名空间内部元素的方法，\__NAMESPACE\__ 魔术常量和 namespace 关键字。常量\__NAMESPACE\__的值是包含当前命名空间名称的字符串。在全局的，不包括在任何命名空间中的代码，它包含一个空的字符串。

```php
<?php
namespace MyProject;
echo '"', __NAMESPACE__, '"';         // 输出 "MyProject"
function get($classname)
{
    $a = __NAMESPACE__ . '\\' . $classname;         // 动态创建名称
    return new $a;
}
?>
```

关键字 namespace 可用来显式访问当前命名空间或子命名空间中的元素。它等价于类中的 self 操作符。namespace操作符，命名空间中的代码

```php
<?php
namespace MyProject;
use blah\blah as mine; // see "Using namespaces: importing/aliasing" ？

blah\mine(); // calls function blah\blah\mine()
namespace\blah\mine(); // calls function MyProject\blah\mine()

namespace\func(); // calls function MyProject\func()
namespace\sub\func(); // calls function MyProject\sub\func()
namespace\cname::method(); // calls static method "method" of class MyProject\cname
$a = new namespace\sub\cname(); // instantiates object of class MyProject\sub\cname
$b = namespace\CONSTANT; // assigns value of constant MyProject\CONSTANT to $b
?>
```

#### 别名/导入

在PHP中，别名是通过操作符 use 来实现的。导入操作是在编译执行的，但动态的类名称、函数名称或常量名称则不是。它只影响非限定名称和限定名称，完全限定名称由于是确定的，故不受导入的影响

```php
<?php
namespace foo;
use My\Full\Classname as Another;
use My\Full\NSname;         // 与 use My\Full\NSname as NSname 相同
use \ArrayObject;         // 导入一个全局类
$obj = new namespace\Another;         // 实例化 foo\Another 对象
$obj = new Another;         // 实例化 My\Full\Classname 对象
NSname\subns\func();         // 调用函数 My\Full\NSname\subns\func
$a = new ArrayObject(array(1));         
// 实例化 ArrayObject 对象，如果不使用 "use \ArrayObject" ，则实例化一个 foo\ArrayObject 对象
use My\Full\Classname as Another, My\Full\NSname;         // 一行中包含多个use语句
$obj = new Another;          // 实例化 My\Full\Classname 对象
NSname\subns\func();          // 调用函数 My\Full\NSname\subns\func
// 动态的类名称、函数名称或常量名称不是在编译执行的
$a = 'Another';
$obj = new $a;      // 实际化一个 Another 对象
// 完全限定名称不受导入的影响
$obj = new Another; // 实例化 My\Full\Classname 类
$obj = new \Another; // 实例化 Another 类
?>
```

#### 后备全局函数/常量

在一个命名空间中，当 PHP 遇到一个非限定的类、函数或常量名称时，它使用不同的优先策略来解析该名称。类名称总是解析到当前命名空间中的名称，因此在访问系统内部或不包含在命名空间中的类名称时，必须使用完全限定名称

```php
<?php         
namespace A\B\C;
class Exception extends \Exception {}          // 在命名空间中访问全局类
$a = new Exception('hi');          // $a 是类 A\B\C\Exception 的一个对象
$b = new \Exception('hi');          // $b 是类 Exception 的一个对象
$c = new ArrayObject;          // 致命错误, 找不到 A\B\C\ArrayObject 类
echo INI_ALL, "\n";           // 输出 7 - 使用全局常量 INI_ALL
function strlen($str)           // 需要在命名空间里定义
{
    return \strlen($str) - 1;
}
echo strlen('hi'), "\n"; // 输出 1
?>
```

#### 全局空间

如果没有定义任何命名空间，所有的类与函数的定义都是在全局空间，与 PHP 引入命名空间概念前一样。在名称前加上前缀 \ 表示该名称是全局空间中的名称，即使该名称位于其它的命名空间中时也是如此

```php
<?php
namespace A;
use B\D, C\E as F;
my\foo();   // 调用定义在命名空间"A\my"中函数 "foo" 
new B();    // 创建命名空间 "A" 中定义的类 "B" 的一个对象，如果未找到，则尝试自动装载类 "A\B"
new \B();   // 创建定义在全局空间中的类 "B" 的一个对象，...
B::foo();   // 调用命名空间 "A" 中定义的类 "B" 的 "foo" 方法，...
\B\foo();   // 调用命名空间 "B" 中的函数 "foo" 
\B::foo();  // 调用全局空间中的类 "B" 的 "foo" 方法，...
A\B::foo();   // 调用命名空间 "A\A" 中定义的类 "B" 的 "foo" 方法，...
\A\B::foo();  // 调用命名空间 "A" 中定义的类 "B" 的 "foo" 方法，...
?>
```

名称解析遵循下列规则：

1. 对完全限定名称的函数，类和常量的调用在编译时解析。例如 *new \A\B* 解析为类 *A\B*
2. 所有的非限定名称和限定名称（非完全限定名称）根据当前的导入规则在编译时进行转换。例如，如果命名空间 *A\B\C* 被导入为 *C*，那么对 *C\D\e()* 的调用就会被转换为 *A\B\C\D\e()*
3. 在命名空间内部，所有的没有根据导入规则转换的限定名称均会在其前面加上当前的命名空间名称。例如，在命名空间 *A\B* 内部调用 *C\D\e()*，则 *C\D\e()* 会被转换为 *A\B\C\D\e()* 
4. 非限定类名根据当前的导入规则在编译时转换（用全名代替短的导入名称）。例如，如果命名空间 *A\B\C* 导入为C，则 *new C()* 被转换为 *new A\B\C()* 
5. 在命名空间内部（例如A\B），对非限定名称或限定名称类（非完全限定名称）的调用是在运行时解析的。例如对函数 foo() 的调用是这样解析的：在当前命名空间中查找名为 *A\B\foo()* 的函数，然后尝试查找并调用 *全局(global)* 空间中的函数 *foo()*

### PHP 面向对象

在面向对象的程序设计（Object-oriented programming，OOP）中，对象是一个由信息及对信息进行处理的描述所组成的整体，是对现实世界的抽象。对象的主要三个特性：行为、形态和表示

#### 面向对象内容

- **类** − 定义了一件事物的抽象特点，类的定义包含了数据的形式以及对数据的操作。对象是类的实例。一个类被其他类继承，可将该类称为父类，或基类，或超类；一个类继承其他类称为子类，也可称为派生类
- **继承** − 继承性是子类自动共享父类数据结构和方法的机制，这是类之间的一种关系
- **多态** − 多态性是指相同的函数或方法可作用于多种类型的对象上并获得不同的结果。不同的对象，收到同一消息可以产生不同的结果，这种现象称为多态性
- **重载** − 函数或者方法有同样的名称，但是参数列表不相同，这样的同名不同参数的函数或者方法之间，互相称之为重载函数或者方法
- **抽象性** − 抽象性是指将具有一致的数据结构（属性）和行为（操作）的对象抽象成类。一个类就是这样一种抽象，它反映了与应用有关的重要性质，而忽略其他一些无关内容。任何类的划分都是主观的，但必须与具体的应用有关
- **封装** − 封装是指将现实世界中存在的某个客体的属性与行为绑定在一起，并放置在一个逻辑单元内
- **析构函数** − 析构函数(destructor) 与构造函数相反，当对象结束其生命周期时（例如对象所在的函数已调用完毕），系统自动执行析构函数。析构函数往往用来做"清理善后" 的工作（例如在建立对象时用 new 开辟了一片内存空间，应在退出前在析构函数中用 delete 释放）

```php
<?php
class Site {
  /* 成员变量 */
  var $url;
  var $title;
  function __construct( $par1, $par2 ) {
   $this->url = $par1;
   $this->title = $par2;
  }
  /* 成员函数 */
  function setUrl($par){
     $this->url = $par;         // 变量 $this 代表自身的对象
  }
  function getUrl(){
     echo $this->url . PHP_EOL;
  }
}
class Child_Site extends Site {         // Child_Site 类继承了 Site 类，并扩展了功能
    var $category;
    function setCate($par){
        $this->category = $par;
    }
    function getCate(){
        echo $this->category . PHP_EOL;
    }
    function getUrl() {         // 方法重写
        echo $this->url . PHP_EOL;
        return $this->url;
    }
}
// 无构造函数的情形
$runoob = new Site;         // 创建对象
$runoob->setUrl( 'www.runoob.com' );        // 调用成员函数，设置 url
$runoob->getUrl();        // 调用成员函数，获取URL
// 有构造函数的情形
$runoob = new Site('www.runoob.com', '菜鸟教程');
?>
```

如果从父类继承的方法不能满足子类的需求，可以对其进行改写，这个过程叫方法的覆盖（override），也称为方法的重写

```php
<?php
class MyDestructableClass {
   function __construct() {
       print "构造函数\n";
       $this->name = "MyDestructableClass";
   }
   function __destruct() {
       print "销毁 " . $this->name . "\n";
   }
}
$obj = new MyDestructableClass();
?>
/* 结果为
构造函数
销毁 MyDestructableClass
*/
```

#### 访问控制

PHP 对属性或方法的访问控制，是通过在前面添加关键字 public（公有），protected（受保护）或 private（私有）来实现的。public（公有）：公有的类成员可以在任何地方被访问，protected（受保护）：受保护的类成员则可以被其自身以及其子类和父类访问，private（私有）：私有的类成员则只能被其定义所在的类访问。

类属性必须定义为公有，受保护，私有之一。如果用 var 定义，则被视为公有

```php
<?php
class MyClass
{
    public $public = 'Public';
    protected $protected = 'Protected';
    private $private = 'Private';
    function printHello()
    {
        echo $this->public;
        echo $this->protected;
        echo $this->private;
    }
    public function MyPublic() { }         // 声明一个公有的方法
    protected function MyProtected() { }         // 声明一个受保护的方法
    private function MyPrivate() { }         // 声明一个私有的方法

}
$obj = new MyClass();
echo $obj->public;         // 这行能被正常执行
echo $obj->protected;         // 这行会产生一个致命错误
echo $obj->private;         // 这行也会产生一个致命错误
$obj->printHello();         // 输出 Public、Protected 和 Private
$obj->MyPublic();          // 这行能被正常执行
$myclass->MyProtected();          // 这行会产生一个致命错误
$myclass->MyPrivate();          // 这行会产生一个致命错误
class MyClass2 extends MyClass
{
    protected $protected = 'Protected2';// 可以对 public 和 protected 进行重定义，但 private 而不能？
    function printHello()          //如果不定义将输出父类中的属性
    {
        echo $this->public;
        echo $this->protected;
        echo $this->private;
    }
    function Foo2()
    {
        $this->MyPublic();
        $this->MyProtected();
        $this->MyPrivate();           // 这行会产生一个致命错误
    }
}
$myclass2 = new MyClass2;
echo $myclass2->private;           // 未定义 private
$myclass2->printHello();           // 输出 Public、Protected2 和 Undefined
$myclass2->Foo2();           // 公有的和受保护的都可执行，但私有的不行
?>
```

类中的方法可以被定义为公有，私有或受保护。如果没有设置这些关键字，则该方法默认为公有

#### 接口

使用接口（interface），可以指定某个类必须实现哪些方法，但不需要定义这些方法的具体内容。接口是通过 **interface** 关键字来定义的，就像定义一个标准的类一样，但其中定义所有的方法都是空的。接口中定义的所有方法都必须是公有，这是接口的特性。要实现一个接口，使用 **implements** 操作符。类中必须实现接口中定义的所有方法，否则会报一个致命错误。类可以实现多个接口，用逗号来分隔多个接口的名称

```php
<?php
interface iTemplate         // 声明一个'iTemplate'接口
{
    public function setVariable($name, $var);
    public function getHtml($template);
}
class Template implements iTemplate         // 实现接口
{
    private $vars = array();
    public function setVariable($name, $var)
    {
        $this->vars[$name] = $var;
    }
    public function getHtml($template)
    {
        foreach($this->vars as $name => $value) {
            // 把字符串 $template 中的 {$name} 换成 $value
            $template = str_replace('{' . $name . '}', $value, $template);
        }
        return $template;
    }
}
```

可以把在类中始终保持不变的值定义为常量。在定义和使用常量的时候不需要使用 $ 符号。常量的值必须是一个定值，不能是变量，类属性，数学运算的结果或函数调用。自 PHP 5.3.0 起，可以用一个变量来动态调用类，但该变量的值不能为关键字（如 self，parent 或 static）

```php
<?php
class MyClass
{
    const constant = '常量值';
    function showConstant() {
        echo  self::constant . PHP_EOL;
    }
}
echo MyClass::constant . PHP_EOL;
$classname = "MyClass";
echo $classname::constant . PHP_EOL;
$class = new MyClass();         
$class->showConstant();
echo $class::constant . PHP_EOL;          // 自 PHP 5.3.0 起
?>
```

#### 抽象类

任何一个类，如果它里面至少有一个方法是被声明为抽象的，那么这个类就必须被声明为抽象的。定义为抽象的类不能被实例化。被定义为抽象的方法只是声明了其调用方式（参数），不能定义其具体的功能实现。继承一个抽象类的时候，子类必须定义父类中的所有抽象方法；另外，这些方法的访问控制必须和父类中一样（或者更为宽松）。例如某个抽象方法被声明为受保护的，那么子类中实现的方法就应该声明为受保护的或者公有的，而不能定义为私有的

```php
<?php
abstract class AbstractClass
{
 
    abstract protected function getValue();         // 强制要求子类定义这些方法
    abstract protected function prefixValue($prefix);
    abstract protected function prefixName($name);
    
    public function printOut() {         // 普通方法（非抽象方法）
        print $this->getValue() . PHP_EOL;
    }
}
class ConcreteClass1 extends AbstractClass
{
    protected function getValue() {
        return "ConcreteClass1";
    }
    public function prefixValue($prefix) {
        return "{$prefix}ConcreteClass1";
    }
    public function prefixName($name, $separator = ".") {         // 注意参数个数和访问控制符
        if ($name == "Pacman") {
            $prefix = "Mr";
        } elseif ($name == "Pacwoman") {
            $prefix = "Mrs";
        } else {
            $prefix = "";
        }
        return "{$prefix}{$separator}{$name}";
    }
}
$class1 = new ConcreteClass1;
$class1->printOut();
echo $class1->prefixValue('FOO_') . PHP_EOL;
?>
```

声明类属性或方法为 static(静态)，就可以不实例化类而直接访问。静态属性不能通过一个类已实例化的对象来访问（但静态方法可以）。由于静态方法不需要通过对象即可调用，所以伪变量 $this 在静态方法中不可用。静态属性不可以由对象通过 -> 操作符来访问。自 PHP 5.3.0 起，可以用一个变量来动态调用类。但该变量的值不能为关键字 self，parent 或 static

```php
<?php
class Foo {
  public static $my_static = 'foo';
  public static function staticValue() {
     return self::$my_static;
  }
}
print Foo::$my_static . PHP_EOL;
$foo = new Foo();
print $foo->staticValue() . PHP_EOL;
print $foo::$my_static . PHP_EOL;         // 静态属性不能通过一个类已实例化的对象来访问？

class SubClass extends BaseClass {
   function __construct() {
       parent::__construct();         // 子类构造方法不能自动调用父类的构造方法
       print "SubClass 类中构造方法" . PHP_EOL;
   }
}
?>
```

`::`是作用域限定操作符它用来置顶类中不同作用域的级别，左边是作用域右边是访问作用域的成员。`::`用于静态上下文，即当某些方法或属性声明为静态时。还可以在调用父类的方法/属性时，动态上下文中使用。在 PHP 中定义的作用域有 self 和 parent 两种（在 PHP6 中提供了 static 作用域），self 表示当前类的作用域，与 this 不同的是它不表示类的某个特定实例，在类之外的代码中不能使用 self，而且它不能识别自己在继承中层次的位置。也就是说，当在扩展类中使用self 时，它调用的不是父类的方法，而是扩展类的重载的方法

PHP 5 新增了一个 final 关键字。如果父类中的方法被声明为 final，则子类无法覆盖该方法。如果一个类被声明为 final，则不能被继承。PHP 不会在子类的构造方法中自动的调用父类的构造方法。要执行父类的构造方法，需要在子类的构造方法中调用 `parent::__construct()` 