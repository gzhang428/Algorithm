package algorithm.interview;

import java.util.ArrayList;
import java.util.List;

public class FactorCombination {

	public static void main(String[] args) {
		List<List<Integer>> res = new FactorCombination().find(28);
		System.out.println(res);
	}

	public List<List<Integer>> find(int num) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		find(num, 2, list, res);
		return res;
	}

	private void find(int num, int start, List<Integer> list, List<List<Integer>> res) {
		if (num  == 1 && list.size() > 1){
			res.add(new ArrayList<Integer>(list));
			return ;
		}
		for (int i = start; i <= num; i++){
			if (num % i == 0){
				list.add(i);
				find(num / i, i, list, res);
				list.remove(list.size() - 1);
			}
		}
	}

}
