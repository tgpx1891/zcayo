BootStrap 是 Twitter 的工程师开发的前端框架，可以非常方便的设计出好看的页面效果。  因为 bootstrap 用到了 html5 的特性，为了正常使用，需要在最开头加上`<!DOCTYPE html>`。导入 js 和 css，顺序不要搞错了

```
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
```

### 基础样式

#### 按钮

```html
<button type="button" class="btn">原始样式按钮</button>	<!-- 平面，灰背黑字 -->
<button type="button" class="btn btn-default">默认按钮</button>	<!-- 无色黑字 -->
<button type="button" class="btn btn-primary">提交按钮</button>	<!-- 蓝背白字 -->
<button type="button" class="btn btn-success">成功按钮</button>	<!-- 绿背白字 -->
<button type="button" class="btn btn-info">信息按钮</button>	<!-- 浅蓝背白字 -->
<button type="button" class="btn btn-warning">警告按钮</button>	<!-- 橙背白字 -->
<button type="button" class="btn btn-danger">危险按钮</button>	<!-- 红背白字 -->
<button type="button" class="btn btn-link">表现为链接</button>
<button type="button" class="btn btn-lg">大一点的按钮</button>
<button type="button" class="btn btn-sm">小一点的按钮</button>
<button type="button" class="btn btn-xs">最小的按钮</button>
<button type="button" class="btn btn-block">宽屏按钮</button>
<button type="button" class="btn active">激活状态按钮</button>	<!-- 处于正在被按下状态 -->
<button type="button" class="btn disabled">领红包</button>			<!-- 无效按钮 -->
<button type="button" class="btn disabled btn-danger btn-xs">发红包</button><!-- 多种按钮样式混用 -->
<button type="button" class="close" aria-hidden="true">&times;</button>		<!-- 关闭按钮 x -->
```

`aria-hidden="true"`残障人士如失明的人使用识读设备（自动读取内容并自动播放出来），播放到带此属性的内容时会自动跳过，以免残障人士混淆。role 也是给有阅读障碍的人设置的属性，用来注明作用

#### 表格

```html
<table class="table">			<!-- 拥有横向分割线的表格，宽度占用父容器的 -->
<table class="table table-striped">			<!-- 通过斑马线把奇偶行的区别表现出来 -->
<table class="table table-bordered">			<!-- 给表格的单元格加上边框 -->
<table class="table table-hover">			<!-- 鼠标悬停高亮显示 -->
<table class="table table-condensed">			<!-- 更加紧凑的表格 -->
<!-- 多种表格样式混合使用 -->
<table class="table table-striped table-bordered table-hover  table-condensed">
  <thead>
     <th>头像</th>
     <th>名字</th>
     <th>HP</th>
  </thead>
  <tbody>
     <tr>
        <td><img width="20px" src="https://how2j.cn/study/bootstrap/lol/gareen.png"/></td> 
        <td>盖伦</td> 
        <td>616</td> 
     </tr>
 <tr>
        <td><img width="20px" src="https://how2j.cn/study/bootstrap/lol/teemo.png"/></td> 
        <td>提莫</td> 
        <td>383</td> 
     </tr>
 <tr  class="active">激活样式，浅灰
 <tr  class="success">成功样式，浅绿
 <tr  class="info">信息样式，浅蓝
 <tr  class="warning">警告样式，浅橙
        <td><img width="20px" src="https://how2j.cn/study/bootstrap/lol/akali.png"/></td> 
        <td>阿卡丽</td> 
        <td>448</td> 
     </tr>
  </tbody>
</table>

```

#### 各种

对输入元素使用 form-control 可以去除阴影，边框附带淡蓝色，输入状态更加柔和

```html
<!-- 图片 -->
<img src="https://how2j.cn/example.gif" class="img-rounded">圆角			<!-- 更加紧凑的表格 -->
<img src="https://how2j.cn/example.gif" class="img-circle">圆形			<!-- 更加紧凑的表格 -->
<img src="https://how2j.cn/example.gif" class="img-thumbnail">缩略图			<!-- 更加紧凑的表格 -->
<!-- 表单 -->
<div class="col-xs-4">			<!-- 对表单控件宽度进行设置 -->
<input type="password" class="form-control" value="password"><br>
</div>
<textarea class="form-control">文本域</textarea><br>
<select class="form-control">
   <option>Java</option>
   <option>Html</option>
   <option>IOS</option>
</select>
<!-- 文本 -->
<span class="text-muted">muted</span>			<!-- 淡灰色文本，常用在说明性文字 -->
<span class="text-primary">primary</span>			<!-- 强调的文本，蓝 -->
<span class="text-success">success</span>			<!-- 操作成功文本，绿 -->
<span class="text-info">info</span>			<!-- 提示信息文本，浅蓝 -->
<span class="text-warning">warning</span>			<!-- 警告文本，橙 -->
<span class="text-danger">danger</span>			<!-- 危险操作文本，红 -->
<!-- 背景 -->
<p class="bg-primary">强调</p>			<!-- 强调，蓝背白字 -->
<p class="bg-success">操作成功</p>			<!-- 成功操作文字，浅绿背黑字 -->
<p class="bg-info">请输入姓名</p>			<!-- 信息提示文字，浅蓝背黑字 -->
<p class="bg-warning">警告语</p>			<!-- 警告提示文字，浅粉背黑字 -->
<p class="bg-danger">危险提示</p>		<!-- 危险提示文字，粉红背黑字 -->
```

#### 其它

```html
<span class="caret"></span>下拉菜单图标
<div class="pull-left">文字浮动到左边</div>
<div class="pull-right">文字浮动到右边</div>
<div class="show">显示</div>
<div class="hidden">隐藏</div>			<!-- 会把元素的位置让出来 -->
<div class="invisible">隐藏</div>			<!-- 元素的位置会保留 -->
```

运用 Bootstrap 的栅格系统，可以做出像 table 那样定义多少行，多少列效果，但是又比 table 灵活

```html
<style>
div.container div.row div {
    margin:5px 0px;  
}
div.container div.row div {
    background-color: lightgray;
    border: 1px solid gray;
    text-align:center;
}
</style>
<div class="container">
    <div class="row">
        <div class="col-xs-12 ">一共12列</div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-xs-1 ">1列</div>
        <div class="col-xs-6 ">一半</div>
        <div class="col-xs-4 ">1/3</div>
        <div class="col-xs-3 ">1/4</div>		<!-- 一行不是必须添满的 -->
    </div>
</div>
<div class="container">		<!-- 当同一行的栅格总数超过12的时候，就会自动换行，6会到下一行 -->
    <div class="row">
        <div class="col-xs-8 ">8格</div>
        <div class="col-xs-6 ">6格</div>
    </div>
</div>
```

#### 字体图标

Bootstrap提供了总共263种字体图标。所有的字体图标：<https://how2j.cn/k/boostrap/boostrap-font/484.html>

```html
<span class="glyphicon glyphicon-asterisk"></span>			<!-- 一个 * 字体图标 -->
<span class="glyphicon glyphicon-asterisk text-success"></span>		<!-- 字体图标设置颜色（绿） -->
```

#### 下拉菜单

```html
<div class="dropdown">
    <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
      http://192.168.1.189
      <span class="caret"></span>			<!-- 下拉图标 -->
    </button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
        <li class="dropdown-header">			<!-- 标题不可点击 -->
            静态页面(不可点击)
        </li>
        <li role="presentation">
            <a href="#">HTML</a>            
        </li>
        <li role="presentation">
            <a href="#">CSS</a>             
        </li>
        <li role="presentation" class="divider"></li>			<!-- 菜单分割线 -->
        <li role="presentation">
            <a href="#">Javascript</a>          
        </li>
        <li role="presentation">
            <a href="#">AJAX</a>            
        </li>
        <li role="presentation" class="disabled">			<!-- 禁用项 -->
            <a role="menuitem" tabindex="-1" href="#">Bootstrap(开发中)</a>
        </li>
    </ul>
</div>   
<div style="height:100px"></div>
```

html 中的 tabIndex 属性可以设置键盘中的 TAB 键在控件中的移动顺序。把控件的tabIndex属性设成1到32767的一个值，就可以把这个控件加入到TAB键的序列中。这样，当浏览者使用TAB键在网页控件中移动时，将首先移动到具有最小tabIndex属性值的控件上，最后在具有最大 tabIndex 属性值的控件上结束移动

### 组件

#### 按钮组 

```html
<div class="btn-toolbar" role="toolbar" aria-label="study">		<!-- 按钮工具栏（多个按钮组） -->
<div class="btn-group btn-group-lg" role="group" aria-label="web">		<!-- 按钮组最大 -->
<div class="btn-group" role="group" aria-label="web">			<!-- 按钮组 -->
<div class="btn-group btn-group-sm" role="group" aria-label="web">
<div class="btn-group btn-group-xs" role="group" aria-label="web">
  <button type="button" class="btn btn-default">Html</button>
  <button type="button" class="btn btn-default">Css</button>
</div>
<div class="btn-group-vertical" role="group" aria-label="java">			<!-- 垂直排列的按钮组 -->
  <button type="button" class="btn btn-default">基础</button>
  <button type="button" class="btn btn-default">中级</button>
</div>
</div>
<div class="btn-group" data-toggle="buttons">			<!-- 按钮式单选框组 -->
  <label class="btn btn-default active">
    <input type="radio" checked>LOL(默认选中)			<!-- checked 似乎没有效果 -->
  </label>
  <label class="btn btn-default">
    <input type="radio" > DOTA
  </label>
</div>
<div class="btn-group">			<!-- 单按钮下拉菜单 -->
    <!-- 大号 -->
    <button type="button" class="btn btn-lg btn-default dropdown-toggle " data-toggle="dropdown">
    <!-- default -->
    <button type="button" class="btn btn-default dropdown-toggle "  data-toggle="dropdown">
    <!-- 小号 -->
    <button type="button" class="btn btn-sm btn-default dropdown-toggle " data-toggle="dropdown">
    <!-- 更小 -->
    <button type="button" class="btn btn-xs btn-default dropdown-toggle " data-toggle="dropdown">
      <span class="caret"></span>         
    </button>
    <!-- 分裂式按钮下拉菜单 -->
    <button type="button" class="btn btn-default">默认</button>
    <button type="button" class="btn btn-default dropdown-toggle"
       data-toggle="dropdown">
       <span class="caret"></span>
    </button>
    <!-- 向上弹出式菜单 -->
    <button type="button" class="btn btn-default dropdown-toggle " id="dropdownMenu1" data-toggle="dropdown">
     default
      <span class="caret"></span>         
    </button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
    
    <ul class="dropdown-menu" role="menu">
      <li>
         <a href="#">HTML</a>            
      </li>
      <li role="presentation">
         <a href="#">CSS</a>             
      </li>
    </ul>
</div> 
<div style="height:100px"></div>			<!-- 空出一片区域 -->
```

#### 输入框组 

可以整合复选框、单选框、按钮、下拉菜单和分裂式下拉菜单 

```html
<style>
div{
  margin:5px;
}
</style>
<div class="input-group input-group-lg">			<!-- 大 -->
<div class="input-group">
<div class="input-group input-group-sm">
  <input type="text" class="form-control" placeholder="邮箱" aria-describedby="basic-addon2">
  <span class="input-group-addon" id="basic-addon2">@12306.com</span>	<!-- id不起作用 -->
</div>
<div class="input-group">			<!-- 整合复选框 -->
    <span class="input-group-addon">			<!-- addon 需加在 span 上 -->
        <input type="checkbox" >
    </span>
    <input type="text" class="form-control" >
</div>
<div class="input-group">			<!-- 整合下拉菜单 -->
    <input type="text" class="form-control" aria-label="...">
    <div class="input-group-btn">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">搜索<span class="caret"></span></button>
        <ul class="dropdown-menu dropdown-menu-right" role="menu">   <!-- 不加 right 类会超出 -->
            <li><a href="#">Google</a></li>
            <li><a href="#">百度</a></li>
            <li><a href="#">搜狗</a></li>
            <li class="divider"></li>
            <li><a href="#">人民搜索</a></li>
        </ul>
    </div>
</div>
```

- aria-label：正常情况下，form 表单的 input 组件都有对应的 label.当 input 组件获取到焦点时，屏幕阅读器会读出相应的 label 里的文本。但是如果我们没有给输入框设置 label 时，当其获得焦点时，屏幕阅读器会读出 aria-label 属性的值，aria-label 不会在视觉上呈现效果
- aria-describedby：当想要的标签文本已在其他元素中存在时，可以使用 aria-labelledby，并将其值为所有读取的元素的 id
- aria-expanded：aria-expanded表示展开状态。默认为undefined, 表示当前展开状态未知。其它可选值：true表示元素是展开的；false表示元素不是展开的。

aria 属性表：<https://blog.csdn.net/weixin_38203203/article/details/80594737>

#### 导航栏

```html
<ul class="nav nav-tabs">			<!-- 标签页 -->
<ul class="nav nav-pills">			<!-- 胶囊式标签页 -->
<ul class="nav nav-pills nav-stacked" style="width:100px">			<!-- 垂直胶囊式标签页 -->
  <li role="presentation" class="active"><a href="#">Java</a></li>
  <li role="presentation"><a href="#">IOS</a></li>
  <li role="presentation" class="disabled"><a href="#">Android</a></li>			<!-- 禁用的链接 -->
</ul>
<ol class="breadcrumb">			<!-- 面包屑导航（以斜杆分隔） -->
  <li><a href="#">前端技术</a></li>
  <li><a href="#">BootStrap </a></li>
  <li class="active">BootStrap 面包屑导航 </li>
</ol>
```

#### 分页

```html
<nav>
  <ul class="pagination pagination-lg">			<!-- 大 -->
  <ul class="pagination">
  <ul class="pagination pagination-sm">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>			<!-- 双左号 -->
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li class="disabled">禁用状态
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>			<!-- 双右号 -->
      </a>
    </li>
  </ul>
  <ul class="pager">			<!-- 翻页 -->
    <li><a href="#">上一页</a></li>
    <li><a href="#">下一页</a></li>
    <!-- 两端对齐，&larr; &rarr;为左右箭头 -->
    <li class="previous"><a href="#"><span aria-hidden="true">&larr;</span> 上一页</a></li>
    <li class="next"><a href="#">下一页 <span aria-hidden="true">&rarr;</span></a></li>
  </ul>
</nav>
```

#### 标签

```html
<span class="label label-default">默认</span>			<!-- 灰背白字 -->
<span class="label label-primary">强调</span>			<!-- 蓝背白字 -->
<span class="label label-success">成功</span>			<!-- 绿背白字 -->
<span class="label label-info">信息</span>			<!-- 浅蓝背白字 -->
<span class="label label-warning">警告</span>			<!-- 橙背白字 -->
<span class="label label-danger">危险</span>			<!-- 红背白字 -->

<a href="#">新的消息<span class="badge">42</span></a>			<!-- 超链旁的徽记 -->
<button class="btn btn-primary" type="button">			<!-- 按钮中的徽记 -->
  未读消息<span class="badge">4</span>
</button>

<div class="jumbotron">			<!-- 超大屏幕 -->
  <div class="container" align="center">
      <h2 class="text-info" style="font-family:宋体;font-weight:bold;font-size:49px">逼乎</h2>
      <br>
      <div class="text-muted">与世界分享你的逼格</div>
      <br>
      <br>
      <p><a role="button" href="#" class="btn btn-success">注册</a></p>
  </div>
</div>

<div class="page-header">			<!-- 副标题 -->
  <h1>正标题<small>副标题</small></h1>
</div>

<style>
img{
  width:150px;
}
</style>
<div class="container">			<!-- 相册风格 -->
    <div class="row">
        <div class="col-xs-3 ">
            <a href="#" class="thumbnail">
                <img src="https://how2j.cn/study/gareen.jpg">
            </a>
            <div class="caption">
                <div class="text-muted">德玛西亚之力</div>
                <br>
                <p><a href="#" class="btn btn-primary" role="button">选中</a></p>
            </div>
        </div>
        <div class="col-xs-3 ">
            <a href="#" class="thumbnail">
                <img src="https://how2j.cn/study/annie.jpg">
            </a>
        </div>
    </div>
</div>
```

#### 警告框

```html
<div class="alert alert-success" role="alert">操作成功</div>			<!-- 浅绿 -->
<div class="alert alert-info" role="alert">信息提示</div>			<!-- 浅蓝 -->
<div class="alert alert-warning" role="alert">警告提示</div>			<!-- 浅黄 -->
<div class="alert alert-danger" role="alert">危险提示</div>			<!-- 红 -->
<div class="alert alert-warning alert-dismissible" role="alert">
  <!-- 可关闭的警告框，不加close时x号会出现在左边，dismissible？ -->
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  警告提示
</div>
<div class="alert alert-success" role="alert">			<!-- 警告框中的链接 -->
  <span>大减价！！！</span><a href="#nowhere" class="alert-link">点击购买</a>
</div>
```

#### 进度条

```html
<div class="progress">
  <div class="progress-bar" style="width: 60%;">			<!-- 蓝色 -->
  <div class="progress-bar progress-bar-success"  style="width: 40%">			<!-- 绿色 -->
  <div class="progress-bar progress-bar-info"   style="width: 20%">			<!-- 浅蓝色 -->
  <div class="progress-bar progress-bar-warning"   style="width: 60%">			<!-- 橙色 -->
  <div class="progress-bar progress-bar-danger"   style="width: 80%">			<!-- 红色 -->
  <div class="progress-bar" style="width: 60%; min-width: 2em;" >		<!-- 带有提示的进度条 -->
  <!-- 绿色条纹 -->
  <div class="progress-bar progress-bar-success progress-bar-striped"  style="width: 40%">
  <div class="progress-bar progress-bar-striped active" style="width: 45%">	<!-- 发廊，会动？ -->
60%</div>
<!-- 堆叠（35%+20%+10%） -->
<div class="progress">
  <div class="progress-bar progress-bar-success" style="width: 35%">
  </div>
  <div class="progress-bar progress-bar-warning progress-bar-striped" style="width: 20%">
  </div>
  <div class="progress-bar progress-bar-danger" style="width: 10%">
  </div>
</div>
```

#### 列表

列表可以是徽记、链接和按钮 

```html
<ul class="list-group">			<!-- 带徽记列表，徽记和列表会左右分开 -->
  <li class="list-group-item"><span class="badge">3</span>回锅肉</li>
  <li class="list-group-item"><span class="badge">14</span>烧烤</li>
  <a href="#" class="list-group-item active">鱼香肉丝</a>			<!-- 链接，激活，蓝背白字 -->
  <a href="#" class="list-group-item list-group-item-success">烧烤</a>			<!-- 浅绿色 -->
  <a href="#" class="list-group-item list-group-item-info">鱼香肉丝</a>			<!-- 浅蓝色 -->
  <a href="#" class="list-group-item list-group-item-warning">麻婆豆腐</a>			<!-- 浅黄色 -->
  <a href="#" class="list-group-item list-group-item-danger">夫妻肺片</a>			<!-- 粉红色 -->
</ul>
```

#### 面板

```html
<div class="panel panel-default">			<!-- 灰色黑字 -->
<div class="panel panel-success">			<!-- 浅绿色 -->
<div class="panel panel-info">			<!-- 浅蓝色 -->
<div class="panel panel-warning">			<!-- 浅黄色 -->
<div class="panel panel-danger">			<!-- 粉红色 -->
  <div class="panel-heading">面板标题</div>
  <div class="panel-body">面板内容</div>
  <div class="panel-footer">面板脚注</div>
</div>

<div class="well">文字呈现嵌入效果</div>			<!-- 嵌入效果 -->
```

#### 顶部底部

```html
<style>			/* 使内容下移能看见下拉条 */
  body{
    padding-top:70px;
  }
</style>
<nav class="navbar navbar-default navbar-fixed-top">			<!-- 贴在顶部(不会消失） -->
<nav class="navbar navbar-default navbar-static-top">			<!-- 贴在顶部(会消失) -->
  <button class="btn btn-info">菜单1</button>
  <button class="btn btn-success">菜单2</button>
  <button class="btn btn-danger">菜单3</button>
</nav>
<div style="white-space:pre">
  很多内容 ，下拉才看得见，下拉时，置顶菜单不消失
  很多内容 ，下拉才看得见，下拉时，置顶菜单不消失
  很多内容 ，下拉才看得见，下拉时，置顶菜单不消失
  很多内容 ，下拉才看得见，下拉时，置顶菜单不消失
</div>
<nav class="navbar navbar-default navbar-fixed-bottom">			<!-- 贴在底部 (不会消失) -->
<div style="text-align:center">
 版权所有
</div>
</nav>
```

### 插件

#### 模态窗体 

```html
<script>			// 监听模态的变化
$(function(){
    $("#myModal").on("show.bs.modal",function(){		// show 方法调用之后立即触发该事件	
      alert("开始显示模态窗口");
    });
    // 此事件在模态框已经显示出来（并且同时在 CSS 过渡效果完成）之后被触发
    $("#myModal").on("shown.bs.modal",function(){
      alert("显示模态窗口完毕");
    });
    $("#myModal").on("hide.bs.modal",function(){		// hide 方法调用之后立即触发该事件
      alert("开始隐藏模态窗口");
    });
    // 此事件在模态框被隐藏（并且同时在 CSS 过渡效果完成）之后被触发
    $("#myModal").on("hidden.bs.modal",function(){
      alert("隐藏模态窗口完毕");
    });
    // loaded.bs.modal 从远端的数据源加载完数据之后触发该事件
    
    $("#open").click(function(){			// 使用JS控制模态窗口
      $("#myModal").modal('show');			// 显示
      $("#myModal").modal('hide');			// 隐藏
      $("#myModal").modal('toggle');			// 切换
   });
});	
</script>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">提问</button>
<button  class="btn btn-default" id="open"> 打开模态窗口</button>
<!-- 点击弹出模态窗口 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
<!-- 不要动画效果 -->
<div class="modal " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
<!-- 点击空白（旁边）不会收起 -->
<div class="modal fade" id="myModal"  data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">提问</h4>
              </div>
              <div class="modal-body">
                <p>问题描述</p>
                <textarea class="form-control"></textarea>
              </div>
              <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button class="btn btn-primary" type="button">提交</button>
              </div>
            </div>
    </div>
</div>
 
<div style="height:200px"></div>
```

####  可切换导航栏

```html
<body>
<style>
p{
 
  margin-left:10px;
  margin-top:10px;
}
</style>
<ul id="myTab" class="nav nav-tabs">
   <li class="active"><a href="#dota" data-toggle="tab">DotA</a></li>
   <li><a href="#lol" data-toggle="tab">英雄联盟</a></li>
   <li class="dropdown">
      <a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown">其他类似游戏<b class="caret"></b></a>
      <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
         <li><a href="#storm" tabindex="-1" data-toggle="tab">风暴英雄</a></li>
         <li><a href="#h300" tabindex="-1" data-toggle="tab">300英雄</a></li>
      </ul>
   </li>
</ul>
<div id="myTabContent" class="tab-content">
   <div class="tab-pane fade in active" id="dota">			<!-- in active 是一起的 -->
      <p>《DotA》（Defense of the Ancients），可以译作守护古树、守护遗迹、远古遗迹守卫， 是由暴雪公司出品即时战略游戏《魔兽争霸3》的一款多人即时对战、自定义地图，可支持10个人同时连线游戏，是暴雪公司官方认可的魔兽争霸的RPG地图。</p>
   </div>
   <div class="tab-pane fade" id="lol">
      <p>《英雄联盟》（简称lol）是由美国Riot Games开发，中国大陆地区由腾讯游戏运营的网络游戏。</p>
   </div>
   <div class="tab-pane fade" id="storm">
      <p>
      《风暴英雄》 是由暴雪娱乐公司开发的一款运行在Windows和Mac OS上的在线多人竞技PC游戏。</p>
       <p> 游戏中的英雄角色主要来自于暴雪三大经典游戏系列：《魔兽世界》、《暗黑破坏神》和《星际争霸》。它是一款道具收费的游戏，与《星际争霸Ⅱ》基于同一引擎开发。
      </p>
   </div>
   <div class="tab-pane fade" id="h300">
      <p>《300英雄》是由上海跳跃网络科技有限公司自主研发，深圳中青宝互动网络股份有限公司运营的一款类DOTA网游。游戏以7v7组队对抗玩法为主，提供永恒战场和永恒竞技场两种经典模式任由玩家选择，并创新性地加入勇者斗恶龙、克隆战争等多种休闲娱乐玩法。
      </p>
   </div>
</div>
 
<div style="height:200px"></div>
```

#### 提示信息

```html
<button style="margin-left:100px" type="button" class="btn btn-default" data-toggle="tooltip" data-placement="left" title="提示信息">鼠标悬停</button>			<!-- 左侧提示 -->
<button style="margin-right:100px" type="button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="提示信息">鼠标悬停</button>			<!-- 右侧提示 -->
<button style="margin-top:50px" type="button" class="btn btn-default" data-toggle="tooltip" data-placement="top" title="提示信息">鼠标悬停</button>			<!-- 上侧提示 -->
<button style="margin-bottom:50px" type="button" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="提示信息">鼠标悬停</button>			<!-- 下侧提示 -->
<script>
   $(function () 
   { 
       $("[data-toggle='tooltip']").tooltip(); 			// 弹出提示信息
   });
</script>
```

#### 折叠

```html
<style>
div.well{
  margin:10px;
}
</style>
<a class="btn btn-info" role="button" data-toggle="collapse" href="#dota" aria-expanded="false" aria-controls="collapseExample">DotA</a>			<!-- 以链接形式 -->
<button class="btn btn-info" type="button" data-toggle="collapse" data-target="#lol" aria-expanded="false" aria-controls="collapseExample">LOL</button>			<!-- 以按钮形式 -->
<div class="collapse" id="dota">
  <div class="well">
《DotA》（Defense of the Ancients），可以译作守护古树、守护遗迹、远古遗迹守卫， 是由暴雪公司出品即时战略游戏《魔兽争霸3》的一款多人即时对战、自定义地图，可支持10个人同时连线游戏，是暴雪公司官方认可的魔兽争霸的RPG地图。
  </div>
</div>
<div class="collapse" id="lol">
  <div class="well">
《英雄联盟》（简称lol）是由美国Riot Games开发，中国大陆地区由腾讯游戏运营的网络游戏。
  </div>
</div>
<div style="height:100px"></div>
<!-- 面板折叠 -->
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          DOTA
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">			<!-- in 展开 -->
      <div class="panel-body">
       《DotA》（Defense of the Ancients），可以译作守护古树、守护遗迹、远古遗迹守卫， 是由暴雪公司出品即时战略游戏《魔兽争霸3》的一款多人即时对战、自定义地图，可支持10个人同时连线游戏，是暴雪公司官方认可的魔兽争霸的RPG地图。
      </div>
    </div>
  </div>
  ...
</div>
```

#### 基本轮播

```html
<style>
  div.item img{
    width:100%;
   }
  div#carousel-example-generic{
    width:80%;
    margin:0 auto;
  }
</style>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="1000">			<!-- data-interval设置轮播速度，1秒一次 -->
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
  </ol>
  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="https://how2j.cn/img/site/step/3491.png" >
      <div class="carousel-caption">LOL1</div>			<!-- 带标题 -->
    </div>
    <div class="item">
            <img src="https://how2j.cn/img/site/step/3492.png" >
    </div>
  </div>
  <!-- 控制前后 -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">			<!-- 左号 -->
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">			<!-- 右号 -->
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
  </a>
</div>
```

