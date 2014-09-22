package algorithm.datastructure;

public class TreeNode<T> {

	public T key;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode(T t){
		this.key = t;
		left = null;
		right = null;
	}
}
