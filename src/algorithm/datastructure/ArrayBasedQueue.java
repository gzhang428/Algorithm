package algorithm.datastructure;

import java.util.Arrays;


public class ArrayBasedQueue<T> implements Queue<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private T[] array;
	private int tail;
	private int head;
	
	public ArrayBasedQueue(){
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayBasedQueue(int capacity) {
		array = (T[]) new Object[capacity];
		tail = -1;
		head = 0;
	}

	public boolean isEmpty(){
		return (head - tail == 1);
	}
	
	public int size(){
		return (tail - head + 1);
	}
	
	public void enqueue(T t){
		if (tail >= array.length - 1){
			resize();
		}
		tail ++;
		array[tail] = t;
	}
	
	private void resize() {
		array = Arrays.copyOf(array, array.length * 2);
	}

	public T dequeue() {
		if(isEmpty()){
			throw new RuntimeException();
		}
		return array[head++];
	}
}
