package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	class Node{
		int key;
		int value;
		Node next;
		Node prev;
		
		public Node(int key, int value){
			this.key = key;
			this.value = value;
		}
		
		public String toString(){
			return key + "->" + value;
		}
	}
	private Node head;
	private Node tail;
	private Map<Integer, Node> map;
	private int capacity;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		
	}

	public int get(int key) {
		if (!map.containsKey(key)){
			return -1;
		}
		Node node = map.get(key);
		if (node == head){
			return node.value;
		} 
		if (node == tail){
			tail = tail.prev;
			tail.next = null;
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		head.prev = node;
		node.next = head;
		head = node;
		return node.value;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)){
			Node node = map.get(key);
			node.value = value;
			if (node == head){
				return;
			} 
			if (node == tail){
				tail = tail.prev;
				tail.next = null;
			} else {
				node.prev.next = node.next;
				node.next.prev = node.prev;
			}
			head.prev = node;
			node.next = head;
			head = node;
			
			
		} else {
			Node node = new Node(key, value);
			if (map.size() == capacity){
				// remove tail;
				map.remove(tail.key);
				tail = tail.prev;
				if (tail == null){
					head = null;
				} else {
					tail.next = null;
				}
			}
			if (head == null && tail  == null){
				head = node;
				tail = node;
			} else {
				head.prev = node;
				node.next = head;
				head = node;
			}
			map.put(key, node);
		}
	
	}
	public static void main(String[] args){
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(2, 2);
		cache.get(2);
		cache.set(1, 1);
		cache.set(4,  1);
		cache.get(2);
	}
}
