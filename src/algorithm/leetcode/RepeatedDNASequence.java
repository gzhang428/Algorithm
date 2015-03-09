package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {

	public static void main(String[] args) {
		new RepeatedDNASequence().findRepeatedDnaSequences("AAAAAAAAAAAA");
	}
	
	 public List<String> findRepeatedDnaSequences(String s) {
	        Set<Integer> set = new HashSet<>();
	        List<String> list = new ArrayList<>();
	        
	        for (int i = 0; i < s.length() - 9; i ++){
	            String str = s.substring(i, i + 10);
	            int n = toInt(str);
	            if (set.contains(n)){
	                list.add(str);
	            } else {
	                set.add(n);
	            }
	        }
	        return list;
	    }
	    
	    private int toInt(String str){
	        int s = 0;
	        for (int i = 0; i < str.length(); i++){
	            char c = str.charAt(i);
	            if (c == 'A'){
	                s  = s << 2;
	            } else if (c == 'C'){
	                s = s << 2  | 1;
	            } else if (c == 'G'){
	                s = s << 2 | 2;
	            } else {
	                s = s << 2 | 3;
	            }
	            
	        }
	        return s;
	    }

}
