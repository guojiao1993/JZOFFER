package J03_DuplicationInArray;

/**
 * 面试题3（一）：找出数组中重复的数字
 * <p>题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是重复的数字2或者3。</p>
 */
public class DuplicationInArray {

    /**
     * @param numbers     一个整数数组
     * @param length      数组的长度
     * @param duplication (输出) 数组中的一个重复的数字
     * @return true  - 输入有效，并且数组中存在重复的数字
     * <p>false - 输入无效，或者数组中没有重复的数字</p>
     */
    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; ++i) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                // 交换numbers[i]和numbers[numbers[i]]
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test1 = {0, 1, -1};
        int[] test2 = {0, 1, 1};
        int[] test3 = {0, 1, 2};
        int[] test4 = {0, 1, 3};
        int[] test5 = {2, 3, 1, 0, 2, 5, 3};
        int[] result = new int[1];
        result[0] = -1;
        System.out.println(DuplicationInArray.duplicate(test1, test1.length, result) + "\t" + result[0]);
        result[0] = -1;
        System.out.println(DuplicationInArray.duplicate(test2, test2.length, result) + "\t" + result[0]);
        result[0] = -1;
        System.out.println(DuplicationInArray.duplicate(test3, test3.length, result) + "\t" + result[0]);
        result[0] = -1;
        System.out.println(DuplicationInArray.duplicate(test4, test4.length, result) + "\t" + result[0]);
        result[0] = -1;
        System.out.println(DuplicationInArray.duplicate(test5, test5.length, result) + "\t" + result[0]);
    }

}
