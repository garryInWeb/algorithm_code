package old.leetCode.part724;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2019/1/29.
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int[] numsSumLeft = new int[nums.length];
        int[] numsSumRight = new int[nums.length];
        numsSumLeft[0] = 0;
        numsSumRight[0] = 0;
        for (int i = 1; i < nums.length; i++){
            numsSumRight[0] += nums[i];
        }
        for (int i = 0; i < nums.length; i++){
            if(i!=0) {
                numsSumLeft[i] = numsSumLeft[i - 1] + nums[i - 1];
                numsSumRight[i] = numsSumRight[i - 1] - nums[i];
            }
            if (numsSumLeft[i] == numsSumRight[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1,0,1,1,0};
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        System.out.println(findPivotIndex.pivotIndex(nums));
    }
}
