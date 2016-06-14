import java.util.*;

public class BSTIterator {
    
    LinkedList<Integer> list;
    int index;

    public BSTIterator(TreeNode root) {
        list = new LinkedList<Integer>();
        index = 0;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (list != null && list.size() > 0 && index < list.size());
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }
}
