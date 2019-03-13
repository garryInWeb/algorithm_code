package old.teach.part37;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhengtengfei on 2019/3/13.
 */
public class Candy {
    public int candy(Integer[] m, Integer[] n ){
        Arrays.sort(m, Comparator.comparingInt(o -> o));
        Arrays.sort(n, ((o1, o2) -> o2-o1));
        int count = 0;
        for (int i = 0; i < n.length; i++){
            for (int j = 0; j < m.length; j++){
                if (n[i] <= m[j]){
                    m[j] = 0;
                    count ++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        System.out.println(candy.candy(new Integer[]{1,2,3,4,5},new Integer[]{3,6,72,123,4,1}));
    }
}
