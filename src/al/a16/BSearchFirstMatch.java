package al.a16;

public class BSearchFirstMatch {
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
    public static int bsNotRescursionFirstMatch(int[] source, int target){
        int start = 0;
        int end = source.length-1;

        while(start <= end){
            int half = (start + end) >> 1;
            if (source[half] == target){
                if (half == 0 || source[half-1]!=target)
                    return half;
                else
                    end = half - 1;
            }else if(source[half] > target){
                end = half - 1;
            }else{
                start = half + 1;
            }
        }
        throw new RuntimeException("num: " + target + " not found");
    }

    public static int bsNotRescursionLastMatch(int[] source, int target){
        int start = 0;
        int end = source.length-1;

        while(start <= end){
            int half = (start + end) >> 1;
            if (source[half] == target){
                if (half == source.length - 1 || source[half+1]!=target)
                    return half;
                else
                    start = half + 1;
            }else if(source[half] > target){
                end = half - 1;
            }else{
                start = half + 1;
            }
        }
        throw new RuntimeException("num: " + target + " not found");
    }

    public static int bsNotRescursionFirstLarger(int[] source, int target){
        int start = 0;
        int end = source.length-1;

        while(start <= end){
            int half = (start + end) >> 1;
            if (source[half] >= target){
                if (half == 0 || source[half-1]<target)
                    return half;
                else
                    end = half - 1;
            }else{
                start = half + 1;
            }
        }
        throw new RuntimeException("num: " + target + " not found");
    }

    public static int bsNotRescursionLastLess(int[] source, int target){
        int start = 0;
        int end = source.length-1;

        while(start <= end){
            int half = (start + end) >> 1;
            if (source[half] <= target){
                if (half == source.length - 1 || source[half+1]>target)
                    return half;
                else
                    start = half + 1;
            }else{
                end = half - 1;
            }
        }
        throw new RuntimeException("num: " + target + " not found");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6,12,12,14,16,21};
        int[] num = new int[]{1,3,4,5,6,8,8,8,11,12,31};
        System.out.println(BSearchFirstMatch.bsNotRescursionFirstMatch(num,8));
        System.out.println(BSearchFirstMatch.bsNotRescursionLastMatch(num,8));
        System.out.println(BSearchFirstMatch.bsNotRescursionFirstLarger(num,8));
        System.out.println(BSearchFirstMatch.bsNotRescursionFirstLarger(num,6));
//        System.out.println(nums[BSearchFirstMatch.bsNotRescursionFirstMatch(nums,21)]);
//        System.out.println(nums[BSearchFirstMatch.bsNotRescursionFirstMatch(nums,1)]);
//        System.out.println(nums[BSearchFirstMatch.bsRecursion(nums,1,0,nums.length-1)]);
//        System.out.println(nums[BSearchFirstMatch.bsNotRescursionFirstMatch(num,0)]);
    }
}
