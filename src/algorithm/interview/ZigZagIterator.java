package algorithm.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZigZagIterator<T> implements Iterator<T> {
	List<Iterator<T>> its;
	int i;

	public static void main(String[] args) {
		List<List<String>> lists = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		lists.add(list1);
		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		lists.add(list2);
		ZigZagIterator<String> it = new ZigZagIterator<>(lists);
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	public ZigZagIterator(List<List<T>> lists) {
		its = new ArrayList<>();
		for (List<T> list: lists){
			its.add(list.iterator());
		}
		i = -1;
	}
	

	@Override
	public boolean hasNext() {
		for(int j = 1; j <= its.size(); j++){
			if (its.get((i + j) % its.size()).hasNext()){
				i = (i + j) % its.size();
				return true;
			}
		}
		return false;
	}

	@Override
	public T next() {
		return its.get(i).next();
	}

}
