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

未完待续。。。

## JS

