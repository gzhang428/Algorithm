package algorithm.graph;

public class Edge implements Comparable<Edge> {
	public Vertex start;
	public Vertex end;
	public int weight;
	
	public Edge(Vertex start, Vertex end, int weight){
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [start=" + start.index + ", end=" + end.index + ", weight=" + weight
				+ "]";
	}

	@Override
	public int compareTo(Edge e1) {
		if (weight == e1.weight){
			return start.index * end.index - e1.start.index * e1.end.index;
		}else {
			return weight - e1.weight;
		}
	}
	
	
}
