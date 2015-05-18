package algorithm.interview;

import java.util.ArrayList;
import java.util.List;

public class CanIWin {

	public static void main(String[] args) {
		boolean res = new CanIWin().canIWin(3, 9);
		System.out.println(res);
	}

	public boolean canIWin(int max, int target) {
		List<Integer> candidates = new ArrayList<Integer>();
		int total = 0;
		for (int i = 1; i <= max; i++) {
			total += i;
			candidates.add(i);
		}
		if (total < target){
			return false;
		}
		return canWin(candidates, target);
	}

	public boolean canWin(List<Integer> candidates, int target) {
		if (candidates.isEmpty()){
			return false;
		}
		for (int i = 0; i < candidates.size(); i++){
			int num = candidates.get(i);
			if (num >=  target){
				return true;
			}
			
			candidates.remove(i);
			if (!canWin(candidates, target - num)){
				candidates.add(i, num);
				return true;
			}
			candidates.add(i, num);
		}
		return false;
	}
}
