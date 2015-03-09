package algorithm.leetcode;


public class ReverseKGroup {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
	
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
		ListNode res = new ReverseKGroup().reverseKGroup(n1, 2);
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
        if (head == null || head.next == null || k == 1){
            return head;
        }
       
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode n0 = helper;
        ListNode start = head;
        ListNode end = head;
        int i = 1;
        while (end != null && end.next != null){
        	end = end.next;
        	i ++;
        	if (i == k){
        		i = 1;
        		n0.next = end;
        		ListNode np = end.next;
        		ListNode ns = start;
        		while(np != end){
        			ListNode n2 = ns.next;
        			ns.next = np;
        			np = ns;
        			ns = n2;
        		}
        		end = start.next;
        		n0 = start;
        		start = start.next;
        	}
        }
        
        return helper.next;
        
        
    }

}
