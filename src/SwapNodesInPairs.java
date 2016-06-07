
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode l1 = head, l2 = head.next;
        ListNode pre = null, rh = l2;
        while (l1 != null && l2 != null) {
            l1.next = l2.next;
            l2.next = l1;
            if (pre != null) pre.next = l2;
            pre = l1;
            l1 = l1.next;
            if (l1 != null) l2 = l2.next.next.next;
        }
        
        return rh;
    }
}
