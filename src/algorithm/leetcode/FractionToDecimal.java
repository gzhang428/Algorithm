package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

	public static void main(String[] args) {
		String res = new FractionToDecimal().fractionToDecimal(-1, -2147483648);
		System.out.println(res);
	}

	
	  public String fractionToDecimal(int numerator, int denominator) {
	        if (denominator == 0){
	            return null;
	        }
	        if (numerator == 0){
	            return "0";
	        }
	        boolean negative = (numerator > 0) ^ (denominator > 0);
	        
	        long n = Math.abs((long)numerator);
	        long d = Math.abs((long)denominator);
	        long f = n / d;
	        long f2 = f;
	        long r = n % d;
	        int i = 0;
	        Map<Long, Integer> map = new HashMap<>();
	        map.put(r, 0);
	        StringBuilder sb = new StringBuilder();
	        while(r != 0){
	            r *= 10;
	            f = r / d;
	            r = r % d;
	            i ++;
	            if (map.containsKey(r)){
	            	int index = map.get(r);
	            	sb.insert(index, "(");
	            	sb.append(f).append(")");
	            	break;
	            } else {
	            	map.put(r, i);
	            }
	            sb.append(f);
	            
	        }        
	        
	        String str =( negative? "-":"") + String.valueOf(f2);
	        if (sb.length() > 0){
	        	str = str + "." + sb;
	        }
	        return str;
	        
	    }
}
