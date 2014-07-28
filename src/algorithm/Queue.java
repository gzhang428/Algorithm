package algorithm;
import java.util.LinkedList;
import java.util.List;


public class Queue<T> {
	private List<T> q;
	
	public Queue(){
		q = new LinkedList<T>();
	}
	
	public boolean isEmpty(){
		return q.isEmpty();
	}
	
	public int size(){
		return q.size();
	}
	
	public void enqueue(T t){
		q.add(t);
	}
	
	public T dequeue() throws Exception{
		if(q.isEmpty()){
			throw new Exception();
		}
		return q.remove(0);
	}
	public T peek() throws Exception{
		if(q.isEmpty()){
			throw new Exception();
		}
		return q.get(0);
	}
}
