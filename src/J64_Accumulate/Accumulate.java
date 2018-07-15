package J64_Accumulate;

/**
 * 面试题64：求1+2+…+n
 * <p>题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 */
public class Accumulate {

    public static int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Accumulate.Sum_Solution(-1) == -1);
        System.out.println(Accumulate.Sum_Solution(0) == 0);
        System.out.println(Accumulate.Sum_Solution(10) == 55);
        System.out.println(Accumulate.Sum_Solution(100) == 5050);
    }

}
