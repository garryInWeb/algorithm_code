package old.drop.al3;

/**
 * Created by zhengtengfei on 2018/10/29.
 */
public class LinkedQueue {
    class Linked{
        char a;
        Linked next;
    }

    private Linked linkedQueue  = null;
    private Linked tail = null;
    private Linked head = null;

    public void enqueue(char s){
        Linked temp = new Linked();
        temp.a = s;
        if (linkedQueue == null){
            linkedQueue = temp;
            tail = linkedQueue;
            head = linkedQueue;
        }else {
            tail.next = temp;
            tail = tail.next;
        }
    }

    public char dequeue(){
        char e = head.a;
        head = head.next;
        return e;
    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue('a');
        linkedQueue.enqueue('s');
        linkedQueue.enqueue('c');
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());

    }
}
