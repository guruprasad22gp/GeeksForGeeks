package Range_GCD_Queries;

import java.util.ArrayList;

class SegmentTree {
	int n;
	int tree[];
	
	public SegmentTree(int[] arr) {
		n = arr.length;
		tree = new int[4 * n];
		buildTree(arr, 0, 0, n-1);
	}
	
	public void buildTree(int[] arr, int node, int start, int end) {
		if(end == start) {
			tree[node] = arr[start];
			return;
		}
		
		int mid = start + (end - start)/2;
		buildTree(arr, 2*node+1, start, mid);
		buildTree(arr, 2*node+2, mid+1, end);
		tree[node] = GCD(tree[2*node+1], tree[2*node+2]);
	}
	
	public void update(int start, int end, int node, int index, int val) {
		if(start == end) {
			tree[node] = val;
			return;
		}
			
		int mid = start + (end - start)/2;
		if(index <= mid) {
			update(start, mid, 2*node+1, index, val);
		} else {
			update(mid+1, end, 2*node+2, index, val);
		}
		
		tree[node] = GCD(tree[2*node+1], tree[2*node+2]);
	}
	
	int query(int start, int end, int node, int left, int right) {
		if(right < start || left > end) {
			return 0;
		}
		
		if(left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = start + (end - start)/2;
		int gcd1 = query(start, mid, 2*node+1, left, right);
		int gcd2 = query(mid+1, end, 2 *node+2, left, right);
		
		if(gcd1 == 0) {
			return gcd2;
		}
		
		if(gcd2 == 0) {
			return gcd1;
		}
		
		return GCD(gcd1, gcd2);
	}
	
	public int GCD(int a, int b) {
		while(b!=0) {
			int t = b;
			b = a % b;
			a = t;
		}
		
		return a;
	}
}

public class Solution2 {
    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
    	ArrayList<Integer> result = new ArrayList<>();
    	SegmentTree st = new SegmentTree(arr);
    	
    	for(int[] x: queries) {
    		if(x[0] == 0) {
    			int left = x[1];
    			int right = x[2];
    			result.add(st.query(0, arr.length-1, 0, left, right));
    		} else {
    			int index = x[1];
    			int val = x[2];
    			st.update(0, arr.length-1, 0, index, val);
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
    	int arr[] = {2, 3, 4, 6, 8, 16};
    	int queries[][] = {
    			{0, 0, 2},
    			{1, 3, 8},
    			{0, 2, 5}
    	};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.processQueries(arr, queries));
	}
}
