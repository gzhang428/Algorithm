package algorithm.leetcode;


public class Divide {

	public static void main(String[] args) {
		int res = new Divide().divide(-2147483648, -1);
		System.out.println(res);
	}

	public int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}
		boolean negative = (dividend > 0) ^ (divisor > 0);
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);

		long res = 0;
		while (a >= b) {
			int i = 0;
			while (a >= (b << i)) {
				i++;
			}
			res = res | (1L << (i - 1));
			a -= b << (i - 1);
		}
		if (res > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return negative ? -(int) res : (int) res;
	}

}
