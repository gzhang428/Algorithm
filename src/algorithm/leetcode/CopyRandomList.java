package algorithm.leetcode;


public class CopyRandomList {

	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(-1);
		new CopyRandomList().copyRandomList(n1);
	}

	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
		public String toString(){
			return label + "->" + next;
		}
	};

	 public RandomListNode copyRandomList(RandomListNode head) {
	        if (head == null){
	            return null;
	        }
	        RandomListNode n = head;
	        while(n != null){
	            RandomListNode n2 = new RandomListNode(n.label);
	            n2.next = n.next;
	            n.next = n2;
	            n = n2.next;
	        }
	        
	        n = head;
	        while(n != null){
	            if (n.random != null){
	                n.next.random = n.random.next;
	            }
	            n = n.next.next;
	        }
	        
	        RandomListNode head2 = head.next;
	        RandomListNode n2 = head2;
	        n = head;
	        while(n != null){
	            n.next = n2.next;
	            if (n2.next != null){
	                n2.next = n2.next.next;
	            }
	            n = n.next;
	            n2 = n2.next;
	        }        
	        return head2;
	    }

}
