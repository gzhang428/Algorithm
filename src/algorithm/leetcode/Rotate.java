package algorithm.leetcode;

public class Rotate {

	public static void main(String[] args) {
		int[][] matrix = {{1,2}, {3,4}};
		new Rotate().rotate(matrix );
	}

	public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                res[j][n - 1 -i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = res[i][j];
            }
        }
    }
}
