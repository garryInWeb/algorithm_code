package al.a28;

import java.util.Arrays;

/**
 * 数据流实时查找中位数
 */
public class MedianFinder {

    int[] minHeap = new int[16];
    int[] maxHeap = new int[16];
    int count = 0,minCount = 0,maxCount = 0;
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public double findMedian() {
        if((count&1) == 1){
            return minHeap[1];
        }else{
            return ((double)(minHeap[1] + maxHeap[1])) / 2;
        }
    }

    public void addNum(int num) {
        count ++;
        if((count&1)==1){
            if (maxHeap[1] > num){
                maxPut(num);
                num = maxPoll();
            }
            minPut(num);
        }else{
            if(minHeap[1] < num){
                minPut(num);
                num = minPoll();
            }
            maxPut(num);
        }
    }

    private void minPut(int num){
        if(minCount + 1 >= minHeap.length){
            minHeap = Arrays.copyOf(minHeap,minHeap.length * 2);
        }
        int index = ++minCount;
        minHeap[index] = num;
        while (index > 1 && minHeap[index] < minHeap[index/2]){
            swap(minHeap,index,index/2);
            index /= 2;
        }
    }

    private void maxPut(int num){
        if(maxCount + 1 >= maxHeap.length){
            maxHeap = Arrays.copyOf(maxHeap,maxHeap.length * 2);
        }
        int index = ++maxCount;
        maxHeap[index] = num;
        while (index > 1 && maxHeap[index] > maxHeap[index/2]){
            swap(maxHeap,index,index/2);
            index /= 2;
        }
    }

    private void swap(int[] heap,int front, int end) {
        int temp = heap[front];
        heap[front] = heap[end];
        heap[end] = temp;
    }

    /**
     * 出堆
     */
    public int minPoll(){
        int index = 1;
        int result = minHeap[index];
        swap(minHeap,index,minCount);
        minCount --;
        minHeapifys(minHeap,index,minCount);
        return result;
    }

    public int maxPoll(){
        int index = 1;
        int result = maxHeap[index];
        swap(maxHeap,index,maxCount);
        maxCount --;
        maxHeapifys(maxHeap,index,maxCount);
        return result;
    }

    public void minHeapifys(int[] heap,int i,int length){
        int change = i;
        while (change * 2 <= length){
            int temp = change;
            if (heap[change] > heap[temp * 2])change = temp * 2;
            if (temp * 2 + 1 <= length && heap[change] > heap[temp * 2 + 1])change = temp * 2 + 1;

            if (temp == change) break;
            else swap(heap,temp,change);
        }
    }

    public void maxHeapifys(int[] heap,int i,int length){
        int change = i;
        while (change * 2 <= length){
            int temp = change;
            if (heap[change] < heap[temp * 2])change = temp * 2;
            if (temp * 2 + 1 <= length && heap[change] < heap[temp * 2 + 1])change = temp * 2 + 1;

            if (temp == change) break;
            else swap(heap,temp,change);
        }
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());;
    }
}
