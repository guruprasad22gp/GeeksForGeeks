package Balanced_Binary_Tree_Counter;

import java.util.Arrays;

public class Solution1 {
	long MOD = 1_000_000_007;
	long[] dp;

	public int countBT(int h) {
		dp = new long[h + 1];
		Arrays.fill(dp, -1);
		for (int i = 2; i <= h; i += 1000) {
			dp[i] = solve(i);
		}
		return (int) solve(h);
	}

	private long solve(int i) {
		if (i == 1 || i == 0) {
			return 1;
		}
		if (dp[i] != -1) {
			return dp[i];
		}
		long first = solve(i - 1);
		long second = solve(i - 2);
		long a = first * first % MOD;
		long b = 2 * first % MOD * second % MOD;
		return dp[i] = (a + b) % MOD;
	}

	public static void main(String[] args) {
		int h = 1000000;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.countBT(h));
	}
}
