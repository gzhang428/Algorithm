package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ClosestPair {

	public static void main(String[] args) {
		ClosestPair closestPair = new ClosestPair();
		List<Point> points = closestPair.createPoints();
		Pair pair1 = closestPair.bruteForce(points);
		System.out.println(pair1);
		Pair pair2 = closestPair.divideAndConque(points);
		System.out.println(pair2);
	}

	private List<Point> createPoints() {
		List<Point> points = new ArrayList<Point>();
		Random r = new Random();
		for (int i = 0; i < 100000; i ++){
			points.add(new Point(r.nextInt(), r.nextInt()));
		}
		return points;
	}

	private Pair divideAndConque(List<Point> points) {
		List<Point> xSortedPoints = new ArrayList<Point>(points);
		Collections.sort(xSortedPoints, new PointComparator("x"));
		List<Point> ySortedPoints = new ArrayList<Point>(points);
		Collections.sort(ySortedPoints, new PointComparator("y"));
		return findClosestPair(xSortedPoints, ySortedPoints);
	}

	private Pair findClosestPair(List<Point> xSortedPoints, List<Point> ySortedPoints) {
		if (xSortedPoints.size() == 1){
			Pair pair = new Pair(null, null);
			pair.updateDistance();
			return pair;
		} else if (xSortedPoints.size() == 2){
			Pair pair = new Pair( xSortedPoints.get(0),  xSortedPoints.get(1));
			pair.updateDistance();
			return pair;
		} else {
			int mid = xSortedPoints.size() / 2;
			List<Point> xSortedLeft = xSortedPoints.subList(0, mid);
			List<Point> xSortedRight = xSortedPoints.subList(mid, xSortedPoints.size());
			List<Point> ySortedLeft = getYSortedHalf(ySortedPoints, xSortedLeft);
			List<Point> ySortedRight = getYSortedHalf(ySortedPoints, xSortedRight);
			
			double xCenter = (xSortedLeft.get(xSortedLeft.size() - 1).x + xSortedRight.get(0).x) / 2;
			Pair left = findClosestPair(xSortedLeft, ySortedLeft);
			Pair right = findClosestPair(xSortedRight, ySortedRight);
			double delta;
			Pair pair;
			if (left.distance <= right.distance){
				pair = left;
				delta = left.distance;
			} else {
				pair = right;
				delta = right.distance;
			}
			Pair split = findSplitClosestPair(ySortedPoints, xCenter, delta);
			if (split == null){
				return pair;
			} else{
				return split;
			}
		}
	}

	private Pair findSplitClosestPair(List<Point> ySortedPoints, double xCenter, double delta) {
		double min = delta;
		Pair pair = null;
		List<Point> ySortedStrip = new ArrayList<Point>();
		for (Point p: ySortedPoints){
			if (p.x > xCenter - delta && p.x < xCenter + delta){
				ySortedStrip.add(p);
			}
		}
		for (int i = 0; i < ySortedStrip.size(); i++){
			Point p1 = ySortedStrip.get(i);
			int checkedPoints = 0;
			for (int j = i + 1; j < Math.min(i + 8, ySortedStrip.size()); j++){
				Point p2 = ySortedStrip.get(j);
				if (p2.y < p1.y + delta && (p1.x < xCenter && p2.x > xCenter) || (p1.x > xCenter && p2.x < xCenter)){
					double distance = getDistance(p1, p2);
					if (distance < min){
						min = distance;
						pair = new Pair(p1, p2);
						pair.distance = distance;
					}
					checkedPoints++;
					if (checkedPoints == 4){
						break;
					}
				}
			}
		}
		return pair;
	}


	private List<Point> getYSortedHalf(List<Point> ySortedPoints, List<Point> xSortedLeft) {
		List<Point> res = new ArrayList<Point>();
		Set<Point> xHalfSet = new HashSet<Point>(xSortedLeft);
		for (Point p: ySortedPoints){
			if (xHalfSet.contains(p)){
				res.add(p);
			}
		}
		return res;
	}

	public Pair bruteForce(List<Point> points) {
		double min = Double.MAX_VALUE;
		Pair pair = null;
		for (int i = 0; i < points.size() - 1; i++){
			Point start = points.get(i);
			for (int j = i + 1; j < points.size(); j++ ){
				Point end = points.get(j);
				double distance = getDistance(start, end);
				if (distance < min){
					min = distance;
					pair= new Pair(start, end);
					pair.distance = distance;
				}
			}
		}
		return pair;
	}

	
	private double getDistance(Point start, Point end) {
		return Math.sqrt((start.x - end.x) * (start.x - end.x) + (start.y - end.y) * (start.y - end.y));
	}
	
	public class Pair {
		public Point start;
		public Point end;
		public double distance;
		
		
		public Pair(Point start, Point end){
			this.start = start;
			this.end = end;
		}
		
		public void updateDistance(){
			if (start == null || end == null){
				distance = Double.MAX_VALUE;
			} else {
				distance =  Math.sqrt((start.x - end.x) * (start.x - end.x) + (start.y - end.y) * (start.y - end.y));
			}
		}

		public String toString(){
			return String.format("start=%s end=%s distance=%f", start, end, distance);
		}
	}
	
	public class Point {
		public double x;
		public double y;
		
		public Point(double x, double y){
			this.x = x;
			this.y = y;
		}
		
		public String toString(){
			return String.format("(x=%f, y=%f)", x, y);
		}
	}
	
	

	public class PointComparator implements Comparator<Point> {
		String sortDimension;

		public PointComparator(String sortDimension) {
			this.sortDimension = sortDimension;
		}

		@Override
		public int compare(Point p0, Point p1) {
			if (sortDimension.equals("x")){
				return (int) Math.signum(p0.x - p1.x);
			} else {
				return (int) Math.signum(p0.y - p1.y);
			}
		}

	}
}
