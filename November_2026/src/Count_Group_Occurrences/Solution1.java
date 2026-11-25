package Count_Group_Occurrences;

public class Solution1 {
	int getCount(String s, int k) {
		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 || (s.charAt(i) != s.charAt(i - 1))) {
				freq[s.charAt(i) - 'a']++;
			}
		}
		int count = 0;
		for (int ele : freq) {
			if (ele == k) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String s = "abc";
		int k = 1;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.getCount(s, k));
	}
}