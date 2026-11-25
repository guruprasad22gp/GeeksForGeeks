package Min_Flips_for_Alternate;

public class Solution3 {
	public int minFlips(String s) {
		int n = s.length();
		int[][] dp = new int[n + 1][2];
		for (int i = n - 1; i >= 0; i--) {
			int res = 0;
			if (s.charAt(i) == '0') {
				res = dp[i + 1][1];
			} else {
				res = dp[i + 1][1] + 1;
			}
			dp[i][0] = res;
			int ans = 0;
			if (s.charAt(i) == '1') {
				ans = dp[i + 1][0];
			} else {
				ans = dp[i + 1][0] + 1;
			}

			dp[i][1] = ans;
		}
		return Math.min(dp[0][0], dp[0][1]);
	}

	public static void main(String[] args) {
		String s = "001";
		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.minFlips(s));
	}
}