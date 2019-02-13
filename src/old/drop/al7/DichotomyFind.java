package old.drop.al7;

/**
 * Created by zhengtengfei on 2018/11/5.
 */
public class DichotomyFind {

    public static int simpleFind(int[] arr,int index,int ait){

        if (arr[index] >= ait){
            if (index == 0 || arr[index-1] < ait)
                return arr[index];
            index--;
            return simpleFind(arr,index,ait);
        }
        if (index == 0 || index == arr.length){
            return -1;
        }
        if (arr[index] < ait){
            return simpleFind(arr,(index + arr.length + 1) / 2,ait);
        }else{
            return simpleFind(arr,(index) / 2,ait);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,5,8,11,53,77,99,103,188,233,566,658,789,987};
        System.out.println(simpleFind(arr,arr.length/2,9));
    }
    int arr[] = new int[]{0,1,2,3,4,5,6,7,8,9};
//    public static double sqrt(double x){
//        if (x < 0){
//            return Double.NaN;
//        }
//        double low = 0;
//        double up = x;
//
//        double sum = 0;
//
//        for (int i = 0; i < 6; i++){
//
//        }
//    }
}
