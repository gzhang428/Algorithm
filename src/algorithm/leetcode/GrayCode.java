package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		List<Integer> res = new GrayCode().grayCode(3);
		System.out.println(res);
	}
	public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0){
            res.add(0);
            return res;
        }
            res.add(0);
            res.add(1);
        for (int i = 2; i <= n; i++){
            for (int j = res.size() - 1; j >= 0; j--){
            	res.add(res.get(j) + (1 << (i - 1)));
            }
        }
        return res;
    }
}
