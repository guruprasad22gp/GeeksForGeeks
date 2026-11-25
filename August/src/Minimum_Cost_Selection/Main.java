package Minimum_Cost_Selection;

import java.util.Arrays;

public class Main {
	int[][] dp;
    public int minCost(int[][] mat) {
    	int n = mat.length;
    	
    	dp = new int[n+1][n+1];
    	for(int i=0;i<=n;i++) {
    		Arrays.fill(dp[i], -1);
    	}
    	
    	int prev = -1;
    	int index = 0;
    	
    	return solve(index, prev, mat);
        
    }
    
    private int solve(int index, int prev, int[][] mat) {
    	if(index == mat.length) {
    		return 0;
    	}
    	
    	int prevIndex = (prev == -1)? 3: prev;
    	
    	if(dp[index][prevIndex] != -1) {
    		return dp[index][prev];
    	}
    	
    	int ans = Integer.MAX_VALUE;
    	for(int i=0;i<3;i++) {
    		if(i == prev) {
    			continue;
    		}
    		
    		int currentCost = mat[index][i];	
    		int futureCost = solve(index+1, i, mat);
    		ans = Math.min(ans, futureCost + currentCost);
    	}
    	
    	return dp[index][prevIndex] = ans;
    }

    public static void main(String[] args) {
    	int mat[][] = {
    					{1, 50, 50},
    					{50, 50, 50},
    					{1, 50, 50}
    	};

    	Main m = new Main();
    	System.out.println("Output: " + m.minCost(mat));
	}
}
