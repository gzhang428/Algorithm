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
		TreeNode<T> newNode = new TreeNode<>(t);
		if (isEmpty()){
			root = newNode;
			return;
		}
		
		TreeNode<T> p = null;
		TreeNode<T> node = root;
		while(node != null){ 
			p = node;
			if (t.compareTo(node.key) <= 0){
				node = node.left;
			} else if (t.compareTo(node.key) > 0){
				node = node.right;
			} 
		}
		if (t.compareTo(p.key) <= 0){
			p.left = newNode;
		} else {
			p.right = newNode;
		}
	}
	
	
	
	public void deleteRecursive(T t){
		root =  delete(root, t);
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
				TreeNode<T> replaceNode = max(node.left);
				node.left = delete(node.left, replaceNode.key);
				replaceNode.left = node.left;
				replaceNode.right = node.right;
				return replaceNode;
			} else if (node.left != null && node.right == null){
				return node.left;
			} else if (node.left == null && node.right != null){
				return node.right;
			} else {
				return null;
			}
		}
		return node;
	}

	public boolean search(T t){
		TreeNode<T> node = root;
		while(node != null){
			if (t.compareTo(node.key) == 0){
				return true;
			} else if (t.compareTo(node.key) < 0){
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return false;
	}
	
	public T min(){
		if (isEmpty()){
			throw new RuntimeException();
		}
		TreeNode<T> node = root;
		while(node.left != null){
			node = node.left;
		}
		return node.key;
	}
	
	private TreeNode<T> min(TreeNode<T> node){
		while(node.left != null){
			node = node.left;
		}
		return node;
	}

	public T max(){
		if (isEmpty()){
			throw new RuntimeException();
		}
		TreeNode<T> node = root;
		while(node.right != null){
			node = node.right;
		}
		return node.key;
	}
	
	private TreeNode<T> max(TreeNode<T> node){
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
					System.out.print(node.key + " ");
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
					return max(current.left).key;
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
					return min(current.right).key;
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
	
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(5);
		tree.insert(7);
		tree.insert(3);
		tree.insert(4);
		tree.insert(9);
		tree.insert(1);
		tree.insert(6);
		System.out.println(tree.max());
		tree.preOrderTraversal();
		tree.postOrderTraversal();
		tree.inOrderTraversal();
		tree.levelOrderTraversal();
		tree.levelOrderTraversal2();
//		System.out.println(tree.search(5));
//		System.out.println(tree.predecessor(3));
//		System.out.println(tree.successor(1));
		tree.deleteRecursive(5);
		tree.levelOrderTraversal2();
	
	}

	// too complicated
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

}
