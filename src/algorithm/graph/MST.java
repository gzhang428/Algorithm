package algorithm.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import algorithm.MinHeap;

public class MST {

	public static void main(String[] args) {
		MST mst = new MST();
		Graph g = mst.readGraph("D:/edges.txt");
		//Graph g = mst.createGraph();
		System.out.println(g);
		try {
			Graph minimalSpinningTree = mst.find(g);
			System.out.println(minimalSpinningTree);
			int cost = 0;
			for (Vertex v: minimalSpinningTree.vertice){
				for (Edge e: v.edges){
					cost += e.weight;
				}
			}
			System.out.println(cost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public Graph find(Graph g) throws Exception {
		Graph minimalSpinningTree = new Graph(g.V, true);
		Vertex startVertex = g.vertice[0];
		startVertex.distance = 0;
		MinHeap<Vertex> heap = new MinHeap<Vertex>(g.vertice);
		
		while(!heap.isEmpty()){
			Vertex vertex = heap.extractMin();
			vertex.visited = true;
			if (vertex.prev != null){
				Edge prevEdge = vertex.prev;
				minimalSpinningTree.addEdge(prevEdge.start.index, prevEdge.end.index, prevEdge.weight);
			}
			
			for (Edge edge: vertex.edges){
				Vertex endVertex = edge.end;
				if (!endVertex.visited && edge.weight < endVertex.distance){
					heap.delete(endVertex);
					endVertex.distance = edge.weight;
					endVertex.prev = edge;
					heap.insert(endVertex);
				}
			}
		}
		
		
		return minimalSpinningTree;
	}

	private Graph createGraph() {
		Graph g = new Graph(4, false);
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 3, 5);
		g.addEdge(0, 3, 4);
		g.addEdge(0, 2, 3);
		return g;
	}
	
	
	private Graph readGraph(String file) {
		Graph g = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			int V = Integer.parseInt(line.split(" ")[0]);
			g = new Graph(V, false);
			while( (line = br.readLine() ) != null ){
				String[] entry = line.split(" ");
				int start = Integer.parseInt(entry[0]) - 1;
				int end = Integer.parseInt(entry[1]) - 1;
				int weight = Integer.parseInt(entry[2]);
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
