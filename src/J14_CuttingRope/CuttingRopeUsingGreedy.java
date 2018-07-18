package J14_CuttingRope;

public class CuttingRopeUsingGreedy {
    public int integerBreak(int n) {
        if(n < 2) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        int ds_3 = n / 3;
        int ds_2;
        int ys = n % 3;
        if(ys == 0) {
            ds_2 = 0;
        } else if(ys == 1){
            ds_3--;
            ds_2 = 2;
        } else {
            ds_2 = 1;
        }
        return (int) (Math.pow(3, ds_3) * Math.pow(2, ds_2));
    }
}
