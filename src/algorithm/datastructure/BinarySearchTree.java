package algorithm.datastructure;

public class BinarySearchTree<T> {
	private TreeNode<T> root;
	
	public BinarySearchTree(){
		root = null;
	}

	boolean isEmpty(){
		return root == null;
	}
	
	public T min(){
		if (isEmpty()){
			throw new RuntimeException();
		}
		TreeNode<T> node = root;
		while(node.left != null){
			node = node.left;
		}
		return node.data;
	}

	public T max(){
		if (isEmpty()){
			throw new RuntimeException();
		}
		TreeNode<T> node = root;
		while(node.right != null){
			node = node.right;
		}
		return node.data;
	}
	
	
	
	public static void main(String[] args) {

	}

}
