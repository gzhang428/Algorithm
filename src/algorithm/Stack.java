package algorithm;
import java.util.ArrayList;
import java.util.List;


public class Stack<T> {
	private List<T> s;
	
	public Stack(){
		s = new ArrayList<T>();
	}
	public boolean isEmpty(){
		return s.isEmpty();
	}
	
	public int size(){
		return s.size();
	}
	
	public void push(T x){
		s.add(x);
	}
	public T pop() throws Exception{
		if(s.isEmpty()){
			throw new Exception();
		}
		return s.remove(s.size() - 1);
	}
	public T peek() throws Exception{
		if(s.isEmpty()){
			throw new Exception();
		}
		return s.get(s.size() - 1);
	}
	
}
