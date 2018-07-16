package J62_LastNumberInCircle;

public class LastNumberInCircleUsingRecursion {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 3));
    }

    /**
     * 使用递归公式法
     * <p>约瑟夫环，圆圈长度为 n 的解可以看成长度为 n-1 的解再加上报数的长度 m。因为是圆圈，所以最后需要对 n 取余。（？）
     * @param n 数字个数
     * @param m 删除计数
     * @return 最后剩下的数字
     */
    public static int LastRemaining_Solution(int n, int m) {
        if(n == 0) {
            return -1;
        }
        if(n == 1) {
            return 0;
        }
        return (LastRemaining_Solution(n  - 1, m) + m ) % n;
    }
}