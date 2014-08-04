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
		Graph g = apsp.readGraph("D:/g1.txt");
		System.out.println(g.E);
		apsp.find(g);
		
	}

	private void find(Graph g) {
		int n = g.V;
		int[][][] a = new int[n + 1][n + 1][n + 1];
		Edge e;
		for (int i = 0; i <= n; i++){
			for (int j = 0; j <= n; j++){
				if (i == j){
					a[i][j][0] = 0;
				} else if ((e = g.getEdge(i, j)) != null){
					a[i][j][0] = e.weight;
				} else {
					a[i][j][0] = Integer.MAX_VALUE;
				}
			}
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
