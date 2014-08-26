package algorithm.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedConnectivity {

	public static void main(String[] args) {
		UndirectedConnectivity undirectedConnectivity = new UndirectedConnectivity();
		Graph g = undirectedConnectivity.createGraph();
		System.out.println(g);
		List<List<Vertex>> connectedComponents = undirectedConnectivity.findConnectedComponents(g);
		System.out.println(connectedComponents);
	}

	private List<List<Vertex>> findConnectedComponents(Graph g) {
		DFS bfs = new DFS(); // Both BFS and DFS are OK
		List<List<Vertex>> res = new ArrayList<>();
		for(Vertex vertex: g.vertice){
			if (!vertex.visited){
				List<Vertex> connectedComponent = bfs.search(g, vertex.index);
				res.add(connectedComponent);
			}
		}
		
		return res;
	}

	private Graph createGraph() {
		Graph g = new Graph(10, false);
		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(2, 4);
		g.addEdge(4, 6);
		g.addEdge(4, 8);
		g.addEdge(1, 3);
		g.addEdge(5, 7);
		g.addEdge(5, 9);
		g.addEdge(7, 9);
		
		return g;
	}

}
