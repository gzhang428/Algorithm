package algorithm.leetcode;

public class ReverseBetween {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		new ReverseBetween().reverseBetween(n1, 1, 3);
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
		
		public String toString(){
			return "" + val;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n){
			return head;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode prev = newHead;

		for (int i = 1; i < m; i++) {
			prev = prev.next;
		}
		ListNode start = prev.next;
		ListNode end = start;
		for (int i = m + 1; i <= n; i++) {
			end = end.next;
		}


		if (n - m == 1) {
			prev.next = end;
			start.next = end.next;
			end.next = start;
			return newHead.next;
		}

		ListNode n0 = start;
		ListNode n1 = n0.next;
		ListNode n2 = n1.next;
		ListNode nodeAfterEnd = end.next;
		for (int i = m; i <= n - 1; i++) {
			n1.next = n0;
			n0 = n1;
			n1 = n2;
			n2 = n2 == null? null: n2.next;

		}
		prev.next = end;
		start.next = nodeAfterEnd;
		return newHead.next;

	}
}
