package al.a15;

public class Sqrt {
    /**
     *  log num + 3n
     */
    public static double sqrt(double num,int n){
        double result = 0;

        double target = (int) num;

        result += bsNotRescursion(target);
        if (result*result == num)
            return result;
        int i = 1;
        while(i < n){
            result += bsDouble(result,num,i) / Math.pow(10,i++);

        }
        return result;
    }

    /**
     * log n
     */
    public static double bsNotRescursion(double target){
        int start = 0;
        int end = (int)target/2;

        while(start <= end){
            int half = (start + end) >> 1;
            if (half*half == target){
                return half;
            }
            if (half*half < target && (half+1)*(half+1) > target){
                return half;
            }else if(half*half > target){
                end = half - 1;
            }else{
                start = half + 1;
            }
        }

        return 1;
    }

    /**
     *  3 ~ 4
     */
    public static int bsDouble(double source,double target,int n){
        double pow = Math.pow(10, n);
        int start = 0;
        int end = 9;

        while(start <= end){
            int half = (start + end) / 2;
            double temp = source + half / pow;
            double nextTemp = source + (half + 1) / pow;
            if (temp*temp < target && nextTemp*nextTemp >= target){
                return half;
            }else if(temp*temp > target){
                end = half - 1;
            }else{
                start = half + 1;
            }
        }
        throw new RuntimeException("error");

    }

    public static void main(String[] args) {
        System.out.println(Sqrt.sqrt(4,7));
        System.out.println(Sqrt.sqrt(16,7));
        System.out.println(Sqrt.sqrt(9,7));
        System.out.println(Sqrt.sqrt(25,7));
        System.out.println(Sqrt.sqrt(121,7));
        System.out.println(Sqrt.sqrt(144,7));
        System.out.println(Sqrt.sqrt(10,7));
        System.out.println(Sqrt.sqrt(1,7));
        System.out.println(Sqrt.sqrt(2,7));
        System.out.println(Sqrt.sqrt(1.9,7));
        System.out.println(Sqrt.sqrt(0.8,7));
    }
}
