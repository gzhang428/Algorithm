package algorithm;

import java.util.List;

import algorithm.graph.Edge;

public class UnionFind<T> {
	private Node[] nodes;

	public UnionFind(List<T> objects){
		nodes = (Node[]) new Object[objects.size()];
		for (int i = 0; i < nodes.length; i++){
			Node node = nodes[i];
			node.id = i;
			node.object = objects.get(i);
		}
	}
	
	public int find(T t){
		
		
		return 0;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public class Node {
		public int id;
		public int weight;
		public T object;
	}
	
	
	
	
	public static void main(String[] args) {
		UnionFind<Edge> unionFind = new UnionFind<>(null);
		
	}

}
