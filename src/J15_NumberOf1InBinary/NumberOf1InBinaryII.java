package J15_NumberOf1InBinary;

/**
 * 面试题15：二进制中1的个数
 * <p>题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 * 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 * <p>OJ：https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class NumberOf1InBinaryII {
    public int NumberOf1(int n) {
        return Integer.bitCount(n);
    }
}
