package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {

	public static void main(String[] args) {
		//int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11 ,12}};
		int[][] matrix = {{1}};
		List<Integer> res = new SprialMatrix().spiralOrder(matrix );
		System.out.println(res);
	}
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        for (; i < Math.min(m, n) / 2; i++){
            for (int j = i; j < n - 1 - i; j++){
                res.add(matrix[i][j]);
            }
            for (int j = i; j < m - 1 - i; j++){
                res.add(matrix[j][n - 1 - i]);
            }
            for (int j = n - 1 - i; j > i; j--){
                res.add(matrix[m - 1 - i][j]);                
            }
            for (int j = m - 1 -i; j > i; j--){
                res.add(matrix[j][i]);            
            }
        }
        if (m > n && n % 2 == 1){
        	for (int j = i; j < m - i; j++){
        		res.add(matrix[j][i]);
        	}
        } else if (m <= n && m % 2 == 1){
        	for (int j = i; j < n  - i; j++){
        		res.add(matrix[i][j]);
        	}
        }
        

        return res;
    }

}
