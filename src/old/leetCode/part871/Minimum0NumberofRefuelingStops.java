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
        int[][] sortSations = sortStations(stations,0,stations.length-1);
        int count = 0;
        int i = 0;
        int goS = 0;
        while(target-startFuel > 0){
            if (sortSations.length == 0) return -1;
            if (i == sortSations.length) return -1;
            if (startFuel + goS >= sortSations[i][0]){
                target -= sortSations[i][0];
                startFuel = startFuel - sortSations[i][0] + sortSations[i][1];
                goS += sortSations[i][0];
                sortSations = buildNewSations(sortSations,sortSations[i][0]);
                i = 0;
                count ++;
                continue;
            }
            i++;
        }
        return count;
    }

    private int[][] buildNewSations(int[][] sortSations,int stations) {
        int count = 0;
        for (int i = 0; i < sortSations.length; i++){
            if  (sortSations[i][0] > stations) count++;
        }
        int[][] result = new int[count][2];
        int j = 0;
        for (int i = 0; i < sortSations.length; i++){
            if  (sortSations[i][0] > stations) {
                result[j] = sortSations[i];
                j++;
            }
        }
        return result;
    }

    public int[][] sortStations(int[][] stations,int offset,int last) {

        if (offset >= last) return stations;
        int j = offset;
        int partition = stations[last][1];
        for (int i = offset; i < last; i++){
            if (stations[i][1] > partition){
                swap(stations,j,i);
                j++;
            }
        }
        swap(stations,last,j);

        sortStations(stations,offset,j-1);
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
        System.out.println(minimum0NumberofRefuelingStops.minRefuelStops(100,25,new int[][]{{25, 25}, {50, 25}, {75, 25}}));
        System.out.println(minimum0NumberofRefuelingStops.minRefuelStops(100,50,new int[][]{{50, 50}}));
        System.out.println(minimum0NumberofRefuelingStops.minRefuelStops(1000,299,new int[][]{{13, 21},{26, 115},{100, 47},{225, 99},{299, 141},
                {444, 198},{608, 190},{636, 157},{647, 255},{841, 123}}));
    }

}
