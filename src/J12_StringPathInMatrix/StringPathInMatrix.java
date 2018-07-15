package J12_StringPathInMatrix;

/**
 * 面试题12：矩阵中的路径
 * <p>题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
 * 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
 * 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
 * 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
 * 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
 * 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>A B T G
 * <p>C F C S
 * <p>J D E H
 */
public class StringPathInMatrix {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean result = hasPathCore(matrix, rows, cols, i, j, str, 0, visited);
                if (result) {
                    return result;
                }
            }
        }
        return false;
    }

    public static boolean hasPathCore(char[] matrix, int rows, int cols, int rowIndex,
                                      int colIndex, char[] str, int pathIndex, boolean[] visited) {
        if (visited[rowIndex * cols + colIndex]) {
            return false;
        }
        if (matrix[rowIndex * cols + colIndex] != str[pathIndex]) {
            return false;
        }
        if (pathIndex == str.length - 1) {
            return true;
        }
        visited[rowIndex * cols + colIndex] = true;
        // 上一行
        if (rowIndex > 0) {
            boolean result = hasPathCore(matrix, rows, cols, rowIndex - 1, colIndex, str, pathIndex + 1, visited);
            if (result) {
                return result;
            }
        }
        // 下一行
        if (rowIndex < rows - 1) {
            boolean result = hasPathCore(matrix, rows, cols, rowIndex + 1, colIndex, str, pathIndex + 1, visited);
            if (result) {
                return result;
            }
        }
        // 左一列
        if (colIndex > 0) {
            boolean result = hasPathCore(matrix, rows, cols, rowIndex, colIndex - 1, str, pathIndex + 1, visited);
            if (result) {
                return result;
            }
        }
        // 右一列
        if (colIndex < cols - 1) {
            boolean result = hasPathCore(matrix, rows, cols, rowIndex, colIndex + 1, str, pathIndex + 1, visited);
            if (result) {
                return result;
            }
        }
        visited[rowIndex * cols + colIndex] = false;
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = {'A', 'B', 'T', 'G', 'C', 'F', 'C', 'S', 'J', 'D', 'E', 'H'};
        char[] str = {'B', 'F', 'C', 'E'};
        System.out.println(hasPath(matrix, 3, 4, str));
    }
}