双击运行目录内的`setup_xampp.bat`初始化 xampp。然后运行 `xampp-control.exe` 可以启动或停止 apache、mysql 等各个模块并可将其注册为服务

#### 配置Apache

把 httpd.conf 中的80端口全部修改为 8081，如果不修改，会与默认80端口产生冲突，严重时可能导致浏览器不能正常使用。没有更改Apache的端口时，使用的是 http://localhost 访问xampp主页；更改后， 假设80改为了8081 则使用 http://localhost:8081 。把 httpd-ssl.conf 文件把端口443修改为4433

```
# ./apache/conf/httpd.conf
...
#Listen 0.0.0.0:80
#Listen [::]:80
Listen 80          # 修改为 8081
...
#
ServerName localhost:80          # 修改为 8081
...
# ./apache/conf/httpd-ssl.conf
...
#Listen 0.0.0.0:443
#Listen [::]:443
Listen 4433
...
<VirtualHost _default_:443>
    #   General setup for the virtual host
    DocumentRoot "D:/Program Files (x86)/xampp/htdocs"
    ServerName localhost:443          # 修改为 4433
```

#### 配置MySQL

把my.ini中的3306改为3316（如果 3306 不冲突，可以不修改）。把my.ini中的字符集改为utf8，原文档中已有，但需要取消注释（如果不配置utf8，取出的中文是乱码）

```
## UTF 8 Settings
#init-connect=\'SET NAMES utf8\'          # 从这行开始去掉开头的 #
#collation_server=utf8_unicode_ci
#character_set_server=utf8
#skip-character-set-client-handshake
#character_sets-dir="D:/Program Files (x86)/xampp/mysql/share/charsets"
```

Apache默认网站目录为…\xampp/htdocs，但是显示 `Object not found!`。<http://localhost:8080/dashboard/>？

#### 部署项目

复制文件夹到…\xampp\htdocs目录下，如…\xampp\htdocs\test，浏览器中访问 localhost/test。或者在 在`httpd-xampp.conf`文件中建立虚拟目录

1. 首先修改C盘`WINDOWS\system32\drivers\etc`目录下的 hosts 文件，加入映射

   ```
   # thinkphp5
     127.0.0.1 www.youpindao.com
   ```

2. 打开`xampp\apache\conf\httpd.conf`文件，搜索 `“Include conf/extra/httpd-vhosts.conf”`，确保前面没有 # 注释符，也就是确保引入了 vhosts 虚拟主机配置文件

3. 在虚拟主机设置文件`xampp\apache\conf\extra\httpd-vhosts.conf`里设置，在最后添加

   ```
   <VirtualHost *:80>
       DocumentRoot "D:\xampp\htdocs\test"          # 你的项目路径
       ServerName WWW.youpindao.com          # 你的站点域名
       ServerAlias youpindao.com          # 你的站点二级域名
     <Directory "D:\xampp\htdocs\test">
         AllowOverride All
         Order allow,deny
         Allow from all
         Require all granted
     </Directory>
   </VirtualHost>
   ```

4. 配置重启完成后，浏览器里输入 www.youpindao.com 就可以访问了

phpmyadmin导入文件大小限制修改： 打开PHP配置文件PHP.ini，搜索“upload_max_filesize”，修改默认的2M就行了

 https://blog.csdn.net/scx_yatoy/article/details/76131169 

#### admin不能正常显示

MySQL 口号和 Apache 端口号和点击右上角 “config”，点“Service and Port Settings”里面的要一样

#### 修改密码打不开

 通过 phpmyadmin 设置数据库密码后若出现 phpmyadmin 拒绝访问的情况 ，方法一：可以修改config.inc.php配置文件中的`$cfg['Servers'][$i]['password'] = '你的密码'`；方法二：将 config.inc.php 配置文件中的`$cfg['Servers'][$i]['auth_type'] = 'config';`   修改为   `$cfg['Servers'][$i]['auth_type'] = 'http';`