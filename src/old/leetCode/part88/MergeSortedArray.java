package old.leetCode.part88;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2019/2/13.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0,j = 0;
        int[] result = new int[m+n];
        for (int x = 0; x < result.length; x++){
            if (i != m && (j == n || nums1[i] <= nums2[j])){
                result[x] = nums1[i];
                i++;
                continue;
            }
            if (j != n && (i == m || nums1[i] > nums2[j])){
                result[x] = nums2[j];
                j++;
            }
        }
        System.arraycopy(result, 0, nums1, 0, result.length);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
