package Numbers_Without_d_as_Digit;

import java.util.Arrays;

public class Solution2 {
	int[][][] dp;
    public int countWithout(int n, int d) {
    	dp = new int[11][2][2];
    	for(int i=0;i<11;i++) {
    		for(int j=0;j<2;j++) {
    			Arrays.fill(dp[i][j], -1);
    		}
    	}
    	
    	int index = 0;
    	int isStarted = 0;
    	int isTight = 1;
    	String num = String.valueOf(n);
    	return solve(index, isTight, isStarted, num, d) - 1;
    }
    
    private int solve(int index, int isTight, int isStarted, String num, int d) {
    	if(index == num.length()) {
    		return 1;
    	}
    	
    	if(dp[index][isTight][isStarted] != -1) {
    		return dp[index][isTight][isStarted];
    	}
    	
    	int limit = 9;
    	if(isTight == 1) {
    		limit = num.charAt(index)-'0';
    	}
    	
    	int ans = 0;
    	for(int i=0;i<=limit;i++) {
    		int isnTight = (isTight == 1) && (i == limit)? 1: 0;
    		int isNStarted = (isStarted == 1 || i != 0) ? 1: 0;
    		
    		if(isNStarted == 1 && i == d) {
    			continue;
    		}
    		
    		ans += solve(index+1, isnTight, isNStarted, num, d);
    	}
    	
    	return dp[index][isTight][isStarted] = ans;
    }
    
    public static void main(String[] args) {
    	int n = 9;
    	int d = 2;
    	
    	Solution2 sol2 = new Solution2();
    	
    	System.out.println("Output: " + sol2.countWithout(n, d));
	}
}
