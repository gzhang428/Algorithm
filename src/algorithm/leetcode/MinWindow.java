package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

	public static void main(String[] args) {
		String res = new MinWindow().minWindow("ADOBECODEBANC", "ABC");
		System.out.println(res);
	}

	public String minWindow(String s, String t) {
		Map<Character, Integer> needToFind = new HashMap<>();
		Map<Character, Integer> hasFound = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (needToFind.containsKey(c)) {
				needToFind.put(c, needToFind.get(c) + 1);
			} else {
				needToFind.put(c, 1);
			}
			hasFound.put(c, 0);
		}
		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		String res = "";
		int len = 0;
		for (; end < s.length(); end++) {
			char c = s.charAt(end);
			if (!hasFound.containsKey(c))
				continue;
			hasFound.put(c, hasFound.get(c) + 1);
			if (hasFound.get(c) <= needToFind.get(c)) {
				len++;
			}

			if (len == t.length()) {
				for (; start <= end; start++) {
					char c2 = s.charAt(start);
					if (!hasFound.containsKey(c2))
						continue;
					hasFound.put(c2, hasFound.get(c2) - 1);
					if (hasFound.get(c2) < needToFind.get(c2)) {
						len--;
						if (end - start + 1 < min) {
							min = end - start + 1;
							res = s.substring(start, end + 1);
						}
						start++;
						break;
					}
				}
			}
		}
		return res;
	}

}
