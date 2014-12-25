package algorithm.leetcode;

public class MaxSubArray {

	public static void main(String[] args) {
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int res = new MaxSubArray().maxSubArray(A );

		System.out.println(res);
	}

	public int maxSubArray(int[] A) {
		   int[] s = new int[A.length];
		   int[] l = new int[A.length];
		   l[0] = A[0];
	       s[0] = A[0];
	      
	       for (int i = 1; i < A.length; i++){
	    	   l[i] = Math.max(l[i - 1] + A[i], A[i]);
	           s[i] = Math.max(s[i - 1], l[i]);
	       }
	       return s[A.length - 1];
	}

}
