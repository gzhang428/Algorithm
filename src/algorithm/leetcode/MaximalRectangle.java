package algorithm.leetcode;

import java.util.Stack;

public class MaximalRectangle {

	public static void main(String[] args) {
		char[][] matrix = { { '0', '1' }, { '1', '0' } };
		int res = new MaximalRectangle().maximalRectangle(matrix);
		System.out.println(res);
	}

	// public int maximalRectangle(char[][] matrix) {
	// if (matrix.length == 0 || matrix[0].length == 0){
	// return 0;
	// }
	// int m = matrix.length;
	// int n = matrix[0].length;
	// int max = 0;
	//
	// for (int i = 0; i < m; i++){
	// for (int j = 0; j < n; j ++){
	// if (matrix[i][j] == '1'){
	// int area = maxArea(matrix, i, j);
	// max = Math.max(max, area);
	// }
	// }
	// }
	// return max;
	// }
	//
	// private int maxArea(char[][] matrix, int row, int col) {
	// int m = matrix.length;
	// int n = matrix[0].length;
	// int right = n - 1;
	// int max = 0;
	// for (int i = row; i < m; i++){
	// for (int j = col; j <= right; j++){
	// if (matrix[i][j] != '1'){
	// right = j - 1;
	// break;
	// }
	// }
	// int area = (right - col + 1) * (i - row + 1);
	// max = Math.max(max, area);
	// }
	// return max;
	// }

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[] h = new int[n + 1];
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					h[j]++;
				} else {
					h[j] = 0;
				}
			}
			int area = getArea(h);
			res = Math.max(res, area);
		}
		return res;

	}

	private int getArea(int[] h) {
		Stack<Integer> s = new Stack<>();
		int i = 0;
		int res = 0;
		while (i < h.length) {
			if (s.isEmpty() || h[i] >= h[s.peek()]) {
				s.push(i);
				i++;
			} else {
				int t = s.pop();
				int area = h[t] * (s.isEmpty() ? i : (i - 1 - s.peek()));
				res = Math.max(res, area);
			}
		}
		return res;
	}
}
