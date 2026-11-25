package Min_Flips_for_Alternate;

import java.util.Arrays;

public class Solution2 {
	int[][] dp;

	public int minFlips(String s) {
		int n = s.length();
		dp = new int[n + 1][2];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		return Math.min(solve(0, s, false), solve(0, s, true));
	}

	private int solve(int i, String s, boolean isZero) {
		if (i == s.length()) {
			return 0;
		}
		int j = isZero ? 1 : 0;
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int res = 0;
		if (isZero) {
			if (s.charAt(i) == '0') {
				res = solve(i + 1, s, false);
			} else {
				res = 1 + solve(i + 1, s, false);
			}
		} else {
			if (s.charAt(i) == '1') {
				res = solve(i + 1, s, true);
			} else {
				res = 1 + solve(i + 1, s, true);
			}
		}

		return dp[i][j] = res;
	}

	public static void main(String[] args) {
		String s = "001";
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.minFlips(s));
	}
}