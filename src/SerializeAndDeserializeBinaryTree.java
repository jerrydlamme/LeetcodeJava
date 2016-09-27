import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                buffer.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                buffer.append("null,");
            }
        }
        
        return buffer.substring(0, buffer.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (vals[0].equals("null")) return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        TreeNode node = root;
        
        int k = 1;
        
        while (k < vals.length) {
            if (vals[k].equals("null")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.valueOf(vals[k]));
                queue.add(node.left);
            }
            k++;
            if (vals[k].equals("null")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.valueOf(vals[k]));
                queue.add(node.right);
            }
            k++;
            
            node = queue.poll();
        }
        
        return root;
    }
}
