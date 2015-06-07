package algorithm.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class CourseSchedule2 {

	public static void main(String[] args) {
		int[][] prerequisites = {{1, 0},{2, 0},{3, 1},{3, 2}};
		new CourseSchedule2().findOrder(4, prerequisites );
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < numCourses; i++){
            nodes[i] = new Node(i);
        }
        
        for (int[] edge: prerequisites){
            int start = edge[1];
            int end = edge[0];
            nodes[end].inwards.add(start);
        }
        
        for (Node node: nodes){
            pq.add(node);
        }
        
        int[] res = new int[numCourses];
        int i = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if (node.inwards.isEmpty()){
                res[i++] = node.val;
                for (Node other: nodes){
                    if (other.inwards.contains(node.val)){
                        other.inwards.remove(node.val);
                        pq.remove(other);
                        pq.add(other);
                    }
                }
            } else {
                return new int[0];
            }
        }        

        return res;
        
    }
    
   
    
    class Node implements Comparable<Node> {
        int val;
        Set<Integer> inwards;
        
        Node(int val){
            this.val = val;
            inwards = new HashSet<>();
        }
        
        public String toString(){
        	return String.valueOf(val);
        }
        
        public int compareTo(Node other){
            return inwards.size() - other.inwards.size();
        }
    }
}
