package algorithm.leetcode;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		boolean res = new RegularExpressionMatching().isMatch("ab", ".*c");
		System.out.println(res);
	}

	public boolean isMatch(String s, String p) {
		if (s.length() == 0 && p.length() == 0) {
			return true;
		}
		if (p.length() == 0) {
			return false;
		}

		if (p.length() > 1 && p.charAt(1) == '*') {
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			int i = 0;
			while (i < s.length() && (p.charAt(0) == '.' || s.charAt(i) == p.charAt(0))) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
		
		return s.length() > 0 &&  (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && isMatch(s.substring(1), p.substring(1));
	}

}
