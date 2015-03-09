package algorithm.leetcode;

public class Search {

	public static void main(String[] args) {
		int[] A = {3, 5, 1};
		int res = new Search().search(A , 3);
		System.out.println(res);
	}

	public int search(int[] A, int target) {
		if (A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;

		while (start <= end) {
			if (start == end){
				if (target == A[start]){
					return start;
				} else {
					return -1;
				}
			}
			
			int mid = (start + end) / 2;
			int val = A[mid];
			
			if (val == target) {
				return mid;
			}
			if (A[start] <= val && val <= A[end]) {
				if (target <= val) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (val >= A[start] && val >= A[end]) {
				if (target <= val) {
					if (target >= A[start]) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
				} else {
					start = mid + 1;
				}

			} else if (val <= A[start] && val <= A[end]) {
				if (target <= val) {
					end = mid - 1;
				} else {
					if (target >= A[start]) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
				}
			}

		}
		return -1;
	}
}
