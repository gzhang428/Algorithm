package algorithm.leetcode;

public class Exist {

	public static void main(String[] args) {
		char[][] board = { { 'a', 'b', 'c', 'e' },{'s', 'f', 'e', 's'}, {'a', 'd', 'e', 'e'} };
		boolean res = new Exist().exist(board, "abceseeefs");
		System.out.println(res);
	}

	public boolean exist(char[][] board, String word) {
		int n = board.length;
		int m = board[0].length;
		char firstChar = word.charAt(0);
		for (int i = 0; i < n; i++){
			for (int j = 0; j < m; j++){
				char c = board[i][j];
				if (c == firstChar){
					boolean[][] used = new boolean[n][m];
					boolean res = exist(board, word, i, j, "" + c, used);
					if (res){
						return true;
					}
				}
			}
		}
		
		return false;
	}

	private boolean exist(char[][] board, String word, int i, int j, String str, boolean[][] used) {
		if (str.equals(word)){
			return true;
		}
		used[i][j] = true;
		boolean t = false;
		char nextChar = word.charAt(str.length());
		if (i > 0 && !used[i - 1][j] && board[i - 1][j] == nextChar) {
			t = exist(board, word, i - 1, j, str + nextChar, used);
		}
		if (i < board.length - 1 && !used[i + 1][j] && board[i + 1][j] == nextChar) {
			t = t || exist(board, word, i + 1, j, str + nextChar, used);
		}
		if (j > 0 && !used[i][j - 1] && board[i][j - 1] == nextChar) {
			t = t || exist(board, word, i, j - 1, str + nextChar, used);
		}
		if (j < board[0].length - 1 &&  !used[i][j + 1] && board[i][j + 1] == nextChar) {
			t = t || exist(board, word, i, j + 1, str + nextChar, used);
		}
		used[i][j] = false;
		return t;
		
	}

}
