package old.al2;

/**
 * Created by zhengtengfei on 2018/10/23.
 */
public class LinkedRevert {

    static class StrLink{
        char data;
        StrLink nextLink;
    }

    public static StrLink getRevert(StrLink strLink){

        int count = 0;
        StrLink result = null;
        while (strLink != null){
            StrLink temp = new StrLink();
            temp.data = strLink.data;
            if (count == 0){
                temp.nextLink = null;
            }else{
                temp.nextLink = result;
            }

            result = temp;
            count ++;
            strLink = strLink.nextLink;
        }
        return result;
    }

      static class ListNode {
          int val;
          ListNode next;

          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode curr = head.next;
        while(curr != null){
            if (curr == head){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        System.out.println(hasCycle(listNode1));

    }

//    public static void main(String[] args) {
//        StrLink strLink = new StrLink();
//        StrLink strLink1 = new StrLink();
//        StrLink strLink2 = new StrLink();
//        strLink.data = 'a';
//        strLink1.data = 'b';
//        strLink2.data = 'c';
//        strLink.nextLink = strLink1;
//        strLink1.nextLink = strLink2;
//
//        StrLink re  = getRevert(strLink);
//        while   (re != null){
//            System.out.println(re.data);
//            re = re.nextLink;
//        }
//
//    }
}
