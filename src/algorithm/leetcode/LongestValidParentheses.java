package algorithm.leetcode;

public class LongestValidParentheses {

	public static void main(String[] args) {
		int res = new LongestValidParentheses().longestValidParentheses("(()");
		System.out.println(res);
	}

	public int longestValidParentheses(String s) {
		if (s.length() == 0 || s.length() == 1){
			return 0;
		}
		int max = 0;
		int n = s.length();
		int[] dp = new int[n];
		dp[n - 1] = 0;
		
		for (int i = n - 2; i >= 0; i--){
			if (s.charAt(i) == '('){
				int j = i + 1 + dp[i + 1];
				if (j < n && s.charAt(j) == ')'){
					dp[i] = dp[i + 1] + 2;
					if (j + 1 < n){
						dp[i] += dp[j + 1];
					}
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		
		
		return max;
	}


}
