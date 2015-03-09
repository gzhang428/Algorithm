package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeKLists {

	public static void main(String[] args) {
		List<ListNode> lists = new ArrayList<>();
		lists.add(new ListNode(1));
		new MergeKLists().mergeKLists(lists );
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
