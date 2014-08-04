package algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightIndependentSet {

	public static void main(String[] args) {
		MaxWeightIndependentSet maxWeightIndependentSet = new MaxWeightIndependentSet();
		int[] set = {10, 4, 5, 4};
		int value = maxWeightIndependentSet.find(set);
		System.out.println(value);
	}

	private int find(int[] path) {
		int[] a = new int[path.length + 1];
		a[1] = path[0];
		for (int i = 2; i <= path.length; i++){
			a[i] = Math.max(a[i - 1], a[i - 2] + path[i - 1]);
		}
		
		
		// reconstruction
		int i = path.length;
		List<Integer> res = new ArrayList<>();
		while (i >= 1 ){
			if (a[i - 1] > ((i >= 2)? a[i - 2]: 0) + path[i - 1]){
				i--;
			} else {
				res.add(path[i - 1]);
				i -= 2;
			}
		}
		System.out.println(res);
		
		
		return a[path.length];
		
	}


}
