package algorithm;



public class UnionFind {
	private int[] id;
	
	public UnionFind(int n){
		id = new int[n];
		for (int i = 0; i < n; i++){
			id[i] = i;
		}
	}
	
	
	public int find(int a){
		return id[a];
	}
	
	public void union(int a, int b){
		int aId = id[a];
		int bId = id[b];
		for (int i = 0; i < id.length; i++){
			if (id[i] == aId){
				id[i] = bId;
			}
		}
	}
	
	
	public static void main(String[] args) {
		
	}

}
