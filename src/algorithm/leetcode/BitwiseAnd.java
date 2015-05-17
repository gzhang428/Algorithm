package algorithm.leetcode;

public class BitwiseAnd {

	public static void main(String[] args) {
		int res = new BitwiseAnd().rangeBitwiseAnd(5, 7);
		System.out.println(res);
	}

	 public int rangeBitwiseAnd(int m, int n) {
	        int res = 0;
	        for (int i = 0; i < 32; i++){
	            boolean isOne = true;
	            for (long j = m; j <= n; j++){
	                if ( (j  & (1 << i)) == 0){
	                    isOne = false;
	                    break;
	                }
	            }
	            if (isOne){
	                res = res | (1 << i);
	            }
	        }
	        return res;
	    }
}
