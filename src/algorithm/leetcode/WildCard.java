package algorithm.leetcode;

public class WildCard {

	public static void main(String[] args) {
		new WildCard().isMatch("aacabacd", "a*acd");
	}

	 public boolean isMatch(String s, String p) {
	      
		 int si = 0;
		 int pi = 0;
		 int star = -1;
		 int match = 0;
		 while(si < s.length()){
			 if (pi < p.length() && (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si))){
				 pi ++;
				 si ++;
			 }else if (pi< p.length() && p.charAt(pi) == '*'){
				 star = pi;
				 match = si;
				 pi ++;
			 } else if (star != -1){
				 pi = star + 1;
				 match ++;
				 si = match;
			 } else {
				 return false;
			 }
			 
		 }
		 
		 while(pi < p.length() && p.charAt(pi) == '*'){
			 pi++;
		 }
		 return pi == p.length();
	 }
	    
}
