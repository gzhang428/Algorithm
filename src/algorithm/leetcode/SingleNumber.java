package algorithm.leetcode;

public class SingleNumber {

	public static void main(String[] args) {
		int[] A = { 2, 2, 3, 2 };
		new SingleNumber().singleNumber(A);
	}

	public int singleNumber(int[] A) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int bit = 0;
			for (int j = 0; j < A.length; j++) {
				if ((A[j] & (1 << i)) != 0) {
					bit++;
				}
			}
			res += (bit % 3) << i;
		}
		return res;
	}
}
