package Successful_Binary_Searches_Irrespective_of_Pivot;

public class Solution1 {
	public int countAlwaysFound(int[] arr) {
		int n = arr.length;
		int[] minimum = new int[n];
		minimum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			minimum[i] = Math.max(minimum[i - 1], arr[i]);
		}

		int[] maximum = new int[n];
		maximum[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			maximum[i] = Math.min(maximum[i + 1], arr[i]);
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (minimum[i] <= arr[i] && arr[i] <= maximum[i]) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 7, 9, 8, 15 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.countAlwaysFound(arr));
	}
}
