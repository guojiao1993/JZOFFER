package J10_Fibonacci;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
    /**
     * 可以用数学归纳法证明f(n) = 2^(n-1)
     * @param target 台阶数
     * @return 跳法数
     */
    public int JumpFloor(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
