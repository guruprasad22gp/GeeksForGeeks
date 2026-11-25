package Lexicographically_Smallest_Rotation;

public class Solution2 {
	public String lexiString(String s) {
		int n = s.length();
		String doubleS = s + s;
		int i = 0;
		int j = 1;
		int k = 0;

		while (i < n && j < n && k < n) {
			if (doubleS.charAt(i + k) == doubleS.charAt(j + k)) {
				k++;
			} else if (doubleS.charAt(i + k) > doubleS.charAt(j + k)) {
				i = i + k + 1;
				if (i == j) {
					i++;
				}

				k = 0;
			} else {
				j = j + k + 1;
				if (i == j) {
					j++;
				}

				k = 0;
			}
		}

		int start = Math.min(i, j);
		return doubleS.substring(start, start + n);
	}

	public static void main(String[] args) {
		String s = "abcaa";

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.lexiString(s));
	}
}
