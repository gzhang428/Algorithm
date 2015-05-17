package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

	public static void main(String[] args) {
		int[] num = { 1, 1, 2 };
		List<List<Integer>> res = new Subset().subsetsWithDup(num);
		System.out.println(res);
	}

	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		subsets(num, 0, list, res);
		return res;
	}

	private void subsets(int[] num, int start, List<Integer> list,
			List<List<Integer>> res) {
		res.add(new ArrayList<Integer>(list));
		for (int i = start; i < num.length; i++) {
			if (i > start && num[i] == num[i - 1]) {
				continue;
			}
			list.add(num[i]);
			subsets(num, i + 1, list, res);
			list.remove(list.size() - 1);
		}
	}
}
