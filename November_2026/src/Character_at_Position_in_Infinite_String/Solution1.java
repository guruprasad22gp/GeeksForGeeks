package Character_at_Position_in_Infinite_String;

public class Solution1 {
	public char posInfinite(String s, int pos) {
		int len = s.length();
		int i = 1;

		while (len < pos) {
			len = len * 2 + i;
			i++;
		}

		i--;

		while (pos > s.length()) {
			int oldLen = (len - i) / 2;
			if (pos <= oldLen) {
				len = oldLen;
			} else if (pos <= oldLen + i) {
				return '$';
			} else {
				int revPos = pos - oldLen - i;
				pos = oldLen - revPos + 1;
				len = oldLen;
			}
			i--;
		}
		return s.charAt(pos - 1);
	}

	public static void main(String[] args) {
		String s = "abc";
		int pos = 20;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.posInfinite(s, pos));
	}
}
