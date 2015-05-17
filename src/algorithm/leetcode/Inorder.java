package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Inorder {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;

		List<Integer> res = new Inorder().inorderTraversal(n1);
		System.out.println(res);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode node = root;
		TreeNode prev = null;

		while (node != null || !s.isEmpty()) {
			if (node != null) {
				s.push(node);
				node = node.left;
			} else {
				TreeNode peek = s.peek();
				if (peek.right != null && prev != peek.right) {
					node = peek.right;
				} else {
					s.pop();
					res.add(peek.val);
					prev = peek;
				}
			}

		}
		return res;

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
