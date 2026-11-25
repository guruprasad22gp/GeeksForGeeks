package XOR_of_All_Subarray_XORs;

public class Solution2 {
	public int subarrayXor(int[] arr) {
		int xor = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = i; j < n; j++) {
				sum ^= arr[j];
				xor ^= sum;
			}
		}

		return xor;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.subarrayXor(arr));
	}
}