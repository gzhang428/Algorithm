package algorithm.graph;

import java.util.Iterator;
import java.util.List;


public class Graph {
	public int V;
	public int E;
	public Vertex[] vertice;
	public boolean directed;
	
	public Graph(int V, boolean directed){
		this.V = V;
		E = 0;
		vertice = new Vertex[V];
		for (int i = 0; i < V; i++){
			vertice[i] = new Vertex(i);
		}
		this.directed = directed;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("V: " + V + ", E: " + E + ", directed: " + directed + "\n");
		for(Vertex v: vertice){
			if (v != null){
				sb.append(v);
			}
		}
		return sb.toString();
	}

	public void addEdge(int start, int end, int weight) {
		vertice[start].edges.add(new Edge(vertice[start], vertice[end], weight));
		if (!directed){
			vertice[end].edges.add(new Edge(vertice[end], vertice[start], weight));
		}
		E ++;
	}

	public void addEdge(int start, int end) {
		addEdge(start, end, 1);
	}
	

	public void removeEdge(int start, int end) {
		List<Edge> edges = vertice[start].edges;
		for (Iterator<Edge> it = edges.iterator(); it.hasNext(); ){
			Edge e = it.next();
			if (e.end.index  == end){
				it.remove();
			}
		}
		
		if (!directed){
			List<Edge> backEdges = vertice[end].edges;
			for (Iterator<Edge> it = backEdges.iterator(); it.hasNext(); ){
				Edge e = it.next();
				if (e.end.index == start){
					it.remove();
				}
			}
		}
		E --;
	}

	public boolean hasEdge(int start, int end) {
		List<Edge> edges = vertice[start].edges;
		for (Iterator<Edge> it = edges.iterator(); it.hasNext(); ){
			Edge e = it.next();
			if (e.end.index  == end){
				return true;
			}
		}
		return false;
	}

	public Edge getEdge(int start, int end) {
		List<Edge> edges = vertice[start].edges;
		for (Iterator<Edge> it = edges.iterator(); it.hasNext(); ){
			Edge e = it.next();
			if (e.end.index  == end){
				return e;
			}
		}
		return null;
		
	}
}
