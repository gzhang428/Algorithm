package algorithm.leetcode;

public class FindMinimumInRoatedSortedArray2 {

	public static void main(String[] args) {
		int[] num = {10,1,10,10,10};
		new FindMinimumInRoatedSortedArray2().findMin(num );
	}

	public int findMin(int[] num) {
		int low = 0;
		int high = num.length - 1;

		while (low <= high) {
			if (low == high || num[low] < num[high]) {
				return num[low];
			}
			int mid = (low + high) / 2;
			if (num[low] > num[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}

		}
		return -1;
	}
}
