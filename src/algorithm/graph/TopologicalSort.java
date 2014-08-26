package algorithm.graph;

import java.util.HashMap;
import java.util.Map;

import algorithm.graph.DFS.IFunction;

public class TopologicalSort {

	private int label;
	
	public static void main(String[] args) {
		TopologicalSort topologicalSort = new TopologicalSort();
		Graph g = topologicalSort.createGraph();
		Map<Integer, Integer> res = topologicalSort.sort(g);
		System.out.println(res);
	}

	private Map<Integer, Integer> sort(Graph g) {
		Map<Integer, Integer> order = new HashMap<>();
		label = g.V;
		DFS dfs = new DFS();
		IFunction function = new SortFunction(order);
		for (Vertex vertex: g.vertice){
			if (!vertex.visited){
				dfs.recursiveSearch(g, vertex.index, function);
			}
		}
		return order;
	}
	
	public class SortFunction implements IFunction {
		private Map<Integer, Integer> order;

		public SortFunction(Map<Integer, Integer> order) {
			this.order = order;
		}

		@Override
		public void execute(Vertex currentVertex) {
			order.put(currentVertex.index, label);
			label--;
		}

	}

	private Graph createGraph() {
		Graph g = new Graph(4, true);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		return g;
	}

}
