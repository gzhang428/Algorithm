package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("a");
		dict.add("b");
		boolean res = new WordBreak().wordBreak("ab", dict );
		System.out.println(res);
	}

	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		return wordBreak(s, dict, "");
	}

	private boolean wordBreak(String s, Set<String> dict, String str) {
		if (s.equals(str)) {
			return true;
		}
		boolean res = false;
		if (str.length() < s.length()) {
			for (String d : dict) {
				String newString = str + d;
				res = res || wordBreak(s, dict, newString);
			}
		}
		return res;
	}

}
