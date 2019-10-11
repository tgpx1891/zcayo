import java.util.Scanner; 
 
public class ScannerDemo1 {
    public static void main(String[] args) {
		float floatVar = 1.02f;
		int intVar = 1;
		String stringVar = "1";
        String fs;
fs = String.format("浮点型变量的值为 " +
                   "%f, 整型变量的值为 " +
                   " %d, 字符串变量的值为 " +
                   " %s", floatVar, intVar, stringVar);
    }
}