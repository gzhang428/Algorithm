package algorithm.datastructure;

public class SimpleUnionFind {

	int[] id;
	public SimpleUnionFind(int n){
		id = new int[n];
		for(int i = 0; i < n; i++){
			id[i] = i;
		}
	}
	
	public int find(int x){
		while(id[x] != x){
			x = id[x];
		}
		return x;
	}
	
	public void union(int p, int q){
		int r1 = find(p);
		int r2 = find(q);
		id[r2] = r1;
	}
	
	public static void main(String[] args) {
		
	}
}
