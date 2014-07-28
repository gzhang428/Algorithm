package algorithm.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MinCut {
	
	
	public static void main(String[] args) {
		MinCut repeat = new MinCut();
		List<Edge> edges = repeat.readGraph("kargerMinCut.txt");
		int V = 200;
		int n = repeat.run(edges, V);
		System.out.println(n);
	}

	private int run(List<Edge> edges, int V) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 10000; i++){
			List<Edge> edgesCopy = new ArrayList<Edge>(edges.size());
			for (Edge edge: edges){
				edgesCopy.add(new Edge(edge.start, edge.end));
			}
			int n = randomContraction(edgesCopy, V);
			System.out.println(n);
			if (n < min){
				min = n;
			}
		}
		return min;
	}

	private int randomContraction(List<Edge> edges, int V) {
		Random r = new Random();
		while(V > 2){
			int randomEdgeIndex = r.nextInt(edges.size());
			Edge randomEdge = edges.get(randomEdgeIndex);
			int startVertex = randomEdge.start;
			int endVertex = randomEdge.end;
			edges.remove(randomEdgeIndex);
			
			for (Edge edge: edges){
				if (edge.start == endVertex){
					edge.start = startVertex;
				}
				if (edge.end == endVertex){
					edge.end = startVertex;
				}
			}
			for(Iterator<Edge> it = edges.iterator(); it.hasNext(); ){
				Edge edge = it.next();
				if (edge.start == edge.end){
					it.remove();
				}
			}
			V --;
		}			
		return edges.size();
	}

	private List<Edge> readGraph(String file) {
		List<Edge> edges = new ArrayList<Edge>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = br.readLine()) != null){
				String[] vertice = line.split("\t");
				int start = Integer.parseInt(vertice[0]);
				
				for (int i = 1; i < vertice.length; i++){
					int end = Integer.parseInt(vertice[i]);
					if (end > start){
						edges.add(new Edge(start, end));
					}
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return edges;
	}
	
	private class Edge {
		public int start;
		public int end;
		
		public Edge(int start, int end){
			this.start =  start;
			this.end = end;
		}
		
		public String toString(){
			return start + "->" + end + "\n";
		}
		
	}


}