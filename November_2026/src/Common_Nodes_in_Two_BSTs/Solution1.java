package Common_Nodes_in_Two_BSTs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Node {
	int data;
	Node left;
	Node right;

	Node(int val) {
		this.data = val;
		this.left = null;
		this.right = null;
	}
}

class BinarySearchTree {
	Node build(int val, Node root) {
		if (root == null) {
			return new Node(val);
		}

		if (val < root.data) {
			root.left = build(val, root.left);
		} else {
			root.right = build(val, root.right);
		}
		return root;
	}
}

public class Solution1 {
	public static void main(String[] args) {
		int[] r1 = { 5, 1, 10, 0, 4, 7, 9 };
		int[] r2 = { 10, 7, 20, 4, 9 };

		BinarySearchTree bst = new BinarySearchTree();

		Node root1 = null;
		for (int ele : r1) {
			root1 = bst.build(ele, root1);
		}

		Node root2 = null;
		for (int ele : r2) {
			root2 = bst.build(ele, root2);
		}

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findCommon(root1, root2));
	}

	HashSet<Integer> set1 = new HashSet<>();
	HashSet<Integer> set2 = new HashSet<>();

	public ArrayList<Integer> findCommon(Node r1, Node r2) {
		inOrder1(r1);
		inOrder2(r2);

		ArrayList<Integer> res = new ArrayList<>();
		for (int ele : set1) {
			if (set2.contains(ele)) {
				res.add(ele);
			}
		}

		Collections.sort(res);
		return res;
	}

	private void inOrder1(Node root) {
		if (root == null) {
			return;
		}
		inOrder1(root.left);
		set1.add(root.data);
		inOrder1(root.right);
	}

	private void inOrder2(Node root) {
		if (root == null) {
			return;
		}

		inOrder2(root.left);
		set2.add(root.data);
		inOrder2(root.right);
	}
}
