package algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TSP {
	private Combination<Integer> conbination = new Combination<>();

	public static void main(String[] args) {
		TSP tsp = new TSP();
		Point[] points = tsp.readPoints("D:/tsp.txt"); 
		double res = tsp.find(points);
		System.out.println(res);
	}

	private double find(Point[] points) {
		int n = points.length;
		float[][] distances = getDistances(points);
		float[][] a = new float[(int) Math.pow(2, n)][n];
		System.out.println("memory allocated");
		
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < n; j++){
				a[i][j] = Float.MAX_VALUE;
			}
		}
		a[1][0] = 0;
		
		for (int i = 2; i <= n; i++){
			System.out.println(i);
			for (Set<Integer> pointSet: getPointSetsWithSize(n, i)){
				int index = convertSetToIndex(pointSet);
				for (Iterator<Integer> it1 = pointSet.iterator(); it1.hasNext(); ){
					int j = it1.next();
					if (j != 0){
						int prevIndex = index & ~(1 << j); // set j position to 0;
						float min = Float.MAX_VALUE;
						for (Iterator<Integer> it2 = pointSet.iterator(); it2.hasNext();){
							int k = it2.next();
							if (k != j){
								float dist = sum(a[prevIndex][k], distances[k][j]);
								if (dist < min){
									min = dist;
								}
							}
						}
						a[index][j] = min;
					}
				}
			}
		}
		
		float min = Float.MAX_VALUE;
		for (int j = 1; j < n; j++){
			float dist = sum(a[a.length - 1][j], distances[j][0]);
			if (dist < min){
				min = dist;
			}
		}
		return min;
	}

	private float[][] getDistances(Point[] points) {
		int n = points.length;
		float[][] dist = new float[n][n];
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				dist[i][j] = getDistance(points[i], points[j]);
			}
		}
		return dist;
 	}
	
	private float getDistance(Point point1, Point point2) {
		return (float) Math.sqrt((point1.x - point2.x) * (point1.x - point2.x) + (point1.y - point2.y) * (point1.y - point2.y) );
	}
	
	private float sum(float a, float d) {
		if (a == Float.MAX_VALUE || d == Float.MAX_VALUE){
			return Float.MAX_VALUE;
		} else {
			return a + d;
		}
	}

	private int convertSetToIndex(Set<Integer> pointSet) {
		int res = 0;
		for (int i: pointSet){
			res = res | 1 << i;
		}
		return res;
	}

	private List<Set<Integer>> getPointSetsWithSize(int n, int size) {
		Integer[] pointsFromSecond = new Integer[n - 1];
		for (int i = 1; i <n; i++){
			pointsFromSecond[i - 1] = i;
		}
		List<Set<Integer>> sets = conbination.find(pointsFromSecond, size - 1);
		for (Set<Integer> set: sets){
			set.add(0);
		}
		return sets;
		
	}

	private Point[] readPoints(String file) {
		Point[] points = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			points = new Point[Integer.parseInt(line)];
			int i = 0;
			while((line = br.readLine()) != null){
				String[] pair = line.split(" ");
				float x = Float.parseFloat(pair[0]);
				float y = Float.parseFloat(pair[1]);
				Point p = new Point(i, x, y);
				points[i] = p;
				i ++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return points;
	}

	

	public class Point {
		public int index;
		public float x;
		public float y;
		
		public Point(int index, float x, float y){
			this.index = index;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [index=" + index + "]";
		}

	}
}
