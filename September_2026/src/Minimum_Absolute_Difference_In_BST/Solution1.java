package Minimum_Absolute_Difference_In_BST;

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

class BinarySearchTree {
	int index = -1;
	
	Node buildBST(Node root, int val) {
		if(root == null) {
			return new Node(val);
		}
		
		if(root.val < val) {
			root.right = buildBST(root.right, val);
		} else {
			root.left = buildBST(root.left, val);
		}
		
		return root;
	}
	
	void print(Node root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.val + " ");
		print(root.left);
		print(root.right);
	}
}
public class Solution1 {
	public static void main(String[] args) {
		int[] arr = {4, 2, 6, 1, 3};
		BinarySearchTree bst = new BinarySearchTree();
		Node root = null;
		for(int ele: arr) {
			root = bst.buildBST(root, ele);
		}
		
		bst.print(root);
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.absDiff(root));
	}
	
	int maxDiff;
	Node prev;
    public int absDiff(Node root) {
    	maxDiff = Integer.MAX_VALUE;
    	prev = null;
    	
    	inOrder(root);
    	
    	return maxDiff;
    }
    
    private void inOrder(Node root) {
    	if(root == null) {
    		return;
    	}
    	
    	inOrder(root.left);
    	
    	if(prev != null) {
    		maxDiff = Math.min(maxDiff, Math.abs(root.val - prev.val));
    	}
    	
    	prev = root;
    	inOrder(root.right);
    }
}
