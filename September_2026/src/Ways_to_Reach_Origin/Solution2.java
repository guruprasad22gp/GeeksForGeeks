package Ways_to_Reach_Origin;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		int x = 25;
		int y = 41;
		
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.ways(x, y));
	}
	
	int[][] dp;
	int MOD = 1_000_000_007;
    public int ways(int x, int y) {
    	dp = new int[x+1][y+1];
    	for(int[] a: dp) {
    		Arrays.fill(a, -1);
    	}
    	return solve(x, y);
    }
    
    private int solve(int x, int y) {
    	if(x < 0 || y < 0) {
    		return 0;
    	}
    	
    	if(dp[x][y] != -1) {
    		return dp[x][y];
    	}
    	
    	if(x == 0 && y == 0) {
    		System.out.println(x + " " + y); 
    		return dp[x][y] = 1;
    	}
    	
    	return dp[x][y] = (solve(x-1, y) + solve(x, y-1))%MOD;
    }
}
