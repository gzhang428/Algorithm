package algorithm.leetcode;

public class FactorialTrailingZeros {

	public static void main(String[] args) {
		new FactorialTrailingZeros().trailingZeroes(2147483647);
	}

	private int trailingZeroes(int n) {
		 int s = 0;
	        long x = 5;
	        while(n >= x){        
	            s += n / x;
	            x *= 5;
	        }
	        return s;	
	}

}
