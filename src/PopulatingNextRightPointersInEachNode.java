
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        TreeLinkNode head = root, nextHead = null;
        TreeLinkNode cur, child = null;
        while (head != null) {
            cur = head;
            while (cur != null) {
                if (cur.left != null) {
                    if (child == null) {
                        child = cur.left;
                        nextHead = child;
                    } else {
                        child.next = cur.left;
                        child = child.next;
                    }
                }
                
                if (cur.right != null) {
                    if (child == null) {
                        child = cur.right;
                        nextHead = child;
                    } else {
                        child.next = cur.right;
                        child = child.next;
                    }
                }
                
                cur = cur.next;
            }
            
            head = nextHead;
            child = null;
            nextHead = null;
        }
    }
}
