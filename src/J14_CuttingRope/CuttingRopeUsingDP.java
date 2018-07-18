package J14_CuttingRope;

/**
 * 面试题14：剪绳子
 * <p>题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 * 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * 时得到最大的乘积18。
 * <p>OJ：https://leetcode.com/problems/integer-break/description/
 */
public class CuttingRopeUsingDP {
    public int integerBreak(int n) {
        if(n < 2) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        int[] lengths = new int[n + 1];
        // 对这里的初始化我尚存疑问
        lengths[0] = 0;
        lengths[1] = 1;
        lengths[2] = 2;
        lengths[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int length = lengths[j] * lengths[i - j];
                if(length > max) {
                    max = length;
                }
            }
            lengths[i] = max;
        }
        return lengths[n];
    }
}
