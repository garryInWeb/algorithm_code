package old.leetCode.part402;

/**
 * Created by zhengtengfei on 2019/1/30.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        StringBuilder str = new StringBuilder(num);
        for (int i = 0; i < k ; i++){
            for (int j = 0; j < num.length(); j++){
                if (j == num.length() - 1 ) {
                    str.deleteCharAt(j);
                    break;
                }
                if((int) str.charAt(j) > (int) str.charAt(j + 1)){
                    str.deleteCharAt(j);
                    break;
                }
            }
        }
        if(str.toString().startsWith("0")){
            for (int i = 0; i < str.length()-1;){
                if (str.charAt(i) != '0') break;
                str.deleteCharAt(i);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        removeKDigits.removeKdigits("1173",2);
    }
}
