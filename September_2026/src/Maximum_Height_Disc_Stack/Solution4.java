package Maximum_Height_Disc_Stack;

import java.util.Arrays;

public class Solution4 {
	public int maxStackHeight(int[] r, int[] h) {
		int n = r.length;
		
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0] = r[i];
			arr[i][1] = h[i];
		}
		
		Arrays.sort(arr, (a, b) -> {
			if(a[0] == b[0]) {
				return b[1] - a[1];
			}
			return a[0] - b[0];
		});
		
		int[] dp = new int[1001];
		
		int result = 0;
		for(int i=0;i<n;i++) {
			int height = arr[i][1];
			int best = dp[height-1];
			
			int current = best + height;
			update(height, current, dp);
			
			result = Math.max(current, result);
		}
		
		return result;
	}
	
	private void update(int index, int value, int[] dp) {
		while(index < dp.length) {
			dp[index] = Math.max(dp[index], value);
			index++;
		}
	}

	public static void main(String[] args) {
		int r[] = { 5, 7, 3 };
		int h[] = { 6, 5, 4 };

		Solution4 sol4 = new Solution4();
		System.out.println("Output: " + sol4.maxStackHeight(r, h));
	}
}