package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate3 {

	public static void main(String[] args) {
		int[] nums = {-1,2147483647};
		new ContainsDuplicate3().containsNearbyAlmostDuplicate(nums , 1,2147483647);
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if (n == 0 || t < 0 || k < 1){
            return false;
        }
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            int num = nums[i];
            long bucket = ((long)num + Integer.MAX_VALUE) / ((long)t + 1);
            if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && (long)num - map.get(bucket - 1) <= t)
                || (map.containsKey(bucket + 1) && map.get(bucket + 1) - (long)num <= t)){
                    return true;
                }
                if (map.size() == k){
                    long bucketToRemove = ((long)nums[i - k] + Integer.MAX_VALUE) / ((long)t + 1);
                    map.remove(bucketToRemove);
                }
                map.put(bucket, num);
           
        } 
        return false;
        
    }
}
