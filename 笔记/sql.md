sql语句都是参照数据库系统概论书中的

sql练习题：https://blog.csdn.net/mrbcy/article/details/68965271

### 创建模式

```sql
CREATE SCHEMA "S-T" AUTHORIZATION WANG(用户名)；
```

可以不用模式名，隐含为用户名。也可以在创建模式的时候在其中定义一个表

删除模式

```sql
DROP SCHEMA <模式名><CASCADE|RESTRICT>；
```

### 创建和删除数据库

```sql
CREATE DATABASE db;
DROP DATABASE db;
```

### 创建表

```sql
CREATE TABLE Student(Sno CHAR(9) PRIMARY KEY,
                     Sname CHAR(9) UNIQUE,  
                     Ssex CHAR(2),  
                     Sage SMALLINT,  
                     Sdept CHAR(20)
                    );
                    
CREATE  TABLE Course(Cno CHAR(4) PRIMARY KEY,  
                     Cname CHAR(4) NOT NULL,  
                     Cpno  CHAR(4), 
                     Ccredit SMALLINT,  
                     FOREIGN KEY(Cno) REFERENCES Course(Cno)
                     );
```

#### 显示搜索路径

```sql
SHOW serach_path; 
```

默认值为 $user，PUBLIC

#### 修改基本表

```sql
ALTER TABLE Student 
ADD S_entrance DATE;

ALTER TABLE Student 
ALTER COLUMN Sage INT;

ALTER TABLE Course 
ADD UNIQUE(Cname);
```

删除基本表

```sql
DROP TABLE <表名> [RESTRICT|CASCADE]；
```

### 创建视图

```sql
CREATE VIEW IS_Student 
AS SELECT Sno,Sname,Sage 
FROM Student 
WHERE  Sdept='IS';
```

可在最后加上 WITH CHECK OPTION，对视图进行插入修改删除操作时会自动加上 Sdept='IS'

```sql
SELECT * 
FROM (SELECT Sno,AVG(Grade) 
      FROM SC 
      GROUP BY Sno)AS S_G(Sno,Gavg) 
WHERE Gavg>=90;
```

子查询生成一个派生表S_C

### 建立索引

```sql
CREATE UNIQUE INDEX Stusno ON Student(Sno);

CREATE UNIQUE INDEX SCno ON SC(Sno ASC,Cno DESC);
```

[ CLUSTER ]为聚簇索引，默认为ASC

修改索引

```sql
ALTER INDEX SCno RENAME TO SCSno;
```

删除索引

```sql
DROP INDEX Stusname ON tablename;
```

从数据字典中删除

### 数据查询

```sql
SELECT Sname,Sno,Sdept 
FROM Student;

SELECT * 
FROM Student;

SELECT Sname,'Year of Birth:',2014-Sage BIRTHDAY,LOWER(Sdept) FROM Student;

SELECT DISTINCT Sno 
FROM SC;

SELECT TOP 5 FROM Student;（mysql不支持）

SELECT * FROM students WHERE class='95033' 
union 
SELECT * FROM students WHERE class='95031';
```

默认地，UNION 操作符选取不同的值。如果允许重复的值，请使用 UNION ALL。替代 DISTINCT 方法是添加 GROUP BY 子句列名称到选择的列

```sql
SELECT last_name, first_name
FROM person_tbl
GROUP BY (last_name, first_name);
```

从表中删除重复记录的一个简单的方法就是添加索引(INDEX) 或主键(PRIMAY KEY)到该表

```sql
ALTER IGNORE TABLE person_tbl
ADD PRIMARY KEY (last_name, first_name);
```

比较：<>，!>，!<，NOT+所有比较符，BETWEEN AND，LIKE，IS NULL（IS不能用 = 代替）

```sql
SELECT Sname,Ssex 
FROM Student 
WHERE Sdept IN('CS','MA','IS');

SELECT *  
FROM Student 
WHERE Sno LIKE '201215121';
```

LIKE 可以换成 =，匹配串可以包括 %，表示任意长度的字符串，_ 代表单个字符，如果字符串本身就包含有通配符 % 和_，使用ESCAPE  '<换码字符>'，比如查询 DB_Design 课程的课程号和学分

```sql
SELECT Cno,Ccredit FROM Cource WHERE Cname LIKE 'DB\_Design' ESCAPE '\';
```

```sql
SELECT Sno,Grade 
FROM SC 
WHERE Cno='3' 
ORDER BY Grade DESC;
```

默认按升序排，含空值的元祖最后显示，由具体系统实现来决定

```sql
SELECT COUNT(DISTINCT Sno) 
FROM SC; 
```

COUNT(*) 不跳过空值，也可以用 COUNT(1)，Count（列名）只包括列名那一项，会忽略列值为空的计数。WHERE子句不能使用聚集函数，只能用于 SELECT 和 GROUP BY 中的HAVING，WHERE 作用于基本表或视图，而 HAVING 作用于组

```sql
SELECT Sno,AVG(Grade) 
FROM SC 
GROUP BY Sno 
Having count(Grade)>=90;
```

### 连接查询

等值连接 

```sql
SELECT Student.*,SC.* 
FROM Student,SC 
WHERE Student.Sno=SC.Sno;
```

自然连接

```sql
SELECT Student.Sno,Sname,Ssex,Sage,Sdept,Cno,Grade 
FROM Student,SC
WHERE Student.Sno=SC.Sno;
```

去掉重复列，也叫做内连接

自身连接 

```sql
SELECT FIRST.Cno,SECOND.Cpno 
FROM Course FIRST,Course SECOND 
WHERE FIRSRT.Cpno=SECOND.Cno;
```

外连接 

```sql
SELECT Student.Sno,Sname,Ssex,Sage,Sdept,Cno,Grade 
FROM Student LEFT OUTER JOIN SC ON(Student.Sno=SC.Cno);
```

(Student.Sno=SC.Cno) 改为 USING(Sno)，去掉结果的重复值

### 嵌套查询

```sql
SELECT Sno,Sname,Sdept 
FROM Sudent 
WHERE Sdept IN (SELECT Sdept 
                FROM Student 
                WHERE Sname='刘晨');
```

等于下面的自身连接：

```sql
SELECT S1.Sno,S1.Sname,S1.Sdept 
FROM Sudent S1,Student S2 
WHERE S1.Sdept=S2.Sdept AND S2.Sname='刘晨'；
```

子查询的 SELECT 语句不能使用 ORDER BY，它只对最终结果排序。子查询的查询条件不依赖于父查询，称为不相关子查询

相关子查询

```sql
SELECT Sno,Cno 
FROM SC x 
WHERE Grade>(SELECT AVG(Grade) 
             FROM SC y 
             WHERE y.Sno=x.Sno);
```

### 数据更新

插入元组

```sql
INSERT 
INTO Student(Sno,Sname,Ssex,Sdept,Sage) 
VALUES('201215128','陈东','男','IS',18);
```

或者不用写属性列

```sql
INSERT 
INTO Dept_age(Sdept,Avg_age) 
SELECT Sdept,AVG(Sage) 
FROM Student 
GROUP BY Sdept;
```

空值与另一个值的比较运算为 UNKNOW

修改数据

```sql
UPDATE Student 
SET Sage=22 
WHERE Sno='201215121';
```

删除数据

```sql
DELETE FROM SC;
```

### 授权与收回

把查询和修改学号权限授给用户 U1

```sql
GRANT UPDATE(Sno),SELECT 
ON TABLE Student 
TO U1 
WITH GRANT OPTION;
```

权限可以为 ALL PRIVILEGES，用户可以为 PUBLIC

U1可以将权限传给U2

```sql
GRANT SELECT 
ON TABLE Student 
TO U2;
```

收回权限

```sql
REVOKE SELECT 
ON TABLE Student 
FROM U1 CASCADE;
```

创建角色

角色是权限的集合

```sql
CREATE ROLE R1;
GRANT SELECT ON TABLE Student TO R1;
GRANT R1 TO 王平;
```

### 实体和参照完整性

```sql
CREATE  TABLE SC(Sno CHAR(9) NOT NULL, 
                 Co CHAR(4) NOT NULL, 
                 Grade SMALLINT,  
                 PRIMARY KEY(Sno,Cno),  /*表级实体完整性*/ 
                 FOREIGN KEY(Sno) REFERENCES Student(Sno),  /*表级参照完整性*/ 
                 FOREIGN KEY(Cno) REFERENCES Course(Cno)
                );
```

#### 用户定义完整性

```sql
CREATE TABLE Student(Sno CHAR(9) PRIMARY KEY,  
                     Sname CHAR(8) NOT NULL, 
                     Ssex CHAR(2) CHECK (Ssex IN ('男','女')), 					
                     Sage SMALLINT,  
                     Sdept CHAR(20)
                    );
                    
CREATE TABLE Student(Sno CHAR(9), 
                     Sname CHAR(8) NOT NULL,  
                     Ssex CHAR(2),  
                     Sage  SMALLINT,  
                     Sdept CHAR(20),  
                     PRIMARY KEY(Sno), 
                     CHECK (Ssex IN ('男','女') OR Sname NOT LIKE 'Ms.%')
                    );
```

#### 完整性约束命名子句

```sql
CREATE TABLE Student(
    Sno NUMERIC(6) CONSTRAINT C1 CHECK (Sno BETWEEN 90000 AND 99999), 
    Sname CHAR(20) CONSTRAINT C2 NOT NULL, 
    Sage NUMERIC(3) CONSTRAINT C3  CHECK (Sage < 30), 
    Ssex CHAR(2) CONSTRAINT C4 CHECK (Ssex IN  ('男','女')),
    CONSTRAINT StudentKey PRIMARY KEY(Sno)
    ); 
```

修改表中的完整性限制

```sql
ALTER TABLE Student 
DROP CONSTRAINT C1;

ALTER TABLE Student 
ADD CONSTRAINT C1 CHECK (Sno BETWEEN 900000 AND 9999999);
```

### 创建断言

限制数据库课程最多60名同学选修

```sql
CREATE ASSERTION ASSE_SC_DB_NUM CHECK ( 60>=( 
	SELECT count(*) 
	FROM Course,SC 
	WHERE SC.Cno=Course.Cno AND Course.Cname='SHUJUKU ')
	);
```

### 创建触发器

```sql
CREATE TRIGGER SC_T 
AFTER UPDATE OF Grade ON SC 
REFERENCES OLDROW AS OldTuple, NEWROW AS NewTuple 
FOR EACH ROW 
WHEN (NewTuple.Grade >= 1.1 * OldTuple.Grade) 
   INSERT INTO SC_U(Sno, Cno, OldGrade, NewGrade) 
   VALUES(OldTuple.Sno, OldTuple.Cno, OldTuple.Grade, NewTuple.Grade);

CREATE TRIGGER Insert_Or_Update_Sal 
BEFORE INSERT OR UPDATE ON Teacher  
REFERENCES NEWROW AS NewTuple 
FOR EACH ROW 
BEGIN 
	IF(newtuple.Job='教授') AND (newtuple.Sal<4000)         #Sal为工资
	THEN newtuple.Sal :=4000; 
	END IF;  
END;
```

REFERENCES 指出引用的变量 OLDROW 和 NEWROW，FOR EACH { ROW | STATEMENT} 定义触发器的类型，分为行级触发器（执行多次触发动作体）和语句级触发器（执行一次）

删除触发器

```sql
DROP TRIGGER SC_T ON SC;
```

