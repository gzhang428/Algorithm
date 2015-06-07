package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Skyline {

	public static void main(String[] args) {
		int[][] buildings = { {0,2,3}, {2, 5, 3}} ;
		List<int[]> res = new Skyline().getSkyline(buildings );
		for (int[] point: res){
			System.out.println(Arrays.toString(point));
		}
		
	}

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new ArrayList<>();
		List<Node> nodes = new ArrayList<>();
		for (int[] building: buildings){
			Node n1 = new Node(building[0], building[2], true);
			Node n2 = new Node(building[1], building[2], false);
			nodes.add(n1);
			nodes.add(n2);
		}

		Collections.sort(nodes, new Comparator<Node>(){

			@Override
			public int compare(Node n1, Node n2) {
				if (n1.x != n2.x){
					return n1.x - n2.x;
				}
				if (n1.left != n2.left){
					return n1.left? -1 : 1;
				}
				if (n1.left && n2.left){
					return n2.y - n1.y;
				}
				if (!n1.left && !n2.left){
					return n1.y - n2.y;
				}
				return 0;
			}
			
		});
		
		System.out.println(nodes);
		PriorityQueue<Integer> pq = new PriorityQueue<>(20000, Collections.reverseOrder());
		for (Node node: nodes){
			if (node.left){
				if (pq.isEmpty() || node.y > pq.peek()){
					int[] point = new int[2];
					point[0] = node.x;
					point[1] = node.y;
					res.add(point);
				}
				pq.add(node.y);
			} else {
				pq.remove(Integer.valueOf(node.y));
				if (pq.isEmpty()){
					int[] point = new int[2];
					point[0] = node.x;
					point[1] = 0;
					res.add(point);
				} else if (node.y > pq.peek()) {
					int[] point = new int[2];
					point[0] = node.x;
					point[1] = pq.peek();
					res.add(point);
				}
			}
		}
		System.out.println(res);
		
		return res;
	}
	
	private class Node{
		int x;
		int y;
		boolean left;
		
		public Node(int x, int y, boolean left){
			this.x = x;
			this.y = y;
			this.left = left;
		}
		
		public String toString(){
			return x + "," + y + "," + (left? "left": "right");
		}
	}
}
