package algorithm.leetcode;

public class SudokuSolver {

	public static void main(String[] args) {

	}

	public void solveSudoku(char[][] board) {
		solve(board, 0, 0);
	}

	private boolean solve(char[][] board, int i, int j) {
		if (j == 9){
			return solve(board, i + 1, 0);
		}
		if (i == 9){
			return true;
		}
		if (board[i][j] == '.'){
			for (int k = 1; k <= 9; k++){
				board[i][j] = (char)('0' + k);
				if (isValid(board, i, j)){
					if (solve(board, i, j + 1)){
						return true;
					}
				}
			}
			board[i][j] = '.';
		} else {
			return solve(board, i, j + 1);
		}
		return false;
	}

	private boolean isValid(char[][] board, int row, int col) {
		char c = board[row][col];
		for (int j = 0; j < 9; j++){
			if (j != col && board[row][j] == c){
				return false;
			}
		}
		for (int i = 0; i < 9; i++){
			if (i != row && board[i][col] == c){
				return false;
			}
		}
		for (int i =  row - row % 3; i < row - row % 3 + 3; i++){
			for (int j = col - col % 3; j < col - col % 3 + 3; j++){
				if (i != row && j != col && board[i][j] == c){
					return false;
				}
			}
		}
		return true;
	}
}
