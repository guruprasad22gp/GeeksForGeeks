package Balanced_Binary_Tree_Counter;

public class Solution2 {
	public int countBT(int h) {
		int MOD = 1_000_000_007;
		long[] dp = new long[h + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= h; i++) {
			dp[i] = (dp[i - 1] * dp[i - 1] % MOD + 2 * dp[i - 1] % MOD * dp[i - 2] % MOD) % MOD;
		}

		return (int) dp[h];
	}

	public static void main(String[] args) {
		int h = 1000000;
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.countBT(h));
	}
}
