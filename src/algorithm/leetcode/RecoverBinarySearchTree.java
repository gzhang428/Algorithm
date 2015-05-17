package algorithm.leetcode;


public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;
		new RecoverBinarySearchTree().recoverTree(n1);
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

	TreeNode prev = null;
	TreeNode first = null;
	TreeNode second = null;

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root);
		int t = first.val;
		first.val = second.val;
		second.val = t;
	}

	private void inorder(TreeNode node) {
		if (node.left != null) {
			inorder(node.left);
		}
		if (prev != null && prev.val > node.val) {
			if (first == null) {
				first = prev;
			}
			second = node;
		}
		prev = node;
		if (node.right != null) {
			inorder(node.right);
		}

	}
}
