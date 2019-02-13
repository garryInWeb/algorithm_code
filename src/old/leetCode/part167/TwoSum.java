package old.leetCode.part167;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2019/2/13.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int offset = 0,last = numbers.length - 1;
        while (offset != last){
            int sum = numbers[offset] + numbers[last];
            if (sum == target)
                return new int[]{offset+1,last+1};
            if (sum < target){
                offset ++;
                continue;
            }
            if (sum > target){
                last -- ;
                continue;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2, 7, 10, 99}, 9)));
    }
}
