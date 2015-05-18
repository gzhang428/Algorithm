package algorithm.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class NewDataStructure {

	Map<Integer, Integer> map;
	List<Integer> list;
	
	
	public NewDataStructure(){
		map = new HashMap<>();
		list = new ArrayList<>();
	}
	
	public void put(int x){
		list.add(x);
		map.put(x, list.size() - 1);
	}
	
	public boolean contains(int x){
		return map.containsKey(x);
	}
	
	public void remove(int x){
		int lastElement = list.get(list.size() - 1);
		int index = map.get(x);
		list.set(index, lastElement);
		map.put(lastElement, index);
		map.remove(x);
		list.remove(list.size() - 1);
	}
	
	public int getRandom(){
		return list.get(new Random().nextInt(list.size()));
	}
	
	public int getLast(){
		return list.get(list.size() - 1);
	}
	
	
	public static void main(String[] args) {
		NewDataStructure d = new NewDataStructure();
		d.put(1);
		d.put(2);
		d.put(3);
		d.put(4);
		System.out.println(d.getLast());
		System.out.println(d.getRandom());
		d.remove(2);
		System.out.println(d.getLast());
		System.out.println(d.getRandom());
		d.remove(4);
		System.out.println(d.getLast());
		System.out.println(d.getRandom());
		d.put(5);
		System.out.println(d.getLast());
		System.out.println(d.getRandom());
	}

}
