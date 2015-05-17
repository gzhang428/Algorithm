package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] num = { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> res = new CombinationSum().combinationSum2(num, 8);
		System.out.println(res);
	}

	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(num);
		sum(num, target, 0, list, res);
		return res;

	}

	private void sum(int[] num, int target, int start, List<Integer> list,
			List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		if (target > 0) {
			for (int i = start; i < num.length; i++) {
				if (i > start && num[i] == num[i - 1]) {
					continue;
				}
				list.add(num[i]);
				sum(num, target - num[i], i + 1, list, res);
				list.remove(list.size() - 1);
			}
		}
	}
}
