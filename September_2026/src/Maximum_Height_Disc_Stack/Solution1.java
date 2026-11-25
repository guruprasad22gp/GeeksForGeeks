package Maximum_Height_Disc_Stack;

import java.util.Arrays;

public class Solution1 {
    public int maxStackHeight(int[] r, int[] h) {
    	int n = r.length;
    	
    	int[][] arr = new int[n][2];
    	for(int i=0;i<n;i++) {
    		arr[i][0] = r[i];
    		arr[i][1] = h[i];
    	}
    	
    	Arrays.sort(arr, (a, b) -> {
    		if(a[0] == b[0]) {
    			return a[1] - b[1];
    		}
    		return a[0] - b[0];
    	});
    	
    	for(int[] x: arr) {
    		System.out.println(x[0] + " - " + x[1]);
    	}
    	
    	
    	return solve(0, -1, arr);
    }
    
    private int solve(int i, int prevI, int[][] arr) {
    	if(i >= arr.length) {
    		return  0;
    	}
    	
    	int skip = solve(i+1, prevI, arr);
    	int take = 0;
    	if(prevI == -1 || (arr[i][0] > arr[prevI][0] && arr[i][1] > arr[prevI][1])) {
    		take = arr[i][1] + solve(i+1, i, arr);
    	}
    	
    	return Math.max(take, skip);
    }
    
    public static void main(String[] args) {
    	int r[] = {5, 7, 3};
    	int h[] = {6, 5, 4};

    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.maxStackHeight(r, h));
	}
}
