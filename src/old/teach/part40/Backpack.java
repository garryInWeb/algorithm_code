package old.teach.part40;

/**
 * Created by zhengtengfei on 2019/2/27.
 * 0-1背包问题的动态规划解法
 */
public class Backpack {

    int[][] states;
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

    public static void main(String[] args) {
        Backpack backpack = new Backpack();
        System.out.println(backpack.f(new int[]{2,6,8,9,1,3},13));
    }
}
