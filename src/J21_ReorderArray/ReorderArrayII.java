package J21_ReorderArray;

/**
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * <p>题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 * 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>额外要求：需要保证奇数和奇数，偶数和偶数之间的相对位置不变
 * <p>RE：https://github.com/CyC2018/Interview-Notebook/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md#20-%E8%A1%A8%E7%A4%BA%E6%95%B0%E5%80%BC%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2
 * <p>OJ：https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class ReorderArrayII {
    public void reOrderArray(int [] array) {
        // 统计奇数的数量
        int oddCount = 0;
        for (int num : array) {
            if(num % 2 == 1) {
                oddCount++;
            }
        }
        int[] copy = array.clone();
        // i存放前面的奇数位置，j存放后面的偶数位置
        int i = 0;
        int j = oddCount;
        // 注意这里遍历的是copy，因为array中的值要重写
        for (int num : copy) {
            if(num % 2 == 1) {
                array[i++] = num;
            } else {
                array[j++] = num;
            }
        }
    }
}
