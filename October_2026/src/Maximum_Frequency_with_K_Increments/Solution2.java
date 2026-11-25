package Maximum_Frequency_with_K_Increments;

import java.util.Arrays;

public class Solution2 {
	public int maxFrequency(int[] arr, int k) {
		Arrays.sort(arr);

		int left = 0;
		int right = 0;
		int res = 0;

		long currentSum = 0;

		while (right < arr.length) {
			long target = arr[right];
			currentSum += arr[right];

			long windowSum = (right - left + 1) * target;
			long op = windowSum - currentSum;

			while (left < right && op > k) {
				currentSum -= arr[left];
				left++;
				windowSum = (right - left + 1) * target;
				op = windowSum - currentSum;
			}

			res = Math.max(res, right - left + 1);
			right++;
		}

		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 2, 4 };
		int k = 4;

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.maxFrequency(arr, k));
	}
}
