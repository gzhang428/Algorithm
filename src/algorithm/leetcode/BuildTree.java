package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

	public static void main(String[] args) {
		int[] p = { 1, 2 };
		int[] i = { 2, 1};

		new BuildTree().buildTree(p, i);
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

	 public TreeNode buildTree(int[] preorder, int[] inorder) {
	        Map<Integer, Integer> inorderPos = new HashMap<>();
	        for (int i = 0; i < inorder.length; i++){
	            inorderPos.put(inorder[i], i);
	        }
	        
	        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderPos);
	    }
	    
	    private TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2, Map<Integer, Integer> inorderPos){
	        int n = r1 - l1 + 1;
	        if (n <= 0){
	            return null;
	        }
	        TreeNode node = new TreeNode(preorder[l1]);
	        int p = inorderPos.get(node.val);
	        int leftSize = p - 1 - l2 + 1;
	        node.left = build(preorder, l1 +1, l1 + leftSize, inorder, l2, p - 1, inorderPos);
	        node.right = build(preorder, l1 + leftSize + 1, r1, inorder, p + 1, r2, inorderPos);
	        return node;
	        
	    }
}
