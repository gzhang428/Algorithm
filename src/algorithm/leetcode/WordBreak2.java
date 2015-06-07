package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak2 {

	public static void main(String[] args) {
		String[] words = { "aba","baa","bab","aaab","aaa","aaaa","aaba"};
		String[] b = {"ab", "aa"};
		char[][] board = new char[b.length][];
		for (int i = 0; i < b.length; i++){
			board[i] = b[i].toCharArray();
		}
		List<String> res = new WordBreak2().findWords(board, words);
		System.out.println(res);
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		if (board.length == 0 || board[0].length == 0) {
			return res;
		}
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		
		Trie trie = new Trie();
		for (String word: words){
			trie.add(word);
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				findWord(board, visited, i, j, trie.root, "", res);
			}
		}
		return res;
	}

	private void findWord(char[][] board, boolean[][] visited, int i, int j, TrieNode trieNode, String str, List<String> res) {
		if (trieNode.end && !trieNode.found){
			res.add(str);
			trieNode.found = true;
		}
		if (i < 0 || i >= board.length || j  < 0 || j >= board[0].length || visited[i][j]){
			return;
		}
		int index = (int) (board[i][j] - 'a');
		if (trieNode.children[index] == null){
			return;
		}
		
		visited[i][j] = true;
		String newStr = str + board[i][j];
		findWord(board, visited, i + 1, j, trieNode.children[index], newStr, res);
		findWord(board, visited, i - 1, j, trieNode.children[index], newStr, res);
		findWord(board, visited, i, j + 1, trieNode.children[index], newStr, res);
		findWord(board, visited, i, j - 1, trieNode.children[index], newStr, res);
		visited[i][j] = false;
	}
	 
	
	private class TrieNode {
		boolean end;
		boolean found;
		TrieNode[] children;
		
		public TrieNode(){
			children = new TrieNode[26];
		}
		
		public String toString(){
			return String.valueOf(end);
		}
	}
	
	private class Trie {
		TrieNode root;
		
		public Trie(){
			root = new TrieNode();
		}
		
		public void add(String word){
			add(word, root);
		}
		
		private void add(String word, TrieNode node){
			if (word.isEmpty()){
				node.end = true;
				return;
			}
			int index = (int)( word.charAt(0) - 'a');
			if (node.children[index] == null){
				node.children[index] = new TrieNode();
			}
			add(word.substring(1), node.children[index]);
			
		}
	}
}
