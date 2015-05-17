package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CanIWin {

	public static void main(String[] args) {
		boolean res = new CanIWin().canIWin(3, 5);
		System.out.println(res);
	}

	public boolean canIWin(int max, int target) {
		List<Integer> candidates = new ArrayList<Integer>();
		for (int i = 1; i <= max; i++) {
			candidates.add(i);
		}
		return helper(candidates, target);
	}

	public boolean helper(List<Integer> candidates, int target) {
		if (candidates.get(candidates.size() - 1) >= target) {
			return true;
		}
		for (int i = 0; i < candidates.size(); i++) {
			int removed = candidates.remove(i);
			if (!helper(candidates, target - removed)) {
				candidates.add(i, removed);
				return true;
			}
			candidates.add(i, removed);
		}
		return false;
	}
}
