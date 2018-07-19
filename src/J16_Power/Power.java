package J16_Power;

/**
 * 面试题16：数值的整数次方
 * <p>题目：实现函数double Power(double base, int exponent)，求base的exponent
 * 次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>OJ：https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Power {
    public double Power(double base, int exponent) {
        if(base == 0) {
            return 0;
        }
        if(exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNagetive = false;
        if(exponent < 0) {
            exponent = -exponent;
            isNagetive = true;
        }
        double result = base * Power(base, exponent / 2);
        if(exponent % 2 != 0) {
            result = base * result;
        }
        return isNagetive ? 1 / result : result;
    }
}
