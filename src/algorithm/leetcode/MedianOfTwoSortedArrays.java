package algorithm.leetcode;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3 };
		int[] B = { 1, 2 };
		double res = new MedianOfTwoSortedArrays().findMedianSortedArrays(A, B);
		System.out.println(res);
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;

		if ((m + n) % 2 == 0) {
			return (median(A, 0, m - 1, B, 0, n - 1, (m + n) / 2 + 1) + median(A,
					0, m - 1, B, 0, n - 1, (m + n) / 2)) / 2.0;
		} else {
			return median(A, 0, m - 1, B, 0, n - 1, (m + n) / 2 + 1);
		}
	}

	private double median(int[] nums1, int l1, int h1, int[] nums2, int l2,	int h2, int k) {
		int len1 = h1 - l1 + 1;
		int len2 = h2 - l2 + 1;
		if (len1 > len2){
			return median(nums2, l2, h2, nums1, l1, h1, k);
		}
		if (len1 == 0) {
			return nums2[l2 + k - 1];
		}

		if (k == 1){
			return Math.min(nums1[l1], nums2[l2]);
		}
		
		int p1 = Math.min(k / 2, len1);
		int p2 = k - p1;
		if (nums1[l1 + p1 - 1]  == nums2[l2 + p2 - 1]){
			return nums1[l1 + p1 - 1];
		} else if (nums1[l1 + p1 -1] < nums2[l2 + p2 - 1]){
			return median(nums1, l1 + p1, h1, nums2, l2, h2, k - p1);
		} else {
			return median(nums1, l1, h1, nums2, l2 + p2, h2, k - p2);
		}
		
	}
}
