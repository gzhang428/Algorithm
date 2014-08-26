package algorithm.datastructure;

import java.util.Arrays;


public class ArrayStack<T> implements Stack<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private T[] array;
	private int top;
	
	public ArrayStack(){
		this(DEFAULT_CAPACITY);
	}
	public ArrayStack(int capacity) {
		array = (T[]) new Object[capacity];
		top = -1;
	}
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public int size(){
		return (top + 1);
	}
	
	public void push(T t){
		if (top >= array.length - 1){
			resize();
		}
		top++;
		array[top] = t;
	}

	private void resize() {
		array = Arrays.copyOf(array, array.length * 2);
	}
	public T pop() {
		if(isEmpty()){
			throw new RuntimeException();
		}
		return array[top--];
	}
	
}
