package old.check;

/**
 * Created by zhengtengfei on 2018/10/8.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode sout = this;
        while(sout != null){
            result.append(sout.val);
            sout = sout.next;
        }
        return result.toString();
    }
}
