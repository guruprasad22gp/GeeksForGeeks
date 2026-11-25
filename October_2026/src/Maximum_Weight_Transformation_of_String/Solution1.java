package Maximum_Weight_Transformation_of_String;

public class Solution1 {
	public int getMaxWeight(String s) {
		int n = s.length();
		int prev2 = 0;
		int prev1 = 1;
		if (n == 1) {
			return 1;
		}

		for (int i = 2; i <= n; i++) {
			int single = prev1 + 1;
			int pairWt = (s.charAt(i - 1) != s.charAt(i - 2)) ? 4 : 3;
			int pair = pairWt + prev2;
			int curr = Math.max(pair, single);
			prev2 = prev1;
			prev1 = curr;
		}
		return prev1;
	}

	public static void main(String[] args) {
		String s = "ABB";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.getMaxWeight(s));
	}
}
