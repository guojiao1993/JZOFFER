package J21_ReorderArray;

/**
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * <p>题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 * 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>RE：https://github.com/CyC2018/Interview-Notebook/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md#20-%E8%A1%A8%E7%A4%BA%E6%95%B0%E5%80%BC%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2
 */
public class ReorderArray {
    public void reOrderArray(int [] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            // 从前往后，是奇数就跳过
            while (i < array.length && array[i] % 2 == 1) {
                i++;
            }
            // 从后往前，是偶数就跳过
            while (j < array.length && array[j] % 2 == 0) {
                j--;
            }
            // 对调
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
}
