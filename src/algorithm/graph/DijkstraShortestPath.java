package algorithm.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import algorithm.datastructure.MinHeap;

public class DijkstraShortestPath {

	public static void main(String[] args) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath();
		//Graph g = dijkstraShortestPath.createGraph();
		
		int start = 0;
		int end = 59;
		Graph g = dijkstraShortestPath.readGraph("dijkstraData.txt");
		int d = dijkstraShortestPath.findShortestPath(g, start, end);
		System.out.println(d);
		Graph g2 = dijkstraShortestPath.readGraph("dijkstraData.txt");
		int d2 = dijkstraShortestPath.findShortestPathWithHeap(g2, start, end );
		System.out.println(d2);
	}

	private Graph readGraph(String file) {
		Graph g = new Graph(200, true);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = br.readLine()) != null){
				String[] str = line.split("\t");
				int start = Integer.parseInt(str[0]) - 1;
				for (int i = 1; i < str.length; i ++){
					String[] endStr = str[i].split(",");
					int end = Integer.parseInt(endStr[0]) - 1;
					int weight = Integer.parseInt(endStr[1]);
					g.addEdge(start, end, weight);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return g;
	}

	public int findShortestPath(Graph g, int start, int end) {
		Vertex startVertex = g.vertice[start];
		startVertex.distance = 0;
		while (true) {
			Vertex vertex = null;
			int min = Integer.MAX_VALUE;
			for (Vertex v: g.vertice){
				if (!v.visited && v.distance < min){
					min = v.distance;
					vertex = v;
				}
			}
			
			if (vertex  == null){
				return Integer.MAX_VALUE;
			}
			
			vertex.visited = true;
			if (vertex == g.vertice[end]){
				return vertex.distance;
			}
			
			for (Edge edge: vertex.edges){
				Vertex endVertex = edge.end;
				if (!endVertex.visited && vertex.distance + edge.weight < endVertex.distance){
					endVertex.distance = vertex.distance + edge.weight;
				}
			}
		}
	}
	
	
	public int findShortestPathWithHeap(Graph g, int start, int end) {
		Vertex startVertex = g.vertice[start];
		startVertex.distance = 0;
		MinHeap<Vertex> heap = new MinHeap<Vertex>(g.vertice);
		
		while(!heap.isEmpty()) {
			Vertex vertex  = heap.extractMin();
			vertex.visited = true;
			if (vertex == g.vertice[end]){
				return vertex.distance;
			}
			for(Edge edge: vertex.edges){
				Vertex endVertex = edge.end;
				if (!endVertex.visited && vertex.distance + edge.weight < endVertex.distance){
					heap.delete(endVertex);
					endVertex.distance = vertex.distance + edge.weight;
					heap.insert(endVertex);
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	private Graph createGraph() {
		Graph g = new Graph(7, true);
		g.addEdge(0, 1, 2);
		g.addEdge(0, 3, 1);
		g.addEdge(1, 3, 3);
		g.addEdge(1, 4, 10);
		g.addEdge(2, 0, 4);
		g.addEdge(2, 5, 5);
		g.addEdge(3, 2, 2);
		g.addEdge(3, 4, 2);
		g.addEdge(3, 5, 8);
		g.addEdge(3, 6, 4);
		g.addEdge(4, 6, 6);
		g.addEdge(6, 5, 1);
		return g;
	}

}
