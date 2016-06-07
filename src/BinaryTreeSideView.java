import java.util.*;
public class BinaryTreeSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if (root == null) return list;
        
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        int cur = 1, next = 0;
        q.add(root);
        
        while(q.size() != 0) {
            TreeNode node = q.pop();
            cur--;
            if (node.left != null) {
                q.add(node.left);
                next++;
            }
            
            if (node.right != null) {
                q.add(node.right);
                next++;
            }
            
            if (cur == 0) {
                list.add(node.val);
                cur = next;
                next = 0;
            }
        }
        
        return list;
    }
}
