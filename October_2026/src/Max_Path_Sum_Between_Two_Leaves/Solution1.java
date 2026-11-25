package Max_Path_Sum_Between_Two_Leaves;

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

		if (arr[index] == Integer.MIN_VALUE) {
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

		System.out.print(root.val + " ");
		print(root.left);
		print(root.right);
	}
}

public class Solution1 {
	public static void main(String[] args) {
		int[] arr = { 3, 4, -10, Integer.MIN_VALUE, Integer.MIN_VALUE, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 5,
				Integer.MIN_VALUE, Integer.MIN_VALUE };

		BinaryTree bt = new BinaryTree();
		Node root = bt.build(arr);

		bt.print(root);

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxPathSum(root));

	}

	int maxSum;
	int leafCount;

	public int maxPathSum(Node root) {
		maxSum = 0;
		leafCount = 0;

		if (root == null) {
			return -1;
		}

		DFS(root);
		if (leafCount < 2) {
			return -1;
		}

		return maxSum;
	}

	private int DFS(Node root) {
		if (root.left == null && root.right == null) {
			leafCount++;
			return root.val;
		}

		if (root.left == null) {
			return root.val + DFS(root.right);
		}

		if (root.right == null) {
			return root.val + DFS(root.left);
		}

		int left = DFS(root.left);
		int right = DFS(root.right);

		maxSum = Math.max(maxSum, left + right + root.val);
		return Math.max(left, right) + root.val;
	}
}
