package check;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhengtengfei on 2018/10/8.
 */
public class Str {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length() ; i++){
            for (int j = i+1; j <= s.length() ; j++){
                String temp = s.substring(i,j);
                if(isOk(temp))
                    if (max < j - i)
                        max = j - i;
            }
        }
        return max;
    }
    public boolean isOk(String result){
        Set<Character> charSequences = new HashSet<>();
        for (int i = 0; i < result.length(); i++){
            char is = result.charAt(i);
            if (!charSequences.contains(is))
                charSequences.add(is);
            else
                return false;
        }
        return true;
    }


}
