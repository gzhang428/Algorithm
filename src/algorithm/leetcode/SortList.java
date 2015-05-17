package algorithm.leetcode;


public class SortList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(1);
		n1.next = n2;
		new SortList().sortList(n1);
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
	
	 public ListNode sortList(ListNode head) {
	        if (head == null || head.next == null){
	            return head;
	        }
	        ListNode n1 = head;
	        ListNode n2 = head;
	        
	        while(n1 != null && n1.next != null){
	            n1 = n1.next.next;
	            n2 = n2.next;
	        }
	        ListNode head2 = n2.next;
	        n2.next = null;
	        ListNode left = sortList(head);
	        ListNode right = sortList(head2);
	        return merge(left, right);
	    }
	    
	    private ListNode merge(ListNode l1, ListNode l2){
	        ListNode newHead = new ListNode(0);
	        ListNode l = newHead;
	        while(l1 != null && l2 != null){
	            if (l1.val <= l2.val){
	                l.next = l1;
	                l = l.next;
	                l1 = l1.next;
	            } else {
	                l.next = l2;
	                l = l.next;
	                l2 = l2.next;
	            }
	        }
	        while(l1 != null){
	            l.next = l1;
	            l = l.next;
	            l1 = l1.next;
	        }
	        while(l2 != null){
	            l2.next = l2;
	            l = l.next;
	            l2 = l2.next;
	        }
	        return newHead.next;
	        
	    }
}
