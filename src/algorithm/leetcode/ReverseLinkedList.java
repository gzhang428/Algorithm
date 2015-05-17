package algorithm.leetcode;

public class ReverseLinkedList {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(5);
		// ListNode n3 = new ListNode(3);
		// ListNode n4 = new ListNode(4);
		// ListNode n5 = new ListNode(5);
		// ListNode n6 = new ListNode(6);

		n1.next = n2;
		// n2.next = n3;
		// n3.next = n4;
		// n4.next = n5;
		// n5.next = n6;
		ListNode res = new ReverseLinkedList().reverseBetween(n1, 1, 1);
		System.out.println(res);
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

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;

		ListNode prev = newHead;
		int i = 1;
		while (i < m) {
			prev = prev.next;
			i++;
		}
		ListNode start = prev.next;

		ListNode n1 = null;
		ListNode n2 = start;

		while (i < n) {
			ListNode n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
			i++;
		}
		start.next = n2;
		prev.next = n1;
		return newHead.next;

	}
}
