package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPoints {

	public static void main(String[] args) {
		MaxPoints mp = new MaxPoints();
		Point[] points = mp.getPoints();
		int res = mp.maxPoints(points );
		System.out.println(res);
	}

	private Point[] getPoints() {
		List<Point> list = new ArrayList<>();
		list.add(new Point(2, 3));
		list.add(new Point(3, 3));
		list.add(new Point(-5, 3));
		return list.toArray(new Point[list.size()]);
	}

	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	 
	public int maxPoints(Point[] points) {
		int n = points.length;
		if (n <= 2){
			return n;
		}

		int max = 2;
		for (int i = 0; i < n; i++){
			System.out.println("i=" + i);
			Map<Double, Integer> map = new HashMap<>();
			map.put(Double.MIN_VALUE, 1); // record number of duplicate points;
			int dedup = 0;
			for (int j = i + 1; j < n; j++){
				System.out.print("j=" + j + ", ");
				if (points[i].x == points[j].x && points[i].y == points[j].y){
					dedup ++;
					continue;
				}

				double a;
				if (points[i].x == points[j].x) {
					a = Double.MAX_VALUE;   
				} else {
					a = 0.0 + (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x); // 0.0 + x to solve -0 issue.
				}
				System.out.println("a=" + a);
				if (map.containsKey(a)){
					map.put(a, map.get(a) + 1);
				} else {
					map.put(a, 2);
				}
			}
			System.out.println(map);
			for (Map.Entry<Double, Integer> entry: map.entrySet()){
				if (entry.getValue() + dedup > max){
					max = entry.getValue() + dedup;
				}
			}

		}
		return max;
	}
}
