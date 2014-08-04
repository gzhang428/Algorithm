package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Knapsack {
	public static void main(String[] args) {
		Knapsack knapsack = new Knapsack();
		List<Item> items = knapsack.readItems("D:/knapsack1.txt");
		int value = knapsack.find(items, 6);
		System.out.println(value);
	}

	private List<Item> readItems(String file) {
		List<Item> items = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			br.readLine();
			while((line = br.readLine()) != null){
				String[] parts = line.split(" ");
				int value = Integer.parseInt(parts[0]);
				int weight = Integer.parseInt(parts[1]);
				Item item = new Item(value, weight);
				items.add(item);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return items;
	}

	private int find(List<Item> items, int capacity) {
		int[][] a = new int[items.size() + 1][capacity + 1];
		for (int i = 1; i <= items.size(); i ++){
			Item lastItem = items.get(i - 1);
			for (int w = 1; w <= capacity; w ++){
				if (lastItem.weight <= w){
					a[i][w] = Math.max(a[i - 1][w], a[i - 1][w - lastItem.weight] + lastItem.value);
				} else {
					a[i][w] = a[i - 1][w];
				}
			}
		}
		return a[items.size()][capacity];
	}
	
	private int find2(List<Item> items, int capacity){
		Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
		int value =  recusiveFind(items, items.size(), capacity, cache);
		//System.out.println(cache);
		return value;
	}


	private int recusiveFind(List<Item> items, int i, int w, Map<Integer, Map<Integer, Integer>> cache) {
		if (i <= 0 || w <= 0){
			return 0;
		} else {
			//System.out.println(i + " " + w);
			Item lastItem = items.get(i - 1);
			Map<Integer, Integer> map;
			if (cache.containsKey(i - 1)){
				map = cache.get(i - 1);
			} else {
				map = new HashMap<>();
				cache.put(i - 1, map);
			}
			 
			if (!map.containsKey(w)){
				int value = recusiveFind(items, i - 1, w, cache);
				if (value != 0){
					map.put(w, value);
				}
			}
			if (!map.containsKey(w - lastItem.weight)){
				int value = recusiveFind(items, i - 1, w - lastItem.weight, cache);
				if (value != 0){
					map.put(w - lastItem.weight, value);
				}
			}
			
			
			if (lastItem.weight <= w){
				return Math.max(map.containsKey(w)? map.get(w): 0, (map.containsKey(w - lastItem.weight)? map.get(w - lastItem.weight): 0) + lastItem.value);
			} else {
				return map.containsKey(w)? map.get(w): 0;
			}
		}
	}


	public class Item {

		public int value;
		public int weight;

		public Item(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}

	}

}
