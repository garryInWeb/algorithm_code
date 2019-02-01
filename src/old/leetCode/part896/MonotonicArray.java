package old.leetCode.part896;

/**
 * Created by zhengtengfei on 2019/2/1.
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 1) return true;
        int flag = 0;
        for (int i = 0 ; i < A.length-1; i++){
            int temp;
            if (A[i] < A[i+1]) temp = 2;
            else if(A[i] > A[i+1]) temp = 1;
            else temp = 0;
            if (temp == 0) continue;
            if(flag == 0) flag = temp;
            else {
                if(temp != flag){
                    return false;
                }
                flag = temp;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        MonotonicArray monotonicArray = new MonotonicArray();
        System.out.println(monotonicArray.isMonotonic(new int[]{11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5}));
    }
}
