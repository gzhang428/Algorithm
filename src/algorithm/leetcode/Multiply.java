package algorithm.leetcode;

public class Multiply {

	public static void main(String[] args) {
		new Multiply().multiply("9998", "0");
	}
	 public String multiply(String num1, String num2) {
	        
	        int n1 = num1.length();
	        int n2 = num2.length();

	        String str1 = new StringBuilder(num1).reverse().toString();
	        String str2 = new StringBuilder(num2).reverse().toString();
	        
	        int[] res = new int[n1 + n2 ];
	        for (int i =0; i < n1; i++){
	            for (int j = 0; j < n2; j++){
	                res[i + j] += (str1.charAt(i) - '0') * (str2.charAt(j) - '0');
	            }
	        }
	        
	        char[] chars = new char[n1 + n2];
	        for (int i = 0; i < res.length - 1; i++){
	            int n = res[i];
	            int a = n % 10;
	            int b = n / 10;
	            chars[i] = (char)(a + '0');
	            res[i + 1] += b;
	            
	        }
	        if (res[res.length - 1] != 0){
	            chars[res.length - 1] = (char)(res[res.length - 1] + '0');
	            String r = new String(chars);
	            return new StringBuilder(r).reverse().toString();
	            
	        } else {
	            String r = new String(chars);
	            return new StringBuilder(r.substring(0, r.length() - 1)).reverse().toString();
	        }
	        
	        
	        
	        
	        
	        
	    }
	        

}
