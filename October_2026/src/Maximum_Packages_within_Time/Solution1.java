package Maximum_Packages_within_Time;

public class Solution1 {
	public int maxPackages(int[] arr, int totalTime) {
		int n = arr.length;
		int maxEle = 0;
		for (int i = 0; i < totalTime && i < n; i++) {
			maxEle += arr[i];
		}
		int max = maxEle;
		for (int i = totalTime; i < n; i++) {
			maxEle += arr[i] - arr[i - totalTime];
			max = Math.max(max, maxEle);
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 1, 3, 5, 0, 1, 4 };
		int totalTime = 3;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxPackages(arr, totalTime));
	}
}
