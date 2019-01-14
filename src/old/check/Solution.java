package old.check;

/**
 * Created by zhengtengfei on 2018/10/8.
 */
public class Solution {

    int awardOne = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);

        System.out.println(solution.addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbersToList(ListNode l1,ListNode l2,ListNode result,int awardOnes){
        int sum = l1.val + l2.val + awardOnes;
        int resultTemp = 0;
        if  (sum > 10){
            resultTemp = sum % 10;
            awardOne = 1;
        }else{
            resultTemp = sum;
            awardOne = 0;
        }
        return new ListNode(resultTemp);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 结果
        ListNode cResult = new ListNode(0);
        ListNode cResultTemp = cResult;
        while(l1 != null || l2 != null){
            cResultTemp.next = addTwoNumbersToList(l1,l2,cResultTemp,awardOne);
            cResultTemp = cResultTemp.next;

            if  (l1.next != null){
                l1 = l1.next;
            }else{
                l1 = null;
            }


            if  (l2.next != null){
                l2 = l2.next;
            }else{
                l2 = null;
            }
        }
        return cResult.next;
    }
}
