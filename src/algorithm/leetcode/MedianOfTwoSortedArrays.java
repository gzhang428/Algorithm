package algorithm.leetcode;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] A =  {100000};
		int[] B =  {100001};
		double res = new MedianOfTwoSortedArrays().findMedianSortedArrays(A , B);
		System.out.println(res);
	}

	  public double findMedianSortedArrays(int A[], int B[]) {
	        int m = A.length;
	        int n = B.length;
	        if ( (m + n) % 2 == 0){
	            return (getMedian(A, 0, m,  B, 0, n, (m + n) / 2 - 1) + getMedian(A, 0, m , B, 0, n, (m + n) / 2)) / 2.0;
	        } else {
	            return getMedian(A, 0, m, B, 0, n, (m + n) / 2 );
	        }
	    }
	    
	    private int getMedian(int[] A, int start1, int l1, int[] B, int start2, int l2, int k){
	    	int m1 = start1 + l1 / 2;
	    	int m2 = start1 + l2 / 2;
	    	
	    	if (l1 <= 0){
	    		return B[start2 + k];
	    	}
	    	if (l2 <= 0){
	    		return A[start1 + k];
	    	}
	    	
	    	if (k == 0){
	    		return Math.min(A[start1], B[start2]);
	    	}
	    	
	    	if ( k < (l1 + l2) / 2){
	    		if (A[m1] < B[m2]){
	    			// drop b2
	    			return getMedian(A, start1, l1, B, start2, m2 - 1, k);
	    		} else {
	    			// drop a2
	    			return getMedian(A, start1, m1 - 1, B, start2, l2, k);
	    		}
	    	} else  if (k > (l1 + l2) / 2){
	    		if (A[m1] < B[m2]){
	    			// drop a1
	    			return getMedian(A, m1 + 1, l1 - m1 - 1, B, start2, l2, k - m1 - 1);
	    		} else{
	    			// drop b1
	    			return getMedian(A, start1, l1, B, m2 + 1 , l2 - m2 - 1, k - m2 - 1);
	    		} 
	    	} else if (A[m1] == B[m2]){
	    			return A[m1];
	    	}
	    	return 0;
	    
	    }
}
