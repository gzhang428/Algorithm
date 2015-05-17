package algorithm.leetcode;


public class Reverse {

	public static void main(String[] args) {
		int res = new Reverse().reverse(1534236469);
		System.out.println(res);
	}

	 public int reverse(int x) {
	        boolean negative = false;
	        if (x < 0){
	            negative = true;
	            x = -x;
	        }
	        
	        int res = 0;
	        while(x > 0){
	            int v = x % 10;
	            x = x /10;
	            if (res  > (Integer.MAX_VALUE - v) / 10){
	            	return 0;
	            }
	            res = res * 10 + v;
	        }
	        return negative? -res: res;
	 }

}
