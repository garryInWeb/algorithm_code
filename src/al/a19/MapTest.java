package al.a19;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
//        System.out.println(singleNumber(new int[]{6,7,6,7,6,7,2},7));
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(3,(o,o1)->{
            if (o > o1){
                return -1;
            }else{
                return 1;
            }
        });
        List<Integer> arr = new ArrayList(Arrays.asList(new int[]{1,2,3,4,5,6,7,8,9}));
        queue.addAll(arr);

        System.out.println(queue.peek().intValue());
    }

    static int singleNumber(int A[], int n) {
        int ones = 0, twos = 0, xthrees = 0;
        for(int i = 0; i < n; ++i) {
            twos |= (ones & A[i]);
            ones ^= A[i];
            xthrees = ~(ones & twos);
            ones &= xthrees;
            twos &= xthrees;
        }

        return ones;
    }
}
