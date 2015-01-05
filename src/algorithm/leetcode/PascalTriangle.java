package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		new PascalTriangle().generate(3);
	}
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0){
            return res;
        }
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        res.add(row1);
        if (numRows == 1){
           return res;
        }
        for (int i = 2; i <= numRows; i++){
            int[] row = new int[i];
            row[0] = 1;
            row[i - 1] = 1;
            for (int j = 1; j < i - 1; j++){
                row[j] = res.get(i - 2).get(j - 1) + res.get(i - 2).get(j);
            }
            List<Integer> rowList = new ArrayList<>();
            for (int k : row){
                rowList.add(k);
            }
            res.add(rowList);
        }
        return res;
    }
	
	
	    

}
