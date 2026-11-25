package Minimum_Cost_for_n_Characters;

public class Solution1 {
	public static void main(String[] args) {
		int n = 73;
		int i = 9;
		int d = 2;
		int c = 5;
		
		Solution1 m = new Solution1();
		System.out.println("Output: " + m.minCost(n, i, d, c));
	}
	
	public int minCost(int n, int i, int d, int c) {
         return solve(n, i, d, c);
    }
	
	private int solve(int n, int i, int d, int c) {
		if(n == 0) {
			return 0;
		}
		
		if(n == 1) {
			return i;
		}
		
		int ans = n * i;
		
		if(n % 2 == 0) {
			int copy = c + solve(n/2, i, d, c);
			ans = Math.min(ans, copy);
		} else {
			int down = i + solve(n-1, i, d, c);
			int up = d + c + solve((n +1)/2, i, d, c);
			ans = Math.min(ans, Math.min(down, up));
		}
		
		return ans;
	}
}
