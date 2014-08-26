package algorithm.datastructure;

public class LinkedNode<T> {
	public T data;
	public LinkedNode<T> next;
	
	public LinkedNode(T data){
		this.data = data;
		next = null;
	}

}
