package Maximum_Frequency_with_K_Increments;

import java.util.Arrays;

public class Solution1 {
	public int maxFrequency(int[] arr, int k) {
		Arrays.sort(arr);

		int n = arr.length;

		int[] prefixSum = new int[n];
		prefixSum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}

		int res = 1;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, binarySearch(i, arr, k, prefixSum));
		}

		return res;
	}

	private int binarySearch(int targetIdx, int[] arr, int k, int[] prefixSum) {
		int targetEle = arr[targetIdx];

		int left = 0;
		int right = targetIdx;
		int res = targetIdx;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			int count = (right - mid + 1);
			long windowSum = (long) count * targetEle;
			long currentSum = (long) prefixSum[targetIdx] - prefixSum[mid] + arr[mid];
			long op = windowSum - currentSum;

			if (op > k) {
				left = mid + 1;
			} else {
				res = mid;
				right = mid - 1;
			}
		}

		return targetIdx - res + 1;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 2, 4 };
		int k = 4;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxFrequency(arr, k));
	}
}
