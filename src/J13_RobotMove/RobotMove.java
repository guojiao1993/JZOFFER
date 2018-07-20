package J13_RobotMove;

/**
 * 面试题13：机器人的运动范围
 * <p>题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 * 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>OJ：https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class RobotMove {
    public int movingCount(int threshold, int rows, int cols) {
        // visited[]很关键，可有效减小遍历的复杂度
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            visited[i] = false;
        }
        // 从(0,0）开始走动，采用回溯法
        return movingCountRecusion(threshold, rows, cols, 0, 0, visited);
    }

    public int movingCountRecusion(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        }
        if(visited[row * cols + col]) {
            return 0;
        }
        int sum = 0;
        // 计算行坐标的数位之和
        int temp = row;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        // 计算列坐标的数位之和
        temp = col;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        if (sum > threshold) {
            return 0;
        } else {
            visited[row * cols + col] = true;
            return 1 +
                movingCountRecusion(threshold, rows, cols, row - 1, col, visited) +
                movingCountRecusion(threshold, rows, cols, row + 1, col, visited) +
                movingCountRecusion(threshold, rows, cols, row, col - 1, visited) +
                movingCountRecusion(threshold, rows, cols, row, col + 1, visited);
        }
    }
}
