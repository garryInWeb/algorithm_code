package old.leetCode.part135;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2019/1/30.
 */
public class Candy {
    public int candy(int[] ratings) {

        int[] candys = new int[ratings.length];
        candys[0] = 1;
         for (int i = 1; i < ratings.length; i++){
             if(ratings[i] > ratings[i-1])candys[i] = candys[i-1] + 1;
             else candys[i] = 1;
         }
         for (int i = ratings.length-1; i > 0; i--){
             if (ratings[i-1] > ratings[i]){
                 if (candys[i] >= candys[i-1]) candys[i-1]=candys[i]+1;
             }
         }
         int sum = 0;
         for (int num : candys){
             sum += num;
         }
         return sum;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        candy.candy(new int[]{1,2,87,87,87,2,1});
    }
}
