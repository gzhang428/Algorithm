package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;


public class BuildTree {

	public static void main(String[] args) {
		int[] p = {1, 2};
		int[] i = {2, 1};
		
		new BuildTree().buildTree(p, i);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		public String toString(){
			return String.valueOf(val);
		}
	}
	  public TreeNode buildTree(int[] inorder, int[] postorder) {
	        if (inorder == null || inorder.length == 0){
	            return null;
	        }
	        Map<Integer, Integer> map = new HashMap<>();
	        for(int i = 0; i < inorder.length; i++){
	            map.put(inorder[i], i);
	        }
	        
	        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
	        
	    }
	    private TreeNode build(int[] inorder, int il, int ir, int[] postorder, int pl, int pr, Map<Integer, Integer> map){
	        if (il > ir || pl > pr){
	            return null;
	        }
	        
	        int     val = postorder[pr];
	        int pos = map.get(val);
	        TreeNode node = new TreeNode(val);
	        node.left = build(inorder, il, pos - 1, postorder, pl, pl + pos - il - 1, map);
	        node.right = build(inorder, pos + 1, ir,postorder, pl + pos - il, pr- 1,  map);
	        return node;
	    }
	    
}
