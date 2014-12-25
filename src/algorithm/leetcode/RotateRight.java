package algorithm.leetcode;

public class RotateRight {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode res = new RotateRight().rotateRight(head , 1);
		System.out.println(res);
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode node = head;
		int length = 1;
		while (node.next != null) {
			node = node.next;
			length++;
		}

		n = n % length;
		if (n == 0) {
			return head;
		}
		node = head;
		for (int i = 1; i < n; i++) {
			node = node.next;
		}

		ListNode prev = null;
		while (node.next != null) {
			prev = node;
			node = node.next;
		}

		node.next = head;
		head = prev.next;
		prev.next = null;

		return head;

	}
}
