package algorithm.graph;

import java.util.List;

import algorithm.Queue;


public class BFS {

	public static void main(String[] args) {

		BFS bfs  = new BFS();
		Graph g = bfs.createGraph();
		System.out.println(g);
		try {
			bfs.search(g, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(g);
	}


	public void search(Graph g, int start) throws Exception {
		Queue<Vertex> queue = new Queue<Vertex>();
		Vertex startVertex = g.vertice[start];
		startVertex.distance = 0;
		startVertex.visited = true;
		queue.enqueue(startVertex);
		while(!queue.isEmpty()){
			Vertex v = queue.dequeue();
			List<Edge> edges = v.edges;
			for (Edge edge: edges){
				Vertex vertex = edge.end;
				if (!vertex.visited){
					vertex.distance = v.distance + 1;
					vertex.visited  = true;
					queue.enqueue(vertex);
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
