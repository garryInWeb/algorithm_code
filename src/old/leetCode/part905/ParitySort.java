package old.leetCode.part905;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2019/1/25.
 * 偷看了答案的，思路nice
 */
public class ParitySort {
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        for (int i : A){
            if (i % 2 == 0){
                result[start] = i;
                start ++;
            }else{
                result[end] = i;
                end --;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ParitySort paritySort = new ParitySort();
        int[] i = new int[]{3,1,5,2,1};
        System.out.println(Arrays.toString(paritySort.sortArrayByParity(i)));
    }
}
