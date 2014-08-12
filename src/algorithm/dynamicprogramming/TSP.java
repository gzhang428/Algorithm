package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import algorithm.Combination;

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
		
		return 0;
	
	}

	private double getDistance(Point point1, Point point2) {
		return Math.sqrt((point1.x - point2.x) * (point1.x - point2.x) + (point1.y - point2.y) * (point1.y - point2.y) );
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
				double x = Double.parseDouble(pair[0]);
				double y = Double.parseDouble(pair[1]);
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
		public double x;
		public double y;
		
		public Point(int index, double x, double y){
			this.index = index;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [index=" + index + "]";
		}

	}
	
	private double sum(double a, double d) {
		if (a == Double.MAX_VALUE || d == Double.MAX_VALUE){
			return Double.MAX_VALUE;
		} else {
			return a + d;
		}
	}

}
