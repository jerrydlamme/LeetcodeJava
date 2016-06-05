
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        /*
        if (head == null) return null;
        
        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        
        return pre;
        */
        
        if (head == null || head.next == null) return head;
        
        ListNode second = head.next;
        ListNode rest = reverseList(second);
        second.next = head;
        head.next = null;
        return rest;
    }
}
