package J10_Fibonacci;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        if(target <= 2) {
            return target;
        }
        int pre1 = 1, pre2 = 2;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
