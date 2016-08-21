
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode init = new ListNode(0);
        ListNode cur = head, pre = init;
        
        while (cur != null) {
            if (cur.val != val) {
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        
        pre.next = null;
        
        return init.next;
    }
}
