package old.teach.part37;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengtengfei on 2019/3/13.
 */
public class Range {
    public int range(int[][] range){
        // 排序
        quick(range,0,range.length-1);
        List<Integer> result = new ArrayList<>();
        int count = -1;
        for (int i=0; i < range.length; i++){
            int[] present = range[i];

            Integer index = count == -1 ? null : result.get(count);
            if (index != null){
                int[] before = range[index];
                count = compare(before,present,result,count,i);
            }else{
                result.add(i);
                count ++;
            }
        }
        return count + 1;
    }

    private int compare(int[] before, int[] present,List<Integer> result,int count,int index) {
        if (present[0] >= before[0] && present[1] <= before[1]){
            result.remove(count);
            result.add(count,index);
            return count;
        }else if (present[0] >= before[1]){
            result.add(index);
            return ++count;
        }else{
            return count;
        }
    }

    public void quick(int[][] range,int p,int q){
        if (p >= q)
            return;
        int partition = range[q][0];
        int j = p;
        for (int i = p; i < q; i++){
            if (range[i][0] < partition){
                swap(range, j, i);
                j++;
            }
        }
        swap(range,j,q);

        quick(range,p,j-1);
        quick(range,j+1,q);
    }

    private void swap(int[][] range, int j, int i) {
        int[] temp = range[i];
        range[i] = range[j];
        range[j] = temp;
    }

    public static void main(String[] args) {

        Range range = new Range();
        System.out.println(range.range(new int[][]{{1,5},{2,4},{4,5},{1,3},{8,9},{9,10},{5,8},{6,8},{8,10}}));
    }
}
