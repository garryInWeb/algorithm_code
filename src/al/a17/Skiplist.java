package al.a17;

import java.util.Arrays;
import java.util.Random;

public class Skiplist {

    private static final int MAX_LEVEL = 16;
    private Node head = new Node();
    private Random random = new Random();

    private int currentLevel = 0;

    public void printAll(){
        Node p = head;
        int level = currentLevel - 1;

        for (int i = level; i >= 0; i-- ){
            while((p = p.forwards[i]) != null){
                System.out.print(p);
            };
            System.out.println();
            p = head;
        }
    }
    public static int count = 0;
    public Node find(double score){
        Node p = head;
        for (int i = currentLevel - 1; i >= 0; i --){
            while (p.forwards[i] != null && p.forwards[i].score < score){
                p = p.forwards[i];
                count++;
            }
        }
        if (p.forwards[0] != null && p.forwards[0].score == score){
            return p.forwards[0];
        }else{
            return null;
        }
    }
    public void delete(double score){
        Node[] update = new Node[currentLevel];
        Node p = head;
        for (int i = currentLevel - 1; i >= 0; i --){
            while (p.forwards[i] != null && p.forwards[i].score < score){
                p = p.forwards[i];
            }
            update[i] = p;
        }
        for (int i = currentLevel - 1;i >= 0; i--){
            if (update[i].forwards[i] != null && update[i].forwards[i].score == score){
                update[i].forwards[i] = update[i].forwards[i].forwards[i];
            }
        }
    }
    public void insert(double score,String key,String value){
        int level = randomly();
        Node newNode = new Node(score,key,value,level);
        Node[] update = new Node[level];
        for (int i = 0; i < level; ++i){
            update[i] = head;
        }

        Node p = head;
        for (int i=level-1; i >= 0; i--){
            while(p.forwards[i]!=null && p.forwards[i].score < score){
                p = p.forwards[i];
            }
            update[i] = p;
        }

        for (int i = 0; i < level; i++){
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }
        if (level > currentLevel)currentLevel = level;
    }

    public int randomly(){
        int level = 1;
        for (int i = 0; i < MAX_LEVEL; i++){
            if((random.nextInt() & 1) == 1){
                level ++;
            }
        }
        return level;
    }
    class Node{
        private double score;
        private int maxLevel;
        private String key;
        private String value;

        Node[] forwards = new Node[MAX_LEVEL];

        public Node() {
        }

        public Node(double score, String key, String value,int maxLevel) {
            this.score = score;
            this.key = key;
            this.value = value;
            this.maxLevel = maxLevel;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "score=" + score +
//                    ", maxLevel=" + maxLevel +
//                    ", key='" + key + '\'' +
//                    ", value='" + value + '\'' +
//                    ", forwards=" + Arrays.toString(forwards) +
                    '}' + "   ";
        }
    }

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        for (int i = 0; i < 13; i ++) {
            skiplist.insert(i, ""+i, "1");
        }
        skiplist.printAll();
        System.out.println();
        System.out.println();
//        System.out.println();
//        System.out.println(skiplist.find(1299999));
//        System.out.println(count)
//        ;
        skiplist.delete(14);
        skiplist.printAll();
    }
}
