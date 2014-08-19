package algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import algorithm.datastructure.UnionFind;

public class Clustering {

	public class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		
		public Edge (int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return weight - e.weight;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight="
					+ weight + "]";
		}
		
	}

	public static void main(String[] args) {
		Clustering clustering = new Clustering();
//		List<Edge> edges = clustering.readEges("D:/clustering1.txt");
//		int res = clustering.cluster(500, 4, edges);
//		System.out.println(res);
		
		clustering.cluster2("D:/clustering_big.txt", 24);
		
		
	}

	private void cluster2(String file, int bit) {
		Map<Integer, Integer> indexes = readIndex(file, bit);
		UnionFind uf = new UnionFind(indexes.size());
		for (Entry<Integer, Integer> e: indexes.entrySet()){
			int node = e.getKey();
			int index = e.getValue();
			
			for (int j = 0; j < bit; j++){
				int newNode = node ^ (1 << j);
				if (indexes.containsKey(newNode)){
					int newIndex = indexes.get(newNode);
					if (uf.find(index) != uf.find(newIndex)){
						uf.union(newIndex, index);
					}
				}
			}
		}
		System.out.println(uf.count());
		
		for (Entry<Integer, Integer> e: indexes.entrySet()){
			int node = e.getKey();
			int index = e.getValue();
			for (int j = 0; j < bit; j++){
				for (int k = j + 1; k < bit; k++){
					int newNode = node ^ (1 << k) ^ (1 << j);
					if (indexes.containsKey(newNode)){
						int newIndex = indexes.get(newNode);
						if (uf.find(index) != uf.find(newIndex)){
							uf.union(newIndex, index);
						}
					}
				}
			}
		}
		System.out.println(uf.count());
	}

	private Map<Integer, Integer> readIndex(String file, int bit) {
		Map<Integer, Integer> index = new HashMap<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			int i = 0;
			while((line = br.readLine()) != null){
				String[] parts = line.split(" ");
				int node = 0;
				for (int j = 0; j < bit; j++){
					if (parts[bit - 1 - j].equals("1")){
						node = node | (1 << j);
					}
				}
				if (!index.containsKey(node)){
					index.put(node, i);
					i++;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return index;
	}

	private int cluster(int n, int k, List<Edge> edges) {
		Collections.sort(edges);
		UnionFind uf = new UnionFind(n);
		
		int i;
		for(i = 0; i < edges.size(); i++){
			Edge e = edges.get(i);
			if (uf.find(e.start) != uf.find(e.end)){
				uf.union(e.start, e.end);
			}
			if (uf.count() == k - 1){
				break;
			}
		}
		return edges.get(i).weight;
		
	}

	private List<Edge> readEges(String file) {
		List<Edge> edges = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while((line = br.readLine()) != null){
				String[] parts = line.split(" ");
				int start = Integer.parseInt(parts[0]) - 1;
				int end = Integer.parseInt(parts[1]) - 1;
				int weight = Integer.parseInt(parts[2]);
				Edge e = new Edge(start, end, weight);
				edges.add(e);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return edges;
	}

}
