package old.leetCode.part137;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2019/1/29.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums.length < 3) return nums[0];
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length; i++){
            if (i == 0 && nums[i]!=nums[i+1])return nums[i];
            if (i == nums.length-1 && nums[i]!=nums[i-1])return nums[i];
            if (i != 0 && i!=nums.length - 1)
                if (nums[i]!=nums[i-1] && nums[i] != nums[i+1]) return nums[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0,1,0,1,0,1,7,8,7,7};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(array));
    }
}
