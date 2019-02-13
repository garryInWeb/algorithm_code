package old.drop.al3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by zhengtengfei on 2018/10/29.
 */
public class ProductAndConsumerQueue {

    String[] queue;
    int head = 0;
    int tail = 0;
    int n = 0;

    BlockingQueue blockingQueue = new LinkedBlockingQueue(5);

    public ProductAndConsumerQueue(int capacity) {
        queue = new String[capacity];
        n = capacity;
    }

    public void blockEnqueue(String s) throws InterruptedException {
        blockingQueue.put(s);
        System.out.println("put" + s);
    }

    public String blockDequeue() throws InterruptedException {
        return (String)blockingQueue.take();
    }

    public synchronized void enqueue(String s) throws InterruptedException {
        while ((tail + 1)%n == head){
            System.out.println("wait");
            wait();
        }

        System.out.println("run");
        queue[tail] = s;
        tail = (tail + 1) % n;

        notifyAll();
    }

    public synchronized String dequeue() throws InterruptedException {
        while (head == tail){
            System.out.println("wait");
            wait();
        }

        System.out.println("run");
        String result = queue[head];
        head = (head + 1) % n;

        notifyAll();
        return result;
    }

    public static void main(String[] args) {

        ProductAndConsumerQueue productAndConsumerQueue = new ProductAndConsumerQueue(3);
        new Thread(() -> {
            try {
                new Productor(productAndConsumerQueue).blockProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                new Consumer(productAndConsumerQueue).blockConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        new Thread(() -> {
//            try {
//                new Consumer(productAndConsumerQueue).consumer();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                new Consumer(productAndConsumerQueue).consumer();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }
}
class Productor implements Runnable{
    ProductAndConsumerQueue productAndConsumerQueue;

    public Productor(ProductAndConsumerQueue productAndConsumerQueue) {
        this.productAndConsumerQueue = productAndConsumerQueue;
    }

    public void product() throws InterruptedException {
        while(true){
            String i = String.valueOf(Math.random());
            productAndConsumerQueue.enqueue(i);
        }
    }
    public void blockProduct() throws InterruptedException {
        while(true){
            String i = String.valueOf(Math.random());
            productAndConsumerQueue.blockEnqueue(i);
        }
    }

    @Override
    public void run() {
        try {
//            product();
            blockProduct();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Consumer implements Runnable{
    ProductAndConsumerQueue productAndConsumerQueue;

    public Consumer(ProductAndConsumerQueue productAndConsumerQueue) {
        this.productAndConsumerQueue = productAndConsumerQueue;
    }

    public String consumer() throws InterruptedException {
        while(true) {
            productAndConsumerQueue.dequeue();
        }
    }

    public String blockConsumer() throws InterruptedException {
        while(true) {
            System.out.println(productAndConsumerQueue.blockDequeue());

        }
    }

    @Override
    public void run() {
        try {
            blockConsumer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}