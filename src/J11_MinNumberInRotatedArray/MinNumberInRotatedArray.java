package J11_MinNumberInRotatedArray;

/**
 * 面试题11：旋转数组的最小数字
 * <p>题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
 * {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 * <p>OJ：https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class MinNumberInRotatedArray {
    public int minNumberInRotateArray(int [] array) {
        if(array == null) {
            return 0;
        }
        int length = array.length;
        if(length < 1) {
            return 0;
        }
        if(length == 1) {
            return array[0];
        }
        // 特殊情况：旋转0个元素，即头<尾，直接输出头
        if(array[0] < array[length - 1]) {
            return array[0];
        }
        // 否则进行二叉判断
        int left = 0;
        int right = length - 1;
        int mid = (left + right) / 2;
        while (true) {
            if(left + 1 == right) {
                return array[right];
            }
            // 如果头=中=尾，则只能遍历查找
            if(array[mid] == array[left] && array[mid] == array[right]) {
                int min = Integer.MAX_VALUE;
                for (int i = left; i <= right; i++) {
                    if(array[i] < min) {
                        min = array[i];
                    }
                }
                return min;
            }
            // 如果中<头，则最小值可能在左侧
            if(array[mid] < array[left]) {
                right = mid;
                mid = (left + right) / 2;
            } else {
                left = mid;
                mid = (left + right) / 2;
            }
        }
    }
}
