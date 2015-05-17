package algorithm.leetcode;


public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		new BinaryTreeMaximumPathSum().maxPathSum(n1);
	}

	public int maxPathSum(TreeNode root) {
		maxPathWithRoot(root);
		return max;
	}

	int max = Integer.MIN_VALUE;
	private int maxPathWithRoot(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = maxPathWithRoot(node.left);
		int right = maxPathWithRoot(node.right);

		int maxPathPathWithRoot = Math.max(node.val, Math.max(left, right) + node.val);
		int arch = left + node.val + right;
		max = Math.max(max, Math.max(maxPathPathWithRoot, arch));
		return maxPathPathWithRoot;
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
}
