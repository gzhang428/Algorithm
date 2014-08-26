package algorithm.graph;

import java.util.ArrayList;
import java.util.List;

import algorithm.datastructure.ArrayStack;
import algorithm.datastructure.Stack;

public class DFS {

	public interface IFunction {
		void execute(Vertex currentVertex);
	}

	public static void main(String[] args) {
		DFS dfs = new DFS();
		Graph g = dfs.createGraph();
		System.out.println(g);
		dfs.search(g, 1);
		System.out.println(g);
	}
	public List<Vertex> search(Graph g, int start) {
		List<Vertex> res = new ArrayList<>();
		Stack<Vertex> stack = new ArrayStack<Vertex>();
		Vertex startVertex = g.vertice[start];
		startVertex.visited = true;
		res.add(startVertex);
		stack.push(startVertex);
		while(!stack.isEmpty()){
			Vertex v = stack.pop();
			List<Edge> edges = v.edges;
			for (Edge edge: edges){
				Vertex vertex = edge.end;
				if (!vertex.visited){
					vertex.visited = true;
					res.add(vertex);
					stack.push(vertex);
				}
			}
		}
		return res;
	}
	

	public void recursiveSearch(Graph g, int start, IFunction f){
		Vertex currentVertex = g.vertice[start];
		currentVertex.visited = true;
		for (Edge edge:currentVertex.edges){
			Vertex endVertex = edge.end;
			if (!endVertex.visited){
				recursiveSearch(g, endVertex.index, f);
			}
		}
		f.execute(currentVertex);
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
