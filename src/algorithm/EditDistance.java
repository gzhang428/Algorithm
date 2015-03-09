package algorithm;

public class EditDistance {

	public static void main(String[] args) {
		int res = new EditDistance().minDistance("ACCTAT", "ACTTAC");
		System.out.println(res);
	}

	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 1; i <= m; i++){
			dp[i][0] = i;
		}
		for (int j = 1; j <= n; j++){
			dp[0][j] = j;
		}
		
		for (int i = 1; i <= m; i++){
			for (int j = 1; j <= n; j++){
				int insert = dp[i][j - 1] + 1;
				int delete = dp[i - 1][j] + 1;
				int edit;
				if (word1.charAt(i - 1) == word2.charAt(j - 1)){
					edit = dp[i - 1][j - 1];
				} else {
					edit = dp[i - 1][j - 1] + 2;
				}
				dp[i][j] = Math.min(edit, Math.min(insert, delete));
			}
		}
		return dp[m][n];
	}

}
