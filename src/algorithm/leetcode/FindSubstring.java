package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {

	public static void main(String[] args) {
		String S = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		List<Integer> res = new FindSubstring().findSubstring(S, L);
		System.out.println(res);
	}

	 public List<Integer> findSubstring(String S, String[] L) {
	        List<Integer> res = new ArrayList<>();
	        int l = L[0].length();
	        int start = 0;
	        Map<String, Integer> map = createMap(L); 
	        boolean started = false;
	        int i = 0;
	        while(i <= S.length() - l ){
	        	String str = S.substring(i, i + l);
	        
	        	if (map.containsKey(str)){
	        		if (!started){
	        			started = true;
	        			start = i;
	        		}
	        		map.put(str, map.get(str) - 1);
	    			if (map.get(str) == 0){
	    				map.remove(str);
	    			}
	    			if (map.size() == 0){
	    				res.add(start);
	    				started = false;
	    				map = createMap(L);
	    				i  = start + 1;
	    				continue;
	    			}
	    			i = i + l;
	        	
	        	} else {
	        		if (started) {
	        			started = false;
	        			map = createMap(L);
	        			i = start + 1;
	        		} else {
	        			i ++;
	        			
	        		}
	        	}
	        }
	        return res;
	        
	    }

	private Map<String, Integer> createMap(String[] L) {
		Map<String, Integer> map = new HashMap<>();
        for (String s: L){
        	if (map.containsKey(s)){
        		map.put(s, map.get(s) + 1);
        	} else{
        		map.put(s, 1);
        	}
        }
        return map;
	}
}
