package al.a30;

public class WeiXinMap{
    Node[] data = new Node[10];

    class Node{
        int val;
        Node next;
    }

    public void put(int i,int j){
        Node nodes = data[i];
        Node newNode = new Node();
        newNode.val = j;
        if (nodes == null)
            nodes = newNode;

        Node pre = null;
        while(nodes != null){
            if (nodes.val == j)
                return;
            pre = nodes;
            nodes = nodes.next;
        }
        pre.next = newNode;
    }

    public boolean charge(int i, int j){
        Node nodes = data[i];

        while(nodes != null){
            if (nodes.val == j)
                return true;
            nodes = nodes.next;
        }
        return false;
    }
}
