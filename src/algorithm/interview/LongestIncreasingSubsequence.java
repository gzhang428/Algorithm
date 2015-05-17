package algorithm.interview;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		int[] array = {2, 3, 0, 4, 5, 7, 9, 8, 1, 6};
		
		
		int[] res = new LongestIncreasingSubsequence().longestSubsequence(array);
		System.out.println(Arrays.toString(res));
	}

	private int[] longestSubsequence(int[] array) {
		int start = 0;
		int max = 0;
		int[] res = {};
		for (int i = 1; i < array.length; i++){
			if (array[i] < array[i - 1]){
				int len = i - 1 - start + 1;
				if (len > max){
					max = len;
					res = Arrays.copyOfRange(array, start, i);
				}
				start = i;
			}
		}
		return res;
	}

}
