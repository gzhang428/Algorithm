package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MergeKLists {

	public static void main(String[] args) {
		List<ListNode> lists = new ArrayList<>();
		lists.add(new ListNode(1));
		new MergeKLists().mergeKLists(lists );
	}
	public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(k, new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;                
            }
        });
        
        for (ListNode n: lists){
            if (n != null){
                pq.add(n);
            }
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(!pq.isEmpty()){
            ListNode n = pq.remove();
            p.next = n;
            p = n;
            if (n.next != null){
                pq.add(n.next);
            }
        }
        return head.next;
        
    }
	
	public ListNode mergeKLists(List<ListNode> lists) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		while (true) {
			int min = Integer.MAX_VALUE;
			ListNode minNode = null;
			for (ListNode node : lists) {
				if (node != null) {
					if (node.val < min) {
						min = node.val;
						minNode = node;
					}
				}
			}
			if (minNode ==null) {
				break;
			}
			p.next = minNode;
			p = p.next;
			ListNode nextNode = minNode.next;
			lists.remove(minNode);
			lists.add(nextNode);
		}
		return head.next;
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
