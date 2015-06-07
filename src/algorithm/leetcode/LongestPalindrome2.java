package algorithm.leetcode;

import java.util.Arrays;

public class LongestPalindrome2 {

	public static void main(String[] args) {
		new LongestPalindrome2().findLongestPalindrome("abba");
	}

	private String findLongestPalindrome(String s) {
		String t = preprocess(s);
		System.out.println(t);
		int n = t.length();
		int[] p = new int[n];
		int c = 0;
		int r = 0;
		for (int i = 1; i < n - 1; i++){
			int i2 = c - (i - c);
			p[i] = (r > i)? Math.min(r - i, p[i]): 0;
			while(t.charAt(i - 1 - p[i]) == t.charAt(i + 1 + p[i])){
				p[i]++;
			}
			if (i + p[i] > r){
				r = i + p[i];
				c = i;
			}
		}
		System.out.println(Arrays.toString(p));
		return null;
	}

	private String preprocess(String s) {
		if (s.isEmpty()){
			return "^$";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("^");
		for (char c: s.toCharArray()){
			sb.append("#").append(c);
		}
		sb.append("#").append("$");
		return sb.toString();
	}

}
