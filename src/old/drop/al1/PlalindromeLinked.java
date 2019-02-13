package old.drop.al1;

/**
 * Created by zhengtengfei on 2018/10/18.
 */
public class PlalindromeLinked {


    class StrLink{
        StrLink lefLink;
        char data;
        StrLink rigLink;
    }

    public boolean checkPlalindrome(String a){
        StrLink strLink = strToLink(a);
//        while (strLink != null){
////            System.out.println(strLink.lefLink);
//            System.out.println(strLink.data);
//            strLink = strLink.rigLink;
//        }
//        return false;
        for (int i = 0; i < a.length() ; i++){
            StrLink checkStr = strLink;
        }
        int index = a.length() / 2;

        StrLink percheck = strLink;
        StrLink houcheck = strLink;

        if (a.length() % 2 == 0){
            for (int i = 1; i <= index; i++){
                percheck = percheck.rigLink;
            }
            houcheck = percheck.lefLink;
        }else{
            for (int i = 1; i <= index; i++){
                percheck = percheck.rigLink;
            }
            houcheck = percheck.rigLink;
            percheck = percheck.lefLink;
        }

        while(houcheck != null || percheck != null){
            if (houcheck == null || percheck == null){
                return false;
            }
            if (houcheck.data != percheck.data){
                return false;
            }
            houcheck = houcheck.rigLink;
            percheck = percheck.lefLink;
        }
        return true;
    }

    public static void main(String[] args) {
        PlalindromeLinked plalindromeLinked = new PlalindromeLinked();
        System.out.println(plalindromeLinked.checkPlalindrome("anvjasijvoi"));
    }

    private StrLink strToLink(String a) {

        StrLink strLink = new StrLink();
        StrLink result = strLink;
        for (char temp : a.toCharArray()){
            strLink.data = temp;
            StrLink strTemp = strLink;
            strLink.rigLink = new StrLink();
            strLink = strLink.rigLink;
            strLink.lefLink = strTemp;
        }
        strLink = strLink.lefLink;
        strLink.rigLink = null;
        return result;
    }

}
