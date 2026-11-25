package Longest_Subsequence_with_Adjacent_Diff_as_1;

import java.util.Arrays;

public class Solution2 {
	int[][] dp;
    public int longestSubseq(int[] arr) {
    	 int n = arr.length;
    	 dp = new int[n+1][n+1];
    	 for(int[] x: dp) {
    		 Arrays.fill(x, -1);
    	 }
    	 
         int index = 0;
         int prevIndex = -1;
         
         return solve(index, prevIndex, arr);
    }
    
    private int solve(int index, int prevIndex, int[] arr) {
    	if(index == arr.length) {
    		return 0;
    	}
    	
    	prevIndex = prevIndex == -1? arr.length: prevIndex;
    	if(dp[index][prevIndex] != -1) {
    		return dp[index][prevIndex];
    	}
    	
    	int skip = solve(index+1, prevIndex, arr);
    	int take = 0;
    	if(prevIndex == arr.length || Math.abs(arr[index] - arr[prevIndex]) == 1) {
    		take = 1 + solve(index+1, index, arr);
    	}
    	
    	return dp[index][prevIndex] =  Math.max(take, skip);
    }
    
    public static void main(String[] args) {
		int arr[] = {10, 9, 4, 5, 4, 8, 6};
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.longestSubseq(arr));
	}
}