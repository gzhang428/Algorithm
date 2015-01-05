package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {

	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		List<Integer> l2 = new ArrayList<>();
		l2.add(2);
		l2.add(3);
		input.add(l1);
		input.add(l2);
		
		new MinimumTotal().minimumTotal(input);
		
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] a = new int[n][n];

		for (int i = 0; i < triangle.get(n - 1).size(); i++) {
			a[n - 1][i] = triangle.get(n - 1).get(i);
		}

		for (int i = n - 2; i >= 0; i--) {
			List<Integer> level = triangle.get(i);
			for (int j = 0; j < level.size(); j++) {
				a[i][j] = Math.min(a[i + 1][j], a[i + 1][j + 1]) + level.get(j);
			}
		}
		return a[0][0];

	}

}
