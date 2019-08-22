package al.a18;


public class GaryHashMap<K,V> {

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    public GaryHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.capacity = DEFAULT_INITIAL_CAPACITY;
//        hashtable = new Node[capacity];
        size = 0;
    }

    private final float loadFactor;
    private int capacity;
    private int size;

    private Node<K,V>[] hashtable;


    class Node<K,V>{
        K key;
        V value;
        int hash;

        Node<K,V> hnext;
    }

    private int hash(Object key){
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) ;
    }

    public V get(K key){
        int hash = hash(key);
        Node<K,V> node = hashtable[hash & (capacity-1)];
        if (node != null){
            do{
                if (node.key.equals(key)){
                    return node.value;
                }
            }while((node = node.hnext)!=null);
        }
        return null;
    }

    public V put(K key, V value){
        Node<K,V> node = new Node<>();
        node.key = key;
        node.value = value;
        node.hash = hash(key);
        node.hnext = null;

        int hash = hash(key);
        Node<K, V>[] tal ;
        int i;
        if ((tal = this.hashtable) == null)
            tal = resize();
         i = hash & (this.capacity - 1);
        Node<K,V> p = tal[i];

        Node<K,V> e = null;
        if (p == null){
            tal[i] = node;
        }else{
            if (p.hash == hash && p.key.equals(key)){
                e = p;
            }else{
                while(true){
                    if ((e = p.hnext) == null){
                        p.hnext = node;
                        break;
                    }
                    if (e.hash == hash && e.key.equals(key)){
                        break;
                    }
                    p = e;
                }
            }
        }

        if (e != null){
            // 省略 if absent
            p.value = value;
            return p.value;
        }

        if(++ size > capacity*loadFactor )
            resize();

        return node.value;
    }

    private Node<K, V>[] resize() {
        Node<K,V>[] oldTal = hashtable;
        int oldCap = oldTal==null ? 0 :oldTal.length;
        int newCap = oldCap == 0 ? DEFAULT_INITIAL_CAPACITY :oldCap << 1;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTal = (Node<K,V>[])new Node[newCap];
        hashtable = newTal;
        capacity = newCap;
        if (oldTal != null){
            for (int i = 0; i < oldCap; i++){
                Node<K,V> p;
                if((p = oldTal[i]) != null){
                    if (p.hnext == null){
                        newTal[p.hash & (newCap - 1)] = p;
                    }else {
                        Node<K,V> loHead = null,loTail = null;
                        Node<K,V> hiHead = null,hiTail = null;
                        do{
                            if ((p.hash & oldCap) == 0){
                                if (loTail == null)
                                    loHead = p;
                                else
                                    loTail.hnext = p;
                                loTail = p;
                           }else{
                                if (hiTail == null)
                                    hiHead = p;
                                else
                                    hiTail.hnext = p;
                                hiTail = p;
                            }
                        }while((p = p.hnext) != null);
                        if (loHead != null)
                            newTal[i] = loHead;
                        if (hiHead != null)
                            newTal[i+oldCap] = hiHead;
                    }
                }
            }
        }
        return newTal;
    }

    public static void main(String[] args) {
        GaryHashMap<String,String> map = new GaryHashMap<>();
        for (int i = 0; i < 21; i++){
            map.put("abc"+i,"12");
        }

        System.out.println(map.get("abc15"));
    }
}
