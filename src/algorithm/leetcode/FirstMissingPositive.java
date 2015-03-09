package algorithm.leetcode;

public class FirstMissingPositive {

	public static void main(String[] args) {
		int[] A = { 3, 4, -1, 1 };
		new FirstMissingPositive().firstMissingPositive(A);
	}

	public int firstMissingPositive(int[] A) {
		if (A.length == 0) {
			return 1;
		}

		int i = 0;
		while (i < A.length) {
			int j = A[i] - 1;
			if (j < A.length && A[i] > 0 && A[j] != A[i]) {
				int t = A[i];
				A[i] = A[j];
				A[j] = t;
			} else {
				i++;
			}
		}

		for (i = 0; i < A.length; ++i) {
			if (A[i] != (i + 1)) {
				return i + 1;
			}
		}
		return A.length + 1;
	}
}
