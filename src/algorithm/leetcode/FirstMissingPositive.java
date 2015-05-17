package algorithm.leetcode;

public class FirstMissingPositive {

	public static void main(String[] args) {
		int[] A = { -1, 1, 2};
		int res = new FirstMissingPositive().firstMissingPositive(A);
		System.out.println(res);
	}

	public int firstMissingPositive(int[] A) {
		int n = A.length;
		int i = 0;
		while (i < n) {
			int j = A[i] - 1;
			if (j != i && j >= 0 && j < n   && j < n && A[j] != A[i]) {
				int t = A[i];
				A[i] = A[j];
				A[j] = t;
			} else {
				i++;
			}
		}

		for (i = 0; i < n; ++i) {
			if (A[i] != (i + 1)) {
				return i + 1;
			}
		}
		return n + 1;
	}
}
