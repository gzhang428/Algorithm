package algorithm.datastructure;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
	private TreeNode<T> root;
	
	public BinarySearchTree(){
		root = null;
	}

	boolean isEmpty(){
		return root == null;
	}

	public void insert(T t){
		root = insert(root, t);
	}
	
	private TreeNode<T> insert(TreeNode<T> node, T t) {
		if (node == null){
			return new TreeNode<T>(t);
		}
		
		if (t.compareTo(node.key) <= 0){
			node.left = insert(node.left, t);
		} else {
			node.right = insert(node.right, t);
		}
		node.size ++;
		return node;
	}

	public void delete(T t){
		root = delete(root, t);
	}
	
	private TreeNode<T> delete(TreeNode<T> node, T t) {
		if (node == null){
			throw new RuntimeException("Cannot find element");
		}
		
		if (t.compareTo(node.key) < 0){
			node.left = delete(node.left, t);
		} else if (t.compareTo(node.key) > 0){
			node.right = delete(node.right, t);
		} else {
			if (node.left != null && node.right != null){
				TreeNode<T> replaceNode = maxSubtreeNode(node.left);
				node.left = delete(node.left, replaceNode.key);
				replaceNode.left = node.left;
				replaceNode.right = node.right;
				replaceNode.size = node.left.size + node.right.size + 1;
				return replaceNode;
			} else if (node.left != null && node.right == null){
				return node.left;
			} else if (node.left == null && node.right != null){
				return node.right;
			} else {
				return null;
			}
		}
		node.size --;
		return node;
	}

	public boolean search(T t){
		return search(root, t);
	}
	
	private boolean search(TreeNode<T> node, T t) {
		if (node == null){
			return false;
		}
		
		if (t.compareTo(node.key) == 0){
			return true;
		} else if (t.compareTo(node.key) < 0){
			return search(node.left, t);
		} else {
			return search(node.right, t);
		}
	}

	public T min(){
		if (isEmpty()){
			throw new RuntimeException();
		}
		return min(root);
	}
	
	private T min(TreeNode<T> node) {
		if (node.left == null){
			return node.key;
		}
		
		return min(node.left);
	}

	private TreeNode<T> minSubtreeNode(TreeNode<T> node){
		while(node.left != null){
			node = node.left;
		}
		return node;
	}

	
	public T max(){
		if (isEmpty()){
			throw new RuntimeException();
		}
		return max(root);
	}
	
	private T max(TreeNode<T> node) {
		if (node.right == null){
			return node.key;
		}
		return max(node.right);
	}

	private TreeNode<T> maxSubtreeNode(TreeNode<T> node){
		while(node.right != null){
			node = node.right;
		}
		return node;
		
	}
	
	public void preOrderTraversal() {
		preOrderTraversal(root);
		System.out.println();
	}
	
	private void preOrderTraversal(TreeNode<T> node){
		if (node != null){
			System.out.print(node.key + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public void postOrderTraversal(){
		postOrderTraversal(root);
		System.out.println();
	}
	
	private void postOrderTraversal(TreeNode<T> node) {
		if (node != null){
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.key + " ");
		}
	}

	// all nodes from smallest to largest
	public void inOrderTraversal(){
		inOrderTraversal(root);
		System.out.println();
	}
	private void inOrderTraversal(TreeNode<T> node) {
		if (node != null){
			inOrderTraversal(node.left);
			System.out.print(node.key + " ");
			inOrderTraversal(node.right);
		}
	}
	
	public void levelOrderTraversal(){
		Queue<TreeNode<T>> queue = new LinkedNodeQueue<>();
		queue.enqueue(root);
		while(!queue.isEmpty()){
			TreeNode<T> node = queue.dequeue();
			if (node != null){
				System.out.print(node.key + " ");
				queue.enqueue(node.left);
				queue.enqueue(node.right);
			}
		}
		System.out.println();
	}

	public void levelOrderTraversal2(){
		List<TreeNode<T>> currentLevel = new ArrayList<>();
		List<TreeNode<T>> nextLevel = new ArrayList<>();

		currentLevel.add(root);
		while (!currentLevel.isEmpty()) {
			for (TreeNode<T> node : currentLevel){
				if (node != null){
					nextLevel.add(node.left);
					nextLevel.add(node.right);
					System.out.print(node.key + ":" + node.size + " ");
				}
			}
			System.out.println();
			currentLevel = nextLevel;
			nextLevel = new ArrayList<>();
		}

	}
	
	
	public T predecessor(T t){
		TreeNode<T> current = root;
		TreeNode<T> predecessor = null;
		
		while(current !=  null){
			if (t.compareTo(current.key) < 0){
				current = current.left;
			} else if (t.compareTo(current.key) > 0){
				predecessor = current;
				current = current.right;
			} else {
				if (current.left != null){
					return maxSubtreeNode(current.left).key;
				} else {
					if (predecessor != null){
						return predecessor.key;
					} else{
						throw new RuntimeException("No Predecessor Found");
					}
				}
			}
		}
		throw new RuntimeException("No such element");
	}
	
	
	
	public T successor(T t){
		TreeNode<T> current = root;
		TreeNode<T> successor = null;
		while(current != null){
			if (t.compareTo(current.key)  < 0){
				successor = current;
				current = current.left;
			} else if (t.compareTo(current.key) > 0){
				current = current.right;
			} else {
				if (current.right != null){
					return minSubtreeNode(current.right).key;
				} else{
					if(successor != null){
						return successor.key;
					} else {
						throw new RuntimeException("No Predecessor Found");
					}
				}
			}
		}
		throw new RuntimeException("No such element");
	}
	
	public int size(){
		return size(root);
	}
	
	
	private int size(TreeNode<T> node) {
		if (node == null){
			return 0;
		}
		return size(node.left) + size(node.right) + 1;
	}

	public int height(){
		return height(root);
	}
	
	
	private int height(TreeNode<T> node) {
		if (node == null){
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public int leafNodes(){
		return leafNodes(root);
	}
	private int leafNodes(TreeNode<T> node) {
		if (node == null){
			return 0;
		}
		
		if (node.left == null && node.right == null){
			return 1;
		}
		
		return leafNodes(node.left) + leafNodes(node.right);
	}

	
	public int width(){
		int height = height();
		int max  = 0;
		for (int i = 1; i <= height; i++){
			int width = width(root, i);
			if (width > max){
				max = width;
			}
		}
		return max;
	}
	
	private int width(TreeNode<T> node, int i) {
		if (node  == null){
			return 0;
		}
		if (i == 1){
			return 1;
		}
		
		return width(node.left, i - 1) + width(node.right, i - 1);
	}

	 public int diameter(){
		 return diameter(root);
	 }
	
	private int diameter(TreeNode<T> node) {
		if (node == null){
			return 0;
		}
		
		int crossRoot = height(node.left) + height(node.right) + 1;
		int leftSubtree = diameter(node.left);
		int rightSubtree = diameter(node.right);
		return Math.max(crossRoot, Math.max(leftSubtree, rightSubtree));
	}
	
	
	public T select(int rank){
		return select(root, rank);
	}
	
	private T select(TreeNode<T> node, int rank) {
		if (node == null){
			throw new RuntimeException("Cannot find element");
		}
		int currentRank = size(node.left) + 1;
		if (rank < currentRank){
			return select(node.left, rank);
		} else if (rank > currentRank){
			return select(node.right, rank - currentRank);
		} else {
			return node.key;
		}
	}

	public int rank(T t){
		return rank(root, t);
	}

	private int rank(TreeNode<T> node, T t) {
		if (node == null){
			throw new RuntimeException("Cannot find element");
		}
		
		if (t.compareTo(node.key) < 0){
			return rank(node.left, t);
		} else if (t.compareTo(node.key) > 0){
			return size(node.left) + rank(node.right, t) + 1;
		} else {
    		return size(node.left) + 1;
		}
	}
	

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(5);
		tree.insert(7);
		tree.insert(3);
		tree.insert(4);
		tree.insert(9);
		tree.insert(1);
		tree.insert(6);
		tree.insert(2);
		tree.insert(8);
		tree.delete(3);
		tree.levelOrderTraversal2();
		System.out.println(tree.rank(1));
		System.out.println(tree.select(7));
	}
	
//	public boolean search(T t){
//		TreeNode<T> node = root;
//		while(node != null){
//			if (t.compareTo(node.key) == 0){
//				return true;
//			} else if (t.compareTo(node.key) < 0){
//				node = node.left;
//			} else {
//				node = node.right;
//			}
//		}
//		return false;
//	}
//	
//	public void insert(T t){
//		TreeNode<T> newNode = new TreeNode<>(t);
//		if (isEmpty()){
//			root = newNode;
//			return;
//		}
//		
//		TreeNode<T> p = null;
//		TreeNode<T> node = root;
//		while(node != null){ 
//			p = node;
//			if (t.compareTo(node.key) <= 0){
//				node = node.left;
//			} else if (t.compareTo(node.key) > 0){
//				node = node.right;
//			} 
//		}
//		if (t.compareTo(p.key) <= 0){
//			p.left = newNode;
//		} else {
//			p.right = newNode;
//		}
//	}
//	
//
//	// too complicated
//	public void delete(T t){
//		if (isEmpty()){
//			throw new RuntimeException("Empty Tree");
//		}
//		if (t.compareTo(root.key) == 0){
//			if (root.left == null && root.right == null){
//				root = null;
//			}  else if (root.left != null && root.right == null){
//				root = root.left;
//			} else if (root.right  != null && root.left == null){
//				root = root.right;
//			} else{
//				TreeNode<T> replaceNode = max(root.left);
//				delete(replaceNode.key);
//				replaceNode.left = root.left;
//				replaceNode.right = root.right;
//				root = replaceNode;
//			}
//			return;
//		}
//		
//		boolean isLeftChild = false;
//		TreeNode<T> p = null;
//		TreeNode<T> node = root;
//		while(node != null){
//			if (t.compareTo(node.key) < 0){
//				p = node;
//				node = node.left;
//				isLeftChild = true;
//			} else if (t.compareTo(node.key) > 0){
//				p = node;
//				node = node.right;
//				isLeftChild = false;
//			} else {
//				if (node.left == null && node.right == null){
//					if (isLeftChild){
//						p.left = null;
//					} else {
//						p.right = null;
//					}
//				}  else if (node.left != null && node.right == null){
//					if (isLeftChild){
//						p.left = node.left;
//					} else{
//						p.right = node.left;
//					}
//				} else if (node.right  != null && node.left == null){
//					if (isLeftChild){
//						p.left = node.right;
//					} else{
//						p.right = node.right;
//					}
//				} else{
//					TreeNode<T> replaceNode = max(node.left);
//					delete(replaceNode.key);
//					replaceNode.left = node.left;
//					replaceNode.right = node.right;
//					if (isLeftChild){
//						p.left = replaceNode;
//					} else{
//						p.right = replaceNode;
//					}
//				}
//				return;
//			}
//		}
//		throw new RuntimeException("Cannot find this element");
//		
//	}
//	public T min(){
//		if (isEmpty()){
//			throw new RuntimeException();
//		}
//		TreeNode<T> node = root;
//		while(node.left != null){
//			node = node.left;
//		}
//		return node.key;
//	}
//	
//	public T max(){
//		if (isEmpty()){
//			throw new RuntimeException();
//		}
//		TreeNode<T> node = root;
//		while(node.right != null){
//			node = node.right;
//		}
//		return node.key;
//	}

}
