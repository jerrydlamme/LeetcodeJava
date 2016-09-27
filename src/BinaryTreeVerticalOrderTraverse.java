import java.util.*;

public class BinaryTreeVerticalOrderTraverse {
    int left = 0;
    int right = 0;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (root == null) return lists;
        
        preorder(root, 0);
        int n = right - left + 1;
        for (int i = 0; i < n; i++) {
            lists.add(new LinkedList<Integer>());
        }
        
        Queue<Wrapper> queue = new LinkedList<Wrapper>();
        queue.add(new Wrapper(root, 0 - left));
        
        while (!queue.isEmpty()) {
            Wrapper cur = queue.poll();
            lists.get(cur.index).add(cur.node.val);
            
            if (cur.node.left != null) {
                queue.add(new Wrapper(cur.node.left, cur.index-1));
            }
            
            if (cur.node.right != null) {
                queue.add(new Wrapper(cur.node.right, cur.index+1));
            }
        }
        
        return lists;
    }
    
    void preorder(TreeNode node, int last) {
        left = last < left ? last : left;
        right = last > right ? last : right;
        
        if (node.left != null) preorder(node.left, last-1);
        if (node.right != null) preorder(node.right, last+1);
    }
    
    class Wrapper {
        TreeNode node;
        int index;
        
        public Wrapper(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
