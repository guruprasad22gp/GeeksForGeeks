package Longest_Subarray_Sum_Divisible_by_K;

public class Solution1 {
	public int longestSubarrayDivK(int[] arr, int k) {
		int n = arr.length;
		int maxLen = 0;

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum % k == 0) {
					maxLen = Math.max(maxLen, j - i + 1);
				}
			}
		}

		return maxLen;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 7, 6, 1, 4, 5 };
		int k = 3;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.longestSubarrayDivK(arr, k));
	}
}