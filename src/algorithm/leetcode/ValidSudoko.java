package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoko {

	public static void main(String[] args) {
		char[][] board = { ".87654321".toCharArray(),
				"2........".toCharArray(), "3........".toCharArray(),
				"4........".toCharArray(), "5........".toCharArray(),
				"6........".toCharArray(), "7........".toCharArray(),
				"8........".toCharArray(), "9........".toCharArray(), };
		new ValidSudoko().isValidSudoku(board );
	}

	public boolean isValidSudoku(char[][] board) {
        int n = 9;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            set.clear();
            for (int j = 0; j < n; j++){
                int val = board[i][j] - '0';
                if (val < 1 || val  > 9 || set.contains(val)){
                    return false;
                }
                set.add(val);
            }
        }
        for (int j = 0; j < n; j++){
            set.clear();
            for (int i = 0; i < n; i++){
                int val = board[i][j] - '0';
                if (val < 1 || val  > 9 || set.contains(val)){
                    return false;
                }
                set.add(val);
            }
        }
        for (int x = 0; x < n; x += 3){
            for (int y = 0; y < n; y += 3){
                set.clear();
                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){
                        int val = board[x + i][y + j] - '0';
                        if (val < 1 || val  > 9 || set.contains(val)){
                            return false;
                        }
                        set.add(val);
                    }
                }
            }
        }
        return true;
    }
}
