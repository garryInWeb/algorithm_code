package old.leetCode.part871;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2019/2/14.
 */
public class Minimum0NumberofRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int[] dp = new int[stations.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < stations.length; i++){
            for (int t = i; t >= 0 ; t--){
                if (dp[t] >= stations[i][0])
                    dp[t+1] = Math.max(dp[t+1],dp[t] + stations[i][1]);
            }
        }
        for (int i = 0; i < dp.length; i++){
            if (dp[i] >= target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Minimum0NumberofRefuelingStops minimum0NumberofRefuelingStops = new Minimum0NumberofRefuelingStops();
        System.out.println(minimum0NumberofRefuelingStops.minRefuelStops(100,25,new int[][]{{25, 25}, {50, 25}, {75, 25}}));
        System.out.println(minimum0NumberofRefuelingStops.minRefuelStops(100,50,new int[][]{{50, 50}}));
        System.out.println(minimum0NumberofRefuelingStops.minRefuelStops(1000,299,new int[][]{{13, 21},{26, 115},{100, 47},{225, 99},{299, 141},
                {444, 198},{608, 190},{636, 157},{647, 255},{841, 123}}));
    }

}
