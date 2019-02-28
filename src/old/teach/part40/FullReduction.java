package old.teach.part40;

/**
 * Created by zhengtengfei on 2019/2/28.
 *
 * 满 200 元减 50 元 场景

 */
public class FullReduction {
    public static void fullReduction(int[] items,int reductValue){
        boolean[][] states = new boolean[items.length][reductValue * 3 + 1];
        int maxCol = reductValue * 3 + 1;
        states[0][0] = true;
        states[0][items[0]] = true;
        for (int i = 1; i < items.length; i++){
            for (int j = 0; j < maxCol; j++){
                if (states[i-1][j]) states[i][j] = true;
            }
            for (int j = 0; j < maxCol-items[i]; j++){
                if (states[i-1][j]) states[i][j + items[i]] = true;
            }
        }
        int j;
        for (j = reductValue; j < maxCol; j++){
            if (states[items.length-1][j])break;
        }
        for (int i = items.length -1 ; i > 0; i--){
            if (j-items[i] >= 0 && states[i-1][j-items[i]]) {
                System.out.println("买了 " + i + " : " + items[i]);
                j = j - items[i];
            }
        }
        if (j != 0) System.out.println("买了 " + 0 + " : " + items[0]);

    }

    public static void main(String[] args) {
        fullReduction(new int[]{2,1,3,14},13);
    }
}
