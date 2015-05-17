package algorithm.leetcode;

import java.util.Arrays;

public class InterleavingString {

	public static void main(String[] args) {
		//boolean res = new InterleavingString().isInterleave("a", "b", "a");
		String[] strs = "/home//foo".split("/+");
		System.out.println(Arrays.toString(strs));
	}
//	 public boolean isInterleave(String s1, String s2, String s3) {
//	        if (s1.length() == 0){
//	            return s2.equals(s3);
//	        }
//	        if (s2.length() == 0){
//	            return s1.equals(s3);
//	        }
//	        
//	        if (s1.length() + s2.length() != s3.length()){
//	            return false;
//	        }
//
//	        char c1 = s1.charAt(0);
//	        char c2 = s2.charAt(0);
//	        char c3 = s3.charAt(0);
//	        if (c1 == c3 && c2 == c3){
//	            return isInterleave(s1.substring(1), s2, s3.substring(1)) || isInterleave(s1, s2.substring(1), s3.substring(1));
//	        } else if (c1 == c3 && c2 != c3){
//	            return isInterleave(s1.substring(1), s2, s3.substring(1));
//	        } else if (c1 != c3 && c2 == c3){
//	            return isInterleave(s1, s2.substring(1), s3.substring(1));
//	        } else {
//	            return false;
//	        }
//	        
//	    }
	
	public boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();

		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;

		for (int i = 1; i <= m; i++) {
			if (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
				dp[i][0] = true;
			}
		}
		for (int j = 1; j <= n; j++) {
			if (dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1)) {
				dp[0][j] = true;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if ((dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
						|| (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j
								- 1))) {
					dp[i][j] = true;
				}
			}
		}
		return dp[m][n];
	}

}
