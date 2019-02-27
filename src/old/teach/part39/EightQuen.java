package old.teach.part39;

/**
 * Created by zhengtengfei on 2019/2/26.
 * 八王后问题
 */
public class EightQuen {
    int[] pan = new int[8];
    public void putQuen(int row){
        if (row == 8) {
            printPan();
            return ;
        }
        for (int i = 0; i < 8; i ++){
            if (isOk(row,i)){
                pan[row] = i;
                putQuen(row + 1);
            }
        }
    }

    private boolean isOk(int row, int i) {
        int left = i-1,right = i+1;
        for (int j = row-1; j >= 0; j--){
            if (pan[j] == i) return false;
            if  ((left >= 0 && pan[j] == left) || (right < 8 && pan[j] == right))
                return false;
            left --;
            right++;
        }
        return true;
    }

    private void printPan() {
        for (int aPan : pan) {
            for (int j = 0; j < aPan; j++)
                System.out.printf("K");
            System.out.printf("Q");
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        EightQuen eightQuen = new EightQuen();
        eightQuen.putQuen(0);
    }
}
