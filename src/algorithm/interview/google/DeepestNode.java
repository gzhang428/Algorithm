package algorithm.interview.google;

public class DeepestNode {

	public class Result {
		TreeNode node;
		int depth;
		public Result(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
		
		public String toString(){
			return node + ":" + depth;
		}
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

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		
		n1.left = n2;
		n1.right = n4;
		n2.right = n3;
	
		new DeepestNode().getDeepest(n1);
	}

	public TreeNode getDeepest(TreeNode root) {
		Result res = getDeepestNode(root);
		return res.node;
		
	}
	
	private Result getDeepestNode(TreeNode node) {
		if (node == null){
			return new Result(null, 0);
		}
		if (node.left == null && node.right == null){
			return new Result(node, 1);
		}
		Result left = getDeepestNode(node.left);
		Result right = getDeepestNode(node.right);
		
		
		if (left.depth > right.depth){
			return new Result(left.node, left.depth + 1);
		} else{
			return new Result(right.node, right.depth + 1);
		}
		
	}
	

	private TreeNode getDeepest(TreeNode node, int level, int height) {
		if (level == height){
			return node;
		}
		if (node != null){
			TreeNode left = getDeepest(node.left, level + 1, height);
			if (left != null){
				return left;
			}
			TreeNode right = getDeepest(node.right, level + 1, height);
			if (right != null){
				return right;
			}
		}
		return null;
	}

	private int getHeight(TreeNode node) {
		if (node == null){
			return 0;
		}
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}
	
	

}
