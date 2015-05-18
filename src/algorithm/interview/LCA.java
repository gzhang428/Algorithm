package algorithm.interview;


public class LCA {
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
		TreeNode n5 = new TreeNode(5);
		
		n1.left = n2;
		n1.right = n4;
		n2.right = n3;
		n2.left = n5;
		
		TreeNode res = new LCA().findLCA(n1, n5, n3);
		System.out.println(res);
	}

	private TreeNode findLCA(TreeNode node, TreeNode n1, TreeNode n2) {
		if (node == null || n1 == null || n2 == null){
			return null;
		}
		if (node == n1 || node == n2){
			return node;
		}
		
		TreeNode left = findLCA(node.left, n1, n2);
		TreeNode right = findLCA(node.right, n1, n2);
		if (left != null && right != null){
			return node;
		}
		if (left != null){
			return left;
		}
		return right;
		
	}
}
