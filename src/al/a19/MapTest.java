package al.a19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapTest {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{6,7,6,7,6,7,2},7));

        new ArrayList(Arrays.asList(args));
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
