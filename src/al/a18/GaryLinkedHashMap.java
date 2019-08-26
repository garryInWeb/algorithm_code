package al.a18;

import al.a18.GaryHashMap;

public class GaryLinkedHashMap<K,V> extends GaryHashMap {

    Entry head,tail;

    class Entry<K,V> extends GaryHashMap.Node{
        Entry<K,V> before,after;
        Entry(K key, V value, int hash, Entry<K,V> hnext){
            super(key,value,hash,hnext);
        }
    }

    private Entry<K, V> newNode(K key, V value) {
        Entry<K,V> node = new Entry<>(key,value,hash(key),null);
        listNodeLat(node);
        return node;
    }

    protected void afterNodeAccess(Entry<K,V> p) {
        Entry<K,V> last = tail,b = p.before,a = p.after;
        if (tail == p)
            return;
        if (b == null){
            head = a;
            head.before = null;
        }else{
            b.after = a;
            a.before = b;
        }
        last.after = p;
        p.before = last;
        p.after = null;
        tail = p;
    }

    public V get(Object k){
        Node<K,V> node;
        if ((node = getNode(k)) == null){
            return null;
        }
        afterNodeAccess(node);
        return node.value;
    }

    private Node<K, V> getNode(Object key) {
        int hash = hash(key);
        Node<K,V> node = hashtable[hash & (capacity-1)];
        if (node != null){
            do{
                if (node.key.equals(key)){
                    return node;
                }
            }while((node = node.hnext)!=null);
        }
        return null;
    }

    private void listNodeLat(Entry<K, V> node) {
        Entry last = tail;
        tail = node;
        if (head == null){
            head = node;
        }
        else {
            node.before = last;
            last.after = node;
        }
    }

}
