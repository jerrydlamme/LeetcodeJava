
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode even_head = head.next;
        
        ListNode odd = head, even = head.next, tmp;
        int n = 0;
        
        while (even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = null;
            tmp = odd;
            odd = even;
            even = tmp;
            n++;
        }
        
        if (n % 2 == 0) {
            odd.next = even_head;
        } else {
            even.next = even_head;
        }
        
        return head;
    }
}
