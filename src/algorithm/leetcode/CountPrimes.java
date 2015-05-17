package algorithm.leetcode;

import java.util.Arrays;

public class CountPrimes {

	public static void main(String[] args) {
		new CountPrimes().countPrimes(50);
	}

	public int countPrimes(int n) {
        if (n < 2){
            return 0;
        }
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i <= Math.sqrt(n); i++){
        	if (prime[i]){
        		for (int j = 2; i * j <= n; j++){
        			prime[i * j] = false;
        		}
        	}
        }
        
        int count = 0;
        for (int i = 2; i <= n; i++){
        	if (prime[i]){
        		count ++;
        	}
        }
        return count;
    }
    
}
