package algorithm.interview;

public class ChangeMaking {

	public static void main(String[] args) {
		int[] s = { 2, 5, 3, 6};
		int res = new ChangeMaking().count(s , 10);
		System.out.println(res);
	}

	private int count(int[] s, int n) {
		int m = s.length;
		int[][] dp = new int[m][n + 1];
		
		for (int i = 0; i < m; i++){
			dp[i][0] = 1;
		}
		
		for (int j = 1; j <= n; j++){
			if (j % s[0] == 0){
				dp[0][j] = 1;
			}
		}
		
		for (int j = 1; j <= n; j++){
			for (int i = 1; i < m; i++){
				dp[i][j] = dp[i - 1][j] + ((j - s[i] >= 0 )? dp[i][j - s[i]]: 0);				
			}
		}
		return dp[m - 1][n];
		
	}

}
