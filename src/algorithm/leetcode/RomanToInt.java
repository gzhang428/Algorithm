package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	public static void main(String[] args) {
		int res = new RomanToInt().romanToInt("MCMXCVI");
	}

	 public int romanToInt(String s) {
	        int res = 0;
	        Map<Character, Integer> map = new HashMap<>();
	        map.put('M', 1000);
	        map.put('D', 500);
	        map.put('C', 100);
	        map.put('L', 50);
	        map.put('X', 10);
	        map.put('V', 5);
	        map.put('I', 1);
	        
	        for (int i = 0; i < s.length(); i++){
	            char c = s.charAt(i);
	            if (i + 1 < s.length()){
	                char nc = s.charAt(i + 1);
	                if (map.get(nc) > map.get(c)){
	                    res += (map.get(nc) - map.get(c));
	                    i ++;
	                    continue;
	                }
	            }
	            res += map.get(c);
	        }
	        return res;
	    }
}
