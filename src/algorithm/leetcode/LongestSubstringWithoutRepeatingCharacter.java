package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

	public static void main(String[] args) {
		new LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring("abcabcbb");
	}

	 public int lengthOfLongestSubstring(String s) {
	        int left = 0;
	        int max = 0;
	        Map<Character, Integer> map = new HashMap<>();
	        for (int i = 0; i < s.length(); i++){
	            char c = s.charAt(i);
	            if (map.containsKey(c) && map.get(c) >= left){
	                max = Math.max(max, i - left);
	                left = map.get(c) + 1;
	            }
	            map.put(c, i);
	        }
	        return Math.max(max, s.length() - left);
	    }
}
