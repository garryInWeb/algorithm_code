package old.leetCode.part539;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengtengfei on 2019/1/29.
 */
public class MinimunTimeDifferent {
    public int findMinDifference(List<String> timePoints) {
        boolean[] times = new boolean[60*24];
        for (String timePoint : timePoints){
            String[] timePointList = timePoint.split(":");
            int hour = Integer.valueOf(timePointList[0]);
            int minute = Integer.valueOf(timePointList[1]);
            if (times[hour * 60 + minute]) return 0;
            times[hour*60 + minute] = true;
        }
        int prev = 0,min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE,last = Integer.MIN_VALUE;
        for (int i = 0; i < 60*24; i++){
            if (times[i]){
                if (first != Integer.MAX_VALUE){
                    min = Math.min(min,i - prev);
                }
                first = Math.min(i,first);
                last = Math.max(i,last);
                prev = i;
            }
        }
        return Math.min(min,60*24-last+first);
    }

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        timePoints.add("23:57");
        MinimunTimeDifferent minimunTimeDifferent = new MinimunTimeDifferent();;
        System.out.println(minimunTimeDifferent.findMinDifference(timePoints));
    }
}
