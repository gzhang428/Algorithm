package algorithm.leetcode;

public class Atoi {

	public static void main(String[] args) {
		int i = new Atoi().atoi("    10522545459");
	}

	public int atoi(String str) {
		if (str == null) {
			return 0;
		}
		str = str.trim();
		if (str.isEmpty()) {
			return 0;
		}
		int res = 0;
		int i = 0;
		boolean positive = true;
		if (str.charAt(0) == '+' || str.charAt(0) == '-') {
			i = 1;
			if (str.charAt(0) == '-') {
				positive = false;
			}
		}

		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			int val = str.charAt(i) - '0';
			if ( res * 10L + val > Integer.MAX_VALUE) {
				return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + val;
			i++;
		}

		return positive ? res : (-res);

	}
}