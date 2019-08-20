package al.a16;

/**
 * [ 4,5,6,1,2,3]  查找定值
 */
public class BSearchCycleArray {
    public static int bsearch(int[] source,int target){
        int start = 0;
        int end = source.length - 1;
        int endVal = source[source.length - 1];
        int startVal = source[0];

        while(start <= end){
            int half = start + ((end - start) >> 1);
            if (source[half] == target)
                return half;
            else if (source[half] > target) {
                if (target < startVal && source[half] > endVal)
                    start = half + 1;
                else
                    end = half - 1;
            } else {
                if (source[half] < endVal && target < endVal)
                    end = half - 1;
                else
                    start = half + 1;
            }
        }
        return -1;
    }
}
