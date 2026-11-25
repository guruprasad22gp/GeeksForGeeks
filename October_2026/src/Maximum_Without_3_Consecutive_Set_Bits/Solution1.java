package Maximum_Without_3_Consecutive_Set_Bits;

public class Solution1 {
	public int maxValue(int n) {
		for (int i = 31; i >= 2; i--) {
			if ((n & (1 << i)) != 0 && (n & (1 << i - 1)) != 0 && (n & (1 << i - 2)) != 0) {
				n ^= (1 << (i - 2));
			}
		}

		return n;
	}

	public static void main(String[] args) {
		int n = 38;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxValue(n));
	}
}
