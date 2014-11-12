package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		LengthOfLongestSubstring l = new LengthOfLongestSubstring();
		int length = l.lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar");
		System.out.println(length);
	}

	private int lengthOfLongestSubstring(String s) {
	    if (s == null || s.isEmpty()){
            return 0;
        }
        
        int left = 0;
        int max = 0;
        int i;
        Map<Character, Integer> map = new HashMap<>();
        for (i = 0; i < s.length(); i++){
            char c = s.charAt(i);
           
            if (map.containsKey(c) && map.get(c) >= left){
                int length = i - left;
                if (length > max){
                    max = length;
                }
                int prevOccurrence = map.get(c);
                left = prevOccurrence + 1;
                
                
            } 
            
            map.put(c, i);
            
        }
        return Math.max(max, i - left );
	}

}
