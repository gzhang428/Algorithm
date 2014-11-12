package algorithm.leetcode;

public class SearchRange {

	public static void main(String[] args) {
		int[] A = {1,4};
		new SearchRange().searchRange(A, 4);
	}

	public int[] searchRange(int[] A, int target) {
		int[] res = { -1, -1 };
		if (A == null || A.length == 0) {
			return res;
		}

		return find(A, target, 0, A.length - 1);
	}

	public int[] find(int[] A, int target, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] < target) {
				return find(A, target, mid + 1, end);
			} else if (A[mid] > target) {
				return find(A, target, start, mid - 1);
			} else {
				int i;
				for (i = mid; i >= start; i--){
					if (A[i] != target){
						break;
					}
				}
				int j;
				for (j = mid; j <= end; j++){
					if (A[j] != target){
						break;
					}
				}
				int[] res = { i + 1, j - 1 };
				return res;
			}
		}
		int[] res = { -1, -1 };
		return res;
	}

}
