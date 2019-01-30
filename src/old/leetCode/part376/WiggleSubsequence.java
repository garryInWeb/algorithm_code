package old.leetCode.part376;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by zhengtengfei on 2019/1/30.
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1) return 1;
        if(nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        for (int i : nums){
            list.add(i);
        }
        int flag = 0;
        for (int i = 0; i < list.size()-1;) {
            if (flag == 1) {
                if (list.get(i) >= list.get(i+1)){
                    // 移大
                    list.remove(i);
                    continue;
                }
                i++;
                flag = 2;
            }else if (flag == 2){
                if (list.get(i) <= list.get(i+1)){
                    // 移小
                    list.remove(i+1);
                    continue;
                }
                i++;
                flag = 1;
            }else{
                if  (Objects.equals(list.get(i), list.get(i + 1))){
                    list.remove(i);
                    continue;
                }
                flag = list.get(i) > list.get(i+1) ?1:2;
                i++;
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        System.out.println(wiggleSubsequence.wiggleMaxLength(new int[]{
                33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40,46,69,42,6,95,51,68,72,9,32,
                84,34,64,6,2,26,98,3,43,30,60,3,68,82,9,97,19,27,98,99,4,30,96,37,9,
                78,43,64,4,65,30,84,90,87,64,18,50,60,1,40,32,48,50,76,100,57,29,63,
                53,46,57,93,98,42,80,82,9,41,55,69,84,82,79,30,79,18,97,67,23,52,38,74,15}));
    }
}
