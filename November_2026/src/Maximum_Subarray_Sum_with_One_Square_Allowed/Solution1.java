package Maximum_Subarray_Sum_with_One_Square_Allowed;

public class Solution1 {
	public int maximumSubarray(int[] arr) {
		int square = 0;
		int noSquare = 0;
		int ans = 0;
		for (int ele : arr) {
			int newNoSquare = Math.max(noSquare + ele, ele);
			int newSquare = Math.max(ele * ele, Math.max(noSquare + ele * ele, square + ele));
			square = newSquare;
			noSquare = newNoSquare;
			ans = Math.max(ans, Math.max(noSquare, square));
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { -1, -2, 3, -2, 3 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maximumSubarray(arr));
	}
}
