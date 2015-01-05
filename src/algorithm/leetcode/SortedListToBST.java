package algorithm.leetcode;

public class SortedListToBST {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(8);
		n1.next = n2;
		n2.next = n3;
		new SortedListToBST().sortedListToBST(n1);
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

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		public String toString() {
			return "" + val;
		}
	}
	private ListNode node;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode p = head;
		int n = 0;
		while (p != null) {
 			p = p.next;
			n++;
		}
		node = head;
		return build(0, n - 1);

	}

	private TreeNode build( int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode left = build(start, mid - 1);
		TreeNode parent = new TreeNode(node.val);
		parent.left = left;
		node = node.next;
		parent.right = build( mid + 1, end);
		return parent;
	}
}
