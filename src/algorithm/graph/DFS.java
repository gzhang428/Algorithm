package algorithm.graph;

import java.util.List;

import algorithm.Stack;

public class DFS {

	public static void main(String[] args) {
		DFS dfs = new DFS();
		Graph g = dfs.createGraph();
		System.out.println(g);
		try {
			dfs.search(g, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(g);
	}
	public void search(Graph g, int start) throws Exception {
		Stack<Vertex> stack = new Stack<Vertex>();
		Vertex startVertex = g.vertice[start];
		startVertex.visited = true;
		stack.push(startVertex);
		while(!stack.isEmpty()){
			Vertex v = stack.pop();
			List<Edge> edges = v.edges;
			for (Edge edge: edges){
				Vertex vertex = edge.end;
				if (!vertex.visited){
					vertex.visited = true;
					stack.push(vertex);
				}
			}
		}
	}
	
	private Graph createGraph() {
		Graph g = new Graph(6, false);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
		return g;
	}
}
