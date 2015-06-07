package algorithm.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekIterator<T> implements Iterator<T> {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		PeekIterator<Integer> it = new PeekIterator<>(list.iterator());
		System.out.println(it.peek());
		System.out.println(it.next());
		System.out.println(it.peek());
		System.out.println(it.next());
		System.out.println(it.peek());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
	}

	private Iterator<T> it;
	private T item;

	public PeekIterator(Iterator<T> it){
		this.it = it;
	}
	
	@Override
	public boolean hasNext() {
		return item != null || it.hasNext();
	}

	@Override
	public T next() {
		if (item != null){
			T res = item;
			item = null;
			return res;
		} else {
			return it.next();
		}
	}
	
	public T peek(){
		if (item != null){
			return item;
		} else {
			item = it.next();
			return item;
		}
	}

}
