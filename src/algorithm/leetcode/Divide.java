package algorithm.leetcode;

import java.util.Arrays;

public class Divide {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(" 1".split("\\s+")));
//		int res = new Divide().divide(-2147483648, -1);
//		System.out.println(res);
	}

	public int divide(int dividend, int divisor) {
		boolean negative = false;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			negative = true;
		}
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		long r = 0;
		while (a >= b) {
			int shift = 0;
			while (a >= (b << shift)) {
				shift++;
			}
			r += 1L << (shift - 1);
			a -= b << (shift - 1);
		}
		if (r > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return negative ? -(int) r : (int) r;
	}

}
