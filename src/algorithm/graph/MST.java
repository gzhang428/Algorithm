package algorithm.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import algorithm.datastructure.MinHeap;
import algorithm.datastructure.UnionFind;

public class MST {

	public static void main(String[] args) {
		MST mst = new MST();
		Graph g = mst.readGraph("D:/edges.txt");
		//Graph g = mst.createGraph();
		Graph minimalSpinningTree = mst.findKruskal(g);
		int cost = 0;
		for (Vertex v: minimalSpinningTree.vertice){
			for (Edge e: v.edges){
				cost += e.weight;
			}
		}
		System.out.println(cost);
		
	}

	
	public Graph findKruskal(Graph g){
		Graph minimalSpinningTree = new Graph(g.V, true);
		List<Edge> edges = g.getEdges();
		Collections.sort(edges);
		UnionFind uf = new UnionFind(g.V);
		for (int i = 0; i < edges.size(); i += 2 ){
			Edge e = edges.get(i);
			if (uf.find(e.start.index) != uf.find(e.end.index)){
				uf.union(e.start.index, e.end.index);
				minimalSpinningTree.addEdge(e.start.index, e.end.index, e.weight);
			}
		}
		return minimalSpinningTree;
	}
	

	public Graph findPrim(Graph g)  {
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
