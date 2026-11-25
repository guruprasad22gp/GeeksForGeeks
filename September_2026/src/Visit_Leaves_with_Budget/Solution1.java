package Visit_Leaves_with_Budget;

class Tree {
	int val;
	Tree left;
	Tree right;
	
	Tree(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class Solution {
	int index = -1;
	Tree build(int[] arr) {
		index++;
		if(arr[index] == -1) {
			return null;
		}
		Tree root = new Tree(arr[index]);
		root.left = build(arr);
		root.right = build(arr);
		
		return root;
	}
	
	void print(Tree root) {
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
		int[] arr = {1, 2, 3, -1, -1, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1};
		
		Solution sol = new Solution();
		Tree root = sol.build(arr);
		
		sol.print(root);
		
		int k = 8;
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.getCount(root, k));
	}
	
    public int getCount(Tree root, int k) {
        int[] freq = new int[k+1];
        
        DFS(root, 1, k, freq);
        
        int ans = 0;
        int budget = k;
        for(int i=1;i<freq.length;i++) {
        	int count = freq[i];
        	while(count > 0 && budget >= i) {
        		budget -= i;
        		ans++;
        		count--;
        	}
        }
        
        return ans;
    }
    
    private void DFS(Tree root, int level, int k, int[] freq) {
    	if(root == null) {
    		return;
    	}
    	
    	if(level > k) {
    		return;
    	}
    	
    	if(root.left == null && root.right == null) {
    		freq[level]++;
    		return;
    	}
    	
    	DFS(root.left, level+1, k, freq);
    	DFS(root.right, level+1, k, freq);
    }
}