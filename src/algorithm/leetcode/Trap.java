package algorithm.leetcode;

public class Trap {

	public static void main(String[] args) {
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		new Trap().trap(A );
	}

	public int trap(int[] A) {
		int n = A.length;
		if (n <= 2) {
			return 0;
		}

		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		int max = A[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = max;
			max = Math.max(max, A[i]);
		}
		

		return 0;

	}

}
