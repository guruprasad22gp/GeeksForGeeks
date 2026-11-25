package Sort_Two_Parts_Sorted;

import java.util.Arrays;

public class Solution1 {
	public void mergeTwoParts(int[] arr) {
		int n = arr.length;
		int j = 0;
		while (j + 1 < n && arr[j] <= arr[j + 1]) {
			j++;
		}

		j++;

		if (j == n) {
			return;
		}

		int m = j;
		int i = 0;
		int k = 0;
		int[] res = new int[n];
		while (i < m && j < n) {
			if (arr[i] < arr[j]) {
				res[k++] = arr[i++];
			} else {
				res[k++] = arr[j++];
			}
		}

		while (i < m) {
			res[k++] = arr[i++];
		}

		while (j < n) {
			res[k++] = arr[j++];
		}

		for (i = 0; i < n; i++) {
			arr[i] = res[i];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 8, -1, 7, 10 };

		Solution1 sol1 = new Solution1();

		sol1.mergeTwoParts(arr);

		System.out.println("Output: " + Arrays.toString(arr));
	}
}
