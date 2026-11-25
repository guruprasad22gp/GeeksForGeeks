package Maximum_Height_Disc_Stack;

import java.util.Arrays;

public class Solution3 {
	public int maxStackHeight(int[] r, int[] h) {
		int n = r.length;
		
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0] = r[i];
			arr[i][1] = h[i];
		}
		
		Arrays.sort(arr, (a, b) -> {
			return a[0] - b[0];
		});
		
		int[] dp = new int[n];
		for(int i=0;i<n;i++) {
			dp[i] = arr[i][1];
		}
		
		int result = 1;
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i][1]);
					result = Math.max(result, dp[i]);
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		int r[] = { 5, 7, 3 };
		int h[] = { 6, 5, 4 };

		Solution3 sol3 = new Solution3();
		System.out.println("Output: " + sol3.maxStackHeight(r, h));
	}
}
