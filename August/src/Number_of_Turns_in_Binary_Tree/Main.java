package Number_of_Turns_in_Binary_Tree;

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

class Solution {
	int index = -1;
	Node build(int[] arr) {
		index++;
		
		if(arr[index] == -1) {
			return null;
		}
		
		Node root = new Node(arr[index]);
		root.left = build(arr);
		root.right = build(arr);																							
		
		return root;
	}
	
	void inOrder(Node root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}
	
	Node LCA(Node root, int p, int q) {
		if(root == null) {
			return null;
		}
		
		if(root.val == p || root.val == q) {
			return root;
		}
		
		Node leftLCA = LCA(root.left, p, q);
		Node rightLCA = LCA(root.right, p, q);
		
		if(leftLCA != null && rightLCA != null) {
			return root;
		} else if(leftLCA != null) {
			return leftLCA;
		} else {
			return rightLCA;
		}
	}
     
    private boolean findPath(Node root, int target, StringBuilder path) {
    	if(root == null) {
    		return false;
    	}
    	
    	if(root.val == target) {
    		return true;
    	}
    	
    	path.append("L");
    	if(findPath(root.left, target, path)) {
    		return true;
    	}
    	path.deleteCharAt(path.length()-1);
    	
    	path.append("R");
    	if(findPath(root.right, target, path)) {
    		return true;
    	}
    	path.deleteCharAt(path.length()-1);
    	
    	return false;
    }
    
    public int numberOfTurns(Node root, int p, int q) {
    	Node lca = LCA(root, p, q);
    	
    	StringBuilder pathP = new StringBuilder();
    	findPath(lca, p, pathP);
    	
    	StringBuilder pathQ = new StringBuilder();
    	findPath(lca, q, pathQ);
    	
    	int turnsCount = 0;
    	
    	String str = pathP.reverse().toString() + pathQ.toString();
    	
    	for(int i=1;i<str.length();i++) {
    		if(str.charAt(i) != str.charAt(i-1)) {
    			turnsCount++;
    		}
    	}
    	
    	return turnsCount;
    }
}

public class Main {
	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 8, -1, -1, -1, 5, -1, -1, 3, 6, 9, -1, -1, 10, -1, -1, 7, -1, -1};
		int p = 5;
		int q = 10;
		
		Solution s = new Solution();
		Node root = s.build(arr);
		
		s.inOrder(root);
		
		System.out.println("Output: " + s.numberOfTurns(root, p, q));
	}
}
