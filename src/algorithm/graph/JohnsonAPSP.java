package algorithm.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JohnsonAPSP {

	public static void main(String[] args) {
		JohnsonAPSP johnsonAPSP = new JohnsonAPSP();
		//Graph g = johnsonAPSP.createGraph();
		Graph g = johnsonAPSP.readGraph("D:/g3.txt");
		int[][] res = johnsonAPSP.calculate(g);
		System.out.println(res[398][903]);
		
	}

	private int[][] calculate(Graph g) {
		Graph g2 = new Graph(g.V + 1, true);
		Vertex addedVertex = g2.vertice[g.V];
		for (Vertex v: g.vertice){
			for (Edge e: v.edges){
				g2.addEdge(e.start.index, e.end.index, e.weight);
			}
			g2.addEdge(addedVertex.index, v.index, 0);
		}
		
		BellmanFordShortestPath bellmanFordShortestPath = new BellmanFordShortestPath();
		int[] weights = bellmanFordShortestPath.findShortestPath(g2, addedVertex.index);
		if (weights == null){
			return null;
		}
		
		
		Graph g3 = new Graph(g.V, true);
		for (Vertex v: g.vertice){
			for (Edge e: v.edges){
				int startIndex = e.start.index;
				int endIndex = e.end.index;
				int weight = e.weight + weights[startIndex] - weights[endIndex];
				g3.addEdge(startIndex, endIndex, weight);
			}
		}
		
		
		int[][] r = new int[g.V][g.V];
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath();
		for (int i = 0; i < g.V; i++){
			int[] res = dijkstraShortestPath.findShortestPathWithHeap(g3.copy(), i);
			for (int j = 0; j < res.length; j++){
				res[j] = sum (sum (res[j],  -weights[i]), weights[j]);
			}
			r[i] = res;
		}
		return r;
	}

	private Graph createGraph() {
		Graph g = new Graph(6, true);
		g.addEdge(0, 1, -2);
		g.addEdge(1, 2, -1);
		g.addEdge(2, 0, 4);
		g.addEdge(2, 4, -3);
		g.addEdge(2, 3, 2);
		g.addEdge(5, 3, 1);
		g.addEdge(5, 4, -4);
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
