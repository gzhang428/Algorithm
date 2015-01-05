package algorithm.leetcode;

public class Partition {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(1);
		n1.next = n2;
		
		ListNode res = new Partition().partition(n1, 2);
		System.out.println(res.next.next);	
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode smallHead = new ListNode(0);
		ListNode bigHead = new ListNode(0);
		ListNode small = smallHead;
		ListNode big = bigHead;
		ListNode node = head;

		while (node != null) {
			if (node.val < x) {
				small.next = node;
				small = node;
			} else {
				big.next = node;
				big = node;
			}
			
			node = node.next;
		}
		big.next = null;
		small.next = bigHead.next;
		return smallHead.next;

	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
