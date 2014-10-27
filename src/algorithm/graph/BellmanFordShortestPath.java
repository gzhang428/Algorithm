package algorithm.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BellmanFordShortestPath {

	public static void main(String[] args) {
		BellmanFordShortestPath bellmanFord = new BellmanFordShortestPath();
		Graph g = bellmanFord.readGraph("D:/g3.txt");
		//Graph g = bellmanFord.createGraph();
		int res = bellmanFord.findShortestPath(g, 398, 903);
		System.out.println(res);
	}

	public int findShortestPath(Graph g, int start, int end){
		int[] res = findShortestPath(g, start);
		if (res == null){
			return Integer.MIN_VALUE;
		} else {
			return res[end];
		}
	}
	

	public int[] findShortestPath(Graph g, int start) {
		int[][] a = new int[g.V][g.V];
		// init
		for (int i = 0; i < g.V; i++){
			if (i == start){
				a[0][i] = 0;
			} else {
				a[0][i] = Integer.MAX_VALUE;
			}
		}
		
		int i;
		for (i = 1; i < g.V; i++){
			System.out.println(i);
			for (int j = 0; j < g.V; j ++){ // j is the end node index
				int min = Integer.MAX_VALUE;
				for (int w = 0; w < g.V; w ++){
					for (Edge e: g.vertice[w].edges){
						if (e.end.index == j){
							int dist = sum(a[i - 1][w] , e.weight);
							if (dist < min){
								min = dist;
							}
						}
					}
				}
				min = Math.min(min, a[i - 1][j]);
				a[i][j] = min;
			}
			
			// stop early
			boolean shouldStop = true;
			for (int j = 0; j < g.V; j++){
				if (a[i - 1][j] != a[i][j]){
					shouldStop = false;
					break;
				}
			}
			if (shouldStop){
				return a[i];
			}
		}
		
		// detect negative circle, run one more cycle for i = n;
		for (int j = 0; j < g.V; j ++){ // j is the end node index
			int min = Integer.MAX_VALUE;
			for (int w = 0; w < g.V; w ++){
				for (Edge e: g.vertice[w].edges){
					if (e.end.index == j){
						int dist = sum(a[g.V - 1][w] , e.weight);
						if (dist < min){
							min = dist;
						}
					}
				}
			}
			min = Math.min(min, a[i - 1][j]);
			if (a[g.V - 1][j] != min){
				return null; // negative circle found, return Min value;
			}
		}
		
		return a[g.V];
		
	}
	
	

	private Graph createGraph() {
		Graph g = new Graph(5, true);
		g.addEdge(0, 1, 2);
		g.addEdge(0, 2, 4);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(3, 4, 2);
		return g;
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
