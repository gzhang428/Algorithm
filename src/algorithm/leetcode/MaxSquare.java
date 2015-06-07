package algorithm.leetcode;

import java.util.Stack;

public class MaxSquare {

	public static void main(String[] args) {
		String[] strs = { "10100", "10111", "11111", "10010" };
		int n = strs.length;
		char[][] matrix = new char[n][];
		for (int i = 0; i < n; i++) {
			matrix[i] = strs[i].toCharArray();
		}
		int res = new MaxSquare().maximalSquare(matrix);
		System.out.println(res);
	}

	public int maximalSquare(char[][] matrix) {
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
		int res = 0;
		int i = 0;
		while (i < h.length) {
			if (s.isEmpty() || h[i] >= h[s.peek()]) {
				s.push(i);
				i++;
			} else {
				int t = s.pop();
				int k = s.isEmpty() ? i : i - s.peek() - 1;
				if (k >= h[t]) {
					res = Math.max(res, h[t] * h[t]);
				}
			}
		}
		return res;
	}
}
