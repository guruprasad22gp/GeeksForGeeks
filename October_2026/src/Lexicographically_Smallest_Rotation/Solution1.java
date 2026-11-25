package Lexicographically_Smallest_Rotation;

public class Solution1 {
	public String lexiString(String s) {
		String result = s;

		for (int i = 0; i < s.length(); i++) {
			String sub1 = s.substring(0, i);
			String sub2 = s.substring(i);
			String sub = sub2 + sub1;
			if (result.compareTo(sub) > 0) {
				result = sub;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "abcaa";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.lexiString(s));
	}
}
