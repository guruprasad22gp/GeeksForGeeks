package Convert_One_String_to_Another_with_Constraints;

public class Solution1 {
	public boolean isItPossible(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		if (m != n) {
			return false;
		}

		int i = 0;
		int j = 0;

		while (i < m) {
			while (i < m && s1.charAt(i) == '#') {
				i++;
			}

			while (j < n && s2.charAt(j) == '#') {
				j++;
			}

			if (i >= m && j < n) {
				return false;
			}

			if (j >= n && i < n) {
				return false;
			}

			if (i < m && j < n && s1.charAt(i) == s2.charAt(j)) {
				if (s1.charAt(i) == 'A' && j > i) {
					return false;
				}

				if (s1.charAt(i) == 'B' && j < i) {
					return false;
				}
			}
			if (i < m && j < n && s1.charAt(i) != s2.charAt(j)) {
				return false;
			}

			i++;
			j++;
		}

		return true;
	}

	public static void main(String[] args) {
		String s1 = "#A#B#B#";
		String s2 = "A###B#B";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.isItPossible(s1, s2));
	}
}