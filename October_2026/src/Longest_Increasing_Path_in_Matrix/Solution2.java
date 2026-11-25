package Longest_Increasing_Path_in_Matrix;

import java.util.Arrays;

public class Solution2 {
	int dp[][];

	public int longIncPath(int[][] matrix, int m, int n) {
		int maxLen = 1;
		dp = new int[m][n];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				maxLen = Math.max(maxLen, solve(i, j, m, n, matrix));
			}
		}

		return maxLen;
	}

	private int solve(int i, int j, int m, int n, int[][] matrix) {
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int maxLen = 1;

		if (i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]) {
			maxLen = Math.max(maxLen, 1 + solve(i - 1, j, m, n, matrix));
		}

		if (j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) {
			maxLen = Math.max(maxLen, 1 + solve(i, j - 1, m, n, matrix));
		}

		if (i + 1 < m && matrix[i][j] < matrix[i + 1][j]) {
			maxLen = Math.max(maxLen, 1 + solve(i + 1, j, m, n, matrix));
		}

		if (j + 1 < n && matrix[i][j] < matrix[i][j + 1]) {
			maxLen = Math.max(maxLen, 1 + solve(i, j + 1, m, n, matrix));
		}

		return dp[i][j] = maxLen;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 3, 2, 3 }, { 0, 2, 2 }, { 2, 0, 4 }, { 3, 1, 0 } };
		int n = matrix.length;
		int m = matrix[0].length;

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.longIncPath(matrix, n, m));
	}
}
