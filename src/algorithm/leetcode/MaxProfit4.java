package algorithm.leetcode;

public class MaxProfit4 {

	public static void main(String[] args) {
		int[] prices = {1, 2, 4};
		new MaxProfit4().maxProfit(2, prices );
	}
	 public int maxProfit(int k, int[] prices) {
	        if (k > prices.length){
	            return getProfit(prices);
	        }
	        
	        int[] local = new int[k + 1];
	        int[] global = new int[k + 1];
	        for (int i = 1; i < prices.length; i++){
	            int diff = prices[i] - prices[i - 1];
	            for (int j = k; j >= 1; j--){
	                local[j] = Math.max(global[j - 1] + Math.max(0, diff), local[j] + diff);
	                global[j] = Math.max(global[j], local[j]);
	            }
	        }
	        return global[k];
	    }
	    
	    private int getProfit(int[] prices){
	        int res = 0;
	        for (int i = 1; i < prices.length; i++){
	            int diff = prices[i] - prices[i - 1];
	            res += Math.max(0, diff);
	        }
	        return res;
	        
	        
	    }

}
