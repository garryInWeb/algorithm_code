package al.a15;

public class BSearch {
    /**
     * time : O(logn)
     * space : O(1)
     */
    public static int bsRecursion(int[] source,int target,int start,int end){
        if (start > end){
            throw new RuntimeException("num: " + target + " not found");
        }
        int half = (start + end) >> 1;
        if (source[half] == target){
            return half;
        }else if (source[half] > target){
            return bsRecursion(source,target,start,half-1);
        }else{
            return bsRecursion(source,target,half+1,end);
        }
    }

    /**
     * time : O(logn)
     * space : O(1)
     */
    public static int bsNotRescursion(int[] source,int target){
        int start = 0;
        int end = source.length-1;

        while(start <= end){
            int half = (start + end) >> 1;
            if (source[half] == target){
                return half;
            }else if(source[half] > target){
                end = half - 1;
            }else{
                start = half + 1;
            }
        }
        throw new RuntimeException("num: " + target + " not found");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6,12,14,16,21};
        int[] num = new int[]{};
        System.out.println(nums[BSearch.bsRecursion(nums,21,0,nums.length-1)]);
        System.out.println(nums[BSearch.bsNotRescursion(nums,21)]);
        System.out.println(nums[BSearch.bsNotRescursion(nums,1)]);
        System.out.println(nums[BSearch.bsRecursion(nums,1,0,nums.length-1)]);
        System.out.println(nums[BSearch.bsNotRescursion(num,0)]);
    }
}
