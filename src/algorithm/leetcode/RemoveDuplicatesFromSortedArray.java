package algorithm.leetcode;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] A = {1, 2, 2};
		int res = new RemoveDuplicatesFromSortedArray().removeDuplicates2(A);
	}

	public int removeDuplicates(int[] A) {
		int k = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]) {
				A[k] = A[i];
				k++;
			}
		}
		return k;
	}

	public int removeDuplicates2(int[] A) {
		if (A.length <= 2) {
			return A.length;
		}

		int k = 1;
		int count = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i - 1]) {
				count++;
				if (count <= 2) {
					A[k++] = A[i];
				}
			} else {
				A[k++] = A[i];
				count = 1;
			}
		}
		return k;
	}

}
