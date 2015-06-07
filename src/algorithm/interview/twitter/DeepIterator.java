package algorithm.interview.twitter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DeepIterator<T> implements Iterator<T> {
	private Stack<Iterator<Object>> stack;
	private T nextItem;
	
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		list.add(1);
		list.add(new ArrayList<Integer>());
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(3);
		list.add(list2);
		List<Object> list3 = new ArrayList<>();
		List<Integer> list4 = new ArrayList<>();
		list4.add(4);
		list4.add(5);
		list3.add(list4);
		list3.add(6);
		list3.add(7);
		list.add(list3);
		
		DeepIterator<Integer> it = new DeepIterator<Integer>(list);
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
	
	}

	public DeepIterator(List<Object> list) {
		stack = new Stack<>();
		stack.push(list.iterator());
	}
	
	
	@Override
	public boolean hasNext() {
		if(nextItem != null){
			return true;
		}
		
		while(!stack.isEmpty()){
			 Iterator<Object> it = stack.peek();
			 if (it.hasNext()){
				 Object o = it.next();
				 if (o instanceof List){
					 stack.push(((List) o).iterator());
				 } else {
					 nextItem = (T) o;
					 return true;
				 }
			 } else {
				 stack.pop();
			 }
			
		}
		
		return false;
	}

	@Override
	public T next() {
		if (hasNext()){
			T res = nextItem;
			nextItem = null;
			return res;
		}
		throw new RuntimeException();
	}

}
