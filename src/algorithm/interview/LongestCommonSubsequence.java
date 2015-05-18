package algorithm.interview;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		int res = new LongestCommonSubsequence().find("thisisatest", "testing123testing");
		System.out.println(res);
	}

	private int find(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int[][] dp = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++){
			for (int j = 1; j <= n; j++){
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);
				if (c1 == c2){
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		return dp[m][n];
		
	}

}
