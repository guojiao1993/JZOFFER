package J17_Print1ToMaxOfNDigits;

import java.util.Scanner;

/**
 * 面试题17：打印1到最大的n位数
 * <p>题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
 * 打印出1、2、3一直到最大的3位数即999。
 */
public class Print1ToMaxOfNDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n < 1) {
            System.out.println();
            return;
        }
        char[] num = new char[n];
        for (int i = 0; i < n; i++) {
            num[i] = '0';
        }
        while (true) {
            int index = n - 1;
            boolean jw = true;
            while (jw && index >= 0) {
                if(num[index] == '9') {
                    num[index] = '0';
                    index--;
                } else {
                    num[index]++;
                    jw = false;
                }
            }
            // 当最高位都进位了，则退出
            if(index < 0) {
                break;
            } else {
                boolean isHead = true;
                for (int i = 0; i < n; i++) {
                    char c = num[i];
                    if(isHead && c == '0') {
                        System.out.print(" ");
                    } else {
                        isHead = false;
                        System.out.print(c);
                    }
                }
                System.out.println();
            }
        }
    }
}
