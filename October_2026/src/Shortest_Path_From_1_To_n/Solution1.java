package Shortest_Path_From_1_To_n;

public class Solution1 {
	public int minimumStep(int n) {
		int steps = 0;

		while (n > 1) {
			if (n % 3 == 0) {
				n /= 3;
			} else {
				n -= 1;
			}

			steps++;
		}

		return steps;
	}

	public static void main(String[] args) {
		int n = 9;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minimumStep(n));
	}
}
