import java.util.Scanner; 
 
public class ScannerDemo1 {
    public static void main(String[] args) {
		float floatVar = 1.02f;
		int intVar = 1;
		String stringVar = "1";
        String fs;
fs = String.format("�����ͱ�����ֵΪ " +
                   "%f, ���ͱ�����ֵΪ " +
                   " %d, �ַ���������ֵΪ " +
                   " %s", floatVar, intVar, stringVar);
    }
}