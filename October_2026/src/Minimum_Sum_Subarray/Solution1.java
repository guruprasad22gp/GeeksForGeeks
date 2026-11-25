package Minimum_Sum_Subarray;

public class Solution1 {
	public int minSubarraySum(int[] arr) {
		int currentSum = 0;
		int result = Integer.MAX_VALUE;

		for (int ele : arr) {
			currentSum += ele;
			result = Math.min(currentSum, result);
			currentSum = Math.min(0, currentSum);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 3, -4, 2, -3, -1, 7, -5 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minSubarraySum(arr));
	}
}
