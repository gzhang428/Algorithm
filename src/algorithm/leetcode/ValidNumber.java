package algorithm.leetcode;

public class ValidNumber {

	public static void main(String[] args) {
		boolean res = new ValidNumber().isNumber(" 00");
		System.out.println(res);
	}

	public boolean isNumber(String s) {
		int i = 0;
		int n = s.length();
		while(i < n && s.charAt(i) == ' '){
			i++;
		}
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
			i++;
		}
		int n1 = 0;
		while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
			i++;
			n1++;
		}
		if (i < n && s.charAt(i) == '.'){
			i++;
		}
		int n2 = 0;
		while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
			i++;
			n2++;
		}
		if (n1 + n2 == 0){
			return false;
		}
		
		if (i < n && (s.charAt(i) == 'E' || s.charAt(i) == 'e')){
			i++;
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
				i++;
			}
			int n3 = 0;
			while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
				i++;
				n3++;
			}
			if (n3 == 0){
				return false;
			}
		}
	
		while(i < s.length() && s.charAt(i) == ' '){
			i++;
		}
		
		return i == s.length();
	}

}
