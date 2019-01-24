package old.leetCode.part50;

/**
 * Created by zhengtengfei on 2019/1/24.
 */
public class Pow {
    public double myLowPow(double x, int n) {
        double result = x;
        if (n == 0){
            return 1;
        }else if(n > 0) {
            for (int i = 1; i < n; i++) {
                result *= x;
            }
        }else {
            if (n == Integer.MIN_VALUE){
                n = n+1;
            }
            n = -n;
            for (int i = 1; i < n; i++){
                result *= x;
            }
            if (result > Integer.MAX_VALUE){
                result = 0;
            }else {
                result = 1 / result;
            }
        }
        return result;
    }
    /**
     * x的100次方 = x的50次方 * x的50次方，递归
     */
    public double myBestPow(double x,int n){
        if (n == 0 || x == 1) return 1;
        if (x == -1){
            if (n % 2 == 0) return 1;
            return -1;
        }
        if (n < 0){
            x = 1/x;
            if (n == Integer.MIN_VALUE) n++;
            n = -n;
        }
        if (n / 2 == 1){
            if (n % 2 == 1) return x*x*x;
            return x*x;
        }
        double v = myBestPow(x, n / 2);
        if (n % 2 == 0) return v * v;
        return v * v * x;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
//        System.out.println(pow.myLowPow(-1.00,2147483647));
        System.out.println(pow.myBestPow(2.0,-1));
        System.out.println(pow.myBestPow(2.0,3));
        System.out.println(pow.myBestPow(2.0,-3));
        System.out.println(pow.myBestPow(2.0,-2147483648));
        System.out.println(pow.myBestPow(1.0,-2147483648));
//        System.out.println(pow.myPow(0.00,3));
//        System.out.println(pow.myPow(-1.0,3));
//        System.out.println(pow.myPow(-1.0,10));
//        System.out.println(pow.myPow(-1.0,-10));
//        System.out.println(pow.myPow(2.0 ,-2));
    }
}
