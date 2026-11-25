package Roll_Characters_of_String;

public class Solution1 {
	public String findRollOut(String s, int[] roll) {
		int[] freq = new int[s.length() + 1];
		for (int x : roll) {
			freq[0]++;
			freq[x]--;
		}
		StringBuilder sb = new StringBuilder();
		int prefixSum = 0;
		for (int i = 0; i < s.length(); i++) {
			prefixSum += freq[i];
			int currIdx = s.charAt(i) - 'a';
			int updated = (currIdx + prefixSum) % 26;
			sb.append((char) ('a' + updated));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "bca";
		int roll[] = { 1, 2, 3 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findRollOut(s, roll));
	}
}
