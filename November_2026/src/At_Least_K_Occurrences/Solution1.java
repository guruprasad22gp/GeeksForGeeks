package At_Least_K_Occurrences;

public class Solution1 {
	public int firstElementKTime(int[] arr, int k) {
		int[] freq = new int[1000001];
		for (int ele : arr) {
			freq[ele]++;
			if (freq[ele] == k) {
				return ele;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 7, 4, 3, 4, 8, 7 };
		int k = 2;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.firstElementKTime(arr, k));
	}
}
