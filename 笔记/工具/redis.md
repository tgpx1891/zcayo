Redis 是一个开源的使用 ANSI C 语言编写、支持网络、可基于内存也可持久化的日志型、Key-Value 数据库，并提供多种语言的 API。换句话说，Redis 就像是一个 HashMap，不过不是在 JVM 中运行，而是以一个独立进程的形式运行。一般说来，会被当作缓存使用。 因为它比数据库(mysql)快，所以常用的数据，可以考虑放在这里，这样就提高了性能。

### 下载

 windows版本的下载地址是 `http://redis.io/download `，点击进去之后会跳转到 github， 是一个开源项目，下载后需要自己编译生成exe文件，但是为了编译生成exe文件，又需要用到Visual Studio一套。redis-cli.exe 是客户端，redis-server 是服务端

### 运行

```
cd D:\software\redis-64.3.0.503
redis-server.exe			# 启动服务器
redis-cli.exe			# 启动客户端
127.0.0.1:6379>set hero gareen			# 向服务器设置键值
127.0.0.1:6379>get hero			# "gareen"
```

### 常用命令

 Redis 目前有5种数据类型，分别是 String（字符串）、List（列表）、Hash（字典）、Set（集合）和 Sorted Set（有序集合）， 不同的数据类型，有不同的命令方式 

####  String 字符串 

```
SET key value                   设置key=value
GET key                         获得键key对应的值
GETRANGE key start end          得到字符串的子字符串存放在一个键
GETSET key value                设置键的字符串值，并返回旧值
GETBIT key offset               返回存储在键位值的字符串值的偏移
MGET key1 [key2..]              得到所有的给定键的值
SETBIT key offset value         设置或清除该位在存储在键的字符串值偏移
SETEX key seconds value         键到期时设置值
SETNX key value                 设置键的值，只有当该键不存在
SETRANGE key offset value       覆盖字符串的一部分从指定键的偏移
STRLEN key                      得到存储在键的值的长度
MSET key value [key value...]   设置多个键和多个值
MSETNX key value [key value...] 设置多个键多个值，只有在当没有按键的存在时
PSETEX key milliseconds value   设置键的毫秒值和到期时间
INCR key                        增加键的整数值一次
INCRBY key increment            由给定的数量递增键的整数值
INCRBYFLOAT key increment       由给定的数量递增键的浮点值
DECR key                        递减键一次的整数值
DECRBY key decrement            由给定数目递减键的整数值
APPEND key value                追加值到一个键
DEL key                         如果存在删除键
DUMP key                        返回存储在指定键的值的序列化版本
EXISTS key                      此命令检查该键是否存在
EXPIRE key seconds              指定键的过期时间
EXPIREAT key timestamp         指定的键过期时间。在这里，时间是在Unix时间戳格式
PEXPIRE key milliseconds        设置键以毫秒为单位到期
PEXPIREAT key milliseconds-timestamp        设置键在Unix时间戳指定为毫秒到期
KEYS pattern                    查找与指定模式匹配的所有键
MOVE key db                     移动键到另一个数据库
PERSIST key                     移除过期的键
PTTL key                        以毫秒为单位获取剩余时间的到期键
TTL key                         获取键到期的剩余时间
RANDOMKEY                       从Redis返回随机键
RENAME key newkey               更改键的名称
RENAMENX key newkey             重命名键，如果新的键不存在
TYPE key                        返回存储在键的数据类型的值
# 测试数据
set google http://www.google
append google .com
get google
set visitors 0
incr visitors
incr visitors
get visitors
incrby visitors 100
get visitors
type google
type visitors
ttl google
rename google google-site
get google
get google-site
```

####  List 列表 

```
BLPOP key1 [key2 ] timeout     取出并获取列表中的第一个元素，或阻塞，直到有可用
BRPOP key1 [key2 ] timeout 	   取出并获取列表中的最后一个元素，或阻塞，直到有可用
BRPOPLPUSH source destination timeout 从列表中弹出一个值，它推到另一个列表并返回它;或阻塞，直到有可用
LINDEX key index 			  从一个列表其索引获取对应的元素
LINSERT key BEFORE|AFTER pivot value 在列表中的其他元素之后或之前插入一个元素
LLEN key 				     获取列表的长度
LPOP key 				     获取并取出列表中的第一个元素
LPUSH key value1 [value2] 	  在前面加上一个或多个值的列表
LPUSHX key value 			 在前面加上一个值列表，仅当列表中存在
LRANGE key start stop 		 从一个列表获取各种元素
LREM key count value 		 从列表中删除元素
LSET key index value 		 在列表中的索引设置一个元素的值
LTRIM key start stop 		 修剪列表到指定的范围内
RPOP key 				    取出并获取列表中的最后一个元素
RPOPLPUSH source destination 删除最后一个元素的列表，将其附加到另一个列表并返回它
RPUSH key value1 [value2] 	 添加一个或多个值到列表
RPUSHX key value			添加一个值列表，仅当列表中存在
# 测试数据
lpush list1 redis
lpush list1 hello
rpush list1 world
llen list1
lrange list1 0 3
lpop list1
rpop list1
lrange list1 0 3
```

####  Hash 字典 

```
HDEL key field[field...] 		删除对象的一个或几个属性域，不存在的属性将被忽略
HEXISTS key field 				查看对象是否存在该属性域
HGET key field 					获取对象中该field属性域的值
HGETALL key 					获取对象的所有属性域和值
HINCRBY key field value 	将该对象中指定域的值增加给定的value，原子自增操作，只能是integer的属性值可以使用
HINCRBYFLOAT key field increment 将该对象中指定域的值增加给定的浮点数
HKEYS key 						获取对象的所有属性字段
HVALS key 						获取对象的所有属性值
HLEN key 						获取对象的所有属性字段的总数
HMGET key field[field...]		 获取对象的一个或多个指定字段的值
HSET key field value 			设置对象指定字段的值
HMSET key field value [field value ...] 同时设置对象中一个或多个字段的值
HSETNX key field value 			只在对象不存在指定的字段时才设置字段的值
HSTRLEN key field 				返回对象指定field的value的字符串长度，如果该对象或者field不存在，返回0.
HSCAN key cursor [MATCH pattern] [COUNT count] 类似SCAN命令
# 测试数据
hset person name jack
hset person age 20
hset person sex female
hgetall person
hkeys person
hvals person
```

####  Set 集合 

```
SADD key member [member ...] 					添加一个或者多个元素到集合(set)里
SCARD key 									获取集合里面的元素数量
SDIFF key [key ...] 						获得队列不存在的元素
SDIFFSTORE destination key [key ...] 			获得队列不存在的元素，并存储在一个关键的结果集
SINTER key [key ...] 						获得两个集合的交集
SINTERSTORE destination key [key ...] 			获得两个集合的交集，并存储在一个集合中
SISMEMBER key member 							确定一个给定的值是一个集合的成员
SMEMBERS key 									获取集合里面的所有key
SMOVE source destination member 				移动集合里面的一个key到另一个集合
SPOP key [count] 								获取并删除一个集合里面的元素
SRANDMEMBER key [count] 						从集合里面随机获取一个元素
SREM key member [member ...] 					从集合里删除一个或多个元素，不存在的元素会被忽略
SUNION key [key ...] 						  添加多个set元素
SUNIONSTORE destination key [key ...] 			合并set元素，并将结果存入新的set里面
SSCAN key cursor [MATCH pattern] [COUNT count]   迭代set里面的元素
# 测试数据
SADD myset "Hello"
SADD myset "World"
SMEMBERS myset
SADD myset "one"
SISMEMBER myset "one"
SISMEMBER myset "two"
```

####  Sorted Set 有序集合 

```
ZADD key score1 member1 [score2 member2] 		添加一个或多个成员到有序集合，或者如果它已经存在更新其分数
ZCARD key 									得到的有序集合成员的数量
ZCOUNT key min max 							计算一个有序集合成员与给定值范围内的分数
ZINCRBY key increment member 				在有序集合增加成员的分数
ZINTERSTORE destination numkeys key [key ...] 多重交叉排序集合，并存储生成一个新的键有序集合。
ZLEXCOUNT key min max 						计算一个给定的字典范围之间的有序集合成员的数量
ZRANGE key start stop [WITHSCORES] 			由索引返回一个成员范围的有序集合（从低到高）
ZRANGEBYLEX key min max [LIMIT offset count]	返回一个成员范围的有序集合（由字典范围）
ZRANGEBYSCORE key min max [WITHSCORES] [LIMIT] 返回有序集key中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员，有序集成员按 score 值递增(从小到大)次序排列
ZRANK key member 							确定成员的索引中有序集合
ZREM key member [member ...] 				从有序集合中删除一个或多个成员，不存在的成员将被忽略
ZREMRANGEBYLEX key min max 					删除所有成员在给定的字典范围之间的有序集合
ZREMRANGEBYRANK key start stop 				在给定的索引之内删除所有成员的有序集合
ZREMRANGEBYSCORE key min max 				在给定的分数之内删除所有成员的有序集合
ZREVRANGE key start stop [WITHSCORES] 		返回一个成员范围的有序集合，通过索引，以分数排序，从高分到低分
ZREVRANGEBYSCORE key max min [WITHSCORES] 	返回一个成员范围的有序集合，以socre排序从高到低
ZREVRANK key member 						确定一个有序集合成员的索引，以分数排序，从高分到低分
ZSCORE key member 							获取给定成员相关联的分数在一个有序集合
ZUNIONSTORE destination numkeys key [key ...] 添加多个集排序，所得排序集合存储在一个新的键
ZSCAN key cursor [MATCH pattern] [COUNT count]	增量迭代排序元素集和相关的分数
# 测试数据
zadd dbs 100 redis
zadd dbs 98 memcached
zadd dbs 99 mongodb
zadd dbs 99 leveldb
zcard dbs
zcount dbs 10 99
zrank dbs leveldb
zrank dbs other
zrangebyscore dbs 98 100
```

 redis 官方命令手册 `http://www.redis.cn/commands.html`

### Jedis

 在常见命令中，使用各种 Redis 自带客户端的命令行方式访问Redis服务。 而在实际工作中却需要用到Java代码才能访问，使用第三方 jar 包 ：Jedis 就能方便地访问 Redis 的各种服务了 

```java
// TestJedis.java
package redis;
import redis.clients.jedis.Jedis;
public class TestRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
    }     
}
// TestRedisManyCommands.java
package redis;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool; 
public class TestRedisManyCommands { 
    JedisPool pool; 
    Jedis jedis; 
    @Before 
    public void setUp() { 
        jedis = new Jedis("localhost");    
    } 
    // Redis 存储初级的字符串，CRUD
    @Test 
    public void testBasicString(){ 
        // 添加数据
        jedis.set("name","meepo");			// 向key->name中放入了value->meepo 
        System.out.println(jedis.get("name"));			// 结果 meepo
        // 修改数据 
        jedis.append("name","dota");			// 将dota append 到已经有的value之后 
        System.out.println(jedis.get("name"));			// 结果 meepodota  
        jedis.set("name","poofu");			// 直接覆盖原来的数据
        System.out.println(jedis.get("name"));			// 结果 poofu 
        jedis.del("name");			// 删除key对应的记录 
        System.out.println(jedis.get("name"));			// 结果 null 
        // mset相当于 jedis.set("name","meepo");、jedis.set("dota","poofu");
        jedis.mset("name","meepo","dota","poofu"); 
        System.out.println(jedis.mget("name","dota")); 
    } 
    // jedis 操作 Map
    @Test 
    public void testMap(){ 
        Map<String,String> user=new HashMap<String,String>(); 
        user.put("name","meepo"); 
        user.put("pwd","password"); 
        jedis.hmset("user",user);  
        List<String> rsmap = jedis.hmget("user", "name");	// 取出user中的name，结果是一个泛型的List
        System.out.println(rsmap);			// [meepo]
        jedis.hdel("user","pwd");			// 删除map中的某个键值 
        System.out.println(jedis.hmget("user", "pwd")); 		// 因为删除了，所以返回的是null 
        System.out.println(jedis.hlen("user"));			 // 返回key为user的键中存放的值的个数 1 
        System.out.println(jedis.exists("user"));			// 是否存在key为user的记录 返回true 
        System.out.println(jedis.hkeys("user"));			// 返回map对象中的所有key [pwd, name] 
        System.out.println(jedis.hvals("user"));		// 返回map对象中的所有value [meepo, password] 
        Iterator<String> iter=jedis.hkeys("user").iterator(); 
        while (iter.hasNext()){ 
            String key = iter.next(); 
            System.out.println(key+":"+jedis.hmget("user",key)); 
        } 
    } 
    // jedis 操作 List
    @Test 
    public void testList(){ 
        jedis.del("java framework"); 			// 先移除所有的内容
       // 先向key java framework中存放三条数据 
       jedis.lpush("java framework","spring"); 
       jedis.lpush("java framework","struts"); 
       jedis.lpush("java framework","hibernate"); 
       //再取出所有数据jedis.lrange是按范围取出， 
       // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有 
       System.out.println(jedis.lrange("java framework",0,-1)); 
    } 
 
    // jedis 操作 Set
    @Test 
    public void testSet(){ 
        // 添加数据
        jedis.sadd("sname","meepo"); 
        jedis.sadd("sname","dota"); 
        jedis.sadd("sname","poofu"); 
        jedis.sadd("sname","noname"); 
        jedis.srem("sname","noname");			// 移除noname
        System.out.println(jedis.smembers("sname"));			// 获取所有加入的value 
        System.out.println(jedis.sismember("sname", "meepo"));		// 判断 meepo 是否是sname集合的元素 
        System.out.println(jedis.srandmember("sname"));			// 从集合里面随机获取一个元素
        System.out.println(jedis.scard("sname"));			// 返回集合的元素个数 
    } 
    @Test 
    public void test() throws InterruptedException { 
        // 返回当前库中所有的key [sose, sanme, name, dota, foo, sname, java framework, user, braand] 
        System.out.println(jedis.keys("*"));	
        System.out.println(jedis.keys("*name"));			// 返回的sname [sname, name] 
        // 删除key为sanmdde的对象  删除成功返回1 删除失败（或者不存在）返回 0 
        System.out.println(jedis.del("sanmdde"));
        System.out.println(jedis.ttl("sname"));			// 返回给定key的有效时间，如果是-1则表示永远有效 
        jedis.setex("timekey", 10, "min");		// 设定键值顺便可以指定key的存活（有效时间）时间为秒 
        Thread.sleep(5000);			// 睡眠5秒后，剩余时间将为<=5 
        System.out.println(jedis.ttl("timekey"));			// 输出结果为5 
        jedis.setex("timekey", 1, "min");        // 设为1后，下面再看剩余时间就是1了 
        System.out.println(jedis.ttl("timekey"));			// 输出结果为1 
        System.out.println(jedis.exists("key"));		// 检查key是否存在 
        System.out.println(jedis.rename("timekey","time"));			// 重命名 key
        System.out.println(jedis.get("timekey"));			// 因为重命名，返回为null 
        System.out.println(jedis.get("time"));			// 结果 min 
        //jedis 排序，rpush和lpush是List的操作
        jedis.del("a");			// 先清除数据，再加入数据进行测试 
        jedis.rpush("a", "1"); 
        jedis.lpush("a","6"); 
        jedis.lpush("a","3"); 
        jedis.lpush("a","9"); 
        System.out.println(jedis.lrange("a",0,-1));			// 结果 [9, 3, 6, 1] 
        System.out.println(jedis.sort("a"));			// 输出排序后结果 [1, 3, 6, 9] 
    } 
}
```

### Spring 集成

- 设置连接 Redis 服务器的相关信息；
- 创建 applicationContext.xml ，配置连接池，连接工厂等，都是为了RedisTemplate 服务，这个类就提供常用的访问 Redis 的方法。然后又把这个 RedisTemplate 类的实例，注入到 RedisUtil 工具类里，方便调用；
- 创建 RedisUtil 工具类，封装了 RedisTemplate 这个类，以提供更为便利的 对于 Redis 的访问 

```java
// redis.properties
#ip地址
redis.hostName=127.0.0.1
#端口号
redis.port=6379
#如果有密码
redis.password=
#客户端超时时间单位是毫秒 默认是2000
redis.timeout=2000
#最大空闲数
redis.maxIdle=10
#连接池的最大数据库连接数。设为0表示无限制,如果是jedis 2.4以后用redis.maxTotal
redis.maxActive=10
#控制一个pool可分配多少个jedis实例,用来替换上面的redis.maxActive,如果是jedis 2.4以后用该属性
redis.maxTotal=10
#最大建立连接等待时间。如果超过此时间将接到异常。设为-1表示无限制。
redis.maxWaitMillis=1000
#连接的最小空闲时间 默认1800000毫秒(30分钟)
redis.minEvictableIdleTimeMillis=300000
#每次释放连接的最大数目,默认3
redis.numTestsPerEvictionRun=1024
#逐出扫描的时间间隔(毫秒) 如果为负数，则不运行逐出线程, 默认-1
redis.timeBetweenEvictionRunsMillis=30000
#是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
redis.testOnBorrow=false
#在空闲时检查有效性, 默认false
redis.testWhileIdle=false
// applicationContext.xml
<?xml version="1.0" encoding="UTF-8"?> 
<beans xmlns="http://www.springframework.org/schema/beans"   
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"   
    xmlns:context="http://www.springframework.org/schema/context"   
    xmlns:mvc="http://www.springframework.org/schema/mvc"   
    xmlns:cache="http://www.springframework.org/schema/cache" 
    xsi:schemaLocation="http://www.springframework.org/schema/beans     
                        http://www.springframework.org/schema/beans/spring-beans-4.2.xsd     
                        http://www.springframework.org/schema/context     
                        http://www.springframework.org/schema/context/spring-context-4.2.xsd     
                        http://www.springframework.org/schema/mvc     
                        http://www.springframework.org/schema/mvc/spring-mvc-4.2.xsd 
                        http://www.springframework.org/schema/cache  
                        http://www.springframework.org/schema/cache/spring-cache-4.2.xsd">
    <!-- 加载配置文件 -->
    <context:property-placeholder location="classpath:*.properties" />
    <!-- redis连接池配置--> 
    <bean id="jedisPoolConfig" class="redis.clients.jedis.JedisPoolConfig" > 
        <!--最大空闲数--> 
        <property name="maxIdle" value="${redis.maxIdle}" /> 
        <!--连接池的最大数据库连接数  -->
        <property name="maxTotal" value="${redis.maxTotal}" />
        <!--最大建立连接等待时间--> 
        <property name="maxWaitMillis" value="${redis.maxWaitMillis}" /> 
        <!--逐出连接的最小空闲时间 默认1800000毫秒(30分钟)-->
        <property name="minEvictableIdleTimeMillis" value="${redis.minEvictableIdleTimeMillis}" />
        <!--每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3-->
        <property name="numTestsPerEvictionRun" value="${redis.numTestsPerEvictionRun}" />
        <!--逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1-->
        <property name="timeBetweenEvictionRunsMillis" value="${redis.timeBetweenEvictionRunsMillis}" />
        <!--是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个--> 
        <property name="testOnBorrow" value="${redis.testOnBorrow}" /> 
        <!--在空闲时检查有效性, 默认false  -->
        <property name="testWhileIdle" value="${redis.testWhileIdle}" /> 
    </bean >
    <!--redis连接工厂 -->
    <bean id="jedisConnectionFactory" class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory" destroy-method="destroy">
        <property name="poolConfig" ref="jedisPoolConfig"></property>
        <!--IP地址 -->
        <property name="hostName" value="${redis.hostName}"></property>
        <!--端口号  -->
        <property name="port" value="${redis.port}"></property>
        <!--如果Redis设置有密码  -->
        <property name="password" value="${redis.password}" />
        <!--客户端超时时间单位是毫秒  -->
        <property name="timeout" value="${redis.timeout}"></property>
    </bean> 
    <!--redis操作模版,使用该对象可以操作redis  -->
    <bean id="redisTemplate" class="org.springframework.data.redis.core.RedisTemplate"
        p:connection-factory-ref="jedisConnectionFactory" > 
        <property name="keySerializer">
            <bean
                class="org.springframework.data.redis.serializer.StringRedisSerializer" />
        </property>
        <property name="hashKeySerializer">
            <bean
                class="org.springframework.data.redis.serializer.StringRedisSerializer" />
        </property>
        <property name="valueSerializer">
            <bean
                class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer" />
        </property>
        <property name="hashValueSerializer">
            <bean
                class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer" />
        </property>
    </bean >  
    <!--自定义redis工具类,在需要缓存的地方注入此类  -->
    <bean id="redisUtil" class="com.how2java.RedisUtil">
        <property name="redisTemplate" ref="redisTemplate" />
    </bean>     
</beans>
// RedisUtil.java
package com.how2java; 
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit; 
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
/**
 * 基于spring和redis的redisTemplate工具类
 * 针对所有的hash 都是以h开头的方法
 * 针对所有的Set 都是以s开头的方法，不含通用方法
 * 针对所有的List 都是以l开头的方法
 */
public class RedisUtil {
    private RedisTemplate<String, Object> redisTemplate;
     
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    //=============================common============================
    /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key,long time){
        try {
            if(time>0){
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 根据key 获取过期时间
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }
    /**
     * 判断key是否存在
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }  
    /**
     * 删除缓存
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String ... key){
        if(key!=null&&key.length>0){
            if(key.length==1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    } 
    //============================String=============================
    /**
     * 普通缓存获取
     * @param key 键
     * @return 值
     */
    public Object get(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }    
    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key,Object value) {
         try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
         
    }
    /**
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key,Object value,long time){
        try {
            if(time>0){
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }else{
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }    
    /**
     * 递增
     * @param key 键
     * @param by 要增加几(大于0)
     * @return
     */
    public long incr(String key, long delta){ 
        if(delta<0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }  
    /**
     * 递减
     * @param key 键
     * @param by 要减少几(小于0)
     * @return
     */
    public long decr(String key, long delta){ 
        if(delta<0){
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta); 
    }    
    //================================Map=================================
    /**
     * HashGet
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public Object hget(String key,String item){
        return redisTemplate.opsForHash().get(key, item);
    }  
    /**
     * 获取hashKey对应的所有键值
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<Object,Object> hmget(String key){
        return redisTemplate.opsForHash().entries(key);
    }   
    /**
     * HashSet
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmset(String key, Map<String,Object> map){ 
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }  
    /**
     * HashSet 并设置时间
     * @param key 键
     * @param map 对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmset(String key, Map<String,Object> map, long time){ 
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if(time>0){
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }  
    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * @param key 键
     * @param item 项
     * @param value 值
     * @return true 成功 false失败
     */
    public boolean hset(String key,String item,Object value) {
         try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }  
    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * @param key 键
     * @param item 项
     * @param value 值
     * @param time 时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public boolean hset(String key,String item,Object value,long time) {
         try {
            redisTemplate.opsForHash().put(key, item, value);
            if(time>0){
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }   
    /**
     * 删除hash表中的值
     * @param key 键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public void hdel(String key, Object... item){ 
        redisTemplate.opsForHash().delete(key,item);
    }   
    /**
     * 判断hash表中是否有该项的值
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public boolean hHasKey(String key, String item){
        return redisTemplate.opsForHash().hasKey(key, item);
    }   
    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     * @param key 键
     * @param item 项
     * @param by 要增加几(大于0)
     * @return
     */
    public double hincr(String key, String item,double by){ 
        return redisTemplate.opsForHash().increment(key, item, by);
    }  
    /**
     * hash递减
     * @param key 键
     * @param item 项
     * @param by 要减少记(小于0)
     * @return
     */
    public double hdecr(String key, String item,double by){ 
        return redisTemplate.opsForHash().increment(key, item,-by); 
    }   
    //============================set=============================
    /**
     * 根据key获取Set中的所有值
     * @param key 键
     * @return
     */
    public Set<Object> sGet(String key){
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }  
    /**
     * 根据value从一个set中查询,是否存在
     * @param key 键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean sHasKey(String key,Object value){
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    } 
    /**
     * 将数据放入set缓存
     * @param key 键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSet(String key, Object...values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }   
    /**
     * 将set数据放入缓存
     * @param key 键
     * @param time 时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSetAndTime(String key,long time,Object...values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if(time>0) expire(key, time);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }   
    /**
     * 获取set缓存的长度
     * @param key 键
     * @return
     */
    public long sGetSetSize(String key){
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }   
    /**
     * 移除值为value的
     * @param key 键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public long setRemove(String key, Object ...values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    //===============================list=================================
    /**
     * 获取list缓存的内容
     * @param key 键
     * @param start 开始
     * @param end 结束  0 到 -1代表所有值
     * @return
     */
    public List<Object> lGet(String key,long start, long end){
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     
    /**
     * 获取list缓存的长度
     * @param key 键
     * @return
     */
    public long lGetListSize(String key){
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }   
    /**
     * 通过索引 获取list中的值
     * @param key 键
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object lGetIndex(String key,long index){
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    /**
     * 将list放入缓存
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     * @return
     */
    public boolean lSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }  
    /**
     * 将list放入缓存
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     * @return
     */
    public boolean lSet(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) expire(key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }   
    /**
     * 将list放入缓存
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     * @return
     */
    public boolean lSet(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }  
    /**
     * 将list放入缓存
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     * @return
     */
    public boolean lSet(String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) expire(key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }    
    /**
     * 根据索引修改list中的某条数据
     * @param key 键
     * @param index 索引
     * @param value 值
     * @return
     */
    public boolean lUpdateIndex(String key, long index,Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }    
    /**
     * 移除N个值为value
     * @param key 键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public long lRemove(String key,long count,Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }    
}
// TestRedis.java
package com.how2java; 
import java.util.HashMap;
import java.util.Map; 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
public class TestRedis {     
    public static void main(String[] args) throws Exception {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        RedisUtil redisUtil=(RedisUtil) context.getBean("redisUtil");  
        // testString
        redisUtil.set("name", "how2java");
        System.out.println(redisUtil.get("name"));
        redisUtil.del("name");
        System.out.println(redisUtil.get("name"));         
        // testNumber
        long incr = redisUtil.incr("number", 1);
        System.out.println(incr);
        incr =redisUtil.incr("number", 1);
        System.out.println(incr);  
        // testMap    
        Map<String,Object> map=new HashMap<>();
        map.put("name", "meepo");
        map.put("pwd", "password");
        redisUtil.hmset("user", map);
        System.out.println(redisUtil.hget("user","name"));
    }    
}
```

###  RedisClient 

 除了使用 redis-cli.exe 可以观察服务器里面的数据外，还可以使用一款图形化界面的工具，叫做 RedisClient 

-  点击菜单 -> Server -> Add， Name 输入 localhost， Host 输入 127.0.0.1，密码默认为空；
-  默认都是使用 db0 这个数据库，双击之后，右边就显示数据库里面的数据了 