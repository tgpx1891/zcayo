## HTML

HTML 是 Hyper Text Markup Language 超文本标记语言 的缩写，由一套标记标签 （markup tag）组成，通常就叫标签。标签由开始标签和结束标签组成，标签之间的文本叫做内容。元素指的是从开始标签到结束标签之间所有的代码

开发一个 html 文件，可以有很多方式，比如 Dreamweaver,HBuilder 等等专业工具。最简单的方式就是用记事本写一个

中文乱码问题

可以在浏览器上设置编码方式为 GB2312 或者 UTF-8，或者在html的最前面加上编码设置

```html
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
</head> 
```

一个完整的 HTML 文件，应该至少包含 html 元素，body 元素，以及里面的内容

```html
<html>
 <body>
   <h1>标题</h1>  
 </body>
</html>
```

实际开发中，即使一个元素不完整，也是可以正常显示的。浏览器能够渲染你写的“错误的代码” ，不过，未来不一定能正常显示。有的特殊元素，没有内容，即开始和结束标签直接放在一起，比如 `<br/>`，`<hr/>`

属性用来修饰标签的，比如要设置一个标题居中`<h1 align="center">居中标题</h1>`，写在开始标签里的 align="center" ，就叫属性，align 是属性名，center 是属性值，属性值应该使用双引号括起来

html使用`<!-- --> `进行注释

### 基本元素

标题会自动粗体，大写其中的内容，并且带有换行效果，一般会使用`<h1>` 到 `<h6>` 分别表示不同大小的标题  

`<p>`标签即表示段落，是paragraph的缩写，自带换行效果

`<b>`，`<strong>`都可以用来实现粗体的效果。区别是：
b 是 bold 的缩写，仅仅表示该文本是粗体的，**并不暗示这段文字的重要性**，strong 虽然也是粗体，但是更多的是强调**语义上的加重**，提醒用户该文本的重要性。 在SEO（搜索引擎优化）的时候，也更加容易帮助用户找到重点的内容，推荐使用strong

`<i>`和`<em>`都可以表示斜体效果。  区别是：
i 是 italic 的缩写，仅仅表示该文本是斜体的，并不暗示这段文字的重要性；em 是 Emphasized 的缩写，虽然也是斜体，但是更多的是强调语义上的加重，提醒用户该文本的重要性。 常常用于引入新的术语的时候使用  

 有时候，需要在网页上显示代码，比如java代码，就需要用到`<pre>` （预格式）

删除标签`<del>`，delete的缩写，通常来讲，不要给普通文本加下划线，因为用户会误以为是一个超链

下划线标签`<ins>`

#### html 图像

`<img> `即图像标签，需要设置其属性 src 指定图像的路径。

- 如果是本地文件，只需把图片放在同一个目录下即可，src直接使用文件名，不需要 /；
- 图片在上级目录，则在src上加上 ../，即可访问上级目录的图片；
- 如果是在上级目录的上级目录，则使用 ../../；
- src使用图片所在的绝对路径，并在前面加上file://

如果图片不存在，默认会显示一个缺失图片，这是不友好的，所以可以加上alt属性。当图片存在的时候，alt是不会显示的；当图片不存在的时候，alt就会出现

```html
<img src="http://how2j.cn/example.gif"/>
<!-- 如果设置的大小比原图片大，则会产生失真效果 -->
<img width="200" height="200" src="http://how2j.cn/example.gif"/>
<div align="left">         <!-- 还有 center 和 right -->
  <img src="http://how2j.cn/example.gif"/>
</div>
<img src="http://how2j.cn/example.gif" alt="这个是一个图片" />
```

#### html 超链

`<a>`标签即用来显示超链，完整元素是`<a href="跳转到的页面地址">超链显示文本</a>`

```html
<a href="http://www.12306.com">12306</a>
<a href="http://www.12306.cn" target="_blank">http://www.12306.cn</a>   <!-- 在新的页面打开超链 -->
<!-- 当鼠标放在超链上的时候，就会弹出提示文字 -->
<a href="http://www.12306.com" title="跳转到http://www.12306.com">www.12306.com</a>
<a href="http://www.12306.com">         <!-- 使用图片作为超链 -->
<img src="http://how2j.cn/example.gif"/>
</a>
```

#### html 表格

`<table>`标签用于显示一个表格，`<tr> `表示行，`<td> `表示列又叫单元格

```html
<table border="1" width="200px">
  <tr bgcolor="gray">
      <td width="50px">1</td>
      <td>2</td>
  </tr>
  <tr>
      <td>3</td>
      <td  bgcolor="pink">4</td>
  </tr>
  <tr>
      <td>a</td>
      <td>b</td>
  </tr>
</table>
```

- 设置table的属性 border，边框

- 设置table的属性 width，宽度，px即像素的意思，比如你的分辨率是1024X768,则你的屏幕横向就有1024个像素

- 设置td的属性width，在示例里，1单元格设置了宽度，那么3，和a单元格，自动继承该宽度，2单元格的宽度由table宽度和1单元格的宽度决定

- 设置td的属性width为百分数``<``td` `width``=``"80%"``>1</``td``>``，单元格宽度相对值

- 设置td的属性 align，单元格水平对齐

  `<td width="50%" align="left">1</td>` `<td align="center">3</td>` `<td align="right">a</td>`

- 设置td的属性 valign，单元格垂直对齐

  `<td width="50%" valign="top" >1</td>`  `<td valign="middle"  >3</td>` `<td valign="bottom">a</td>`

- 设置td的属性 colspan`<td colspan="2" >1，2</td>`，横跨两列, 水平合并

- 设置td的属性 rowspan``<``td` `rowspan``=``"2"``>1,3</``td``>``，横跨两行, 垂直合并

- 设置 tr 或者 td 的属性 bgcolor，背景色

#### html 列表

列表分无序列表和有序列表，分别用`<ul>`标签和`<ol>`标签表示

```html
<ul>
<li>DOTA</li>
<li>LOL</li>
</ul>
```

#### html 块

`<div>`，`<span>`这两种标签都是布局用的，这种标签本身没有任何显示效果，通常是用来结合css进行页面布局。div是块元素，即自动换行，常见的块元素还有h1,table,p。span是内联元素，即不会换行，常见的内联元素还有img,a,b,strong

```html
<img style="margin-left:50px" src="http://how2j.cn/example.gif"/>
<br/>
<div style="margin-left:100px" >
 <img src="http://how2j.cn/example.gif"/>
  <br/>
 <img src="http://how2j.cn/example.gif"/>
</div>
```

使用`<font>`标签表示字体，font 常用的属性有 color 和 size, 分别表示颜色和大小

```html
<font color="blue" size="+2">蓝色大2号字体</font>
<font color="#ff0000" >用#ff0000表示红色字体</font>
```

在html中，颜色通常使用两种方式来表示：
1. 预定义的颜色名字，比如red, blue
2. rgb格式，分别代表红绿蓝的比例，rgb(250,0,255) 即表示红色是满的，没有绿色，蓝色是满的，即红色和蓝色混合在一起：紫色
3. 颜色对应的16进制，比如 #ff0000 就表示红色，#00ff00 等同于 rgb(0,255,0)

#### 颜色速查手册

<http://how2j.cn/k/html/html-font/644.html>

`<iframe> `即内联框架，通过内联框架 可以实现在网页中“插入”网页。相当于浏览器里面有个小浏览器，在这个小浏览器中，打开另一个网页

```html
<iframe src="http://how2j.cn/" width="600px" height="400px"></iframe>
```

### 表单元素

#### html 文本框

 ` <input type="text">`即表示文本框，并且只能够输入一行，如果要输入多行，使用文本域`<textarea>`

注： `<input> `标签很特别，一般是不需要写成`<input />`或者`<input></input> `这样，并且`<input> `这样的写法也是满足标准的  

```html
<input type="text" size="10" value="有初始值的文本框" placeholder="请输入账号">
```

placeholder 是一个 html5 的属性，用于设置背景文字，对于大多数的已经支持 html5 的浏览器来说，是可以看到效果的，但是对于老的不支持 html5 的浏览器，比如 ie8，就看不到效果

`<input type="password">` 即表示密码框，输入的数据会自动显示为星号

### html 表单

`<form>`用于向服务器提交数据，比如账号密码

```html
<form action="http://how2j.cn/study/login.jsp" method="get">  
账号：<input type="text" name="name"> <br/>
密码：<input type="password" name="password" > <br/>
	 <input type="submit" value="登陆">
</form>
```

action="/study/login.jsp"表示把账号和密码提交到 login.jsp 这个页面去。

- 使用method="get" 提交数据是常用的提交数据的方式，如果form元素没有提供method属性，默认就是get方式提交数据，get方式的一个特点就是，可以在浏览器的地址栏看到提交的参数，即便是密码也看得到；
- 使用method="post" 也可以提交数据，post不会在地址栏显示提交的参数，如果要提交二进制数据，比如上传文件，必须采用post方式

#### get和post的区别

get 是 form 默认的提交方式，如果通过一个超链访问某个地址，是get方式；如果在地址栏直接输入某个地址，是get方式
提交数据会在浏览器显示出来；不可以用于提交二进制数据，比如上传文件
post 必须在 form 上通过 method="post" 显示指定，提交数据不会在浏览器显示出来；可以用于提交二进制数据，比如上传文件

### html 单选框、复选框和下拉列表

`<input type="radio" >`表示单选框，两个单选，都可以同时选中。 为了达到，同一时间，只能选中其一的效果，需要使用分组。分组即，多个单选框，都在一个分组里，同一时间，只能选中一个单选框，设置name属性相同即可

```html
<p>今天晚上做什么？</p>
学习java<input type="radio" name="activity" checked="checked" value="学习java" > <br/>
LOL<input type="radio" name="activity"  value="lol"> <br/>
```

checked 属性设置默认选中

`<input type="checkbox">` 即表示复选框

```html
学习java<input type="checkbox" value="学习java" > <br/>
东京热<input type="checkbox" checked="checked" name="activity" value="tokyohot" > <br/>
```

注：加 name属性可以在以后和后台交互时，可以通过 name 获取值

`<select>`即下拉列表，需要配合`<option>`使用

```html
<select size="3" multiple="multiple">
 <option selected="selected">火影</option>
 <option >海贼</option>
 <option >七龙珠</option>
</select>
```

设置 multiple 属性可以多选，使用ctrl或者shift；使用属性 size 设置高度；selected 属性设置默认选中

`<textarea>`即文本域，与文本框不同的是，文本域可以有多行，并且可以有滚动条

```htnl
<textarea cols="30" rows="8">123456789</textarea>
```

使用属性 cols 和 rows设置 每行最多大字符数和行数

### html 按钮、提交和重置

`<input type="button"> `即普通按钮，普通按钮不具备提交 form 的效果；`<input type="submit">` 即为提交按钮
用于提交form，把数据提交到服务端；`<input type="reset">` 重置按钮 可以把输入框的改动复原

```html
<form action="/study/login.jsp">
账号：<input type="text" name="name"> <br/>
密码：<input type="password" name="password" > <br/>
	 <input type="button" value="一个按钮">         <!-- 不具备提交效果 -->
	 <input type="submit" value="提交">
	 <input type="reset" value="重置">
     <input type="image" src="http://how2j.cn/example.gif">         <!-- 使用图像进行提交 -->
</form>
```

login.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>    
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String password = request.getParameter("password");  
%>
您提交的账号名是 :<%=name%> <br/>
您提交的密码是 :<%=password%>
<br>
<a href="javascript:history.back()">返回</a>
```

`<button></button>`即按钮标签，与`<input type="button">`不同的是，`<button>`标签功能更为丰富，按钮标签里的内容可以是文字也可以是图像。如果button的type=“submit” ，那么它就具备提交form的功能  

```html
<button>按钮</button>         <!-- button里是文字 -->
<button><img src="http://how2j.cn/example.gif"/></button>         <!-- button里是图片 -->
<button type="submit">登陆</button>         <!-- 具备提交效果 -->
```

设置 type="submit"，IE 下 button 的 type 的默认值为 button 不具备提交功能，其他浏览器type的默认值是submit

## CSS

不使用 css 给每一个单元格加上背景颜色，就需要给每一个 td 元素加上 bgcolor 属性。  使用css 给每一个单元格加上背景颜色，只需要在最前面写一段css代码，所有的单元格都有背景颜色了。这是一种分层设计的思想，css把和颜色，大小位置等信息剥离到`<style>`中，而html只用关心提供什么样的内容就行了  

```css
<td bgcolor="gray" >1</td>

td{ background-color:gray; }
```

### CSS 选择器

css 的语法 selector {property: value} 即 选择器{属性:值}，学习css即学习有哪些选择器，哪些属性以及可以使用什么样的值  

```css
p{ color:red; }         /* 选择所有的p元素，并且设置文字颜色为红色 */
#p1{ color:blue; }         /* 通过id选择元素 */
.pre{ color:blue; }         /* 通过class选择元素 */
p.pre{ color:blue; }         /* 同时根据元素名和class来选择 */

<p style="color:red">这是style为红色的</p>         <!-- 也可以直接在元素上增加style属性 -->
```

选择器主要分3种：元素选择器，id 选择器和类选择器。一个元素的 id 应该是唯一的。另一个元素不应该重复使用。当需要多个元素，都使用同样的css的时候，就会使用类选择器

注释以 /* 开始，以 */ 结束，被注释掉的文字会自动隐藏

设置元素的尺寸可以用属性 width，值可以是百分比或者像素

```css
p#percentage{ width:50%; height:50%; background-color:pink; }
p#pix{ width:180px; height:50px; background-color:green; }
```

### CSS 背景

```css
p.gray { background-color: gray; }         /* 灰色背景 */
h1 { background-color: transparent }         /* 透明背景，默认即透明背景 */
h2 { background-color: rgb(250,0,255) }         /* 紫色背景 */
h3 { background-color: #00ff00 }         /* 绿色作背景 */
div#test { background-image:url(/study/background.jpg); width:200px;         /* 图片作背景 */
height:100px; background-repeat: no-repeat; background-size: contain; }     /* contain为背景平铺 */
```

`background-size: contain`为背景平铺，通过拉伸实现，会有失真

background-repeat属性值可以选

- repeat：水平垂直方向都重复
- repeat-x：只有水平方向重复
- repeat-y：只有垂直方向重复
- no-repeat：无重复

### CSS 文本和字体

设置文本对齐属性 text-align，有三个取值：left，right，center

```css
div#left{ text-align:left;
  color:pink; }         /* 文字颜色 */
div,span{         /* 让div和span的边框显露出来 */
  border:1px gray solid; margin:10px; }
```

div是块级元素，其默认宽度是100%，所以文本有对齐的空间前提，但是span却看不出右对齐效果，因为span是内联元素其默认宽度就是其文本内容的宽度，简单说就是文本已经粑在其边框上了，对齐是看不出效果来的

```css
<style type="text/css">
h1 {text-decoration: overline}         /* 上划线 */
h2 {text-decoration: line-through}         /* 删除效果 */
h3 {text-decoration: underline}         /* 下划线 */
h4 {text-decoration:blink}         /* 闪烁效果，大部分浏览器已经取消该效果 */
.a {text-decoration: none}         /* 去掉了下划线 */
</style>

<a class="a" href="http://how2j.cn/">去掉了下划线的超链</a>
```

p 标签中换行符相当于一个空格

```css
.p{ line-height:200%;         /* 行间距 */
  letter-spacing:2;         /* 字符间距 */
  word-spacing:10;         /* 单词间距 */
  text-indent:50; }         /* 首行缩进 */
p.u {text-transform:uppercase}         /* 全部大写 */
p.c {text-transform:capitalize}         /* 首字母大写 */
p.l {text-transform:lowercase}         /* 全部小写 */
p.n {white-space:normal}
p.p {white-space:pre}
p.pw {white-space:pre-wrap}
p.nw {white-space:nowrap}
```

空白格属性：white-space

- normal：默认，多个空白格或者换行符会被合并成一个空白格
- pre：有多少空白格，显示多少空白格，相当于pre标签,如果长度超出父容器也不会换行。
- pre-wrap：有多少空白格，显示多少空白格，相当于pre标签,如果长度超出父容器，会换行。
- nowrap：一直不换行，直到使用br

```css
p.big{
  font-size:30px 或 50% 或 0.5em;         /* 字体尺寸，0.5em 等同于 50%比例的文字 */
  font-style:normal 或 italic;         /* 字体风格，normal为标准字体，italic为斜体 */
  font-weight:normal 或 bold;         /* 字体粗细，normal为标准字体，italic为斜体 */
  font-family:黑体;         /* 字体字库 */
}
```

其它的字库有：default、Times New Roman、Arial、宋体（这种字体是IE默认字体）、楷体和微软雅黑,（这个字体是火狐默认字体）

把大小，风格，粗细，字库都写在一行里面

```css
p.all{ font:italic bold 30px "Times New Roman"; }    /* 斜体的粗体的大小是30px的"Times New Roman" */
```



```css
span{ cursor:crosshair; }         /* 鼠标移动到这段文字上，就看到鼠标样式变成了十字架 */
```

其它样式

default：默认效果，箭头；auto：，crosshair：十字架，pointer：手，e-resize：东（东西），ne-resize：南东，nw-resize：南西，n-resize：北（南北），se-resize：南东，sw-resize：南西，w-resize，text：文本，wait：沙漏，等待，help：带问号，not-allowed：禁止

### CSS 表格

表格布局属性 table-layout，值为 automatic 时单元格的大小由 td 的内容宽度决定，为 fixed 时单元格的大小由 td 上设置的宽度决定，只对连续的英文字母起作用，如果使用中文就看不到效果

表格边框属性 border-collapse，值为 separate 时边框分隔，为 collapse 时边框合并

```css
table.t1{
  table-layout:automatic;         /* 单元格的大小由 td 的内容宽度决定 */
  border-collapse:collapse;         /* 表格边框合并 */
}
```

### CSS 边框

边框风格属性 border-style，取值为 solid:：实线，dotted：点状，dashed：虚线，double：双线

```css
.solid{ border-style:solid;
   border-color:red;         /* 边框颜色 */
   border-width:1px; }         /* 边框宽度 */
.red{ border:1px dotted LightSkyBlue; }         /* 都放在一起 */

<div class="solid"> 实线边框  </div><br/>
<div class="red"> 点状天蓝色细边框  </div><br/>
```

通过制定位置，可以只给一个方向设置边框风格，颜色和宽度。  比如上和左就是有交界的，而上和下就没有交界，当有交界的边同时出现边框的时候，就会以倾斜的形式表现交界线。  

```css
div{ width:150px; height:150px;         /* 只有一个方向有边框 */
   border-top-style:solid;
   border-top-color:red;
   border-top-width: 50px;
   background-color:lightgray;  
}
div.lefttop{ width:150px; height:150px;         /* 左边和上边都有边框 */=
   border-top-style:solid;
   border-top-color:red;
   border-top-width: 50px;
   border-left-style:solid;
   border-left-color:blue;
   border-left-width: 50px;  
   background-color:lightgray; }
```

块级元素div默认是占用100%的宽度，常见的块级元素有 div、h1、p 等。而内联元素span的宽度由其内容的宽度决定，常见的内联元素有 a、b、strong、i、input 等

### CSS 内边距和外边距

#### 内边距

元素内边距指的是元素里的内容与边框之间的距离，属性有 padding-left: 左内边距，padding-right: 右内边距，padding-top: 上内边距，padding-bottom: 下内边距，padding: 如果只写一个，即四个方向的值；如果写四个，即四个方向的值：上 右 下 左，依顺时针的方向依次赋值

```css
.pad-left{
   border:5px solid red;
   background-color:green;
   padding-left:50px 或 padding: 20 或 padding: 10 20 30 40;
}
.margin{
   border:1px solid red;
   background-color:green;
   margin-left:10px;
}

<span class="pad-left"> 左边距为50的span  </span><br/>
<span class="margin"> 有左外边距的span  </span>
```

当内边距的值少于4个的时候，如果缺少左内边距的值，则使用右内边距的值；如果缺少下内边距的值，则使用上内边距的值；如果缺少右内边距的值，则使用上内边距的值

#### 外边距

元素外边距指的是元素边框和元素边框之间的距离，属性有 margin-left: 左外边距，margin-right: 右外边距，margin-top: 上外边距，margin-bottom: 下外边距

**注**：像span这样的内联元素，默认情况下，只有左右外边距，没有上下外边距

#### 边框模型

真正决定一个元素的表现形式，是由其边框模型决定的。由图所示，蓝色框即为内容，width:70px 表示内容的大小；红色框即为边框，内容到边框之间的距离，即为内边距 5px；灰色框，是指边框与其他元素之间的距离，即为外边距 10px

![483](https://zcayo.oss-cn-beijing.aliyuncs.com/%E5%9B%BE%E7%89%87/483.png)

伪类就是被选中的元素处于某种状态的时候。超链状态有4种：link - 初始状态，从未被访问过；visited - 已访问过；；hover - 鼠标悬停于超链的上方；active - 鼠标左键点击下去，但是尚未弹起的时候

```css
<style>
a:link {color: #FF0000}         /* 红色 */
a:visited {color: #00FF00}         /* 绿色 */
a:hover {color: #FF00FF}         /* 粉色 */
a:active {color: #0000FF}         /* 蓝色 */
a.no_underline {text-decoration: none}         /* 去除了下划线的超链 */
</style>
  
<a href="http://www.12306.com">超链的不同状态</a>
<a class="no_underline" href="http://www.12306.com">去除了下划线的超链</a>
```

隐藏元素有两种方式，使用`display:none;` 隐藏一个元素，这个元素将不再占有原空间 “坑” 让出来了；使用 `visibility:hidden;`隐藏一个元素，这个元素继续占有原空间，只是“看不见”

  如果把所有的css都写在html文件里面，一旦样式比较多的时候，就会显得不易维护。这个时候就会选择把所有的css内容，放在一个独立文件里，然后在html中引用该文件。通常这个文件会被命名为style.css  

```html
<link rel="stylesheet" type="text/css" href="/study/style.css" />
```

如果 CSS 文件放在本地，这时就应该写成`href="file://d:/style.css"`

style 标签与外部文件 style.css 样式重复，优先使用最后出现的一个；style标签上的与style属性冲突，优先使用style属性；如果样式上增加了!important，则优先级最高，甚至高于style属性

```css
.p1{ color:green !important; }

<p class="p1" style="color:red">p1 颜色是绿色，优先使用!important样式</p>
```

### CSS 布局

#### 绝对定位和相对定位

绝对定位属性：position，值： absolute，通过指定 left，top 绝对定位一个元素 。设置了绝对定位的元素，相当于该元素被从原文档中删除了。绝对定位是基于最近的一个定位了的父容器。如果没有定位了的父容器，所以它的最近的一个定位了的父容器就是body

```css
p.abs{ position: absolute; left: 150px; top: 50px; }
p.abs1{ position: absolute; left: 100px; top: 50px; }
.absdiv{ position: absolute; left: 150px; top: 50px; width:215px; border: 1px solid blue; }
p.abs2{ position: absolute; left: 100px; top: 50px; }

<p >正常文字2</p>
<p class="abs" >绝对定位的文字3</p>      /* “正常文字4”会紧接着出现在 ”正常文字2“后面，而不会留下空档 */
<p >正常文字4</p>
<div class="absdiv">
这是一个定位了的div
<p class="abs1" >绝对定位的文字</p>/* abs1 定位的父容器是 absdiv，所以出现的位置是以这个 div 为基础的 */
</div>

<div>
这个div没有定位
<p class="abs2" >绝对定位的文字</p>   /* 没有定位的父容器，所以它的最近的一个定位了的父容器就是body */
</div>
```

通过绝对定位可以把一个元素放在另一个元素上，这样位置就重复了。重复了，就存在一个谁掩盖谁的问题。 这个时候就可以使用 z-index 属性， 当 z-index的值越大，就表示放上面，z-index 越小就表示放下面  。相对定位属性：position，值：relative，与绝对定位不同的是，相对定位不会把该元素从原文档删除掉，而是在原文档的位置的基础上，移动一定的距离

```css
img#i1{ position: absolute; left: 60px; top: 20px; z-index:1; }
img#i2{ position: absolute; left: 60px; top: 120px; z-index:-1; }
p.r{ position: relative; left: 150px; top: 50px; }         /* 相对定位 */

<p >正常文字2</p>
<p class="r" >相对定位的文字3</p>
<p >正常文字4</p>
<img id="i1" src="http://how2j.cn/example.gif" />
<img id="i2" src="http://how2j.cn/example.gif" />
```

#### 浮动

浮动的框可以向左或向右移动，直到它的外边缘碰到包含框或另一个浮动框的边框为止。文字向右浮动浮动后，原来的“坑”就让出来了，并且是在原来的高度的基础上，向右浮动；文字向左浮动，首先，向左浮动后，会把“坑”让出来，这个时候"正常的文字4“ 就会过来试图占这个坑，但是，发现 “浮动的文字”并没有走，结果，就只好排在它后面了

```css
.f{ float:right; }
.f1{ float:left; }
div{ width:320px; }
.clearp{ clear:left; }         /* 不允许浮动元素出现在左边 */

<div >正常文字2</div>
<div class="f">浮动的文字</div>
<div >正常文字4</div>
<div >
    <img  class="f1" src="http://how2j.cn/example.gif"/>
    <p class="clearp">  当图片浮动时，文字围绕着图片
     当图片浮动时，文字围绕着图片
     当图片浮动时，文字围绕着图片
     当图片浮动时，文字围绕着图片
     当图片浮动时，文字围绕着图片
    </p>
</div>
```

当图片不浮动时，文字就会换行出现在下面；当图片浮动时，文字围绕着图片。当图片浮动的时候，就会让出这个“坑”出来，这个时候文字就试图去填补这个“坑”，结果发现图片没走，那就只好围绕图片摆放了。不允许出现浮动元素，属性:clear，值: left right both none，如果p左边出现了浮动的元素，如此例，则设置 clear:left 即达到不允许浮动元素出现在左边的效果

默认的div排列是会换行的，如果使用float就可以达到水平排列的效果，通常会用在菜单、导航栏等地方，如果超出了父容器，还会有自动换行的效果

```css
div#floatingDiv{ width:200px; }
div#floatingDiv div{ float:left; }

<div id="floatingDiv">
	<div>菜单1</div>
	<div>菜单2</div>
</div>
```

#### 显示方式

元素的 display 显示方式有多种，隐藏、块级、内联、内联-块级， 块级元素会自动在前面和后面加上换行，并且在其上的width和height也能够生效，内联元素前后没有换行，并且在其上的width和height也无效，其大小由其中的内容决定 。div默认是块级元素，span默认是内联元素。display:inline 表示内联元素，display:block 表示块级元素，有时候，需要元素处于同一行，同时还能指定大小，这个时候，就需要用到 内联-块级 inline-block

```css
div.d{ display:none; }
.d{ display:block; }
span{ display:inline-block; border: 1px solid lightgray; margin:10px; width:100px; }
/* 每个 sapn 都能设置宽度 ，同时还能在同一行 */
<div>可见的div1</div>
<div class="d">隐藏的div2,使用display:none隐藏</div>    /* 使得被选择的元素隐藏，并且不占用原来的位置 */
<div>可见的div3</div>
<span class="d">这是span,被改造成了块级元素</span>
```

其他的不太常见的显示方式像 list-item 显示为列表，table 显示为表格，inline-table 显示为前后无换行的表格，table-cell 显示为单元格

#### 设置内容和元素居中

默认情况下div会占用100%的宽度,所以无法观察元素是否居中。先设置 div 的宽度，然后再使用样式 margin: 0 auto 来使得元素居中。span 是内联元素，无法设置宽度，所以不能通过margin:0 auto居中，可以通过放置在div中，然后让div text-align实现居中

```css
div{ border:1px solid lightgray; margin:10px; }
/* 设置内容居中 */
<div align="center">居中的内容</div>
<div style="text-align:center">居中的内容</div>
/* 设置元素居中 */
<div style="width:300px;margin:0 auto">设置本div的宽度</div>
<div style="text-align:center">
  <span>span的居中可以</span>
</div>
```

左侧固定，右边自动占满

```css
.left{ width:200px; float:left; background-color:pink }
.right{ overflow:hidden;         /* 作用是清除浮动 */
    background-color:lightskyblue; }

<div class="left">左边固定宽度</div>
<div class="right">右边自动填满</div>
```

设置垂直居中

借助设置相同的上下内边距，实现垂直居中效果，可以用在多行文本上。首先通过 display: table-cell 把div 用单元格的形式显示，然后借用单元格的垂直居中 vertical-align: middle 来达到效果。 这样对图片也可以居中， line-height 就不能对图片居中

```css
#d { line-height: 100px; }         /* 设置垂直居中 */
#c { padding: 30 0; }         /* 设置相同的上下内边距，实现垂直居中效果 */
#d { display: table-cell; vertical-align: middle; height:200px; }
div{ border:solid 1px lightskyblue; }

<div id="d">line-height 适合单独一行垂直居中</div>
<div id="d">多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容  </div>
<div id="d"><img src="http://how2j.cn/example.gif"></div>
```

左右固定，中间自适应

```css
.left{ width:200px; float:left; background-color:pink }
.right{ width:200px; float:right; background-color:pink }
.center { margin:0 200px;   background-color:lightblue }

<div class="left">左边固定宽度</div>
<div class="right">左边固定宽度</div>
<div class="center">中间自适应</div>
```

一个div始终贴在下方

```css
#div1{ position: relative; height: 300px; width: 90%; background-color: skyblue; }
#div2{ position: absolute; bottom: 0; height: 30px; width: 100%; background-color: lightgreen; }
 
<div id="div1">
    <div id="div2">无论蓝色div高度如何变化，绿色div都会贴在下面</div>
</div>
```

如果多个 span 连续编写，是不会有空格的。但是真正开发代码的时候，一般不会连续书写span，而是不同的 span 之间有回车换行，而这样编写代码，就会导致`<span>`之间出现空格。可以使用 float 来解决，float使用完毕之后，记得在下面加上 `<div style="clear:both"></div> `用于使得后续的元素，不会和这些span重复在一起

```css
div.nocontinue span{ border-bottom:2px solid lightgray; float:left; }

<div class="nocontinue">
    <span>有换行的span</span>
    <span>有换行的span</span>
    <span>有换行的span</span>
</div>
<div style="clear:both"></div>         /* 使得后续的元素，不会和这些span重复在一起 */ 
<div>后续的内容</div>
```

有的时候，我们只需要一个大图的一小部分。可以使用背景的方式获取一部分图片，也可以借助裁剪的方式只显示部分图片，裁剪之后，只显示被裁剪出来的图片，所以还需要把整个图片向左移动，才看上去像拿到了想要的那部分图片

```css
div{ width:25; height:25;
    background:transparent url(http://how2j.cn/study/wangwang.gif) no-repeat scroll -83px -0px;
    /* 等同于下面 */
    background-color:transparent; background-image:url(/site/wangwang.gif);
    background-repeat:no-repeat; background-attachment:scroll; background-position: -83px -0px;
    /* 使用 img 方式 */
    img{ position:absolute; left:-83px; clip:rect(0px 108px 25px 83px);
}
}

<div></div>
<img src="http://how2j.cn/study/wangwang.gif">
```

clip:rect 中四个属性表示顺时针裁剪指定尺寸，只能作用于`position:absolute`的元素上

## JS

JavaScript用于网页和用户之间的交互，比如提交的时候，进行用户名是否为空的判断。完整的javascript由语言基础，BOM和DOM组成，只有通过javascript操作DOM对象的时候，才会带来很好的实用效果

```
<script>
  var x = 10;
  document.write("变量x的值:"+x);         // 向文档写入字符串，不换行
  console.log("x="+x);         // 输出到控制台
</script>

<button onclick="document.getElementById('text').style.display='none'">隐藏文本</button>
<button onclick="document.getElementById('text').style.display='block'">显示文本</button>
<p id="text"> 这个是一段可以被javascript隐藏的文本</p>
```

document 是 javascript的内置对象，代表浏览器的文档部分  。上面是 javascript 和 DOM 结合的一个简单例子，onclick，getElementById，style.display 这些内容，是 HTML DOM 应该到才会用到的知识和概念，document.getElementById 根据id获取指定的元素

  javascript代码必须放在script标签中，一旦加载，就会执行。如果有多段 script 代码（多个 script biaoq），会按照从上到下，顺序执行。script标签可以放在html的任何地方，一般建议放在head标签里  

```html
<html>
  <head>
    <script src="http://how2j.cn/study/hello.js"></script> <!-- 使用外部js文件 -->
    <script>
            document.write("这是 javascript");
    </script>
  </head>
</html>
```

javascript有两种注释方式，// 单行注释和 /* 进行多行注释

使用 var 声明一个变量，但是关键字 var 可有可无，命名规则和 java 差不多，开头可以用  _、$ 和字母，其他部分可以用 $、 _ 、字母或者数字

### JS 调试方法

使用 alert(1) 进行调试，如果弹出了1,这个位置以上的代码，都是可以运行的。不停的把 alert(1) 向下移动，当移动到某一行之后，就不再弹出，那么就证明那一行运行有问题。firebug 有一个日志输出工具 console.log()，console.log() 只会把信息输出在 console 里，而不会影响用户的使用

### 基本数据类型

基本数据类型 undefined，Boolean，Number，String，null。变量的类型是动态的，当值是整数的时候，就是Number类型，当值是字符串的时候，就是String类型

- 当一个变量被声明了，却没有赋值的时候，叫做 undefined；
- Boolean 变量有两种值，分别是 true 或者 false；
- javascript 中的 Number 可以表示十进制，八进制，十六进制整数，浮点数，科学记数法（第一位是0，表示八进制；0x开头表示十六进制）
- 与java 不同的是，javascript 中没有字符的概念，只有字符串，所以单引号和双引号，都用来表示字符串
- null表示一个对象不存在

正是因为变量是动态类型的，所以无法确定当前到底是哪种类型，这个时候，就可以使用 typeof 来进行判断

```javascript
document.write('声明了但是未赋值的时候，类型是： '+typeof x);
document.write("<br>");
document.write("变量a的长度是:"+a.length);
document.write("数字 "+a+" 转换为字符串"+a.toString());
document.write("字符串的\"10\"转换为数字的:"+parseInt("10"));
document.write("通过Number() 函数转换字符串'abc123' 后得到的数字："+Number("abc123")); //NaN
document.write("字符串的\"hello javascript\"转换为数字的:"+parseInt("hello javascript"));
document.write("空字符串''转换为布尔后的值:"+Boolean(""));
var a = null;
document.write(a.toString());          // 报错，无法执行
document.write("因为前一行报错，所以这一段文字不会显示"); 
```

javascript 是一门很有意思的语言，即便是基本类型，也是伪对象，所以他们都有属性和方法。变量 a 的类型是字符串，通过调用其为伪对象的属性length获取其长度；无论是 Number，Boolean 还是 String 都有一个 toString 方法，用于转换为字符串；Number 转换为字符串的时候有默认模式和基模式两种，toString() 表示默认模式（十进制），toString(2) 表示基模式（二进制或其它进制）

javascript 分别提供内置函数 parseInt() 和 parseFloat()，转换为数字。如果被转换的字符串，同时由数字和字符构成，那么 parseInt 会一直定位数字，直到出现非字符。 所以"10abc" 会被转换为 10。如果完全不包含数字，则返回 NaN - Not a Number。使用内置函数 Boolean() 转换为 Boolean 值，当转换字符串时：非空即为 true，当转换数字时：非0即为 true，当转换对象时：非null即为 true

Number()和parseInt()一样，都可以用来进行数字的转换。区别在于，当转换的内容包含非数字的时候，Number() 会返回NaN(Not a Number)；parseInt() 要看情况，如果以数字开头，就会返回开头的合法数字部分，如果以非数字开头，则返回NaN。String() 和 toString()一样都会返回字符串，区别在于对 null 的处理，String()会返回字符串"null"，toString() 就会报错，无法执行

### JS 函数

```javascript
function print(message){
  document.write(message);
}
function calc(x,y){
  return x+y;
}
var sum = calc(500,20);
print(sum);
```

一个参数的作用域就在这个函数内部，超出函数就看不见该参数了。全局变量定义在函数前面，所有函数都可以访问

### JS 事件

事件是javascript允许html与用户交互的行为。 用户任何对网页的操作，都会产生一个事件。事件有很多种，比如鼠标移动，鼠标点击，键盘点击等等  

```javascript
var day=new Date().getDay(); //通过日期对象获取数字形式的星期几，从 0 到 6
function showHello(){
   alert("Hello JavaScript");
}

<button onclick="showHello()">点击一下</button>
```

与 == 进行值是否相等的判断不同 ，绝对等 === 还会进行 类型的判断，比如 数字1和 字符串'1'比较，值是相等的，但是类型不同，所以 == 会返回true,但是 === 会返回false，绝对不等于!== 与上是一个道理。三目运算符 ?: ，比如 age<18?"卡通":"你懂的"

JavaScript提供了一种 try catch 的错误处理机制，当有错误抛出的时候，可以 catch 住

```java
try{
   document.write("试图调用不存在的函数f2()<br>");
    f2();  //调用不存在的函数f2();
}
catch(err){
   document.write("捕捉到错误产生:");
    document.write(err.message);
}
document.write("<p>因为错误被捕捉了，所以后续的代码能够继续执行</p>");
```

### JS 对象

JavaScript 中的对象是有着属性和方法的一种特殊数据类型，常见的对象有数字 Number，字符串 String，日期 Date，数组 Array 等  

#### 数字对象

```javascript
var x = new Number(123);
var b = new Number("3.1415926");
document.write('数字对象x的类型:'+typeof x); // 通过 typeof 获知这是一个 object
document.write('Number对象的最小值:'+Number.MIN_VALUE); // 获取 Number 对象的最小值（最大值）
var a = new Number("123abc");         // 通过非数字创建 Number 对象，得到的是一个NaN
document.write(a==Number.NaN);         // 即便是一个 NaN 也"不等于" Number.NaN
document.write(isNaN(a));         // 正确的方式是通过 isNaN() 函数进行判断
document.write(b.toFixed(3));         // 返回一个数字的小数表达，保留三位小数点
document.write(b.toExponential());         //返回一个Number对象的科学计数法表达
var c = a.valueOf();         //返回一个基本类型的数字
```

#### 字符串对象

所有返回字符串类型的方法，返回的都是基本类型的String

```javascript
var y = new String("JavaScript");
var x = new String("Hello ");
document.write("通过.length属性获取字符串'JavaScript'的长度"+y.length);
document.write('通过 charAt(0)获取位置0的字符串： '+ y.charAt(0));         // 返回 J
document.write(y.charCodeAt(0));         // 返回 H 对应的Unicode码 72
document.write( '通过函数concat()把x和y连接起来: ' +  x.concat(y) );
document.write('通过 indexOf ("a")获取子字符"a" 第一次出现的位置 '+y.indexOf ("a"));
document.write('通过 lastIndexOf ("a")获取子字符"a" 最后出现的位置 '+y.lastIndexOf ("a"));
document.write('通过 localeCompare()判断 x和y是否相等 '+x.localeCompare(y));
document.write('x.substring (0,3) 获取位0到2的字符串： '+x.substring (0,3) );
document.write('通过空格分隔split(" ",2),得到数组，并且只保留前两个'+x.split(" ",2));
var z = x.replace("e","o");         // 只替换第一个 e 为 o
var regS = new RegExp("e","g");         // 替换全部的 e 为 o，g 代表全部
var d = x.replace(regS, "o");
var d = x.replace(/a/g, "o");         // 替换全部的 e 为 o
```

#### 数组对象

```javascript
var x = new Array();         // 创建长度是0的数组
x = new Array(5);         // 创建长度是5的数组,，但是其每一个元素都是undefine
x = new Array(3,1,4,1,5);         // 根据参数创建数组
document.write(x.length);
for(i in x){         // for in 循环
  document.write(x[i]);
}
var z = x.concat(y);         // 使用concat连接数组
document.write(x.join("@"));         // 得到的是数组 x 指定分隔符后的字符串表达，为 3@1@4@1@5
x.push(5);         // 在最后的位置插入数据
z = x.pop();         // 在最后的位置获取数据(获取后删除)
x.unshift (5);         // 在最开始的位置插入数据
z = x.shift ();         // 在最开始的位置获取数据(获取后删除)

```

方法 join 通过指定分隔符，返回一个数组的字符串表达，默认分隔符为 ','

```javascript
function comparator(v1,v2){
   return v2-v1;  // v2-v1 表示大的放前面，小的放后面（降序）
}
x.sort();         // 对数组的内容进行自然排序
x.sort(comparator);         // 使用sort 进行自定义倒排序结果为5 4 3 1 1
x.reverse();         // 对数组的内容进行反转
x.slice(1);         // 获取子数组，结果为 1 4 1 5
x.slice(1,3);         // 结果为 1 4
x.splice (3,2);         // 从位置3开始 ，删除2个元素，结果为
x.splice(3,0,1,5);         // 从位置3开始，删除0个元素，但是插入1和5
```

#### 日期对象

```javascript
var d = new Date();
document.write(d);         // 输出格式：Wed Oct 23 2019 16:09:33 GMT+0800 (中国标准时间)
document.write(d.getFullYear()+"/"+(d.getMonth()+1)+"/"+d.getDate());         // 分别获取年，月，日
document.write(d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+":"+d.getMilliseconds());         // 分别获取时，分，秒，毫秒
new Date().getDay();         // 获取本周的第几天,与getMonth()一样，返回值是基0的
new Date().getTime();         // 获取从1970/1/1 08:00:00 至今的毫秒数
d.setFullYear(2012);         // 把日期对象设置为2012/12/12 00:00:00
d.setMonth(11);          // 月份是基0的，所以11表示12月
d.setDate(12);
d.setHours(0);
d.setMinutes(0);
d.setSeconds(0);
```

d.getMonth() 的值从 0 到 11

#### Math 对象

```java
document.write(Math.E + Math.PI);          // 属性 E PI，分别表示自然对数和圆周率 PI
Math.abs(-1)取绝对值
Math.min(1,100)          // 取最小值（最大值）
Math.pow(3,3)          // 3的立方，即27
Math.round(3.4)          // 小数四舍五入取整
Math.random()          // 取0-1之间的随机数
Math.round(Math.random() *5)+5          // 5-10之间的随机整数
```

Math.abs()：取绝对值，Math.min() 和 Math.max()：取最小值，最大值

#### 自定义对象

```javascript
var hero = new Object();
hero.name = "盖伦";         //定义一个属性name，并且赋值
hero.kill = function(){          // 定义一个函数kill
	document.write(hero.name + " 正在杀敌" );
}
 
hero.kill();         // 调用函数kill
```

通过new Object创建对象有个问题，就是每创建一个对象，都得重新定义属性和函数。这样代码的重用性不好，那么，采用另一种方式，通过function设计一种对象。 然后实例化它 。这种思路很像 Java 里的设计一种类，但是 javascript 没有类，只有对象，所以我们叫设计一种对象

```javascript
function Hero(name){
  this.name = name;
  this.kill = function(){
     document.write(this.name + "正在杀敌<br>");
  }
}
var gareen = new Hero("盖伦");
gareen.kill(); 
Hero.prototype.keng = function(){         // 为已经存在的对象，增加新的方法
  document.write(this.name + "正在坑队友<br>");
}
gareen.keng();
```

### BOM

  BOM即 浏览器对象模型(Browser Object Model)，浏览器对象包括 Window(窗口)、Navigator(浏览器)、Screen (客户端屏幕)、History(访问历史)、Location(浏览器地址)  。

一旦页面加载，就会自动创建window对象，所以无需手动创建window对象。Navigator即浏览器对象，提供浏览器相关的信息。

```javascript
document.write(window.innerWidth+","+window.innerHeight);         // 获取文档显示区域的高度和宽度
document.write(window.outerWidth+","+window.outerHeight);         // 获取外部窗体的宽度和高度
document.write("<p>");
document.write(navigator.appName);         // 浏览器版本号
document.write(navigator.appCodeName);         // 浏览器内部代码
document.write(navigator.platform);         // 操作系统
document.write(navigator.cookieEnabled);         // 是否启用Cookies
document.write(navigator.userAgent + "</p>");         // 浏览器的用户代理报头
function openNewWindow(){
  myWindow=window.open("/");         // myWindow 是一个窗口对象
}

<button onclick="openNewWindow()">打开一个新的窗口</button>
```

Screen对象表示用户的屏幕相关信息。如果是在台式电脑上，通常看到的可用区域的高度会比屏幕高度小一点，因为有任务栏的存在。History用于记录访问历史，Location表示浏览器中的地址栏

```javascript
document.write(screen.width + "*" + screen.height);         // 用户的屏幕分辨率
document.write(screen.availWidth + "*" + screen.availHeight);         // 可用区域大小
history.back();         // 返回上一次的访问
history.go(-2);         // -1表示上次，-2表示上上次，以次类推
location.reload();         // 刷新当前页面
location="/";         // 跳转到另一个页面，或者下面另一种
location.assign("/");
location.protocol         // 协议
location.hostname         // 主机名
location.port         // 端口号
location.host         // 主机加端口号
location.pathname         // 访问的路径
location.hash         // 锚点
location.search         // 参数列表
```

浏览器上常见的弹出框有警告框，确认框，提示框，这些都是通过调用window的方法实现的。比如警告框用的是window.alert("警告内容")，因为很常用，所以就把window省略掉，直接使用 alert  。警告框 alert，常用于消息提示，比如注册成功等等。确认框 confirm，常用于危险性操作的确认提示， 比如删除一条记录的时候，弹出确认框 confirm 返回基本类型的 Boolean true 或者 false。输入框 prompt，用于弹出一个输入框，供用户输入相关信息。 因为弹出的界面并不好看，很有可能和网站的风格不一致，所以很少会在实际工作中用到

```javascript
alert("注册成功");         // 弹出警告框
function del(){
var d = confirm("是否要删除");         // 弹出确认框
alert(typeof d + " " + d);
}
function p(){
var name = prompt("请输入用户名:");         // 弹出输入框
alert("您输入的用户名是:" + name);
}
```



```javascript
function printTime(){
  var d = new Date();
  var h= d.getHours();
  var m= d.getMinutes();
  var s= d.getSeconds();
  document.getElementById("time").innerHTML= h+":"+m+":"+s;
  if(s%5==0)
      clearInterval(t);         // 终止一个不断重复的任务，当秒是5的倍数的时候，就停止执行
}
function showTimeIn3Seconds(){
   setTimeout(printTime,3000);         // 在指定的毫秒数时间后，执行一次函数 printTime
}  
var t = setInterval(printTime,1000);         // 重复执行同一个函数，重复的时间间隔由第二个参数指定

<div id="time"></div>
<button onclick="showTimeIn3Seconds()">点击后3秒钟后显示当前时间，并且只显示一次</button>
```

document.getElementById 获取 id=time 的div元素，.innerHTML 修改该元素的内容

假设 setInterval 调用的函数是 printTime, 在 printTime 中调用 document.write()，只能看到一次打印时间的效果。
这是因为 document.write，会创建一个新的文档，而新的文档里，只有打印出来的时间字符串，并没有 setInterval 这些javascript 调用，所以只会看到执行一次的效果。比如firefox有这个问题，其他浏览器没这个问题