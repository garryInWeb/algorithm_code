package al.a32;

public class TwoDimensionStr {
    public static boolean bfMatch(char[][] source,char[][] target){
        for (int i = 0; i < source.length - target.length + 1; i++) {
            for (int j = 0; j < source[0].length - target[0].length + 1; j++) {
                boolean result = true;
                for (int sX=i,tX=0; tX < target.length; tX ++,sX++){
                    for(int sY=j,tY=0;tY < target[0].length; tY ++,sY++){
                        if(source[sX][sY] != target[tX][tY]) {
                            result = false;
                            break;
                        }
                    }
                }
                if (result)return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] source = new char[][]{{'d','a','b','c'},
                {'e','f','a','d'},
                {'c','c','a','f'},
                {'d','e','f','c'}};
        char[][] target = new char[][]{{'a','a'},
                {'e','f'}};
        System.out.println(bfMatch(source,target));
    }
}
