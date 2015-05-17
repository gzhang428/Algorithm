package algorithm.leetcode;

public class Atoi {

	public static void main(String[] args) {
		int i = new Atoi().atoi("    9223372036854775809");
		System.out.println(i);
	}

	public int atoi(String str) {
		str = str.trim();
		if (str.isEmpty()) {
			return 0;
		}
		boolean negative = false;
		int i = 0;
		if (str.charAt(i) == '+') {
			i++;
		} else if (str.charAt(i) == '-') {
			negative = true;
			i++;
		}
		int res = 0;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			int val = (int) (str.charAt(i) - '0');
			if (res > (Integer.MAX_VALUE - val) / 10){
				return negative? Integer.MIN_VALUE: Integer.MAX_VALUE;
			}
			res = res * 10 + val;
			i++;
		}
		
		return negative ? -res : res;
	}
}