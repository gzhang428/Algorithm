package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {

	public static void main(String[] args) {
		new RepeatedDNASequence().findRepeatedDnaSequences("AAAAAAAAAAA");
	}
	
	 public List<String> findRepeatedDnaSequences(String s) {
	        Set<Integer> set = new HashSet<>();
	        List<String> res = new ArrayList<>();
	        for (int i = 0; i < s.length() - 10; i++){
	            String str = s.substring(i, i + 10);
	            int val = transfer(str);
	            if (set.contains(val)){
	                res.add(str);
	            } else {
	                set.add(val);
	            }
	        }
	        return res;
	    }
	    
	    private int transfer(String str){
	        int v = 0;
	        for (char c: str.toCharArray()){
	            if (c == 'A'){
	                v = v << 2;
	            } else if (c == 'C'){
	                v = v << 2 | 1;
	            } else if (c == 'G'){
	                v = v << 2 | 2;
	            } else if (c == 'T'){
	                v = v << 2 | 3;
	            }
	            
	        }
	        return v;
	    }

}
