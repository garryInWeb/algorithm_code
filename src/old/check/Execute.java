package old.check;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2018/10/9.
 */
public class Execute {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = Arrays.copyOf(nums1,nums1.length + nums2.length);
        if (nums3.length == 1){
            if (nums1.length > 0){
                return nums1[0];
            }else{
                return nums2[0];
            }
        }
        int nums3Length = nums1.length;
        int y = 0;
        for (int i = 0; i < nums2.length; i++){
            for (int j = y; j < nums3.length; j++){
                if  (nums2[i] <= nums3[j]){
                    for (int x = nums3Length - 1; x >= j; x--){
                        nums3[x + 1] = nums3[x];
                    }
                    nums3Length ++;
                    nums3[j] = nums2[i];
                    y = j;
                    break;
                }else if (j >= nums3Length){
                    nums3[j] = nums2[i];
                    nums3Length ++;
                    y = j;
                    break;
                }
            }
        }
        if (nums3.length % 2 == 0){
            return  (double)(nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2;
        }else{
            return nums3[nums3.length / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,7,6,2,132,65,46,5,321,54,654,23,168,4218,4,654321,5,465,111,321,32,84,652,132,1,584,621,54,651,684,32,56,4,6246,54,21,654,231};
        int[] nums2 = new int[]{3,4,48,94,654,8,4,654,65,48,9,51,65,13,21,588,4968,46,51,654,62,16,546,51,2,16,51,654,65,462,13,21,54,6,7489,45,621,35,213,215,6,5165,46,54,897,74,954,62,165,1,651,564,89,798,7,54,621,321,23,132,16,5489};
        long time = System.currentTimeMillis();
        System.out.println(findMedianSortedArrays(nums1,nums2));
        System.out.println(System.currentTimeMillis() - time);

        String s = "aba";
        int MAX = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < s.length(); j++){
                String str = s.substring(i,j);
                StringBuilder stringBuilder = new StringBuilder(str);
                if (stringBuilder.reverse().toString().equals(str)){
                    Math.max(MAX,j - i);
                }
            }
        }
    }
}
