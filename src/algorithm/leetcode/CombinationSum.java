package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

	public static void main(String[] args) {
		int[] num = {1};
		List<List<Integer>> res = new CombinationSum().combinationSum(num, 1);
		System.out.println(res);
	}

	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        Set<List<Integer>> res = new HashSet<>();
	        Arrays.sort(candidates);
	        List<Integer> r = new ArrayList<>();
	        find(candidates, target, 0, 0, res, r);
	        
	        List<List<Integer>> result = new ArrayList<>();
	        result.addAll(res);
	        return result;
	    }
	    
	    public void find(int[] candidates, int target, int start, int sum, Set<List<Integer>> res, List<Integer> r){
	        if (target == sum){
	            res.add(r);
	            return;      
	        } 
	        if (target < sum){
	            return;
	        }
	        
	        for (int i = start; i < candidates.length; i++){
	            int n = candidates[i];
	            r.add(n);
	            find(candidates, target, i, sum + n, res,   new ArrayList<Integer>(r));
	        }
	        

	    }
}
