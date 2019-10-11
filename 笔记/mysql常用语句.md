## mysql常用语句

### 使用中mysqladmin工具程序来获取服务器状态

```
D:\software\mysql-5.6.25-winx64\bin> mysqladmin --version
```

### 运行和关闭MySQL服务器

```
D:\software\mysql-5.6.25-winx64\bin>mysqld
D:\software\mysql-5.6.25-winx64\bin>mysqladmin -u root -p shutdown

在windows命令行下
net start mysql56
net stop mysql56
```

### 进入mysql

```
D:\software\mysql-5.6.25-winx64\bin> mysql
D:\software\mysql-5.6.25-winx64\bin> mysql -u root -p password
```

### 查看当前用户和数据库

```mysql
mysql> select user();
mysql> select database();
```

### 显示数据库、数据库中的表和表中的列

```mysql
mysql> SHOW DATABASES;
mysql> SHOW TABLES;
mysql> SHOW COLUMNS FROM tablename;
mysql> SHOW INDEX FROM tablename;
mysql> SHOW TABLE STATUS LIKE tablename;
mysql> SHOW CREATE TABLE table_name;
```

### 忘记密码后重置的操作

1. 首先关闭MySQL服务：net stop mysql56

2. 然后转到MySQL的bin目录，输入

   ```
   mysqld --skip-grant-tables
   ```

   --skip-grant-tables的意思是启动MySQL服务的时候跳过权限表认证

3. 再开一个DOS窗口(因为刚才那个DOS窗口已经不能动了)，转到mysql\bin目录，输入mysql回车

4. ```mysql
   use mysql;
   update user 
   set password=password("123456") 
   where user="root";
   flush privileges;
   equi;
   mysql -u root -p 123456
   ```


### 设置mysql用户账户

```mysql
mysql> use mysql;
mysql> INSERT INTO user 
          (host, user, password, 
           select_priv, insert_priv, update_priv) 
           VALUES ('localhost', 'yiibai', 
           PASSWORD('123456'), 'Y', 'Y', 'Y');
mysql> FLUSH PRIVILEGES;
```

### 或者使用另一种方式创建用户

```mysql
mysql>create database tutorials default character set utf8 collate utf8_general_ci;
mysql> GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP
    -> ON tutorials.*
    -> TO 'yiibai'@'localhost'
    -> IDENTIFIED BY '123456';
```

### 创建数据库

```mysql
D:\software\mysql-5.6.25-winx64\bin> mysqladmin -u root -p create tutorials
mysql>create database tutorials default character set utf8 collate utf8_general_ci;
```

utf8为字符集，utf8_general_ci为字符集校对

### 删除数据库

```mysql
D:\software\mysql-5.6.25-winx64\bin> mysqladmin -u root -p drop tutorials
mysql> drop database tutorials;
```

### MySQL表字段类型

#### mysql中的数字数据类型

INT - 11位，TIBYINT - 4位，SMALLINT - 5位，MEDIUNINT - 9位，BIGINT - 20位，FLOAT(M,D) - 不能使用无符号，默认为10,2，小数精度24个浮点，DOUBLE(M,D)/REAL - 不能使用无符号，默认为16,4，小数精度53个浮点，DECIMAL(M,D)/NUMERIC - 非压缩浮点数不能是无符号的

#### 日期和时间类型

- DATE - 以YYYY-MM-DD格式的日期，在1000-01-01和9999-12-31之间。 
- DATETIME - 日期和时间组合以YYYY-MM-DD HH:MM:SS格式，在1000-01-01 00:00:00 到9999-12-31 23:59:59之间。
- TIMESTAMP - 1970年1月1日午夜之间的时间戳，到2037的某个时候。这看起来像前面的DATETIME格式，无需数字之间的连字符; 1973年12月30日下午3点30分将被存储为19731230153000(YYYYMMDDHHMMSS)。
- TIME - 存储时间为HH:MM:SS格式。
- YEAR(M) - 以2位或4位数字格式来存储年份。如果长度指定为2(例如YEAR(2))，年份就可以为1970至2069(70〜69)。如果长度指定为4，年份范围是1901-2155，默认长度为4。

#### 字符串类型

- CHAR(M) - 固定长度的字符串是以长度为1到255之间个字符长度(例如：CHAR(5))，存储右空格填充到指定的长度。 限定长度不是必需的，它会默认为1。
- VARCHAR(M) - 可变长度的字符串是以长度为1到255之间字符数(高版本的MySQL超过255); 例如： VARCHAR(25). 创建VARCHAR类型字段时，必须定义长度。
- BLOB or TEXT - 字段的最大长度是65535个字符。 BLOB是“二进制大对象”，并用来存储大的二进制数据，如图像或其他类型的文件。定义为TEXT文本字段还持有大量的数据; 两者之间的区别是，排序和比较上存储的数据，BLOB大小写敏感，而TEXT字段不区分大小写。不用指定BLOB或TEXT的长度。
- TINYBLOB 或 TINYTEXT - BLOB或TEXT列用255个字符的最大长度。不指定TINYBLOB或TINYTEXT的长度。
- MEDIUMBLOB or MEDIUMTEXT - BLOB或TEXT列具有16777215字符的最大长度。不指定MEDIUMBLOB或MEDIUMTEXT的长度。
- LONGBLOB 或 LONGTEXT -  BLOB或TEXT列具有4294967295字符的最大长度。不指定LONGBLOB或LONGTEXT的长度。
- ENUM - 枚举，当定义一个ENUM，要创建它的值的列表，这些是必须用于选择的项(也可以是NULL)。例如，如果想要字段包含“A”或“B”或“C”，那么可以定义为ENUM为 ENUM(“A”，“B”，“C”)，也只有这些值(或NULL)才能用来填充这个字段。

### 创建表

```mysql
mysql> use tutorials;
mysql> CREATE TABLE tutorials_tbl(
   -> tutorial_id INT NOT NULL AUTO_INCREMENT,
   -> tutorial_title VARCHAR(100) NOT NULL,
   -> tutorial_author VARCHAR(40) NOT NULL,
   -> submission_date DATE,
   -> PRIMARY KEY ( tutorial_id )
   -> );
```

在每次创建表的时候都在最后加上`character set = utf8`，就可以很好的支持中文；加上TYPE= InnoDB，使表支持InnoDB类型，#号后为注释

修改表结构支持中文

```sql
alter table table_name 
convert to character set utf8;
```

### MySQL临时表

```
CREATE TEMPORARY TABLE SalesSummary(...);
```

当发出SHOW TABLES命令，临时表不会被列在表的列表中。如果注销MySQL会话，然后发出SELECT命令，那么会发现在数据库中没有可用的数据

### 修改表中的列

```mysql
ALTER TABLE testalter_tbl DROP i;
ALTER TABLE testalter_tbl ADD i INT FIRST;
ALTER TABLE testalter_tbl ADD i INT AFTER c;
ALTER TABLE testalter_tbl MODIFY c CHAR(10);
ALTER TABLE testalter_tbl CHANGE i j BIGINT;
ALTER TABLE testalter_tbl ALTER i SET DEFAULT 1000;
ALTER TABLE testalter_tbl ALTER i DROP DEFAULT;
ALTER TABLE testalter_tbl RENAME TO alter_tbl;
```

用truncate来删除表中的所有字段

```mysql
truncate table tb;
```

truncate语句，只能用于删除表中的所有记录，删除表中的数据后，向表中添加记录时，自动增加字段的默认初始值重新从1开始

truncate和delete的区别

1. DELETE语句执行删除的过程是每次从表中删除一行，并且同时将该行的删除操作作为事务记录在日志中保存以便进行回滚操作
2.  TRUNCATE TABLE 则一次性地从表中删除所有的数据并不把单独的删除操作记录记入日志保存，删除行是不能恢复的。并且在删除的过程中不会激活与表有关的删除触发器

修改索引

```mysql
ALTER TABLE tbl_name ADD UNIQUE index_name (column_list)；
ALTER TABLE tbl_name ADD INDEX index_name (column_list)；
ALTER TABLE tbl_name ADD FULLTEXT index_name (column_list):；
ALTER TABLE tbl_name ADD INDEX (c); 不加名称时索引名称为c
ALTER TABLE tbl_name drop INDEX c;
ALTER TABLE testalter_tbl DROP PRIMARY KEY;
```

FULLTEXT是用于文本搜索目的一种特殊的索引，UNIQUE (last_name, first_name)

### 插入数据

```mysql
mysql> INSERT INTO tutorials_tbl (tutorial_title, tutorial_author, submission_date) VALUES ("Learn PHP", "Paul", NOW());
```

使用INSERT IGNORE INTO，如果记录与现有不重复时，MySQL将其正常插入。如果记录是一个重复的，则 IGNORE 关键字告诉MySQL丢弃它而不会产生错误。使用REPLACE而不是INSERT，如果记录是新的，它插入就像使用 INSERT。如果它是重复的，新的记录将取代旧的记录

### 分页查询

```sql
SELECT * FROM Student limit 9,4
SELECT * FROM student limit 4 offset 9
```

语句1和2均返回表Student的第10、11、12、13行

除非执行字符串LIKE比较，比较是不区分大小写，msql字段不区分大小写

### 连接的表示法

```mysql
SELECT Sname,Cno,Degree
FROM Students INNER JOIN Scores 
ON(Students.Sno=Scores.Sno)
ORDER BY Sname;

SELECT Sname,Cname,Degree
FROM Students INNER JOIN Scores
ON(Students.Sno=Scores.Sno) INNER JOIN Courses
ON(Scores.Cno=Courses.Cno)
ORDER BY Sname;

SELECT s1.Sno,s1.Degree FROM Scores AS s1 INNER JOIN Scores AS s2 ON(s1.Cno=s2.Cno AND s1.Degree>s2.Degree) WHERE s1.Cno='3-105' AND s2.Sno='109' ORDER BY s1.Sno;
```

### mysql正则表达式

|    模式    |         什么样的模式匹配         |
| :--------: | :------------------------------: |
|     ^      |         开始的一个字符串         |
|     $      |         结束的一个字符串         |
|     .      |           任意单个字符           |
|   [...]    |      方括号中列出的任何字符      |
|   [^...]   |   任何字符方括号之间不会被列出   |
| p1\|p2\|p3 | 交替匹配的任何模式 p1, p2, 或 p3 |
|     *      |    前一个元素的零个或多个实例    |
|     +      |      前面元素的一或多个实例      |
|    {n}     |       前一个元素的n个实例        |
|   {m,n}    |    前一个元素的 m 到 n 个实例    |

查询查找所有以 “st” 开头的名字：

```mysql
mysql> SELECT name FROM person_tbl WHERE name REGEXP '^st';
```

查询找到所有以 'ok' 结尾的名字

```mysql
mysql> SELECT name FROM person_tbl WHERE name REGEXP 'ok$';
```

查询查找其中包含 'mar' 所有的名字

```mysql
mysql> SELECT name FROM person_tbl WHERE name REGEXP 'mar';
```

查询查找以元音开头或者 'ok' 结尾的所有名称

```mysql
mysql> SELECT name FROM person_tbl WHERE name REGEXP '^[aeiou]|ok$';
```

### MySQL数据库导入导出

导出表数据到一个文本文件

```mysql
SELECT * FROM tutorials_tbl 
INTO OUTFILE 'C:\tutorials.txt'; 
```

语句类似于没有LOCAL版本的LOAD DATA的本地版本

注意：MYSQL导入数据出现`The MySQL server is running with the --secure-file-priv option so it cannot execute this statement`的解决办法：

1. 通过下面命令查看 secure-file-priv 当前的值是什么

   ```
   show variables like '%secure%';
   ```

2. 或者到C:\ProgramData\MySQL\MySQL Server 5.7目录下找到my.ini，找到secure-file-priv一行并将它的值改为自己的目录

使用CRLF为结束行导出tutorial_tbl 为CSV格式表格，使用以下语句

```mysql
SELECT * FROM passwd INTO OUTFILE 'C:\tutorials.txt'
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
LINES TERMINATED BY '\r\n';
```

使用FIELDS子句来描述一行内字段的特征，LINES子句指定的行结束序列

从数据库test中的tutorials_tbl表转储到一个文件在C:\tmp目录

```
mysqldump -u root -p --no-create-info \
            --tab=c:\tmp TEST tutorials_tbl
```

以SQL格式的表和数据库导出到一个文件

```
mysqldump -u root -p test tutorials_tbl > dump.txt
mysqldump -u root -p test > database_dump.txt
mysqldump -u root -p --all-databases > database_dump.txt
mysql -u root -p database_name < dump.txt
```

mysqldump输出直接通过网络到远程MySQL服务器

```
mysqldump -u root -p database_name \
       | mysql -h other-host.com database_name
```

命令mysqldump的一半连接到本地服务器，并转储输出写入管道。另一半MySQL连接到other-host.com远程MySQL服务器。它读取管道输入并发送每条语句到other-host.com服务器

使用LOAD DATA导入数据

```mysql
LOAD DATA LOCAL INFILE 'C:\dump.txt' INTO TABLE mytbl(b,c,a);
```

使用mysqlimport导入数据

```
mysqlimport -u root -p --local database_name dump.txt
mysqlimport -u root -p --local --columns=b,c,a \
    database_name dump.txt
mysqlimport -u root -p --local --fields-terminated-by=":" \
   --lines-terminated-by="\r\n"  database_name dump.txt
```

进入MySQL目录下的bin文件夹

```
mysqldump -h localhost -u root -p test > G:\arcgisworkspace\zypdoc\test.sql

mysql> source G:\arcgisworkspace\zypdoc\test.sql 
```

### 获取服务器元数据

| 命令               |               描述               |
| ------------------ | :------------------------------: |
| SELECT VERSION( )  |         服务器版本字符串         |
| SELECT DATABASE( ) | 当前数据库名称(如果没有，则为空) |
| SELECT USER( )     |            当前用户名            |
| SHOW STATUS        |          服务器状态指示          |
| SHOW VARIABLES     |          服务器配置变量          |

LAST_INSERT_ID( )是一个SQL函数，用来查看新增的自增字段值