package algorithm.leetcode;

public class Trie {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("app");
		trie.insert("apple");
		trie.search("apps");
		boolean res = trie.search("app");
		System.out.println(res);
	}

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		insert(root, word);
	}

	private void insert(TrieNode node, String word) {
		if (word.length() == 0) {
			node.end = true;
			return;
		}
		int index = (int) (word.charAt(0) - 'a');
		if (node.children[index] == null){
			node.children[index] = new TrieNode();
		}
		insert(node.children[index], word.substring(1));
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		return search(root, word);
	}

	private boolean search(TrieNode node, String word) {
		if (node == null) {
			return false;
		}
		if (word.length() == 0) {
			return node.end;
		}
		int index = (int) (word.charAt(0) - 'a');
		return search(node.children[index], word.substring(1));
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		return startsWith(root, prefix);
	}

	private boolean startsWith(TrieNode node, String prefix) {
		if (node == null) {
			return false;
		}
		if (prefix.length() == 0) {
			return true;
		}
		int index = (int) (prefix.charAt(0) - 'a');
		return startsWith(node.children[index], prefix.substring(1));
	}

	class TrieNode {
		boolean end;
		TrieNode[] children;

		// Initialize your data structure here.
		public TrieNode() {
			children = new TrieNode[26];
		}
		
		public String toString(){
			return "" + end;
		}
	}
}
