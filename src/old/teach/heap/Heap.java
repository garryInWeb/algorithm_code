package old.teach.heap;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2019/2/22.
 */
public class Heap {

    private int[] heap;
    private int count;

    public Heap(int[] nums) {
        buildHeap(nums);
    }

    private void buildHeap(int[] nums) {
        count = nums.length - 1;
        heap = new int[nums.length];
        heap = nums;
        for (int i = count / 2; i >= 1; i--){
            heapify(i);
        }
    }

    private void heapify(int index) {
        while (true){
            int change = index;
            if (index * 2 <= count && heap[change] < heap[index * 2])
                change = index * 2;
            if (index * 2 + 1 <= count && heap[change] < heap[index * 2 + 1])
                change = index * 2 + 1;
            if (change == index)
                break;
            swap(change,index);
            index = change;
        }
    }

    /**
     * 入堆
     */
    public void put(int num){
        if (count == heap.length-1) extend();
        int index = ++count;
        heap[index] = num;
        while (index > 0 && heap[index] > heap[index/2]){
            swap(index,index/2);
        }
    }

    /**
     * 数组扩展
     */
    private void extend() {
        heap = Arrays.copyOf(heap,heap.length * 2);
    }

    /**
     * 出堆
     */
    public int poll() throws Exception {
        if (heap.length == 0) throw new RuntimeException("out of heap.");
        int index = 1;
        int result = heap[index];
        swap(index,count);

        heapify(index);
        count --;
        return result;
    }

    private void swap(int front, int end) {
        int temp = heap[front];
        heap[front] = heap[end];
        heap[end] = temp;
    }

    public int[] getHeap() {
        return heap;
    }

    public static void main(String[] args) {
        int[] i = new int[]{0,7,5,19,8,4,1,20,13,16};
        Heap heap = new Heap(i);
        System.out.println(Arrays.toString(heap.getHeap()));
        heap.put(10);
        System.out.println(Arrays.toString(heap.getHeap()));

    }
}
