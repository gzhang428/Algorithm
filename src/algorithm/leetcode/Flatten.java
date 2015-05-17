package algorithm.leetcode;

import java.util.Stack;

public class Flatten {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		n1.left = n2;
		n2.left = n3;
		n2.right = n4;
		n1.right = n5;
		n5.right = n6;
		new Flatten().flatten(n1);
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
		Stack<TreeNode> s = new Stack<>();
		TreeNode node = root;
		TreeNode right = null;
		TreeNode head = null;
		TreeNode prev = null;
		while(node != null || !s.isEmpty()){
			if (node != null){
				s.push(node);
				node = node.left;
			} else {
				TreeNode peek = s.peek();
				if (head == null){
					head = peek;
				}
				if (peek.right != null && peek.right != right){
					node = peek.right;
				} else {
					right = peek;
					s.pop();
					if (prev != null){
						prev.left = null;
						prev.right = peek;
					}
					prev = peek;
				}
				
			}
			
		}
		root = head;
	
	}
}
