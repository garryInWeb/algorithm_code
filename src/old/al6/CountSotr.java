package old.al6;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2018/11/3.
 */
public class CountSotr {

    static int[] countSort(int[] arr,int max){
        // 按数据范围分类
        int[] sortCount = new int[max + 1];
        for (int i : arr){
            sortCount[i] ++;
        }
        // 构造累加后的数据桶
        for (int i = 1 ; i < sortCount.length; i++){
            sortCount[i] += sortCount[i - 1];
        }
        int[] temp = new int[arr.length];
        // 排序
        for (int i : arr){
            temp[sortCount[i] - 1] = i;
            sortCount[i] --;
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] news = new int[]{1,9,5,9,3,5,6,2,2,8};
        System.out.println(Arrays.toString(countSort(news, 9)));
    }
}
