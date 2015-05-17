package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenation {

	public static void main(String[] args) {
		String[] words = { "foo","bar"};
		String s = "barfoothefoobarman";
		List<Integer> res = new SubstringWithConcatenation().findSubstring(s, words);
		System.out.println(res);
	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		int n = words.length;
		int l = words[0].length();
		int len = n * l;
		Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - len; i++){
            reset(map, words);
            String str = s.substring(i, i + len);
            int j = i;
            for (; j < i + len; j += l){
                String str2 = s.substring(j, j + l);
                if (map.containsKey(str2)){
                    map.put(str2, map.get(str2) - 1);
                    if (map.get(str2) < 0){
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j == i + len){
                res.add(i);
            }
        }
	
		return res;

	}

	private void reset(Map<String, Integer> map, String[] words) {
		map.clear();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}
	}

}
