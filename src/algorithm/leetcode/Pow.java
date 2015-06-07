package algorithm.leetcode;

public class Pow {

	public static void main(String[] args) {
		double res = new Pow().myPow(2, 5);
		System.out.println(res);
	}
	

	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		boolean negative = false;
		if (n < 0) {
			n = -n;
			negative = true;
		}

		double r = 1;
		while (n > 0) {
			if (n % 2 == 1){
				r = r * x;
			}
			x = x * x;
			n = n / 2;
		}
		return negative ? 1 / r : r;

	}
}
