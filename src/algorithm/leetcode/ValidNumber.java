package algorithm.leetcode;

public class ValidNumber {

	public static void main(String[] args) {
		boolean res = new ValidNumber().isNumber("-11.");
		System.out.println(res);
	}

	public boolean isNumber(String s) {
		s = s.trim();
		if (s.length() == 0) {
			return false;
		}
		String pattern = "[+-]?(\\d+\\.?|(\\d+)?\\.\\d+)([Ee][+-]?\\d+)?";
		if (s.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

}
