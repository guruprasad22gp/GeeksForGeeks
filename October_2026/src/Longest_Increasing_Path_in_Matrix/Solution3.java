package Longest_Increasing_Path_in_Matrix;

import java.util.Arrays;

public class Solution3 {
	public int longIncPath(int[][] matrix, int n, int m) {
		int[][] dp = new int[n][m];
		for (int[] x : dp) {
			Arrays.fill(x, 1);
		}

		int result = 0;

		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				int maxLen = 1;

				if (i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]) {
					maxLen = Math.max(maxLen, 1 + dp[i - 1][j]);
				}

				if (j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) {
					maxLen = Math.max(maxLen, 1 + dp[i][j - 1]);
				}

				if (i + 1 < n && matrix[i][j] < matrix[i + 1][j]) {
					maxLen = Math.max(maxLen, 1 + dp[i + 1][j]);
				}

				if (j + 1 < m && matrix[i][j] < matrix[i][j + 1]) {
					maxLen = Math.max(maxLen, 1 + dp[i][j + 1]);
				}

				dp[i][j] = maxLen;

				result = Math.max(result, maxLen);
			}
		}

		return result;

	}

	public static void main(String[] args) {
		int matrix[][] = { { 3, 2, 3 }, { 0, 2, 2 }, { 2, 0, 4 }, { 3, 1, 0 } };
		int n = 4;
		int m = 3;

		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.longIncPath(matrix, n, m));
	}
}
