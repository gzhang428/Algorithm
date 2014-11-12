package algorithm.leetcode;

public class Divide {

	public static void main(String[] args) {
		int res = new Divide().divide(-1010369383, -2147483648);
		System.out.println(res);
	}

	private int divide(int dividend, int divisor) {
		boolean negative = false;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			negative = true;
		}
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		int r = 0;
		while (a >= b) {
			int shift = 0;
			long v = b;
			while( v <= a){
				v = v << 1;
				shift ++;
			}
			r += 1 << (shift - 1);
			a -= b << (shift - 1);
				
		}
		return negative ? -r : r;
	}

}
