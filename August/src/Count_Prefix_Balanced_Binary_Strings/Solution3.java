package Count_Prefix_Balanced_Binary_Strings;

import java.util.Arrays;

public class Solution3 {
	 public static void main(String[] args) {
		int n = 1000;
			
		Solution3 sol = new Solution3();
		System.out.println("Output: " + sol.prefixStrings(n));
	 }
		 
	int MOD = 1000000007;
	long dp[];
    public int prefixStrings(int n) {
    	if(n==1) {
    		return 1;
    	}
    	dp = new long[2*n+1];
    	Arrays.fill(dp, -1);
    	long nominator = fact(2*n);
    	long denominator = (fact(n) * fact(n)) % MOD;
    	denominator = (denominator * (n+1)) % MOD;
    	long result = (nominator*inverse(denominator)) % MOD;
    	
    	return (int)result;
    }
    
    private long inverse(long a) {
    	long exp = MOD - 2;
    	a %= MOD;
    	
    	long res = 1;
    	
    	while(exp > 0) {
    		if((exp & 1) == 1) {
    			res = (res * a) % MOD;
    		}
    		a = (a * a) % MOD;
			exp >>= 1;
    	}
    	
    	return res;
    }
    
    private long fact(int n) {
    	if(n <= 1) {
    		return 1;
    	}
    	if(dp[n] != -1) {
    		return dp[n];
    	}
    	
    	return dp[n] = (n * fact(n-1)) % MOD;
    }
}
