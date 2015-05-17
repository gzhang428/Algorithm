package algorithm.leetcode;


public class ReverseKGroup {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
	
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode res = new ReverseKGroup().reverseKGroup(n1, 1);
		System.out.println(res);
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
		
		public String toString(){
			return val + "->" + next;
		}
	}
	
	 public ListNode reverseKGroup(ListNode head, int k) {
	        if (head == null){
	            return null;
	        }
	        ListNode newHead = new ListNode(0);
	        newHead.next = head;
	        
	        ListNode prev = newHead;
	        while(true){
	            ListNode n0 = prev.next;
	            ListNode n1 = prev.next;
	            for (int i = 1; i <= k; i++){
	                if (n1 == null){
	                    return newHead.next;
	                }
	                n1 = n1.next;
	            }
	            
	            ListNode n2 = n1;
	            ListNode n3 = prev.next;
	            while(n3 != n1){
	                ListNode n4 = n3.next;
	                n3.next = n2;
	                n2 = n3;
	                n3 = n4;
	            }
	            prev.next = n2;
	            prev = n0;
	            
	        }
	    }
}
