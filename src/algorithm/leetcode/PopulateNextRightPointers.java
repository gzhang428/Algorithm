package algorithm.leetcode;

public class PopulateNextRightPointers {

	public static void main(String[] args) {
		TreeLinkNode n1 = new TreeLinkNode(2);
		TreeLinkNode n2 = new TreeLinkNode(1);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(0);
		TreeLinkNode n5 = new TreeLinkNode(7);
		TreeLinkNode n6 = new TreeLinkNode(9);
		TreeLinkNode n7 = new TreeLinkNode(1);
		TreeLinkNode n8 = new TreeLinkNode(2);
		TreeLinkNode n9 = new TreeLinkNode(1);
		TreeLinkNode n10 = new TreeLinkNode(0);
		TreeLinkNode n11 = new TreeLinkNode(8);
		TreeLinkNode n12 = new TreeLinkNode(8);
		TreeLinkNode n13 = new TreeLinkNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n8;
		n4.right = n9;
		n5.right = n10;
		n10.left = n13;
		n3.left = n6;
		n3.right = n7;
		n7.left = n11;
		n7.right = n12;
		new PopulateNextRightPointers().connect(n1);
	}

	public void connect(TreeLinkNode root) {

		if (root == null) {
			return;
		}

		TreeLinkNode p = root.next;

		while (p != null) {
			if (p.left != null) {
				p = p.left;
				break;
			}
			if (p.right != null) {
				p = p.right;
				break;
			}
			p = p.next;
		}

		if (root.right != null) {
			root.right.next = p;
		}

		if (root.left != null) {
			root.left.next = root.right == null ? p : root.right;
		}

		connect(root.right);
		connect(root.left);

	}

	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
		
		public String toString(){
			return val + "";
		}
	}

}
