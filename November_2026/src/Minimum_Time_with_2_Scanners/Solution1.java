package Minimum_Time_with_2_Scanners;

public class Solution1 {
	public int minTime(int n, int s1, int s2) {
		int high = n * Math.max(s1, s2);
		int low = 0;
		int ans = high;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int count = mid / s1 + mid / s2;
			if (count >= n) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int n = 2, s1 = 2, s2 = 4;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minTime(n, s1, s2));
	}
}
