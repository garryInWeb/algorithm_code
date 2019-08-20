package old.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxTest {
    public static void main(String[] args) {
        String line = "This order was placed for QT3000! OK?";
        String parten = "(.*)(\\D*)(\\d+)";
        Pattern pattern = Pattern.compile(parten);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()){
            System.out.println("Found value:" + matcher.group(0));
            System.out.println("Found value:" + matcher.group(1));
            System.out.println("Found value:" + matcher.group(2));
            System.out.println("Found value:" + matcher.group(3));
//            System.out.println("Found value:" + matcher.group(4));
//            System.out.println("Found value:" + matcher.group(5));
        } else{
            System.out.println("NO MATCH");
        }

    }
}
