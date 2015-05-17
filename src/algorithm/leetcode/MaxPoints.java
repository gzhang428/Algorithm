package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPoints {

	public static void main(String[] args) {
		MaxPoints mp = new MaxPoints();
		Point[] points = mp.getPoints();
		int res = mp.maxPoints(points);
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

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
		
		public String toString(){
			return x + ":" + y;
		}
	}

	public int maxPoints(Point[] points) {
		int n = points.length;
		if (n <= 2) {
			return n;
		}
		int res = 0;
		for (int i = 0; i < n - 1; i++) {
			Point p1 = points[i];
			int duplicate = 0;
			Map<Double, Integer> count = new HashMap<>();
			for (int j = i + 1; j < n; j++) {
				Point p2 = points[j];
				if (p1.x == p2.x && p1.y == p2.y) {
					if (duplicate == 0) {
						duplicate = 2;
					} else {
						duplicate++;
					}
					continue;
				}
				double a = Double.MAX_VALUE;
				if (p1.x != p2.x) {
					a = (double) (p1.y - p2.y) /(double) (p1.x - p2.x);
				}
				if (count.containsKey(a)) {
					count.put(a, count.get(a) + 1);
				} else {
					count.put(a, 2);
				}
			}
			int max = duplicate;
			for (Map.Entry<Double, Integer> entry : count.entrySet()) {
				int val = entry.getValue();
				if (duplicate != 0) {
					val = val + duplicate - 1;
				}
				max = Math.max(max, val);
			}
			res = Math.max(res, max);
		}
		return res;
	}
}
