package algorithm.leetcode;

public class ReorderList {

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

	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		new ReorderList().reorderList(n1);
	}
	
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		ListNode fast = head;
		ListNode slow = head;

		while(fast.next != null  && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode mid = slow.next;
		slow.next = null;
		
		ListNode node = mid;
		ListNode prev = null;
		while( node != null){
			ListNode next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		
		ListNode p1 = head;
		ListNode p2 = prev;
		while(p1 != null && p2 != null){
			ListNode next1 = p1.next;
			p1.next = p2;
			p2 = p2.next;
			p1.next.next = next1;
			p1 = next1;
		}
		
	}

}
