package algorithm.leetcode;

import java.util.Arrays;

public class SpiralMatrix2 {

	public static void main(String[] args) {
		int[][] res = new SpiralMatrix2().generateMatrix(4);
		System.out.println(Arrays.deepToString(res));
	}
	
	 public int[][] generateMatrix(int n) {
	     
	        int[][] res = new int[n][n];
	        int a = 1;
	        for (int i = 0; i <= n / 2; i++){
	        	int k = n - 1-  2 * i;
	            for (int j = i; j < n - 1 - i; j++){
	                res[i][j] = a;
	                res[j][n - 1 - i] = a + k;
	                res[n - 1- i][n - 1 - j] = a + 2 * k;
	                res[n - 1 - j][i] = a + 3 * k;
	                a ++;
	            }
	            a += 3 * k ;
	        }
	        if( a == n * n){
	            res[n / 2][n / 2] = a;
	        }
	        return res;
	        
	    }

}
