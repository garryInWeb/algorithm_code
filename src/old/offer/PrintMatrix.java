package old.offer;

import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int left = 0;
        int up = 0;
        int right = matrix[0].length-1;
        int down = matrix.length-1;
        ArrayList<Integer> result = new ArrayList<>();

        while(true){
            for(int i=left; i <= right; i++){
                result.add(matrix[up][i]);
            }
            if(++up > down){
                break;
            }
            for(int i=up; i <= down; i++){
                result.add(matrix[i][right]);
            }
            if(--right < left){
                break;
            }
            for(int i=right; i >= left; i--){
                result.add(matrix[down][i]);
            }
            if(--down < up){
                break;
            }
            for(int i=down; i >= up; i--){
                result.add(matrix[i][left]);
            }
            if(++left > right){
                break;
            };
        }
        return result;
    }
}
