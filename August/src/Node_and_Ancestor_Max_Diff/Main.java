package Node_and_Ancestor_Max_Diff;

class Node {
	int ele;
	Node left;
	Node right;
	
	Node(int ele) {
		this.ele = ele;
		this.left = null;
		this.right = null;
	}
}

class BT {
	
	int index = -1;
	Node buildTree(int[] arr) {
		index++;
		
		if(arr[index] == -1) {
			return null;
		}
		
		Node root = new Node(arr[index]);
		root.left = buildTree(arr);
		root.right = buildTree(arr);
		
		return root;
	}
	
	void printNode(Node root) {
		if(root == null) {
			return;
		}
		
		printNode(root.left);
		System.out.print(root.ele + " ");
		printNode(root.right);
	}
	
	int max = Integer.MIN_VALUE;
	int maxDiff(Node root) {
		maximumDifference(root.left, root.ele);
		maximumDifference(root.right, root.ele);
		return max;
    }
	
	private void maximumDifference(Node root, int ancestor) {
		if(root == null) {
			return;
		}
		
		max = Math.max(ancestor-root.ele, max);
		ancestor = Math.max(ancestor, root.ele);

		maximumDifference(root.left, ancestor);
		maximumDifference(root.right, ancestor);
	}
}

public class Main {
	public static void main(String[] args) {
		int[] arr = {5, 2, -1, -1, 1, -1, -1};
		
		BT b = new BT();
		Node root = b.buildTree(arr);
		
		b.printNode(root);
		
		System.out.println("Output: " + b.maxDiff(root));
	}
}
