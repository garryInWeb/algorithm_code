package al.a12;

import java.util.Arrays;

public class Quicksort {
    public void quicksort(int[] nums){
        quicksort(nums,0,nums.length-1);
    }

    private void quicksort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int dividePart = part(nums,start,end);
        quicksort(nums,start,dividePart - 1);
        quicksort(nums,dividePart+1,end);

    }

    private int part(int[] nums, int start, int end) {
        int divideValue = nums[end];
        int i = start;
        int j = start;

        for (;i < end; i++){
            if (nums[i] < divideValue){
                swap(nums,i,j++);
            }
        }
        swap(nums,j,end);
        return j;
    }

    private void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        Quicksort quicksort = new Quicksort();
        int[] nums = {6, 5, 4, 3, 2,2,2,2,10};
        quicksort.quicksort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
