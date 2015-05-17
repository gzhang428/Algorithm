package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		int[] num = { 1, 1, 2 };
		List<List<Integer>> res = new Permutation().permuteUnique(num);
		System.out.println(res);
	}

	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(num);
		boolean[] used = new boolean[num.length];
		List<Integer> list = new ArrayList<>();
		permute(num, used, list, res);
		return res;
	}

	private void permute(int[] num, boolean[] used, List<Integer> list,
			List<List<Integer>> res) {
		if (list.size() == num.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (i > 0 && num[i] == num[i - 1] && used[i - 1]) {
				continue;
			}
			if (!used[i]) {
				list.add(num[i]);
				used[i] = true;
				permute(num, used, list, res);
				list.remove(list.size() - 1);
				used[i] = false;
			}
		}

	}

}
