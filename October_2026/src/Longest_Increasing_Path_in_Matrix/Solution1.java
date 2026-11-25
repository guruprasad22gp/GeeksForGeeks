package Longest_Increasing_Path_in_Matrix;

public class Solution1 {
	public int longIncPath(int[][] matrix, int n, int m) {
		int maxLen = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				maxLen = Math.max(maxLen, solve(i, j, n, m, matrix));
			}
		}

		return maxLen;
	}

	private int solve(int i, int j, int m, int n, int[][] matrix) {

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

		return maxLen;

	}

	public static void main(String[] args) {
		int n = 3;
		int m = 3;
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.longIncPath(matrix, n, m));
	}
}
