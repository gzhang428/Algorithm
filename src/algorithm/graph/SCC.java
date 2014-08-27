package algorithm.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import algorithm.datastructure.ArrayStack;
import algorithm.datastructure.Stack;
import algorithm.graph.DFS.IFunction;

public class SCC {
	DFS dfs = new DFS();

	public static void main(String[] args) {
		SCC scc = new SCC();
		//Graph g = scc.readGraph("D:/sample1.txt", 9);
		Graph g = scc.createGraph();
		List<List<Vertex>> res = scc.findSCCs(g);
		System.out.println(res);
	}
	
	private List<List<Vertex>> findSCCs(Graph g) {
		List<List<Vertex>> res = new ArrayList<>();
		Stack<Vertex> stack =new ArrayStack<>();
		while(stack.size() < g.V){
			int start = 0;
			for (int i = 0; i < g.V; i++){
				if (!g.vertice[i].visited){
					start = i;
					break;
				}
			}
			System.out.println("start: " + start);
			dfsAndStackPush(g, start, stack);
		}
		
		Graph gRev = reverse(g);
		//System.out.println(gRev);

		while(!stack.isEmpty()){
			Vertex v = stack.pop();
			Vertex startVertex = gRev.vertice[v.index];
			if (!startVertex.visited){
				List<Vertex> oneSCC = dfs.search(gRev, startVertex.index);
				res.add(oneSCC);
			}
		}
		return res;
	}


	private Graph reverse(Graph g) {
		Graph reversed = new Graph(g.V, true);
		for (Vertex v: g.vertice){
			int start = v.index;
			for (Edge e: v.edges){
				int end = e.end.index;
				reversed.addEdge(end, start);
			}
		}
		return reversed;
	}

	public void dfsAndStackPush(Graph g, int start, Stack<Vertex> stack) {
		IFunction stackPushFunction = new StackPushFunction(stack);
		dfs.recursiveSearch(g, start, stackPushFunction);
	}
	
	public class StackPushFunction implements IFunction {

		private Stack<Vertex> stack;

		public StackPushFunction(Stack<Vertex> stack) {
			this.stack = stack;
		}

		@Override
		public void execute(Vertex currentVertex) {
			stack.push(currentVertex);
		}

	}
	
	
	private Graph createGraph() {
		Graph g = new Graph(9, true);
		g.addEdge(0, 6);
		g.addEdge(6, 3);
		g.addEdge(3, 0);
		g.addEdge(6, 8);
		g.addEdge(8, 5);
		g.addEdge(5, 2);
		g.addEdge(2, 8);
		g.addEdge(5, 7);
		g.addEdge(7, 1);
		g.addEdge(1, 4);
		g.addEdge(4, 7);
		return g;
	}

	private Graph readGraph(String file, int size) {
		Graph g = new Graph(size, true);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = br.readLine()) != null){
				String[] edgeString = line.split(" ");
				int start = Integer.parseInt(edgeString[0]) - 1;
				int end = Integer.parseInt(edgeString[1]) - 1;
				g.addEdge(start, end);
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