package Min_Flips_for_Alternate;

public class Solution1 {
	public int minFlips(String s) {
		return Math.min(solve(0, s, false), solve(0, s, true));
	}

	private int solve(int i, String s, boolean isZero) {
		if (i == s.length()) {
			return 0;
		}

		if (isZero) {
			if (s.charAt(i) == '0') {
				return solve(i + 1, s, false);
			} else {
				return 1 + solve(i + 1, s, false);
			}
		} else {
			if (s.charAt(i) == '1') {
				return solve(i + 1, s, true);
			} else {
				return 1 + solve(i + 1, s, true);
			}
		}
	}

	public static void main(String[] args) {
		String s = "001";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minFlips(s));
	}
}