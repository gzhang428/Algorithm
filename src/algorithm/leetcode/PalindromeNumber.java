package algorithm.leetcode;

public class PalindromeNumber {

	public static void main(String[] args) {
		new PalindromeNumber().isPalindrome(11);
	}
	
	 public boolean isPalindrome(int x) {
		  if (x < 0){
	            return false;
	        }
	        int d = 1;
	        while(x / d >= 10){
	            d *= 10;
	        }
	        while (x > 0){
	            if (x % 10 != x / d){
	                return false;
	            }
	            x /= 10;
	            d /= 100;
	        }
	        return true;
	    }

}
