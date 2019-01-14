package al3;

/**
 * Created by zhengtengfei on 2018/10/29.
 * 循环队列
 */
public class ArrayCycQueue {
    String[] cycQueue ;
    int n = 0;
    int head = 0;
    int tail = 0;

    public ArrayCycQueue(int capacity) {
        cycQueue = new String[capacity];
        n = capacity;
    }

    public void enqueue(String s){
        if ((tail + 1) % n == head){
            System.out.println("满");
            return;
        }
        cycQueue[tail] = s;
        tail = (tail + 1) % n;
    }

    public String dequeue(){
        if (tail == head){
            System.out.println("空");
            return null;
        }
        String result = cycQueue[head];
        head = (head + 1) % n;

        return result;
    }

    public static void main(String[] args) {
        ArrayCycQueue arrayCycQueue = new ArrayCycQueue(3);
        arrayCycQueue.enqueue("s");
        arrayCycQueue.enqueue("b");
        arrayCycQueue.enqueue("d");
        arrayCycQueue.enqueue("c");

        System.out.println(arrayCycQueue.dequeue());
        System.out.println(arrayCycQueue.dequeue());
        System.out.println(arrayCycQueue.dequeue());
        System.out.println(arrayCycQueue.dequeue());
    }
}
