package al.a23;


import java.util.LinkedList;

public class LinkedBinaryTree<T extends Comparable<T>> {

    private Node<T> head;

    class Node<T> {
        T data;
        Node<T> lNode;
        Node<T> rNode;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public Node<T> put(T data){
        Node<T> node = new Node<T>();
        node.data = data;
        if (head == null){
            head = node;
            return head;
        }
        Node<T> temp = head,preTemp = head;
        while(temp != null){
            preTemp = temp;
            if (data.compareTo(temp.data) <= 0){
                temp = temp.lNode;
            }else{
                temp = temp.rNode;
            }
        }
        if (data.compareTo(preTemp.data) <= 0){
            preTemp.lNode = node;
        }else{
            preTemp.rNode = node;
        }

        return node;
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
        LinkedList<Node> linkedList = new LinkedList<>();
        if (head != null)
            linkedList.push(head);
        while(!linkedList.isEmpty()){
            Node node = linkedList.poll();
            System.out.println(node);

            if (node.rNode != null)
                linkedList.offer(node.rNode);
            if (node.lNode != null)
                linkedList.offer(node.lNode);
        }
    }

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree<>();
        int[] num = new int[]{10,9,7,1,3,4,5,6,2,8};
        for (int i = 0; i < num.length; i++)
            linkedBinaryTree.put(num[i]);
        System.out.println();
        linkedBinaryTree.breadthFirstOrder();
        System.out.println();
        linkedBinaryTree.preOrder(linkedBinaryTree.head);
        System.out.println();
        linkedBinaryTree.inOrder(linkedBinaryTree.head);
    }
}
