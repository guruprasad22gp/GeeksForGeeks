package Minimum_Squares_with_Full_Cuts;

public class Solution1 {
	public int minSquares(int n, int m) {
		int min = Math.min(m, n);
		int max = Math.max(n, m);
		int count = 0;
		while (min > 0 && max > 0) {
			count += max / min;
			int rem = max % min;
			max = min;
			min = rem;
		}

		return count;
	}

	public static void main(String[] args) {
		int n = 11;
		int m = 13;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minSquares(n, m));
	}
}