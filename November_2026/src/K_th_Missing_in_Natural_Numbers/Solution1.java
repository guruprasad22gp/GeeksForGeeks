package K_th_Missing_in_Natural_Numbers;

import java.util.HashSet;

public class Solution1 {
	public int findKthSmall(int[] arr, int k) {
		int n = arr.length + k;
		HashSet<Integer> set = new HashSet<>();
		for (int ele : arr) {
			set.add(ele);
		}

		for (int i = 1; i <= n; i++) {
			if (!set.contains(i)) {
				k--;
				if (k == 0) {
					return i;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 9, 5, 2 };
		int k = 6;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findKthSmall(arr, k));
	}
}
