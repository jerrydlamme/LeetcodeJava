import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        
        if (root == null) return lists;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        int count = 0, cur = 1;
        List<Integer> list = new LinkedList<Integer>();
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.pop();
            list.add(node.val);
            cur--;
            
            if (node.left != null) {
                queue.add(node.left);
                count++;
            }
            if (node.right != null) {
                queue.add(node.right);
                count++;
            }
            
            if (cur == 0) {
                lists.add(list);
                list = new LinkedList<Integer>();
                cur = count;
                count = 0;
            }
        }
        
        return lists;
    }
}
