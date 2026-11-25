package Minimum_Cost_Pizza_Selection;

import java.util.Arrays;

public class Solution2 {
	int S;
	int M;
	int L;
	int CS;
	int CM;
	int CL;
	int[] dp;
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
    	S = s;
    	M = m;
    	L = l;
    	CS = cs;
    	CM = cm;
    	CL = cl;
    	
    	dp = new int[1000];
    	Arrays.fill(dp, -1);
    	return solve(x);
    }
    
    private int solve(int x) {
    	if(x <= 0) {
    		return 0;
    	}
    	
    	if(dp[x] != -1) {
    		return dp[x];
    	}
    	
    	int tS = CS + solve(x - S);
    	int tM = CM + solve(x - M);
    	int tL = CL + solve(x - L);
    	return dp[x] = Math.min(tS, Math.min(tM, tL));
    }

	public static void main(String[] args) {
		int x = 16;
		int s = 3;
		int m = 6;
		int l = 9;
		int cs = 50;
		int cm = 150;
		int cl = 300;
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.minimumCost(x, s, m, l, cs, cm, cl));
	}
}
