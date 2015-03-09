package algorithm.leetcode;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		new RotateArray().rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}

	public void rotate(int[] nums, int k) {
		int n = nums.length;
		if (n <= 1 || k == 0) {
			return;
		}
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		int i = start;
		int j = end;
		while(i <= j){
			int t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
			i++;
			j--;
		}
	}
}
