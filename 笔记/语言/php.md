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
| addslashes()                                                 | 返回在预定义的字符前添加反斜杠的字符串。addslashes('What does "yolo" mean?')，What does \"yolo\" mean? |
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
| htmlentities()                                               | 把字符转换为 HTML 实体。                                     |
| [htmlspecialchars_decode()](https://www.runoob.com/php/func-string-htmlspecialchars-decode.html) | 把一些预定义的 HTML 实体转换为字符。                         |
| [htmlspecialchars()](https://www.runoob.com/php/func-string-htmlspecialchars.html) | 把一些预定义的字符转换为 HTML 实体。                         |
| [implode()](https://www.runoob.com/php/func-string-implode.html) | 返回一个由数组元素组合成的字符串。                           |
| [join()](https://www.runoob.com/php/func-string-join.html)   | implode() 的别名。                                           |
| [lcfirst()](https://www.runoob.com/php/func-string-lcfirst.html) | 把字符串中的首字符转换为小写。                               |
| [levenshtein()](https://www.runoob.com/php/func-string-levenshtein.html) | 返回两个字符串之间的 Levenshtein 距离。                      |
| [localeconv()](https://www.runoob.com/php/func-string-localeconv.html) | 返回本地数字及货币格式信息。                                 |
| [ltrim()](https://www.runoob.com/php/func-string-ltrim.html) | 移除字符串左侧的空白字符或其他字符。                         |
| md5()                                                        | 计算字符串的 MD5 散列。                                      |
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

##### 多维数组

```php
<?php
$cars = array
(
    array("Volvo",100,96),
    array("BMW",60,59),
    array("Toyota",110,100)
);
$sites = array
(
    "runoob"=>array
    (
        "菜鸟教程",
        "http://www.runoob.com"
    ),
    "google"=>array
    (
        "Google 搜索",
        "http://www.google.com"
    ),
    "taobao"=>array
    (
        "淘宝",
        "http://www.taobao.com"
    )
);
print("<pre>");          // 格式化输出数组
print_r($sites);
print("</pre>");
echo $cars['runoob'][0] . '地址为：' . $sites['runoob'][1];          // 显示上面数组中的某个值
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

#### date() 函数

date() 函数用于格式化时间/日期，时间戳是一个字符序列，表示一定的事件发生的日期/时间

```php
string date ( string $format [, int $timestamp ] )
// format-必需，规定时间戳的格式。timestamp-可选，规定时间戳，默认是当前的日期和时间
<?php
echo date("Y/m/d") . "<br>";
echo date("Y.m.d") . "<br>";
echo date("Y-m-d");
?>
```

格式字串可以识别以下 format 参数的字符串：<https://www.runoob.com/php/php-date.html>

#### error_log() 函数

error_log() 函数向服务器错误记录、文件或远程目标发送一个错误。如果成功该函数返回 TRUE，如果失败该函数返回 FALSE。语法为`error_log(error,type,destination,headers)`

| 参数        | 描述                                                         |
| :---------- | :----------------------------------------------------------- |
| error       | 必需，要记录的错误消息                                       |
| type        | 可选，规定错误记录的类型。 可能的记录类型：0 - 默认，根据在 php.ini 文件中的 error_log 配置，错误被发送到服务器日志系统或文件。1 - 错误被发送到 destination 参数中的地址，只有该类型使用 headers 参数。2 - 通过 PHP debugging 连接来发送错误，该选项只在 PHP 3 中可用。3 - 错误发送到文件目标字符串 |
| destination | 可选，规定向何处发送错误消息，该参数的值依赖于 "type" 参数的值 |
| headers     | 可选，只在 "type" 参数为 1 时使用。规定附加的头部，比如 From, Cc 以及 Bcc。附加头部由 CRLF (\r\n) 分隔。注意：在发送电子邮件时，必须包含 From 头部，可以在 php.ini 文件中或者通过此参数设置 |

### 命名空间

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

### 面向对象

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

### 表单

当处理 HTML 表单时，PHP 能把来自 HTML 页面中的表单元素自动变成可供 PHP 脚本使用

```php+HTML
<?php
// 可以通过 select 的 name 属性获取下拉菜单的值
$q = isset($_GET['q'])? htmlspecialchars($_GET['q']) : '';    // 把预定义的字符转换为 HTML 实体
if($q) {
        if($q =='RUNOOB') {
                echo '菜鸟教程<br>http://www.runoob.com';
        } else if($q =='GOOGLE') {
                echo 'Google 搜索<br>http://www.google.com';
        } else if($q =='TAOBAO') {
                echo '淘宝<br>http://www.taobao.com';
        }
} else {
?>
<form action="" method="get">         <!-- action 属性值为空表示提交到当前脚本 -->
    <select name="q">
    <option value="">选择一个站点:</option>
    <option value="RUNOOB">Runoob</option>
    <option value="GOOGLE">Google</option>
    <option value="TAOBAO">Taobao</option>
    </select>
    <input type="submit" value="提交">
</form>
<!--  单选按钮表单中 name 属性的值是一致的，value 值是不同的 -->
<form action="" method="get"> 
    <input type="radio" name="q" value="RUNOOB" />Runoob
    <input type="radio" name="q" value="GOOGLE" />Google
    <input type="radio" name="q" value="TAOBAO" />Taobao
    <input type="submit" value="提交">
</form>
<?php
}
?>
```

如果下拉菜单是多选的（ multiple="multiple"），我们可以通过将设置 `select name="q[]"` 以数组的方式获取

```php+HTML
<?php
$q = isset($_POST['q'])? $_POST['q'] : '';
if(is_array($q)) {
    $sites = array(
            'RUNOOB' => '菜鸟教程: http://www.runoob.com',
            'GOOGLE' => 'Google 搜索: http://www.google.com',
            'TAOBAO' => '淘宝: http://www.taobao.com',
    );
    foreach($q as $val) {
        echo $sites[$val] . PHP_EOL;
    }
      
} else {
?>
<form action="" method="post"> 
    <select multiple="multiple" name="q[]">
    <option value="">选择一个站点:</option>
...
<!-- 复选框 -->
<form action="" method="post"> 
    <input type="checkbox" name="q[]" value="RUNOOB"> Runoob<br> 
    <input type="checkbox" name="q[]" value="GOOGLE"> Google<br> 
    <input type="checkbox" name="q[]" value="TAOBAO"> Taobao<br>
    <input type="submit" value="提交">
</form>
```

我们应该尽可能的对用户的输入进行验证（通过客户端脚本）。浏览器验证速度更快，并且可以减轻服务器的压力。如果用户输入需要插入数据库，您应该考虑使用服务器验证。在服务器验证表单的一种好的方式是，把表单的数据传给当前页面（异步提交的方式更好），而不是跳转到不同的页面。这样用户就可以在同一张表单页面得到错误信息。用户也就更容易发现错误了

#### 表单验证

```php+HTML
<?php
// 定义变量并默认设置为空值
$nameErr = $emailErr = $genderErr = $websiteErr = "";
$name = $email = $gender = $comment = $website = "";
if ($_SERVER["REQUEST_METHOD"] == "POST")
{
    if (empty($_POST["name"]))
    {
        $nameErr = "名字是必需的";
    }
    else
    {
        $name = test_input($_POST["name"]);
        if (!preg_match("/^[a-zA-Z ]*$/",$name))         // 检测名字是否只包含字母跟空格
        {
            $nameErr = "只允许字母和空格"; 
        }
    }
    if (empty($_POST["email"]))
    {
      $emailErr = "邮箱是必需的";
    }
    else
    {
        $email = test_input($_POST["email"]);
        if (!preg_match("/([\w\-]+\@[\w\-]+\.[\w\-]+)/",$email))         // 检测邮箱是否合法
        {
            $emailErr = "非法邮箱格式"; 
        }
    }
    if (empty($_POST["website"]))
    {
        $website = "";
    }
    else
    {
        $website = test_input($_POST["website"]);
        // 检测 URL 地址是否合法
        if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$website))
        {
            $websiteErr = "非法的 URL 的地址"; 
        }
    }
    if (empty($_POST["comment"]))
    {
        $comment = "";
    }
    else
    {
        $comment = test_input($_POST["comment"]);
    }
    if (empty($_POST["gender"]))
    {
        $genderErr = "性别是必需的";
    }
    else
    {
        $gender = test_input($_POST["gender"]);
    }
}
function test_input($data)
{
    $data = trim($data);
    $data = stripslashes($data);          // 删除由 addslashes() 函数添加的反斜杠
    $data = htmlspecialchars($data);          // 把一些预定义的字符转换为 HTML 实体
    return $data;
}
?>
<p><span class="error">* 必需字段。</span></p>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>"> 
   名字: <input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
   <br><br>
   E-mail: <input type="text" name="email" value="<?php echo $email;?>">
   <span class="error">* <?php echo $emailErr;?></span>
   <br><br>
   网址: <input type="text" name="website" value="<?php echo $website;?>">
   <span class="error"><?php echo $websiteErr;?></span>
   <br><br>
   备注: <textarea name="comment" rows="5" cols="40"><?php echo $comment;?></textarea>
   <br><br>
   性别:
   <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?>  value="female">女         <!-- 设置好checked属性 -->
   <input type="radio" name="gender" <?php if (isset($gender) && $gender=="male") echo "checked";?>  value="male">男
   <span class="error">* <?php echo $genderErr;?></span>
   <br><br>
   <input type="submit" name="submit" value="Submit"> 
</form>
<?php
echo "<h2>您输入的内容是:</h2>";
echo $name;
echo "<br>";
echo $email;
echo "<br>";
echo $website;
echo "<br>";
echo $comment;
echo "<br>";
echo $gender;
?>
```

$_SERVER["PHP_SELF"] 会发送表单数据到当前页面，而不是跳转到不同的页面。preg_match() 函数用于进行正则表达式匹配，成功返回 1 ，否则返回 0 。htmlspecialchars() 函数把一些预定义的字符转换为 HTML 实体。预定义的字符是：& （和号） 成为 \&amp;，" （双引号） 成为 \&quot;，' （单引号） 成为 \&#039;，< （小于） 成为 \&lt;，>（大于） 成为 \&gt;

##### 表单中需引起注重的地方

XSS又叫 CSS (Cross-Site Script) ，跨站脚本攻击。恶意攻击者往 Web 页面里插入恶意 html 代码，当用户浏览该页之时，嵌入其中 Web 里面的 html 代码会被执行，从而达到恶意用户的特殊目的。当黑客使用跨网站脚本的 HTTP 链接来攻击时，$SERVER["PHP_SELF"] 服务器变量也会被植入脚本。原因就是跨网站脚本是附在执行文件的路径后面的，因此$SERVER["PHP_SELF"]的字符串就会包含 HTTP 链接后面的 JavaScript 程序代码

```
http://www.runoob.com/test_form.php/%22%3E%3Cscript%3Ealert('hacked')%3C/script%3E
// 以上的 URL 将被解析为如下代码并执行
<form method="post" action="test_form.php/"><script>alert('hacked')</script>
// 当页面载入时会执行该Javascript代码（用户会看到弹出框）
```

$_SERVER["PHP_SELF"] 可以通过 htmlspecialchars() 函数来避免被利用

```
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
// 结果将输出如下所示
<form method="post" action="test_form.php/&quot;&gt;&lt;script&gt;alert('hacked')&lt;/script&gt;">
// 当我们使用 htmlspecialchars() 函数时，在用户尝试提交以下文本域
<script>location.href('http://www.runoob.com')</script>
// 该代码将不会被执行，因为它会被保存为HTML转义代码
&lt;script&gt;location.href('http://www.runoob.com')&lt;/script&gt;
```

可以通过`$_SERVER["REQUEST_METHOD"]`来检测表单是否被提交 。如果 REQUEST_METHOD 是 POST,，表单将被提交——数据将被验证。如果表单未提交将跳过验证并显示空白

```php
<?php
$name = $email = $gender = $comment = $website = "";// 定义变量并默认设置为空值
if ($_SERVER["REQUEST_METHOD"] == "POST")
{
  $name = test_input($_POST["name"]);
  $email = test_input($_POST["email"]);
  $website = test_input($_POST["website"]);
  $comment = test_input($_POST["comment"]);
  $gender = test_input($_POST["gender"]);
}
?>
```

- 在 PHP 中，预定义的 $GET 变量用于收集来自 method="get" 的表单中的值，表单域的名称会自动成为 $GET 数组中的键。因为变量显示在 URL 中，因此可以在收藏夹中收藏该页面。在某些情况下，这是很有用的。GET 方法不适合大型的变量值。它的值是不能超过 2000 个字符的。
- 预定义的 $_POST 变量用于收集来自 method="post" 的表单中的值，默认情况下，POST 方法的发送信息的量最大值为 8 MB（可通过设置 php.ini 文件中的 post_max_size 进行更改）。由于变量不显示在 URL 中，所以无法把页面加入书签
- 预定义的 $_REQUEST 变量包含了 $_GET、$_POST 和 $_COOKIE 的内容，可用来收集通过 GET 和 POST 方法发送的表单数据

### 包含文件

在 PHP 中，您可以在服务器执行 PHP 文件之前在该文件中插入一个文件的内容。include 和 require 语句用于在执行流中插入写在其他文件中的有用的代码。include 和 require 除了处理错误的方式不同之外，在其他方面都是相同的：require 生成一个致命错误（E_COMPILE_ERROR），在错误发生后脚本会停止执行；include 生成一个警告（E_WARNING），在错误发生后脚本会继续执行。包含文件省去了大量的工作。这意味着您可以为所有网页创建标准页头、页脚或者菜单文件。然后，在页头需要更新时，您只需更新这个页头包含文件即可

```php+HTML
<?php         // vars.php 文件	
$color='red';
$car='BMW';
?>
<body>
<h1>欢迎来到我的主页!</h1>
<?php 
include 'vars.php';
echo "I have a $color $car"; 
?>
</body>
```

### 文件处理

```php
<?php
$file=fopen("welcome.txt","r") or exit("Unable to open file!");
while(!feof($file))         // feof() 函数检测是否已到达文件末尾（EOF）
{   // fgets() 函数用于从文件中逐行读取文件，在调用该函数之后，文件指针会移动到下一行
    echo fgets($file). "<br>";      
}
while (!feof($file))
{
    echo fgetc($file);         // fgetc() 函数用于从文件中逐字符地读取文件
}
fclose($file);
?>
```

Filesystem 参考手册：<https://www.runoob.com/php/php-ref-filesystem.html>

如果 fopen() 函数无法打开指定文件，则返回 0 (false)。函数的第一个参数含有要打开的文件的名称，第二个参数规定了使用哪种模式来打开文件。在 w 、a 和 x 模式下，您无法读取打开的文件！

| 模式 | 描述                                                         |
| :--- | :----------------------------------------------------------- |
| r    | 只读，在文件的开头开始。                                     |
| r+   | 读/写，在文件的开头开始。                                    |
| w    | 只写，打开并清空文件的内容；如果文件不存在，则创建新文件。   |
| w+   | 读/写，打开并清空文件的内容；如果文件不存在，则创建新文件。  |
| a    | 追加，打开并向文件末尾进行写操作，如果文件不存在，则创建新文件。 |
| a+   | 读/追加，通过向文件末尾写内容，来保持文件内容。              |
| x    | 只写，创建新文件，如果文件已存在，则返回 FALSE 和一个错误。  |
| x+   | 读/写，创建新文件，如果文件已存在，则返回 FALSE 和一个错误   |

### 文件上传

通过 PHP，可以把文件上传到服务器

```php+HTML
<!-- form.html  -->
<form action="upload_file.php" method="post" enctype="multipart/form-data">
    <label for="file">文件名：</label>
    <input type="file" name="file" id="file"><br>
    <input type="submit" name="submit" value="提交">
</form>
<!-- upload_file.php -->
<?php
$allowedExts = array("gif", "jpeg", "jpg", "png");         // 允许上传的图片后缀
$temp = explode(".", $_FILES["file"]["name"]);
$extension = end($temp);        // 获取文件后缀名
if ((($_FILES["file"]["type"] == "image/gif")
|| ($_FILES["file"]["type"] == "image/jpeg")
|| ($_FILES["file"]["type"] == "image/jpg")
|| ($_FILES["file"]["type"] == "image/pjpeg")
|| ($_FILES["file"]["type"] == "image/x-png")
|| ($_FILES["file"]["type"] == "image/png"))
&& ($_FILES["file"]["size"] < 204800)    // 小于 200 kb
&& in_array($extension, $allowedExts))
{
    if ($_FILES["file"]["error"] > 0)
    {
        echo "错误：: " . $_FILES["file"]["error"] . "<br>";
    }
    else
    {
        echo "上传文件名: " . $_FILES["file"]["name"] . "<br>";
        echo "文件类型: " . $_FILES["file"]["type"] . "<br>";
        echo "文件大小: " . ($_FILES["file"]["size"] / 1024) . " kB<br>";
        echo "文件临时存储的位置: " . $_FILES["file"]["tmp_name"];
// 判断当期目录下的 upload 目录是否存在该文件，如果没有 upload 目录，你需要创建它，upload 目录权限为 777
        if (file_exists("upload/" . $_FILES["file"]["name"]))
        {
            echo $_FILES["file"]["name"] . " 文件已经存在。 ";
        }
        else
        {
            // 如果 upload 目录不存在该文件则将文件上传到 upload 目录下
            move_uploaded_file($_FILES["file"]["tmp_name"], "upload/" . $_FILES["file"]["name"]);
            echo "文件存储在: " . "upload/" . $_FILES["file"]["name"];
        }
    }
}
else
{
    echo "非法的文件格式";
}
?>
```

\<form> 标签的 enctype 属性规定了在提交表单时要使用哪种内容类型。在表单需要二进制数据时，比如文件内容，请使用 "multipart/form-data"。\<input> 标签的 type="file" 属性规定了应该把输入作为文件来处理。举例来说，当在浏览器中预览时，会看到输入框旁边有一个浏览按钮

### Cookie 和 session

cookie 是一种服务器留在用户计算机上的小文件。每当同一台计算机通过浏览器请求页面时，这台计算机将会发送 cookie。 常用于识别用户，通过 PHP，您能够创建并取回 cookie 的值

```php+HTML
<html>          <!-- setcookie() 函数必须位于 <html> 标签之前 -->
<?php
    // 创建名为 "user" 的 cookie，并为它赋值 "runoob"，此 cookie 在一小时后过期
    setcookie("user", "runoob", time()+3600);
    $expire=time()+60*60*24*30;
    setcookie("user", "runoob", $expire);         // 过期时间一个月
    echo $_COOKIE["user"];         // 输出 cookie 值
    print_r($_COOKIE);          // 查看所有 cookie
    if (isset($_COOKIE["user"]))
    echo "欢迎 " . $_COOKIE["user"] . "!<br>";          // 使用 isset() 函数来确认是否已设置了 cookie
    setcookie("user", "", time()-3600);         // 设置 cookie 过期时间为过去 1 小时
?>
</html>
```

在发送 cookie 时，cookie 的值会自动进行 URL 编码，在取回时进行自动解码。为防止 URL 编码，可以使用 setrawcookie() 取而代之。当删除 cookie 时，您应当使过期日期变更为过去的时间点

session 变量用于存储关于用户会话（session）的信息，或者更改用户会话（session）的设置。Session 变量存储单一用户的信息，并且对于应用程序中的所有页面都是可用的。然而，会话信息是临时的，在用户离开网站后将被删除。如果您需要永久存储信息，可以把数据存储在数据库中。Session 的工作机制是：为每个访客创建一个唯一的 id (UID)，并基于这个 UID 来存储变量。UID 存储在 cookie 中，或者通过 URL 进行传导

```php
<?php 
session_start();         // session_start() 函数必须位于 <html> 标签之前
$_SESSION['views']=1;         // 存储 session 数据
if(isset($_SESSION['views']))
{
    unset($_SESSION['views']);         // 释放指定的 session 变量
}
session_destroy();         // 重置 session，将失去所有已存储的 session 数据
?>         
<html>
<body>
<?php
echo "浏览量：". $_SESSION['views'];         // 检索 session 数据
?>
</body>
</html>
```

### 发送电子邮件

mail() 函数用于从脚本中发送电子邮件，语法：`mail(to,subject,message,headers,parameters)`

- to 为 email 接收者，subject 为 email 的主题（该参数不能包含任何新行字符）
- message 定义要发送的消息，应使用 LF (\n) 来分隔各行，每行应该限制在 70 个字符内
- headers 规定附加的标题，比如 From、Cc 和 Bcc，应当使用 CRLF (\r\n) 分隔附加的标题
- parameters 对邮件发送程序规定额外的参数

PHP 运行邮件函数需要一个已安装且正在运行的邮件系统(如：sendmail、postfix、qmail等)。所用的程序通过在 php.ini 文件中的配置设置进行定义。

| 名称          | 默认        | 描述                                                         | 可更改         |
| :------------ | :---------- | :----------------------------------------------------------- | :------------- |
| SMTP          | "localhost" | Windows 专用：SMTP 服务器的 DNS 名称或 IP 地址。             | PHP_INI_ALL    |
| smtp_port     | "25"        | Windows 专用：SMTP 端口号。自 PHP 4.3 起可用。               | PHP_INI_ALL    |
| sendmail_from | NULL        | Windows 专用：规定在由 PHP 发送的电子邮件中使用的 "from" 地址。 | PHP_INI_ALL    |
| sendmail_path | NULL        | Unix 系统专用：规定 sendmail 程序的路径（通常 /usr/sbin/sendmail 或 /usr/lib/sendmail）。 | PHP_INI_SYSTEM |

发送电子邮件的最简单的方式是发送一封文本 email

```php
<?php
$to = "someone@example.com";         // 邮件接收者
$subject = "参数邮件";                // 邮件标题
$message = "Hello! 这是邮件的内容。";  // 邮件正文
$from = "someonelse@example.com";   // 邮件发送者
$headers = "From:" . $from;         // 头部信息设置
mail($to,$subject,$message,$headers);
echo "邮件已发送";
?>
<?php
    if (isset($_REQUEST['email'])) { 			// 如果接收到邮箱参数则发送邮件
        $email = $_REQUEST['email'] ;
        $subject = $_REQUEST['subject'] ;
        $message = $_REQUEST['message'] ;
        mail("someone@example.com", $subject,
             $message, "From:" . $email);
        echo "邮件发送成功";
    } else { 			// 如果没有邮箱参数则显示表单
        echo "<form method='post' action='mailform.php'>
            Email: <input name='email' type='text'><br>
            Subject: <input name='subject' type='text'><br>
            Message:<br>
            <textarea name='message' rows='15' cols='40'>
            </textarea><br>
            <input type='submit'>
            </form>";
	}
?>
```

首先，检查是否填写了邮件输入框。如果未填写（比如在页面被首次访问时），输出 HTML 表单；如果已填写（在表单被填写后），从表单发送电子邮件。当填写完表单点击提交按钮后，页面重新载入，可以看到邮件输入被重置，同时显示邮件发送成功的消息。ezmlm_hash() 函数计算 EZMLM 邮件列表系统所需的散列值

以上代码存在的问题是，未经授权的用户可通过输入表单在邮件头部插入数据

```
someone@example.com%0ACc:person2@example.com
%0ABcc:person3@example.com,person3@example.com,
anotherperson4@example.com,person5@example.com
%0ABTo:person6@example.com
```

假如用户在表单中的输入框内加入如下文本到电子邮件中，与往常一样，mail() 函数把上面的文本放入邮件头部，那么现在头部有了额外的 Cc:、Bcc: 和 To: 字段。当用户点击提交按钮时，这封 e-mail 会被发送到上面所有的地址。防止 e-mail 注入的最好方法是对输入进行验证

```php
<?php
function spamcheck($field)
{
    // FILTER_SANITIZE_EMAIL 过滤器从字符串中删除电子邮件的非法字符，使用 FILTER_SANITIZE_EMAIL
    $field=filter_var($field, FILTER_SANITIZE_EMAIL);
    // FILTER_VALIDATE_EMAIL 过滤器验证电子邮件地址的值，使用 FILTER_VALIDATE_EMAIL
    if(filter_var($field, FILTER_VALIDATE_EMAIL))
    {
        return TRUE;
    }
    else
    {
        return FALSE;
    }
}

if (isset($_REQUEST['email']))
{
    // 判断邮箱是否合法
    $mailcheck = spamcheck($_REQUEST['email']);
    if ($mailcheck==FALSE)
    {
        echo "非法输入";
    }
    else
    {    
        // 发送邮件
        ...
    }
}
else
{ 
    // 如果没有邮箱参数则显示表单
    ...
}
?>
```

###  错误处理

在 PHP 中，默认的错误处理很简单。一条错误消息会被发送到浏览器，这条消息带有文件名、行号以及描述错误的消息。现在，如果文件不存在，您会得到类似这样的错误消息：文件不存在

```php
<?php
    if(!file_exists("welcome.txt"))
{
    die("文件不存在");
}
else
{
    $file=fopen("welcome.txt","r");
}
function customError($errno, $errstr)				// 错误处理函数
{
    echo "<b>Error:</b> [$errno] $errstr<br>"; // 输出结果 Error: [8] Undefined variable: test
    echo "脚本结束";
    die();
}
set_error_handler("customError");			// 设置错误处理函数
echo($test);			// 触发错误
?>
```

上面的代码有一个简单的错误处理函数，当它被触发时，它会取得错误级别和错误消息。然后它会输出错误级别和消息，并终止脚本。针对所有错误来使用我们自定义的错误处理程序，仅需要一个参数，可以添加第二个参数来规定错误级别。

#### 错误报告级别

这些错误报告级别是用户自定义的错误处理程序处理的不同类型的错误

| 值   | 常量                | 描述                                                         |
| :--- | :------------------ | :----------------------------------------------------------- |
| 2    | E_WARNING           | 非致命的 run-time 错误，不暂停脚本执行                       |
| 8    | E_NOTICE            | run-time 通知，在脚本发现可能有错误时发生，但也可能在脚本正常运行时发生 |
| 256  | E_USER_ERROR        | 致命的用户生成的错误，这类似于程序员使用 PHP 函数 trigger_error() 设置的 E_ERROR |
| 512  | E_USER_WARNING      | 非致命的用户生成的警告，这类似于程序员使用 PHP 函数 trigger_error() 设置的 E_WARNING |
| 1024 | E_USER_NOTICE       | 用户生成的通知，这类似于程序员使用 PHP 函数 trigger_error() 设置的 E_NOTICE |
| 4096 | E_RECOVERABLE_ERROR | 可捕获的致命错误。类似 E_ERROR，但可被用户定义的处理程序捕获（参见 set_error_handler()） |
| 8191 | E_ALL               | 所有错误和警告（在 PHP 5.4 中，E_STRICT 成为 E_ALL 的一部分） |

脚本中用户输入数据的位置，当用户的输入无效时触发错误是很有用的。在 PHP 中，这个任务由 trigger_error() 函数完成。您可以在脚本中任何位置触发错误，通过添加的第二个参数，您能够规定所触发的错误类型。

- E_USER_ERROR - 致命的用户生成的 run-time 错误，错误无法恢复，脚本执行被中断。
- E_USER_WARNING - 非致命的用户生成的 run-time 警告，脚本执行不被中断。
- E_USER_NOTICE - 默认，用户生成的 run-time 通知，在脚本发现可能有错误时发生，但也可能在脚本正常运行时发生

```php
<?php
function customError($errno, $errstr)
{
    echo "<b>Error:</b> [$errno] $errstr<br>";
    echo "已通知网站管理员";
    error_log("Error: [$errno] $errstr",1,	// 1 表示把错误被发送到 destination（第三个） 参数中的地址
    "someone@example.com","From: webmaster@example.com");
}
set_error_handler("customError",E_USER_WARNING);
$test=2;
if ($test>1)
{	
    trigger_error("变量值必须小于等于 1");		/* 输出结果 Notice: 变量值必须小于等于 1 in
    										   /www/test/runoob.php on line 5 */
    trigger_error("变量值必须小于等于 1",E_USER_WARNING);	/* Error: [512] 变量值必须小于等于 1
    										   			  脚本结束 */
}
?>
```

如果 "test" 变量大于 "1"，则发生 E_USER_WARNING 错误。如果发生了 E_USER_WARNING，我们将使用我们自定义的错误处理程序并结束脚本。接收自以上代码的邮件为 `Error: [512] 变量值必须小于等于 1`，这个方法不适合所有的错误。常规错误应当通过使用默认的 PHP 记录系统在服务器上进行记录

### 异常处理

异常用于在指定的错误发生时改变脚本的正常流程。当异常被抛出时，其后的代码不会继续执行，PHP 会尝试查找匹配的 "catch" 代码块。如果异常没有被捕获，而且又没用使用 set_exception_handler() 作相应的处理的话，那么将发生一个严重的错误（致命错误），并且输出 "Uncaught Exception" （未捕获异常）的错误消息

```php
<?php
// 创建一个有异常处理的函数
function checkNum($number)
{
    if($number>1)
    {
        throw new Exception("变量值必须小于等于 1");
    }
        return true;
}
// 在 try 块 触发异常
try
{
    checkNum(2);
    // 如果抛出异常，以下文本不会输出
    echo '如果输出该内容，说明 $number 变量';
}
// 捕获异常
catch(Exception $e)
{
    echo 'Message: ' .$e->getMessage();
}
?>
```

为了遵循 "每个 throw 必须对应一个 catch" 的原则，可以设置一个顶层的异常处理器来处理漏掉的错误。可以为一段脚本使用多个异常，来检测多种情况。可以使用多个 if..else 代码块，或一个 switch 代码块，或者嵌套多个异常。这些异常能够使用不同的 exception 类，并返回不同的错误消息

```php
<?php
class customException extends Exception
{
    public function errorMessage()
    {
        // 错误信息，getMessage()就是传进去的参数
        $errorMsg = '错误行号 '.$this->getLine().' in '.$this->getFile()
        .': <b>'.$this->getMessage().'</b> 不是一个合法的 E-Mail 地址';
        return $errorMsg;
    }
}
$email = "someone@example...com";
try
{
    if(filter_var($email, FILTER_VALIDATE_EMAIL) === FALSE)
    {
        throw new customException($email);
    }
    // 检测 "example" 是否在邮箱地址中
    if(strpos($email, "example") !== FALSE)
    {
        throw new Exception("$email 是 example 邮箱");
    }
    try				// 重新抛出异常代码
    {
        // 检测 "example" 是否在邮箱地址中
        if(strpos($email, "example") !== FALSE)
        {
            // 如果是个不合法的邮箱地址，抛出异常
            throw new Exception($email);
        }
    }
    catch(Exception $e)
    {
        // 重新抛出异常
        throw new customException($email);
    }
} 
catch (customException $e)
{
echo $e->errorMessage();
}
catch(Exception $e)
{
    echo $e->getMessage();
}
?>
/* 输出结果（子类）：错误行号 21 in /box/main.php: someone@example...com 不是一个合法的 E-Mail 地址
   输出结果（父类）：someone@example.com 是 example 邮箱
*/
   
```

子类异常可以作为父类异常可以处理，但是父类异常不能作为子类异常处理。有时，当异常被抛出时，您也许希望以不同于标准的方式对它进行处理。可以在一个 "catch" 代码块中再次抛出异常。如果在当前的 "try" 代码块中异常没有被捕获，则它将在更高层级上查找 catch 代码块

```php
<?php
function myException($exception)
{
    echo "<b>Exception:</b> " , $exception->getMessage();
}
set_exception_handler('myException');			// 设置处理所有未捕获异常的用户定义函数
throw new Exception('Uncaught Exception occurred');  // 结果 Exception: Uncaught Exception occurred
?>
```

###  过滤器

 过滤器用于验证和过滤来自非安全来源的数据，比如用户的输入。几乎所有的 Web 应用程序都依赖外部的输入。这些数据通常来自用户或其他应用程序（比如 web 服务）。通过使用过滤器，您能够确保应用程序获得正确的输入类型

- filter_var() - 通过一个指定的过滤器来过滤单一的变量
- filter_var_array() - 通过相同的或不同的过滤器来过滤多个变量
- filter_input - 获取一个输入变量，并对它进行过滤
- filter_input_array - 获取多个输入变量，并通过相同的或不同的过滤器对它们进行过滤

```php
<?php
$int = 123;
if(!filter_var($int, FILTER_VALIDATE_INT))			// 验证了一个整数
{
echo("不是一个合法的整数");
}
?>
```

Validating 过滤器：用于验证用户输入，严格的格式规则（比如 URL 或 E-Mail 验证），如果成功则返回预期的类型，如果失败则返回 FALSE。Sanitizing 过滤器：用于允许或禁止字符串中指定的字符，无数据格式规则，始终返回字符串。选项和标志用于向指定的过滤器添加额外的过滤选项，不同的过滤器有不同的选项和标志

```php
<?php
$var=300;
$int_options = array(
    "options"=>array
    (
        "min_range"=>0,
        "max_range"=>256
    )
); 
if(!filter_var($var, FILTER_VALIDATE_INT, $int_options)) 
{// 结果：不是一个合法的整数。选项必须放入一个名为 "options" 的相关数组中
    echo("不是一个合法的整数");
}
else
{
    echo("是个合法的整数");
}
if(!filter_has_var(INPUT_GET, "email"))			// 检测是否存在 "GET" 类型的 "email" 输入变量
{
    echo("没有 email 参数");
}
else
{
    if (!filter_input(INPUT_GET, "email", FILTER_VALIDATE_EMAIL))   // 检测它是否是有效的 e-mail 地址
    {
        echo "不是一个合法的 E-Mail";
    }
    else
    {
        echo "是一个合法的 E-Mail";
    }
}
?>
```

验证方式为 `.php?email=...?`，验证 url `$url = filter_input(INPUT_GET, "url", FILTER_SANITIZE_URL);`

```php
<?php
$filters = array
(
    "name" => array
    (
        "filter"=>FILTER_SANITIZE_STRING
    ),
    "age" => array
    (
        "filter"=>FILTER_VALIDATE_INT,
        "options"=>array
        (
            "min_range"=>1,
            "max_range"=>120
        )
    ),
    "email"=> FILTER_VALIDATE_EMAIL
);
 
$result = filter_input_array(INPUT_GET, $filters);
 
if (!$result["age"])
{
    echo("年龄必须在 1 到 120 之间。<br>");
}
elseif(!$result["email"])
{
    echo("E-Mail 不合法<br>");
}
else
{
    echo("输入正确");
}
?>
```

设置一个数组，其中包含了输入变量的名称和用于指定的输入变量的过滤器，调用 filter_input_array() 函数，参数包括 GET 输入变量及刚才设置的数组。检测 $result 变量中的 "age" 和 "email" 变量是否有非法的输入，如果存在非法输入，在使用 filter_input_array() 函数之后，输入变量为 FALSE。filter_input_array() 函数的第二个参数可以是数组或单一过滤器的 ID，

- 如果该参数是单一过滤器的 ID，那么这个指定的过滤器会过滤输入数组中所有的值。
- 如果该参数是一个数组，那么此数组必须是一个关联数组，其中包含的输入变量是数组的键（比如 "age" 输入变量） ，此数组的值必须是过滤器的 ID ，或者是规定了过滤器、标志和选项的数组

通过使用 FILTER_CALLBACK 过滤器，可以调用自定义的函数，把它作为一个过滤器来使用 	

```php
<?php
function convertSpace($string)
{
    return str_replace("_", ".", $string);
}
$string = "www_runoob_com!";
echo filter_var($string, FILTER_CALLBACK,
array("options"=>"convertSpace"));
$int = 122;
$min = 1;
$max = 200;
if (filter_var($int, FILTER_VALIDATE_INT, array("options" => array("min_range"=>$min, "max_range"=>$max))) === false)         // 检测一个 INT 型的变量是否在 1 到 200 内
    ...
// 检测一个 $ip 变量是否是 IPv6 地址:
if (!filter_var($ip, FILTER_VALIDATE_IP, FILTER_FLAG_IPV6) === false)
$url = "http://www.runoob.com";    
// 检测 $url 是否包含查询字符串
if (!filter_var($url, FILTER_VALIDATE_URL, FILTER_FLAG_QUERY_REQUIRED) === false)
$str = "<h1>Hello WorldÆØÅ!</h1>";
// 移除字符串中 ASCII 值大于 127 的字符，同样它也能移除 HTML 标签
$newstr = filter_var($str, FILTER_SANITIZE_STRING, FILTER_FLAG_STRIP_HIGH);
echo $newstr;
?>
```

过滤器参考手册：<https://www.runoob.com/php/php-ref-filter.html>

### JSON

在 php5.2.0 及以上版本已经内置 JSON 扩展

json_encode() 用于对变量进行 JSON 编码，函数只对 UTF-8 编码的数据有效，如果执行成功返回 JSON 数据，否则返回 FALSE。第二个参数是由以下常量组成的二进制掩码：JSON_HEX_QUOT，JSON_HEX_TAG，JSON_HEX_AMP，JSON_HEX_APOS， JSON_NUMERIC_CHECK，JSON_PRETTY_PRINT，JSON_UNESCAPED_SLASHES，JSON_FORCE_OBJECT

```php
<?php
    $arr = array('a' => 1, 'b' => 2, 'c' => 3, 'd' => 4, 'e' => 5);
	echo json_encode($arr);         
	// 将 PHP 数组转换为 JSON 格式数据，结果是 {"a":1,"b":2,"c":3,"d":4,"e":5}
    class Emp {
        public $name = "sachin";
        public $hobbies  = "sports";
        public $birthdate = "date('m/d/Y h:i:s a', "8/5/1974 12:20:03 p");";
        // 或者 date('m/d/Y h:i:s a', strtotime("8/5/1974 12:20:03"))
    }
    $e = new Emp();
    echo json_encode($e);
	// 结果是 {"name":"sachin","hobbies":"sports","birthdate":"08\/05\/1974 12:20:03 pm"}
?> 
```

json_decode() 函数用于对 JSON 格式的字符串进行解码，并转换为 PHP 变量。语法为

```php
mixed json_decode ($json_string [,$assoc = false [, $depth = 512 [, $options = 0 ]]])
```

- json_string: 待解码的 JSON 字符串，必须是 UTF-8 编码数据
- assoc: 当该参数为 TRUE 时，将返回数组，FALSE 时返回对象。
- **depth**: 整数类型的参数，它指定递归深度
- options: 二进制掩码，目前只支持 JSON_BIGINT_AS_STRING 

```php
<?php
   $json = '{"a":1,"b":2,"c":3,"d":4,"e":5}';
   var_dump(json_decode($json));         // 返回数组
   var_dump(json_decode($json, true));         
// 返回对象，结果为 object(stdClass)#1 (5) {...
?>
```

