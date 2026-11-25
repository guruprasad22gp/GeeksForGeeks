package Trace_Path;

public class Solution1 {
	public boolean isPossible(int n, int m, String s) {
		int x = 0;
		int y = 0;
		int minX = 0;
		int maxX = 0;
		int minY = 0;
		int maxY = 0;

		for (char ch : s.toCharArray()) {
			if (ch == 'L') {
				y--;
			} else if (ch == 'R') {
				y++;
			} else if (ch == 'U') {
				x++;
			} else {
				x--;
			}

			minX = Math.min(minX, x);
			maxX = Math.max(maxX, y);
			minY = Math.min(minY, y);
			maxY = Math.max(maxY, y);
		}

		int r = maxX - minX + 1;
		int c = maxY - minY + 1;

		return r <= n && c <= m;

	}

	public static void main(String[] args) {
		int n = 2;
		int m = 3;
		String s = "LLRU";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.isPossible(n, m, s));
	}
}
