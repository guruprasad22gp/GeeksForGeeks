package Minimum_Elements_Outside_Subsequences;

import java.util.Arrays;

public class Solution2 {
	int[][][] dp;
    public int minCount(int[] arr) {
    	int n = arr.length;
    	dp = new int[n+1][102][102];
    	for(int i=0;i<=n;i++) {
    		for(int j=0;j<102;j++) {
    			Arrays.fill(dp[i][j], -1);
    		}
    	}
    	
    	int incr = Integer.MIN_VALUE;
    	int decr = Integer.MAX_VALUE;
    	int i = 0;
    	return n - solve(i, incr, decr, arr);
    }
    
    private int solve(int index, int incr, int decr, int[] arr) {
    	if(index == arr.length) {
    		return 0;
    	}
    	
    	int newInc = incr == Integer.MIN_VALUE? 0: incr+1;
    	int newDec = decr == Integer.MAX_VALUE? 0: decr+1;
    	
    	if(dp[index][newInc][newDec] != -1) {
    		return dp[index][newInc][newDec];
    	}
    	
    	int skip = solve(index+1, incr, decr, arr);
    	
    	int takeInc = 0;
    	
    	if(arr[index] > incr) {
    		takeInc = 1 + solve(index+1, arr[index], decr, arr);
    	}
    	
    	int takeDecr = 0;
    	if(decr > arr[index]) {
    		takeDecr = 1 + solve(index+1, incr, arr[index], arr);
    	}
    	
    	return dp[index][newInc][newDec] = Math.max(skip, Math.max(takeInc, takeDecr));
    }
    
    public static void main(String[] args) {
    	int arr[] = {7, 8, 1, 2, 4, 6, 3, 5, 2, 1, 8, 7};
    	
    	Solution2 sol2 = new Solution2();
    	System.out.println("Output: " + sol2.minCount(arr));
	}
}
