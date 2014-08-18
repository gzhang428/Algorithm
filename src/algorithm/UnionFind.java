package algorithm;

import java.util.Arrays;



public class UnionFind {
	private int[] id;
	private int[] size;
	private int count;
	public UnionFind(int n){
		id = new int[n];
		size = new int[n];
		count = n;
		for (int i = 0; i < n; i++){
			id[i] = i;
			size[i] = 1;
		}
	}
	
	public int getCount(){
		return count;
	}
	
	
	public int find(int a){
		int root = root(a);
		while(a != id[a]){
			int t = id[a];
			id[a] = root;
			a = t;
		}
		return a;
	}
	
	private int root(int a) {
		while(a != id[a]){
			a = id[a];
		}
		return a;
	}


	public void union(int a, int b){
		int aRoot = root(a);
		int bRoot = root(b);
		
		if (size[aRoot] > size[bRoot]){
			id[bRoot] = aRoot;
			size[aRoot] += size[bRoot];
		} else{
			id[aRoot] = bRoot;
			size[bRoot] += size[aRoot];
		}
		count --;
	}
	
	
	public static void main(String[] args) {
		UnionFind uf = new UnionFind(10);
		uf.union(4, 3);
		uf.union(4, 9);
		uf.union(8, 0);
		uf.union(2, 3);
		uf.union(5, 6);
		uf.union(5, 9);
		uf.union(7, 3);
		uf.union(4, 8);
		uf.union(6, 1);
		uf.print();
	}


	public void print() {
		System.out.println(Arrays.toString(id));
		System.out.println(Arrays.toString(size));
	}

}
