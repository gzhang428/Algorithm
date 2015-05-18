package algorithm.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContigeousSubsequenceSumToInteger {

	public static void main(String[] args) {
		int[] a = {3, 11, 5, 7, 3, 7, 8, 0, 4, 16, 7};
		List<List<Integer>> res = new ContigeousSubsequenceSumToInteger().find(a, 19);
		
		System.out.println(res);
	}

	private List<List<Integer>> find(int[] a, int s) {
		List<List<Integer>> res = new ArrayList<>();
		int n = a.length;
		Map<Integer, Integer> map = new HashMap<>();
		
		map.put(a[0], 0);
		for (int i = 1; i < n; i++){
			a[i] = a[i - 1] + a[i];
			map.put(a[i], i);
		}
		
		if (map.containsKey(s)){
			List<Integer> list = new ArrayList<>();
			list.add(0);
			list.add(map.get(s));
			res.add(list);
		}
		for (int i = 0; i < n; i++){
			int r = s + a[i];
			if (map.containsKey(r)){
				List<Integer> list = new ArrayList<>();
				list.add(i + 1);
				list.add(map.get(r));
				res.add(list);
			}
		}
		return res;
	}

}
