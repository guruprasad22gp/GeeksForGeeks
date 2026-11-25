package Perimeter_of_Shapes_in_Binary_Matrix;

public class Solution1 {
	int findPerimeter(int[][] mat) {
		int total = 0;
		int m = mat.length;
		int n = mat[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1) {
					total += 4;

					int count = 0;
					if (i - 1 >= 0 && mat[i - 1][j] == 1) {
						count++;
					}

					if (j - 1 >= 0 && mat[i][j - 1] == 1) {
						count++;
					}

					if (i + 1 < m && mat[i + 1][j] == 1) {
						count++;
					}

					if (j + 1 < n && mat[i][j + 1] == 1) {
						count++;
					}

					total -= count;
				}
			}
		}

		return total;
	}

	public static void main(String[] args) {
		int mat[][] = { { 0, 1, 0, 0, 0 }, { 1, 1, 1, 0, 0 }, { 1, 0, 0, 0, 0 } };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findPerimeter(mat));
	}
}
