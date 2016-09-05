import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, cur = null;
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(11, new Comp());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (cur == null && head == null) {
                cur = node;
                head = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
            
            if (node.next != null) heap.add(node.next); 
        }
        
        return head;
    }
    
    class Comp implements Comparator<ListNode> {
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    }
}
