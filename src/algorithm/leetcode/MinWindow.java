package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

	public static void main(String[] args) {
		String res = new MinWindow().minWindow("ADOBECODEBANC", "ABC");
		System.out.println(res);
	}

	public String minWindow(String S, String T) {
		if (S.length() < T.length()){
			return "";
		}
		
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < T.length(); i++){
			char c = T.charAt(i);
			if (map.containsKey(c)){
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		int count = 0;
		int min = Integer.MAX_VALUE;
		String res = "";
		int start = 0;
		for (int end = 0; end < S.length(); end++){
			char c = S.charAt(end);
			if (map.containsKey(c)){
				map.put(c, map.get(c) -1);
				if (map.get(c) >= 0){
					count++;
					if (count == T.length()){
						for (; start <= end; start++){
							char c2 = S.charAt(start);
							if (map.containsKey(c2)){
								map.put(c2, map.get(c2) + 1);
								if (map.get(c2) > 0){
									count --;
									String sub = S.substring(start, end + 1);
									if (sub.length() < min){
										min = sub.length();
										res = sub;
									}
									start++;
									break;
								}
							}
						}
					}
				}
			}
		}
		return res;
		
	}

}
