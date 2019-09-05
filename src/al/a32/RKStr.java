package al.a32;

public class RKStr {
    static int[] var26 = new int[26];

    static {
        for (int i = 0; i < var26.length; i++) {
            var26[i] = (int) Math.pow(26,i);
        }
    }

    public static boolean match(String source,String target){
        int targetLength = target.length();
        int sourceRKLength = source.length() - targetLength + 1;
        int targetRK = 0;
        int[] sourceRK = new int[sourceRKLength];
        for (int i = 0,j=targetLength-1; i < targetLength; i++,j--){
            sourceRK[0] += (source.charAt(i) - '`') * var26[j];
            targetRK += (target.charAt(i) - '`') * var26[j];
        }
        if (sourceRK[0] == targetRK) return true;
        for (int i = 1; i < sourceRKLength; i++) {
            sourceRK[i] = (sourceRK[i - 1] - (source.charAt(i - 1) - '`') * var26[targetLength-1]) * 26 + source.charAt(i+targetLength-1) - '`';
            if (sourceRK[i] == targetRK)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(RKStr.match("abbc","ab"));
    }
}
