package algorithm.leetcode;

public class NumDecodings {

	public static void main(String[] args) {
		int res = new NumDecodings().numDecodings("1212");
		System.out.println(res);
	}
	
	  public int numDecodings(String s) {
	        return decode(s, 0);
	        
	    }
	
	 public int decode(String s, int start){
	        if (start >= s.length() - 1){
	            return 1;
	        }
	        int res = decode(s, start + 1);
	        String str = s.substring(start, start + 2);
	        int n = Integer.parseInt(str);
	        if ( n >= 1 && n <= 26){
	            res += decode(s, start + 2);
	        }
	        return res;
	    }

}
