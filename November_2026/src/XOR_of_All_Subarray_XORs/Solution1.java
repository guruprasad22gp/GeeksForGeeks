package XOR_of_All_Subarray_XORs;

public class Solution1 {
	public int subarrayXor(int[] arr) {
		int xor = 0;
		long n = arr.length;
		for (int i = 0; i < n; i++) {
			long count = (i + 1) * (n - i);
			if (count % 2 == 1) {
				xor ^= arr[i];
			}
		}

		return xor;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.subarrayXor(arr));
	}
}
