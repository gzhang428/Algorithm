package algorithm.leetcode;

public class JumpGame2 {

	public static void main(String[] args) {
		int[] a = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
		new JumpGame2().jump(a);
	}


	public int jump(int[] A) {
		int n = A.length;
		if (n <= 1) {
			return 0;
		}

		int ret = 0;
		int last = 0;
		int curr = 0;
		for (int i = 0; i < n; ++i) {
			if (i > last) {
				last = curr;
				++ret;
			}
			curr = Math.max(curr, i + A[i]);
		}

		return ret;

	}

}
