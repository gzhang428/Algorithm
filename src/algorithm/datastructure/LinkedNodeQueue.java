package algorithm.datastructure;

public class LinkedNodeQueue<T> implements Queue<T> {
	private LinkedNode<T> head;
	private LinkedNode<T> tail;
	private int size;

	public LinkedNodeQueue (){
		head = null;
		tail = null;
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void enqueue(T t) {
		LinkedNode<T> node = new LinkedNode<>(t);
		size ++;
		if (isEmpty()){
			head = node;
			tail = node;
			return;
		} 
		tail.next = node;
		tail = node;
	}

	@Override
	public T dequeue() {
		if (isEmpty()){
			throw new RuntimeException("Empty Queue");
		}
		size--;
		T res = head.data;
		head = head.next;
		return res;
	}

	public static void main(String[] args){
		Queue<Integer> queue = new LinkedNodeQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(3);
		System.out.println(queue.dequeue());
	}
}
