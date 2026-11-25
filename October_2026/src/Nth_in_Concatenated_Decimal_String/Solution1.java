package Nth_in_Concatenated_Decimal_String;

public class Solution1 {
	public char nthCharacter(int n) {
//		String s = "";
//		int index = 1;
//		while (s.length() < n) {
//			s += String.valueOf(index);
//			index++;
//		}
//
//		return s.charAt(n - 1);

		long len = 1;
		long count = 9;
		long start = 1;

		while (n > len * count) {
			n -= len * count;
			len++;
			start *= 10;
			count *= 10;
		}

		long num = start + (n - 1) / len;
		int index = (int) ((n - 1) % len);
		return String.valueOf(num).charAt(index);

	}

	public static void main(String[] args) {
		int n = 1000000000;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.nthCharacter(n));
	}
}
