package Maximum_Height_Disc_Stack;

import java.util.Arrays;

public class Solution2 {
	int[][] dp;
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
		
		dp = new int[n+1][n+1];
		for(int[] x: dp) {
			Arrays.fill(x, -1);
		}
		
		return solve(0, -1, arr);
	}
	
	private int solve(int i, int prevI, int[][] arr) {
		if(i >= arr.length) {
			return 0;
		}
		
		int prev = prevI + 1;
		if(dp[i][prev] != -1) {
			return dp[i][prev];
		}
		
		int skip = solve(i+1, prevI, arr);
		
		int take = 0;
		if(prevI == -1 || (arr[i][0] > arr[prevI][0] && arr[i][1] > arr[prevI][1])) {
			take = arr[i][1] + solve(i+1, i, arr);
		}
		
		return dp[i][prev] = Math.max(take, skip);
	}

	public static void main(String[] args) {
		int r[] = { 5, 7, 3 };
		int h[] = { 6, 5, 4 };

		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.maxStackHeight(r, h));
	}
}
