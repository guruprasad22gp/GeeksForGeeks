package Count_Subsequences_Divisible_by_n;

import java.util.Arrays;

public class Solution2 {
	int[][][] dp;
	int MOD = 1000000007;
    public int countSubsequences(String s, int n) {
    	dp = new int[s.length()][n][2];
    	for(int[][] d: dp) {
    		for(int[] x: d) {
    			Arrays.fill(x, -1);
    		}
    	}
    	
    	int index = 0;
    	int remainder = 0;
    	boolean isTaken = false;
    	return solve(s, n, index, remainder, isTaken);
    }
    
    private int solve(String s, int n, int index, int remainder, boolean isTaken) {
    	if(index == s.length()) {
    		if(isTaken & remainder == 0) {
    			return 1;
    		}
    		return 0;
    	}
    	
    	int state = isTaken? 1: 0;
    	if(dp[index][remainder][state] != -1) {
    		return dp[index][remainder][state];
    	}
    	
    	int d = s.charAt(index) - '0';
    	
    	int skip = solve(s, n, index+1, remainder, isTaken);
    	
    	int newRemainder = (remainder * 10 + d) % n;
    	int take = solve(s, n, index+1, newRemainder, true);
    	
    	return dp[index][remainder][state] = skip + take;
    }
    
    public static void main(String[] args) {
    	String s = "1234567890";
    	int n = 4;
    	
    	Solution2 m = new Solution2();
    	System.out.println("Output: " + m.countSubsequences(s, n));
	}
}
