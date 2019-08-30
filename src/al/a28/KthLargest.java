package al.a28;

/**
 * top K
 */
public class KthLargest {
    int[] heap;
    int count = -1;
    int max;

    public KthLargest(int k, int[] nums) {
        max = k;
        heap = new int[k];
        for(int num : nums){
            put(num);
        }
    }

    public int add(int val) {
        put(val);
        return heap[0];
    }

    /**
     * 入堆
     */
    public void put(int num){
        if(count+1 == max){
            if(num < heap[0]) return;
            poll();
        }
        int index = ++count;
        heap[index] = num;
        while (index > 0 && heap[index] < heap[(index-1)/2]){
            swap(index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public void heapifys(int[] heap,int i,int length){
        int change = i;
        while (change * 2 + 1 <= length){
            int temp = change;
            if (heap[change] > heap[temp * 2 + 1])change = temp * 2 + 1;
            if (temp * 2 + 2 <= length && heap[change] > heap[temp * 2 + 2])change = temp * 2 + 2;

            if (temp == change) break;
            else swap(heap,temp,change);
        }
    }

    /**
     * 出堆
     */
    public int poll(){
        int index = 0;
        int result = heap[index];
        swap(index,count);
        count --;
        heapifys(heap,index,count);
        return result;
    }
    private void swap(int front, int end) {
        int temp = heap[front];
        heap[front] = heap[end];
        heap[end] = temp;
    }

    private void swap(int[] heap,int front, int end) {
        int temp = heap[front];
        heap[front] = heap[end];
        heap[end] = temp;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */