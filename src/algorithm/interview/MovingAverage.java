package algorithm.interview;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	
	Queue<Integer> q;
	private int size;
	private int sum;
	
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
	
	public MovingAverage(int size){
		this.size = size;
		sum = 0;
		q  = new LinkedList<>();
	}
	
	public void add(int x){
		sum += x;
		if (q.size() == size){
			sum -= q.remove();
		}
		q.add(x);
	}
	
	public double getAverage(){
		return (double)sum / q.size();
	}

}
