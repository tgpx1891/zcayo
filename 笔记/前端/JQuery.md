  JQuery是一个 javascript 的框架，是对 javascript 的一种封装。通过 JQuery 可以非常方便的操作 html 的元素  

```html
<!-- 导入一个第三方的javascript库 jquery.min.js -->
<script src="https://how2j.cn/study/jquery.min.js"></script>
<script>
$(function(){
  document.write("文档加载成功!");
  document.write($("#d"));			// 通过id获取元素，结果为 [object Object]
  document.close();
});
$(function(){
   $("#b1").click(function(){
       $("#d").hide();			// 或者 $(this).hide();
       alert("点击了按钮");			// 增加监听器
       alert($("#input1").val());	// 取输入框的值，相当于 document.getElementById("input1").value;
       alert($("#d1").html());			// 获取元素内容,如果有子元素，保留标签
       alert($("#d1").text());			// 获取元素内容,如果有子元素，不包含标签  
       $("#d").addClass("pink");			// 增加一个样式中的class
       $("#e").removeClass("pink");			// 删除一个样式中的class
       $("#d").toggleClass("pink");		// 切换一个样式中的class（如果存在就删除如果不存在，就添加）
       // 通过css函数，直接设置样式。设置多种样式
       $("#d").css({"background-color":"pink","color":"green"});	
       $("#d").css("background-color","pink");			// 设置单一样式
       $("div").addClass("pink");		// 根据标签名选择所有该标签的元素，给所有的div元素增加背景色
       $("#d").addClass("pink");			// 根据 id 选择元素，如果id重复，则只会选择第一个
       $(".d").addClass("pink");			// 根据 class 选择元素
       $("div#d span").addClass("pink");			// 选择 id=d 的div下的span元素
       $("div:first").addClass("pink");			// 第一个增加背景色
       $("div:last").addClass("pink");
       $("div:odd").toggleClass("pink");			// 切换奇数背景色
       $("div:even").toggleClass("green");
       $("div:visible").hide();			// 隐藏可见的
       $("div[id]").toggleClass("border");			// 给有id属性的div切换边框
       $("div[id='pink']").toggleClass("border");			// 给id=pink的div切换边框
       $("div[id!='pink']").toggleClass("border");			// id!=pink
       $("div[id^='p']").toggleClass("border");				// id以p开头
       $("div[id$='k']").toggleClass("border");			// id以k结尾
       $("div[id*='ee']").toggleClass("border");			// id包含ee
       $("div").first().toggleClass("pink");			// 切换第1个div背景色
       $("div").last().toggleClass("pink");
       $("div").eq(4).toggleClass("pink");			// 切换第5个div背景色（从0开始）
       $("#currentDiv").parent().toggleClass("b");			// 改变最近一个父元素的边框
       $("#currentDiv").parents().toggleClass("b");			// 所有的祖先元素
       $("#currentDiv").children().toggleClass("b");		// 儿子元素 (紧挨着的子元素)
       $("#currentDiv").find("div").toggleClass("b");		// 后代元素
       $("#currentDiv").siblings().toggleClass("b");		// 同级(同胞)元素
   });
   $("#b2").click(function(){
      $("#d").show();
       $("div:hidden").show();			// 显示不可见的
   });
});
</script>
<style>
.pink{
   background-color:pink;
}
.b{
	border: 2px solid black;
}
</style>
<button id="b1">隐藏div</button>
<button id="b2">显示div</button> 
<div id="d" class="d">这是一个div<span>这是div里的span</span></div>
<input type="text" id="input1" value="默认值">
<div id="e" class="pink">Hello JQuery</div>
<div id="grandParentDiv" >
    祖先元素
    <div id="parentDiv">
        父元素
        <div id="currentDiv" >
            当前元素
            <div class="childrenDiv">
                儿子元素1
                <div class="grandChildrenDiv">后代元素n</div> 
            </div>
            <div class="childrenDiv">
                儿子元素2
                <div class="grandChildrenDiv">后代元素n</div> 
            </div>
        </div> 
        <div >
            同级元素
        </div>
    </div>
</div>
```

`$(function( ){ });`表示文档加载，这是为了防止文档在完全加载（就绪）之前运行 jQuery 代码。还有另一个写法`$(document).ready(function( ){ });`。javascript 通过 id 获取元素节点的方式为`document.getElementById`，获取到的是 DOM 里的 元素节点，而通过 $("#id") 获取到的是一个 JQuery 对象。

表单对象选择器 指的是选中form下会出现的输入元素

- :`input` 会选择所有的输入元素，不仅仅是input标签开始的那些，还包括textarea,select和button
- `:button` 会选择type=button的 input 元素和 button 元素
- `:text`会选择文本框，但是不会选择文本域
- `:image`会选择图片型提交按钮
- `:enabled`会选择可用的输入元素，输入元素的默认状态都是可用
- `:disabled`会选择不可用的输入元素
- `:checked`会选择被选中的单选框和复选框，注意 checked 在部分浏览器上(火狐,chrome)也可以选中selected的option
- `:selected`会选择被选中的option元素

```html
<script>
$(function(){
   $(".b").click(function(){
      var value = $(this).val();			// 获取组件的值，$(this)表示触发该事件的组件
      $("td[rowspan!=13] "+value).toggle(500);		
       /* 注意有个空格，表示层级选择器，如果没有就会出错。toggle(500) 表示在显示与隐藏之间来回切换，生效时		间是500毫秒 */
   });       
});     
</script> 
<style>
div button{
    display:block;
}
</style>
<table>
    <tr>
        <td rowspan="13" valign="top" width="150px">
            <div >
                <button value=":input" class="b">切换所有的:input</button>  
                <button value=":image" class="b">切换:image</button>
                <button value=":enabled" class="b">切换:enabled</button>
                <button value=":disabled" class="b">切换:disabled</button>       
                <button value=":checked" class="b">切换:checked</button>     
                <button value=":selected" class="b2">:selected数量</button>
            </div>           
        </td>
        <td width="120px">说明</td>
        <td width="120px">表单对象</td>
        <td width="">示例</td>
    </tr>
    <tr>
        <td><input type="button" enabled="enabled" value="input按钮"/></td>
        <td><input type="image" src="https://how2j.cn/example.gif" /></td>
        <td><input type="button" disabled="disabled" value="disabled的按钮"/></td>
        <td>
            <input type="radio" checked="checked" ><br>
            <input type="radio" ><br>
            <input type="checkbox" ><br>
            <input type="checkbox" checked="checked" >
        </td>
        <td>
            <select size="3" multiple="multiple">
                <option selected="selected">苍老师</option>
                <option >高树玛利亚</option>
                <option selected="selected">遥美</option>
            </select>
        </td>
    </tr>
</table>
```

### 属性

```html
 <script>
$(function(){
   $("#b").click(function(){
       alert("align属性是:" + $("#h").attr("align") );			// 获取一个元素的属性，结果为 center
       alert("game属性是:" + $("#h").attr("game") );			// 结果为 LOL
       alert("game属性是:" + $("#c").prop("game") );			// 结果为 undefined
       $("#h").attr("align","right");			// 修改align属性为right
       $("#h").removeAttr("align");			// 删除align属性
       alert("checked属性是:" + $("#c").attr("checked") );	// 结果为 checked，但是只能获取初始值
       alert("checked属性是:" + $("#c").prop("checked") );			// 结果为 true
   });
});
</script>
<button id="b">获取align属性</button>
<h1 id="h" align="center" game="LOL">居中标题</h1>
<input type="checkbox" id="c" game="LOL" checked="checked"> 选中的复选框
```

 与 prop 一样，attr 也可以用来获取与设置元素的属别。区别在于，对于自定义属性和选中属性的处理。
选中属性指的是 checked，selected 这2种属性。

- 对于自定义属性，attr 能够获取，prop 不能获取
- 对于选中属性，attr 只能获取初始值， 无论是否变化；prop 能够访问变化后的值，并且以 true | false 的布尔型返回

所以在访问表单对象属性的时候，应该采用 prop 而非 attr 事件

### 效果

```html
<script>
$(function(){
var div = $("#d");
   $("#b").click(function(){
       div.hide();			// 立即隐藏
       div.show();			// 立即显示
       div.toggle();			// 立即切换
       div.show(1000);			// 延迟显示
       div.slideUp();			// 向上滑动
       div.slideDown();			// 向下滑动
       div.slideToggle();			// 滑动切换
       div.slideUp(2000);			// 延时向上滑动
       div.fadeIn();			// 淡出（隐藏）
       div.fadeOut();			// 淡入（显示）
       div.fadeToggle();			// 淡入淡出切换
       div.fadeIn(2000);			// 延时淡出
       $("#d1").fadeTo("slow",0.2);			// 指定淡入程度
       $("#d2").fadeTo("slow",0.5);
       $("#d3").fadeTo("slow",0.8);
   });
});
</script> 
<style>
div{
  border:solid 1px gray;
  background-color:pink;
  width:300px;
  height:100px;
}
#d1,#d2,#d3{
  border:solid 1px gray;
  background-color:pink;
  width:300px;
  height:100px;
  float:left;
}
</style>
<button id="b">立即隐藏</button>  
<div id="d">
用于演示效果的DIV
</div>
<div>
    <div id="d1">
        用于演示fadeTo 20%
    </div>
    <div id="d2">
        用于演示fadeTo 50%
    </div>  
    <div id="d3">
        用于演示fadeTo 80%
    </div>     
</div>

```

fadeTo() 方法指定淡入程度，第一个参数表示速度，可取值为毫秒（比如 1500）、"slow"、"normal"和"fast"。第二个参数是 0-1 之间的小数，0表示不淡入，1表示全部淡入

#### 自定义动画效果

 通过 animate 可以实现更为丰富的动画效果 。 默认情况下，html 中的元素都是固定，并且无法改变的位置的。 为了使用animate()自定义动画效果，需要通过 css 把元素的 position 设置为 relative、absolute 或者 fixed 

```html
<script>
$(function(){
    var div = $("#d");
    $("#b").click(function(){
        div.animate({left:'100px'},2000);
        div.animate({left:'0px',top:'50px',height:'50px'},2000);
        alert("动画演示结束");
    });
});
</script>
<style>
div{
  background-color:pink;
  width:200px;
  height:80px;
  font-size:12px;
  position:relative;
}
</style>   
<button id="b">自定义动画</button>
<div id="d">
<p>1. 向右移动100px</p>
<p>2. 向左下移动50px，同时高度变小</p>
</div>
```

只有第一次运行有效，因为第一次运行后 div 块没有回到原来的位置

### 事件

空白键和回车键也可以造成click事件，但是只有双击鼠标才能造成dblclick事件 

```html
<script>
    $(function(){
        $("#img").load(function(){
            $("#message").html("图片加载成功");			// 图片加载完
        });
        $("#b").dblclick(function(){
            $("#message").html("双击按钮");			// 双击按钮
        });
        $("#b").on("click",function(){			// 通过on() 绑定事件来处理
            $("#message").html("单击按钮");
        });
        $("#b").on("dblclick",function(){
            $("#message").html("双击按钮");
        });
        $("#b").trigger("dblclick");			// 文档加载好之后，就触发dblclick双击事件
        $("input").focus(function(){			// 获取焦点（点击）
            $(this).val("获取了焦点");
        });
        $("input").blur(function(){			// 失去焦点
            $(this).val("失去了焦点");
        });
        $("#input1").change(function(){			// 只有当文本失去焦点的时候，才会触发 change 事件
            var text = $(this).val();
            $("#message").html("input1的内容变为了"+text);
        });
        $("#form").submit(function(){			// 提交form表单
            alert("提交账号密码");
        });
    });
</script>
<div id="message"></div>
<img id="img" src="https://how2j.cn/example.gif">
<button id="b">测试单击和双击</button>
账号 : <input id="input1" type="text" name="name">
<input type="submit" value="登陆">
```

#### 键盘

keydown 表示按下键盘，keypress 表示按住键盘，keyup 表示键盘弹起。三者的区别分别表现在发生的先后顺序、获取到的键盘按钮值，以及对输入框的文本取值这三方面

- 先后顺序： 按照 keydown keypress keyup 顺序发生
- 键盘按钮值：通过 event 对象的 which 属性获取键盘的值，keydown 和 keyup 能获取所有按键，不能识别大小写；
  keypress 不能获取功能键，如F1、SHIFT等，能够识别大小写
- 文本取值：keydown 和 keypress 不能获取最后一个字符，keyup 获取所有字符

例如敲入ab，发生的先后顺序是 keydown,keypress,keyup，keydown 和 keyup 取到大写B的 ASCII 码表 66,keypress 取到小写 b 的 ASCII 码表 98，keydown 和 keypress 只能取到文本值。 a,，keyup 可以取到 ab

```html
<script>
var order = 0;
var clearTimer=null;
$(function(){
  $("#i").keydown(function(e){
     var selector = "keydown";
     show(selector,e,$(this).val());
  });
  $("#i").keypress(function(e){
     var selector = "keypress";
     show(selector,e,$(this).val());
  });
  $("#i").keyup(function(e){
     var selector = "keyup";
     show(selector,e,$(this).val());
  });  
});
function show(selector,e,inputvalue){
     clearTimeout(clearTimer);			// 取消执行 Timeout
     action(selector);
     key(selector,e);
     value(selector,inputvalue);
     clearTimer= setTimeout(clear,4000);			// 在4秒后调用 clear 函数
}
function action(selector){
    $("#"+selector+"Action").css("background-color","green");
    $("#"+selector+"Action").html("顺序: " + (++order ) );
}
function value(selector,value){
    $("#"+selector+"Value").html(value);
}
function key(selector,e){
    $("#"+selector+"Key").html(e.which);
}
function clear(){
  order = 0;
  $("tr#action div").css("background-color","red");
  $("tr div").html("");
}
</script>
<style>
tr#action div{
  border: 1px solid black;
  height:50px;
  background-color:red;
}
tr#value div,tr#key div{
  height:50px;
  background-color:#d1d1d1;
}
td{
 width:25%;
}
</style>
输入框：<input id="i">
<table width="100%">
<tr>
  <td></td>
  <td>keydown</td>
  <td>keypress</td>
  <td>keyup</td>
</tr>
<tr id="action">
  <td>行为</td>
  <td><div id="keydownAction"></div></td>
  <td><div id="keypressAction"></div></td>
  <td><div id="keyupAction"></div></td>
</tr>
<tr id="key">
  <td>按键</td>
  <td><div id="keydownKey"></div></td>
  <td><div id="keypressKey"></div></td>
  <td><div id="keyupKey"></div></td>
</tr>
<tr id="value">
  <td>取值</td>
  <td><div id="keydownValue"></div></td>
  <td><div id="keypressValue"></div></td>
  <td><div id="keyupValue"></div></td>
</tr>
</table>
```

setTimeout() 方法用于在指定的毫秒数后调用函数或计算表达式，返回一个 ID（数字），可以将这个ID传递给 clearTimeout() 来取消执行

#### 鼠标

鼠标按下 mousedown， 鼠标弹起 mouseup，鼠标进入：mousemove，mouseenter，mouseover ，鼠标离开：mouseleave，mouseout  。

- mousemove ：当鼠标进入元素，每移动一下都会被调用 
- mouseenter ：当鼠标进入元素，调用一下，在其中移动，不调用。当鼠标经过其子元素不会被调用
- mouseover：当鼠标进入元素，调用一下，在其中移动，不调用。当鼠标经过其子元素会被调用
- mouseleave: 当鼠标经过其子元素不会被调用 
- mouseout：当鼠标经过其子元素会被调用

```html
<script>
$(function(){
    $("#downup").mousedown(function(){
       $(this).html("鼠标按下");
    });
    $("#downup").mouseup(function(){
       $(this).html("鼠标弹起");
    });
    var moveNumber  =0;
    var enterNumber  =0;
    var leaveNumber  =0;
    var overNumber  =0;
    var outNumber  =0;
    var enterNumber1  =0;
    var overNumber1  =0;
    var leaveNumber1  =0;
    var outNumber1  =0;
    $("#move").mousemove(function(){
      $("#move span.number" ).html(++moveNumber);
    });
    $("#enter").mouseenter(function(){
      $("#enter span.number" ).html(++enterNumber);
    });
    $("#leave").mouseleave(function(){
      $("#leave span.number" ).html(++leaveNumber);
    });
    $("#over").mouseover(function(){
      $("#over span.number" ).html(++overNumber);
    });
    $("#out").mouseout(function(){
      $("#out span.number" ).html(++outNumber);
    });

    $("#enter1").mouseenter(function(){
      $("#enter1 span.number" ).html(++enterNumber1);
    });
    $("#over1").mouseover(function(){
      $("#over1 span.number" ).html(++overNumber1);
    });

    $("#leave1").mouseleave(function(){
      $("#leave1 span.number" ).html(++leaveNumber1);
    });

    $("#out1").mouseout(function(){
      $("#out1 span.number" ).html(++outNumber1);
    });
});
</script> 
<button id="downup" style="margin-left:20px">鼠标按下弹起测试</button>
<div id="move">mousemove 当鼠标进入元素，每移动一下都会被调用 次数<span class="number">0</span></div>
<div id="enter">mouseenter 当鼠标进入元素，调用一下，在其中移动，不调用 次数<span class="number">0</span></div>
<div id="over">mouseover 当鼠标进入元素，调用一下，在其中移动，不调用 次数<span class="number">0</span></div>
<div id="leave">mouseleave 当鼠标离开元素，调用一下 次数<span class="number">0</span></div>
<div id="out">mouseout 当鼠标离开元素，调用一下 <span class="number">0</span></div>
<div id="enter1" class="parentDiv">
    mouseenter 经过其子元素不会被调用 次数<span class="number">0</span>
    <div class="subDiv">div中的子元素</div>
</div>
<div id="over1" class="parentDiv">
    mouseover 经过其子元素会被调用 次数<span class="number">0</span>
    <div class="subDiv">div中的子元素</div>
</div>
<div id="leave1" class="parentDiv">
    mouseleave 经过其子元素不会被调用 次数<span class="number">0</span>
    <div class="subDiv">div中的子元素</div>
</div>
<div id="out1" class="parentDiv">
    mouseout 经过其子元素会被调用 次数<span class="number">0</span> 
    <div class="subDiv">div中的子元素</div>
</div>
```

### ajax

```html
<div id="checkResult"></div>
<form id="form"> 
输入账号 :<input id="name" type="text">
</form>
<script>
$(function(){
   $("#name").keyup(function(){
     var page = "/study/checkName.jsp";			// checkName.jsp用于校验提交的用户名是否存在
     var page2 = "/study/checkName.jsp"+value;
     var value = $(this).val();
        $.ajax({			// 提交 AJAX 请求
            url: page,			// page 表示访问的是 page 页面
            data:{"name":value},			// 表示提交的参数
            success: function(result){			// 服务器成功返回后对应的响应函数
              $("#checkResult").html(result);
            }
        });
       // 使用 get 方式提交 ajax，是 $.ajax的简化版，只有第一个参数是必须的，其他参数都是可选
       $.get(			
            page,
            {"name":value},
            function(result){
              $("#checkResult").html(result);
            }
        );
       $.post(			// 使用 post 方式提交 ajax，同 get 方式
            page,
            {"name":value},
            function(result){
              $("#checkResult").html(result);
            }
        );
       $("#checkResult").load(page2);			// 最简单的调用ajax的方式
       var data = $("#form").serialize();	// 把 form 下的输入数据格式化成字符串，结果为 name=1&age=2
       var url = "https://how2j.cn/study/checkName.jsp";
       var link = url+"?"+ data;
   });
});
```

 load 语法为`$("#id").load(page,[data]);` ，id: 用于显示 AJAX 服务端文本的元素 Id ，page: 服务端页面 ，data: 提交的数据，可选。 在本例中，直接在page里加上了参数列表 

### 数组和字符串操作

```html
<script>
var a = new Array(1,2,3);
a.sort();			// 对数组的内容进行排序
$.unique(a);			// 去掉重复的元素
$.each( a, function(i, n){			// 遍历一个数组 第一个参数是数组,第二个参数是回调函数 i是下标，n是内容
document.write( "元素[" + i + "] : " + n + "<br>" );
})
document.write($.inArray(9,a));			// 返回元素在数组中的位置 ，如果不存在返回-1
document.write($.trim(" Hello JQuery    "));			// 去除首尾空白
var s1 = "{\"name\":\"盖伦\"";
var s2 = ",\"hp\":616}";
var s3 = s1+s2;
var gareen = $.parseJSON(s3);
document.write("这是一个JSON格式的字符串:" + s3 + "<br>");		//将JSON格式的字符串，转换为JSON对象
document.write("这是一个JSON对象: " + gareen);
document.close();
$(function(){
   $("#b1").click(function(){
       var div= $("#d");			// JQuery 对象
       var d = div[0];			// JQuery 转 DOM对象
       var div2= document.getElementById("d");			// DOM 对象
       var d = $(div);			// DOM 对象转 JQuery 对象
   });
});
</script> 
<div id="d">Hello JQuery</div>
```

