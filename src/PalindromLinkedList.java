
public class PalindromLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head, nxt, pre = null, p1, p2;
        int len = 0;
        
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (len < 2) return true; 
        
        cur = head; 
        nxt = head.next;

        for (int i = 0; i < len/2; i++) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            nxt = nxt.next;
        }
        
        p1 = pre;
        p2 = len % 2 == 0 ? cur : nxt;
        
        while (p1 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
    }
}
