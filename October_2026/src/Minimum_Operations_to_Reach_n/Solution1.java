package Minimum_Operations_to_Reach_n;

public class Solution1 {
	public int minOperation(int n) {
		int op = 0;
		while (n > 0) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n--;
			}
			op++;
		}

		return op;
	}

	public static void main(String[] args) {
		int n = 7;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minOperation(n));
	}
}
