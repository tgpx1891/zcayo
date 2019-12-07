	在学习 SSM(H) 的过程中，需要做大量的配置工作，其实很多配置行为本身只是手段，并不是目的。基于这个考虑，把该简化的简化，该省略的省略，开发人员只用关心提供业务功能就行了，这就是 SpringBoot。换言之，SpringBoot可以简单地看成简化了的、按照约定开发的SSM(H) ， 开发速度大大提升。版本用的是 1.5.9.RELEASE

启动方式是启动一个 Java 类的主方法，这是因为这个 Application 类的主方法就把 tomcat 嵌入进去了，不需要手动启动 tomcat

###  创建项目 

####  关于STS插件 

 Eclipse 提供了一个专门开发 SpringBoot 的插件叫做 Spring Tool Suite. 这个插件的安装是使用国外的源，安装很卡 

![](https://stepimagewm.how2j.cn/7116.png)

#### 在 eclipse 中创建项目

-  依次点击 菜单 -> File -> New -> Other -> Maven -> Maven -> Maven Project -> New Maven Project，勾上这个 Create a simple project (skip archetype selection) 
-  接着在参数里输入数值，Group Id：com.how2java，Artifact Id：springboot，Name：springboot，Description：springboot
-  用以下 pom.xml 里面的内容覆盖掉项目里的 pom.xml，覆盖后，右键点击项目->Maven->Update Project 更新一下项目， 这个 pom.xml 就指定了当前项目需要用到的 jar 包 
-  创建主类 Application.java， 运行其主方法就会启动tomcat，默认端口是8080 。创建控制器类 HelloController， 这个类就是Spring MVC里的一个普通的控制器 
-  运行启动类 Application.java， 然后访问地址`http://127.0.0.1:8080/hello`

Application.java 和 HelloController.java 文件

```java
// Application.java
package com.how2java.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication			// 表示这是一个SpringBoot应用
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
 
}
// HelloController.java
package com.how2java.springboot.web;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController			// spring4里的新注解，是@ResponseBody和@Controller的缩写
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}
```

以下是  pom.xml 文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.how2java</groupId>
  <artifactId>springboot</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>springboot</name>
  <description>springboot</description>
  <packaging>war</packaging>			<!-- war方式，新加打包成war的声明 -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.9.RELEASE</version>
    </parent>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>			<!-- war方式，spring-boot-starter-tomcat 修改为 provided方式 -->
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>           
        </dependency>
        <dependency>
              <groupId>junit</groupId>
              <artifactId>junit</artifactId>
              <version>3.8.1</version>
              <scope>test</scope>
        </dependency>
        <!-- servlet依赖. -->
        <dependency>
              <groupId>javax.servlet</groupId>
              <artifactId>javax.servlet-api</artifactId>
        </dependency>
              <dependency>
                     <groupId>javax.servlet</groupId>
                     <artifactId>jstl</artifactId>
              </dependency>
        <!-- 对tomcat的支持.-->
        <dependency>
               <groupId>org.apache.tomcat.embed</groupId>
               <artifactId>tomcat-embed-jasper</artifactId>
        </dependency> 
        <dependency>			<!-- 热部署.-->
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional> 		<!-- 这个需要为 true 热部署才有效 -->
        </dependency>
        <!-- mysql -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.21</version>
        </dependency>
        <!-- jpa -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <!-- pagehelper -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>4.1.6</version>
        </dependency>
        <!-- sqlite -->
        <dependency>
            <groupId>org.xerial</groupId>
            <artifactId>sqlite-jdbc</artifactId>
            <scope>runtime</scope>
        </dependency>
        <!-- springboot test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <properties>
        <java.version>1.8</java.version>
    </properties>
    <build>
        <plugins>
            <plugin>			<!-- 热部署需要的插件 -->
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

#### 在 IDEA 中创建创建项目

 在 IDEA 中开发 Springboot 应用和 Eclipse 里面一样，本质上都是一个 maven 项目。 但是IDEA 本身自带对 SpringBoot支持的插件，不像 Eclipse 那样，要用插件还需要从第三方安装， 而且很缓慢 (国外插件源)

-  依次点击 菜单 -> New -> Project -> Spring Initializr，然后点 Next；
-  输入两个地方的参数，Group：com.how2java，Artifact：springboot，其他参数不用修改，然后Next ；
-  接着左边选择 Web，右边只勾选 Web 即可，然后点击Next ；
-  指定项目路径为`e:\project\springboot `(其他位置也可以)。这样项目就创建成功了，就可以看到项目结构了 。 项目创建好之后，就自带一个 SpringbootApplication ；
-  新建包 com.how2java.springboot.web， 然后在其下新建类 HelloController（同上）；
-  运行 Application.java， 然后访问地址`http://127.0.0.1:8080/hello`

#### 修改仓库下载路径

 maven 项目用到很多 jar 包，如果嫌 jar 包下载缓慢，可以修改仓库下载路径

### 部署方式

 通常来说，Springboot 部署会采用两种方式：全部打包成一个 jar，或者打包成一个 war 

####  jar 方式

```
cd e:\project\springboot 
mvn install			# 会在 target 目录下生成一个jar文件
java -jar target/springboot-0.0.1-SNAPSHOT.jar			# 运行该jar
```

 通过这种方式，把此 jar 上传到服务器并运行，就可达到部署的效果了 

#### war 方式

```java
// 修改 Application.java
package com.how2java.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
@SpringBootApplication
@ServletComponentScan
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

cd e:\project\springboot 
mvn clean package			# 会在 target 目录下生成一个war文件
```

对 pom.xml 文件新加打包成 war 的声明，spring-boot-starter-tomcat 修改为 provided方式，以避免和独立 tomcat 容器的冲突，表示 provided 只在编译和测试的时候使用，打包的时候就没它了。 把这个文件重命名为 ROOT.war，然后把它放进 tomcat 的 webapps 目录下 ， ROOT 表示根路径。运行 tomcat 下的 bin 目录里的 startup.bat，然后访问如下地址测试  `http://127.0.0.1:8080/hello`

###  使用 JSP 

对 pom.xml 文件增加对 JSP 支持，包括 servlet 依赖和 tomcat 的支持。在`src/main/resources`目录下增加 application.properties 文件，用于视图重定向jsp文件的位置。 测试地址是：http://127.0.0.1:8080/hello 

```java
// 增加 src/main/resources/application.properties 文件
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
// 修改 HelloController.java
package com.how2java.springboot.web;
import java.text.DateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller			// 把@RestController改为@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }
}
// 新建 main/webapp/WEB-INF/jsp/hello.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Hi JSP. 现在时间是  ${now}
```

### 热部署

 目前的 Springboot，当发生了任何修改之后，必须关闭后再启动 Application 类才能够生效，显得略微麻烦。 Springboot提供了热部署的方式，当发现任何类发生了改变，马上通过 JVM 类加载的方式，加载最新的类到虚拟机中。 这样就不需要重新启动也能看到修改后的效果了。 做法很简单，在 pom.xml 中新增加一个依赖和一个插件就行了。 重新启动Application，然后随便修改一下 HelloController，就会观察到控制台的自动重启现象 

### 错误处理

 修改 HelloController，使得访问 /hello 一定会产生异常：some exception。 新增加一个类 GlobalExceptionHandler，用于捕捉 Exception 异常以及其子类。捕捉到之后，把异常信息，发出异常的地址放进 ModelAndView 里，然后跳转到 errorPage.jsp。 如果配置了热部署，会自动重启。测试地址：`http://127.0.0.1:8080/hello`

```java
// 修改 HelloController.java
public String hello(Model m) throws Exception {
    m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
    if(true){
        throw new Exception("some exception");
    }
    return "hello";
}
// 增加 GlobalExceptionHandler.java
package com.how2java.springboot.exception;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("errorPage");
        return mav;
    }
}
// 增加 errorPage.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="width:500px;border:1px solid lightgray;margin:200px auto;padding:80px">
系统出现了异常，异常原因是：${exception}<br>
出现异常的地址是：${url}
</div>
```

### 配置相关

#### 设置端口和上下文路径

修改 application.properties 文件，测试地址就变成了：`http://127.0.0.1:8080/test/hello`

```properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
server.port=8888
server.context-path=/test
```

#### 配置切换

有时候在本地测试是使用 8080 端口，可是上线使用的又是 80 端口，此时就可以通过多配置文件实现多配置支持与灵活切换。 可以通过 application.properties 里的 spring.profiles.active 灵活地来切换使用哪个环境，也可以在部署环境下，指定不同的参数来确保生产环境总是使用的希望的那套配置。 这样就可以保证在开发环境总是用的 8080 端口，而到了生产环境总是用的 80 端口，免去了每次上线还要修改端口号的麻烦 

```properties
# 核心配置文件 application.properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
spring.profiles.active=pro			# 或者dev 
# 开发环境用的配置文件 application-dev.properties
server.port=8080
server.context-path=/test
# 生产环境用的配置文件 application-pro.properties
server.port=80
server.context-path=/

cd e:\project\springboot 
mvn install
java -jar target/springboot-0.0.1-SNAPSHOT.jar --spring.profiles.active=pro			
```

#### yml 文件

很多 springboot 项目会使用 yml 格式 的配置文件，它和 properties 格式的配置文件达到的效果是相同的，要么用application.properties 要么用 application.yml。需要注意：不同“等级” 用冒号隔开；次等级的前面是空格，不能使用制表符(tab)；冒号之后如果有值，那么冒号和值之间至少有一个空格，不能紧贴 

```
spring:
    mvc:
        view:
            prefix: /WEB-INF/jsp/
            suffix: .jsp
server:
    port: 8888
    context-path: /test
```

### 导入项目

####  Eclipse 导入 

- 依次点击菜单->File->Import->Maven->Existing Maven Projects 

- 粘贴 springboot 所在的目录，点一下 Refresh，下面就会跳出 pom.xml 文件

- 点 Finish，然后就是等待下载 jar 文件。 一旦下载完成，就会展现为如图所示的 maven 风格的项目结构 

  ![](https://stepimagewm.how2j.cn/8658.png)

- 运行启动类 Application.java， 然后访问地址`http://127.0.0.1:8080/hello`

####  IDEA 导入 

- 依次点击菜单->File->New->Project From Existing Sources
- 粘贴 springboot 所在的目录，选中 pom.xml 
- 点击OK，然后后面就一路 Next 就行了
- 运行启动类 Application.java， 然后访问地址`http://127.0.0.1:8080/hello`

### 持久层支持

#### JPA

JPA(Java Persistence API)是 Sun 官方提出的 Java 持久化规范，用来方便大家操作数据库。
真正干活的可能是 Hibernate，TopLink 等等实现了 JPA 规范的不同厂商，默认是 Hibernate 

首先准备数据库

```mysql
create database how2java;
use how2java;
CREATE TABLE category_ (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(30),
  PRIMARY KEY (id)
) DEFAULT CHARSET=UTF8;
insert into category_ values(null,'category 1');
insert into category_ values(null,'category 2');
insert into category_ values(null,'category 3');
insert into category_ values(null,'category 4');
```

修改 application.properties 文件， 新增数据库链接必须的参数 

```properties
# application.properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.properties.hibernate.hbm2ddl.auto=update			# 表示会自动更新表结构
```

-  对 pom.xml 文件增加对 mysql 和 jpa 的支持；
- 增加一个包`com.how2java.springboot.pojo`，然后创建实体类 Category；
- 增加一个包`com.how2java.springboot.dao`，然后创建 dao 接口 CategoryDAO，继承了 JpaRepository，并且提供泛型`<Category,Integer>`，表示这个是针对 Category 类的 DAO，Integer 表示主键是Integer类型。JpaRepository 这个父接口，就提供了 CRUD，分页等，直接可以拿来用；
-  增加一个包`com.how2java.springboot.web`，然后创建 CategoryController 类；
-  创建 listCategory 文件，用 jstl 遍历从 CategoryController 传递过来的集合
-  因为在 pom.xml 中增加了 jar 包的依赖，所以仅仅通过 Springboot 本身的热部署是无法起作用的，得手动重启一下，然后访问测试地址 `http://127.0.0.1:8080/listCategory `

```java
// Category.java
package com.how2java.springboot.pojo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity			// 表示这是个实体类
@Table(name = "category_")			// 表示这个类对应的表名是 category_
public class Category {
    @Id			// 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)			// 自增长方式
    @Column(name = "id")			// 对应的数据库字段名
    private int id;
    @Column(name = "name")
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }
}
// CategoryDAO.java
package com.how2java.springboot.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.how2java.springboot.pojo.Category;
public interface CategoryDAO extends JpaRepository<Category,Integer>{
}
// CategoryController.java
package com.how2java.springboot.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
@Controller
public class CategoryController {
    @Autowired CategoryDAO categoryDAO;
    @RequestMapping("/listCategory")
    public String listCategory(Model m) throws Exception {
        List<Category> cs = categoryDAO.findAll();    
        m.addAttribute("cs", cs);   
        return "listCategory";
    }
}
// listCategory.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>    
        </tr>
    </c:forEach>
</table>
```

####  CRUD 和分页

-  为 CategoryController 添加： 增加、删除、获取、修改映射，JPA 新增和修改用的都是 save. 它根据实体类的 id 是否为0来判断是进行增加还是修改，然后修改查询映射
-  修改 查询页面 listCategory.jsp，通过 page.getContent 遍历当前页面的 Category 对象，会返回一个泛型是Category的集合。通过 page.number 获取当前页面，page.totalPages 获取总页面数
-  增加编辑分类的页面 editCategory.jsp
-  重启后访问测试地址`http://127.0.0.1:8080/listCategory?start=1`

```java
// 修改 CategoryController
package com.how2java.springboot.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
@Controller
public class CategoryController {
    @Autowired CategoryDAO categoryDAO;
    @RequestMapping("/listCategory")
    // 在参数里接受 当前是第几页 start ，和每页显示多少条数据 size，默认值分别是 0 和 5
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;			// 防止在当前是首页，并点击了上一页的时候
        Sort sort = new Sort(Sort.Direction.DESC, "id");			// 设置倒排序
        Pageable pageable = new PageRequest(start, size, sort);	 // 根据start,size和sort创建分页对象
        Page<Category> page =categoryDAO.findAll(pageable);			// 根据这个对象获取结果 page
        System.out.println(page.getNumber());			// 获取当前页面号
        System.out.println(page.getNumberOfElements());			// 返回当前页上的元素数
        System.out.println(page.getSize());			// 返回当前页面的大小
        System.out.println(page.getTotalElements());			// 返回元素总数
        System.out.println(page.getTotalPages());			// 获取总页面数
        m.addAttribute("page", page);			// 把page放在"page"属性里，跳转到listCategory.jsp   
        return "listCategory";
    }
    @RequestMapping("/addCategory")
    public String addCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception {
        categoryDAO.delete(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/editCategory")
    public String ediitCategory(int id,Model m) throws Exception {
        Category c= categoryDAO.getOne(id);
        m.addAttribute("c", c);
        return "editCategory";
    }
}
// 修改 listCategory.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<div align="center">
</div>
<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.content}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="editCategory?id=${c.id}">编辑</a></td>
                <td><a href="deleteCategory?id=${c.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div>
            <a href="?start=0">[首  页]</a>
            <a href="?start=${page.number-1}">[上一页]</a>
            <a href="?start=${page.number+1}">[下一页]</a>
            <a href="?start=${page.totalPages-1}">[末  页]</a>
    </div>
    <br>
    <form action="addCategory" method="post">
    name: <input name="name"> <br>
    <button type="submit">提交</button>
    </form>
</div>
// editCategory.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>
<div style="margin:0px auto; width:500px">
<form action="updateCategory" method="post">
name: <input name="name" value="${c.name}"> <br>
<input name="id" type="hidden" value="${c.id}">
<button type="submit">提交</button>
</form>
</div>
```



#### Mybatis 注解方式

增加一个包`com.how2java.springboot.mapper`，然后创建接口 CategoryMapper。 手动重启一下，然后访问测试地址 `http://127.0.0.1:8080/listCategory `

```java
// 修改 Category.java
package com.how2java.springboot.pojo;
public class Category {
    private int id;
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }   
}
// CategoryMapper.java
package com.how2java.springboot.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.how2java.springboot.pojo.Category;
@Mapper			// 表示这是一个Mybatis Mapper接口
public interface CategoryMapper {
    @Select("select * from category_ ")			// 表示调用 findAll 方法会去执行对应的 sql 语句
    List<Category> findAll();
}
```

#### Mybatis xml 方式

- 修改了 CategoryMapper.java，去掉 @Select 注解
- 在 CategoryMapper.java 同级目录下新增加 Category.xml 文件
-  修改application.properties， 指明从哪里去找xml配置文件，同时指定别名 
-  重启后访问测试地址`http://127.0.0.1:8080/listCategor`

```java
// 增加 Category.xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.how2java.springboot.mapper.CategoryMapper">
        <select id="findAll" resultType="Category">
            select * from category_
        </select>   
    </mapper>
// 修改 application.properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
mybatis.mapper-locations=classpath:com/how2java/springboot/mapper/*.xml
mybatis.type-aliases-package=com.how2java.springboot.pojo
```

#### Mybatis CRUD 和分页

- 对 pom.xml 增加对 PageHelper 的支持；
- 新增加一个包`com.how2java.springboot.config`， 然后添加一个类 PageHelperConfig；
- 修改 CategoryMapper，增加 CRUD 方法的支持，就是调用不同的SQL语句；
- 为 CategoryController 添加： 增加、删除、获取、修改映射，修改查询映射；
- 修改 listCategory.jsp，通过 page.getList 遍历当前页面的 Category 对象，会返回一个泛型是 Category 的集合。在分页的时候通过 page.pageNum 获取当前页面，page.pages 获取总页面数；
- 重启后访问测试地址`http://127.0.0.1:8080/listCategory?start=2`

```java
// PageHelperConfig.java
package com.how2java.springboot.config;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.pagehelper.PageHelper;
@Configuration			// 表示这个类是用来做配置的
public class PageHelperConfig {
    @Bean			// 表示启动PageHelper这个拦截器
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");   // 将RowBounds第一个参数offset当成pageNum页码使用
        p.setProperty("rowBoundsWithCount", "true");			// 使用RowBounds分页会进行count查询
        // 启用合理化，如果 pageNum<1 会查询第一页，如果 pageNum>pages 会查询最后一页
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
// package com.how2java.springboot.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.how2java.springboot.pojo.Category;
@Mapper
public interface CategoryMapper {
    @Select("select * from category_ ")
    List<Category> findAll(); 
    @Insert(" insert into category_ ( name ) values (#{name}) ")
    public int save(Category category); 
    @Delete(" delete from category_ where id= #{id} ")
    public void delete(int id);   
    @Select("select * from category_ where id= #{id} ")
    public Category get(int id);
    @Update("update category_ set name=#{name} where id=#{id} ")
    public int update(Category category); 
}
// 修改 CategoryController.java
package com.how2java.springboot.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.CategoryMapper;
import com.how2java.springboot.pojo.Category; 
@Controller
public class CategoryController {
    @Autowired CategoryMapper categoryMapper; 
    @RequestMapping("/addCategory")
    public String listCategory(Category c) throws Exception {
        categoryMapper.save(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception {
        categoryMapper.delete(c.getId());
        return "redirect:listCategory";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
        categoryMapper.update(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/editCategory")
    public String listCategory(int id,Model m) throws Exception {
        Category c= categoryMapper.get(id);
        m.addAttribute("c", c);
        return "editCategory";
    }
    @RequestMapping("/listCategory")
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");		// 根据start,size进行分页，并且设置 id 倒排序
        List<Category> cs=categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(cs);
        m.addAttribute("page", page);        
        return "listCategory";
    }
}
// 修改 listCategory.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<div align="center">
</div>
<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="editCategory?id=${c.id}">编辑</a></td>
                <td><a href="deleteCategory?id=${c.id}">删除</a></td>
            </tr>
        </c:forEach> 
    </table>
    <br>
    <div>
            <a href="?start=1">[首  页]</a>
            <a href="?start=${page.pageNum-1}">[上一页]</a>
            <a href="?start=${page.pageNum+1}">[下一页]</a>
            <a href="?start=${page.pages}">[末  页]</a>
    </div>
    <br>
    <form action="addCategory" method="post">
    name: <input name="name"> <br>
    <button type="submit">提交</button>
    </form>
</div>
```

#### SQLite

SQLite 是一种数据库，它是跑在 JVM里面的，所以不需要像 mysql 那样得独立安装配置，而是直接拿来就用。因为是使用 JPA 来链接 SQlite, 而 JPA 默认用的是 Hibernate，所以要为 Hibernate 配置专门的方言

- 增加 SQLiteDialect.java，SQLiteDialectIdentityColumnSupport.java，SQLiteMetadataBuilderInitializer.java 
- 对 pom.xml 增加 sqlite jar 包
- 重启后访问测试地址`http://127.0.0.1:8080/listCategory`

```java
// SQLiteDialect.java，存放在 E:\file\html？
// SQLiteDialectIdentityColumnSupport.java
package com.how2java.sqlite;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
public class SQLiteDialectIdentityColumnSupport extends IdentityColumnSupportImpl {
    public SQLiteDialectIdentityColumnSupport(Dialect dialect) {
        super(dialect);
    }
    @Override
    public boolean supportsIdentityColumns() {
        return true;
    }
    @Override
    public boolean hasDataTypeInIdentityColumn() {
        return false;
    }
    @Override
    public String getIdentitySelectString(String table, String column, int type) {
        return "select last_insert_rowid()";
    }
    @Override
    public String getIdentityColumnString(int type) {
        return "integer";
    }
}
// SQLiteMetadataBuilderInitializer.java
package com.how2java.sqlite;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.spi.MetadataBuilderInitializer;
import org.hibernate.engine.jdbc.dialect.internal.DialectResolverSet;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolver;
import org.jboss.logging.Logger;
public class SQLiteMetadataBuilderInitializer implements MetadataBuilderInitializer {
    private final static Logger logger = Logger.getLogger(SQLiteMetadataBuilderInitializer.class);
    @Override
    public void contribute(MetadataBuilder metadataBuilder, StandardServiceRegistry serviceRegistry) {
        DialectResolver dialectResolver = serviceRegistry.getService(DialectResolver.class);
  
        if (!(dialectResolver instanceof DialectResolverSet)) {
            logger.warnf("DialectResolver '%s' is not an instance of DialectResolverSet, not registering SQLiteDialect",
                    dialectResolver);
            return;
        }
        ((DialectResolverSet) dialectResolver).addResolver(resolver);
    }
    static private final SQLiteDialect dialect = new SQLiteDialect();
    static private final DialectResolver resolver = (DialectResolver) info -> {
        if (info.getDatabaseName().equals("SQLite")) {
            return dialect;
        }
        return null;
    };
}
// 修改 application.properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
 
spring.jpa.database-platform=com.how2java.sqlite.SQLiteDialect
# 表结构由 hibernate 根据实体类来帮你创建
spring.jpa.generate-ddl=true
# 自动根据Entity配置创建表
spring.jpa.hibernate.ddl-auto=update
# 数据库文件位置
spring.datasource.url=jdbc:sqlite:how2j.db
# 驱动名称
spring.datasource.driver-class-name=org.sqlite.JDBC
```

#### JPA 条件查询

本知识点建立在单元测试知识点基础上。JPA 条件查询方式很有意思，是不需要写 SQL 语句的，只需要在 dao 接口里按照规范的命名定义对应的方法名，通过反射获取自定义的接口方法里提供的信息，就知道用户希望根据什么条件来查询了。 然后 JPA 底层再偷偷摸摸地拼装对应的 sql 语句，丢给数据库，就达到了条件查询的效果

```java
// 修改 CategoryDAO.java
package com.how2java.springboot.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.how2java.springboot.pojo.Category;
public interface CategoryDAO extends JpaRepository<Category,Integer>{
    public List<Category> findByName(String name);
    public List<Category> findByNameLikeAndIdGreaterThanOrderByNameAsc(String name, int id);
}
// TestJPA.java
package com.how2java.springboot.test;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.how2java.springboot.Application;
import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestJPA {
    @Autowired CategoryDAO dao;
    @Before			// 把 Category 表里所有数据都删除了，并新增了10条
    public void before() {
        List<Category> cs=  dao.findAll();
        for (Category c : cs) {
            dao.delete(c);
        }
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setName("category " + i);
            dao.save(c);
        }
    }
    @Test
    public void test1() {			// 查询所有数据
        List<Category> cs=  dao.findAll();
        System.out.println("所有的分类信息：");
        for (Category c : cs) {
            System.out.println(c.getName());
        }
        System.out.println();
    } 
    @Test
    public void test2() {			// 根据 name 查询分类表
        System.out.println("查询名称是 \"category 1 \"的分类:");
        List<Category> cs=  dao.findByName("category 1");
        for (Category c : cs) {
            System.out.println("c.getName():"+ c.getName());
        }
        System.out.println();
    }
    @Test
    public void test3() {			// 根据名称模糊查询，id 大于某值, 并且名称正排序查询
        System.out.println("根据名称模糊查询，id 大于5, 并且名称正排序查询");
        List<Category> cs=  dao.findByNameLikeAndIdGreaterThanOrderByNameAsc("%3%",5);
        for (Category c : cs) {
            System.out.println(c);
        }
        System.out.println();  
    }
}
```

##### 条件查询规范

| 关键词            | 举例                                                      | 生成的JPQL 语句片段                                          |
| ----------------- | --------------------------------------------------------- | ------------------------------------------------------------ |
| And               | findByLastnameAndFirstname                                | … where x.lastname = ?1 and x.firstname = ?2                 |
| Or                | findByLastnameOrFirstname                                 | … where x.lastname = ?1 or x.firstname = ?2                  |
| Is,Equals         | findByFirstname, findByFirstnameIs, findByFirstnameEquals | … where x.firstname = ?1                                     |
| Between           | findByStartDateBetween                                    | … where x.startDate between ?1 and ?2                        |
| LessThan          | findByAgeLessThan                                         | … where x.age < ?1                                           |
| LessThanEqual     | findByAgeLessThanEqual                                    | … where x.age ⇐ ?1                                           |
| GreaterThan       | findByAgeGreaterThan                                      | … where x.age > ?1                                           |
| GreaterThanEqual  | findByAgeGreaterThanEqual                                 | … where x.age >= ?1                                          |
| After             | findByStartDateAfter                                      | … where x.startDate > ?1                                     |
| Before            | findByStartDateBefore                                     | … where x.startDate < ?1                                     |
| IsNull            | findByAgeIsNull                                           | … where x.age is null                                        |
| IsNotNull,NotNull | findByAge(Is)NotNull                                      | … where x.age not null                                       |
| Like              | findByFirstnameLike                                       | … where x.firstname like ?1                                  |
| NotLike           | findByFirstnameNotLike                                    | … where x.firstname not like ?1                              |
| StartingWith      | findByFirstnameStartingWith                               | … where x.firstname like ?1 (parameter bound with appended %) |
| EndingWith        | findByFirstnameEndingWith                                 | … where x.firstname like ?1 (parameter bound with prepended %) |
| Containing        | findByFirstnameContaining                                 | … where x.firstname like ?1 (parameter bound wrapped in %)   |
| OrderBy           | findByAgeOrderByLastnameDesc                              | … where x.age = ?1 order by x.lastname desc                  |
| Not               | findByLastnameNot                                         | … where x.lastname <> ?1                                     |
| In                | findByAgeIn(Collection ages)                              | … where x.age in ?1                                          |
| NotIn             | findByAgeNotIn(Collection age)                            | … where x.age not in ?1                                      |
| True              | findByActiveTrue()                                        | … where x.active = true                                      |
| False             | findByActiveFalse()                                       | … where x.active = false                                     |
| IgnoreCase        | findByFirstnameIgnoreCase                                 | … where UPPER(x.firstame) = UPPER(?1)                        |

### 单元测试

对 pom.xml 修改junit 版本为 4.12，增加 spring-boot-starter-test。编写测试类如下，运行的时候选择 JUnit Test 方式，就可以在控制台看到结果了

```java
package com.how2java.springboot.test
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.how2java.springboot.Application;
import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestJPA {
    @Autowired CategoryDAO dao;
    @Test
    public void test() {
        List<Category> cs=  dao.findAll();
        for (Category c : cs) {
            System.out.println("c.getName():"+ c.getName());
        }  
    }
}
```

