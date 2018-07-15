package J10_Fibonacci;

/**
 * 面试题10：斐波那契数列
 * 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int pre1 = 0, pre2 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre1 + pre2;
            pre1 = pre2;
            pre2 = fib;
        }
        return fib;
    }
}