package Count_Subsequences_Divisible_by_n;

public class Solution3 {
	public static void main(String[] args) {
    	String s = "36";
    	int n = 3;
    	
    	Solution3 m = new Solution3();
    	System.out.println("Output: " + m.countSubsequences(s, n));
	}
	
	int MOD = 1000000007;
    public int countSubsequences(String s, int n) {
    	long[] dp = new long[n];
    	
    	for(int i=0;i<s.length();i++) {
    		int d = s.charAt(i) - '0';
    		long copy[] = dp.clone();
    		copy[d % n]++;
    		for(int rem = 0; rem <n;rem++) {
    			int newRem = (rem * 10 + d) % n;
    			copy[newRem] = (copy[newRem] + dp[rem]) % MOD;
    		}
    		
    		dp = copy;
    	}
    	
    	return (int)dp[0];
    }
}
