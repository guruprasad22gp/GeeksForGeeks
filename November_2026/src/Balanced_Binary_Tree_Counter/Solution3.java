package Balanced_Binary_Tree_Counter;

public class Solution3 {
	public int countBT(int h) {
		int MOD = 1_000_000_007;
		long prev2 = 1;
		long prev1 = 1;
		for (int i = 2; i <= h; i++) {
			long curr = (prev1 * prev1 % MOD + 2 * prev1 % MOD * prev2 % MOD) % MOD;
			prev2 = prev1;
			prev1 = curr;
		}

		return (int) prev1;
	}

	public static void main(String[] args) {
		int h = 1000000;
		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.countBT(h));
	}
}
