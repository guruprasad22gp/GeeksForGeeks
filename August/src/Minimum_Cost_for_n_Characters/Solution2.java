package Minimum_Cost_for_n_Characters;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		int n = 73;
		int i = 9;
		int d = 2;
		int c = 5;
		
		Solution2 m = new Solution2();
		System.out.println("Output: " + m.minCost(n, i, d, c));
	}
	
	int[] dp;
	public int minCost(int n, int i, int d, int c) {
		 dp = new int[n+1];
		 Arrays.fill(dp, -1);
         return solve(n, i, d, c);
    }
	
	private int solve(int n, int i, int d, int c) {
		if(n == 0) {
			return 0;
		}
		
		if(n == 1) {
			return i;
		}
		
		if(dp[n] != -1) {
			return dp[n];
		}
		
		int ans = n * i;
		
		if(n % 2 == 0) {
			int copy = c + solve(n/2, i, d, c);
			ans = Math.min(ans, copy);
		} else {
			int down = i + solve(n-1, i, d, c);
			int up = d + c + solve((n +1)/2, i, d, c);
			ans = Math.min(ans, Math.min(down, up));
		}
		
		return dp[n] = ans;
	}
}
