package Smallest_Subarray_Sum_Greater_Than_x;

public class Solution1 {
	public int smallestSubWithSum(int[] arr, int x) {
		int left = 0;
		int curr = 0;
		int maxLen = Integer.MAX_VALUE;

		for (int right = 0; right < arr.length; right++) {
			curr += arr[right];

			while (left <= right && curr > x) {
				maxLen = Math.min(maxLen, right - left + 1);
				curr -= arr[left];
				left++;
			}
		}

		return maxLen == Integer.MAX_VALUE ? 0 : maxLen;
	}

	public static void main(String[] args) {
		int x = 10;
		int arr[] = { 1, 1, 8, 10 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.smallestSubWithSum(arr, x));
	}
}