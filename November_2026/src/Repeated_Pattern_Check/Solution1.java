package Repeated_Pattern_Check;

public class Solution1 {
	public boolean findPattern(String s) {
		int n = s.length();
		int i = 0;
		int cx = 0;
		int cy = 0;

		while (i < n) {
			while (i < n && s.charAt(i) == 'x') {
				cx++;
				i++;
			}

			while (i < n && s.charAt(i) == 'y') {
				cy++;
				i++;
			}

			if (cx != cy) {
				return false;
			}
		}

		return true;

	}

	public static void main(String[] args) {
		String s = "xxyyxy";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findPattern(s));
	}
}
