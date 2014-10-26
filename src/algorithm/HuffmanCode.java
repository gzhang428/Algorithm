package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import algorithm.datastructure.MinHeap;

public class HuffmanCode {

	public static void main(String[] args) {
		HuffmanCode huffmanCode = new HuffmanCode();
		Map<String, Double> weight = new HashMap<>();
		weight.put("a", 0.2);
		weight.put("b", 0.1);
		weight.put("c", 0.4);
		weight.put("d", 0.3);
		Map<String, String> res  = huffmanCode.generate(weight);
		System.out.println(res);
	}

	private Map<String, String> generate(Map<String, Double> weight) {
		Map<String, String> res = new HashMap<>();
		if (weight.size() == 1){
			String letter = weight.keySet().iterator().next();
			res.put(letter, "0");
			return res;
		}
		MinHeap<HuffmanNode> heap = new MinHeap<>(weight.size());
		for (Entry<String, Double> entry: weight.entrySet()){
			HuffmanNode node = new HuffmanNode(entry.getKey(), entry.getValue());
			heap.insert(node);
		}
		heap.print();
		
		while(heap.size() >= 2){
			HuffmanNode minNode1 = heap.extractMin();
			HuffmanNode minNode2 = heap.extractMin();
			HuffmanNode newNode = new HuffmanNode(minNode1.letter + minNode2.letter, minNode1.freq + minNode2.freq);
			newNode.left = minNode1;
			newNode.right = minNode2;
			
			heap.insert(newNode);
			heap.print();
		}
		
		HuffmanNode root = heap.extractMin();
		generateCode(root, "", res);
		return res;
	}
	
	private void generateCode(HuffmanNode node, String code, Map<String, String> res) {
		if (node.left == null && node.right == null){
			res.put(node.letter, code);
			return;
		}
		if (node.left != null){
			generateCode(node.left, code + "0", res);
		}
		if (node.right != null){
			generateCode(node.right, code + "1", res);
		}
		
	}

	public class HuffmanNode implements Comparable<HuffmanNode>{
		public String letter;
		public double freq;
		public HuffmanNode left;
		public HuffmanNode right;
		
		public HuffmanNode(String letter, double freq){
			this.letter = letter;
			this.freq = freq;
			left = null;
			right = null;
		}
		
		
		@Override
		public int compareTo(HuffmanNode node) {
			return (int) Math.signum(this.freq - node.freq);
		}


		@Override
		public String toString() {
			return "HuffmanNode [letter=" + letter + ", freq=" + freq + "]";
		}

		
	}

}
