package algorithm.interview;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	
	private Queue<Integer> q;
	private int n;
	private double average;
	
	public static void main(String[] args){
		MovingAverage m = new MovingAverage(5);
		m.add(1);
		System.out.println(m.getAverage());
		m.add(2);
		System.out.println(m.getAverage());
		m.add(3);
		System.out.println(m.getAverage());
		m.add(4);
		System.out.println(m.getAverage());
		m.add(5);
		System.out.println(m.getAverage());
		m.add(6);
		System.out.println(m.getAverage());
		m.add(7);
		System.out.println(m.getAverage());
	}
	
	public MovingAverage(int n){
		this.n = n;
		q  = new LinkedList<>();
	}
	
	public void add(int x){
		if (q.size() == n){
			int t = q.remove();
			q.add(x);
			average = average - t / n + x / n;
			
		} else {
			q.add(x);
			average = average / q.size() * (q.size() - 1) + x / q.size();
		}
	}
	
	public double getAverage(){
		if (q.size() < n){
			throw new RuntimeException();
		}
		return average;
	}

}
