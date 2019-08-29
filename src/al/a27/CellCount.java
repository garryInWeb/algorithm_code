package al.a27;

public class CellCount {
    public static int cellCount(int n){
        return count(n);
    }
    public static int count(int item){
        if (item == 0)
            return 1;
        return item < 3 ? count(item-1)*2 :count(item-1)*2-count(item-3);
    }

    public static void main(String[] args) {
        System.out.println(cellCount(5));
        System.out.println(cellCount(6));
    }
}
