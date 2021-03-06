### 概述

MATLAB(矩阵实验室)是数字计算，可视化和编程的第四代高级编程语言和交互式环境。MATLAB是由MathWorks开发的。它允许矩阵操纵，绘制功能和数据、创建用户界面、与其他语言编写的程序(包括C语言，C++，Java和FORTRAN)进行交互、分析数据、实现和开发算法，并创建模型和应用程序。它有许多内置命令和数学函数，可以帮助您进行数学计算，生成图形和执行数值方法。

MATLAB用于计算数学的各个方面，常用数学计算方法有处理矩阵和数组、2D和3D绘图和图形、线性代数、代数方程、非线性函数、统计、数据分析、微积分和微分方程、数值计算、积分、变换、曲线拟合和各种其他特殊功能。MATLAB 也是广泛应用于物理、化学、数学和所有工程流领域的科学与工程计算工具，包括信号处理和通信、图像和视频处理、控制系统、测试和测量、计算财务和计算生物学

#### 特点

- 它是数字计算，可视化和应用程序开发的高级语言。
- 它还为迭代探索，设计和解决问题提供了一个交互式环境。
- 它为线性代数、统计学、傅里叶分析、滤波、优化、数值积分和求解常微分方程提供了广泛的数学函数库。
- 它提供内置的图形，用于可视化数据和工具，用于创建自定义绘图。
- MATLAB 编程接口提供了开发工具，以提高代码质量的可维护性并最大限度提高性能。
- 它提供使用自定义图形界面构建应用程序的工具。
- 它提供了基于 MATLAB 的算法与外部应用程序和语言(如C语言，Java，.NET和Microsoft Excel)集成的功能

#### 下载安装

 教程地址`https://www.yiibai.com/matlab/matlab_environment.html`

#### 软件面板介绍

- **当前文件夹** - 此面板允许访问项目文件夹和文件；
- **命令窗口** - 这是在命令行中可以输入命令的主要区域，它由命令提示符(`>>`)指示；
- **工作区** - 工作区显示从文件创建和/或导入的所有变量；
- **命令历史** - 此面板显示或重新运行在命令行中输入的命令；

### 基础语法

 MATLAB 环境的行为就像一个超级复杂的计算器。可以在`>>`命令提示符下输入命令 

```matlab
>> sin(pi /2)      % 结果 1
>> 7/0      % 结果 Inf（∞）
>> save mymat      % 保存变量	
>> load mymat      % 加载变量
```

 MATLAB 为某些数学符号提供了一些特殊表达式 ，`.Nan`代表“非数字” ， `i`(和`j`)为`√-1` 。 分号(`;`)表示结束语句，如果要抑制和隐藏表达式的MATLAB输出，请在表达式后添加分号。百分比符号(`%`)用于指示注释行，还可以使用块注释运算符`%{`和`%}`编写一段注释。MATLAB编辑器包括工具和上下文菜单项，以帮助添加，删除或更改注释的格式

#### 常用的运算符和特殊字符 

`.*` 阵列乘法运算符，`^` 标量和矩阵求幂运算符，`.^` 阵列求幂运算符，`\` 左除法运算符，`/` 右除法运算符，`.\` 阵列左除法运算符，`./` 右除法运算符，`:` 冒号，生成规则间隔的元素，并表示整个行或列， `[ ]` 括号，罩住阵列元素，`…` 省略号，行连续运算符，`;` 分号，分隔列并抑制输出显示，`%` 百分号，指定一个注释并指定格式，`_` 引用符号和转置运算符，`._` 非共轭转置运算符

`ans` 最近的回应/回答，`eps` 浮点精度精度，`i`,`j` 虚构单位`√-1`，`Inf` 无穷  `NaN` 未定义的数值结果(非数字)，`pi` 数字`π`

冒号(`:`)是 MATLAB 中最有用的操作符之一，它用于创建向量，下标数组，并为迭代指定。 可以使用冒号运算符创建索引向量，以选择数组的行，列或元素。 

|     格式     |                             目的                             |
| :----------: | :----------------------------------------------------------: |
|   `A(:,j)`   |                        是`A`的第`j`列                        |
|   `A(i,:)`   |                        是`A`的第`i`行                        |
|   `A(:,:)`   |           是等效的二维数组。对于矩阵，与`A`相同。            |
|   `A(j:k)`   |              是`A(j)`, `A(j+1)`,`...`,`A(k)`列               |
|  `A(:,j:k)`  |           是`A(:,j)`, `A(:,j+1)`,`...`,`A(:,k)`列            |
|  `A(:,:,k)`  |                   是三维数组`A`的第`k`页？                   |
| `A(i,j,k,:)` | 是四维数组`A`中的向量。向量包括`A(i，j，k，1)`，`A(i，j，k，2)`等 |
|    `A(:)`    | 是`A`的所有要素，会形成以每列顺序组合的单列。在赋值语句的左侧，`A(:)`填充`A`，从之前保留其形状。在这种情况下，右侧必须包含与`A`相同数量的元素? |

示例代码

```matlab
1:10			% 创建一个包含从`1`到`10`的整数的行向量
100: -5: 50			% 指定一个增量值
0:pi/8:pi
A = [1 2 3 4; 4 5 6 7; 7 8 9 10]
A(:,2)			% A的第2列
A(:,2:3)		% A的第2和第3列
A(2:3,2:3)		% 按索引值配对
```

#### 变量

在MATLAB环境中，每个变量都是数组或矩阵。比如`x=3`会创建一个名为`x`的`1×1`矩阵，并将值`3`存储在其元素中。当变量输入到系统中，可以在接下来代码中引用，变量在使用前必须有值。当表达式返回未分配给任何变量的结果时，系统将其分配给名为`ans`的变量，可以使用这个变量

MATLAB 是区分大小写的编程语言，变量名称由一个字母组成，后跟任意数字的字母，数字或下划线。变量名称可以是任意长度，但MATLAB只使用前`N`个字符，其中N由函数`namelengthmax`给出。 

```matlab
x=3
sqrt(99)
99.499/ans
clear x
clear
% 长任务
initial_velocity = 0;
acceleration = 9.8;
time = 20;
final_velocity = initial_velocity ...
    + acceleration * time
% 更精确
format long			% 结果 17.231981640639408
format short		% 结果 17.2320
x = 7 + 10/3 + 5 ^ 1.2
format bank			% 结果 1064.70
daily_wage = 177.45;
weekly_wage = daily_wage * 6
format short e			% 结果 2.2922e+01
4.678 * 4.9
format long e			% 结果 3.141592653589793e+00
x = pi
format rat			% 结果 2063/90
4.678 * 4.9
```

- `who`命令显示使用过的所有变量名，`whos`命令显示更多的变量信息，包括当前在内存中的变量、每个变量的类型、每个变量的内存分配和是否是复合的变量 ；
- `save`命令用于在工作空间中保存所有变量，它在当前目录中，以`.mat`作为扩展名的文件。可以随时使用`load`命令重新加载文件；
- `clear`清除命令从存储器中删除所有(或指定的)变量；
- 长任务可以通过使用省略号(`...`)扩展到另一行；
- `format long`命令显示十进制后的`16`位数字，`format long`命令显示十进制后的`16`位数字。默认情况下，MATLAB 显示四位小数位数，称为短格式。`format bank`命令将数字舍入到小数点后两位，`format short e`命令以指数形式显示四位小数加上指数，`format long e`命令允许以指数形式显示十六位小数加上指数，`format rat`命令给出计算结果最接近的合理表达式 

**注**： shift 加回车可以换行； exp(1) 就等于 e，exp(- 12.6570) 等于 3.1852e-06 

### 命令

#### 管理会话

|   命令    |          描述说明          |
| :-------: | :------------------------: |
|   `clc`   |        清除命令窗口        |
|  `clear`  |      从内存中删除变量      |
|  `exist`  |   检查文件或变量是否存在   |
| `global`  |     声明变量为全局变量     |
|  `help`   |        搜索帮助主题        |
| `lookfor` |    搜索帮助关键字的条目    |
|  `quit`   |        停止 MATLAB         |
|   `who`   |        列出当前变量        |
|  `whos`   | 列出当前变量(显示详细信息) |

#### 使用系统

MATLAB提供了各种有用的命令来处理系统，比如将工作区中的当前工作保存为文件，稍后加载文件。它还为其他系统相关活动提供各种命令，如显示日期，列出目录中的文件，显示当前目录等。

|   命令    |             描述说明             |
| :-------: | :------------------------------: |
|   `cd`    |    更改当前目录(进入指定目录)    |
|  `date`   |           显示当前日期           |
| `delete`  |             删除文件             |
|  `diary`  |      打开/关闭日记文件记录       |
|   `dir`   |     列出当前目录下的所有文件     |
|  `load`   |       从文件加载工作区变量       |
|  `path`   |           显示搜索路径           |
|   `pwd`   |           显示当前目录           |
|  `save`   |    将工作空间变量保存在文件中    |
|  `type`   |          显示文件的内容          |
|  `what`   | 列出当前目录中的所有 MATLAB 文件 |
| `wklread` |      读取`.wk1`电子表格文件      |

#### 输入和输出

|   命令    |           描述说明           |
| :-------: | :--------------------------: |
|  `disp`   |    显示数组或字符串的内容    |
| `fscanf`  |     从文件读取格式化数据     |
| `format`  |       控制屏幕显示格式       |
| `fprintf` | 对屏幕或文件执行格式化的写入 |
|  `input`  |      显示提示并等待输入      |
|    `;`    |         禁止打印显示         |

`fscanf`和`fprintf`命令的行为类似于C语言中的`scanf`和`printf`函数。它们支持以下格式代码 

| 命令 |           描述说明           |
| :--: | :--------------------------: |
| `%s` |        格式化为字符串        |
| `%d` |     格式化为字符串整数值     |
| `%f` |        格式化为浮点值        |
| `%e` |  格式化为科学记数法的浮点值  |
| `%g` | 格式最紧凑的形式：`%f`或`%e` |
| `\n` |  在输出字符串中插入一个换行  |
| `\t` |   在输出字符串中插入制表符   |

格式化(`format`)函数具有以下用于数字显示的形式 

|       命令       |         描述说明         |
| :--------------: | :----------------------: |
|  `format short`  |    4位十进制数(默认)     |
|  `format long`   |         16位数字         |
| `format short e` |      5位数加上指数       |
| `format long e`  |       16位加上指数       |
|  `format bank`   |      两位十进制数字      |
|    `format +`    |        正，负或零        |
|   `format rat`   |         有理近似         |
| `format compact` |      禁止一些换行符      |
|  `format loose`  | 重置为较不紧凑的显示模式 |

#### 向量，矩阵和数组

|    命令    |         描述说明         |
| :--------: | :----------------------: |
|   `cat`    |         连接数组         |
|   `find`   |    查找非零元素的索引    |
|  `length`  |       计算元素数量       |
| `linspace` |    创建规则间隔的向量    |
| `logspace` |     创建对数间隔向量     |
|   `max`    |      返回最大的元素      |
|   `min`    |      返回最小的元素      |
|   `prod`   |        产生的每列        |
| `reshape`  |         改变大小         |
|   `size`   |       计算数组大小       |
|   `sort`   |      对每列进行排序      |
|   `sum`    |      对每列进行求和      |
|   `eye`    |     创建一个单位矩阵     |
|   `ones`   |       创建一个数组       |
|  `zeros`   |     创建一个零的数组     |
|  `cross`   |      计算矩阵交叉积      |
|   `dot`    |       计算矩阵点积       |
|   `det`    |     计算数组的行列式     |
|   `inv`    |      计算矩阵的倒数      |
|   `pinv`   |      计算矩阵的伪逆      |
|   `rank`   |       计算矩阵的秩       |
|   `rref`   |    计算简化行阶梯形式    |
|   `cell`   |      创建单元格数组      |
| `celldisp` |      显示单元格数组      |
| `cellplot` | 显示单元格阵列的图形表示 |
| `num2cell` |  将数组转换为单元格数组  |
|   `deal`   |    匹配输入和输出列表    |
|  `iscell`  |      识别单元格数组      |

#### 绘图

|    命令     |         描述说明         |
| :---------: | :----------------------: |
|   `axis`    |        设置轴限制        |
|   `fplot`   |       智能绘图功能       |
|   `grid`    |        显示网格线        |
|   `plot`    |      生成`xy`坐标图      |
|   `print`   |     打印或绘图到文件     |
|   `title`   |   在文字的顶部放置文字   |
|  `xlabel`   |  将文本标签添加到`x`轴   |
|  `ylabel`   |  将文本标签添加到`y`轴   |
|   `axes`    |        创建轴对象        |
|   `close`   |      关闭当前坐标图      |
| `close all` |      关闭所有坐标图      |
|  `figure`   |   打开一个新的图形窗口   |
|   `gtext`   |   通过鼠标启用标签放置   |
|   `hold`    |      冻结当前坐标图      |
|  `legend`   |     通过鼠标图例位置     |
|  `refresh`  |   重新绘制当前图形窗口   |
|    `set`    |  指定诸如轴的对象的属性  |
|  `subplot`  |     在子窗口中创建图     |
|   `text`    |     在图开放置字符串     |
|    `bar`    |        创建条形图        |
|  `loglog`   |      创建日志记录图      |
|   `polar`   |       创建极坐标图       |
| `semilogx`  | 创建半标记图(对数横坐标) |
| `semilogy`  | 创建半标记图(对数纵坐标) |
|  `stairs`   |        创建梯形图        |
|   `stem`    |         创建茎图         |

### .m 脚本文件 

 MATLAB 允许将一系列命令写入文件，并将文件作为完整单元执行，比如编写函数并调用它。脚本文件是以`.m`扩展名的程序文件。在这些文件中，可以编写一系列要一起执行的命令。脚本不接受输入，不返回任何输出。它们对工作空间中的数据进行操作。  脚本文件包含多个连续的MATLAB命令行和函数调用。可以通过在命令行中键入其名称来运行脚本。函数文件也是扩展名为`.m`的程序文件，函数可以接受输入和返回输出，内部变量是函数的局部变量 

在命令提示符下键入`edit`并回车，这将打开编辑器。也可以直接键入`edit`，然后直接输入文件名(扩展名为`.m`)。命令将在默认的 MATLAB 目录中创建该文件。如果要将所有程序文件存储在特定文件夹中，则必须提供整个路径

```matlab
edit 
edit newfile.m			% 或者
mkdir progs    % 创建文件夹
chdir progs    % 对当前文件夹进行改名
% 创建脚本文件 newfile.m
NoOfStudents = 6000;
TeachingStaff = 150;
NonTeachingStaff = 20;
Total = NoOfStudents + TeachingStaff ... + NonTeachingStaff;
disp(Total);

newfile			% 运行，结果 6170

uint32(789.50)			% 结果 790
int32(5678.92347)			% 5679
```

如果使用 IDE，请选择*“新建”* ->*“脚本”*，会打开编辑器并创建一个名为 *Untitled* 的文件，在输入代码后命名并保存文件。 创建并保存文件后，可以单击编辑器窗口上的“运行”按钮，或者在命令提示符下键入文件名(无扩展名) 

### 数据类型

MATLAB 不需要任何类型声明或维度语句。当 MATLAB 遇到新的变量名称时，它将创建变量并分配适当的内存空间。如果变量已经存在，则 MATLAB 将使用新内容替换原始内容，并在必要时分配新的存储空间。MATLAB 提供`15`种基本数据类型，每种数据类型存储矩阵或数组形式的数据。矩阵或数组的最小值是`0`，并且是可以到任何大小的矩阵或数组

|  数据类型  |                             描述                             |
| :--------: | :----------------------------------------------------------: |
|   `int8`   |                       `8`位有符号整数                        |
|  `uint8`   |                       `8`位无符号整数                        |
|  `int16`   |                       `16`位有符号整数                       |
|  `uint16`  |                       `16`位无符号整数                       |
|  `int32`   |                       `32`位有符号整数                       |
|  `uint32`  |                       `32`位无符号整数                       |
|  `int64`   |                       `64`位有符号整数                       |
|  `uint64`  |                       `64`位无符号整数                       |
|  `single`  |                        单精度数值数据                        |
|  `double`  |                        双精度数值数据                        |
| `logical`  |          逻辑值为`1`或`0`，分别代表`true`和`false`           |
|   `char`   |               字符数据(字符串作为字符向量存储)               |
| 单元格阵列 |     索引单元阵列，每个都能够存储不同维数和数据类型的数组     |
|   结构体   | C 型结构，每个结构具有能够存储不同维数和数据类型的数组的命名字段 |
|  函数处理  |                      指向一个函数的指针                      |
|   用户类   |                    用户定义的类构造的对象                    |
|  Java 类   |                     从 Java 类构造的对象                     |

 MATLAB 提供了各种用于将一种数据类型转换为另一种数据类型的函数

|       函数       |                    描述说明                    |
| :--------------: | :--------------------------------------------: |
|      `char`      |             转换为字符数组(字符串)             |
|    `int2str`     |             将整数数据转换为字符串             |
|    `mat2str`     |               将矩阵转换为字符串               |
|    `num2str`     |               将数字转换为字符串               |
|   `str2double`   |             将字符串转换为双精度值             |
|    `str2num`     |               将字符串转换为数字               |
| `native2unicode` |          将数字字节转换为Unicode字符           |
| `unicode2native` |          将Unicode字符转换为数字字节           |
|    `base2dec`    |          将基数N字符串转换为十进制数           |
|    `bin2dec`     |          将二进制数字串转换为十进制数          |
|    `dec2base`    |         将十进制转换为字符串中的N数字          |
|    `dec2bin`     |        将十进制转换为字符串中的二进制数        |
|    `dec2hex`     |           将十进制转换为十六进制数字           |
|    `hex2dec`     |       将十六进制数字字符串转换为十进制数       |
|    `hex2num`     |      将十六进制数字字符串转换为双精度数字      |
|    `num2hex`     |         将单数转换为IEEE十六进制字符串         |
|    `cell2mat`    |             将单元格数组转换为数组             |
|  `cell2struct`   |           将单元格数组转换为结构数组           |
|    `cellstr`     |            从字符数组创建字符串数组            |
|    `mat2cell`    | 将数组转换为具有潜在不同大小的单元格的单元阵列 |
|    `num2cell`    |   将数组转换为具有一致大小的单元格的单元阵列   |
|  `struct2cell`   |             将结构转换为单元格数组             |

 MATLAB 提供了用于识别变量数据类型的各种函数 

|         函数         |             描述说明             |
| :------------------: | :------------------------------: |
|         `is`         |             检测状态             |
|        `isa`         |    确定输入是否是指定类的对象    |
|       `iscell`       |       确定输入是单元格数组       |
|     `iscellstr`      |   确定输入是字符串的单元格数组   |
|       `ischar`       |      确定项目是否是字符数组      |
|      `isfield`       |    确定输入是否是结构数组字段    |
|      `isfloat`       |      确定输入是否为浮点数组      |
|     `ishghandle`     |   确定是否用于处理图形对象句柄   |
|     `isinteger`      |      确定输入是否为整数数组      |
|       `isjava`       |      确定输入是否为Java对象      |
|     `islogical`      |      确定输入是否为逻辑数组      |
|     `isnumeric`      |      确定输入是否是数字数组      |
|      `isobject`      |    确定输入是否为 MATLAB 对象    |
|       `isreal`       |      检查输入是否为实数数组      |
|      `isscalar`      |        确定输入是否为标量        |
|       `isstr`        |      确定输入是否是字符数组      |
|      `isstruct`      |      确定输入是否是结构数组      |
|      `isvector`      |        确定输入是否为向量        |
|       `class`        |           确定对象的类           |
| `validateattributes` |         检查数组的有效性         |
|        `whos`        | 在工作区中列出变量，其大小和类型 |

 使用以下代码创建脚本文件 

```matlab
x = 3
isinteger(x)			% 结果 0
isfloat(x)			% 结果 1
isvector(x)			% 结果 1
isscalar(x)			% 结果 1
isnumeric(x)			% 结果 1

x = 23.54			% 结果 1177/50
isinteger(x)			% 结果 0
isfloat(x)			% 结果 1
isvector(x)			% 结果 1
isscalar(x)			% 结果 1
isnumeric(x)			% 结果 1

x = [1 2 3]
isinteger(x)			% 结果 0
isfloat(x)			% 结果 1
isvector(x)			% 结果 1
isscalar(x)			% 结果 0

x = 'Hello'
isinteger(x)			% 结果 0
isfloat(x)			% 结果 0
isvector(x)			% 结果 1
isscalar(x)			% 结果 0
isnumeric(x)		% 结果 0
```

### 运算符

运算符是一个符号，它告诉编译器执行特定的数学或逻辑操作。MATLAB 中的运算符主要用于整个矩阵和阵列的操作，既可用于标量数据也可用于非标量数据

#### 算术运算符 

MATLAB 允许两种不同类型的算术运算：矩阵算术运算和数组算术运算。矩阵算术运算与线性代数中定义的相同，在一维和多维数组中，逐个元素执行数组运算。矩阵运算符和数组运算符由句点符号(`.`)区分，由于对于矩阵和阵列的加减运算是相同的，它们的运算符也相同

| 运符符 | 描述说明                                                     |
| ------ | ------------------------------------------------------------ |
| `+`    | 加法或一元加法运算。`A + B`表示相加存储在变量`A`和`B`中的值。`A`和`B`必须具有相同的大小，除非是标量，标量可以添加到任何大小的矩阵。 |
| `-`    | 减法或一元减法运算。 `A-B`表示从`A`中减去`B`的值。`A`和`B`必须具有相同的大小，除非是标量，可以从任何大小的矩阵中减去标量。 |
| `*`    | 矩阵乘法。 `C = A * B`是矩阵`A`和`B`的线性代数乘积。更准确地说，执行公式：![img](http://www.yiibai.com/uploads/images/201709/3009/741170918_87743.jpg) ，对于非标量`A`和`B`，`A`的列数必须等于`B`的行数。标量可以乘以任何大小的矩阵。 |
| `.*`   | 阵列乘法。 `A .* B`是数组`A`和`B`的逐个元素乘积。`A`和`B`必须具有相同的大小，除非它们之一是标量。 |
| `/`    | 数组乘法。`A .* B`是数组`A`和`B`的逐个元素乘积。`A`和`B`必须具有相同的大小，除非它们之一是标量。 |
| `./`   | 数组右除。`A./B`是具有元素`A(i，j)/ B(i，j)`的矩阵。 `A`和`B`必须具有相同的大小，除非它们之一是标量。 |
| `\`    | 反斜杠或数组左除。如果`A`是一个方阵，`A \ B`与`inv(A)* B`大致相同，除了以不同的方式计算。如果`A`是`n×n`矩阵，`B`是具有`n`个分量的列向量或具有若干这样的列的矩阵，则`X = A \ B`是方程`AX = B`的解。如果A是不规则或几乎单数，将显示警告消息。 |
| `.\`   | 阵列左除。`A .\ B`是具有元素`B(i，j)/ A(i，j)`的矩阵。`A`和`B`必须具有相同的大小，除非它们之一是标量。 |
| `^`    | 矩阵 `X ^ p`是`X`的`P`次幂，如果`p`是标量。 如果`p`是整数，则通过重复平方来计算幂值。 如果整数为负，则`X`首先倒置。 对于`p`的其他值，计算涉及特征值和特征向量，使得如果`[V，D] = eig(X)`，则`X ^ p = V * D. ^ p / V`。 |
| `.^`   | 阵列幂值， `A ^ B`是`B(i，j)`到`A(i，j)`的幂矩阵。`A`和`B`必须具有相同的大小，除非它们之一是标量。 |
| `'`    | 矩阵转置。 `'`是`A`的线性代数转置。对于复数矩阵，这是复共轭转置。 |
| `.'`   | 数组转置。`.'`是`A`的数组转置。对于复数矩阵，不涉及共轭。    |

示例代码

```matlab
a = 10;			
b = 20;			
c = a + b			% 结果 30
d = a - b			% 结果 -10
e = a * b			% 结果 200
f = a / b			% 结果 0.50000
g = a \ b			% 结果 2
x = 7;			
y = 3;			
z = x ^ y			% 结果 343
```

#### 关系运算符

关系运算符也可以用于标量和非标量数据。数组的关系运算符在两个数组之间执行逐个元素的比较，并返回相同大小的逻辑数组。如果为真，则元素设置为逻辑`1(true)`，如果为假，则元素设置为逻辑`0(false)`。`<` 小于 、`<=` 小于或等于、`>` 大于、`>=` 大于或等于、`==` 等于、`~=` 不等于

示例代码

```matlab
a = 100;
b = 200;
if (a >= b)
max = a
else
max = b			% 结果 200
end

if (le(a, b))
  disp(' a is either less than or equal to b')			% 输出这个
else
  disp(' a is greater than b')
end
```

 除了上述关系运算符之外，MATLAB还提供以下用于相同目的的命令/函数  

|    函数    |              描述               |
| :--------: | :-----------------------------: |
| `eq(a, b)` |       测试`a`是否等于`b`        |
| `ge(a, b)` |    测试`a`是否大于或等于`b`     |
| `gt(a, b)` |       测试`a`是否大于`b`        |
| `le(a, b)` |    测试`a`是否小于或等于`b`     |
| `lt(a, b)` |       测试`a`是否小于`b`        |
| `ne(a, b)` |      测试`a`是否不等于`b`       |
| `isequal`  |      测试数组以获得相等性       |
| `isequaln` | 测试数组相等，将`NaN`值视为相等 |

#### 逻辑运算符

MATLAB 提供两种类型的逻辑运算符和函数：逐元素 - 这些运算符对逻辑阵列的相应元素进行操作；短路 - 这些运算符在标量和逻辑表达式上运行。元素逻辑运算符在逻辑数组上运行逐个元素。符号`＆`，`|`和`〜`是逻辑数组运算符`AND`，`OR`和`NOT`。短路逻辑运算符允许逻辑运算短路，符号`&&`和`||`是逻辑短路运算符`AND`和`OR`

```matlab
a = 5;
b = 20;
if ( a && b )
  disp('Line 1 - Condition is true');
end

A = 00111100
B = 00001101
A&B			% 结果 0000 1100
```

#### 位运算

按位运算符对位执行，并执行逐位运算。包括`＆`，`|`和`^`。MATLAB 提供了诸如“按位与”、“按位或”、“按位非”，移位操作等位操作的各种功能

|      方法      |                             目的                             |
| :------------: | :----------------------------------------------------------: |
|  bitand(a, b)  |                 整数`a`和`b`的位与`AND`操作                  |
|   bitcmp(a)    |                        `a`的比特补码                         |
| bitget(a,pos)  |          在整数数组`a`中，获取指定的位置`pos`位字节          |
|  bitor(a, b)   |                  整数`a`和`b`的逐位`OR`操作                  |
| bitset(a, pos) |                  设置在指定`pos`处的位字节                   |
| bitshift(a, k) | 返回向左移位`k`字节，相当于乘以`2^k`。`k`的负值对应于向右移位或除以`2^k` 并舍入到最接近的整数到负无穷大。任何溢出位都被截断 |
|  bitxor(a, b)  |               整数`a`和`b`的逐字节位`XOR`操作                |
|   swapbytes    |                         交换字节排序                         |

示例代码

```matlab
a = 60;			% 60 = 0011 1100   
b = 13;			% 13 = 0000 1101 
c = bitand(a, b)      % 12 = 0000 1100  
c = bitor(a, b)       % 61 = 0011 1101 
c = bitxor(a, b)      % 49 = 0011 0001 
c = bitshift(a, 2)    % 240 = 1111 0000
c = bitshift(a,-2)    % 15 = 0000 1111
```

#### 集合操作

MATLAB 为集合操作提供了各种功能，如联合，交集和集合成员的测试等

下表显示了一些常用的集合操作 -

|         函数          |                             描述                             |
| :-------------------: | :----------------------------------------------------------: |
|    intersect(A,B)     | 设置两个阵列的交集; 也就是返回`A`和`B`共同的值。返回的值按排序顺序排列 |
| intersect(A,B,’rows’) | 将`A`的每一行和`B`的每一行视为单个实体，并返回`A`和`B`两者共同的行。返回矩阵的行按排序顺序排列 |
|     ismember(A,B)     | 返回与`A`相同大小的数组，其中包含`1(true)`，其中`A`的元素位于`B`中。其他地方返回`0(false)` |
| ismember(A,B,’rows’)  | 将`A`的每行和`B`的每一行视为单个实体，并返回一个包含`1(true)`的向量，其中矩阵`A`的行也是`B`行。其他返回`0(false)` |
|      issorted(A)      | 如果`A`的元素按排序顺序返回逻辑`1`(真)，否则返回逻辑`0`(假)。输入`A`可以是一个向量，也可以是`N-by-1`或`1-by-N`的字符串数组。 如果`A`和`sort(A)`的输出相等，则认为`A`被排序。 |
|  issorted(A, ‘rows’)  | 如果二维矩阵`A`的行按排序顺序返回逻辑`1`(真)，否则返回逻辑`0`(假)。 如果`A`和排序`(A)`的输出相等，则认为矩阵`A`被排序 |
|     setdiff(A,B)      | 设置两个数组的差异; 返回`A`中不在`B`中的值。返回的数组中的值按排序顺序排列 |
|  setdiff(A,B,’rows’)  | 将`A`的每一行和`B`的每一行视为单个实体，并从不在`B`中的`A`返回行。返回的矩阵的行按排序顺序排列。`'rows'`选项不支持单元格数组。 |
|        setxor         |                      设置两个数组的异或                      |
|         union         |                      设置两个数组的并集                      |
|        unique         |                       使数组中的值唯一                       |

### 决策和循环

一个`if...end`语句由一个`if`语句和一个布尔表达式组成，后跟一个或多个语句。它是由`end`语句分隔的语句块

```matlab
a = 10;
b = 20;
% if...end
if a < 20 
	fprintf('a is less than 20\n' );
end
	fprintf('value of a is : %d\n', a);
% if...else...end
if a < 20 
  fprintf('a is less than 20\n' );
else
  fprintf('a is not less than 20\n' );
end
% if...elseif...else
if a == 10 
	fprintf('Value of a is 10\n' );
elseif( a == 20 )
	fprintf('Value of a is 20\n' );
elseif a == 30 
	fprintf('Value of a is 30\n' );
else
	fprintf('None of the values are matching\n');
	fprintf('Exact value of a is: %d\n', a );
end
% 嵌套 if
if( a == 100 )
    if( b == 200 )
        fprintf('Value of a is 100 and b is 200\n' );
    end
end
grade = 'B';
switch(grade)
    case 'A' 
        fprintf('Excellent!\n' );
    case 'B' 
        fprintf('Well done\n' );
    otherwise
        fprintf('Invalid grade\n' );
end
% switch 语句的语法
switch <switch_expression>
   case <case_expression>
      <statements>
...
% while 循环
while( a < 20 )
  fprintf('value of a: %d\n', a);
  a = a + 1;
end
% for 循环，输出 10 到 20
for a = 10:20 
   fprintf('value of a: %d\n', a);
end
for a = 1.0: -0.1: 0.0			% 每次-0.1，从 1 到 0 
   disp(a)
end
for a = [24,18,17,23,28]			% 输出数组的每个元素
   disp(a)
end
% for 语句的语法
for index = values
   <program statements>
...
```

 评估的`switch_expression`是一个标量或字符串 

- 对于数字，`eq(case_expression，switch_expression)`；
- 对于字符串，`strcmp(case_expression，switch_expression)`；
- 对于对象，支持`eq(case_expression，switch_expression)`；
- 对于单元格数组`case_expression`至少有一个

for 语句中的值(`values`)具有以下格式 

|        值格式         |                             描述                             |
| :-------------------: | :----------------------------------------------------------: |
|   `initval:endval`    | `index`变量从`initval`到`endval`每次递增`1`，并重复程序语句的执行，直到`index`大于`endval`。 |
| `initval:step:endval` | 通过每次迭代值步长(`step`)增加索引(`index`)的值，或者当`step`为负时递减。 |
|      `valArray`       | 在每个迭代中从数组`valArray`的后续列创建列向量索引。 例如，在第一次迭代中，`index = valArray(:，1)`。 循环最多执行`n`次，其中`n`是由`numel(valArray，1，:)`给出的`valArray`的列数。`valArray`可以是任何 MATLAB 数据类型，包括字符串，单元格数组或结构体。 |

### 向量

向量是数字的一维数组，MATLAB 允许创建两种类型的向量：行向量和列向量。行向量是通过用方括号中的元素集合来创建的，使用空格或逗号分隔元素；列向量通过用方括号中的元素集合来创建，使用分号(`;`)来分隔元素。矩阵是数字的二维数组，在 MATLAB 中，通过将每行作为一系列空格或逗号分隔的元素输入矩阵，并以行号分隔一行。

```matlab
r = [7 8 9 10 11];			% 行向量
t = [2, 3, 4, 5, 6];
res = r + t			% 向量相加，结果 [9, 11, 13, 15, 17]
res = r - t			% 向量相减，结果 [2, 5, 5, 5, 5]
c = [7;  8;  9;  10; 11]			% 列向量
m = [1 2 3; 4 5 6; 7 8 9]			% 创建一个3x3的矩阵
m(3)			% 向量的第3个分量的第1个元素
m(3,2)			% 向量的第3个分量的第2个元素
m(:)			% 列出向量的所有组件
rv = [1 2 3 4 5 6 7 8 9];
sub_rv = rv(3:7)			% 取第3个到第7个元素
A = [7, 11, 15, 23, 9];
B = [2, 5, 13, 16, 20];
C = A + B;			% 向量相加，结果 [9, 16, 28, 39, 29]
D = A - B;			% 向量相减，结果 [5, 6, 2, 7, -11]
v = [ 12 34 10 8];
m = 5 * v			% 向量标量乘法，结果 [60, 170, 50, 40]
r = [ 1 2 3 4 ];
tr = r';			% 行向量转置为列向量
v = [1; 2; 3; 4 ];
w = [5; 6; 7; 8 ];
tv = v';			% 列向量转置为行向量
C = [A, B]			% 附加向量，结果 形成一行
C = [A; B]			% 结果 上下两行
u = [v; w]			% 附加向量，结果 形成一列
u = [v, w]			%  结果 左右两列
```

- 两个相加或相减操作的向量必须是相同的类型并且具有相同数量的元素。可以对向量执行所有标量运算。例如:以标量数量对向量执行相加，相减和除法运算；

- 将一个向量乘以一个数字时，称为标量乘法。标量乘法产生相同类型的新向量，原始向量的每个元素乘以数字；

- 转置操作是将列向量更改为行向量，反之亦然。 转置操作由单引号(`'`)表示；

- MATLAB 允许将多个向量附加在一起来创建新的向量，附加操作由分号(`'`)和逗号(`;`)来完成；

- 具有元素为`v1`，`v2`，`v3`，`...`，`vn`的向量`v`的幅值(大小)由下列公式求出

  ![img](http://www.yiibai.com/uploads/images/201710/0710/311141056_12884.png)

- 两个向量`a =(a1，a2，...，an)`和`b =(b1，b2，...，bn)`的点积的公式为`a.b = ∑(ai.bi)`。可以使用`dot`函数计算两个向量`a`和`b`的点积

```matlab
% 计算向量的幅值
v = [1: 2: 20];
sv = v.* v;			% 向量 v 的元素的平方 
dp = sum(sv);			% 得到向量v的元素的平方和
mag = sqrt(dp);			% 取平方根，结果 36.469
% 计算向量的点积
v1 = [2 3 4];
v2 = [1 2 3];
dp = dot(v1, v2);			% 结果20
% 创建具有均匀间隔元素的向量
v = [1: 2: 20];			% 不包括最后一个，结果 [1, 3, 5...19]
sqv = v.^2;			% 取幂值 结果 [1, 9, 25...361]
```

### 矩阵

矩阵是数字的二维数组。在 MATLAB 中，可以通过在每行中输入元素来创建一个矩形，以逗号或空格分隔数字，并使用分号标记每一行的结尾

```matlab
a = [ 1 2 3 4 5; 2 3 4 5 6; 3 4 5 6 7; 4 5 6 7 8]			% 4×5 矩阵 a
a(2,5)			% 引用矩阵a的第2行和第5列中的元素
v = a(:,4)			% 引用第4列中的所有元素
a = (:, 2:3)			% 引用第2列到第3列中的所有元素
sa = a(2:3,2:4)			% ?创建一个矩阵的子部分的子矩阵
a( 4 , : ) = []			% 删除第4行
a(: , 5)=[]			% 删除第5列
a = [ 1 2 3 ; 4 5 6; 7 8 9];
b = [ 7 5 6 ; 2 0 8; 5 7 1];
new_mat = a([2,3,2,3],:)			% 复制矩阵的第2行和第3行2次来创建一个4x3的矩阵
c = a + b			% 矩阵的相加
c = a + b			% 矩阵的相减
c = a / 			% 矩阵的左除
c = a \ b			% 矩阵的右除
% 标量运算
c = a + 2
c = a - 2
c = a * 2
c = a / 2
b = a'			% 矩阵的转置	
c = [a, b]			% 水平连接
d = [a; b]			% 垂直连接
prod = a * b			% 矩阵乘法
a = [ 1 2 3; 2 3 4; 1 2 5]
det(a)			% 矩阵的行列式，结果 -2
inv(a)			% 矩阵的逆转
```

- 通过向该行或列分配一组空的方括号`[]`来删除矩阵的整个行或列，`[]`表示一个空数组；
- 矩阵可以相加或相减，两个矩阵操作数必须具有相同数量的行和列，结果为每个对应元素的相加；
- 可以使用左(`\`)或右(`/`)除法运算符来执行两个矩阵的除法运算，两个操作数矩阵必须具有相同数量的行和列；
- 当矩阵相加，相减，乘法或除以一个数字时，这些称为标量运算。标量运算产生一个具有相同数量的行和列的新矩阵，其原始矩阵的每个元素都被相加，相减，相乘以或除以数字;
- 转置操作以矩阵形式切换行和列，由单引号(`'`)来操作。矩阵`A`的行列式由`det(A)`计算给出；
- 可以连接两个矩阵来创建一个较大的矩阵，方括号`'[]'`是连接运算符。当使用逗号(`,`)分隔两个矩阵时，它们只是水平附加，也称为水平连接。如果通过使用分号(`;`)分隔两个矩阵，它们将垂直附加，也称为垂直连接；
- 在矩阵乘法中，第一矩阵中的行的元素与第二矩阵中的相应列的元素相乘，仅当`A`中的列数`n`等于`B`中行`n`数量时，才能进行矩阵乘法；
- 矩阵`A`的倒数由`A^-1`表示，矩阵的倒数并不总是存在。如果矩阵的行列式为零，则不存在逆矩阵，矩阵是单数的。使用`inv`函数计算MATLAB中矩阵的逆转

### 数组

MATLAB 中所有数据类型的所有变量都是多维数组。向量是一维数组，矩阵是二维数组。对于函数，单个参数创建一个正方形数组，双参数创建矩形数组

```matlab
zeros(5)			% 创建一个5x5的元素都为0的数组 
ones(4,3)			% 创建一个4x3的元素都为1的数组
eye(4)			% 创建一个4x4的单位矩阵
rand(3, 5)			% 在(0,1)创建均匀分布的随机数的数组
a(:, :, 2)= [ 1 2 3; 4 5 6; 7 8 9]			% 创建3维数组
rand(4,3,2)
a = [9 8 7; 6 5 4; 3 2 1];
b = [1 2 3; 4 5 6; 7 8 9];
c = cat(3, a, b, [ 2 3 1; 4 7 8; 3 9 0])			% 构建多维数组，3是连接的数组大小？
```

单位矩阵就是反斜线为1，其它为0的矩阵

- 魔方是一个平方，它产生相同的和（行列和对角线），它的元素被逐行，逐列或者对角线地添加时。`magic()`函数创建一个魔术方阵。这需要一个参数，指定正方形的大小。 参数必须是大于或等于`3`的标量；
- 具有二维以上的数组在MATLAB中被称为多维数组。MATLAB中的多维数组是正常二维矩阵的扩展。通常要生成一个多维数组，首先创建一个二维数组然后再扩展它

#### 数组函数

MATLAB 提供以下函数来对数组内容进行排序，旋转，排列，重新成形或移位。

|     函数     |            描述            |
| :----------: | :------------------------: |
|   `length`   |   向量的大小或数组的长度   |
|   `ndims`    |         数组的维数         |
|   `numel`    |       数组的元素数量       |
|    `size`    |         数组的维度         |
|  `iscolumn`  |    确定输入是否为列向量    |
|  `isempty`   |      确定数组是否为空      |
|  `ismatrix`  |     确定输入是否为矩阵     |
|   `isrow`    |    确定输入是否为行向量    |
|  `isscalar`  |     确定输入是否为标量     |
|  `isvector`  |     确定输入是否为向量     |
|  `blkdiag`   |  从输入参数构造块对角矩阵  |
| `circshift`  |          循环移位          |
| `ctranspose` |         复共轭转置         |
|    `diag`    |    矩阵对角矩阵和对角线    |
|  `flipdim`   |   沿着指定的尺寸翻转数组   |
|   `fliplr`   |      从左到右翻转矩阵      |
|   `flipud`   |        向下翻转矩阵        |
|  `ipermute`  |   反转N-D阵列的置换维度    |
|  `permute`   |   重新排列N-D数组的维度    |
|   `repmat`   |       复制和平铺数组       |
|  `reshape`   |          重塑数组          |
|   `rot90`    |        旋转矩阵90度        |
|  `shiftdim`  |          移动维度          |
|  `issorted`  | 确定设置元素是否按排序顺序 |
|    `sort`    |  按升序或降序排列数组元素  |
|  `sortrows`  |        按升序排列行        |
|  `squeeze`   |        删除单例维度        |
| `transpose`  |            转置            |
| `vectorize`  |        向量化表达式        |

示例代码

```matlab
x = [7.1, 3.4, 7.2, 28/4, 3.6, 17, 9.4, 8.9];
length(x)			% 向量长度，结果 8
y = rand(3, 4, 5, 2);			% 创建一个四维数组
ndims(y)			% 向量的维度，结果 4
s = ['Zara', 'Nuha', 'Shamim', 'Riz', 'Shadab'];
numel(s)			% 向量的元素数量，就是字母的数量，结果 5
a = [1 2 3; 4 5 6; 7 8 9]  
b = circshift(a,1)         % 循环移位，向下移动一行
c = circshift(a,[1 -1])         % 向下移动一行，再向左移动一列
v = [ 23 45 12 9 5 0 19 17]			% horizontal vector
sort(v)			% 排序数组，原数组不会被改变，自然排序
m = [2 6 4; 5 3 9; 2 0 1]			% two dimensional array
sort(m, 1)			% 沿着列排序
sort(m, 2)			% 沿着行排序
c = cell(2, 5);			% 创建单元格阵列，2指定单元格数组的维数
c = {'Red', 'Blue', 'Green', 'Yellow', 'White'; 1 2 3 4 5}			% 数字会在[]中显示
c(1:2,1:2)			% 按索引值配对访问单元格数组数据，如[1,1]、[1,2
c{1, 2:4}			% 
```

 单元格阵列是索引单元的数组，其中每个单元格可以存储不同维度和数据类型的数组。单元格函数用于创建单元格数组 

### 数字

MATLAB支持包括有符号和无符号整数以及单精度和双精度浮点数的各种数字类型。 默认情况下，MATLAB将所有数值存储为双精度浮点数。可以选择将任何数字或数组的数字存储为整数或单精度数字。所有数字类型都支持基本的数组运算和数学运算

转换为各种数值数据类型

|   函数   |        描述说明        |
| :------: | :--------------------: |
| `double` |     转换为双精度数     |
| `single` |     转换为单精度数     |
|  `int8`  | 转换为`8`位有符号整数  |
| `int16`  | 转换为`16`位有符号整数 |
| `int32`  | 转换为`32`位有符号整数 |
| `int64`  | 转换为`64`位有符号整数 |
| `uint8`  | 转换为`8`位无符号整数  |
| `uint16` | 转换为`16`位无符号整数 |
| `uint32` | 转换为`32`位无符号整数 |
| `uint64` | 转换为`64`位无符号整数 |

示例代码

```matlab
x = single([5.32 3.47 6.28]) .* 7.5			% 结果 [39.900 26.025 47.100]
x = double([5.32 3.47 6.28]) .* 7.5			% 结果 [39.900 26.025 47.100]
x = int8([5.32 3.47 6.28]) .* 7.5			% 结果 [38 23 45]
x = int16([5.32 3.47 6.28]) .* 7.5			% 结果 [38 23 45]
x = int32([5.32 3.47 6.28]) .* 7.5			% 1×3 int32 行向量，结果 [38 23 45]
x = int64([5.32 3.47 6.28]) .* 7.5			% 1×3 int64 行向量，结果 [38 23 45]
x = num2cell(x)			% 1×3 cell 数组，结果 {[38]} {[23]} {[45]}
str = 'The range for int8 is:\n\t%d to %d ';
sprintf(str, intmin('int8'), intmax('int8'))			% 结果是 -128 to 127
str = 'The range for single is:\n\t%g to %g and\n\t %g to  %g';
sprintf(str, -realmax('single'), -realmin('single'), ...
   realmin('single'), realmax('single'))
%{	结果为 -3.40282e+38 to -1.17549e-38 and
    	  1.17549e-38 to  3.40282e+38'	}

```

 `intmax()`和`intmin()`函数返回可以用所有类型的整数表示的最大值和最小值，`realmax()`和`realmin()`函数返回可以用浮点数表示的最大值和最小值 

### 字符串

可以使用`uint8`或`uint16`等数字转换函数将字符串中的字符转换为数字代码，`char`函数将整数向量转换回到字符

```matlab
my_string = 'Yiibai''s Tutorial';			% 单引号需用两个
str_ascii = uint8(my_string)        
% 结果 [89  105  105   98   97  105   39  115   32   84  117  116  111  114  105   97  108]
str_back_to_char= char(str_ascii)  
str_16bit = uint16(my_string)       % 16-bit ascii values
str_back_to_char = char(str_16bit)
doc_profile = ['Bara Tli                             '; ...
               'Sr. Surgeon                          '; ...
               'R N Tagore Cardiology Research Center']
doc_profile = char('Bara Tli', 'Sr. Surgeon', ...
                   'RN Tagore Cardiology Research Center')
name =     'Myra Yli                             ';
position = 'Sr. Surgeon                          '; 
worksAt =  'R N Tagore Cardiology Research Center';
profile = [name ', ' position ', ' worksAt]			% 会保留空格
profile = strcat(name, ', ', position, ', ', worksAt)			% 不会保留空格
profile = char(name, position, worksAt);
profile = cellstr(profile);			% 将字符数组转换为字符串的单元格数组 
disp(profile)
```

 创建矩形字符阵列的最简单的方式是根据需要垂直或水平连接两个或更多个一维字符数组。

- 垂直组合字符串：使用 MATLAB 连接运算符`[]`并用分号(`;`)分隔每一行。 请注意，在这种方法中，每行必须包含相同数量的字符。对于不同长度的字符串，应该根据需要填充空格字符。也可以使用`char`函数，如果字符串的长度不同，会将较短的字符串填充到尾部空白处，以使每行具有相同的字符数；
- 水平组合字符串 ： 使用 MATLAB 连接运算符`[]`并用逗号(`,`)或空格分隔输入字符串。该方法保留输入数组中的任何尾随空格。也可以使用字符串连接函数`strcat`，此方法会删除输入中的尾随空格

组合字符串的更有效的方法是将生成的数组转换为单元格数组， MATLAB 单元格数组可以在数组中保存不同大小和类型的数据。单元格数组提供了一种更灵活的方法来存储不同长度的字符串，`cellstr`函数将字符数组转换为字符串的单元格数组 

#### 字符串函数

 MATLAB 提供了许多字符串函数来创建，组合，解析，比较和操作字符串

用于存储字符数组中的文本，组合字符数组等的函数

|    函数     |                 描述                 |
| :---------: | :----------------------------------: |
|  `blanks`   |            创建空白字符串            |
|  `cellstr`  |       从字符数组创建字符串数组       |
|   `char`    |        转换为字符数组(字符串)        |
| `iscellstr` |     确定输入是字符串的单元格数组     |
|  `ischar`   |        确定项目是否是字符数组        |
|  `sprintf`  |         将数据格式化为字符串         |
|  `strcat`   |            水平连接字符串            |
|  `strjoin`  | 将单元格中的字符串连接到单个字符串中 |

识别字符串部分，查找和替换子串的函数

|       函数        |              描述              |
| :---------------: | :----------------------------: |
|     `ischar`      |     确定项目是否是字符数组     |
|    `isletter`     |       数组元素是否为字母       |
|     `isspace`     |         数组元素是空格         |
|    `isstrprop`    |   确定字符串是否是指定的类别   |
|     `sscanf`      |     从字符串读取格式化数据     |
|     `strfind`     | 在另一个字符串中查找一个字符串 |
|     `strrep`      |         查找并替换子串         |
|    `strsplit`     |   在指定的分隔符处拆分字符串   |
|     `strtok`      |        字符串的选定部分        |
| `validatestring`  |     检查文本字符串的有效性     |
|     `symvar`      |     确定表达式中的符号变量     |
|     `regexp`      |   匹配正则表达式(区分大小写)   |
|     `regexpi`     |  匹配正则表达式(不区分大小写)  |
|    `regexprep`    |     用正则表达式替换字符串     |
| `regexptranslate` |     用正则表达式替换字符串     |

字符串比较的函数

| 函数       | 描述                                  |
| ---------- | ------------------------------------- |
| `strcmp`   | 比较字符串(区分大小写)                |
| `strcmpi`  | 比较字符串(不区分大小写)              |
| `strncmp`  | 比较字符串的前`n`个字符(区分大小写)   |
| `strncmpi` | 比较字符串的前`n`个字符(不区分大小写) |

将字符串更改为大写或小写，创建或删除空格的函数

| 函数      | 描述                           |
| --------- | ------------------------------ |
| `deblank` | 从字符串末尾剥去尾随空格       |
| `strtrim` | 从字符串中删除前导和尾随的空格 |
| `lower`   | 将字符串转换为小写             |
| `upper`   | 将字符串转换为大写字母         |
| `strjust` | 对齐字符数组                   |

示例代码

```matlab
A = pi*1000*ones(1,5);			% 结果 [3.1416 3.1416 3.1416 3.1416 3.1416]
sprintf(' %f \n %.2f \n %+.2f \n %12.2f \n %012.2f \n', A)			% 格式化字符串
str_array = {'red','blue','green', 'yellow', 'orange'};
str1 = strjoin(str_array, "-")			% 将单元格中的字符串连接到单个字符串中
str1 = 'This is test'
str2 = 'This is text'
if (strcmp(str1, str2))
 sprintf('%s and %s are not equal', str1, str2)
else
 sprintf('%s and %s are equal', str1, str2)
end
```

### 函数

 在 MATLAB 中，函数在单独的文件中定义，文件的名称和函数的名称应该是一样的。函数在自己的工作空间内的变量上运行，这个变量也称为本地工作空间，与在 MATLAB 命令提示符下访问的工作区(称为基本工作区)不同。函数的第一行以关键字`function`开头。它给出了函数的名称和参数的顺序。 函数可以接受多个输入参数，并可能返回多个输出参数。 函数语句之后的注释行提供了帮助文本。当键入时，这些行被打印 

创建名为`mymax.m`的函数文件，从左上角菜单中点击*新建*->*函数* ，它需要五个数字作为参数，并返回参数数字值的最大值。max 为返回值

```matlab
function max = mymax(n1, n2, n3, n4, n5)
% This function calculates the maximum of the
% five numbers given as input
max =  n1;
if(n2 > max)
    max = n2;
end
if(n3 > max)
   max = n3;
end

mymax(11,22,35,81,198)			% 调用函数，结果 198
power = @(x, n) x.^n;			% 定义一个匿名函数，括号內为参数
result1 = power(7, 3)			% 结果 343
```

#### 匿名函数

匿名函数就像传统编程语言中的内联函数，在单个 MATLAB 语句中定义。 它由单个 MATLAB 表达式和任意数量的输入和输出参数组成。可以在 MATLAB 命令行或函数或脚本中定义一个匿名函数，这样就可以创建简单的函数，而无需为它们创建一个文件

#### 主函数和子函数

必须在文件中定义除了匿名函数以外的其它任何函数。每个函数文件包含主要出现的必需的主函数，以及主函数之后的任意数量的可选子函数。可以从命令行或其他函数的文件外部调用主函数，但不能从命令行或函数文件外的其他函数调用子函数。子函数仅对函数文件中的主函数和其他子函数可见。

下面编写一个名为`quadratic`的函数来计算二次方程的根。该函数需要三个输入参数：二次系数，线性系数和常数项，计算并会返回根。函数文件`quadratic.m`将包含主函数`quadratic`和次函数和子函数`disc`，它计算判别式

```matlab
function [x1,x2] = quadratic(a,b,c)
d = disc(a,b,c); 
x1 = (-b + d) / (2*a);
x2 = (-b - d) / (2*a);
end 

function dis = disc(a,b,c) 
dis = sqrt(b^2 - 4*a*c);
end 

quadratic(2,4,-4)			% 结果 0.7321
```

#### 嵌套函数

可以在一个函数的主体内定义另一个函数，这样的函数被称为嵌套函数。嵌套函数包含任何其他函数的部分或全部组件，嵌套函数在另一个函数的范围内定义，并且它们共享对包含函数的工作空间的访问

```matlab
function [x1,x2] = quadratic2(a,b,c)
function disc			% 嵌套函数
d = sqrt(b^2 - 4*a*c);
end 
disc;			% 调用函数
x1 = (-b + d) / (2*a);
x2 = (-b - d) / (2*a);
end 

quadratic2(2,4,-4)			
```

#### 私有函数

私有函数是仅在有限的其他函数组中可见的主函数。如果不想公开函数的实现，则可以将其创建为私有函数。私有函数处在专用名称为私有的子文件夹中，它们只对父文件夹中的函数可见。在工作目录中创建一个名为`private`的子文件夹(*F:\worksp\matlab\private*)，存储以下函数在文件`disc.m`中。 在工作目录中创建一个函数`quadratic3.m`(对应目录为：*F:\worksp\matlab*) 

```matlab
% 私有函数，F:/worksp/matlab/private/disc.m
function dis = disc(a,b,c)			
dis = sqrt(b^2 - 4*a*c);
end 
% quadratic3.m
function [x1,x2] = quadratic3(a,b,c)
d = disc(a,b,c); 
x1 = (-b + d) / (2*a);
x2 = (-b - d) / (2*a);
end 
```

#### 全局变量

全局变量可由多个函数共享，需要在所有函数中声明变量为全局变量。如果要从基本工作区访问该变量，则在命令行中声明该变量。全局声明必须在函数实际使用变量之前进行。 将大写字母用于全局变量的名称是一个很好的做法，以区别于其他变量

```matlab
% average.m
function avg = average(nums)
global TOTAL
avg = sum(nums)/TOTAL;
end

global TOTAL;
TOTAL = 10;
n = [34, 45, 25, 45, 33, 19, 40, 34, 38, 42];
av = average(n)			% 结果 41.9000
```

### 数据导入导出

#### 数据导入

 在 MATLAB 中导入数据意味着从外部文件加载数据。importdata 函数允许加载不同格式的各种数据文件

| 序号 |                         函数                          |                             描述                             |
| :--: | :---------------------------------------------------: | :----------------------------------------------------------: |
|  1   |              `A = importdata(filename)`               |            从文件*filename*中将数据加载到数组A中             |
|  2   |           `A = importdata('-pastespecial')`           |               从系统剪贴板而不是从文件加载数据               |
|  3   |          `A = importdata(___, delimiterIn)`           | 解析`delimiterIn`作为在`ASCII`文件，文件名或剪贴板数据中的列分隔符。可以使用`delimiterIn`与上述语法中的任何输入参数 |
|  4   |   `A = importdata(___, delimiterIn, headerlinesIn)`   | 从ASCII文件，文件名或剪贴板加载数据，从行头标题`In + 1`开始读取数字数据 |
|  5   | `[A, delimiterOut, headerlinesOut] = importdata(___)` | 返回在`delimiterOut`中检测到的输入ASCII文件的分隔符字符，并使用前面语法中的任何输入参数检测`headerlinesOut`中检测到的标题行数 |

默认情况下，Octave 不支持`importdata()`函数，因此必须搜索并安装此软件包。将以下行复制到剪贴板`Matlab is simple，I like it.`

```matlab
% 加载并显示一个图像文件
filename = 'mydog.jpg';
A = importdata(filename);
image(A);
% 导入一个文本文件并使用指定分隔符和列标题
filename = 'weeklydata.txt';
delimiterIn = ' ';
headerlinesIn = 1;
A = importdata(filename,delimiterIn,headerlinesIn);
% 输出数据
for k = [1:7]
   disp(A.colheaders{1, k})			% 输出列标题
   disp(A.data(:, k))			% 输出列
   disp(' ')
end
% 从剪贴板中导入数据	
A = importdata('-pastespecial')

```

#### 低级文件I/O 

`importdata`函数是一个高级函数。 MATLAB 中的低级文件 I/O 函数允许对文件读取或写入数据控制。但是，这些函数需要更多关于文件的详细信息才能有效地工作。MATLAB 为字节或字符级别的读写操作提供以下函数

|   函数    |                 描述                 |
| :-------: | :----------------------------------: |
| `fclose`  |       关闭一个或所有打开的文件       |
|  `feof`   |             测试文件结尾             |
| `ferror`  |        有关文件I/O错误的信息         |
|  `fgetl`  |       从文件读取行，删除换行符       |
|  `fgets`  |       从文件读取行，保留换行符       |
|  `fopen`  |  打开文件，或获取有关打开文件的信息  |
| `fprintf` |          将数据写入文本文件          |
|  `fread`  |         从二进制文件读取数据         |
| `frewind` | 将文件位置指示器移动到打开文件的开头 |
| `fscanf`  |  读取文本或ASCII文件中的格式化数据   |
|  `fseek`  |        移动到文件中的指定位置        |
|  `ftell`  |          在打开文件中的位置          |
| `fwrite`  |         将数据写入二进制文件         |

假设有一个文本数据文件`myfile.txt`保存在工作目录中。此文件存放三个月的降雨资料： 2012年6月，7月和8月降雨量。`myfile.txt`中的数据在五个地方包含重复的时间，月份和降雨量测量。标题数据存储月数`M`，所以有`M`个集合测量值

- 使用格式说明符描述文件中的数据，例如字符串的`%s`，整数`%d`或浮点数`%f`。要跳过文件中的文字，请将其包含在格式说明中。要跳过数据字段，请在说明符中使用星号(`*`)；
- 默认情况下，`fscanf`会根据格式描述读取数据，直到找不到数据的匹配，或到达文件的末尾。这里使用`for`循环读取`3`组数据，每次读取`7`行和`5`列；
- 将在工作空间中创建一个名为`mydata`的结构来存储从文件读取的数据，这个结构有三个字段：时间，月份和雨天数组。创建脚本文件(*readraindata.m*) 

```matlab
% myfile.txt
Rainfall Data
Months: June, July, August

M=3
12:00:00
June-2012
17.21  28.52  39.78  16.55 23.67
19.15  0.35   17.57  NaN   12.01
17.92  28.49  17.40  17.06 11.09
9.59   9.33   NaN    0.31  0.23 
10.46  13.17  NaN    14.89 19.33
20.97  19.50  17.65  14.45 14.00
18.23  10.34  17.95  16.46 19.34
...

filename = 'myfile.txt';
rows = 7;
cols = 5;
fid = fopen(filename);			% 打开文件并获取文件标识符
M = fscanf(fid, '%*s %*s\n%*s %*s %*s %*s\nM=%d\n\n', 1);			% 读取文件标题，找到M
% 读取数据
for n = 1:M
   mydata(n).time = fscanf(fid, '%s', 1);
   mydata(n).month = fscanf(fid, '%s', 1);
   mydata(n).raindata  = ...
      fscanf(fid, '%f', [rows, cols]);
end
% 输出数据
for n = 1:M
   disp(mydata(n).time), disp(mydata(n).month)
   disp(mydata(n).raindata)
end
fclose(fid);			% 关闭文件

readraindata			% 运行函数
```

可能需要创建其他文本文件，包括数字和字符数据的组合，非矩形输出文件或具有非 ASCII 编码方案的文件。为了实现这些目的，MATLAB 提供了低级别的`fprintf`函数。低级 I/O 文件活动中，在导出之前，需要使用`fopen`函数打开或创建一个文件，并获取文件标识符。 默认情况下，`fopen`会打开一个只读访问的文件，所以应该指定写入或附加的权限，例如`'w'`或`'a'`。处理文件后，需要用`fclose(fid)`函数关闭它

```matlab
x = 0:10:100;
y = [x; log(x)];
fid = fopen('logtable.txt', 'w');
fprintf(fid, 'Log     Function\n\n');			% 写入标题
fprintf(fid, '%f    %f\n', y);
fclose(fid);	
type logtable.txt
```

#### 数据导出

MATLAB 中的数据导出(或输出)可以理解为写入文件，MATLAB 允许在其他应用程序中使用读取ASCII文件的数据。 可以创建来自数组的矩形，有分隔符的ASCII数据文件、日记(或日志)文件的按键和结果文本输出和使用`fprintf`等低级函数的专用ASCII文件

- 将数字数组导出为有分隔符的ASCII数据文件可以使用`save`函数并指定`-ascii`限定符，或者使用`dlmwrite`函数；
- 保存`save -ascii`命令和`dlmwrite`函数不能使用单元格数组作为输入，要从单元格数组的内容创建一个分隔的ASCII文件，可以使用`cell2mat`函数将单元阵列转换为矩阵，或使用低级文件I/O函数导出单元格数组；
- 如果使用`save`函数将字符数组写入ASCII文件，会将ASCII等效字符写入该文件；
- 日记文件是 MATLAB 会话的活动日志，`diary`函数在磁盘文件中创建会话的精确副本，不包括图形

```matlab
num_array = [ 1 2 3 4 ; 4 5 6 7; 7 8 9 0];
save array_data1.out num_array -ascii;			% 分别是输出文件、数组、说明符
type array_data1.out			% 输出文件的内容
dlmwrite('array_data2.out', num_array, ' ');			% 分别是输出文件、数组、分隔符
type array_data2.out
h = 'hello';
save textdata.out h -ascii
type textdata.out
%{	8位ASCII格式的字符串“hello”的字符 
	1.0400000e+02   1.0100000e+02   1.0800000e+02   1.0800000e+02   1.1100000e+02	%}
diary			% 打开日记文件，或者下面
diary diary.log
```

### 笔记

 `questdlg(quest)` 创建一个模态对话框， 会提出问题并返回用户的回答`'Yes'`、`'No'`、`'Cancel'` 或 `''` 

 uigetfile 创建标准的对话框并通过交互式操作取得文件名 

xlsread 函数读取excel表格数据