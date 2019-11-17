Git 是一个开源的分布式版本控制系统，用于敏捷高效地处理任何或小或大的项目。

Git 是 Linus Torvalds 为了帮助管理 Linux 内核开发而开发的一个开放源码的版本控制软件。

Git 与常用的版本控制工具 CVS, Subversion 等不同，它采用了分布式版本库的方式，不必服务器端软件支持

## Linux 平台上安装

Git 的工作需要调用 curl，zlib，openssl，expat，libiconv 等库的代码，所以需要先安装这些依赖工具。如果你使用的系统是 Centos/RedHat 安装命令为

```
$ yum install curl-devel expat-devel gettext-devel openssl-devel zlib-devel
$ yum -y install git-core
$ git --version
git version 1.7.1
```

也可以在官网下载源码包来安装，在安装指定系统的依赖包后，解压安装下载的源码包

```
$ tar -zxf git-1.7.2.2.tar.gz
$ cd git-1.7.2.2
$ make prefix=/usr/local all
$ sudo make prefix=/usr/local install
```

## Git 配置

Git 提供了一个叫做 git config 的工具，专门用来配置或读取相应的工作环境变量。这些环境变量，决定了 Git 在各个环节的具体工作方式和行为。这些变量可以存放在以下三个不同的地方

- `/etc/gitconfig` 文件：系统中对所有用户都普遍适用的配置。若使用 `git config` 时用 `--system` 选项，读写的就是这个文件。
- `~/.gitconfig` 文件：用户目录下的配置文件只适用于该用户。若使用 `git config` 时用 `--global` 选项，读写的就是这个文件。
- 工作目录中的 `.git/config` 文件（也就是当前项目的 Git 目录中的配置文件）：这里的配置仅仅针对当前项目有效。每一个级别的配置都会覆盖上层的相同配置，所以 `.git/config` 里的配置会覆盖 `/etc/gitconfig` 中的同名变量

### 用户信息

配置个人的用户名称和电子邮件地址

```
$ git config --global user.name "runoob"
$ git config --global user.email test@runoob.com
```

如果用了 **--global** 选项，那么更改的配置文件就是位于你用户主目录下的那个，以后你所有的项目都会默认使用这里配置的用户信息。如果要在某个特定的项目中使用其他名字或者电邮，只要去掉 --global 选项重新配置即可，新的设定保存在当前项目的 .git/config 文件里

Git默认使用的文本编辑器, 一般可能会是 Vi 或者 Vim，重新设置为 Emacs

```
$ git config --global core.editor emacs
```

解决合并冲突时使用哪种差异分析工具，改用成 vimdiff 

```
$ git config --global merge.tool vimdiff
```

### 查看配置信息

```
$ git config --list
http.postbuffer=2M
user.name=runoob
user.email=test@runoob.com
```

有时候会看到重复的变量名，那就说明它们来自不同的配置文件（比如 /etc/gitconfig 和 ~/.gitconfig），不过最终 Git 实际采用的是最后一个。这些配置我们也可以在 **~/.gitconfig** 或 **/etc/gitconfig** 看到

直接查阅某个环境变量的设定

```
$ git config user.name
runoob
```

## Git 工作流程

一般工作流程如下：

- 克隆 Git 资源作为工作目录。
- 在克隆的资源上添加或修改文件。
- 如果其他人修改了，你可以更新资源。
- 在提交前查看修改。
- 提交修改。
- 在修改完成后，如果发现错误，可以撤回提交并再次修改并提交

![git-process](https://zcayo.oss-cn-beijing.aliyuncs.com/%E5%9B%BE%E7%89%87/git-process.png)

### Git 工作区、暂存区和版本库

#### Git 工作区、暂存区和版本库概念

- **工作区：**就是你在电脑里能看到的目录
- **暂存区：**一般存放在 ".git目录下" 下的index文件（.git/index）中，所以我们把暂存区有时也叫作索引（index）
- **版本库：**工作区有一个隐藏目录.git，这个不算工作区，而是Git的版本库

![1352126739_7909](https://zcayo.oss-cn-beijing.aliyuncs.com/%E5%9B%BE%E7%89%87/1352126739_7909.jpg)

图中的 objects 标识的区域为 Git 的对象库，实际位于 ".git/objects" 目录下，里面包含了创建的各种对象及内容

当对工作区修改（或新增）的文件执行 "git add" 命令时，暂存区的目录树被更新，同时工作区修改（或新增）的文件内容被写入到对象库中的一个新的对象中，而该对象的ID被记录在暂存区的文件索引中。

当执行提交操作（git commit）时，暂存区的目录树写到版本库（对象库）中，master 分支会做相应的更新。即 master 指向的目录树就是提交时暂存区的目录树。

当执行 "git reset HEAD" 命令时，暂存区的目录树会被重写，被 master 分支指向的目录树所替换，但是工作区不受影响。

当执行 "git rm --cached <file>" 命令时，会直接从暂存区删除文件，工作区则不做出改变。

当执行 "git checkout ." 或者 "git checkout -- <file>" 命令时，会用暂存区全部或指定的文件替换工作区的文件。这个操作很危险，会清除工作区中未添加到暂存区的改动。

当执行 "git checkout HEAD ." 或者 "git checkout HEAD <file>" 命令时，会用 HEAD 指向的 master 分支中的全部或者部分文件替换暂存区和以及工作区中的文件。这个命令也是极具危险性的，因为不但会清除工作区中未提交的改动，也会清除暂存区中未提交的改动。

## Git 创建仓库

初始化一个 Git 仓库

```
git init   #使用当前目录作为Git仓库
git init newrepo   #使用其它仓库
```

在执行完成 **git init** 命令后，Git 仓库会生成一个 .git 目录，所有 Git 需要的数据和资源都存放在这个目录中，其他的项目目录保持不变（不像 SVN 会在每个子目录生成 .svn 目录，Git 只在仓库的根目录生成 .git 目录）

把几个文件纳入版本控制，需要先用 git add 命令告诉 Git 开始对这些文件进行跟踪，然后提交。将目录下以 .c 结尾及 README 文件提交到仓库中

```
$ git add *.c
$ git add README
$ git commit -m '初始化项目版本'
```

从现有 Git 仓库中拷贝项目（类似 **svn checkout**）

```
git clone <repo> <directory>
```

repo：Git 仓库，directory：本地目录，不加目录时为当前目录，执行该命令后，会在当前目录下创建一个名为grit的目录，其中包含一个 .git 的目录，用于保存下载下来的所有版本记录

克隆 Ruby 语言的 Git 代码仓库 Grit 到mygrit 目录

```
$ git clone git://github.com/schacon/grit.git mygrit
```

### 基本快照

Git 的工作就是创建和保存你项目的快照及与之后的快照进行对比

查看项目的当前状态将该文件添加到缓存

```
$ touch README
$ touch hello.php
$ git status -s   #查看项目的当前状态
$ git add README hello.php 
```

git status 以查看在你上次提交之后是否有修改， -s 参数以获得简短的结果输出

修改 README 文件后，查看项目状态显示为 AM，"AM" 状态的意思是，这个文件在我们将它添加到缓存之后又有改动

```
$ git add .   #加当前项目的所有文件
$ git status -s
A  README
A  hello.php
```

执行 git diff 来查看执行 git status 的结果的详细信息。git diff 命令显示已写入缓存与已修改但尚未写入缓存的改动的区别

- 尚未缓存的改动：**git diff**
- 查看已缓存的改动： **git diff --cached**
- 查看已缓存的与未缓存的所有改动：**git diff HEAD**
- 显示摘要而非整个 diff：**git diff --stat**

将缓存区内容添加到仓库中，Git 为你的每一个提交都记录你的名字与电子邮箱地址，所以第一步需要配置用户名和邮箱地址

```
$ git config --global user.name 'runoob'
$ git config --global user.email test@runoob.com
```

写入缓存，并提交对 hello.php 的所有改动

```
$ git add hello.php
$ git status -s
$ git commit -m '第一次版本提交'
```

如果你没有设置 -m 选项，Git 会尝试为你打开一个编辑器以填写提交信息

跳过git add 写入缓存（写入过缓存后修改了）直接提交

```
git commit -a
```

取消已缓存的内容

```
$ git reset HEAD hello.php
```

删除目录中的文件

```
git rm <file>
git rm -f <file>   #删除之前修改过并且已经放到暂存区域的话，强制
git rm --cached <file>   #从跟踪清单中删除，仍然希望保留在当前工作目录中
git rm –r 目录    #递归删除目录
```

移动或重命名一个文件、目录、软连接

```
$ git mv README  README.md
```

推上github

```
$ git push
```

未完待续。。。