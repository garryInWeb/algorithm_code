package old.leetCode.part455;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2019/1/29.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0,sIndex = 0;
        while (gIndex != g.length && sIndex != s.length){
            if (g[gIndex] >= s[sIndex]){
                result ++;
                gIndex ++;
                sIndex ++;
            }else{
                sIndex ++;
            }
        }
//        for (int i = 0; i < g.length; i++){
//            for (int j = 0; j < s.length; j++){
//                if (s[j] >= g[i]){
//                    result++;
//                    s[j] = 0;
//                    break;
//                }
//            }
//        }
        return result;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1,2,3,4};
        int[] s = new int[]{1,1,4};
        AssignCookies assignCookies = new AssignCookies();
        System.out.println(assignCookies.findContentChildren(g,s));
    }
}
