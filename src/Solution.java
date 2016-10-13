
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode {
	int val;
	int afterMe;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) { val = x; }
	
	
    public TreeNode(int val, int afterMe) {
        this.val = val;
        this.afterMe = afterMe;
        this.left = null;
        this.right = null;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}