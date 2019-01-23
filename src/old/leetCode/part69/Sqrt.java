package old.leetCode.part69;

/**
 * Created by zhengtengfei on 2019/1/23.
 * 求平方根
 */
public class Sqrt {
    static int count = 0;
    static int temp = 0;

    public int mySqrt(int x) {
        if (x == 1){
            return 1;
        }
        if (x == 0){
            return 0;
        }
        long xD = x/2;
        if (xD == 1 || xD == 2){
            return (int)xD;
        }
        for(long i = xD/2;;){
            count ++;
            if (i*i == x){
                return (int)i;
            }else if (i*i > x){
                if ((i-1)*(i-1) < x){
                    return (int)i-1;
                }
                xD = i;
                i = i/2;
            }else{
                if ((i+1)*(i+1) > x){
                    return (int)i;
                }
                i = (i +xD)/2;
            }
        }
    }
    public int bestSqrt(int x){
        long r = x;
        while (r*r > x) {
            temp++;
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(2147395599));
        System.out.println(count);
        System.out.println(sqrt.bestSqrt(2147395599));
        System.out.println(temp);
    }
}
