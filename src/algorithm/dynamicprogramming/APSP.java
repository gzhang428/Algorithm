package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import algorithm.graph.Edge;
import algorithm.graph.Graph;

public class APSP {


	public static void main(String[] args) {
		APSP apsp = new APSP();
		Graph g = apsp.readGraph("D:/g3.txt");
		System.out.println(g.E);
		int[][] res = apsp.find(g);
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < g.V; i ++){
			for (int j = 0; j < g.V; j++){
				if (res[i][j] < min){
					min = res[i][j];
				}
			}
		}
		System.out.println(min);
	}


	private int[][] find(Graph g) {
		int n = g.V;
		int[][][] a = new int[n + 1][n][n];
		Edge e;
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				if (i == j){
					a[0][i][j] = 0;
				} else if ((e = g.getEdge(i, j)) != null){
					a[0][i][j] = e.weight;
				} else {
					a[0][i][j] = Integer.MAX_VALUE;
				}
			}
		}
		// k: the path should use vertex (k - 1)
		for (int k = 1; k <= n; k++){
			for(int i = 0; i < n; i++){
				for (int j = 0; j < n; j++){
					a[k][i][j] = Math.min(a[k - 1][i][j], sum(a[k - 1][i][k - 1], a[k - 1][k - 1][j]));
				}
			}
		}
		
		int[][] res = a[n];
		
		// check negative cycle
		for (int i = 0; i < n; i++){
			if (res[i][i] < 0){
				return null;
			}
		}
		
		return res;
	}

	private int sum(int a, int b) {
		if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		} else {
			return a + b;
		}
	}

	private Graph readGraph(String file) {
		Graph g = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			int V = Integer.parseInt(line.split(" ")[0]);
			g = new Graph(V, true);
			
			while((line = br.readLine()) != null){
				String[] parts = line.split(" ");
				int start = Integer.parseInt(parts[0]) - 1;
				int end = Integer.parseInt(parts[1]) -1 ;
				int weight = Integer.parseInt(parts[2]);
				
				g.addEdge(start, end, weight);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return g;
	}

}
