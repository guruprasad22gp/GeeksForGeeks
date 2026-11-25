package Maximum_Frequency_with_K_Increments;

import java.util.Arrays;

public class Solution3 {
	public int maxFrequency(int[] arr, int k) {
		Arrays.sort(arr);

		int left = 0;
		int right = 0;
		int res = 0;

		long currentSum = 0;

		while (right < arr.length) {
			currentSum += arr[right];

			if ((long) (right - left + 1) * arr[right] - currentSum > k) {
				currentSum -= arr[left];
				left++;
			}

			res = Math.max(res, right - left + 1);
			right++;
		}

		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 2, 4 };
		int k = 4;

		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.maxFrequency(arr, k));
	}
}
