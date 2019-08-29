package old.leetCode.part1046;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Heap heap = new Heap(stones);

        while(heap.count>=1){
            int item = heap.poll() - heap.poll();
            if(item > 0) heap.put(item);
        }

        if(heap.count < 0) return 0;
        return heap.poll();
    }

    class Heap {

        int[] heap;
        int count;

        public Heap(int[] nums) {
            buildHeap(nums);
        }

        private void buildHeap(int[] nums) {
            count = nums.length - 1;
            heap = nums;
            for (int i = count / 2; i >= 0; i--){
                heapifys(nums,i,count);
            }
        }


        /**
         * 入堆
         */
        public void put(int num){
            int index = ++count;
            heap[index] = num;
            while (index > 0 && heap[index] > heap[(index-1)/2]){
                swap(index,(index-1)/2);
                index = (index-1)/2;
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

        public void heapifys(int[] heap,int i,int length){
            int change = i;
            while (change * 2 + 1 <= length){
                int temp = change;
                if (heap[change] < heap[temp * 2 + 1])change = temp * 2 + 1;
                if (temp * 2 + 2 <= length && heap[change] < heap[temp * 2 + 2])change = temp * 2 + 2;

                if (temp == change) break;
                else swap(heap,temp,change);
            }
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

        public int[] getHeap() {
            return heap;
        }
    }
}
