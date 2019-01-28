package old.leetCode.part141;

/**
 * Created by zhengtengfei on 2019/1/28.
 */
public class LinkedListCycle {
    static class ListNode {
        int val;
        LinkedListCycle.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (true){
            if (slow == fast) return true;
            if (slow.next != null){
                slow = slow.next;
            }else{
                return false;
            }
            if (fast.next != null && fast.next.next != null){
                fast = fast.next.next;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode3;

        System.out.println(hasCycle(listNode1));

    }
}
