package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;


public class PathSum {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		new PathSum().pathSum(n1, 1);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		pathSum(root, sum, list, res);
		return res;
	}

	private void pathSum(TreeNode node, int sum, List<Integer> list,
			List<List<Integer>> res) {
		if (node == null) {
			return;
		}

		sum -= node.val;
		if (sum == 0 && node.left == null && node.right == null) {
			list.add(node.val);
			res.add(new ArrayList<Integer>(list));
			list.remove(list.size() - 1);
			return;
		}
		list.add(node.val);
		pathSum(node.left, sum, list, res);
		pathSum(node.right, sum, list, res);
		list.remove(list.size() - 1);
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
