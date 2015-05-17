package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		int res = new PalindromePartitioning().minCut("aab");
		System.out.println(res);
	}

	public int minCut(String s) {

		int n = s.length();
		boolean[][] isPalindrome = new boolean[n][n];
		
		int[] cuts = new int[n + 1];
		for (int i = 1; i <= n; i++){
			cuts[i] = i;
		}
		
	
		
		return 0;
	}

	private int partition(String s, int start, List<String> list, int min) {
		if (start == s.length()) {
			return Math.min(list.size() - 1, min);
		}

		for (int i = start + 1; i <= s.length(); i++) {
			String str = s.substring(start, i);
			if (isPalindrome(str)) {
				list.add(str);
				int res = partition(s, i, list, min);
				min = Math.min(res, min);
				list.remove(list.size() - 1);
			}
		}
		
		return min;
	}

	private boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i <= j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
