package algorithm.datastructure;

public class LinkedList<T> {

	private LinkedNode<T> head;
	
	public LinkedList(){
		head = null;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	
	public void insertBefore(T t, T n){
		if (isEmpty()){
			throw new RuntimeException("Empty List");
		}
		if (t.equals(head.data)){
			addFirst(n);
			return;
		}
		LinkedNode<T> prev = null;
		LinkedNode<T> node = head;
		while(node != null && !t.equals(node.data) ){
			prev = node;
			node = node.next;
		}
		if (node == null){
			throw new RuntimeException("Cannot find element");
		}
		LinkedNode<T> newNode = new LinkedNode<>(n);
		prev.next = newNode;
		newNode.next = node;
		
	}
	
	public void insertAfter(T t, T n){
		if (isEmpty()){
			throw new RuntimeException("Empty List");
		}
		LinkedNode<T> node = head;
		while(node != null && !t.equals(node.data) ){
			node = node.next;
		}
		if (node == null){
			throw new RuntimeException("Cannot find element");
		}
		LinkedNode<T> newNode = new LinkedNode<>(n);
		newNode.next = node.next;
		node.next = newNode;
	}
	
	public void addFirst(T t){
		LinkedNode<T> node = new LinkedNode<T>(t);
		node.next = head;
		head = node;
	}
	
	public T getFirst(){
		if (isEmpty()){
			throw new RuntimeException("Empty List");
		}
		return head.data;
	}
	
	public void removeFirst(){
		if (isEmpty()){
			throw new RuntimeException("Empty List");
		}
		head = head.next;
	}
	
	public void addLast(T t){
		if (isEmpty()){
			addFirst(t);
		} else {
			LinkedNode<T> node = head;
			while(node.next != null){
				node = node.next;
			}
			node.next = new LinkedNode<T>(t);
		}
	}
	
	public T getLast(){
		if (isEmpty()){
			throw new RuntimeException("Empty List");
		}
		LinkedNode<T> node = head;
		while(node.next != null){
			node = node.next;
		}
		return node.data;
	}
	
	public T get(int pos){
		if (isEmpty()){
			throw new RuntimeException("Empty List");
		}
		LinkedNode<T> node = head;
		for(int i = 0; i < pos; i++){
			node = node.next;
			if (node == null){
				throw new RuntimeException("Index out of bound");
			}
		}
		return node.data;
	}
	
	
	public boolean contains(T t){
		if (isEmpty()){
			return false;
		}
		LinkedNode<T> node = head;
		while(node != null){
			if (t.equals(node.data)){
				return true;
			}
			node = node.next;
		}
		return false;
	}

	
	public void removePos(int pos){
		if (isEmpty()){
			throw new RuntimeException("Empty List");
		}
		
		if (pos == 0){
			removeFirst();
			return ;
		}
		
		LinkedNode<T> node = head;
		LinkedNode<T> prev = null;
		for (int i = 0; i < pos; i++){
			prev = node;
			node = node.next;
			if (node == null){
				throw new RuntimeException("Index out of bound");
			}
		}
		
		prev.next = node.next;
		
	}
	
	public void remove(T t){
		if (isEmpty()){
			throw new RuntimeException("Empty List");
		}
		
		if (t.equals(head.data)){
			removeFirst();
			return ;
		}
		
		LinkedNode<T> node = head;
		LinkedNode<T> prev = null;
		while(node != null && !t.equals(node.data)){
			prev = node;
			node = node.next;
		}
		if (node == null){
			throw new RuntimeException("Cannot find element");
		}
		prev.next = node.next;
		
	}
	
	public void clear(){
		head = null;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		LinkedNode<T> node = head;
		while(node != null){
			sb.append(node.data).append(" ");
			node = node.next;
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(1);
		list.addFirst(2);
		System.out.println(list);
		System.out.println(list.getFirst());
		list.addLast(3);
		System.out.println(list);
		System.out.println(list.getLast());
		System.out.println(list.contains(4));
		list.removePos(2);
		System.out.println(list);
		list.insertAfter(2, 3);
		list.insertAfter(1, 4);
		System.out.println(list);
		list.insertBefore(2, 0);
		list.insertBefore(3, 5);
		list.insertBefore(4, 0);
		System.out.println(list);
	}

}
