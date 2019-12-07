## linux系统学习

Linux 是一套免费使用和自由传播的类 Unix 操作系统，是一个基于 POSIX 和 UNIX 的多用户、多任务、支持多线程和多 CPU 的分时操作系统。继承了 Unix 以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统

BIOS(Basic Input Output System)，*NFS*(Network File System)

只有 /etc/securetty 中登记了的终端才允许 root 用户登录。/etc/usertty 文件用于对用户作出附加访问限制

图形模式

按Ctrl + Alt + F1 ~ F6来进入其中一个命令窗口界面，当你进入命令窗口界面后再返回图形界面只要按下Ctrl + Alt + F7 就回来了，如果使用的是VMware，则是Alt+space

### Linux关机

```
sync 将数据由内存同步到硬盘中
shutdown 关机指令
shutdown –h 10 'This server will shutdown after 10 mins'   十分钟后关机并提示
shutdown –h now 立马关机
shutdown –h 20:25 系统会在今天20:25关机
shutdown –r now 系统立马重启
```

reboot 就是重启，等同于 shutdown –r now 和 init 6
halt 关闭系统，等同于shutdown –h now，poweroff 和 init 0

可以使用 *man [命令]* 来查看各个命令的使用文档，如 ：man cp

### Linux 系统目录结构

1. **/bin**：bin是Binary的缩写, 这个目录存放着最经常使用的命令
2. **/boot：**这里存放的是启动Linux时使用的一些核心文件，包括一些连接文件以及镜像文件
3. **/dev ：**dev是Device(设备)的缩写, 该目录下存放的是Linux的外部设备，在Linux中访问设备的方式和访问文件的方式是相同的
4. **/etc：**这个目录用来存放所有的系统管理所需要的配置文件和子目录
5. **/home**：用户的主目录，在Linux中，每个用户都有一个自己的目录，一般该目录名是以用户的账号命名的
6. **/lib**：这个目录里存放着系统最基本的动态连接共享库，其作用类似于Windows里的DLL文件。几乎所有的应用程序都需要用到这些共享库
7. **/lost+found**：这个目录一般情况下是空的，当系统非法关机后，这里就存放了一些文件
8. **/media**：linux系统会自动识别一些设备，例如U盘、光驱等等，当识别后，linux会把识别的设备挂载到这个目录下
9. **/mnt**：系统提供该目录是为了让用户临时挂载别的文件系统的，我们可以将光驱挂载在/mnt/上，然后进入该目录就可以查看光驱里的内容了
10. **/root**：该目录为系统管理员，也称作超级权限者的用户主目录
11. **/sbin**：s就是Super User的意思，这里存放的是系统管理员使用的系统管理程序
12. **/usr**：这是一个非常重要的目录，用户的很多应用程序和文件都放在这个目录下，类似于windows下的program files目录。**/usr/bin：**系统用户使用的应用程序。**/usr/sbin：**超级用户使用的比较高级的管理程序和系统守护程序。**/usr/src：**内核源代码默认的放置目录
13. **/var**：这个目录中存放着在不断扩充着的东西，我们习惯将那些经常被修改的目录放在这个目录下，包括各种日志文件

屏蔽主机的ping命令

```
echo 1 > /proc/sys/net/ipv4/icmp_echo_ignore_all
```

### Linux 文件基本属性

可以使用 ll 或者 ls –l 命令来显示一个文件的属性以及文件所属的用户和组

```
ls -l
total 64
dr-xr-xr-x   2 root root 4096 Dec 14  2012 bin
dr-xr-xr-x   4 root root 4096 Apr 19  2012 boot
……
```

在Linux中第一个字符为[ d ]是目录，[ - ]为文件，[ l ]为链接文档，[ b ]为装置文件里面的可供储存的接口设备(可随机存取装置)，[ c ]为装置文件里面的串行端口设备，例如键盘、鼠标(一次性读取装置)

![363003_1227493859FdXT](https://massionter-images-1258860804.cos.ap-guangzhou.myqcloud.com/zcayo/363003_1227493859FdXT.png)

#### 更改文件属性

更改文件属组

```
chgrp [-R] 属组名 文件名 
```

-R递归更改

更改文件属主，也可以同时更改文件属组

```
chown [-R] 属主名：属组名 文件名
```

更改文件9个属性

```
chmod [-R] xyz 文件或目录
chmod 777 test1
chmod u=rwx,g=rx,o=r test1
chmod  a-x test1 拿掉全部人的可执行权限
```

xyz为 rwx 属性数值的相加

#### 目录操作

遍历当前目录下所有的文件和目录

```
ls -[alh]

-a ：全部的文件，连同隐藏档(开头为 . 的文件)一起列出来
-d ：仅列出目录本身，而不是列出目录内的文件数据
-l ：长数据串列出，包含文件的属性与权限等等数据
-h：遍历详细信息，如权限，所属用户，创建日期，大小等等信息
```

```
ls / 显示根目录
ls [--color={never,auto,always}] 目录名称
ls [--full-time] 目录名称
```

切换目录

```
cd或cd ~ 回到根目录
cd ./runoob/ 
cd .. 
```

[ . ] 表示当前目录，[ .. ] 表示上一级目录

显示目前所在的目录

```
pwd [-P]
```

注意P为大写，显示出确实的路径，而非连结档本身的目录名

创建目录 

```
mkdir [-mp] 目录名称

-p：如果abc的父目录不存在，那么就会帮助创建其父目录
-m ：配置文件的权限

mkdir -m 711 test2
```

删除空的目录，如果有内容就不能删除

```
rmdir [-p] 目录名称
```

删除文件或目录

```
rm [-fir] 文件或目录
rm -r 目录
```

-f是强制删除的意思，-r表示递归删除，i会询问

复制文件

```
cp [-adfilprsu] 来源档(source) 目标档(destination)

-a：相当於 -pdr 的意思，至於 pdr 请参考下列说明；
-d：若来源档为连结档的属性(link file)，则复制连结档属性而非文件本身；
-f：为强制(force)的意思，若目标文件已经存在且无法开启，则移除后再尝试一次；
-i：若目标档(destination)已经存在时，在覆盖时会先询问动作的进行；
-l：进行硬式连结(hard link)的连结档创建，而非复制文件本身；
-p：连同文件的属性一起复制过去，而非使用默认属性(备份常用)；
-r：递归持续复制，用於目录的复制行为；
-s：复制成为符号连结档 (symbolic link)，亦即捷径文件；
-u：若 destination 比 source 旧才升级 destination ！

cp -i ~/.bashrc /tmp/bashrc
```

移动文件与目录，或修改名称

```
mv [-fiu] source destination
mv [options] source1 source2 source3 .... directory
```

options可以不用管

#### Linux 文件内容查看

cat 由第一行开始显示文件内容；tac 从最后一行开始显示，可以看出 tac 是 cat 的倒著写！；nl 显示的时候，顺道输出行号；more 一页一页的显示文件内容；less 与 more 类似，但是比 more 更好的是，他可以往前翻页；head 只看头几行；tail 只看尾巴几行

```
cat [-AbEnTv] 文件

-A ：相当於 -vET 的整合选项，可列出一些特殊字符而不是空白而已；
-b ：列出行号，仅针对非空白行做行号显示，空白行不标行号！
-E ：将结尾的断行字节 $ 显示出来；
-n ：列印出行号，连同空白行也会有行号，与 -b 的选项不同；
-T ：将 [tab] 按键以 ^I 显示出来；
-v ：列出一些看不出来的特殊字符
```

```
nl [-bnw] 文件
-b ：指定行号指定的方式，主要有两种：
-b a ：表示不论是否为空行，也同样列出行号(类似 cat -n)；
-b t ：如果有空行，空的那一行不要列出行号(默认值)；
-n ：列出行号表示的方法，主要有三种：
-n ln ：行号在荧幕的最左方显示；
-n rn ：行号在自己栏位的最右方显示，且不加 0 ；
-n rz ：行号在自己栏位的最右方显示，且加 0 ；
-w ：行号栏位的占用的位数
```

```
more /etc/man_db.config

空白键 (space)：代表向下翻一页；
Enter ：代表向下翻一行；
/字串 ：代表在这个显示的内容当中，向下搜寻字串这个关键字；
:f ：立刻显示出档名以及目前显示的行数；
q ：代表立刻离开 more ，不再显示该文件内容。
b 或 [ctrl]-b ：代表往回翻页，不过这动作只对文件有用，对管线无用
```

```
less /etc/man.config

空白键：向下翻动一页；
[pagedown]：向下翻动一页；
[pageup]  ：向上翻动一页；
/字串 ：向下搜寻字串的功能；
?字串 ：向上搜寻字串的功能；
n  ：重复前一个搜寻 (与 / 或 ? 有关！)
N  ：反向的重复前一个搜寻 (与 / 或 ? 有关！)
q  ：离开 less 这个程序；
```

```
head -n 20 /etc/man.config 默认显示前10行
tail -n 20 /etc/man.config
-n ：后面接数字，代表显示几行的意思
tail -50f /etc/passwd
-f：表示滚动查看，当这个文件发生变化的时候，会自动展示最新的内容，退出方式： ctrl+c
```

创建文件

```
# touch test.java
```

### 添加新的用户账号

```
useradd 选项 用户名
-c comment 指定一段注释性描述
-d 目录 指定用户主目录，如果此目录不存在，则同时使用-m选项，可以创建主目录
-g 用户组 指定用户所属的用户组
-G 用户组，用户组 指定用户所属的附加组
-s Shell文件 指定用户的登录Shell
-u 用户号 指定用户的用户号，如果同时有-o选项，则可以重复使用其他用户的标识号
```

创建了一个用户sam，其中-d和-m选项用来为登录名sam产生一个主目录 /home/sam

```
# useradd –d /home/sam -m sam
```

新建了一个用户 gem，该用户的登录 Shell 是 `/bin/sh` ，它属于 group 用户组，同时又属于 adm 和 root 用户组，其中group 用户组是其主组，Shell 是用户与 Linux 系统之间的接口

```
# useradd -s /bin/sh -g group –G adm,root gem
```

增加用户账号就是在 /etc/passwd 文件中为新用户增加一条记录，同时更新其他系统文件如 /etc/shadow， /etc/group 等

删除账号

```
userdel 选项 用户名
-r：把主目录一起删除
```

修改账号

```
usermod 选项 用户名

# usermod -s /bin/ksh -d /home/z –g developer sam
```

常用的选项包括 -c、-d、-m、-g、-G、-s、-u 以及 -o 等，这些选项的意义与`useradd`命令中的选项一样，有些系统可以使用选项：-l 新用户名

用户口令的管理

```
passwd 选项 用户名

-l 锁定口令，即禁用账号
-u 口令解锁
-d 使账号无口令
-f 强迫用户下次登录时修改口令
```

### 系统用户组的管理

增加一个新的用户组

```
groupadd 选项 用户组

-g GID 指定新用户组的组标识号（GID）
-o 一般与-g选项同时使用，表示新用户组的 GID 可以与系统已有用户组的 GID 相同

# groupadd group1
# groupdel group1
```

修改用户组的属性

```
groupmod 选项 用户组

-g GID 为用户组指定新的组标识号。
-o 与-g选项同时使用，用户组的新GID可以与系统已有用户组的GID相同。
-n 新用户组 将用户组的名字改为新名字

# groupmod –g 10000 -n group3 group2
```

用户可以在登录后，使用命令 newgrp 切换到其他用户组

/etc/passwd文件

```
用户名:口令:用户标识号:组标识号:注释性描述:主目录:登录Shell
```

/etc/shadow文件

```
登录名:加密口令:最后一次修改时间:最小时间间隔:最大时间间隔:警告时间:不活动时间:失效时间:标志
```

1. "登录名"是与/etc/passwd文件中的登录名相一致的用户账号
2. "口令"字段存放的是加密后的用户口令字，长度为13个字符。如果为空，则对应用户没有口令，登录时不需要口令；如果含有不属于集合 { ./0-9A-Za-z }中的字符，则对应的用户不能登录。
3. "最后一次修改时间"表示的是从某个时刻起，到用户最后一次修改口令时的天数。时间起点对不同的系统可能不一样。例如在SCO Linux 中，这个时间起点是1970年1月1日
4. "最小时间间隔"指的是两次修改口令之间所需的最小天数
5. "最大时间间隔"指的是口令保持有效的最大天数
6. "警告时间"字段表示的是从系统开始警告用户到用户密码正式失效之间的天数
7. "不活动时间"表示的是用户没有登录活动但账号仍能保持有效的最大天数
8. "失效时间"字段给出的是一个绝对的天数，如果使用了这个字段，那么就给出相应账号的生存期。期满后，该账号就不再是一个合法的账号，也就不能再用来登录了

/etc/group文件

```
组名:口令:组标识号:组内用户列表
```

#### 添加批量步骤

首先创建文本用户文件user.txt和密码对照文件passwd.txt

```
user001::600:100:user:/home/user001:/bin/bash
user002::601:100:user:/home/user002:/bin/bash
...

user001:密码
user002:密码
...
```

以root身份执行命令 `/usr/sbin/newusers`，从刚创建的用户文件`user.txt`中导入数据，再执行命令/usr/sbin/pwunconv，将 `/etc/shadow` 产生的 `shadow` 密码解码，然后回写到 `/etc/passwd` 中，并将`/etc/shadow`的`shadow`密码栏删掉

```
# newusers < user.txt
# pwunconv
```

以root身份执行命令 `/usr/sbin/chpasswd`，创建用户密码，`chpasswd` 会将经过 `/usr/bin/passwd` 命令编码过的密码写入 `/etc/passwd` 的密码栏，执行命令 `/usr/sbin/pwconv` 将密码编码为 `shadow password`，并将结果写入 `/etc/shadow`

```
# chpasswd < passwd.txt
# pwconv
```

### Linux 磁盘管理

列出文件系统的整体磁盘使用量

```
df [-ahikHTm] [目录或文件名]

-a ：列出所有的文件系统，包括系统特有的 /proc 等文件系统
-k ：以 KBytes 的容量显示各文件系统
-m ：以 MBytes 的容量显示各文件系统
-h ：以人们较易阅读的 GBytes, MBytes, KBytes 等格式自行显示
-H ：以 M=1000K 取代 M=1024K 的进位方式
-T ：显示文件系统类型, 连同该 partition 的 filesystem 名称 (例如 ext3) 也列出
-i ：不用硬盘容量，而以 inode 的数量来显示
```

在 Linux 底下如果 df 没有加任何选项，那么默认会将系统内所有的 (不含特殊内存内的文件系统与 swap) 都以 1 Kbytes 的容量列出来

检查磁盘空间使用量

```
du [-ahskm] 文件或目录名称

-a ：列出所有的文件与目录容量，因为默认仅统计目录底下的文件量而已
-h ：以人们较易读的容量格式 (G/M) 显示
-s ：列出总量而已，而不列出每个各别的目录占用容量
-S ：不包括子目录下的总计，与 -s 有点差别
-k ：以 KBytes 列出容量显示
-m ：以 MBytes 列出容量显示
```

与 df 不一样的是， u 这个命令其实会直接到文件系统内去搜寻所有的文件数据

```
[root@www ~]# du   #只列出当前目录下的所有文件夹容量（包括隐藏文件夹）
8       ./test4     <==每个目录都会列出来
8       ./test2
....中间省略....
12      ./.gconfd   <==包括隐藏文件的目录
220     .           <==这个目录(.)所占用的总量

[root@www ~]# du -a   #将文件的容量也列出来
[root@www ~]# du -sm /*   #检查根目录底下每个目录所占用的容量
```

磁盘分区

输出装置分区

```
fdisk [-l] 装置名称

-l ：输出后面接的装置所有的分区内容。若仅有 fdisk -l 时， 则系统将会把整个系统内能够搜寻到的装置的分区均列出来
```

找出你系统中的根目录所在磁盘，并查阅该硬盘内的相关信息

```
[root@www ~]# df /           
Filesystem           1K-blocks      Used Available Use% Mounted on
/dev/hdc2              9920624   3823168   5585388  41% /

[root@www ~]# fdisk /dev/hdc  <==仔细看，不要加上数字喔！
...
Command (m for help):     <==等待你的输入！
Command (m for help): m 
Command action
   a   toggle a bootable flag
   b   edit bsd disklabel
   c   toggle the dos compatibility flag
   d   delete a partition            <==删除一个partition
   l   list known partition types
   m   print this menu
   n   add a new partition           <==新增一个partition
   o   create a new empty DOS partition table
   p   print the partition table     <==在屏幕上显示分割表
   q   quit without saving changes   <==不储存离开fdisk程序
   s   create a new empty Sun disklabel
   t   change a partition's system id
   u   change display/entry units
   v   verify the partition table
   w   write table to disk and exit  <==将刚刚的动作写入分割表
   x   extra functionality (experts only)
Command (m for help): p  <== 这里可以输出目前磁盘的状态

Disk /dev/hdc: 41.1 GB, 41174138880 bytes        <==这个磁盘的文件名与容量
255 heads, 63 sectors/track, 5005 cylinders      <==磁头、扇区与磁柱大小
Units = cylinders of 16065 * 512 = 8225280 bytes <==每个磁柱的大小
# 装置文件名 启动区否 开始磁柱    结束磁柱  1K大小容量 磁盘分区槽内的系统
   Device Boot      Start         End      Blocks   Id  System
/dev/hdc1   *           1          13      104391   83  Linux
Command (m for help): q  <== 不保存退出
```

#### 磁盘格式化

 `mkfs`（make filesystem）

```
mkfs [-t 文件系统格式] 装置文件名

-t ：可以接文件系统格式，例如 ext3, ext2, vfat 等(系统有支持才会生效)
```

查看 mkfs 支持的文件格式

```
[root@www ~]# mkfs[tab][tab]
```

将分区 /dev/hdc6（可指定你自己的分区） 格式化为 ext3 文件系统

```
[root@www ~]# mkfs -t ext3 /dev/hdc6
mke2fs 1.39 (29-May-2006)
Filesystem label=                <==这里指的是分割槽的名称(label)
OS type: Linux
Block size=4096 (log=2)          <==block 的大小配置为 4K 
Fragment size=4096 (log=2)
251392 inodes, 502023 blocks     <==由此配置决定的inode/block数量
...
Creating journal (8192 blocks): done <==有日志记录
```

#### 磁盘检验

fsck（file system check）用来检查和维护不一致的文件系统。若系统掉电或磁盘发生问题，可利用fsck命令对文件系统进行检查。

```
fsck [-t 文件系统] [-ACay] 装置名称

-t : 给定档案系统的型式，若在 /etc/fstab 中已有定义或 kernel 本身已支援的则不需加上此参数
-s : 依序一个一个地执行 fsck 的指令来检查
-A : 对/etc/fstab 中所有列出来的 分区（partition）做检查
-C : 显示完整的检查进度
-d : 打印出 e2fsck 的 debug 结果
-p : 同时有 -A 条件时，同时有多个 fsck 的检查一起执行
-R : 同时有 -A 条件时，省略 / 不检查
-V : 详细显示模式
-a : 如果检查有错则自动修复
-r : 如果检查有错则由使用者回答是否修复
-y : 选项指定检测每个文件是自动输入yes，在不确定哪些是不正常的时候，可以执行 # fsck -y 全部检查修复
```

强制检测 /dev/hdc6 分区

```
[root@www ~]# fsck -C -f -t ext3 /dev/hdc6 
```

 -f ：强制检查，一项一项的显示过程

#### 磁盘挂载与卸除

Linux 的磁盘挂载使用 `mount` 命令，卸载使用 `umount` 命令

```
mount [-t 文件系统] [-L Label名] [-o 额外选项] [-n]  装置文件名  挂载点
umount [-fn] 装置文件名或挂载点

-f ：强制卸除！可用在类似网络文件系统 (NFS) 无法读取到的情况下；
-n ：不升级 /etc/mtab 情况下卸除
```

将刚刚创建的 /dev/hdc6 挂载到 /mnt/hdc6 上面

```
[root@www ~]# mkdir /mnt/hdc6
[root@www ~]# mount /dev/hdc6 /mnt/hdc6
[root@www ~]# df
[root@www ~]# umount /dev/hdc6     
```

### Linux vi/vim

基本上 vi/vim 共分为三种模式，分别是**命令模式（Command mode）**，**输入模式（Insert mode）**和**底线命令模式（Last line mode）**

- 命令模式：用户刚刚启动 vi/vim，便进入了命令模式 

- 输入模式：在命令模式下按下i就进入了输入模式 

  Insert：切换光标为输入/替换模式，光标将变成竖线/下划线

  在编辑模式当中，你可以发现在左下角状态栏中会出现 –INSERT- 的字样

- 底线命令模式：在命令模式下按下:（英文冒号）就进入了底线命令模式


#### 一般模式可用的光标移动、复制粘贴、搜索替换

h、j、k、l分别表示左下上右，如果想要进行多次移动的话，例如向下移动 30 行，可以使用 "30j" 或 "30↓" 的组合按键

| 上方插入行       |                                                              |
| ---------------- | ------------------------------------------------------------ |
| [Ctrl] + [f]     | 屏幕向下移动一页，相当于 [Page Down]按键 (常用)              |
| [Ctrl] + [b]     | 屏幕向上移动一页，相当于 [Page Up] 按键 (常用)               |
| [Ctrl] + [d]     | 屏幕向下移动半页                                             |
| [Ctrl] + [u]     | 屏幕向上移动半页                                             |
| +                | 光标移动到非空格符的下一行                                   |
| -                | 光标移动到非空格符的上一行                                   |
| n<space>         | 那个 n 表示『数字』，例如 20 。按下数字后再按空格键，光标会向右移动这一行的 n 个字符。例如 20<space> 则光标会向后面移动 20 个字符距离。 |
| 0 或功能键[Home] | 这是数字『0 ：移动到这一行的最前面字符处 (常用)              |
| $ 或功能键[End]  | 移动到这一行的最后面字符处(常用)                             |
| H                | 光标移动到这个屏幕的最上方那一行的第一个字符                 |
| M                | 光标移动到这个屏幕的中央那一行的第一个字符                   |
| L                | 光标移动到这个屏幕的最下方那一行的第一个字符                 |
| G                | 移动到这个档案的最后一行(常用)                               |
| nG               | n 为数字。移动到这个档案的第 n 行。例如 20G 则会移动到这个档案的第 20 行(可配合 :set nu) |
| gg               | 移动到这个档案的第一行，相当于 1G (常用)                     |
| n<Enter>         | n 为数字。光标向下移动 n 行(常用)                            |



| 搜索替换                                   |                                                              |
| :----------------------------------------- | ------------------------------------------------------------ |
| /word                                      | 向光标之下寻找一个名称为 word 的字符串。例如要在档案内搜寻 vbird 这个字符串，就输入 /vbird 即可！ (常用) |
| ?word                                      | 向光标之上寻找一个字符串名称为 word 的字符串。               |
| n                                          | 这个 n 是英文按键。代表重复前一个搜寻的动作。                |
| N                                          | 这个 N 是英文按键。与 n 刚好相反，为『反向』进行前一个搜寻动作。 例如 /vbird 后，按下 N 则表示向上搜寻 vbird 。 |
| :n1,n2s/word1/word2/g                      | n1 与 n2 为数字。在第 n1 与 n2 行之间寻找 word1 这个字符串，并将该字符串取代为 word2 (常用) |
| :1,$s/word1/word2/g 或 :%s/word1/word2/g   | 从第一行到最后一行寻找 word1 字符串，并将该字符串取代为 word2 (常用) |
| :1,$s/word1/word2/gc 或 :%s/word1/word2/gc | 从第一行到最后一行寻找 word1 字符串，并将该字符串取代为 word2 ，且在取代前显示提示字符给用户确认 (confirm) 是否需要取代！(常用) |

：s/vivian/sky/ 替换当前行第一个 vivian 为 sky 

：%s/vivian/sky/（等同于 ：g/vivian/s//sky/） 替换每一行的第一个 vivian 为 sky 

| 删除、复制与贴上 |                                                              |
| :--------------- | ------------------------------------------------------------ |
| x, X             | 在一行字当中，x 为向后删除一个字符 (相当于 [del] 按键)， X 为向前删除一个字符(相当于 [backspace] 亦即是退格键) (常用) |
| nx               | n 为数字，连续向后删除 n 个字符。举例来说，我要连续删除 10 个字符，[10x] |
| dd               | 删除游标所在的那一整行(常用)                                 |
| ndd              | n 为数字。删除光标所在的向下 n 行，例如 20dd 则是删除 20 行 (常用) |
| d1G              | 删除光标所在行到第一行的所有数据                             |
| dG               | 删除光标所在行到最后一行的所有数据                           |
| d$               | 删除游标所在处，到该行的最后一个字符                         |
| d0               | 那个是数字的 0 ，删除游标所在处，到该行的最前面一个字符      |
| yy               | 复制游标所在的那一行(常用)                                   |
| nyy              | n 为数字。复制光标所在的向下 n 行，例如 20yy 则是复制 20 行(常用) |
| y1G              | 复制游标所在行到第一行的所有数据                             |
| yG               | 复制游标所在行到最后一行的所有数据                           |
| y0               | 复制光标所在的那个字符到该行行首的所有数据                   |
| y$               | 复制光标所在的那个字符到该行行尾的所有数据                   |
| p, P             | p 为将已复制的数据在光标下一行贴上，P 则为贴在游标上一行！ 举例来说，我目前光标在第 20 行，且已经复制了 10 行数据。则按下 p 后， 那 10 行数据会贴在原本的 20 行之后，亦即由 21 行开始贴。但如果是按下 P 呢？ 那么原本的第 20 行会被推到变成 30 行(常用) |
| J                | 将光标所在行与下一行的数据结合成同一行                       |
| c                | 重复删除多个数据，例如向下删除 10 行，[ 10cj ]               |
| u                | 复原前一个动作(常用)                                         |
| [Ctrl]+r         | 重做上一个动作(常用)                                         |
| .                | 就是小数点，重复前一个动作，如果你想要重复删除、重复贴上等等动作，按下小数点 [ . ] 就好了 (常用) |

#### 一般模式切换到编辑模式的可用的按钮说明

| i, I | 进入输入模式(Insert mode)： i 为从目前光标所在处输入， I 为在目前所在行的第一个非空格符处开始输入 |
| :--- | ------------------------------------------------------------ |
| a,A  | 进入输入模式(Insert mode)： a 为从目前光标所在的下一个字符处开始输入， A 为从光标所在行的最后一个字符处开始输入 |
| o,O  | 进入输入模式(Insert mode)：o 为在目前光标所在的下一行处输入新的一行； O 为在目前光标所在处的上一行输入新的一行 |
| r,R  | 进入取代模式(Replace mode)： r 只会取代光标所在的那一个字符一次，R 会一直取代光标所在的文字，直到按下 ESC 为止 |

#### 一般模式切换到指令行模式的可用的按钮说明

| :wq                 | 储存后离开，若为 :wq! 则为强制储存后离开 (常用)              |
| ------------------- | ------------------------------------------------------------ |
| ZZ                  | 若档案没有更动，则不储存离开，若档案已经被更动过，则储存后离开 |
| :w [filename]       | 将编辑的数据储存成另一个档案（类似另存新档）                 |
| :r [filename]       | 在编辑的数据中，读入另一个档案的数据。亦即将 『filename』 这个档案内容加到游标所在行后面 |
| :n1,n2 w [filename] | 将 n1 到 n2 的内容储存成 filename 这个档案                 |
| :! command          | 暂时离开 vi 到指令行模式下执行 command 的显示结果。例如 [ :! ls /home ]即可在 vi 当中察看 /home 底下以 ls 输出的档案信息 |
| :set nu             | 显示行号，设定之后，会在每一行的前缀显示该行的行号           |
| :set nonu           | 与 set nu 相反，为取消行号                                 |

编辑abc.txt 

vi abc.txt，如果文件不存在，会自动创建；要进行编辑，先输入 a 、 i或者o；要退出，先点击左上角的ESC键，输入冒号后接着输入wq，然后敲回车，即保存退出，如果不保存就敲q!

### 其它命令

![](https://massionter-images-1258860804.cos.ap-guangzhou.myqcloud.com/zcayo/18401619-61512e8c0c0059c1.png)

### linux yum 命令

yum（ Yellow dog Updater, Modified）是一个在Fedora和RedHat以及SUSE中的Shell前端软件包管理器，基於RPM包管理，能够从指定的服务器自动下载RPM包并且安装

```
yum [options] [command] [package ...]
-options：可选，选项包括-h（帮助），-y（当安装过程提示选择全部为"yes"），-q（不显示安装的过程）等等
-command：要进行的操作
-package：操作的对象
```

#### yum常用命令

- 列出所有可更新的软件清单命令：yum check-update
- 更新所有软件命令：yum update
- 仅安装指定的软件命令：yum install <package_name>
- 仅更新指定的软件命令：yum update <package_name>
- 列出所有可安裝的软件清单命令：yum list
- 删除软件包命令：yum remove <package_name>
- 查找软件包 命令：yum search <keyword>
- 清除缓存命令:
  - yum clean packages: 清除缓存目录下的软件包
  - yum clean headers: 清除缓存目录下的 headers
  - yum clean oldheaders: 清除缓存目录下旧的 headers
  - yum clean, yum clean all (= yum clean packages; yum clean oldheaders) :清除缓存目录下的软件包及旧的headers

#### 修改yum源

将yum源设置为163 yum，可以提升软件包安装和更新的速度

首先备份

```
mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
```

下载对应版本 repo 文件, 放入 /etc/yum.repos.d/ (操作前请做好相应备份)

```
wget http://mirrors.163.com/.help/CentOS6-Base-163.repo
mv CentOS6-Base-163.repo CentOS-Base.repo
```

运行以下命令生成缓存

```
yum clean all
yum makecache
```

### Linux下Nginx 安装配置

Nginx("engine x")是一款是由俄罗斯的程序设计师Igor Sysoev所开发高性能的 Web和 反向代理 服务器，也是一个 IMAP/POP3/SMTP 代理服务器。在高连接并发的情况下，Nginx是Apache服务器不错的替代

#### 安装编译工具及库文件

```
yum -y install make zlib zlib-devel gcc-c++ libtool  openssl openssl-devel
```

#### 安装 PCRE

PCRE 作用是让 Nginx 支持 Rewrite 功能

```
[root@bogon src]# cd /usr/local/src/
[root@bogon src]# wget http://downloads.sourceforge.net/project/pcre/pcre/8.35/pcre-8.35.tar.gz
[root@bogon src]# tar zxvf pcre-8.35.tar.gz         #解压安装包
[root@bogon src]# cd pcre-8.35         #进入安装包目录
[root@bogon pcre-8.35]# ./configure         #编译安装 
[root@bogon pcre-8.35]# make && make install
[root@bogon pcre-8.35]# pcre-config --version         #查看pcre版本
```

#### 安装 Nginx

```
[root@bogon src]# cd /usr/local/src/
[root@bogon src]# wget http://nginx.org/download/nginx-1.6.2.tar.gz         #下载 Nginx
[root@bogon src]# tar zxvf nginx-1.6.2.tar.gz         #解压安装包
[root@bogon src]# cd nginx-1.6.2         #进入安装包目录
[root@bogon nginx-1.6.2]# ./configure --prefix=/usr/local/webserver/nginx --with-http_stub_status_module --with-http_ssl_module --with-pcre=/usr/local/src/pcre-8.35   #编译安装
[root@bogon nginx-1.6.2]# make
[root@bogon nginx-1.6.2]# make install
[root@bogon nginx-1.6.2]# /usr/local/webserver/nginx/sbin/nginx -v         #查看nginx版本
```

#### Nginx 配置

创建 Nginx 运行使用的用户 www

```
[root@bogon conf]# /usr/sbin/groupadd www 
[root@bogon conf]# /usr/sbin/useradd -g www www
```

配置nginx.conf ，将/usr/local/webserver/nginx/conf/nginx.conf替换为以下内容

```
[root@bogon conf]#  cat /usr/local/webserver/nginx/conf/nginx.conf

user www www;
worker_processes 2; #设置值和CPU核心数一致
error_log /usr/local/webserver/nginx/logs/nginx_error.log crit; #日志位置和日志级别
pid /usr/local/webserver/nginx/nginx.pid;
#Specifies the value for maximum file descriptors that can be opened by this process.
worker_rlimit_nofile 65535;
events
{
  use epoll;
  worker_connections 65535;
}
http
{
  include mime.types;
  default_type application/octet-stream;
  log_format main  '$remote_addr - $remote_user [$time_local] "$request" '
               '$status $body_bytes_sent "$http_referer" '
               '"$http_user_agent" $http_x_forwarded_for';
  
#charset gb2312;
     
  server_names_hash_bucket_size 128;
  client_header_buffer_size 32k;
  large_client_header_buffers 4 32k;
  client_max_body_size 8m;
     
  sendfile on;
  tcp_nopush on;
  keepalive_timeout 60;
  tcp_nodelay on;
  fastcgi_connect_timeout 300;
  fastcgi_send_timeout 300;
  fastcgi_read_timeout 300;
  fastcgi_buffer_size 64k;
  fastcgi_buffers 4 64k;
  fastcgi_busy_buffers_size 128k;
  fastcgi_temp_file_write_size 128k;
  gzip on; 
  gzip_min_length 1k;
  gzip_buffers 4 16k;
  gzip_http_version 1.0;
  gzip_comp_level 2;
  gzip_types text/plain application/x-javascript text/css application/xml;
  gzip_vary on;
 
  #limit_zone crawler $binary_remote_addr 10m;
 #下面是server虚拟主机的配置
 server
  {
    listen 80;#监听端口
    server_name localhost;#域名
    index index.html index.htm index.php;
    root /usr/local/webserver/nginx/html;#站点目录
      location ~ .*\.(php|php5)?$
    {
      #fastcgi_pass unix:/tmp/php-cgi.sock;
      fastcgi_pass 127.0.0.1:9000;
      fastcgi_index index.php;
      include fastcgi.conf;
    }
    location ~ .*\.(gif|jpg|jpeg|png|bmp|swf|ico)$
    {
      expires 30d;
  # access_log off;
    }
    location ~ .*\.(js|css)?$
    {
      expires 15d;
   # access_log off;
    }
    access_log off;
  }

}
```

检查配置文件nginx.conf的正确性命令

```
[root@bogon conf]# /usr/local/webserver/nginx/sbin/nginx -t
```

启动 Nginx

```
[root@bogon conf]# /usr/local/webserver/nginx/sbin/nginx
```

从浏览器访问我们配置的站点ip

#### Nginx 其他命令

```
/usr/local/webserver/nginx/sbin/nginx -s reload            # 重新载入配置文件
/usr/local/webserver/nginx/sbin/nginx -s reopen            # 重启 Nginx
/usr/local/webserver/nginx/sbin/nginx -s stop              # 停止 Nginx
```

