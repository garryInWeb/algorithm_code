package old.leetCode.part34;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2019/2/13.
 */
public class FindAndLastPoint {
    public int[] searchRange(int[] nums, int target) {
        int offset = 0,last = nums.length-1;
        int[] result = new int[]{-1,-1};
        while (offset <= last){
            int num = nums[offset];
            int numLast = nums[last];
            if (num == numLast && numLast == target){
                result[0] = offset;
                result[1] = last;
                return result;
            }
            if (num != target) offset++;
            if (numLast != target) last--;
        }
        return result;
    }

    public static void main(String[] args) {
        FindAndLastPoint findAndLastPoint = new FindAndLastPoint();
        System.out.println(Arrays.toString(findAndLastPoint.searchRange(new int[]{5, 7, 7, 8, 8, 8, 10}, 8)));
    }
}
