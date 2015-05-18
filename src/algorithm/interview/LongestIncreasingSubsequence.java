package algorithm.interview;


public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int res = new LongestIncreasingSubsequence().find(a );
		System.out.println(res);
	}

	private int find(int[] a) {
		int n = a.length;
		int[] dp = new int[n];
		
		dp[0] = 1;
		for (int i = 1; i < n; i++){
			int max = 0;
			for (int j = 0; j < i; j++){
				if (a[j] <= a[i] && dp[j] > max){
					max = dp[j];
				}
			}
			dp[i] = max + 1;
		}
		int res = 0;
		for (int i: dp){
			res = Math.max(i, res);
		}
		return res;
	}

}
