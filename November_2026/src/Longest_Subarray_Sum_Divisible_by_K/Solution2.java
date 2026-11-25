package Longest_Subarray_Sum_Divisible_by_K;

import java.util.Arrays;

public class Solution2 {
	public int longestSubarrayDivK(int[] arr, int k) {
		int n = arr.length;
		int sum = 0;
		int maxLen = 0;
		int[] lastSeen = new int[k];
		Arrays.fill(lastSeen, -10);
		lastSeen[0] = -1;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			int rem = (sum % k + k) % k;
			if (lastSeen[rem] != -10) {
				maxLen = Math.max(maxLen, i - lastSeen[rem]);
			} else {
				lastSeen[rem] = i;
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int arr[] = { -2, 2, -5, 12, -11, -1, 7 };
		int k = 3;

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.longestSubarrayDivK(arr, k));
	}
}