import java.util.*;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<String>();
        
        if (root == null) return list;
        
        sub(list, root, null);
        
        return list;
    }
    
    public void sub(List<String> list, TreeNode node, List<Integer> pmask) {
        List<Integer> mask = new LinkedList<Integer>();
        if (pmask != null) mask.addAll(pmask);
        mask.add(node.val);
        
        if (node.left != null) sub(list, node.left, new LinkedList<Integer>(mask)); 
        if (node.right != null) sub(list, node.right, new LinkedList<Integer>(mask));
        
        if (node.left == null && node.right == null) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < mask.size(); i++) {
                buffer.append(mask.get(i));
                if (i != mask.size()-1) buffer.append("->");
            }
            list.add(buffer.toString());
        }
    }
}
