package old.teach.part1;

/**
 * Created by zhengtengfei on 2019/2/13.
 * 分治算法，计算逆序度
 */
public class CountReverse {

    int count = 0;

    public int countReverse(int[] nums){
        count = 0;
        countReverseSorted(nums,0,nums.length-1);
        return count;
    }

    private void countReverseSorted(int[] nums, int offset, int last) {

        if (offset >= last)
            return;
        int half = (offset + last) / 2;
        countReverseSorted(nums,offset,half);
        countReverseSorted(nums,half+1,last);
        mergeCount(nums,offset,last,half);
    }

    private void mergeCount(int[] nums, int offset, int last, int half) {
        int[] result = new int[last - offset + 1];
        int x = offset,y = half;
        for (int i = 0; i < result.length; i++){
            if (x != half && (y == last || nums[x] <= nums[y])){
                result[i] = nums[x];
                x++;
                continue;
            }
            if (y != last && (x == half || nums[x] > nums[y])){
                result[i] = nums[y];
                if (nums[x] > nums[y])
                    count += (half - x + 1);
                y++;
            }
        }
    }

    public static void main(String[] args) {
        CountReverse countReverse = new CountReverse();
        System.out.println(countReverse.countReverse(new int[]{2,4,3,1,5,6}));

    }
}
