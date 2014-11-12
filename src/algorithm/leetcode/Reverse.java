package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Reverse {

	public static void main(String[] args) {
		int res = new Reverse().reverse(-32100);
		System.out.println(res);
	}

	private int reverse(int x) {
		if (x == 0){
			return 0;
		}
		boolean negative = x < 0;
        int s = Math.abs(x);
        
        String str = String.valueOf(s);
        char[] chars = str.toCharArray();
        List<Character> reversed = new ArrayList<>();
        boolean startZero = true;
        for (int i = chars.length - 1; i >= 0; i--){
        	if (chars[i] == '0'){
        		if (!startZero){
        			reversed.add(chars[i]);
        		}
        	} else{
        		startZero = false;
        		reversed.add(chars[i]);
        	}
        }
        char[] newChars = new char[reversed.size()];
        for (int i = 0; i < reversed.size(); i++){
        	newChars[i] = reversed.get(i);
        }
        String newStr = new String(newChars);
		int newVal = Integer.parseInt(newStr);
		return negative? (-newVal): newVal;
	}

}
