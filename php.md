-  mysqli_connect() 函数打开一个到 MySQL 服务器的新的连接 

- mysqli_fetch_array() 从结果集中取得一行作为数字数组或关联数组 ，

- mysqli_data_seek() 函数调整结果指针到结果集中的一个任意行 

- mysqli_free_result 释放查询的结果集

- mysql_query() 函数执行一条 MySQL 查询 

  mysql_query($sql,$con);

-  mysqli_query() 函数执行某个针对数据库的查询 

  mysqli_query($db_conn,'SET NAMES UTF8');

- mysql_select_db() 函数设置活动的 MySQL 数据库 

- sprintf() 函数把格式化的字符串写入一个变量中 

- mysql_num_rows() 函数返回结果集中行的数目 

- header() 函数向客户端发送原始的 HTTP 报头  

- mysql_fetch_assoc() 从结果集中取得一行作为关联数组 

-  mysqli_close() 函数关闭先前打开的数据库连接 

-  require() 语句的性能与 include() 相类似，都是包括并运行指定文件 

-  trigger_error() 函数创建用户级别的错误消息 

-  mysqli_error() 函数返回最近调用函数的最后一个错误描述 

-  eval() 函数把字符串按照 PHP 代码来计算 

- json_encode() 将数值转换成 json 数据存储格式

-  move_uploaded_file() 函数将上传的文件移动到新位置 

   copy() 函数拷贝文件  

-   mysqli_insert_id() 函数返回最后一个查询中自动生成的 ID（通过 AUTO_INCREMENT 生成）

- js $(Id).pagination 中参数

   coping：默认 false， 是否开启首页和末页 

   isHide ：默认 false， 总页数为0或1时隐藏分页控件 

   current ：默认 1，当前第几页 

   callback ：回调函数， function(api){} ， 参数"index"为当前页。 即点击分页的数字按钮时所执行的操作，回调函数中有一个参数叫api，它有几个方法  getPageCount() 、 setPageCount(page) 、 getCurrent() 和 filling()  

 POST 请求从服务器加载数据 

 $(*selector*).post(*URL,data,function(data,status,xhr),dataType)* 

-  *URL* ： 将请求发送到哪个 URL 
-  *data* ： 同请求发送到服务器的数据 
-  function(data,status,xhr) ： 定当请求成功时运行的函数 ，data - 包含来自请求的结果数据，status - 包含请求的状态（"success"、"notmodified"、"error"、"timeout"、"parsererror"），xhr - 包含 XMLHttpRequest 对象。data为请求返回的结果

<meta name="viewport"?

 attr() 函数用于设置或返回当前 jQuery 对象所匹配的元素节点的属性值 

$.ajax，$("#submit").removeAttr， windows.location.href 当前页面打开URL页面 

$_SERVER['HTTP_HOST'] 获取当前域名

 $("").mouseenter() 方法当鼠标指针进入（穿过）元素时 

$("p").fadeOut()  使用淡出效果来隐藏一个\<p> 元素 

a 标签中的 download 指定下载的文件名

 `LEFT()`函数是一个字符串函数，它返回具有指定长度的字符串的左边部分 

$.cookie.json

 Math.ceil(x) 返回大于等于参数x的最小整数 

 $.each() 用于遍历数组，$.each(arr1,function(i,val)，i 是下标，val 是值

 网页被卷去的高： `document.body.scrollTop`，要获取当前页面的滚动条纵坐标位置，用 document.documentElement.scrollTop 

表格居中：\<tr style="text-align:center;" >

input 长度