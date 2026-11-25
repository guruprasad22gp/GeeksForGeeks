package Check_Level_Anagrams_in_Binary_Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
    public boolean areAnagrams(Node root1, Node root2) {
    	Queue<Node> q1 = new LinkedList<>();
    	Queue<Node> q2 = new LinkedList<>();
    	
    	q1.add(root1);
    	q2.add(root2);
    	
    	while(!q1.isEmpty() && !q2.isEmpty()) {
    		int size1 = q1.size();
    		int size2 = q2.size();
    		
    		if(size1 != size2) {
    			return false;
    		}
    		
    		HashMap<Integer, Integer> map1 = new HashMap<>();
    		HashMap<Integer, Integer> map2 = new HashMap<>();
    		
    		for(int i=0;i<size1;i++) {
    			Node curr1 = q1.poll();
    			map1.put(curr1.val, map1.getOrDefault(curr1.val, 0) + 1);
    			
    			if(curr1.left != null) {
    				q1.add(curr1.left);
    			}
    			
    			if(curr1.right != null) {
    				q1.add(curr1.right);
    			}
    			
    			Node curr2 = q2.poll();
    			map2.put(curr2.val, map2.getOrDefault(curr2.val, 0) + 1);
    			
    			if(curr2.left != null) {
    				q2.add(curr2.left);
    			}
    			
    			if(curr2.right != null) {
    				q2.add(curr2.right);
    			}
    		}
    		
    		if(!map1.equals(map2)) {
    			return false;
    		}
    	}
    	
    	 if(q1.size()> 0 || q2.size() > 0) {
             return false;
         }
    	
    	return true;
    }

	public static void main(String[] args) {
		int[] arr1 = {1, 3, -1, -1, 2, 5, -1, -1, 4, -1, -1};
		
		BinaryTree bt1 = new BinaryTree();
		Node root1 = bt1.buildTree(arr1);
		bt1.print(root1);
		System.out.println("\n-------------------------------");

		int[] arr2 = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1};
		
		BinaryTree bt2 = new BinaryTree();
		Node root2 = bt2.buildTree(arr2);
		bt2.print(root2);
		System.out.println("\n--------------------------------");
				
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.areAnagrams(root1, root2));
		
	}
}
