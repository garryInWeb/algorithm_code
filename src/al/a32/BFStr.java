package al.a32;

public class BFStr {
    public static boolean match(String source,String target){
        for (int i = 0; i < source.length() - target.length() + 1; i++){
            boolean result = true;
            for (int temp = i,j = 0; j < target.length(); j++,temp++) {
                if (source.charAt(temp) != target.charAt(j)){
                    result = false;
                    break;
                }
            }
            if (result) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(BFStr.match("abba"," "));
    }
}
