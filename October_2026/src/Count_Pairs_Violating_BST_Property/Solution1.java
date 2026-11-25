package Count_Pairs_Violating_BST_Property;

import java.util.ArrayList;

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

	void print(Node root) {
		if (root == null) {
			return;
		}
		print(root.left);
		System.out.print(root.val + " ");
		print(root.right);
	}
}

public class Solution1 {
	ArrayList<Integer> list;

	public int pairsViolatingBST(Node root) {
		list = new ArrayList<>();
		inOrder(root);

		int n = list.size();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = list.get(i);
		}
		int[] sorted = new int[n];
		return mergeSort(arr, sorted, 0, n - 1);
	}

	private int mergeSort(int[] arr, int[] sorted, int low, int high) {
		if (low >= high) {
			return 0;
		}

		int mid = low + (high - low) / 2;
		int count = mergeSort(arr, sorted, low, mid) + mergeSort(arr, sorted, mid + 1, high);

		int i = low;
		int j = mid + 1;
		int m = j;
		int n = high + 1;
		int k = low;

		while (i < m && j < n) {
			if (arr[i] <= arr[j]) {
				sorted[k++] = arr[i++];
			} else {
				count += mid - i + 1;
				sorted[k++] = arr[j++];
			}
		}

		while (i < m) {
			sorted[k++] = arr[i++];
		}

		while (j < n) {
			sorted[k++] = arr[j++];
		}

		for (int x = low; x <= high; x++) {
			arr[x] = sorted[x];
		}

		return count;
	}

	private void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		list.add(root.val);
		inOrder(root.right);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 50, -1, -1, 40, 20, -1, -1, 30, -1, -1 };
		BinaryTree bt = new BinaryTree();

		Node root = bt.build(arr);
		bt.print(root);
		System.out.println();

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.pairsViolatingBST(root));
	}
}
