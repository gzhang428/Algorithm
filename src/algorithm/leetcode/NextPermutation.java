package algorithm.leetcode;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int[] num = {2,3,1,3,3};
		new NextPermutation().nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}

	private void nextPermutation(int[] num) {
		  if (num == null || num.length < 2){
	            return;
	        }
	        int i = num.length - 1;
	        for (; i > 0; i--){
	            if (num[i - 1]  < num[i]){
	                break;                
	            }
	        }
	        
	        if (i == 0){
	            reverse(num, 0, num.length - 1);
	            return;
	        }
	        int a = num[i - 1];
	        int min = Integer.MAX_VALUE;
	        int k = i;
	        for (int j = i; j < num.length; j++){
	            if (num[j] > a && num[j] <= min){
	                min = num[j];
	                k = j;
	            }
	        }
	        
	        swap(num, i - 1, k);
	        reverse(num, i, num.length - 1);
	        
	    }
	    
	    public void reverse(int[] num, int start, int end){
	        int i = start;
	        int j = end;
	        while(i < j){
	            swap(num, i, j);
	            i ++;
	            j --;
	        }
	    }
	    
	    public void swap(int[] num, int i, int k){
	        int t = num[i];
	        num[i] = num[k];
	        num[k] = t;
	    }
}
