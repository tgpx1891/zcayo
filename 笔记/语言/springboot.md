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
        <!-- thymeleaf -->
        <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <!-- thymeleaf legacyhtml5 模式支持 -->      
        <dependency>
            <groupId>net.sourceforge.nekohtml</groupId>
            <artifactId>nekohtml</artifactId>
            <version>1.9.22</version>
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
        <!-- redis -->       
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        <!-- mybatis -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.1.1</version>
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

- 对 pom.xml 文件增加对 JSP 支持，包括 servlet 依赖和 tomcat 的支持；
- 在`src/main/resources`目录下增加 application.properties 文件，用于视图重定向jsp文件的位置；
- 在`main/webapp/WEB-INF/jsp`目录下新建 hello.jsp；
- 测试地址是：http://127.0.0.1:8080/hello 

```java
// 增加 application.properties 
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

### 上传文件

- 在 jsp 目录下新建 uploadPage.jsp，enctype="multipart/form-data" 是必须的，表示提交二进制文件。accept="image/*" 表示只选择图片；
- 因为 uploadPage.jsp 在 WEB-INF下，不能直接从浏览器访问，要在 UploadController 中加一个 uploadPage 跳转。为 UploadController 新增 upload 用来接受上传；
- 修改 application.properties，设置上传文件的大小，默认是1m；
- 在 jsp 目录下新建 showImg.jsp 用来显示上传成功后的图片；
- 访问测试地址`http://127.0.0.1:8080/uploadPage`；

```java
// uploadPage.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="upload" method="post" enctype="multipart/form-data">
  选择图片:<input type="file" name="file" accept="image/*" /> <br>
  <input type="submit" value="上传">
</form>
// UploadController.java
package com.how2java.springboot.web;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class UploadController {
    @RequestMapping("/uploadPage")
    public String uploadPage() {
        return "uploadPage";
    }    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest req, @RequestParam("file") MultipartFile file,Model m) {
            try {
                //  根据时间戳创建新的文件名
                String fileName = System.currentTimeMillis()+file.getOriginalFilename();
                // 获取当前项目的真实路径，然后拼接前面的文件名
String destFileName=req.getServletContext().getRealPath("")+"uploaded"+File.separator+fileName;    
                File destFile = new File(destFileName);
                destFile.getParentFile().mkdirs();			// 创建目录
                file.transferTo(destFile);			// 把浏览器上传的文件复制到希望的位置
                m.addAttribute("fileName",fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }   
            return "showImg";
    }   
}
// 修改 application.properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
spring.http.multipart.maxFileSize=100Mb
spring.http.multipart.maxRequestSize=100Mb
// showImg.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<img src="/uploaded/${fileName}">
```



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
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" }) 
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
// 修改 CategoryMapper.java
package com.how2java.springboot.mapper;
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

#### RESTFUL 风格

在做 Web 开发的过程中，method 常用的值是 get 和 post，但是 method值 还可以是 put 和 delete 等其它值。可以考虑使用同一个url，但是约定不同的 method 来实施不同的业务。

| 传统风格 | Restful风格                     |        |                 |        |
| -------- | ------------------------------- | ------ | --------------- | ------ |
|          | url                             | method | url             | method |
| 增加     | /addCategory?name=xxx           | POST   | /categories     | POST   |
| 删除     | /deleteCategory?id=123          | GET    | /categories/123 | DELETE |
| 修改     | /updateCategory?id=123&name=yyy | POST   | /categories/123 | PUT    |
| 获取     | /getCategory?id=123             | GET    | /categories/123 | GET    |
| 查询     | /listCategory                   | GET    | /categories     | GET    |

- 修改 listCategory.jsp，增加的 action 修改为"categories"，删除的 url 修改为 categories/id，点击超链后，会使用 form提交，并且提交_method的值为delete；
- 修改 editCategory.jsp，action 修改为了 categories/id。form 下增加 filed, 虽然这个 form 的 method 是 post, 但是springmvc 看到这个_method 的值是 put 后，会把其修改为 put；
- 修改 CategoryController，CRUD 的 RequestMapping 都修改为了/categories；
- 访问测试地址`http://127.0.0.1:8080/categories`

```java
// 修改 listCategory.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="https://how2j.cn/study/jquery.min.js"></script>
    <script type="text/javascript">
       // 将 post method 改变为 delete 
      $(function(){                    
           $(".delete").click(function(){
               var href=$(this).attr("href");
               $("#formdelete").attr("action",href).submit();
               return false;
           })
       })
   </script>    
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
                <td><a href="categories/${c.id}">编辑</a></td>
                <td><a class="delete" href="categories/${c.id}">删除</a></td>
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
    <form action="categories" method="post">
    name: <input name="name"> <br>
    <button type="submit">提交</button>   
    </form>
    <form id="formdelete" action="" method="POST" >
       <input type="hidden" name="_method" value="DELETE">
   </form>
</div>
// 修改 editCategory.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>
<div style="margin:0px auto; width:500px">
<form action="../categories/${c.id}" method="post">			// 关于 .. ？
        <input type="hidden" name="_method" value="PUT">
name: <input name="name" value="${c.name}"> <br>
<button type="submit">提交</button>
</form>
</div>
// 修改 CategoryController.java
package com.how2java.springboot.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
@Controller
public class CategoryController {
    @Autowired CategoryDAO categoryDAO;
    @GetMapping("/categories")
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page =categoryDAO.findAll(pageable);
        m.addAttribute("page", page);
        return "listCategory";
    }
    @PostMapping("/categories")
    public String addCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:/categories";
    }
    @DeleteMapping("/categories/{id}")
    public String deleteCategory(Category c) throws Exception {
        categoryDAO.delete(c);
        return "redirect:/categories";
    }
    @PutMapping("/categories/{id}")
    public String updateCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:/categories";
    }
    @GetMapping("/categories/{id}")
    public String getCategory(@PathVariable("id") int id,Model m) throws Exception {
        Category c= categoryDAO.getOne(id);
        m.addAttribute("c", c);
        return "editCategory";
    }
}
```

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

### JSON

基于 Restful 风格

- 修改 Category.java，增加注解 @JsonIgnoreProperties；
- 修改 CategoryController，控制器里提供3个方法，分别用来处理 json 提交，json 获取单个对象，json 获取多个对象；
- 增加提交页面 submit.html、获取单个对象页面 getOne.html 和获取多个对象页面 getMany.html；
- 访问测试地址`http://localhost:8080/submit.html`，提交成功后，在 springboot 控制台查看使用 json 方式提交的数据。不要在 eclipse 自带的浏览器里面点击，自带的浏览器有 bug，有时候不能识别 jquery, 会导致点击没有反应。 使用独立的浏览器，比如 chrome，firefox 点击测试；
- 访问测试地址`http://localhost:8080/getOne.html`，`http://localhost:8080/getMany.html`

```java
// 修改 CategoryController
package com.how2java.springboot.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
@RestController
public class CategoryController {
    @Autowired CategoryDAO categoryDAO;
    @GetMapping("/category")
    public List<Category> listCategory(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page =categoryDAO.findAll(pageable);
        return page.getContent();
    }
    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id") int id) throws Exception {
        Category c= categoryDAO.getOne(id);
        System.out.println(c);
        return c;
    }
    @PutMapping("/category")
    public void addCategory(@RequestBody Category category) throws Exception {
        System.out.println("springboot接受到浏览器以JSON格式提交的数据："+category);
    }
}
// submit.html
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用AJAX以JSON方式提交数据</title>
<script type="text/javascript" src="https://how2j.cn/study/jquery.min.js"></script>
</head>
<body>
    <form >
       id：<input type="text" id="id" value="123" /><br/>
       名称：<input type="text" id="name" value="category xxx"/><br/>
        <input type="button" value="提交" id="sender"> 
    </form>
    <div id="messageDiv"></div>   
    <script>
    $('#sender').click(function(){
        var id=document.getElementById('id').value;
        var name=document.getElementById('name').value;
        var category={"name":name,"id":id};
        var jsonData = JSON.stringify(category);
        var page="category";  
        $.ajax({
               type:"put",
               url: page,
               data:jsonData,
               dataType:"json",
               contentType : "application/json;charset=UTF-8",
               success: function(result){
               }
            });
           alert("提交成功，请在springboot控制台查看服务端接收到的数据");
    });
    </script>
</body>
</html>
// getOne.html
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用AJAX以JSON方式获取数据</title>
<script type="text/javascript" src="https://how2j.cn/study/jquery.min.js"></script>
</head>
<body>
    <input type="button" value="通过AJAX获取一个Hero对象" id="sender">    
    <div id="messageDiv"></div>  
    <script>
    $('#sender').click(function(){
        var url="category/10";
        $.get(
                url,
                function(data) {
                    console.log(data);
                     var json=data;
                     var name =json.name;
                     var id = json.id;
                     $("#messageDiv").html("分类id："+ id + "<br>分类名称:" +name );             
         }); 
    });
    </script>
</body> 
</body>
</html>
// getMany.html
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用AJAX以JSON方式获取数据</title>
<script type="text/javascript" src="https://how2j.cn/study/jquery.min.js"></script>
</head>
<body>
    <input type="button" value="通过AJAX获取多个分类对象" id="sender"> 
    <div id="messageDiv"></div>  
    <script>
    $('#sender').click(function(){
        var url="category?start=0&size=100";
        $.get(
                url,
                function(data) {
                    var categorys = data;
                     for(i in categorys){
                         var old = $("#messageDiv").html();
                         var category = categorys[i];
                         $("#messageDiv").html(old + "<br>" + category.id + "——"+category.name);
                     }
         }); 
    });
    </script>
</body>    
</body>
</html>
```

### Redis

Redis 是一套 key-value 高性能数据库，先把 Redis 服务器先跑起来

- 对 pom.xml 增加对 Redis 支持的包；
- 修改 application.properties，增加 redis 相关配置，同时让hibernate的sql语句显示出来，这样才知道到底是通过 Redis 取到的数据，还是依然是从数据库取到的数据；
- 修改 Application 类，增加 @EnableCaching 注解，以开启缓存；
- 在`com.how2java.springboot.config`包下添加 Redis 缓存配置类 RedisConfig.java，让保存到 Redis 里的 key 和 value 都转换为可读的 json 格式，否则会是二进制格式，通过 RedisClient 工具也无法识别
- 创建一个工具类 Page4Navigator 用以替换原本分页查询要返回的 org.springframework.data.domain.Page 类。 原因是 Page 类对 json 还原不支持，在放入 Redis 之后，再拿出来，就会报错失败。使用 Page4Navigator 对其包裹，就解决了这个问题了。文件存放在`E:\file\html`目录下；
- 增加 CategoryService接口，注意 list 返回的是 Page4Navigator 而不是 Page 类型；
- 增加实现类 CategoryServiceImp
  -  list 方法：@Cacheable(key="'category '+#p0.offset + '-' + #p0.pageSize ")，假如是第一页，即 offset=0，pageSize=5，那么会创建一个 key: "category 0-5"。首先根据这个 key 到 redis 中查询数据。 第一次是不会有数据的，那么就会从数据库中取到这5条数据，然后以这个 key: "category 0-5" 保存到 redis 数据库中。下一次再次访问的时候，根据这个 key，就可以从 redis 里取到数据了；
  - get 方法：@Cacheable(key="'category '+ #p0")，假如是获取id=71的数据，那么就会以 key= "category 71" 到reids中去获取，如果没有就会从数据库中拿到，然后再以 key= "category 71" 这个值存放到 redis 当中。下一次再次访问的时候，根据这个 key，就可以从 redis 里取到数据了；
  - add 方法：@CacheEvict(allEntries=true)，注释掉 @CachePut(key="'category '+ #p0")。在增加数据之后，就会在Redis 中以 key= "category 71" 缓存一条数据，而 list 对应的数据为 key: "category 0-5"，在缓存在对应的数据，并没有发生变化。如果用这种方式，就会导致数据不同步；
  - delete 方法：和 add 方法同理
- 修改 CategoryController，由原来直接从 dao 获取，变为从 Service 获取了；
- 启动后，访问测试地址`http://127.0.0.1:8080/listCategory`

```java
// 修改 application.properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.properties.hibernate.hbm2ddl.auto=update
###########################redis#########################
#Redis数据库索引（默认为0）
spring.redis.database=0
#Redis服务器地址
spring.redis.host=127.0.0.1
#Redis服务器连接端口
spring.redis.port=6379
#Redis服务器连接密码（默认为空）
spring.redis.password=
#连接池最大连接数（使用负值表示没有限制）
spring.redis.pool.max-active=10
#连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.pool.max-wait=-1
#连接池中的最大空闲连接
spring.redis.pool.max-idle=8
#连接池中的最小空闲连接
spring.redis.pool.min-idle=0
#连接超时时间（毫秒）
spring.redis.timeout=0
    
spring.jpa.show-sql=true
// 修改 Application.java
package com.how2java.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@SpringBootApplication
@EnableCaching
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
  
}
// RedisConfig.java
package com.how2java.springboot.config;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.PUBLIC_ONLY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);       
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);         
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }
}
// CategoryService.java
package com.how2java.springboot.service;
import org.springframework.data.domain.Pageable;
import com.how2java.springboot.pojo.Category;
import com.how2java.springboot.util.Page4Navigator; 
public interface CategoryService {
    public Page4Navigator<Category> list(Pageable pageable);
    public void save(Category category);
    public void delete(int id);  
    public Category get(int id);
}
// 
package com.how2java.springboot.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
import com.how2java.springboot.service.CategoryService;
import com.how2java.springboot.util.Page4Navigator;
@Service
@CacheConfig(cacheNames="category")			// 表示在 redis 中分类数据都放在 category 这个分组里
public class CategoryServiceImpl implements CategoryService{
    @Autowired CategoryDAO categoryDAO;
    @Override
    @Cacheable(key="'category '+#p0.offset + '-' + #p0.pageSize ")
    public Page4Navigator<Category> list(Pageable pageable) {
        Page<Category> pageFromJPA=  categoryDAO.findAll(pageable);
        Page4Navigator<Category> page = new Page4Navigator<>(pageFromJPA,5);
        return page;
    }
    @Override
    @Cacheable(key="'category '+ #p0")
    public Category get(int id) {
        Category c =categoryDAO.findOne(id);
        return c;
    }  
    @Override
    @CacheEvict(allEntries=true)		// 表示清除掉当前分组下的缓存，例如category分组下所有的keys
	//  @CachePut(key="'category '+ #p0")
    public void save(Category category) {
        // TODO Auto-generated method stub
        categoryDAO.save(category);
    }
    @Override
    @CacheEvict(allEntries=true)
	//  @CacheEvict(key="'category '+ #p0")
    public void delete(int id) {
        // TODO Auto-generated method stub
        categoryDAO.delete(id);
    }
 
}
// 修改 CategoryController.java
package com.how2java.springboot.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam; 
import com.how2java.springboot.pojo.Category;
import com.how2java.springboot.service.CategoryService;
import com.how2java.springboot.util.Page4Navigator; 
@Controller
public class CategoryController {
    @Autowired CategoryService categoryService; 
    @RequestMapping("/listCategory") 
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page4Navigator<Category> page =categoryService.list(pageable);
        m.addAttribute("page", page);
        return "listCategory";
    }
    @RequestMapping("/addCategory")
    public String addCategory(Category c) throws Exception {
        categoryService.save(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception {
        categoryService.delete(c.getId());
        return "redirect:listCategory";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
        categoryService.save(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/editCategory")
    public String ediitCategory(int id,Model m) throws Exception {
        Category c= categoryService.get(id);
        m.addAttribute("c", c);
        return "editCategory";
    }
}
```

### ElasticSearch

springboot 有一个 spring data 组件，可以用来连接各种数据源，用来连接 elasticsearch 的是 spring-data-elasticsearch。但是 spring-data-elasticsearch 更新比较慢，其最高版本无法支持教程里的 elasticsearch的6.x 版本，所以 elasticsearch 的版本换成了 2.4.2，kibana 版本，也换成了能够连接 elasticsearch 2.4.2 的 4.6.3 版本。基于 JPA

- 先运行 elasticsearch.bat 启动 elasticsearch 2.4.2，启动后，可以看到左上角的版本号；
- 修改 Category.java，@Document 就表明了要连接到 ElasticSearch 的哪个索引和哪个 type 上，索引相当于就是数据库，type 相当于就是表；
- 修改 application.properties，配置 elastic 链接地址为 127.0.0.1:9300；
- 重启后访问测试地址`http://127.0.0.1:8080/listCategory`；
- 点击 kibana.bat 启动 kibana 并访问`http://127.0.0.1:5601`；
- 刚开始是没有选定索引的，所以要自己指定索引。把默认勾选的 Index contians time-based evens 去掉，输入 how2java 后点击 Create 按钮；
- 后点击上面的 Discover，就可以看到左边是当前的索引 how2java.，右边就是数据了

```java
// Category.java
package com.how2java.springboot.pojo;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "how2java",type = "category")
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
// 修改
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
server.port=8080
spring.data.elasticsearch.cluster-nodes = 127.0.0.1:9300
```

### Thymeleaf 

thymeleaf 跟 JSP 一样，就是运行之后，就得到纯 HTML了。 区别在与，不运行之前， thymeleaf 也是 纯 html，所以 thymeleaf 不需要 服务端的支持，就能够被以 html 的方式打开，这样就方便前端人员独立设计与调试。而 jsp 就不行了， 不启动服务器 jsp 都没法运行出结果来。 基于前面的 springboot 配置切换的基础上展开

- 修改 pom.xml,，增加了对 thymeleaf 的支持；
- 修改 HelloController， 在 resources 下新建目录 templates, 然后新建文件 hello.html。 并不是在 webapp 下，这点和 jsp 不一样.。字符串拼写有两种方式，一种是用加号，一种是在前后放上 ||；
- 修改 application.properties，LEGACYHTML5 表示使用传统模式，比起 HTML5 来对 html的校验更宽松点。重启后访问地址`http://127.0.0.1:8080/thymeleaf/hello`

```java
// 修改 HelloController.java
package com.how2java.springboot.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("name", "thymeleaf");
        return "hello";
    }
}
// hello.html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">			// 声明当前文件是 thymeleaf, 里面可以用th开头的属性
<head>
    <title>hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p th:text="${name}" >name</p>			// ognl 表达式，替换 name。没获取服务端的值时显示 name
<p th:text="'Hello！ ' + ${name} + '!'" >hello world</p>
<p th:text="|Hello！ ${name}!|" >hello world</p>
</body>
</html>
// 修改 application.properties
#thymeleaf 配置
spring.thymeleaf.mode=HTML5			
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.content-type=text/html
#缓存设置为false, 这样修改之后马上生效，便于调试
spring.thymeleaf.cache=false
#上下文
server.context-path=/thymeleaf
```

- 在 webapp 目录下新建 css 目录，然后新建 style.css 文件，新建 js 目录，然后新建 thymeleaf.js 文件；
- 修改 hello.html，通过 th:href 和 th:src 引入 css 和 js 文件，使用浏览器直接打开当前的 hello.html 依然可以看到 css 和 js 效果，因为 href 和 src 代码起作用
- 重启后访问地址`http://127.0.0.1:8080/thymeleaf/hello`

```java
// style.css
div.showing{
    width:80%;
    margin:20px auto;
    border:1px solid grey;
    padding:30px;
} 
.even{
    background-color: red; 
}
.odd{
    background-color: green;
}
// thymeleaf.js
function testFunction(){
    alert("test Thymeleaf.js!");
}
// 修改 hello.html 
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" media="all" href="../../webapp/static/css/style.css" th:href="@{/static/css/style.css}"/>
    <script type="text/javascript" src="../../webapp/static/js/thymeleaf.js" th:src="@{/static/js/thymeleaf.js}"></script>  
    <script>
    testFunction();
    </script>        
</head>
<body>
<div class="showing">
<p th:text="${name}" >name</p>
<p th:text="'Hello！ ' + ${name} + '!'" >hello world</p>
<p th:text="|Hello！ ${name}!|" >hello world</p>
</div> 
</body>
</html>
```

- 准备实体类，用于页面上显示数据；

- 控制器里准备数据，然后映射 /test 路径，返回到 test.html 中；

- 重启后访问地址`http://127.0.0.1:8080/thymeleaf/test`；

- 新建 include.html 文件，里面用 th:fragment 标记代码片段。除了th:replace， 还可以用 th:insert，th:insert 可以保留自己的主标签，保留 th:fragment 的主标签。th:replace 不要自己的主标签，保留 th:fragment 的主标签；

- 修改 test.html，增加包含数据

- 重启后访问地址`http://127.0.0.1:8080/thymeleaf/test`；

- 修改 TestController，增加一个布尔值数据，并且放在 model 中便于视图上获取；

- 修改 test.html，增加条件判断语句，通过 th:if 来进行条件判断，取反可以用 not, 或者用 th:unless。三元表达式也可以使用。 不只是布尔值的 true 和 false, th:if 表达式返回其他值时也会被认为是 true 或 false，规则如下:

  - boolean 类型并且值是 true，返回 true；
  - 数值类型并且值不是 0，返回 true；
  - 字符类型(Char)并且值不是 0, 返回 true；
  - String 类型并且值不是 "false"，"off", "no"，返回 true；
  - 不是 boolean，数值，字符，String 的其他类型，返回 true；
  - 值是 null，返回 false  

- 重启后访问地址`http://127.0.0.1:8080/thymeleaf/test`；

- 修改 TestController，准备集合 List\<Product> 用于视图上显示；

- 修改 test.html，使用 th:each 遍历，也可以使用 th:each="p,status: ${ps} 方式遍历，就把状态放在 status 里面了， 同时还用3元表达式判断奇偶。status里还包含了如下信息：

  - index 属性，0 开始的索引值；
  - count 属性，1 开始的索引值；
  - size 属性，集合内元素的总量；
  - current 属性，当前的迭代对象；
  - even/odd 属性，boolean 类型的，用来判断是否是偶数个还是奇数个；
  - first 属性，boolean 类型，是否是第一个；
  - last 属性，boolean 类型，是否是最后一个

  还可以结合 select，还是用 th:each,但是放在 option 元素上，就可以遍历出多个下拉框出来了。其中 th:selected 表示被选中的项。单选框也是同样的做法，其中 th:checked 用于判断是否选中；

- 重启后访问地址`http://127.0.0.1:8080/thymeleaf/test`；

- 修改 TestController，增加了日期对象，并且放在 "now" 这个变量上扔给视图；

- 修改 test.html，使用 #dates 这个内置工具进行格式化日期

```java
// Product.java
package com.how2java.springboot.pojo;
public class Product {
    private int id;
    private String name;
    private int price;
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
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Product(int id, String name, int price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }   
}
// TestController.java
package com.how2java.springboot.web;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.how2java.springboot.pojo.Product;
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(Model m) {
        String htmlContent = "<p style='color:red'> 红色文字</p>";
        Product currentProduct =new Product(5,"product e", 200);
        
        m.addAttribute("htmlContent", htmlContent);
        m.addAttribute("currentProduct", currentProduct);
        
        boolean testBoolean = true;
        m.addAttribute("testBoolean", testBoolean);
        
        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1,"product a", 50));
        ps.add(new Product(2,"product b", 100));
        ps.add(new Product(3,"product c", 150));
        ps.add(new Product(4,"product d", 200));
        ps.add(currentProduct);
        ps.add(new Product(6,"product f", 200));
        ps.add(new Product(7,"product g", 200));
        
        Date now = new Date();
        m.addAttribute("now", now);
        return "test";
    }
}
// test.html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" media="all" href="../../webapp/static/css/style.css" th:href="@{/static/css/style.css}"/>
    <script type="text/javascript" src="../../webapp/static/js/thymeleaf.js" th:src="@{/static/js/thymeleaf.js}"></script>
    <style>
        h2{
            text-decoration: underline;
            font-size:0.9em;
            color:gray;
        }
    </style>       
</head>
<body>
<div class="showing">
    <h2>显示转义和非转义的 html 文本</h2>
    <p th:text="${htmlContent}" ></p>			// <p style='color:red'> 红色文字</p>
    <p th:utext="${htmlContent}" ></p>			// 红色文字（为红色）
</div>
<div class="showing">
    <h2>显示对象以及对象属性</h2>
    <p th:text="${currentProduct}" ></p>		// com.how2java.springboot.pojo.Product@1f2c417
    <p th:text="${currentProduct.name}" ></p>		// Product e
    <p th:text="${currentProduct.getName()}" ></p>		// Product e
</div>
<div class="showing" th:object="${currentProduct}">
    <p th:text="*{name}"></p>			// *{}方式显示属性
    <p th:text="${currentProduct.price+999}" ></p>			// 算数运算
</div>
<div class="showing">
    <div th:replace="include::footer1" ></div>
    <div th:replace="include::footer2(2015,2018)" ></div>
</div>
<div class="showing">
    <h2>条件判断</h2>
    <p th:if="${testBoolean}" >如果 testBoolean 是 true ，本句话就会显示</p>
    <p th:if="${not testBoolean}" >取反，如果 testBoolean 是 true ，本句话就不会显示</p>
    <p th:unless="${testBoolean}" >unless 等同于上一句，所以如果 testBoolean 是 true ，本句话就不会显示</p>
    <p th:text="${testBoolean}?'当testBoolean为真的时候，显示本句话，这是用三相表达式做的':''" ></p>
</div>
<div class="showing">
    <h2>遍历</h2>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>产品名称</th>
                <th>价格</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="p: ${ps}">			// 普通遍历
            <tr th:class="${status.even}?'even':'odd'" th:each="p,status: ${ps}"> // 带状态的遍历
                <td th:text="${p.id}"></td>
                <td th:text="${p.name}"></td>
                <td th:text="${p.price}"></td>
            </tr>
        </tbody>
    </table>
    <select size="3">			// 结合 select
        <option th:each="p:${ps}" th:value="${p.id}" th:selected="${p.id==currentProduct.id}" th:text="${p.name}" ></option>
    </select>
    <input name="product" type="radio" th:each="p:${ps}" th:value="${p.id}" th:checked="${p.id==currentProduct.id}" th:text="${p.name}"  />			// 结合单选框
</div>
<div class="showing date">
	<h2>格式化日期</h2>
	直接输出日期 ${now}:
	<p th:text="${now}"></p>
	默认格式化 ${#dates.format(now)}:
	<p th:text="${#dates.format(now)}"></p>
	自定义格式化 ${#dates.format(now,'yyyy-MM-dd HH:mm:ss')}:
	<p th:text="${#dates.format(now,'yyyy-MM-dd HH:mm:ss')}"></p>
</div>
</body>
</html>
// include.html
<html xmlns:th="http://www.thymeleaf.org">
<footer th:fragment="footer1"> 
   <p >All Rights Reserved</p>
</footer>
<footer th:fragment="footer2(start,now)"> 
   <p th:text="|${start} - ${now} All Rights Reserved|"></p>
</footer>
</html>
```

#### 内置工具

像 #date 这样的 thymeleaf 内置工具有很多种，一共有如下16种

```java
// Execution Info
${#execInfo.templateName}
${#execInfo.templateMode}
${#execInfo.processedTemplateName}
${#execInfo.processedTemplateMode}
${#execInfo.templateNames}
${#execInfo.templateModes}
${#execInfo.templateStack}
// Messages
${#messages.msg('msgKey')}
${#messages.msg('msgKey', param1)}
${#messages.msg('msgKey', param1, param2)}
${#messages.msg('msgKey', param1, param2, param3)}
${#messages.msgWithParams('msgKey', new Object[] {param1, param2, param3, param4})}
${#messages.arrayMsg(messageKeyArray)}
${#messages.listMsg(messageKeyList)}
${#messages.setMsg(messageKeySet)}
${#messages.msgOrNull('msgKey')}
${#messages.msgOrNull('msgKey', param1)}
${#messages.msgOrNull('msgKey', param1, param2)}
${#messages.msgOrNull('msgKey', param1, param2, param3)}
${#messages.msgOrNullWithParams('msgKey', new Object[] {param1, param2, param3, param4})}
${#messages.arrayMsgOrNull(messageKeyArray)}
${#messages.listMsgOrNull(messageKeyList)}
${#messages.setMsgOrNull(messageKeySet)}
// URIs/URLs
${#uris.escapePath(uri)}
${#uris.escapePath(uri, encoding)}
${#uris.unescapePath(uri)}
${#uris.unescapePath(uri, encoding)}
${#uris.escapePathSegment(uri)}
${#uris.escapePathSegment(uri, encoding)}
${#uris.unescapePathSegment(uri)}
${#uris.unescapePathSegment(uri, encoding)}
${#uris.escapeFragmentId(uri)}
${#uris.escapeFragmentId(uri, encoding)}
${#uris.unescapeFragmentId(uri)}
${#uris.unescapeFragmentId(uri, encoding)}
${#uris.escapeQueryParam(uri)}
${#uris.escapeQueryParam(uri, encoding)}
${#uris.unescapeQueryParam(uri)}
${#uris.unescapeQueryParam(uri, encoding)}
// Conversions
${#conversions.convert(object, 'java.util.TimeZone')}
${#conversions.convert(object, targetClass)}
// Dates
${#dates.format(date)}
${#dates.arrayFormat(datesArray)}
${#dates.listFormat(datesList)}
${#dates.setFormat(datesSet)}
${#dates.formatISO(date)}
${#dates.arrayFormatISO(datesArray)}
${#dates.listFormatISO(datesList)}
${#dates.setFormatISO(datesSet)}
${#dates.format(date, 'dd/MMM/yyyy HH:mm')}
${#dates.arrayFormat(datesArray, 'dd/MMM/yyyy HH:mm')}
${#dates.listFormat(datesList, 'dd/MMM/yyyy HH:mm')}
${#dates.setFormat(datesSet, 'dd/MMM/yyyy HH:mm')}
${#dates.day(date)}                   
${#dates.month(date)}                 
${#dates.monthName(date)}             
${#dates.monthNameShort(date)}        
${#dates.year(date)}                  
${#dates.dayOfWeek(date)}             
${#dates.dayOfWeekName(date)}         
${#dates.dayOfWeekNameShort(date)}    
${#dates.hour(date)}                  
${#dates.minute(date)}                
${#dates.second(date)}                
${#dates.millisecond(date)}           
${#dates.create(year,month,day)}
${#dates.create(year,month,day,hour,minute)}
${#dates.create(year,month,day,hour,minute,second)}
${#dates.create(year,month,day,hour,minute,second,millisecond)}
${#dates.createNow()}
${#dates.createNowForTimeZone()}
${#dates.createToday()}
${#dates.createTodayForTimeZone()}
// Calendars
${#calendars.format(cal)}
${#calendars.arrayFormat(calArray)}
${#calendars.listFormat(calList)}
${#calendars.setFormat(calSet)}
${#calendars.formatISO(cal)}
${#calendars.arrayFormatISO(calArray)}
${#calendars.listFormatISO(calList)}
${#calendars.setFormatISO(calSet)}
${#calendars.format(cal, 'dd/MMM/yyyy HH:mm')}
${#calendars.arrayFormat(calArray, 'dd/MMM/yyyy HH:mm')}
${#calendars.listFormat(calList, 'dd/MMM/yyyy HH:mm')}
${#calendars.setFormat(calSet, 'dd/MMM/yyyy HH:mm')}
${#calendars.day(date)}               
${#calendars.month(date)}             
${#calendars.monthName(date)}         
${#calendars.monthNameShort(date)}    
${#calendars.year(date)}              
${#calendars.dayOfWeek(date)}         
${#calendars.dayOfWeekName(date)}     
${#calendars.dayOfWeekNameShort(date)}
${#calendars.hour(date)}              
${#calendars.minute(date)}            
${#calendars.second(date)}            
${#calendars.millisecond(date)}       
${#calendars.create(year,month,day)}
${#calendars.create(year,month,day,hour,minute)}
${#calendars.create(year,month,day,hour,minute,second)}
${#calendars.create(year,month,day,hour,minute,second,millisecond)}
${#calendars.createForTimeZone(year,month,day,timeZone)}
${#calendars.createForTimeZone(year,month,day,hour,minute,timeZone)}
${#calendars.createForTimeZone(year,month,day,hour,minute,second,timeZone)}
${#calendars.createForTimeZone(year,month,day,hour,minute,second,millisecond,timeZone)}
${#calendars.createNow()}
${#calendars.createNowForTimeZone()}
${#calendars.createToday()}
${#calendars.createTodayForTimeZone()}
// Numbers
${#numbers.formatInteger(num,3)}
${#numbers.arrayFormatInteger(numArray,3)}
${#numbers.listFormatInteger(numList,3)}
${#numbers.setFormatInteger(numSet,3)}
${#numbers.formatInteger(num,3,'POINT')}
${#numbers.arrayFormatInteger(numArray,3,'POINT')}
${#numbers.listFormatInteger(numList,3,'POINT')}
${#numbers.setFormatInteger(numSet,3,'POINT')}
${#numbers.formatDecimal(num,3,2)}
${#numbers.arrayFormatDecimal(numArray,3,2)}
${#numbers.listFormatDecimal(numList,3,2)}
${#numbers.setFormatDecimal(numSet,3,2)}
${#numbers.formatDecimal(num,3,2,'COMMA')}
${#numbers.arrayFormatDecimal(numArray,3,2,'COMMA')}
${#numbers.listFormatDecimal(numList,3,2,'COMMA')}
${#numbers.setFormatDecimal(numSet,3,2,'COMMA')}
${#numbers.formatDecimal(num,3,'POINT',2,'COMMA')}
${#numbers.arrayFormatDecimal(numArray,3,'POINT',2,'COMMA')}
${#numbers.listFormatDecimal(numList,3,'POINT',2,'COMMA')}
${#numbers.setFormatDecimal(numSet,3,'POINT',2,'COMMA')}
${#numbers.formatCurrency(num)}
${#numbers.arrayFormatCurrency(numArray)}
${#numbers.listFormatCurrency(numList)}
${#numbers.setFormatCurrency(numSet)}
${#numbers.formatPercent(num)}
${#numbers.arrayFormatPercent(numArray)}
${#numbers.listFormatPercent(numList)}
${#numbers.setFormatPercent(numSet)}
${#numbers.formatPercent(num, 3, 2)}
${#numbers.arrayFormatPercent(numArray, 3, 2)}
${#numbers.listFormatPercent(numList, 3, 2)}
${#numbers.setFormatPercent(numSet, 3, 2)}
${#numbers.sequence(from,to)}
${#numbers.sequence(from,to,step)}
// Strings
${#strings.toString(obj)}                          
${#strings.isEmpty(name)}
${#strings.arrayIsEmpty(nameArr)}
${#strings.listIsEmpty(nameList)}
${#strings.setIsEmpty(nameSet)}
${#strings.defaultString(text,default)}
${#strings.arrayDefaultString(textArr,default)}
${#strings.listDefaultString(textList,default)}
${#strings.setDefaultString(textSet,default)}
${#strings.contains(name,'ez')}                    
${#strings.containsIgnoreCase(name,'ez')}          
${#strings.startsWith(name,'Don')}                 
${#strings.endsWith(name,endingFragment)}          
${#strings.indexOf(name,frag)}                     
${#strings.substring(name,3,5)}                    
${#strings.substringAfter(name,prefix)}            
${#strings.substringBefore(name,suffix)}           
${#strings.replace(name,'las','ler')}              
${#strings.prepend(str,prefix)}                    
${#strings.append(str,suffix)}                     
${#strings.toUpperCase(name)}                      
${#strings.toLowerCase(name)}                      
${#strings.arrayJoin(namesArray,',')}
${#strings.listJoin(namesList,',')}
${#strings.setJoin(namesSet,',')}
${#strings.arraySplit(namesStr,',')}               
${#strings.listSplit(namesStr,',')}                
${#strings.setSplit(namesStr,',')}                 
${#strings.trim(str)}                              
${#strings.length(str)}                            
${#strings.abbreviate(str,10)}                     
${#strings.capitalize(str)}                        
${#strings.unCapitalize(str)}                      
${#strings.capitalizeWords(str)}                   
${#strings.capitalizeWords(str,delimiters)}        
${#strings.escapeXml(str)}                         
${#strings.escapeJava(str)}                        
${#strings.escapeJavaScript(str)}                  
${#strings.unescapeJava(str)}                      
${#strings.unescapeJavaScript(str)}                
${#strings.equals(first, second)}
${#strings.equalsIgnoreCase(first, second)}
${#strings.concat(values...)}
${#strings.concatReplaceNulls(nullValue, values...)}
${#strings.randomAlphanumeric(count)}
// Objects
${#objects.nullSafe(obj,default)}
${#objects.arrayNullSafe(objArray,default)}
${#objects.listNullSafe(objList,default)}
${#objects.setNullSafe(objSet,default)}
// Booleans
${#bools.isTrue(obj)}
${#bools.arrayIsTrue(objArray)}
${#bools.listIsTrue(objList)}
${#bools.setIsTrue(objSet)}
${#bools.isFalse(cond)}
${#bools.arrayIsFalse(condArray)}
${#bools.listIsFalse(condList)}
${#bools.setIsFalse(condSet)}
${#bools.arrayAnd(condArray)}
${#bools.listAnd(condList)}
${#bools.setAnd(condSet)}
${#bools.arrayOr(condArray)}
${#bools.listOr(condList)}
${#bools.setOr(condSet)}
// Arrays
${#arrays.toArray(object)}
${#arrays.toStringArray(object)}
${#arrays.toIntegerArray(object)}
${#arrays.toLongArray(object)}
${#arrays.toDoubleArray(object)}
${#arrays.toFloatArray(object)}
${#arrays.toBooleanArray(object)}
${#arrays.length(array)}
${#arrays.isEmpty(array)}
${#arrays.contains(array, element)}
${#arrays.containsAll(array, elements)}
// Lists
${#lists.toList(object)}
${#lists.size(list)}
${#lists.isEmpty(list)}
${#lists.contains(list, element)}
${#lists.containsAll(list, elements)}
${#lists.sort(list)}
${#lists.sort(list, comparator)}
${#sets.toSet(object)}
// Sets
${#sets.size(set)}
${#sets.isEmpty(set)}
${#sets.contains(set, element)}
${#sets.containsAll(set, elements)}
// Maps
${#maps.size(map)}
${#maps.isEmpty(map)}
${#maps.containsKey(map, key)}
${#maps.containsAllKeys(map, keys)}
${#maps.containsValue(map, value)}
${#maps.containsAllValues(map, value)}
// Aggregates
${#aggregates.sum(array)}
${#aggregates.sum(collection)}
${#aggregates.avg(array)}
${#aggregates.avg(collection)}
// IDs
${#ids.seq('someId')}
${#ids.next('someId')}
${#ids.prev('someId')}
```

#### CRUD和分页

可以参照 Mybatis CRUD 和分页。修改页面的后缀为 html，比如 listCategory.html、editCategory.html。重启后访问地址`http://127.0.0.1:8080/thymeleaf/listCategory`

```java
// editCategory.html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<div style="margin:0px auto; width:500px">
    <form action="updateCategory" method="post"> 
    name: <input name="name" th:value="${c.name}"/> <br/>     
    <input name="id" type="hidden" th:value="${c.id}"/>
    <button type="submit">提交</button>   
    </form>
</div>
</body>
</html> 
```

#### Vue.js 和 Restful风格

前后端分离的 CRUD

- 增加实体类 Hero，HeroMapper 类；
- 增加`src/main/resources/mapper/Hero.xml`;
- 增加 Service 接口和 Service 实现类；
- 修改 HeroController 类，包括 restful 部分和页面跳转部分，restful 提供 CRUD 等操作，页面跳转主要用来跳转到 thymeleaf 对应的 html 文件；
- 在 resources 下新建 templates 目录，创建3个模板文件 listHero.html、editHero.html 和 errorPage.html；
- 重启后访问测试地址`http://127.0.0.1:8080/listHero`

```java
// Hero.java
package com.how2java.springboot.pojo;
public class Hero {
    private int id;    
    private String name;
    private int hp;
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
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
        return "Hero [id=" + id + ", name=" + name + ", hp=" + hp + "]";
    }
}
// HeroMapper.java
package com.how2java.springboot.mapper;  
import java.util.List; 
import org.apache.ibatis.annotations.Mapper; 
import com.how2java.springboot.pojo.Hero  
@Mapper
public interface HeroMapper {
    public int add(Hero hero);     
    public void delete(int id);        
    public Hero get(int id);       
    public int update(Hero hero);         
    public List<Hero> list();
}
// Hero.xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">   
    <mapper namespace="com.how2java.springboot.mapper.HeroMapper">
        <insert id="add" parameterType="Hero" >
            insert into hero ( name,hp ) values (#{name},#{hp})  
        </insert>         
        <delete id="delete" parameterType="Hero" >
            delete from hero where id= #{id} 
        </delete>          
        <select id="get" parameterType="_int" resultType="Hero">
            select * from   hero  where id= #{id}  
        </select>  
        <update id="update" parameterType="Hero" >
            update hero set name=#{name}, hp = #{hp} where id=#{id}  
        </update>
        <select id="list" resultType="Hero">
            select * from   hero    
        </select> 
    </mapper>
// HeroService.java
package com.how2java.springboot.service;
import java.util.List;
import com.how2java.springboot.pojo.Hero;
public interface HeroService {
    public int add(Hero hero);    
    public void delete(int id);        
    public Hero get(int id);       
    public int update(Hero hero);          
    public List<Hero> list();
}
// HeroServiceImpl.java
package com.how2java.springboot.service.impl; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.how2java.springboot.mapper.HeroMapper;
import com.how2java.springboot.pojo.Hero;
import com.how2java.springboot.service.HeroService;
@Service
public class HeroServiceImpl implements HeroService{   
    @Autowired HeroMapper heroMapper;
    @Override
    public int add(Hero hero) {
        return heroMapper.add(hero);
    }
    @Override
    public void delete(int id) {
        heroMapper.delete(id);
    } 
    @Override
    public Hero get(int id) {
        return heroMapper.get(id);
    } 
    @Override
    public int update(Hero hero) {
        return heroMapper.update(hero);
    }
    @Override
    public List<Hero> list() {
        return heroMapper.list();
    }
}
// HeroController.java
package com.how2java.springboot.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.pojo.Hero;
import com.how2java.springboot.service.HeroService;
@RestController
public class HeroController {
    @Autowired HeroService heroService;
    /* restful 部分*/
    @GetMapping("/heroes")
    public PageInfo<Hero> list(@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<Hero> hs=heroService.list();
        System.out.println(hs.size());
        PageInfo<Hero> page = new PageInfo<>(hs,5); 		// 表示导航分页最多有5个
        return page;
    }  
    @GetMapping("/heroes/{id}")
    public Hero get(@PathVariable("id") int id) throws Exception {
        System.out.println(id);
        Hero h=heroService.get(id);
        System.out.println(h);
        return h;
    }  
    @PostMapping("/heroes")
    public String add(@RequestBody Hero h) throws Exception {
        heroService.add(h);
        return "success";
    }
    @DeleteMapping("/heroes/{id}")
    public String delete(Hero h) throws Exception {
        heroService.delete(h.getId());
        return "success";
    }
    @PutMapping("/heroes/{id}")
    public String update(@RequestBody Hero h) throws Exception {
        heroService.update(h);
        return "success";
    }  
    /* 页面跳转部分 */
    @RequestMapping(value="/listHero", method=RequestMethod.GET)
    public ModelAndView listHero(){
        ModelAndView mv = new ModelAndView("listHero");
        return mv;
    }  
    @RequestMapping(value="/editHero", method=RequestMethod.GET)
    public ModelAndView editHero(){
        ModelAndView mv = new ModelAndView("editHero");
        return mv;
    }   
}
```

模板文件

```java
// listHero.html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="./js/jquery.min.js"></script>
    <script src="./js/vue.min.js"></script>
    <script src="./js/axios.min.js"></script>   
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
        div#pagination{
            text-align: center;
            line-height: 100px;
        }
        div#pagination a{
            text-decoration:none;
        }    
        .disableHref{
            cursor:default;
            color:#E5E0E0;
            text-decoration:none;       
        }
    </style>
    <script>
        $(function(){
            $("a.disableHref").click(function(event){
                return false;
		   // event.preventDefault(); 防止链接打开 URL
            });
        });
    </script>
</head> 
<body>
    <div id="app">
            <table id="heroListTable" >
                    <tr>
                        <td colspan="3">
                            <div id="pagination" >
                                <a :class="{ disableHref: pagination.pageNum==1 }" href="#nowhere" @click="jump('first')">[first]</a>
                                <a :class="{ disableHref: !pagination.hasPreviousPage }" href="#nowhere" @click="jump('pre')">[pre]</a>
 
                                <a href="#nowhere" :class="{disableHref:pagination.pageNum==i}"  v-for="i in pagination.navigatepageNums" @click="jumpByNumber(i)" >
                                    {{i}}
                                </a>
                                <a :class="{ disableHref: !pagination.hasNextPage }" href="#nowhere" @click="jump('next')">[next]</a>
                                <a :class="{ disableHref: pagination.pageNum==pagination.pages }" href="#nowhere" @click="jump('last')">[last]</a>
                            </div>
                        </td>
                    </tr>                              
                    <tr>
                        <td>英雄名称</td>
                        <td>血量</td>
                        <td>操作</td>
                    </tr>
                    <tr v-for="hero in heros ">
                        <td>{{hero.name}}</td>
                        <td>{{hero.hp}}</td>
                        <td>
                            <a :href="'editHero?id=' + hero.id ">编辑</a>
                            <a href="#nowhere" @click="deleteHero(hero.id)">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <br>
                            英雄名称:
                            <input type="text" v-model="hero4Add.name" />
                            <br>
                            血量：
                            <input type="number" v-model="hero4Add.hp" />
                            <br>
                            <br>
                            <button type="button" v-on:click="add">增加</button>
                            <br>
                         </td>                 
                    </tr>
                     
            </table>
    </div>
    <script type="text/javascript">
    var data4Vue = {
            heros: [],
            hero4Add: { id: 0, name: '', hp: '0'},
            pagination:{}
    }; 
    // ViewModel
    var vue = new Vue({
        el: '#app',
        data: data4Vue,
        mounted:function(){			// mounted 表示这个 Vue 对象加载成功了
            this.list(1);
        },       
        methods: {     
            list:function(start){
                var url = "heroes?start="+start;
                axios.get(url).then(function(response) {
                    vue.pagination = response.data;
                    console.log(vue.pagination);
                    vue.heros = response.data.list;
                })    
            },         
            add: function (event) {
                var url = "heroes";
                axios.post(url,this.hero4Add).then(function(response){
                    vue.list(1);
                    vue.hero4Add = { id: 0, name: '', hp: '0'}
                });
            },
            deleteHero: function (id) {
                var url = "heroes/"+id;
                axios.delete(url).then(function(response){
                    vue.list(1);
                });
            },
            jump: function(page){
                if('first'== page && 1!=vue.pagination.pageNum)
                    vue.list(1);
                 
                else if('pre'== page && vue.pagination.hasPreviousPage )
                    vue.list(vue.pagination.prePage);
                 
                else if('next'== page && vue.pagination.hasNextPage)
                    vue.list(vue.pagination.nextPage);                 
                 
                else if('last'== page && vue.pagination.pageNum!=vue.pagination.pages)
                    vue.list(vue.pagination.pages);    
            },
            jumpByNumber: function(start){
                if(start!=vue.pagination.pageNum)
                    vue.list(start);
            }
        }
    });
    </script>
</body>
</html>
// editHero.html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="./js/jquery.min.js"></script>
    <script src="./js/vue.min.js"></script>
    <script src="./js/axios.min.js"></script>   
    <style type="text/css">
        div#app{
            margin:20px auto;
            width:400px;
            padding:20px;
        }     
    </style>
</head>  
<body>
    <div id="app">
            <div id="div4Update">      
                            英雄名称:
                            <input type="text" v-model="hero4Update.name" />
                            <br>
                            血量：
                            <input type="number" v-model="hero4Update.hp" />                      
                            <input type="hidden" v-model="hero4Update.id" />                      
                            <br>
                            <button type="button" v-on:click="update">修改</button>               
                            <button type="button" v-on:click="cancel">取消</button>               
            </div>
    </div>
    <script type="text/javascript">
    // 获取地址栏参数的函数
    function getUrlParms(name){
           var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
           var r = window.location.search.substr(1).match(reg);
           if(r!=null)
               return unescape(r[2]);			// 对通过 escape() 编码的字符串进行解码
           return null;
    }     
    var data4Vue = {
            heros: [],
            hero4Update: { id: 0, name: '', hp: '0'}
    };     
    var vue = new Vue({
        el: '#app',
        data: data4Vue,
        mounted:function()
            this.get();
        },       
        methods: {
            get:function(){
                var id = getUrlParms("id");
                var url = "heroes/"+id;
                console.log(url);
                axios.get(url).then(function(response) {
                    vue.hero4Update = response.data;
                })    
            },
            update:function (event) {
                var url = "heroes/"+vue.hero4Update.id;
                axios.put(url,vue.hero4Update).then(function(response){
                    location.href="listHero";
                });
            },
            cancel:function(){
                location.href="listHero";
            }
        }
    });
    </script>
</body>
</html>
// errorPage.html
<html xmlns:th="http://www.thymeleaf.org">
<body>
    <div style="width:500px;border:1px solid lightgray;margin:200px auto;padding:80px">
        系统出现了异常，异常原因是：
        <div th:text="${exception}"></div>
        出现异常的地址是：
        <div th:text="${url}"></div>
    </div>
</body>
</html>
```

#### idea 热更新

在 idea2017 里， springboot thymeleaf 修改 html 之后不能立即看到效果，要重新启动 Application 才可以看到效果。 这样做开发效率肯定是大受影响的

- 依次点击 菜单 -> Other Settings -> Default Settings -> Builld, Execution, Deployment -> Compiler
  勾选其中的 Build project automatically，这个选项默认是没有被勾选的；
- automake 选项开启比较麻烦，因为它的开启界面默认是不能够被打开的，需要通过快捷键才能打开。点击 菜单->File->Settings->左上角的搜索框里输入 Registry，右边搜索结果出现 Registry，然后给这个功能增加一个快捷键 Alt+Shift+M 后点击 OK。通过 Alt+Shift +M 快捷键打开 Registry 窗口，把`comipler.automake.allow.when.app.running`勾上。接着重启 idea 这样修改 html 就可以马上看到效果了