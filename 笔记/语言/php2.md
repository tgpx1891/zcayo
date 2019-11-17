### PHP 7 新特性

PHP 7+ 版本极大地改进了性能，在一些 WordPress 基准测试当中，性能可以达到 PHP 5.6 的3倍。

### 数据库

关于 MySQL 的一点很棒的特性是，可以对它进行缩减，来支持嵌入的数据库应用程序。也许正因为如此，许多人认为 MySQL 仅仅能处理中小型的系统。PDO(PHP Data Objects)应用在 12 种不同数据库中， MySQLi("i" 意为 improved) 只针对 MySQL 数据库。两者都是面向对象, 但 MySQLi 还提供了 API 接口，两者都支持预处理语句。MySQLi 和 PDO可以通过在 PHP 页面运行 phpinfo() 查看是否安装成功（显示 mysqli 和 PDO）

```php
<?php
$servername = "localhost";
$dbName='test'; 
$username = "username";
$password = "password";
// 面向对象
$conn = new mysqli($servername, $username, $password, $dbname);        // 创建连接，$dbname 可以不加
if ($conn->connect_error) {         // 检测连接
    die("连接失败: " . $conn->connect_error);         // PHP 5.2.9 和 5.3.0 中添加
} 
if (mysqli_connect_error()) {         // 更早版本
    die("数据库连接失败: " . mysqli_connect_error());
}
$sql = "CREATE DATABASE myDB";         // 创建数据库
$sql2 = "CREATE TABLE MyGuests (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,          
firstname VARCHAR(30) NOT NULL,
lastname VARCHAR(30) NOT NULL,
email VARCHAR(50),
reg_date TIMESTAMP
)";         // 创建表UNSIGNED 使用无符号数值类型，0 及正数
$sql3 = "INSERT INTO MyGuests (firstname, lastname, email)
VALUES ('John', 'Doe', 'john@example.com')";         // 插入数据
$sql3 .= "INSERT INTO MyGuests (firstname, lastname, email)
VALUES ('Mary', 'Moe', 'mary@example.com');";         // 插入多条数据（每条语句须用 ; 分开）
$sql4 = "SELECT id, firstname, lastname FROM MyGuests";
if ($conn->query($sql) === TRUE) {         // 创建数据库
    echo "数据库创建成功";
} else {
    echo "Error creating database: " . $conn->error;
}
if ($conn->multi_query($sql3) === TRUE) {
    ...
$result = $conn->query($sql4);         // 读取数据
if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo "id: " . $row["id"]. " - Name: " . $row["firstname"]. " " . $row["lastname"]. "<br>";
    }
}
// 面向过程
$conn = mysqli_connect($servername, $username, $password);
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
if (mysqli_query($conn, $sql)) {         // 创建数据库
    echo "数据库创建成功";
} else {
    echo "Error creating database: " . mysqli_error($conn);
}
if (mysqli_multi_query($conn, $sql3)) {         // 插入多条数据
    ...
...
if (mysqli_num_rows($result) > 0) {         // 读取数据
    while($row = mysqli_fetch_assoc($result)) {
        echo "id: " . $row["id"]. " - Name: " . $row["firstname"]. " " . $row["lastname"]. "<br>";
    }
} 
$result = mysqli_query($con,"SELECT * FROM Persons
WHERE FirstName='Peter'");         // 使用 WHERE 子句
while($row = mysqli_fetch_array($result))       // 从结果集中取得一行作为数字数组或关联数组
{
    echo $row['FirstName'] . " " . $row['LastName']."<br>";
}
// PDO
try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbName", $username, $password);
    echo "连接成功"; 
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);    // 设置 PDO 错误模式为异常
    $conn->exec($sql);         // 使用 exec() ，因为没有结果返回
    $conn->beginTransaction();         // 开始事务
    $conn->exec("INSERT INTO MyGuests (firstname, lastname, email) 
    VALUES ('John', 'Doe', 'john@example.com')");
    $conn->exec("INSERT INTO MyGuests (firstname, lastname, email) 
    VALUES ('Mary', 'Moe', 'mary@example.com')");
    // 提交事务
    $conn->commit();
}
catch(PDOException $e)
{
    $conn->rollback();         // 如果执行失败回滚
    echo $e->getMessage();
}
$conn->close();         // 连接在脚本执行完后会自动关闭，面向对象
mysqli_close($conn);         // 面向过程
$conn = null;         // PDO
?>
```

new mysqli("localhost", "username", "password", "", port) 为数据库指定端口。读取数据中函数 num_rows() 返回的结果的行组数，如果返回的是多条数据，函数 fetch_assoc() 将结合集放入到关联数组并循环输出

数据类型操作手册：<https://www.runoob.com/sql/sql-datatypes.html>

mysqli 扩展提供了第二种方式用于插入语句，我们可以预处理语句及绑定参数。mysql 扩展可以不带数据发送语句或查询到mysql数据库，你可以向列关联或 "绑定" 变量

```php
<?php 
if ($conn->connect_error) {
    die("连接失败: " . $conn->connect_error);
} else {
    $sql = "INSERT INTO MyGuests(firstname, lastname, email)  VALUES(?, ?, ?)";
    $stmt = mysqli_stmt_init($conn);         // 为 mysqli_stmt_prepare() 初始化 statement 对象
    if (mysqli_stmt_prepare($stmt, $sql)) {         // 预处理语句
        mysqli_stmt_bind_param($stmt, 'sss', $firstname, $lastname, $email);     // 绑定参数
        $firstname = 'John';
        $lastname = 'Doe';
        $email = 'john@example.com';
        mysqli_stmt_execute($stmt);
        // 再插入一次
        $firstname = 'Mary';
        $lastname = 'Moe';
        $email = 'mary@example.com';
        mysqli_stmt_execute($stmt);
    }
}
// 另一种预处理语句
...
$stmt = $conn->prepare("INSERT INTO MyGuests (firstname, lastname, email) VALUES (?, ?, ?)");
$stmt->bind_param("sss", $firstname, $lastname, $email);
...
$stmt->execute();
...
$stmt->close();
$conn->close();
// PDO 中的预处理语句
try {
    ...
    $stmt = $conn->prepare("INSERT INTO MyGuests (firstname, lastname, email) 
    VALUES (:firstname, :lastname, :email)");         // 预处理 SQL 
    $stmt->bindParam(':firstname', $firstname);         // 绑定参数
    $stmt->bindParam(':lastname', $lastname);
    $stmt->bindParam(':email', $email);
     // 插入行
    $firstname = "John";
    $lastname = "Doe";
    $email = "john@example.com";
    $stmt->execute();
 	// 插入其他行
    $firstname = "Mary";
    $lastname = "Moe";
    $email = "mary@example.com";
    $stmt->execute();
}
...
echo "<table style='border: solid 1px black;'>";
echo "<tr><th>Id</th><th>Firstname</th><th>Lastname</th></tr>";
class TableRows extends RecursiveIteratorIterator {
    function __construct($it) { 
        parent::__construct($it, self::LEAVES_ONLY); 
    }
    function current() {
        return "<td style='width:150px;border:1px solid black;'>" . parent::current(). "</td>";
    }
    function beginChildren() { 
        echo "<tr>"; 
    } 
    function endChildren() { 
        echo "</tr>" . "\n";
    } 
} 
try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $stmt = $conn->prepare("SELECT id, firstname, lastname FROM MyGuests");          // 读取数据
    $stmt->execute();
    $result = $stmt->setFetchMode(PDO::FETCH_ASSOC);         // 设置结果集为关联数组
    foreach(new TableRows(new RecursiveArrayIterator($stmt->fetchAll())) as $k=>$v) { 
        echo $v;
    }
}
...
echo "</table>";
?>
```

`mysqli_stmt_bind_param` 中的 sss 表示三个参数都是字符串，其它形式如 i - 整数，d - 双精度浮点数，通过告诉数据库参数的数据类型，可以降低 SQL 注入的风险

预处理语句对于防止 MySQL 注入是非常有用的，可以用于执行多个相同的 SQL 语句，并且执行效率更高。预处理语句有两个主要优点：预处理语句大大减少了分析时间，只做了一次查询（虽然语句多次执行）；绑定参数减少了服务器带宽，你只需要发送查询的参数，而不是整个语句；预处理语句针对SQL注入是非常有用的，因为参数值发送后使用不同的协议，保证了数据的合法性

### ODBC

ODBC 是一种应用程序编程接口（Application Programming Interface，API），使我们有能力连接到某个数据源（比如一个 MS Access 数据库）

```php+HTML
<html>
<body>
<?php
$conn=odbc_connect('northwind','','');    // 创建了到达名为 northwind 的 DSN 的连接，没有用户名和密码
if (!$conn)
{
    exit("连接失败: " . $conn);
}
$sql="SELECT * FROM customers";
$rs=odbc_exec($conn,$sql);

if (!$rs)
{
    exit("SQL 语句错误");
}
echo "<table><tr>";
echo "<th>Companyname</th>";
echo "<th>Contactname</th></tr>";
while (odbc_fetch_row($rs))
{
    $compname=odbc_result($rs,"CompanyName");         // 或者 $compname=odbc_result($rs,1);
    $conname=odbc_result($rs,"ContactName");
    echo "<tr><td>$compname</td>";
    echo "<td>$conname</td></tr>";
}
odbc_close($conn);
echo "</table>";
?>
</body>
</html>
```

odbc_fetch_row() 函数用于判断是否能从结果集中返回记录，如果能够返回行，则函数返回 true，否则返回 false。函数有两个参数：ODBC 结果标识符和可选的行号。odbc_result() 函数用于从记录中读取字段，函数有两个参数：ODBC 结果标识符和字段编号或名称

### XML

XML 用于描述数据，其焦点是数据是什么，XML 文件描述了数据的结构。在 XML 中，没有预定义的标签。您必须定义自己的标签。XML教程：<https://www.runoob.com/xml/xml-tutorial.html>。内建的 Expat 解析器使在 PHP 中处理 XML 文档成为可能，如需读取和更新、创建和处理一个 XML 文档，您需要 XML 解析器。

有两种基本的 XML 解析器类型：基于树的解析器，这种解析器把 XML 文档转换为树型结构，它分析整篇文档，并提供了对树中元素的访问，例如文档对象模型 (DOM)；基于事件的解析器，将 XML 文档视为一系列的事件，当某个具体的事件发生时，解析器会调用函数来处理。Expat 解析器是基于事件的解析器，基于事件的解析器集中在 XML 文档的内容，而不是它们的结构。正因为如此，基于事件的解析器能够比基于树的解析器更快地访问数据

例如`<from>Jani</from>`，基于事件的解析器把上面的 XML 报告为一连串的三个事件：开始元素 from，开始 CDATA 部分，值：Jani，关闭元素 from，这个实例是无效的 XML，因为没有与它关联的文档类型声明 (DTD)。然而，在使用 Expat 解析器时，这没有区别。Expat 是不检查有效性的解析器，忽略任何 DTD。作为一款基于事件、非验证的 XML 解析器，Expat 快速且轻巧，十分适合 PHP 的 Web 应用程序。但是 XML 文档必须形式良好，否则 Expat 会生成错误

```php
/* test.xml 文件
<?xml version="1.0" encoding="ISO-8859-1"?>
<note>
<to>Tove</to>
<from>Jani</from>
<heading>Reminder</heading>
<body>Don't forget me this weekend!</body>
</note>
*/
<?php
$parser=xml_parser_create();         // 初始化 XML 解析器（parser）
function start($parser,$element_name,$element_attrs)   //Function to use at the start of an element
{
    switch($element_name)
    {
        case "NOTE":
        echo "-- Note --<br>";
        break;
        case "TO":
        echo "To: ";
        break;
        case "FROM":
        echo "From: ";
        break;
        case "HEADING":
        echo "Heading: ";
        break;
        case "BODY":
        echo "Message: ";
    }
}
function stop($parser,$element_name)         // Function to use at the end of an element
{
	echo "<br>";
}
function char($parser,$data)         // Function to use when finding character data
{
	echo $data;
}
xml_set_element_handler($parser,"start","stop");         // 当解析器遇到开始和结束标签时执行哪个函数
xml_set_character_data_handler($parser,"char");         // 当解析器遇到字符数据时执行哪个函数
$fp=fopen("test.xml","r");         // Open XML file
while ($data=fread($fp,4096))         // Read data
{
    // 解析文件 "test.xml"
    xml_parse($parser,$data,feof($fp)) or 
    // 万一有错误的话，添加 xml_error_string() 函数把 XML 错误转换为文本说明
    die (sprintf("XML Error: %s at line %d", xml_error_string(xml_get_error_code($parser)), 		xml_get_current_line_number($parser)));
}
xml_parser_free($parser);         // 释放分配给 xml_parser_create() 函数的内存
?>
/* 输出结果
-- Note --
To: Tove
From: Jani
Heading: Reminder
Message: Don't forget me this weekend!
*/
```

feof() 函数测试文件指针是否到了文件末尾，如果 xml_parse第三个参数是 TRUE，则 "xml" 参数中的数据为当前解析中最后一段数据

PHP XML Parser 参考手册：runoob.com/php/php-ref-xml.html

#### DOM

内建的 DOM 解析器使在 PHP 中处理 XML 文档成为可能。W3C DOM 提供了针对 HTML 和 XML 文档的标准对象集，以及用于访问和操作这些文档的标准接口。W3C DOM 被分为不同的部分（Core, XML 和 HTML）和不同的级别（DOM Level 1/2/3）：Core DOM - 为任何结构化文档定义标准的对象集；XML DOM - 为 XML 文档定义标准的对象集；HTML DOM - 为 HTML 文档定义标准的对象集

XML DOM 教程：https://www.runoob.com/xml/xml-dom.html

DOM 解析器是基于树的解析器。XML DOM 把下面的 XML 视为一个树形结构：Level 1: XML 文档，Level 2: 根元素： \<from>，Level 3: 文本元素： "Jani"

```php
/* note.xml 文件 
<?xml version="1.0" encoding="ISO-8859-1"?>
<from>Jani</from>
*/
<?php
$xmlDoc = new DOMDocument();         // 创建了一个 DOMDocument 对象
$xmlDoc->load("test.xml");         // 把 "note.xml" 中的 XML 载入这个文档对象中
print $xmlDoc->saveXML();         
// 把内部 XML 文档放入一个字符串，以便可以输出它，结果为 ToveJaniReminder Don't forget me this weekend!
$x = $xmlDoc->documentElement;
foreach ($x->childNodes AS $item)         // 遍历 <note> 元素的所有元素
{
    print $item->nodeName . " = " . $item->nodeValue . "<br>";
}
?>
/* 结果为
#text =
to = Tove
...
*/
```

每个元素之间存在空的文本节点，当 XML 生成时，它通常会在节点之间包含空白。XML DOM 解析器把它们当作普通的元素，如果您不注意它们，有时会产生问题

#### SimpleXML

SimpleXML 处理最普通的 XML 任务，其余的任务则交由其它扩展处理。SimpleXML 是 PHP 5 中的新特性。SimpleXML 扩展提供了一种获取 XML 元素的名称和文本的简单方式。与 DOM 或 Expat 解析器相比，SimpleXML 仅仅用几行代码就可以从 XML 元素中读取文本数据。当执行类似读取/提取 XML 文件/字符串的数据或者编辑文本节点或属性的基础任务时，SimpleXML 使用起来非常快捷。然而，在处理高级 XML 时，比如命名空间，最好使用 Expat 解析器或 XML DOM

SimpleXML 可把 XML 文档（或 XML 字符串）转换为对象，元素被转换为 SimpleXMLElement 对象的单一属性。当同一级别上存在多个元素时，它们会被置于数组中。属性通过使用关联数组进行访问，其中的索引对应属性名称。元素内部的文本被转换为字符串。如果一个元素拥有多个文本节点，则按照它们被找到的顺序进行排列

```php
<?php
$xml=simplexml_load_file("test.xml");
print_r($xml);
// 输出 SimpleXMLElement 对象的键和元素，结果为 SimpleXMLElement Object ( [to] => Tove [from] => Jani [heading] => Reminder [body] => Don't forget me this weekend! )
// 输出 XML 文件中每个元素的数据
echo $xml->to . "<br>";         // 输出 Tove
echo $xml->from . "<br>";
echo $xml->heading . "<br>";
echo $xml->body;
// 输出每个子节点的元素名称和数据
cho $xml->getName() . "<br>";
foreach($xml->children() as $child)
{
    echo $child->getName() . ": " . $child . "<br>";
}
?>
/* 结果
note
to: Tove
...
*/
```

PHP SimpleXML 参考手册：https://www.runoob.com/php/php-ref-simplexml.html

### AJAX 

AJAX（Asynchronous JavaScript and XML） 是一种在无需重新加载整个网页的情况下，能够更新部分网页的技术。通过在后台与服务器进行少量数据交换，使网页实现异步更新。AJAX 基于因特网标准，并使用以下技术组合：XMLHttpRequest 对象（与服务器异步交互数据）、JavaScript/DOM（显示/取回信息）、CSS（设置数据的样式）和 XML（常用作数据传输的格式）。AJAX 应用程序与浏览器和平台无关

![ajax](E:\我的电脑\图片\学习\前端\ajax.gif)

 AJAX 教程：https://www.runoob.com/ajax/

```html
<html>
<head>
<script>
function showHint(str)
{
    if (str.length==0)
    { 
        document.getElementById("txtHint").innerHTML="";         // 清空 txtHint 占位符的内容
        return;
    }
    if (window.XMLHttpRequest)
    {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行的代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {    
        //IE6, IE5 浏览器执行的代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()         // 创建在服务器响应就绪时执行的函数
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","gethint.php?q="+str,true);         // 向服务器上的文件发送请求
    xmlhttp.send();
}
</script>
</head>
<body>
<p><b>在输入框中输入一个姓名:</b></p>
<form> 
姓名: <input type="text" onkeyup="showHint(this.value)">
</form>
<p>返回值: <span id="txtHint"></span></p>
</body>
</html>
```

以下是 gethint.php 文件

```php
<?php
// 将姓名填充到数组中
$a[]="Anna";
$a[]="Brittany";
...
$q=$_GET["q"];         // 从请求URL地址中获取 q 参数
if (strlen($q) > 0)         // 查找是否有匹配值， 如果 q>0
{
    $hint="";
    for($i=0; $i<count($a); $i++)
    {
        if (strtolower($q)==strtolower(substr($a[$i],0,strlen($q))))// 查找忽略大小写的匹配开头字符串
        {
            if ($hint=="")
            {
                $hint=$a[$i];
            }
            else
            {
                $hint=$hint." , ".$a[$i];
            }
        }
    }
}
if ($hint == "")         // 如果没有匹配值设置输出为 "no suggestion" 
{
    $response="no suggestion";
}
else
{
    $response=$hint;
}
echo $response;         // 输出返回值（关键）
?>
```

#### Ajax 跨域问题解决方案

通过设置`Access-Control-Allow-Origin`来实现跨域。例如：客户端的域名是client.runoob.com，而请求的域名是server.runoob.com。如果直接使用ajax访问，会有以下错误：

```
XMLHttpRequest cannot load http://server.runoob.com/server.php. No 'Access-Control-Allow-Origin' header is present on the requested resource.Origin 'http://client.runoob.com' is therefore not allowed access.
```

在http://server.runoob.com/server.php文件头部添加如下代码：

```
# 指定某域名（http://client.runoob.com）跨域访问
header('Access-Control-Allow-Origin:http://client.runoob.com');

# 指定多个域名（http://client1.runoob.com、http://client2.runoob.com等）跨域访问
$origin = isset($_SERVER['HTTP_ORIGIN'])? $_SERVER['HTTP_ORIGIN'] : '';  
$allow_origin = array(  
    'http://client1.runoob.com',  
    'http://client2.runoob.com'  
);  
if(in_array($origin, $allow_origin)){  # in_array() 函数搜索数组中是否存在指定的值
    header('Access-Control-Allow-Origin:'.$origin);       
}

# 允许所有域名访问
header('Access-Control-Allow-Origin:*'); 
```

#### AJAX 与 MySQL

AJAX 可用来与数据库进行交互式通信

```html
xmlhttp.open("GET","getsite_mysql.php?q="+str,true);
...
<form>
<select name="users" onchange="showSite(this.value)">         <!-- 和 showHint(str)类似 -->
<option value="">选择一个网站:</option>
<option value="1">Google</option>
<option value="2">淘宝</option>
<option value="3">菜鸟教程</option>
<option value="4">微博</option>
<option value="5">Facebook</option>
</select>
</form>
<br>
<div id="txtHint"><b>网站信息显示在这里……</b></div>
...
```

onchange 事件会在域的内容改变时发生。当用户在上面的下拉列表中选择某位用户时，会执行名为 "showSite()" 的函数。getsite_mysql.php 文件内容如下：

```php
<?php
$q = isset($_GET["q"]) ? intval($_GET["q"]) : '';
if(empty($q)) {
        echo '请选择一个网站';
        exit;
}
$con = mysqli_connect('localhost','root','123456');
if (!$con)
{
        die('Could not connect: ' . mysqli_error($con));
}
mysqli_select_db($con,"test");         // 选择数据库
mysqli_set_charset($con, "utf8");         // 设置编码，防止中文乱码
$sql="SELECT * FROM Websites WHERE id = '".$q."'";
$result = mysqli_query($con,$sql);
echo "<table border='1'>
<tr>
<th>ID</th>
<th>网站名</th>
<th>网站 URL</th>
<th>Alexa 排名</th>
<th>国家</th>
</tr>";
while($row = mysqli_fetch_array($result))
{
        echo "<tr>";
        echo "<td>" . $row['id'] . "</td>";
        echo "<td>" . $row['name'] . "</td>";
        echo "<td>" . $row['url'] . "</td>";
        echo "<td>" . $row['alexa'] . "</td>";
        echo "<td>" . $row['country'] . "</td>";
        echo "</tr>";
}
echo "</table>";
mysqli_close($con);
?>
```

#### AJAX 与 XML

AJAX 可用来与 XML 文件进行交互式通信

```html
xmlhttp.open("GET","getcd.php?q="+str,true);
...
<form>
Select a CD:
<select name="cds" onchange="showCD(this.value)">
<option value="">Select a CD:</option>
<option value="Bob Dylan">Bob Dylan</option>
<option value="Bonnie Tyler">Bonnie Tyler</option>
<option value="Dolly Parton">Dolly Parton</option>
</select>
</form>
<div id="txtHint"><b>CD info will be listed here...</b></div>
...
```

当用户在上面的下拉列表中选择某张 CD 时，会执行名为 "showCD()" 的函数

```php
/* cd_catalog.xml 文件
<CATALOG>
<CD>
<TITLE>One night only</TITLE>
<ARTIST>Bee Gees</ARTIST>
<COUNTRY>UK</COUNTRY>
<COMPANY>Polydor</COMPANY>
<PRICE>10.90</PRICE>
<YEAR>1998</YEAR>
</CD>
...
</CATALOG>
*/
// getcd.php 文件
<?php
$q=$_GET["q"];
$xmlDoc = new DOMDocument();
$xmlDoc->load("cd_catalog.xml");
$x=$xmlDoc->getElementsByTagName('ARTIST');
for ($i=0; $i<=$x->length-1; $i++)
{
    if ($x->item($i)->nodeType==1)			// 1 是元素节点，2 是属性节点
    {
        if ($x->item($i)->childNodes->item(0)->nodeValue == $q)
        {
            $y=($x->item($i)->parentNode);
        }
    }
}
$cd=($y->childNodes);
for ($i=0;$i<$cd->length;$i++)
{ 
    
    if ($cd->item($i)->nodeType==1)			// 处理元素节点
    {
        echo("<b>" . $cd->item($i)->nodeName . ":</b> ");			// 获取标签名字
        echo($cd->item($i)->childNodes->item(0)->nodeValue);			// 获取标签值
        echo("<br>");
    }
}
?>
```

AJAX 实时搜索

```php+HTML
...
document.getElementById("livesearch").innerHTML=xmlhttp.responseText;
document.getElementById("livesearch").style.border="1px solid #A5ACB2";
...
xmlhttp.open("GET","livesearch.php?q="+str,true);
...
<form>
<input type="text" size="30" onkeyup="showResult(this.value)">
<div id="livesearch"></div>
</form>
....
<!-- 以下是 livesearch.php 文件 -->
<?php
$xmlDoc=new DOMDocument();
$xmlDoc->load("links.xml");
$x=$xmlDoc->getElementsByTagName('link');
$q=$_GET["q"];
if (strlen($q)>0)
{
    $hint="";
    for($i=0; $i<($x->length); $i++)
    {
        $y=$x->item($i)->getElementsByTagName('title');
        $z=$x->item($i)->getElementsByTagName('url');
        if ($y->item(0)->nodeType==1)
        {
            if (stristr($y->item(0)->childNodes->item(0)->nodeValue,$q))    // 找到匹配搜索的链接
            {
                if ($hint=="")
                {
                    $hint="<a href='" . 
                    $z->item(0)->childNodes->item(0)->nodeValue . 
                    "' target='_blank'>" . 
                    $y->item(0)->childNodes->item(0)->nodeValue . "</a>";
                }
                else
                {
                    $hint=$hint . "<br /><a href='" . 
                    $z->item(0)->childNodes->item(0)->nodeValue . 
                    "' target='_blank'>" . 
                    $y->item(0)->childNodes->item(0)->nodeValue . "</a>";
                }
            }
        }
    }
}
if ($hint=="")
{
    $response="no suggestion";
}
else
{
    $response=$hint;
}
echo $response;
?>
<!-- 以下是 links.xml 文件
<pages>
<link>
<title>HTML a 标签</title>
<url>http://www.runoob.com/tags/tag-a.html</url>
</link>
...
-->
```

#### RSS 阅读器

RSS 阅读器用于阅读 RSS Feed

```php+HTML
document.getElementById("rssOutput").innerHTML=xmlhttp.responseText;
...
xmlhttp.open("GET","getrss.php?q="+str,true);
...
<form>
<select onchange="showRSS(this.value)">
<option value="">选择一个 RSS-feed:</option>
<option value="rss">读取 RSS 数据</option>
</select>
</form>
<br>
<div id="rssOutput">RSS-feed 数据列表...</div>
...
<!-- rss_demo.xml 文件
<rss version="2.0">
<channel>
<title>菜鸟教程</title>
<link>http://www.runoob.com</link>
<description>学的不仅技术，更是梦想！！！</description>
<item>
<title>RSS 教程</title>
<link>http://www.runoob.com/rss/rss-tutorial.html</link>
<description>通过使用 RSS，您可以有选择地浏览您感兴趣的以及与您的工作相关的新闻。</description>
</item>
...
</channel>
</rss>
-->
<?php
$xmlDoc = new DOMDocument();
$xmlDoc->load("rss_demo.xml");
$channel=$xmlDoc->getElementsByTagName('channel')->item(0);         // 从 "<channel>" 中读取元素
$channel_title = $channel->getElementsByTagName('title')
->item(0)->childNodes->item(0)->nodeValue;
$channel_link = $channel->getElementsByTagName('link')
->item(0)->childNodes->item(0)->nodeValue;
$channel_desc = $channel->getElementsByTagName('description')
->item(0)->childNodes->item(0)->nodeValue;
echo("<p><a href='" . $channel_link         // 输出 "<channel>" 中的元素
  . "'>" . $channel_title . "</a>");
echo("<br>");
echo($channel_desc . "</p>");
$x=$xmlDoc->getElementsByTagName('item');         // 输出 "<item>" 中的元素
for ($i=0; $i<=1; $i++) {
        $item_title=$x->item($i)->getElementsByTagName('title')
        ->item(0)->childNodes->item(0)->nodeValue;
        $item_link=$x->item($i)->getElementsByTagName('link')
        ->item(0)->childNodes->item(0)->nodeValue;
        $item_desc=$x->item($i)->getElementsByTagName('description')
        ->item(0)->childNodes->item(0)->nodeValue;
        echo ("<p><a href='" . $item_link
        . "'>" . $item_title . "</a>");
        echo ("<br>");
        echo ($item_desc . "</p>");
}
?>
```

#### AJAX 投票

```php+HTML
...
<div id="poll">
<h3>你喜欢 PHP 和 AJAX 吗?</h3>
<form>
是:
<input type="radio" name="vote" value="0" onclick="getVote(this.value)">
<br>否:
<input type="radio" name="vote" value="1" onclick="getVote(this.value)">
</form>
</div>
...
<!-- poll_vote.php 文件 -->
<?php
$vote = htmlspecialchars($_REQUEST['vote']);
$content = file("poll_result.txt");         // 获取文件中存储的数据
$array = explode("||", $content[0]);			// 将数据分割到数组中
$yes = $array[0];
$no = $array[1];
if ($vote == 0)
{
  $yes = $yes + 1;
}
if ($vote == 1)
{
  $no = $no + 1;
}
$insertvote = $yes."||".$no;			// 插入投票数据
$fp = fopen("poll_result.txt","w");			// w 只写，会打开并清空文件的内容
fputs($fp,$insertvote);
fclose($fp);
?>
<h2>结果:</h2>
<table>
  <tr>
  <td>是:</td>
  <td>
  <span style="display: inline-block; background-color:green;
      width:<?php echo(100*round($yes/($no+$yes),2)); ?>px;
      height:20px;" ></span>
  <?php echo(100*round($yes/($no+$yes),2)); ?>%
  </td>
  </tr>
  <tr>
  <td>否:</td>
  <td>
  <span style="display: inline-block; background-color:red;
      width:<?php echo(100*round($no/($no+$yes),2)); ?>px;
      height:20px;"></span>
  <?php echo(100*round($no/($no+$yes),2)); ?>%
  </td>
  </tr>
</table>
```

file() 函数把整个文件读入一个数组中，数组中的每个元素都是文件中相应的一行，包括换行符在内

### 参考手册

#### Array 函数

<https://www.runoob.com/php/php-ref-array.html>

#### 可用的函数

<https://www.runoob.com/php/php-variable-handling-functions.html>

#### 正则表达式(PCRE)

正则表达式(regular expression)描述了一种字符串匹配的模式，可以用来检查一个串是否含有某种子串、将匹配的子串做替换或者从某个串中取出符合某个条件的子串等

<https://www.runoob.com/php/php-pcre.html>

#### 时区

<https://www.runoob.com/php/php-ref-timezones.html>

#### Zip File 函数

Zip File 函数允许您读取压缩文件，如需在服务器上运行 Zip File 函数，必须安装这些库：Guido Draheim 的 ZZIPlib 库和Zip PELC 扩展

<https://www.runoob.com/php/php-ref-zip.html>

#### String 函数

<https://www.runoob.com/php/php-ref-string.html>

#### XML Parser 函数

<https://www.runoob.com/php/php-ref-xml.html>

#### SimpleXML 函数

<https://www.runoob.com/php/php-ref-simplexml.html>

#### Libxml 函数

<https://www.runoob.com/php/php-ref-libxml.html>

#### PDO

<https://www.runoob.com/php/php-pdo.html>

#### MySQLi 函数

<https://www.runoob.com/php/php-ref-mysqli.html>

#### 杂项 函数

把不属于其他类别的函数归纳到杂项函数类别

#### Math 函数

<https://www.runoob.com/php/php-ref-math.html>

#### Mail 函数

<https://www.runoob.com/php/php-ref-mail.html>

#### HTTP 函数

<https://www.runoob.com/php/php-ref-http.html>

#### FTP 函数

<https://www.runoob.com/php/php-ref-ftp.html>

#### Filter 函数

<https://www.runoob.com/php/php-ref-filter.html>

#### Filesystem 函数

Filesystem 函数允许您访问和操作文件系统

<https://www.runoob.com/php/php-ref-filesystem.html>

#### Error 和 Logging 函数

<https://www.runoob.com/php/php-ref-error.html>

#### Directory 函数

<https://www.runoob.com/php/php-ref-directory.html>

#### Date/Time 函数

<https://www.runoob.com/php/php-ref-date.html>

#### cURL 函数

<https://www.runoob.com/php/php-ref-curl.html>

#### Calendar 函数

<https://www.runoob.com/php/php-ref-calendar.html>

### Composer

Composer 是 PHP 的一个依赖管理工具。我们可以在项目中声明所依赖的外部工具库，Composer 会帮你安装这些依赖的库文件，有了它，我们就可以很轻松的使用一个命令将其他人的优秀代码引用到我们的项目中来。Composer 默认情况下不是全局安装，而是基于指定的项目的某个目录中（例如 vendor）进行安装

### RESTful

REST（英文：Representational State Transfer，简称REST) ，指的是一组架构约束条件和原则。

符合REST设计风格的Web API称为RESTful API。它从以下三个方面资源进行定义：

- 直观简短的资源地址：URI，比如`http://example.com/resources/`。
- 传输的资源：Web服务接受与返回的互联网媒体类型，比如 JSON，XML，YAM等。
- 对资源的操作：Web服务在该资源上所支持的一系列请求方法（比如 POST，GET，PUT或DELETE）

Services URI 映射：Apache 服务器的 .htaccess 应设置好对应的 Rewrite 规则。最后通过 http://localhost/restexample/site/list/ 访问

- 服务类：Site.php
- Web Service 控制器：RestController.php
- 简单的 RESTful 基础类：SimpleRest.php
- Web Service 处理类：SiteRestHandler.php

实例：<https://www.runoob.com/php/php-restful.html>

### 图像处理

<https://www.runoob.com/php/php-image-gd.html>