package old.drop.al5;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2018/11/1.
 */
public class MergeSort {

    public int[] sort(int[] arr,int p,int r){

        if (p >= r){
            return new int[]{arr[p]};
        }
        int q = (p + r) / 2;
        int[] m = sort(arr,p,q);
        int[] n = sort(arr,q+1,r);

        return merge(m,n);
    }

    public int[] quickSort(int[] arr , int n){
        return quickSortC(arr,0,n-1);
    }

    public int[] quickSortC(int[] arr, int p, int r){
        if (p >= r){
            return new int[]{arr[p-1]};
        }

        int q = partition(arr,p,r);
        if (q == 0)
            return arr;
        quickSortC(arr,p,q-1);
        quickSortC(arr,q+1,r);

        return arr;
    }

    private int partition(int[] arr, int p, int r) {

        int i = p;
        int pivot = arr[r];
        for (int j = p; j < r; j++){
            if(arr[j] < pivot){
                swap(arr, i, j);
                i ++;
            }
        }
        swap(arr,i,r);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private int[] merge(int[] m, int[] n) {

        int[] result = new int[m.length + n.length];
        int mIndex = 0;
        int nIndex = 0;
        for (int i = 0; i < result.length ; i++){
            if (mIndex >= m.length){
                result[i] = n[nIndex];
                nIndex ++;
                continue;
            }
            if (nIndex >= n.length){
                result[i] = m[mIndex];
                mIndex ++;
                continue;
            }
            if (m[mIndex] <= n[nIndex]){
                result[i] = m[mIndex];
                mIndex ++;
            }else{
                result[i] = n[nIndex];
                nIndex ++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{8,3,1,9};
//        int[] arr = new int[]{3,1,2,1};
//        System.out.println(Arrays.toString(mergeSort.sort(arr, 0, arr.length-1)));
        System.out.println(Arrays.toString(mergeSort.quickSort(arr, arr.length)));
    }
}
