package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringMatching {

	public static void main(String[] args) {
		String text = "bcbabaabcacabcbaba";
		String pattern  = "ababac";
		
		StringMatching stringMatching = new StringMatching();
//		int index = stringMatching.search(text, pattern);
//		System.out.println(index);
		
		int index2 = stringMatching.kmpSearch(text, pattern);
		System.out.println(index2);
	}

	public int kmpSearch(String text, String pattern) {
		List<Map<Character, Integer>> dfa = buildDFA(pattern);
		System.out.println(dfa);
		
		
		int j = 0;
		for (int i = 0; i < text.length(); i++ ){
			j = dfa.get(j).get(text.charAt(i));
			if (j == pattern.length()){
				return i - j + 1;
			}
				
		}
		return -1;
	}

	private List<Map<Character, Integer>> buildDFA(String pattern) {
		List<Map<Character, Integer>> dfa = new ArrayList<>();
		
		Set<Character> chars = new HashSet<>();
		for (char c: pattern.toCharArray()){
			chars.add(c);
		}
		
		
		Map<Character, Integer> initialState = new HashMap<>();
		for (Character c: chars){
			if (c == pattern.charAt(0)){
				initialState.put(c, 1);
			} else {
				initialState.put(c, 0);
			}
		}
		dfa.add(initialState);
		int x = 0;
		
		
		
		for (int i = 1; i < pattern.length(); i++){
			Map<Character, Integer> state = new HashMap<>();
			for (Character c: chars){
				if (c == pattern.charAt(i)){
					state.put(c, i + 1);
				} else{
					int backState = dfa.get(x).get(c);
					state.put(c, backState);
				}
			}
			dfa.add(state);
			x = dfa.get(x).get(pattern.charAt(i));
		}
		
		
		return dfa;
	}

	public int search(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		
		for (int i = 0; i <= n - m; i++){
			int j = 0;
			for (j = 0; j < m; j++){
				if (pattern.charAt(j) != text.charAt(i + j)){
					break;
				}
			}
			if (j == m){
				return i;
			}
		}
		return -1;
	}
	
	

}
