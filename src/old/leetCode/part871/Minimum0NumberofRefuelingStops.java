package old.leetCode.part871;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2019/2/14.
 */
public class Minimum0NumberofRefuelingStops {
    int count = 0;
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel > target)
            return count;
        int[][] sortSations = sortStations(stations,0,stations.length);
        return 0;
    }

    public int[][] sortStations(int[][] stations,int offset,int last) {

        if (offset >= last) return stations;
        int j = offset;
        int partition = stations[last][1];
        for (int i = offset; i < last; i++){
            if (stations[i][1] < partition){
                swap(stations,j,i);
                j++;
            }
        }
        swap(stations,last,j);
        if (j == 0 || j == last) return stations;

        sortStations(stations,offset,j);
        sortStations(stations,j+1,last);

        return stations;
    }

    private void swap(int[][] stations, int j, int i) {
        int[] temp = stations[j];
        stations[j] = stations[i];
        stations[i] = temp;
    }

    public static void main(String[] args) {
        Minimum0NumberofRefuelingStops minimum0NumberofRefuelingStops = new Minimum0NumberofRefuelingStops();
        System.out.println(Arrays.deepToString(minimum0NumberofRefuelingStops.sortStations(new int[][]{{1, 8}, {2, 3}, {3, 1}, {4, 9}}, 0, 4-1)));
    }

}
