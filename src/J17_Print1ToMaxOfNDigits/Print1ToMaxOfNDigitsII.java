package J17_Print1ToMaxOfNDigits;

import java.util.Scanner;

/**
 * 使用全排列+递归法
 */
public class Print1ToMaxOfNDigitsII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 1) {
            System.out.println();
            return;
        }
        char[] num = new char[n];
        printRecusion(num, 0);
    }

    public static void printRecusion(char[] num, int index) {
        if (index == num.length) {
            boolean isHead = true;
            for (int i = 0; i < num.length; i++) {
                char c = num[i];
                if (isHead && c == '0') {
                    System.out.print(" ");
                } else {
                    isHead = false;
                    System.out.print(c);
                }
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index] = (char) ('0' + i);
            printRecusion(num, index + 1);
        }
    }
}