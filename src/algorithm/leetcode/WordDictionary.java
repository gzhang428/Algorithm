package algorithm.leetcode;

public class WordDictionary {
    private class Node{
        boolean end;
        Node[] children;
        public Node(){
            children = new Node[26];
        }
    }
    private Node root;
    public WordDictionary(){
        root = new Node();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        addWord(word, root);
    }
    
    private void addWord(String word, Node node){
        if (word.isEmpty()){
            node.end = true;
            return;
        }
        int i = (int)(word.charAt(0) - 'a');
        if (node.children[i] == null){
            node.children[i] = new Node();
        }
        addWord(word.substring(1), node.children[i]);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }
    
    private boolean search(String word, Node node){
        if (word.isEmpty() ){
            return node.end;
        }
        if (node == null){
            return false;
        }
        char c = word.charAt(0);
        if (c == '.'){
            for (int i = 0; i < 26; i++){
                if (search(word.substring(1), node.children[i])){
                    return true;
                }
            }
        } else {
            return search(word.substring(1), node.children[(int)(c - 'a')]);
        }
        return false;
        
    }
    
    public static void main(String[] args){
    	WordDictionary w = new WordDictionary();
    	w.search("a");
    }
}