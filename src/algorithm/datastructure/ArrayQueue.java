package algorithm.datastructure;

public class ArrayQueue<T> implements Queue<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private T[] array;
	private int tail;
	private int head;
	private int size;
	private int capacity;
	
	public ArrayQueue(){
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayQueue(int capacity) {
		array = (T[]) new Object[capacity];
		tail = -1;
		head = 0;
		size = 0;
		this.capacity = capacity;
	}

	public boolean isEmpty(){
		return (size == 0);
	}
	
	public int size(){
		return size;
	}
	
	private boolean isFull(){
		return (size == capacity);
	}
	
	public void enqueue(T t){
		if (isFull()){
			resize();
		}
		tail = (tail + 1) % capacity;
		array[tail] = t;
		size ++;
	}
	
	private void resize() {
		T[] newArray = (T[]) new Object[capacity *  2];
		for (int i = 0; i < size; i++){
			newArray[i] = array[ (i + head) % capacity];
		}
		capacity *= 2;
		head = 0;
		tail = size - 1;
		array = newArray;
	}

	public T dequeue() {
		if(isEmpty()){
			throw new RuntimeException();
		}
		T res = array[head];
		head = (head + 1) % capacity;
		size --;
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
