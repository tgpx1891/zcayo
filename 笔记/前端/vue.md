把一个 json对象的数据，显示到一个元素上去。如果不使用 Vue, 那么就会用到 JS 或者 JQuery，通过操作 HTML DOM 的方式，把数据显示上去。如果使用 Vue, 那么仅仅需要提供数据，以及数据要绑定到的元素的 id 就行了,不需要显式地操作 HTML DOM

```html
<script src="http://how2j.cn/study/vue.min.js"></script><!-- 导入 vue.js 要用到的库，版本v2.5.16 -->
<div id="div1">{{gareen.name}}</div>			<!-- 获取 vue 数据 -->
<script>
// 通过 JS 的方式
var gareen = {"name":"盖伦","hp":616};
var div1 = document.getElementById("div1");
div1.innerHTML= gareen.name;
// 通过vue.js 把数据和对应的视图关联起来
new Vue({
      el: '#div1',
      data: {
        message: gareen
      }
    })
</script>
```

### 监听事件

```html
<style>
table tr td{
    border:1px solid gray;
}
table{
    border-collapse:collapse;
    width:300px;
}
tr.firstLine{
    background-color: lightGray;
}
</style>
<div id="div1">
  <div>一共点击了  {{clickNumber}}次</div> 
  <button v-on:click="count">点击</button>			<!-- v-on 还可以缩写为 @ -->
  <button @click="count">点击</button>
  <!-- 阻止页面刷新 -->
  <a href="http://12306.com" @click="jump" >正常的链接</a><br>	
  <a href="http://12306.com" @click.prevent="jump" >prevent jump()</a><br>		<!-- 阻止页面刷新 -->
  <a href="http://12306.com" @click.prevent >纯prevent</a><br>
  <form @submit="jump" action="http://12306.com">
    <button type="submit">正常的form</button>
  </form>
  <form @submit.prevent="jump" action="http://12306.com">
  <form @submit.prevent action="http://12306.com">
  <!-- 条件语句 -->
  <button v-on:click="toutai">切换显示</button>
  <div v-if="number>98"> 神仙</div>			<!-- 当 number>98 的时候显示 -->
  <div v-else-if="number>95"> 国家领导人</div>			<!-- 当 number>95 的时候显示 -->
  <div v-else> 流浪汉</div>			<!-- 当 number<=95 的时候显示 -->
  <!-- 循环语句 -->    
  <table align="center" >
        <tr class="firstLine">
            <td>number</td>
            <td>name</td>
            <td>hp</td>
        </tr>
        <tr v-for="hero,index in heros">
            <td>{{index+1}}</td>			<!-- index 从 0 开始 -->
            <td>{{hero.name}}</td>
            <td>{{hero.hp}}</td>
        </tr>	
  </table>
  <div v-for="i in 10">			<!-- 纯数字遍历 -->
     {{ i }}
  </div>
</div>
<script>
var data = [
          {name:"盖伦",hp:341},
          {name:"提莫",hp:225},
          {name:"安妮",hp:427},
          {name:"死歌",hp:893}
    ];
new Vue({
      el: '#div1',
      data: {
          clickNumber:0,
          heros:data
      },
      methods:{
          count: function(){
              this.clickNumber++;
          },
          jump:function(){
              alert("jump()函数被调用");
          },
          toutai: function(){
             this.number=Math.random()*100
          }
      }
    })
</script>
```

 通过在 click 后面添加 .prevent 可以阻止页面刷新， 只有超链和 form 这种会导致页面刷新的操作，.prevent 才有用。 普通的不导致页面刷新的按钮，加上这个没有任何变化 

#### 冒泡

 冒泡就是父元素里有子元素， 如果点击了 子元素, 那么 click 事件不仅会发生在子元素上，也会发生在其父元素上，依次不停地向父元素冒泡，直到 document 元素 

```html
<style type="text/css">
   * {
       margin: 0 auto;
       text-align:center;
       line-height: 40px;
   }
   div {
       width: 100px;
       cursor:pointer;
   }
   #grandFather {
       background: green;
   }
   #father {
       background: blue;
   }
   #me {
       background: red;
   }#son {
        background: gray;
    }
</style>
<div id="content">
    <div id="grandFather"  v-on:click="doc">
        grandFather
        <div id="father" v-on:click="doc">
        <div id="me" v-on:click.stop="doc">			<!-- 事件修饰符.stop 阻止冒泡 -->	
        <div id="father" v-on:click.capture="doc">		<!-- 点击子元素时优先触发子元素 .capture -->
        <div id="father" v-on:click.self="doc">			<!-- 只有自己能触发，子元素无法触发.self -->
        <div id="father" v-on:click.once="doc">			<!-- 只能提交一次 .once -->
            father
            <div id="me" v-on:click="doc">
                me
                <div id="son" v-on:click="doc">
                son
            </div>
            </div>
        </div>
    </div>
</div>
<script>
    var content = new Vue({
        el: "#content",
        data: {
            id: ''
        },
        methods: {
            doc: function () {
                this.id= event.currentTarget.id;
                alert(this.id)
            }
        }
    })
</script>
```

### 属性绑定

```html
<div id="div1">
    <a v-bind:href="page">http://12306.com</a>			<!-- 通过 v-bind 进行属性绑定 -->
    <a :href="page">http://12306.com</a>			<!-- v-bind:href 简写成 :href -->
    hero name: <input v-model="name" >			<!-- 通过 v-model 双向绑定 -->
    <button @click="doClick" >提交数据</button>	
    <textarea v-model="textarea" placeholder="输入数据"></textarea>
    <input type="checkbox" id="checkbox" v-model="checked">
    <!-- 单个复选框，默认值是true或者false，也可以修改为自定义的值，取值 yes、no -->
    <input type="checkbox" id="toggle" true-value="yes" false-value="no" v-model="toggle">
    <!-- 多个复选框，取值 [ "gareen", "teemo" ]、[] -->
    <input type="checkbox" id="teemo" value="teemo" v-model="checkedes">
    <label for="teemo">teemo</label>
    <input type="checkbox" id="gareen" value="gareen" v-model="checkedes">
    <label for="gareen">gareen</label>
    <!-- 单选按钮，取值 One、Two -->
    <input type="radio" id="one" value="One" v-model="radio">
    <label for="one">One</label>
    <input type="radio" id="two" value="Two" v-model="radio">
    <label for="two">Two</label>
    <!-- 单选选择框，取值 AD、AC -->
    <select v-model="selected" size="5">
        <option disabled value="">请选择</option>
        <option>AD</option>
        <option>AC</option>
    </select>
    <!-- 多选选择框，取值 [ "AD", "AC" ] -->
    <select v-model="selecteds" multiple size="5">
        <option disabled value="">请选择</option>			<!-- 此选择不可用 -->
        <option>AD</option>
        <option>AC</option>
    </select>
    <input v-model.lazy="input" placeholder="输入数据"><!-- 只有在失去焦点的时候，才会进行数据绑定 -->
    <!-- v-model默认是string类型，通过.number方式获取到的是数字类型 -->
    <input v-model.number="input" type="number" placeholder="输入数据">
    <p>{{ typeof input }}</p>			<!-- 结果是 number -->
    <input v-model.trim="input" placeholder="输入数据">			<!-- 去掉前后的空白，比如"123" -->
</div>   
<script>
new Vue({
      el: '#div1',
      data:{
          page:'http://12306.com',
          name:"teemo",	
          input:''
      },
      methods:{
          doClick:function(){
              alert(this.name);
          }
      }
    })
</script>
```

 进行双向绑定后，当 input 里面的值发生变化的时候，就会自动把变化后的值，绑定到Vue对象上去 

### 计算属性

```html
<div id="div1">
汇率： <input type="number" v-model.number="exchange" /><br>
￥: <input type="number" v-model.number = "rmb"  /><br>
$: {{ rmb/exchange }}			<!-- 例如 123/6.4=19.21875 -->
$: {{ dollar }}			<!-- 使用 computed -->
$: {{ getDollar() }}			<!-- 使用 methods -->	
$: <input type="number" v-model.number = "dollar"   />			<!-- 同时在 data 中增加 dollar -->
</div>
<script>
new Vue({
      el: '#div1',
      data: {
          exchange:6.4,
          rmb:0,
          dollar:0
      },
      computed:{
          dollar:function() {
              return this.rmb / this.exchange;
          }
      },
      methods:{
          getDollar:function() {
              return this.rmb / this.exchange;
          }
      },
      watch:{			// 监听属性值的变化，rmb 变化也会跟着变化
          rmb:function(val) {
              this.rmb = val;
              this.dollar = this.rmb / this.exchange;
          },
          dollar:function(val) {
              this.dollar = val;
              this.rmb = this.dollar * this.exchange;
          },
      }
    })
</script>
```

 computed 是有缓存的，只要rmb没有变化，dollar 会直接返回以前计算出来的值，而不会再次计算。 这样如果是复杂计算，就会节约不少时间。而 methods 每次都会调用 

### 过滤器

```html
<div id="div1">
	<input v-model= "data" />
    <p>{{ data|capitalize }}</p>			<!-- 一个过滤器 -->
    <p>{{ data|capitalize|capitalizeLastLetter }}</p>p>			<!-- 两	个过滤器 -->
</div>
<script>
new Vue({
      el: '#div1',
      data: {
          data:''
      },
      filters:{			// 首字母大写过滤器
          capitalize:function(value) {
                if (!value) return ''		
                value = value.toString()
                return value.charAt(0).toUpperCase() + value.substring(1)
          },
          capitalizeLastLetter:function(value) {			// 尾字母大写过滤器
                if (!value) return ''
                value = value.toString()
                return value.substring(0,value.length-1)+ value.charAt(value.length-1).toUpperCase()
          }
      }
    })
Vue.filter('capitalize', function (value) {			// 注册全局过滤器
    if (!value) return ''
    value = value.toString()
    return value.charAt(0).toUpperCase() + value.slice(1)
})
</script>
```

### 组件

组件就是模板，只用做一个模板，然后照着这个模板，传递不同的参数就可以看到不同的产品展示了 

```html
<style>
div.product{
  float:left;
  border:1px solid lightGray;
  width:200px;
  margin:10px;
  cursor: pointer;
}
</style>
<div id="div1">
    <product></product>				<!-- 调用组件 -->
    <product name="MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮"></product>
    组件外的值：<input v-model="outName" ><br>			<!-- 输入数据，就可以传递到组件内 -->
    <product v-bind:name="outName"></product>
    <!-- 自定义事件，点击后销量会加增加 -->
    <product name="MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮" sale="10" ></product>
    <product v-for="item in products" v-bind:product="item"></product>	<!-- 遍历 json 数组 -->
</div>
<script>
new Vue({
  el: '#div1',
  data:{
      outName:'产品名称',
      products:[
                {"name":"MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮","sale":"18"},
                {"name":"宾度 男士手包真皮大容量手拿包牛皮个性潮男包手抓包软皮信封包","sale":"35"},
                {"name":"唯美诺新款男士手包男包真皮大容量小羊皮手拿包信封包软皮夹包潮","sale":"29"}
                ]
  },
  components:{			// 定义局部组件
      'product':{
          template:'<div class="product" >MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮</div>'
      }
  }
})
Vue.component('product', {			// 定义全局组件
      template: '<div class="product" >MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮</div>'
    })
Vue.component('product', {			// 全局组件带参数
      props:['name'],
      template: '<div class="product" >{{name}}</div>',
      // 自定义事件
      props:['name','sale'],
      template: '<div class="product" v-on:click="increaseSale">{{name}} 销量: {{sale}} </div>',
      // 遍历 json 数组
      props:['product'],
      template: '<div class="product" v-on:click="increaseSale">{{product.name}} 销量: {{product.sale}} </div>',
      methods:{			// 也可以在一个Vue对象上增加 methods，效果一样
          increaseSale:function(){
              this.sale++
          }
      }
    })
</script>
```

完整的示例

```html
<style>
div.product{
  float:left;
  border:1px solid lightGray;
  width:200px;
  margin:10px;
  cursor: pointer;
}
div.product:hover{
  border:1px solid #c40000;
}
div.price{
  color:#c40000; 
  font-weight:bold;
  font-size:1.2em;
  margin:10px;
}
div.productName{
  color:gray;
  font-size:0.8em;
  margin:10px;
}
div.sale{
  float:left; 
  width:100px;
  border:1px solid lightgray;
  border-width:1px 0px 0px 0px;
  color:gray;
  font-size:0.8em;
  padding-left:10px;
}
div.review{
  overflow:hidden;
  border:1px solid lightgray;
  border-width:1px 0px 0px 1px;
  color:gray;
  font-size:0.8em; 
  padding-left:10px;
} 
</style>
<div id="tempalate" style="display:none">
    <div class="product" v-on:click="increaseSales">
        <div class="price">
            ¥ {{product.price}}
        </div>
        <div class="productName">
            {{product.name}}
        </div>
        <div class="sale"> 月成交 {{product.sale}} 笔</div>
        <div class="review"> 评价 {{product.review}} </div>
    </div>
</div>
<div id="div1">
    <product v-for="item in products" v-bind:product="item"></product>
</div>
<script>
var tempalateDiv=document.getElementById("tempalate").innerHTML;
var templateObject = {
    props: ['product'],
    template: tempalateDiv,
      methods: {
            increaseSales: function () {
                this.product.sale = parseInt(this.product.sale);
              this.product.sale += 1
              this.$emit('increment')
            }
          }
}
Vue.component('product', templateObject)
new Vue({
  el: '#div1',
  data:{
      products:[
                {"name":"MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮","price":"889","sale":"18","review":"5"},
                {"name":"宾度 男士手包真皮大容量手拿包牛皮个性潮男包手抓包软皮信封包","price":"322","sale":"35","review":"12"},
                {"name":"唯美诺新款男士手包男包真皮大容量小羊皮手拿包信封包软皮夹包潮","price":"523","sale":"29","review":"3"},
                ]
  }
})
</script>
```

### 自定义指令

```html
<div id="div1">
    <div v-xart> 好好学习，天天向上 </div>
    <div v-xart="{color:'red',text:'best learning video'}"> 好好学习，天天向上 </div>
    <div v-xart="blue"> 好好学习，天天向上 </div>			<!-- 也可以传递一个简单的 -->
    <div v-xart:hello.a.b="message"> </div>
</div>
<script> 
Vue.directive('xart', function (el) {			// 自定义指令：文字颜色变成粉红，后面自动加上 (x-art)
    el.innerHTML = el.innerHTML + ' ( x-art ) '
    el.style.color = 'pink'
})
Vue.directive('xart', function (el,binding) {	// 带参数的自定义指令，binding.value是 v-xart=“x”的x
    el.innerHTML = el.innerHTML + '( ' + binding.value.text + ' )'
    el.style.color = binding.value.color
})
Vue.directive('xart', {
      // 只调用一次，指令第一次绑定到元素时调用，在这里可以进行一次性的初始化设置
      bind: function (el, binding, vnode) {
            var s = JSON.stringify
            el.innerHTML =
              'name: '       + s(binding.name) + '<br>' +	// 不包括 v- 前缀的指令名 xart
              'value: '      + s(binding.value) + '<br>' +	// 指令的绑定值 hello vue.js
              'expression: ' + s(binding.expression) + '<br>' +	 //字符串形式的指令表达式 message
              'argument: '   + s(binding.arg) + '<br>' +	// 传给指令的参数 hello
              'modifiers: '  + s(binding.modifiers) + '<br>' +	// 包含修饰符的对象 .a .b
              'vnode keys: ' + Object.keys(vnode).join(', ')	// ？
      },
      // 所在组件的 VNode 更新时调用，但是可能发生在其子 VNode 更新之前
      update: function (newValue, oldValue) {
        // 值更新时的工作，也会以初始值为参数调用一次
      },
      // 只调用一次，指令与元素解绑时调用
      unbind: function () {			
        // 清理工作，例如删除 bind() 添加的事件监听器
      }
    })
new Vue({
  el: '#div1'
})
</script>
```

钩子函数叫做回调函数，或者事件响应函数。 指的是，一个指令在创建过程中，经历不同生命周期的时候，vue.js 框架调用的函数 。 以 bind 为例，可以传递主要是用到 binding 里的属性， 这样拿到这些自定义指令的各项参数，那么在函数体里就方便做各种自定义功能了 。oldValue 是指令绑定的前一个值，仅在 update 和 componentUpdated 钩子中可用，无论值是否改变都可用。join() 方法用于把数组中的所有元素放入一个字符串，元素是通过指定的分隔符进行分隔的

### 路由

 vue.js 里的路由相当于就是局部刷新 

```html
<script src="http://how2j.cn/study/vue-router.min.js"></script>		<!-- 实现路由需要的库 -->
<head>
    <style>
    a{
      text-decoration: none;
    }
    a.router-link-active{
    /*   color:blue; */
      background-color: lightGray;
    }
    div.menu{
        border:1px solid gray;
        float:left;
    }
    div.menu a{
        display:block;
    }
    div.workingRoom{
        margin-left:100px;
    }
    div#app{
        width:500px;
        padding:10px;
        margin:10px auto;
    }
    </style>
</head>
<div id="app">
    <div class="menu">
        <!-- router-link 相当于就是超链，to 相当于就是 href -->
        <router-link to="/user">用户管理</router-link>
        <router-link to="/product">产品管理</router-link>
        <router-link to="/order">订单管理</router-link>
    </div>
    <div class="workingRoom">
        <!-- 点击上面的/user,那么/user对应的内容就会显示在router-view 这里 -->
         <router-view></router-view>   
    </div>
</div>
<script>
    // 申明三个模板( html 片段 )
    var user = { template: '<p>用户管理页面的内容</p>' };
    var second = { template: '<p>产品管理页面的内容</p>' };
    var order = { template: '<p>订单管理页面的内容</p>' };
    // 定义路由
    var routes = [
        { path: '/', redirect: '/user'}, 		// 这个表示会默认渲染 /user，没有这个就是空白
        { path: '/user', component: user },
        { path: '/product', component: second },
        { path: '/order', component: order }
    ];
    // 创建VueRouter实例
    var router = new VueRouter({
        routes:routes
    });
    // 给vue对象绑定路由
    new Vue({
        el:"#app",
        router
    })
</script>
```

### fetch.js 和axios.js 

fetch.js 和axios.js 都是是眼下比较流行的 ajax 框架

```html
<script src="https://how2j.cn/study/fetch.min.js"></script>
<script src="https://how2j.cn/study/axios.min.js"></script>
<div id="hero">
</div>
<script>
var url = "http://how2j.cn/study/json.txt"			// 这个不行，跨域问题？
var url = "http://static.how2j.cn/study/json.txt"			// 内容为 {"name":"gareen","hp":"355"}
fetch('json.txt').then...			// json文件存放在本地
fetch(url).then(function(response) {
    response.json().then(function (jsonObject) {
        var jsonString = JSON.stringify(jsonObject)
        document.getElementById("hero").innerHTML = "通过fetch获取到的json数据："+ jsonString;
    })
}).catch(function(err){
    console.log("Fetch错误:"+err);
})
var url = "http://static.how2j.cn/study/json.txt"
axios.get(url).then(function(response) {
    var jsonObject = response.data;
    var jsonString = JSON.stringify(jsonObject)
    document.getElementById("hero").innerHTML = "通过 axios 获取到的json数据："+ jsonString;
})
</script>
```

#### 跨域请求

可以参考 https://segmentfault.com/a/1190000015995283?utm_source=tag-newest 

###  Ajax 

```html
<div id="div1">
    <table align="center" >
        <tr class="firstLine">
            <td>name</td>
            <td>hp</td>
        </tr>
        <tr>
            <td>{{heros.name}}</td>			<!-- 获取到的不是json数组 -->
            <td>{{heros.hp}}</td>
        </tr>  
    </table>
</div>
<script>
var url = "http://static.how2j.cn/study/json.txt";
new Vue({
    el:'#div1',
    data:{
        heros:[]
    },
    mounted:function(){			// mounted　表示这个 Vue 对象加载成功了
        self=this
        // fetch.js 方式
        fetch(url).then(function(response) {
            response.json().then(function (jsonObject) {
                self.heros = jsonObject;
            })
        }).catch(function(err){
            console.log("Fetch错误:"+err);
        })
        // axios.js 方式
        axios.get(url).then(function(response) {
            self.heros= response.data;
            // self.heros = eval("("+self.heros+")"); 字符串转换为数组对象，加了会报错
        })  
    }
})
</script>
```

###  vue-cli 

vue-cli 是 vue 出来的一个脚手架，可以进行 组件式地开发。运用 vue-cli  必须要有 node.js 和 webpack 的基础。以版本3为基础， 安装时一定要跟版本号，如果不跟就是安装 vue-cli 的最新版本 

```
npm install -g @vue/cli@3.0.1			# 安装 vue-cli
vue --version			# 查看版本
npm install -g @vue/cli-service-global@3.0.1			# 安装 vue-cli 的一个原型工具
# 新建 E:\project\vue-cli\test.vue 文件
<template>
  <h1>Hello Vue-Cli</h1>
</template>

vue serve test.vue			# 运行命令
http://localhost:8081/			# 提示打开如下 URL 进行测试
```

 虽然 vue 可以通过 组件的方式重复使用很多代码，但是 \<component> 方式有一些缺陷：组件用 '' 方式写，如果比较复杂，写起来麻烦。组件里 不包含 js 和 css。修改一下 test.vue 文件， html部分放在 \<template> 标签里，提供数据部分放在 \<script> 里，样式部分放在 \<style> 里，这样就是一个可以有比较完整功能的组件了 

```html
<template>
  <p>{{greeting}}  Vue-Cli</p>
</template>
<script>
export default {
    data () {
        return {
            greeting: 'Hi'
        }
    }
}	
</script>
<style scoped>
    p{
        font-size: 2em;
        text-align:center;
        color:blue;
    }
</style>
```

#### 创建项目

```
vue create hello-world		
cd hello-world
npm run serve	
http://localhost:8081/
```

 启动一个 vue 项目， 就是启动了 vue-cli\hello-world\src\main.js  文件。 间接地加载了 App.vue，然后又间接地加载了 components/HelloWorld.vue 文件。

使用 vue-cli 开发单页应用 SPA(single page application) 的时候是很方便的，但是多页复杂系统的话用起来就比较麻烦了。并不是 vue-cli 不支持 多页系统， 而是为了让 vue-cli 支持多页系统，需要额外装很多插件和工具，用起来就相当的麻烦 

### crud

只是前端的 crud，没有与服务器交互

```html
<html>
<head>
    <script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <script src="https://how2j.cn/study/vue.min.js"></script>
    <style type="text/css">
        td{
            border:1px solid gray;
        }
        table{
            border-collapse:collapse;
        }
        div#app{
            margin:20px auto;
            width:400px;
            padding:20px;
        }       
    </style>
</head>
<body>
    <div id="app">
            <table id="heroListTable" >
                <thead>
                    <tr>
                        <th>英雄名称</th>
                        <th>血量</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="hero in heros ">			<!-- 显示 -->
                        <td>{{hero.name}}</td>
                        <td>{{hero.hp}}</td>
                        <td>
                            <a href="#nowhere" @click="edit(hero)">编辑</a>		<!-- 编辑 -->
                            <a href="#nowhere" @click="deleteHero(hero.id)">删除</a>	<!-- 删除 -->
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            英雄名称: <input type="text" v-model="hero4Add.name" /><br>
                            血量：<input type="number" v-model="hero4Add.hp" /><br>
                            <button type="button" v-on:click="add">增加</button>		<!-- 增加 -->
                         </td>                  
                    </tr>
                </tbody>
            </table>
        	<div id="div4Update">			<!-- 点击编辑弹出来的模块 -->
                英雄名称:<input type="text" v-model="hero4Update.name" /><br>
                血量：<input type="number" v-model="hero4Update.hp" />                       					   <input type="hidden"    v-model="hero4Update.id" /><br>
                <button type="button"  v-on:click="update">修改</button>                
                <button type="button"  v-on:click="cancel">取消</button>                
            </div>
    </div>
<script type="text/javascript">
    // Model
    var data = {
        heros: [
        { id: 1, name: '盖伦', hp: 318},
        { id: 2, name: '提莫', hp: 320},
        { id: 3, name: '安妮', hp: 419},
        { id: 4, name: '死歌', hp: 325},
        { id: 5, name: '米波', hp: 422},
        ],
        hero4Add: { id: 0, name: '', hp: '0'},
        hero4Update: { id: 0, name: '', hp: '0'}
    }; 
    var maxId = 5;			//用于记录最大id值
    for (var i=0;i<data.heros.length;i++){			 //计算最大值
        if (data.heros[i].id > maxId)
            maxId = this.heros[i].id;
    }  
    // ViewModel
    var vue = new Vue({
        el: '#app',
        data: data,
        methods: {
            add: function (event) {
                maxId++;
                this.hero4Add.id = maxId;			// this 指向当前 vue 示例
                if(this.hero4Add.name.length==0)			// 名称为空会以 id 形成名称
                    this.hero4Add.name = "Hero#"+this.hero4Add.id;
                this.heros.push(this.hero4Add);			// 把对象加入到数组
                this.hero4Add = { id: 0, name: '', hp: '0'}			// 让 hero4Add 指向新的对象
            }
        },
        deleteHero: function (id) {
                console.log("id"+id);
                for (var i=0;i<this.heros.length;i++){
                    if (this.heros[i].id == id) {
                        this.heros.splice(i, 1);			// 删除 i 元素
                        break;
                    }
                }
        },
        edit: function (hero) {
                $("#heroListTable").hide();			// 隐藏原来的页面
                $("#div4Update").show();			// 显示编辑页面
                // this.hero4Update = hero; 这样数据会被双向绑定，使得取消失效
                this.hero4Update.id = hero.id;
                this.hero4Update.name = hero.name;
                this.hero4Update.hp = hero.hp;
        },
        update:function(){
            // 进行数据更新
            for (var i=0;i<this.heros.length;i++){
                    if (this.heros[i].id == this.hero4Update.id) {
                    	this.heros[i].name= this.hero4Update.name;
                    	this.heros[i].hp= this.hero4Update.hp;
               		    break;
               	    }
        	}
            // 恢复显示
            $("#heroListTable").show();
            $("#div4Update").hide();          
        },
        cancel:function(){
            // 恢复显示
            $("#heroListTable").show();
            $("#div4Update").hide();
        }
    });
</script>
</body>
</html>
```