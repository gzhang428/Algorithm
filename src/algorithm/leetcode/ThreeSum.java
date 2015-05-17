package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		int[] num = {-9,14,-7,-8,9,1,-10,-8,13,12,6,9,3,-3,-15,-15,1,8,-7,-4,-6,8,2,-10,8,11,-15,3,0,-11,-1,-1,10,0,6,5,-14,3,12,-15,-7,-5,9,11,-1,1,3,-15,-5,11,-12,-4,-4,-2,-6,-10,-6,-6,0,2,-9,14,-14,-14,-9,-1,-2,-7,-12,-13,-15,-4,-3,1,14,3,-12,3,3,-10,-9,-1,-7,3,12,-6,0,13,4,-15,0,2,6,1,3,13,8,-13,13,11,11,13,14,-6};
		List<List<Integer>> res = new ThreeSum().threeSum(num );
		System.out.println(res);
	}

	
	public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        
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
