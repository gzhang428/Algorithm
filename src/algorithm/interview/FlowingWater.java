package algorithm.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlowingWater {

	public static void main(String[] args) {
		int[][] m = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}; 
		List<Point> res = new FlowingWater().findPoints(m );
		System.out.println(res);
	}
	
	List<Point> findPoints(int[][] m){
		List<Point> res= new ArrayList<>();
		int n = m.length;
		
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited1 = new boolean[n][n];
		for(int i = 0; i < n; i++){
			q.add(new Point(i, 0));
		}
		for (int i = 1; i < n; i++){
			q.add(new Point(0, i));
		}
		while(!q.isEmpty()){
			Point p = q.remove();
			visited1[p.x][p.y] = true;
			if (p.x + 1 < n && !visited1[p.x + 1][p.y] && m[p.x + 1][p.y] >= m[p.x][p.y]){
				q.add(new Point(p.x + 1, p.y));
			}
			if (p.y + 1 < n && !visited1[p.x][p.y + 1] && m[p.x][p.y + 1] >= m[p.x][p.y]){
				q.add(new Point(p.x, p.y + 1));
			}
		}
		q.clear();
		boolean[][] visited2 = new boolean[n][n];
		for (int i = 0; i < n; i++){
			q.add(new Point(i, n - 1));
		}
		for (int i = 0; i < n - 1; i++){
			q.add(new Point(n - 1, i));
		}
		while(!q.isEmpty()){
			Point p = q.remove();
			visited2[p.x][p.y] = true;
			if (p.x > 0 && !visited2[p.x - 1][p.y] && m[p.x - 1][p.y] >= m[p.x][p.y]){
				q.add(new Point(p.x - 1, p.y));
			}
			if (p.y > 0 && !visited2[p.x][p.y - 1] && m[p.x][p.y - 1] >= m[p.x][p.y]){
				q.add(new Point(p.x, p.y - 1));
			}
		}
	
		for (int i = 0;  i < n; i ++){
			for (int j = 0; j < n; j++){
				if (visited1[i][j] && visited2[i][j]){
					res.add(new Point(i, j));
				}
			}
		}
		return res;
	}


	private class Point{
		int x;
		int y;
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public String toString(){
			return x + ":" + y;
		}
	}
}
