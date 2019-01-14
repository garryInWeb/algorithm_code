package check;

import java.util.ArrayList;

/**
 * Created by zhengtengfei on 2018/10/11.
 */
public class Solucation05 {
    public String longestPalindrome(String s) {
        int MAX = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++){
            for (int j = i + 1; j <= s.length(); j++){
                String str = s.substring(i,j);
                StringBuilder stringBuilder = new StringBuilder(str);
                if (checkPalindromic(str) && j - i > MAX){
                    result = str;
                    MAX = str.length();
                }
            }
        }
        return result;
    }

    public String longestPalindromes(String s) {
        int windowSize=s.length();
        int end;
        int i;
        while(windowSize>0){
            for(i=0;i+windowSize<=s.length();i++){
                end=windowSize+i-1;
                if(isPalindromic(s,i,end)){
                    return s.substring(i,end+1);
                }
            }
            windowSize--;
        }
        return "";
    }

    public boolean isPalindromic(String s,int start,int end){
        if(start>=end){
            return true;
        }
        if(s.charAt(start)==s.charAt(end)){
            return isPalindromic(s,start+1,end-1);
        }
        return false;
    }

    public boolean checkPalindromic(String str){
        int divied = str.length() / 2;
        int n = divied - 1, m = 0;
        if(str.length() % 2 == 0){
            m = divied;
        }else{
            m = divied + 1;
        }
        while(n > 0 || m < str.length()){
            if(str.charAt(n) != str.charAt(m))
                return false;
            n --;
            m ++;
        }
        return true;
    }



    public String isPalindromic(String s){

        if (s.isEmpty()){
            return "";
        }
        int size = s.length();
        int max_len = 1;
        int start = 0;
        boolean dp[][] = new boolean[size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0 ; j <= i; j++){
                if (i - j < 2) {
                    dp[j][i] = (s.charAt(j) == s.charAt(i));
                }
                else{
                    dp[j][i] = dp[j+1][i-1] && (s.charAt(j) == s.charAt(i));
                }
                if (dp[j][i] && max_len < i - j + 1){
                    max_len = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start,start + max_len);
    }


        public static String convert(String s, int numRows) {
            int strLen = s.length();
            char[][] arrayStr = new char[numRows][strLen];
            int index = 0;
            int x = 0,y = 0,multiple = 1;
            while (index < strLen){
                if (y % (numRows - 1) == 0){
                    arrayStr[x][y] = s.charAt(index);
                    index ++;
                    if (x == numRows - 1) {
                        x = 0;
                        y++;
                    }else {
                        x++;
                    }
                }else{
                    arrayStr[multiple * (numRows - 1) - y][y] = s.charAt(index);
                    index ++;
                    y ++;
                    if (y % (numRows - 1) == 0)
                        multiple = y / (numRows-1) + 1;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < arrayStr.length; i++){
                for (int j = 0; j < arrayStr[i].length; j++){
                    if (arrayStr[i][j] != 0){
                        stringBuilder.append(arrayStr[i][j]);
                    }
                }
            }
            return stringBuilder.toString();
        }

    public static int reverse(int x) {
        int result = 0;
        ArrayList<Integer> list = new ArrayList();
        while(x != 0){
            int temp = x % 10;
            list.add(temp);
            x = x / 10;
        }
        int length = list.size();
        for (Integer i : list){
            result += i * Math.pow(10,length);
            if (result == Integer.MAX_VALUE) {
                result = 0;
                break;
            }
            length --;
        }
        return result;
    }
    public static void main(String[] args) {
//        check.Solucation05 solucation05 = new check.Solucation05();
//        solucation05.isPalindromic("ababa");
        char[][] s = new char[100][100];
        System.out.println(s[1][1] == 0);

        System.out.println(reverse(1534236469));


//        String index = "avc";
//        System.out.println(index.charAt(4));
    }
}
