package algorithm.datastructure;

public class TreeNode<T> {

	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode(T t){
		this.data = t;
		left = null;
		right = null;
	}
}
