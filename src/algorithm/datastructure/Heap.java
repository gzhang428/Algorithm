package algorithm.datastructure;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public abstract class Heap<T extends Comparable<T>> {
	private static final int DEFAULT_CAPACITY = 10;
	protected T[] array;
	protected int size;
	
	protected Heap(){
		this(DEFAULT_CAPACITY);
	}
	
	protected Heap(int capacity){
		size = 0;
		array = (T[]) new Comparable[capacity + 1];
	}
	
	protected Heap(T[] a) {
		size = a.length;
		array = (T[]) new Comparable[a.length + 1];
		for (int i = 0; i < a.length; i++){
			array[i + 1] = a[i];
		}
		
		for (int i = size / 2; i >= 1; i--) {
			percolateDown(i);
		}

	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void insert(T x) {
		if (size >= array.length - 1){
			resize();
		}
		size ++;
		array[size] = x;
		percollateUp(size);
	}
	
	public void delete(T t) {
		if (isEmpty()){
			throw new RuntimeException("Empty heap");
		}
		int pos = -1;
		for (int i = 1; i < array.length; i++){
			if (array[i].equals(t)){
				pos = i;
				break;
			}
		}
		if (pos == -1){
			throw new RuntimeException("Item not in heap");
		}
		deletePos(pos);
	}

	public void deletePos(int pos) {
		if (pos < 1 || pos > size){
			throw new RuntimeException("Wrong position");
		}
		array[pos] = array[size];
		size --;
		percollateUp(pos);
		percolateDown(pos);
	}
	

	protected T findRoot(){
		if (isEmpty()) {
			throw new RuntimeException("Empty heap");
		}
		return array[1];
	}

	

	protected T extractRoot() {
		if (isEmpty()) {
			throw new RuntimeException("Empty heap");
		}
		T min = array[1];
		array[1] = array[size];
		size--;
		percolateDown(1);
		return min;

	}

	
	private void resize() {
		array = Arrays.copyOf(array, array.length * 2);
	}
	
	protected abstract void percolateDown(int pos) ;
	
	protected abstract void percollateUp(int pos);
	
	public void print() {
		System.out.println("size: " + size + " , array length: " + array.length);
		for (int i = 1; i <= size; i++) {
			System.out.print(i + ": " + array[i] + ", ");
		}
		System.out.println();
	}
	
}
