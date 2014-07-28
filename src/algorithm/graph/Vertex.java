package algorithm.graph;

import java.util.LinkedList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
	public int index;
	public List<Edge> edges;
	public boolean visited;
	public int distance;
	public Edge prev;
	
	public Vertex(int index){
		this.index = index;
		edges = new LinkedList<Edge>();
		visited = false;
		distance = Integer.MAX_VALUE;
		prev = null;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("index: " + index + ", visited: " + visited+ ", distance: " + distance + ", adjacencyList: ");
		for (Edge e: edges){
			sb.append(e.end.index + " ");
		}
		sb.append("\n");
		return sb.toString();
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (index != other.index)
			return false;
		return true;
	}
	@Override
	public int compareTo(Vertex v) {
		if (distance < 0 && v.distance > 0){
			return -1;
		} else  if (distance > 0 && v.distance < 0){
			return 1;
		} else {
			return distance - v.distance;
	
		}
	}
}
