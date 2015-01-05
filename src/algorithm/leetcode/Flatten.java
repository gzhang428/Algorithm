package algorithm.leetcode;


public class Flatten {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		
		n2.left = n1;
		n2.right = n3;
		new Flatten().flatten(n2);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public String toString() {
			return String.valueOf(val);
		}
	}

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root);
	}

	private TreeNode inorderTraversal(TreeNode node) {
		TreeNode t = node.right;
		if (node.left != null) {
			node.right = inorderTraversal(node.left);
		} else {
			node.right = null;
		}
		node.left = null;
		TreeNode n = node;
		while (n.right != null) {
			n = n.right;
		}
		if (t != null) {
			n.right = inorderTraversal(t);
		}
		return node;
	}

}
