package algorithm.datastructure;

public class ArrayQueue<T> implements Queue<T> {
	private T[] array;
	private int tail;
	private int head;
	
	
	public ArrayQueue(int capacity) {
		array = (T[]) new Object[capacity];
		tail = 0;
		head = 0;
	}

	public boolean isEmpty(){
		return head == tail;
	}
	
	public int size(){
		if (tail < head){
			return tail + array.length - head;
		}
		return tail - head;
	}
	
	private boolean isFull(){
		return (tail + 1) % array.length == head;
	}
	
	public void enqueue(T t){
		array[tail] = t;
		tail = (tail + 1) % array.length;
	}
	

	public T dequeue() {
		if(isEmpty()){
			throw new RuntimeException();
		}
		T res = array[head];
		head = (head + 1) % array.length;
		return res ;
	}
	
	
	public static void main(String[] args){
		Queue<Integer> q = new ArrayQueue<Integer>(4);
		q.enqueue(5);
		q.enqueue(3);
		q.dequeue();
		q.dequeue();
		q.enqueue(2);
		q.enqueue(6);
		q.enqueue(8);
		q.enqueue(7);
		q.enqueue(9);
	}
}
