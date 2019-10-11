shell编程100例：https://blog.csdn.net/yugemengjing/article/details/82469785

### 运行 Shell 脚本

#### 1、作为可执行程序

将上面的代码保存为 test.sh，并 cd 到相应目录：

```
chmod +x ./test.sh  #使脚本具有执行权限
./test.sh  #执行脚本
```

直接写 test.sh，linux 系统会去 PATH 里寻找有没有叫 test.sh 的，而只有 /bin, /sbin, /usr/bin，/usr/sbin 等在 PATH 里

#### 2、作为解释器参数

这种运行方式是，直接运行解释器，其参数就是 shell 脚本的文件名，如：

```
/bin/sh test.sh
/bin/php test.php
```

### Shell变量

定义变量时，变量名不加美元符号；变量名和等号之间不能有空格；首个字符不能以数字开头；不能使用标点符号

循环输出单词

```shell
for skill in Ada Coffe Action Java; do
    echo "I am good at ${skill}Script"
done
```

使用 readonly 命令可以将变量定义为只读变量；使用 unset 命令可以删除变量，unset 命令不能删除只读变量

```shell
your_name="qinjx"
echo $your_name
echo ${your_name}
readonly your_name
unset your_name
```

#### 字符串

单引号字符串中的变量是无效的，单引号字串中不能出现单独一个的单引号（对单引号使用转义符后也不行），但可成对出现，作为字符串拼接使用；双引号里可以有变量，双引号里可以出现转义字符

```shell
str="Hello, I know you are \"$your_name\"! \n"
echo -e $str
```

拼接字符串

```shell
# 使用双引号拼接
greeting="hello, "$your_name" !"
greeting_1="hello, ${your_name} !"
echo $greeting  $greeting_1
# 使用单引号拼接
greeting_2='hello, '$your_name' !'
greeting_3='hello, ${your_name} !'
echo $greeting_2  $greeting_3
```

从字符串第 **2** 个字符开始截取 **4** 个字符

```shell
string="runoob is a great site"
echo ${#string} #输出 23
echo ${string:1:4} # 输出 unoo
```

查找字符 **i** 或 **o** 的位置(哪个字母先出现就计算哪个)

```sh
echo `expr index "$string" io`  # 输出 4，`是反引号
```

### Shell 数组

bash支持一维数组（不支持多维数组），并且没有限定数组的大小，在 Shell 中，用括号来表示数组，数组元素用空格符号分割开

```shell
array_name=(value0 value1 value2 value3) #用双引号括起来也行
valuen=${array_name[n]}
echo ${array_name[@]} # 获取所有元素
length=${#array_name[@]} # 取得数组元素的个数，或者下面
length=${#array_name[*]}
lengthn=${#array_name[n]} # 取得数组单个元素的长度
```

### 多行注释

```shell
:<<EOF
注释内容...
注释内容...
注释内容...
EOF
```

EOF可以换成其它符号，如单引号`'`，`！`

### 传递参数

我们可以在执行 Shell 脚本时，向脚本传递参数，脚本内获取参数的格式为：**$n**，其中 **$0** 为执行的文件名

| 参数处理 | 说明                                                         |
| :------- | :----------------------------------------------------------- |
| $#       | 传递到脚本的参数个数                                         |
| $*       | 以一个单字符串显示所有向脚本传递的参数。 如"$*"用「"」括起来的情况、以"$1 $2 … $n"的形式输出所有参数。 |
| $$       | 脚本运行的当前进程ID号                                       |
| $!       | 后台运行的最后一个进程的ID号                                 |
| $@       | 与$*相同，但是使用时加引号，并在引号中返回每个参数。 如"$@"用「"」括起来的情况、以"$1" "$2" … "$n" 的形式输出所有参数。 |
| $-       | 显示Shell使用的当前选项，与[set命令](https://www.runoob.com/linux/linux-comm-set.html)功能相同。 |
| $?       | 显示最后命令的退出状态。0表示没有错误，其他任何值表明有错误。 |

$* 与 $@ 区别：只有在双引号中体现出来。假设在脚本运行时写了三个参数 1、2、3，，则 " * " 等价于 "1 2 3"（传递了一个参数），而 "@" 等价于 "1" "2" "3"（传递了三个参数）

### Shell 基本运算符

```shell
val=`expr 2 + 2`
`expr $a \* $b`
`expr $b / $a`
[ $a == $b ]
echo "两数之和为 : $val"
```

注意：表达式和运算符之间要有空格，条件表达式要放在方括号之间，并且要有空格

```shell
a=10
b=20
if [ $a == $b ]
then
   echo "a 等于 b"
fi
```

#### 关系运算符

关系运算符只支持数字，不支持字符串，除非字符串的值是数字

- -eq：相等 ，-ne：不相等
- -gt：大于，-lt：不大于
- -ge：大于等于，-le：小于等于

布尔运算符：-o：或运算，-a：与运算，-！：非运算

逻辑运算符：&&，||

```shell
if [ $a -ne $b ]
then
   echo "$a -ne $b: a 不等于 b"
else
   echo "$a -ne $b : a 等于 b"
fi
```

#### 字符串运算符

- -z：检测字符串长度是否为0
- -n：检测字符串长度是否不为0
- -$：检测字符串是否为空

#### 文件测试运算符

- -b file：检测文件是否是块设备文件
- -c：检测文件是否是字符设备文件
- -d：检测文件是否是目录
- -f：检测文件是否是普通文件
- -g：检测文件是否设置了 SGID 位
- -k：检测文件是否设置了粘着位(Sticky Bit)
- -p：检测文件是否是有名管道
- -u：检测文件是否设置了 SUID 位
- -r：检测文件是否可读（还有w，r）
- -s：检测文件是否为空
- -e：检测文件（包括目录）是否存在
- -S：判断某文件是否 socket
- -L：检测文件是否存在并且是一个符号链接

```shell
file="/var/www/runoob/test.sh"
if [ -r $file ]
then
   echo "文件可读"
else
   echo "文件不可读"
fi
```

### echo命令和printf命令

read 命令从标准输入中读取一行,并把输入行的每个字段的值指定给 shell 变量

```
#!/bin/sh
read name 
echo "$name It is a test"
```

这里的双引号完全可以省略， echo 会自动添加换行符

```
echo -e "OK! \n" # -e 开启转义
echo -e "OK! \c" # -e 开启转义 \c 不换行
echo "It is a test" > myfile # 显示结果定向至文件
echo `date` # 显示命令执行结果
```

原样输出字符串，不进行转义或取变量(用单引号)

```
echo '$name\"'
$name\"
```

```
printf "%-10s %-8s %-4s\n" 姓名 性别 体重kg
# 格式只指定了一个参数，但多出的参数仍然会按照该格式输出
printf %s abc def 
# 没有引号也可以输出
printf %s abcdef 
# 如果没有 arguments，那么 %s 用NULL代替，%d 用 0 代替
printf "%s and %d \n" 
```

-表示左对齐，超过也会将内容全部显示出来

#### printf的转义序列

| 序列  | 说明                                                         |
| :---- | :----------------------------------------------------------- |
| \a    | 警告字符，通常为ASCII的BEL字符                               |
| \b    | 后退                                                         |
| \c    | 抑制（不显示）输出结果中任何结尾的换行字符（只在%b格式指示符控制下的参数字符串中有效），而且，任何留在参数里的字符、任何接下来的参数以及任何留在格式字符串中的字符，都被忽略 |
| \f    | 换页（formfeed）                                             |
| \n    | 换行                                                         |
| \r    | 回车（Carriage return）                                      |
| \t    | 水平制表符                                                   |
| \v    | 垂直制表符                                                   |
| \\    | 一个字面上的反斜杠字符                                       |
| \ddd  | 表示1到3位数八进制值的字符。仅在格式字符串中有效             |
| \0ddd | 表示1到3位的八进制值字符                                     |

```
printf "a string, no processing:<%b>\n" "A\nB"
a string, no processing:<A
B>

printf "www.runoob.com \a"
www.runoob.com $                  #不换行
```

### Shell test 命令

Shell中的 test 命令用于检查某个条件是否成立，它可以进行数值、字符和文件三个方面的测试

```
num1=100
num2=100
if test $[num1] -eq $[num2]
then
    echo '两个数相等！'
else
    echo '两个数不相等！'
fi
```

代码中的 [] 执行基本的算数运算

### Shell 流程控制

在sh/bash里，如果else分支没有语句执行，就不要写这个else

```shell
if [ $(ps -ef | grep -c "ssh") -gt 1 ]; then echo "true"; fi
```

#### if else-if else

```
a=10
b=20
if [ $a == $b ]
then
   echo "a 等于 b"
elif [ $a -gt $b ]
then
   echo "a 大于 b"
elif [ $a -lt $b ]
then
   echo "a 小于 b"
else
   echo "没有符合的条件"
fi
```

#### for 循环

```
for loop in 1 2 3 4 5
do
    echo "The value is: $loop"
done
```

#### while 语句

```
int=1
while(( $int<=5 ))
do
    echo $int
    let "int++"
done

echo '按下 <CTRL-D> 退出'
echo -n '输入你最喜欢的网站名: '
while read FILM
do
    echo "是的！$FILM 是一个好网站"
done
```

以上实例使用了 Bash let 命令，它用于执行一个或多个表达式，变量计算中不需要加上 $ 来表示变量

#### 无限循环

```
while :
do
    command
done

while true
do
    command
done

for (( ; ; ))
```

#### until 循环

until 循环执行一系列命令直至条件为 true 时停止

```
a=0
until [ ! $a -lt 10 ]
do
   echo $a
   a=`expr $a + 1`
done
```

#### Case

```
echo '输入 1 到 4 之间的数字:'
echo '你输入的数字为:'
read aNum
case $aNum in
    1)  echo '你选择了 1'
    ;;
    2)  echo '你选择了 2'
    ;;
    3)  echo '你选择了 3'
    ;;
    4)  echo '你选择了 4'
    ;;
    *)  echo '你没有输入 1 到 4 之间的数字'
    ;;
esac
```

#### 跳出循环

break命令允许跳出所有循环（终止执行后面的所有循环）

```
while :
do
    echo -n "输入 1 到 5 之间的数字:"
    read aNum
    case $aNum in
        1|2|3|4|5) echo "你输入的数字为 $aNum!"
        ;;
        *) echo "你输入的数字不是 1 到 5 之间的! 游戏结束"
            break
        ;;
    esac
done
```

continue命令与break命令类似，只有一点差别，它不会跳出所有循环，仅仅跳出当前循环

### Shell 函数

```
funWithReturn(){
    echo "这个函数会对输入的两个数字进行相加运算..."
    echo "输入第一个数字: "
    read aNum
    echo "输入第二个数字: "
    read anotherNum
    echo "两个数字分别为 $aNum 和 $anotherNum !"
    return $(($aNum+$anotherNum))
}
funWithReturn
echo "输入的两个数字之和为 $? !"
```

函数返回值在调用该函数后通过 $? 来获得

注：

- 可以带function fun() 定义，也可以直接fun() 定义,不带任何参数
- 参数返回，可以显示加：return 返回，如果不加，将以最后一条命令运行结果，作为返回值。 return后跟数值n(0-255）
- 所有函数在使用前必须定义。这意味着必须将函数放在脚本开始部分，直至shell解释器首次发现它时，才可以使用。调用函数仅使用其函数名即可

#### 函数参数

在Shell中，调用函数时可以向其传递参数。在函数体内部，通过 $n 的形式来获取参数的值

```
funWithParam(){
    echo "第一个参数为 $1 !"
    echo "第二个参数为 $2 !"
    echo "第十个参数为 $10 !"
    echo "第十个参数为 ${10} !"
    echo "第十一个参数为 ${11} !"
    echo "参数总数有 $# 个!"
    echo "作为一个字符串输出所有参数 $* !"
}
funWithParam 1 2 3 4 5 6 7 8 9 34 73
```

注意，$10 不能获取第十个参数，获取第十个参数需要${10}。当n>=10时，需要使用${n}来获取参数

### Shell 文件包含

```shell
. filename   # 注意点号(.)和文件名中间有一空格
source filename
```

### Shell 输入/输出重定向

| 命令            | 说明                                               |
| :-------------- | :------------------------------------------------- |
| command > file  | 将输出重定向到 file。                              |
| command < file  | 将输入重定向到 file。                              |
| command >> file | 将输出以追加的方式重定向到 file。                  |
| n > file        | 将文件描述符为 n 的文件重定向到 file。             |
| n >> file       | 将文件描述符为 n 的文件以追加的方式重定向到 file。 |
| n >& m          | 将输出文件 m 和 n 合并。                           |
| n <& m          | 将输入文件 m 和 n 合并。                           |
| << tag          | 将开始标记 tag 和结束标记 tag 之间的内容作为输入   |

需要注意的是文件描述符 0 通常是标准输入（STDIN），1 是标准输出（STDOUT），2 是标准错误输出（STDERR）

#### 输出重定向

执行下面的 who 命令，它将命令的完整的输出重定向在用户文件中(users)

```
$ who > users
$ echo "菜鸟教程：www.runoob.com" > users
$ echo "菜鸟教程：www.runoob.com" >> users
```

#### 输入重定向

统计 users 文件的行数,执行以下命令

```
$ wc -l users
       2 users
       
$  wc -l < users
       2 
```

注意：上面两个例子的结果不同：第一个例子，会输出文件名；第二个不会，因为它仅仅知道从标准输入读取内容

同时替换输入和输出，执行command1，从文件infile读取内容，然后将输出写入到outfile中

```
command1 < infile > outfile
```

```shell
$ command 2 > file    #stderr 重定向到 file
$ command > file 2>&1   #将 stdout 和 stderr 合并后重定向到 file
```

#### Here Document

Here Document 是 Shell 中的一种特殊的重定向方式，用来将输入重定向到一个交互式 Shell 脚本或程序

```
command << delimiter
    document
delimiter
```

它的作用是将两个 delimiter 之间的内容(document) 作为输入传递给 command

注意：

- 结尾的delimiter 一定要顶格写，前面不能有任何字符，后面也不能有任何字符，包括空格和 tab 缩进。
- 开始的delimiter前后的空格会被忽略掉

```
$ wc -l << EOF
    欢迎来到
    菜鸟教程
    www.runoob.com
EOF
3          # 输出结果为 3 行
$
```

### /dev/null 文件

如果希望执行某个命令，但又不希望在屏幕上显示输出结果，那么可以将输出重定向到 /dev/null。/dev/null 是一个特殊的文件，写入到它的内容都会被丢弃；如果尝试从该文件读取内容，那么什么也读不到。但是 /dev/null 文件非常有用，将命令的输出重定向到它，会起到"禁止输出"的效果

如果希望屏蔽 stdout 和 stderr，可以这样写

```
$ command > /dev/null 2>&1
```