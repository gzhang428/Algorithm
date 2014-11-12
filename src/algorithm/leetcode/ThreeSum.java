package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		int[] num = {0, 0, 0, 0};
		List<List<Integer>> res = new ThreeSum().threeSum(num );
		System.out.println(res);
	}

	
	public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length < 3){
            return res;
        }
        
        Arrays.sort(num);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < num.length - 2; i++){
            int a = num[i];
            if (a > 0){
                break;
            }
            
            int j = i + 1;
            int k = num.length - 1;
            
            while(j < k){
                int b = num[j];
                int c = num[k];
                
                if (b + c == -a){
                    List<Integer> r = new ArrayList<>();
                    r.add(a);
                    r.add(b);
                    r.add(c);
                    set.add(r);
                    j ++;
                    k --;
                } else if (b + c < -a){
                    j ++;
                } else{
                    k --;
                }
            }
        }
        res.addAll(set);
        return res;
	}
}
