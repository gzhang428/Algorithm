package algorithm.leetcode;

public class Pow {

	public static void main(String[] args) {
		new Pow().pow(1, -5);
	}
	
	  public double pow(double x, int n) {
	        if (x == 0.0){
	            return 0.0;
	        }
	        if (n == 0){
	            return 1;
	            
	        } 
	        boolean negative = false;
	        if (n < 0){
	            negative = true;
	            n =  -1 * n;
	            
	        }
	        double res = power(x, n);  
	      
	        if (negative){
	            return 1.0 / res;
	        } else {
	            return res;
	        }
	    }
	    
	    
	    public double power(double x, long n){
	        if (n ==  1){
	            return x;
	        }
	        
	        if (n % 2 == 1){
	            return power(x * x, n / 2) * x;
	        } else {
	            return power(x * x, n /2);
	        }
	    }

}
