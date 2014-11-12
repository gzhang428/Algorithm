package algorithm.leetcode;




public class AddTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args){
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		new AddTwoNumbers().addTwoNumbers(l1, l2);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode head = node;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int x = l1.val + l2.val + carry;
			if (x > 9) {
				x = x - 10;
				carry = 1;
			} else {
				carry = 0;
			}
			node.next = new ListNode(x);
			node = node.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int x = l1.val + carry;
			if (x > 9) {
				x = x - 10;
				carry = 1;
			} else {
				carry = 0;
			}
			node.next = new ListNode(x);
			node = node.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			int x = l2.val + carry;
			if (x > 9) {
				x = x - 10;
				carry = 1;
			} else {
				carry = 0;
			}
			node.next = new ListNode(x);
			node = node.next;
			l2 = l2.next;
		}

		
		return head.next;
	}
}