package algorithm.leetcode;

public class InsertionSortList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(1);
//		ListNode n3 = new ListNode(2);
//		ListNode n4 = new ListNode(1);
//		ListNode n5 = new ListNode(5);

		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
		new InsertionSortList().test();

	}

	private void test() {
		String s = "0";
		String[] str = s.split("\\.");
		System.out.println(str.length);
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

	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode prev = head;
		ListNode node = head.next;
		boolean swapped = false;
		while (node != null) {
			int v = node.val;
			ListNode p = newHead;
			ListNode n = p.next;
			
			while(n != node){
				if (v < n.val){
					prev.next = node.next;
					node.next = n;
					p.next = node;
					
					node = prev.next;
					swapped = true;
					break;
				}
			
				p = n;
				n = n.next;
			}
			if (swapped){
				swapped = false;
				continue;
			}
			prev = node;
			node = node.next;
		}
		
		
		return newHead.next;
	}
	
	
	
    
    
}
