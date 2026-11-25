package Any_Duplicate_Within_K_Distance;

import java.util.HashSet;

public class Solution1 {
	public boolean checkWithinK(int[] arr, int k) {
		HashSet<Integer> seen = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (seen.contains(arr[i])) {
				return true;
			}
			seen.add(arr[i]);
			if (seen.size() > k) {
				seen.remove(arr[i - k]);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 4, 5, 1 };
		int k = 3;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.checkWithinK(arr, k));
	}
}