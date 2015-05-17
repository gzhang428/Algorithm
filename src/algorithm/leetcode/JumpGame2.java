package algorithm.leetcode;

public class JumpGame2 {

	public static void main(String[] args) {
		int[] a = {2,3,1,1,4};
		int res = new JumpGame2().jump(a);
		System.out.println(res);
	}

	 public int jump(int[] A) {
	        int n = A.length;
	        if (n <= 1){
	            return 0;
	        }
	        int p = 0;
	        int last = 0;
	        int res = 0;
	        for (int i = 0; i < n; i++){
	            if (i > last){
	                last = p;
	                res ++;
	                
	            }
	            p = Math.max(p, i + A[i]);
	        }
	        return res;
	        
	    }
}
