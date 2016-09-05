
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        int sig = rec(head);
        if (sig != 0) {
            ListNode pre = new ListNode(sig);
            pre.next = head;
            head = pre;
        }
        
        return head;
    }
    
    int rec(ListNode node) {
        if (node.next == null) {
            node.val++;
        } else {
            node.val += rec(node.next);
        }
        
        int carry = node.val / 10;
        node.val %= 10;
        
        return carry;
    }
}
