用 maven 方式来做

```java
// 导入 hutool 包
<dependencies>
    <dependency>
        <groupId>cn.hutool</groupId>
        <artifactId>hutool-all</artifactId>
        <version>4.3.1</version>
    </dependency>
</dependencies>
// TestHutool.java
package hutool;
import java.util.Date;
import cn.hutool.core.date.DateUtil;
public class TestHutool {
	public static void main(String[] args) {
		String dateStr = "2012-12-12 12:12:12";
		Date date = DateUtil.parse(dateStr);
		System.out.println(date);
	}
}
```

