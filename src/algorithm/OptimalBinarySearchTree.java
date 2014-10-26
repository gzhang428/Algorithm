package algorithm;

import java.util.Arrays;

public class OptimalBinarySearchTree {

	public static void main(String[] args) {
		OptimalBinarySearchTree optimalBinarySearchTree = new OptimalBinarySearchTree();
		double[] freq = {0.2, 0.1, 0.04, 0.6, 0.06};
		optimalBinarySearchTree.build(freq);
	
	}

	private void build(double[] freq) {
		int n = freq.length;
		double[][] a = new double[n][n];
		int[][] root = new int[n][n];
		for (int s = 0; s < n; s++){ //so j = i + s
			for (int i = 0; i < n && i + s < n; i++){
				int j = i + s;
				double min = Double.MAX_VALUE;
				double sum = 0;
				for (int m = i; m <= j; m ++){
					sum += freq[m];
				}
				for (int k = i; k <= j; k ++){ // Kth node can be the node. i<=k<=j
					double thisSum = sum;
					if (i <= k - 1){
						thisSum += a[i][k - 1];
					}
					if (k + 1 <= j){
						thisSum += a[k + 1][j];
					}
					if (thisSum < min){
						min = thisSum;
						root[i][j] = k;
					}
				}
				a[i][j] = min;
			}
		}
		
		System.out.println(Arrays.deepToString(a));
		System.out.println(Arrays.deepToString(root));
	}

}
