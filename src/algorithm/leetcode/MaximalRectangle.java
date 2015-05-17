package algorithm.leetcode;

public class MaximalRectangle {

	public static void main(String[] args) {
		char[][] matrix = {{'1', '1', '0', '1'}, {'1', '1', '0', '1'}, {'1', '1', '1', '1'}};
		int res = new MaximalRectangle().maximalRectangle(matrix );
		System.out.println(res);
	}

	  public int maximalRectangle(char[][] matrix) {
	        int m = matrix.length;
	        if (m == 0){
	            return 0;
	        }
	        int n = matrix[0].length;
	        if (n == 0){
	            return 0;
	        }
	        
	        int[] colLocal = new int[n];
	        int[][] dp = new int[m][n];
	        dp[0][0] = matrix[0][0] - '0';
	        colLocal[0] = matrix[0][0] - '0';
	        int local = matrix[0][0] - '0';
	        for (int i = 1; i < m; i++){
	            if (matrix[i][0] == '0'){
	                local = 0;
	                dp[i][0] = dp[i - 1][0];
	            } else {
	                local ++;
	                dp[i][0] = Math.max(dp[i - 1][0], local);
	            }
	        }        
	        local = matrix[0][0] -'0';
	        for (int j = 1; j < n; j++){
	             colLocal[j] = matrix[0][j] - '0';
	             
	             
	            if (matrix[0][j] == '0'){
	                local = 0;
	                dp[0][j] = dp[0][j - 1];
	            } else {
	                local ++;
	                dp[0][j] = Math.max(dp[0][j - 1], local);
	            }
	        }

	        
	        for (int i = 1; i < m; i++){
	            int rowLocal = matrix[i][0] - '0';
	            for (int j = 1; j < n; j++){
	                if (matrix[i][j] == '0'){
	                    colLocal[j]  = 0;
	                    rowLocal = 0;
	                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
	                } else {
	                    colLocal[j] = colLocal[j] + 1;
	                    rowLocal ++;
	                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], colLocal[j] * rowLocal));
	                }
	            }
	        }
	        return dp[m - 1][n - 1];
	    }
}
