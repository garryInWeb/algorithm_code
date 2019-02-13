package old.drop.al8;

class Solution {
    public static int myAtoi(String str) {
        str = str.trim();
        if ("".equals(str) || str == null){
            return 0;
        }
        String[] result = str.split(" ");
        boolean isNegative = false;
        int res = 0;
        if(!result[0].matches("^[-+]?[0-9]+.?[0-9]+")){
            return 0;
        }else{
            if (result[0].indexOf('.') > 0)
                result[0] = result[0].split("\\.")[0];
            double wei = Math.pow(10,result[0].length());
            for (char s : result[0].toCharArray()){
                if (s == '-'){
                    wei /= 10;
                    isNegative = true;
                }else if(s == '+'){
                    wei /= 10;
                }else{
                   res += (s - '0') * wei;
                   if (res >= Integer.MAX_VALUE){
                       if (isNegative){
                           return Integer.MIN_VALUE;
                       }else
                           return Integer.MAX_VALUE;
                   }
                   wei /= 10;
                }
            }
            if (isNegative)
                return -res;
            else
                return res;
        }
    }
    public static int up(int n){
        if (n == 1)return 1;
        if (n == 2)return 2;
        return up(n - 1) + up(n - 2);
    }
    static char[] stackLeft = new char[10];
    static char[] stackRight = new char[10];
    static int indexLeft = 0;
    static int indexRight = 0;
    public static boolean matching(String str){
        for (char s : str.toCharArray()){
            if (s == '(' || s == '[' || s == '{'){
                stackLeft[indexLeft] = s;
                indexLeft++;
            }else{
                stackRight[indexRight] = s;
                indexRight++;
            }
        }
        if (stackRight.length != stackLeft.length)
            return false;
        for (int i = stackLeft.length; i > 0; i--){
            switch (stackLeft[i]){
                case '(':
                    if (stackRight[i] != ')') return false;
                    break;
                case '{':
                    if (stackRight[i] != '}') return false;
                    break;
                case '[':
                    if (stackRight[i] != ']') return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {

        System.out.println(myAtoi("1"));

        System.out.println(up(4));
    }

}