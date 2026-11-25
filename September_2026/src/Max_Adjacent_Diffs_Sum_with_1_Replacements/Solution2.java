package Max_Adjacent_Diffs_Sum_with_1_Replacements;

import java.util.Arrays;

public class Solution2 {
	int[][] dp;
    public int maxDiffSum(int[] arr) {
    	int index = 1;
    	
    	int maxValue = Integer.MIN_VALUE;
    	for(int ele: arr) {
    		maxValue = Math.max(maxValue, ele);
    	}
    	
    	dp = new int[arr.length+1][maxValue+1];
    	for(int[] x: dp) {
    		Arrays.fill(x, -1);
    	}
    	
        int keep = solve(index, arr[0], arr);
        int replace = solve(index, 1, arr);
        
        return Math.max(replace, keep);
    }
    
    private int solve(int index, int prev, int[] arr) {
    	if(index == arr.length) {
    		return 0;
    	}
    	
    	if(dp[index][prev] != -1) {
    		return dp[index][prev];
    	}
    	
    	int keep = Math.abs(arr[index] - prev) + solve(index+1, arr[index], arr);
    	int replace = Math.abs(prev - 1) + solve(index+1, 1, arr);
    	
    	return dp[index][prev] = Math.max(keep, replace);
    }
    
    public static void main(String[] args) {
    	int arr[] = {3, 2, 1, 4, 5};

    	Solution2 sol2 = new Solution2();
    	System.out.println("Output: " + sol2.maxDiffSum(arr));
	}
}
