package algorithm.leetcode;

public class MinimalSizeSubarraySum {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		int res = new MinimalSizeSubarraySum().minSubArrayLen(11, nums );
		System.out.println(res);
	}

	 public int minSubArrayLen(int s, int[] nums) {
	        int n = nums.length;
	        int sum = 0;
	        int start = 0;
	        int end = 0;
	        int min = Integer.MAX_VALUE;
	        while (end < nums.length){
	            sum += nums[end];
	            if (sum >= s){
	                while(start <= end){
	                    sum -= nums[start];
	                    if (sum < s){
	                        int len = end - start + 1;
	                        min = Math.min(min, len);
	                        start++;
	                        break;
	                    } 
	                    start++;
	                }
	            } 
	            end++;
	        }
	        return min == Integer.MAX_VALUE? 0: min;
	    }
}
