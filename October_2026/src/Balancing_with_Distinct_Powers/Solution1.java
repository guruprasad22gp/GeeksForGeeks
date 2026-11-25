package Balancing_with_Distinct_Powers;

public class Solution1 {
	public boolean balancePan(int a, int b) {
		while (b > 0) {
			int rem = b % a;
			if (rem == 0 || rem == 1) {
				b = b / a;
			} else if (rem == a - 1) {
				b = b / a + 1;
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int a = 4;
		int b = 11;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.balancePan(a, b));
	}
}
