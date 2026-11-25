package Sort_in_Specific_Order;

import java.util.Arrays;

public class Solution1 {
	public void sortIt(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] % 2 == 1) {
				arr[i] *= -1;
			}
		}

		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				arr[i] *= -1;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 4, 7, 10 };
		Solution1 sol1 = new Solution1();
		System.out.println(Arrays.toString(arr));
		sol1.sortIt(arr);
		System.out.println(Arrays.toString(arr));

	}
}
