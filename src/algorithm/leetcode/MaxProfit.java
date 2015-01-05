package algorithm.leetcode;

public class MaxProfit {

	public static void main(String[] args) {
		int[] input = {1 , 2, 4};
		new MaxProfit().maxProfit(input);
		
	}

	public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1){
            return 0;
        }
        
        int n = prices.length;
        int low = prices[0];
        int[] profit = new int[n];
        
        for (int i = 1; i < n; i++){
            if (prices[i] < low){
                low = prices[i];
            }
            profit[i] = Math.max(profit[i - 1], prices[i] - low);
        }
        
        int[] profit2 = new int[n];
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--){
            if (prices[i] > max){
                max = prices[i];
            }
            profit2[i] = Math.max(profit2[i + 1], max - prices[i]);
        }
        
        int maxProfit = profit2[0];
        for (int i = 1; i < n; i++){
            if (profit[i] + profit2[i] > maxProfit){
                maxProfit = profit[i] + profit2[i];
            }
        }
        return maxProfit;
        
    }
	
	  public boolean isPalindrome(String s) {
	        if (s == null || s.length() == 0){
	            return true;
	        }
	        
	        int i = 0;
	        int j = s.length() - 1;
	        
	        while(i <= j){
	            char c1 = s.charAt(i);
	            if ( c1 >= 'A' && c1 <= 'Z'){
	                c1 = (char) (c1 - 'A' + 'a');
	            }
	            if (c1 < 'a'  || c1 > 'z'){
	                i ++;
	                continue;
	            }
	            
	            char c2 = s.charAt(j);
	            if ( c2 >= 'A' && c2 <= 'Z'){
	                c2 = (char)(c2 - 'A' + 'a');
	            }
	            if (c2 < 'a' || c2 > 'z'){
	                j --;
	                continue;
	            }
	            
	            if (c1 != c2){
	                return false;
	            }
	            
	        }
	        return true;
	    }

}
