package Count_Prefix_Balanced_Binary_Strings;

import java.util.Arrays;

public class Solution2 {
	 public static void main(String[] args) {
		int n = 1000;
		
		Solution2 sol = new Solution2();
		System.out.println("Output: " + sol.prefixStrings(n));
	 }
	 
	 int dp[][];
	 int MOD = 1000000007;
	 public int prefixStrings(int n) {
		 if(n == 1) {
			 return 1;
		 }
		 dp = new int[2*n+1][2*n+1];
		 for(int i=0;i<2*n+1;i++) {
			 Arrays.fill(dp[i], -1);
		 }
		 
		 return solve(2*n, 0, 0) % MOD;
	 }
	 
	 private int solve(int n, int index, int balance) {
		 if(n == index) {
			 if(balance == 0) {
				 return 1;
			 }
			 return 0;
		 }
		 
		 if(balance < 0) {
			 return 0;
		 }
		 
		 if(dp[index][balance] != -1) {
			 return dp[index][balance];
		 }
		 
		 return dp[index][balance] = ((solve(n, index+1, balance+1) % MOD) + (solve(n, index+1, balance-1) % MOD)) % MOD;
	 }
}
