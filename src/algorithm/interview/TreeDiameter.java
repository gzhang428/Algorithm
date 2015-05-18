package algorithm.interview;


public class TreeDiameter {
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

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		
		n1.left = n2;
		n1.right = n4;
		n2.right = n3;
		
		int res = new TreeDiameter().getDiameter(n1);
		System.out.println(res);
	}

	private int getDiameter(TreeNode root) {
		int[] res = helper(root);
		return res[0];
	}

	private int[] helper(TreeNode node) {
		int[] res = new int[2];
		if (node == null){
			return res;
		}
		
		int[] left = helper(node.left);
		int[] right = helper(node.right);
		int height = Math.max(left[1], right[1]) + 1;
		int diameter = Math.max(left[0], Math.max(right[0], left[1] + right[1] + 1));
		res[0] = diameter;
		res[1] = height;
		return res;
	}
}