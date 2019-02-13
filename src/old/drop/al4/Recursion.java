package old.drop.al4;

/**
 * Created by zhengtengfei on 2018/10/30.
 */
public class Recursion {

    public static int wayToN(int n){
        if (n == 2){
            return 2;
        }
        if (n == 1){
            return 1;
        }
        if (n <= 0){
            return 0;
        }
        return wayToN(n-2) + wayToN(n-1);
    }

    public static void main(String[] args) {
        int i = 3;
        System.out.println(wayToN(4));
    }
}
