package algorithm.leetcode;

import java.util.Arrays;

public class FindMedianSortedArrays {

	public static void main(String[] args) {
		FindMedianSortedArrays medianOf2SortedArrays = new FindMedianSortedArrays();
		int[] A = {1, 2};
		int[] B = {1, 2};
		double res = medianOf2SortedArrays.findMedianSortedArrays(A, B);
		System.out.println(res);
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
        int n = A.length;
        int m = B.length;
        int k = 0;
        int i = 0;
        int j = 0;
        int[] res = new int[n + m];
        
        while(i < n && j < m){
            if (A[i] <= B[j]){
                res[k] = A[i];
                k ++;
                i ++;
            } else {
                res[k] = B[j];
                k ++;
                j ++;
            }
        }
        
        while(i < n){
            res[k] = A[i];
            k ++;
            i ++;
        }
        
        while(j < m){
            res[k] = B[j];
            k ++;
            j ++;
        }
        
        System.out.println(Arrays.toString(res));
        if (res.length % 2 == 0){
            return (res[res.length / 2] + res[res.length / 2 - 1]) /2.0;
        } else{
            return res[res.length / 2 ];
        }
    }

}
