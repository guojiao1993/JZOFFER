package J47_MaxValueOfGifts;

/**
 * 面试题47：礼物的最大价值
 * <p>题目：在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值
 * （价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或
 * 者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计
 * 算你最多能拿到多少价值的礼物？
 * <p>OJ：https://www.nowcoder.com/questionTerminal/72a99e28381a407991f2c96d8cb238ab
 */
public class MaxValueOfGifts {
    public int getMost(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int length = board[0].length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int left = 0;
                if(j > 0) {
                    left = dp[j - 1];
                }
                int up = 0;
                if(i > 0) {
                    up = dp[j];
                }
                dp[j] = Math.max(left, up) + board[i][j];
            }
        }
        return dp[length - 1];
    }
}
