package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class CourseSchedule {

	public static void main(String[] args) {
		int[][] prerequisites = {{1, 0}, {2, 1}};
		boolean res = new CourseSchedule().canFinish(3, prerequisites );
		System.out.println(res);
	}	
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        List<Set<Integer>> indegrees = new ArrayList<>();
	        for (int i = 0; i < numCourses; i++){
	            indegrees.add(new HashSet<Integer>());
	        }
	        Queue<Integer> q = new LinkedList<>();
	    
	        
	        for (int[] edge: prerequisites){
	            int start = edge[0];
	            int end = edge[1];
	            indegrees.get(end).add(start);
	        }
	        
	        for (int i = 0; i < numCourses; i++){
	            if (indegrees.get(i).isEmpty()){
	                q.add(i);
	            }
	        }
	        while(!q.isEmpty()){
	            int index = q.remove();
	            for (int i = 0; i < numCourses; i++){
	                Set<Integer> indegree = indegrees.get(i);
	                if (indegree.contains(index)){
	                    indegree.remove(index);
	                    if (indegree.isEmpty()){
		                    q.add(i);
		                }
	                }
	              
	            }
	        }
	        
	        for (Set<Integer> indegree: indegrees){
	            if (!indegree.isEmpty()){
	                return false;
	            }
	        }
	        return true;
	    }
}
