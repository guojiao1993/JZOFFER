package J04_FindInPartiallySortedMatrix;

/**
 * 面试题4：二维数组中的查找
 * <p>题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
 * 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 * 整数，判断数组中是否含有该整数。
 */
public class FindInPartiallySortedMatrix {
    public static boolean find(int target, int[][] array) {
        if (array == null || array.length < 1 ||
                array[0] == null || array[0].length < 1) {
            return false;
        }
        int rowLength = array.length;
        int colLength = array[0].length;
        // 取右上角的数来开始迭代
        int rowIndex = 0;
        int colIndex = colLength - 1;
        while (rowIndex < rowLength && colIndex >= 0) {
            if (array[rowIndex][colIndex] == target) {
                return true;
            }
            // 减一列：列数减一
            if (array[rowIndex][colIndex] > target) {
                colIndex--;
                continue;
            }
            // 减一行：行数加一
            if (array[rowIndex][colIndex] < target) {
                rowIndex++;
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array1 = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find(3, array1));
        System.out.println(find(9, array1));
        System.out.println(find(9, null));
        int[][] array2 = {{1,2,8,9}, {4,7,10,13}};
        System.out.println(find(7, array2));
    }

}
