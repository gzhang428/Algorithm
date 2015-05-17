package algorithm.leetcode;

public class ScrambleString {

	public static void main(String[] args) {
		boolean res = new ScrambleString().isScramble("abcdefghijklmnopq", "efghijklmnopqcadb");
		System.out.println(res);
	}

	public boolean isScramble(String s1, String s2) {
		  if (s1.equals(s2)){
	            return true;
	        }
	        if (s1.length() != s2.length()){
	            return false;
	        }
	        int n = s1.length();
	        for (int i = 1; i < n; i++){
	            String s11 = s1.substring(0, i);
	            String s12 = s1.substring(i, n);
	            String s21 = s2.substring(0, i);
	            String s22 = s2.substring(i, n);
	            if (isScramble(s11, s21) && isScramble(s12, s22)){
	                return true;
	            }
	            String s21r = s2.substring(0, n - i );
	            String s22r = s2.substring(n - i, n);
	            if (isScramble(s11, s22r) && isScramble(s12, s21r)){
	                return true;
	            }
	        }
	        return false;
	}

}
