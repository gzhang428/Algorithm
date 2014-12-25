package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {

	public static void main(String[] args) {
		String res = new GetPermutation().getPermutation(3, 2);
		System.out.println(res);
	}

	public String getPermutation(int n, int k) {
		List<Integer> num = new ArrayList<>();
		for (int i = 1; i <= n; i++){
			num.add(i);
		}
		StringBuilder sb = new StringBuilder();
		int b = k;
		for (int i = n; i >= 1; i--){
			int f = factorial(i - 1);
			int a = (int) Math.ceil((double)b / f);
			if (a == 0) {
				a = num.size();
			}
			int c = num.get(a - 1);
			num.remove(a - 1);
			sb.append(c);
			b = b % f;
		}
		
		return sb.toString();
	}

	public int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}
}
