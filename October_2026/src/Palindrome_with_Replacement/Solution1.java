package Palindrome_with_Replacement;

public class Solution1 {
	public int minimumSum(String s) {
		int n = s.length();
		int res = 0;
		char[] arr = s.toCharArray();
		for (int i = 0; i < n / 2; i++) {
			if (arr[i] != '?' && arr[n - i - 1] == '?') {
				arr[n - i - 1] = arr[i];
			} else if (arr[i] == '?' && arr[n - i - 1] != '?') {
				arr[i] = arr[n - i - 1];
			}

			if (arr[i] != arr[n - i - 1]) {
				return -1;
			}
		}

		char prev = '?';
		for (int i = 0; i < n / 2; i++) {
			if (prev == '?') {
				if (arr[i] != '?') {
					prev = arr[i];
				}
			} else if (arr[i] != '?') {
				res = Math.abs(arr[i] - prev);
				prev = arr[i];
			}
		}

		return 2 * res;
	}

	public static void main(String[] args) {
		String s = "a???c??c????";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minimumSum(s));
	}
}
