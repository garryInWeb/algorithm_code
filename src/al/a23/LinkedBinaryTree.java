package al.a23;


import java.util.*;

public class LinkedBinaryTree<T extends Comparable<T>> {

    private Node<T> head;

    class Node<N extends Comparable<N>> {
        N data;
        Node<N> lNode;
        Node<N> rNode;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    // add
    public Node<T> put(T data){
        Node<T> node = new Node<T>();
        node.data = data;
        if (head == null){
            head = node;
            return head;
        }
        Node<T> temp = head;
        while(true){
            if (data.compareTo(temp.data) < 0){
                if (temp.lNode == null){
                    temp.lNode = node;
                    return node;
                }
                temp = temp.lNode;
            }else {
                if (temp.rNode == null){
                    temp.rNode = node;
                    return node;
                }
                temp = temp.rNode;
            }
        }
    }

    public void preOrder(Node<T> node){
        if (node == null) return;
        System.out.println(node);
        preOrder(node.lNode);
        preOrder(node.rNode);
    }
    public void inOrder(Node<T> node){
        if (node == null) return;
        inOrder(node.lNode);
        System.out.println(node);
        inOrder(node.rNode);
    }
    public void postOrder(Node<T> node){
        if (node == null) return;
        postOrder(node.lNode);
        postOrder(node.rNode);
        System.out.println(node);
    }

    public void breadthFirstOrder(){
        LinkedList<Node<T>> linkedList = new LinkedList<>();
        if (head != null)
            linkedList.push(head);
        while(!linkedList.isEmpty()){
            Node<T> node = linkedList.poll();
            System.out.println(node);

            if (node.rNode != null)
                linkedList.offer(node.rNode);
            if (node.lNode != null)
                linkedList.offer(node.lNode);
        }
    }

    private int depthFirstOrderCount(int count, Node<T> node){
        if (node == null)
            return 0;

        return count + 1 + Math.max(depthFirstOrderCount(count,node.lNode),
                depthFirstOrderCount(count,node.rNode));
    }

    public int depthFirstOrderCount(){
        return depthFirstOrderCount(0,head);
    }

    public T find(T data){
        List<Node<T>> node = findNode(data);
        if (!node.isEmpty())
            return node.get(0).data;
        return null;
    }

    public Node<T> delete(T data){
        Node<T> node = head;
        Node<T> preNode = null;
        Map<Node<T>,Node<T>> nodeNodeMap = new HashMap<>();
        while(node != null) {
            if (data.compareTo(node.data) == 0){
                nodeNodeMap.put(node,preNode);
            }
            preNode = node;
            if (data.compareTo(node.data) < 0) {
                node = node.lNode;
            }else {
                node = node.rNode;
            }
        }

        if (nodeNodeMap.isEmpty())
            return null;

        for (Map.Entry<Node<T>,Node<T>> entry : nodeNodeMap.entrySet()){
            node = entry.getKey();
            preNode = nodeNodeMap.get(node);
            if (node.lNode != null && node.rNode != null){
                Node<T> rightNode = node.rNode;
                while(rightNode.lNode != null){
                    rightNode = rightNode.lNode;
                }
                node.data = rightNode.data;
                node = rightNode;
            }

            Node<T> changeNode;
            if (node.lNode != null) changeNode = node.lNode;
            else if(node.rNode != null) changeNode = node.rNode;
            else changeNode = null;

            if (preNode == null)
                head = changeNode;
            else if (preNode.lNode == node)
                preNode.lNode = changeNode;
            else
                preNode.rNode = changeNode;
        }
        return node;
    }

    private List<Node<T>> findNode(T data) {
        List<Node<T>> nodeList = new ArrayList<>();
        Node<T> node = head;
        while(node != null) {
            if (data.compareTo(node.data) < 0) {
                node = node.lNode;
            }else if (data.compareTo(node.data) > 0){
                node = node.rNode;
            }else{
                nodeList.add(node);
                node = node.rNode;
            }
        }
        return nodeList;
    }

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree<>();
        int[] num = new int[]{10,9,7,1,3,4,5,6,2,8,8};
        for (int value : num) linkedBinaryTree.put(value);
        System.out.println();
        linkedBinaryTree.breadthFirstOrder();
        System.out.println();
//        linkedBinaryTree.preOrder(linkedBinaryTree.head);
//        System.out.println();
//        linkedBinaryTree.inOrder(linkedBinaryTree.head);
//        System.out.println();
//        System.out.println(linkedBinaryTree.find(8));
//        System.out.println();
//        System.out.println(linkedBinaryTree.delete(8));
//        System.out.println();
//        System.out.println("after" + linkedBinaryTree.find(8));
        System.out.println();
        System.out.println(linkedBinaryTree.depthFirstOrderCount());

    }
}
