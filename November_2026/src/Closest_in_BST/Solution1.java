package Closest_in_BST;

class Node {
	int val;
	Node left;
	Node right;

	Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class BinaryTree {
	int index = -1;

	Node build(int[] arr) {
		index++;

		if (arr[index] == -1) {
			return null;
		}

		Node root = new Node(arr[index]);
		root.left = build(arr);
		root.right = build(arr);
		return root;
	}
}

public class Solution1 {
	public int minDiff(Node root, int k) {
		return solve(root, k);
	}

	private int solve(Node root, int k) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int left = solve(root.left, k);
		int right = solve(root.right, k);
		return Math.min(Math.abs(root.val - k), Math.min(left, right));
	}

	public static void main(String[] args) {
		int[] arr = { 10, 2, 1, -1, -1, 5, 3, -1, 4, -1, -1, 6, -1, -1, 11, -1, -1 };
		int k = 13;
		BinaryTree bt = new BinaryTree();
		Node root = bt.build(arr);

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minDiff(root, k));
	}
}
