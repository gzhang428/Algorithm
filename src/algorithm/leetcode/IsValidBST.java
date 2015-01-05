package algorithm.leetcode;

import java.util.Stack;

public class IsValidBST {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(Integer.MIN_VALUE);
		TreeNode n2 = new TreeNode(Integer.MAX_VALUE);
		n1.right = n2;
//		TreeNode n3 = new TreeNode(0);
//		TreeNode n4 = new TreeNode(2);
//		TreeNode n5 = new TreeNode(5);
//		TreeNode n6 = new TreeNode(4);
//		TreeNode n7 = new TreeNode(6);
//		TreeNode n8 = new TreeNode(3);
//		n1.left = n2;
//		n2.left = n3;
//		n2.right = n4;
//		n1.right = n5;
//		n5.left = n6;
//		n5.right = n7;
//		n4.right = n8;
		
		boolean res = new IsValidBST().isValidBST(n1);
		System.out.println(res);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		public String toString(){
			return String.valueOf(val);
		}
	}

	 public boolean isValidBST(TreeNode root) {
	        if (root == null){
	            return true;
	        }
	        Stack<Integer> s = new Stack<>();
	        
	        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	    }
	    
	    private boolean isValid(TreeNode root, int  leftMin, int rightMax){
	        boolean res = true;
	        if (root.left != null){
	            if (root.left.val < root.val && root.left.val > leftMin){
	                res = res && isValid(root.left, leftMin, root.val);
	            }  else {
	                return false;
	            }
	        }
	        
	        if (root.right != null){
	            if (root.right.val > root.val && root.right.val < rightMax){
	                res = res && isValid(root.right, root.val, rightMax );
	            } else {
	                return false;
	            }
	        }
	        return res;
	    }
}
