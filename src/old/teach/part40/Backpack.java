package old.teach.part40;

/**
 * Created by zhengtengfei on 2019/2/27.
 * 0-1背包问题的动态规划解法
 */
public class Backpack {

    int[][] states;
    // 二维数组返回最大重量
    public int f(int[] items, int maxWeight){
        states = new int[items.length][maxWeight+1];
        states[0][0] = 1;
        states[0][items[0]] = 1;
        for (int i = 1; i < items.length; i ++){
            // 不放
            for (int j = 0; j <= maxWeight; j++){
                if (states[i-1][j] == 1){
                    states[i][j] = 1;
                }
            }
            //  放
            for (int j = 0; j <= maxWeight-items[i]; j++){
                if (states[i-1][j] == 1) {
                    states[i][j + items[i]] = 1;
                }
            }
        }
        for (int i = maxWeight;i >= 0; i--){
            if (states[items.length-1][i] == 1) return i;
        }
        return 0;
    }
    // 一维数组返回最大重量
    public int f1(int[] items, int maxWeight){
        int[] states = new int[maxWeight+1];
        states[0] = 1;
        states[items[0]] = 1;
        for (int i = 1; i < items.length; i ++){
            //  放
            for (int j = maxWeight-items[i]; j > 0; j--){
                if (states[j] == 1) {
                    states[j + items[i]] = 1;
                }
            }
        }
        for (int i = maxWeight;i >= 0; i--){
            if (states[i] == 1) return i;
        }
        return 0;
    }

    // 一维数组返回最大价值
    public int maxValue(int[] items,int[] values, int maxWeight){
        int[] states = new int[maxWeight+1];
        states[0] = 0;
        states[items[0]] = values[items[0]];
        for (int i = 1; i < items.length; i ++){
            //  放
            for (int j = maxWeight-items[i]; j > 0; j--){
                if (states[j] > 0) {
                    states[j + items[i]] = states[j] + values[i];
                }
            }
        }
        int maxValue = 0;
        for (int i = maxWeight;i >= 0; i--){
            if (states[i] > maxValue) maxValue = states[i];
        }
        return maxValue;
    }


    public static void main(String[] args) {
        Backpack backpack = new Backpack();
        System.out.println(backpack.maxValue(new int[]{2,1,3},new int[]{9,9,9},13));
        System.out.println(backpack.maxValue(new int[]{2,1,3,14},new int[]{9,9,9,14},13));
    }
}
