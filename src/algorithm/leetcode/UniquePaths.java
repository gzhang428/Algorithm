package algorithm.leetcode;

public class UniquePaths {

	public static void main(String[] args) {
		int res = new UniquePaths().uniquePaths(3, 3);
		System.out.println(res);
	}

	public int uniquePaths(int m, int n) {
	//	return find(m, n, 1, 1);
		
		int[][] a = new int[m][n];
		a[0][0] = 1;
		for (int i = 1; i < m; i++){
			a[i][0] = 1;
		}
		for (int i = 1; i < n; i++){
			a[0][i] = 1;
		}
		for (int i = 1; i < m; i ++){
			for (int j = 1; j < n; j++){
				a[i][j] = a[i - 1][j] + a[i][j - 1];
			}
		}
		
		return a[m - 1][n - 1];
	}

	public int find(int m, int n, int i, int j) {
		if (i == m && j == n) {
			return 1;
		}

		if (i == m) {
			return find(m, n, i, j + 1);
		}
		if (j == n) {
			return find(m, n, i + 1, j);
		}

		return find(m, n, i + 1, j) + find(m, n, i, j + 1);

	}
	
	

}
