### java 中 equals 以及 == 的用法

对于字符串变量来说，== 比较两个变量本身的值，即两个对象在内存中的首地址，equals() 比较字符串中所包含的内容是否相同。对于非字符串变量来说，== 和 equals() 方法的作用是相同的都是用来比较其对象在堆内存的首地址，即用来比较两个引用变量是否指向同一个对象

```java
String s1,s2,s3 = "abc", s4 = "abc";
s1 = new String("abc");
s2 = new String("abc");
System.out.println("s1==s2:"+(s1==s2));   // false 两个变量的内存地址不一样，也就是它们指向的对象不一样
System.out.println(s1.equals(s2));         // true 两个变量的所包含的内容是 abc，故相等
System.out.println("s1==s3:"+(s1==s3));         // false
System.out.println("s1==s4:"+(s3==s4));         // true
System.out.println("s1.equals(s2):"+(s1.equals(s2)));         // true
System.out.println("s1.equals(s3):"+(s1.equals(s3)));         // true
System.out.println("s3.equals(s4):"+(s3.equals(s4)));         // true
```

注意：对于 s3 和 s4 来说，有一点不一样要引起注意，由于 s3 和 s4 是两个字符，串常量所生成的变量，其中所存放的内存地址是相等的，所以 s3 == s4 是true（即使没有 s3 = s4 这样一个赋值语句）

String 类中重新定义了 equals 这个方法，如果是基本类型比较，那么只能用==来比较，不能用 equals 。对于基本类型的包装类型，== 是比较地址的，而 equals 是比较内容的。java中，对象的首地址是它在内存中存放的起始地址，它后面的地址是用来存放它所包含的各个属性的地址，所以内存中会用多个内存块来存放对象的各个参数，而通过这个首地址就可以找到该对象，进而可以找到该对象的各个属性。Object 类中的 equals 方法是用来比较地址的