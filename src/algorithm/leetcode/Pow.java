package algorithm.leetcode;

public class Pow {

	public static void main(String[] args) {
		new Pow().myPow(8.8, 3);
	}

	public double myPow(double x, int n) {
		if (n < 0) {
			return 1 / calculate(x, -(long) n);
		} else {
			return calculate(x, (long) n);
		}

	}

	private double calculate(double x, long n) {
		if (n == 0){
			return 1;
		}
		double half = calculate(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}

}
