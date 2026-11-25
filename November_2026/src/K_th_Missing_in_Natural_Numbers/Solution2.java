package K_th_Missing_in_Natural_Numbers;

import java.util.Arrays;

public class Solution2 {
	public int findKthSmall(int[] arr, int k) {
		Arrays.sort(arr);
		for (int ele : arr) {
			if (ele <= k) {
				k++;
			} else {
				return k;
			}
		}

		return k;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 9, 5, 2 };
		int k = 6;

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.findKthSmall(arr, k));
	}
}
