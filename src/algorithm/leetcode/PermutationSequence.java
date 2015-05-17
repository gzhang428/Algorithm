package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		String res = new PermutationSequence().getPermutation(1, 1);
		System.out.println(res);
	}

	public String getPermutation(int n, int k) {
		List<Integer> list = new LinkedList<>();
		for(int i = 1; i<= n; i++){
			list.add(i);
		}
		int x = k - 1;
		StringBuilder sb = new StringBuilder();
		for (int i = n; i >= 1; i--){
			int f = factorial(i - 1);
			int a = x / f;
			sb.append(list.get(a));
			list.remove(a);
			x = x % f;
		}
		return sb.toString();
	}

	private int factorial(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++) {
			res *= i;
		}
		return res;
	}
}
