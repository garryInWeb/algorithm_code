package old.teach.part40;

/**
 * Created by zhengtengfei on 2019/2/28.
 * 杨辉三角
 */
public class PascalTriangle {
    // 根据当前位置求出在哪一行

    public void f(int[][] items){
        int deep = items.length;
        int[][] states = new int[deep][deep];
        states[0][0] = items[0][0];
        // 计算出矩阵
        for (int i = 1; i < deep; i++){
            for (int j = 0; j < items[i].length; j++){
                if (j == 0) states[i][j] = items[i][j] + states[i-1][j];
                else if (j == items[i].length - 1)states[i][j] = items[i][j] + states[i-1][j-1];
                else states[i][j] = items[i][j] + Math.min(states[i-1][j],states[i-1][j-1]);
            }
        }
        for (int i = 0; i < deep; i++){
            System.out.println(states[deep-1][i]);
        }
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        int[][] items = new int[][]{{1},{2,3},{4,5,6},{7,8,9,10}};
        pascalTriangle.f(items);
    }
}
