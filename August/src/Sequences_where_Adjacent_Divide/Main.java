package Sequences_where_Adjacent_Divide;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	int dp[][];
	public int count(int n, int m) {
		dp = new int[n+1][m+1];
		for(int x[]: dp) {
			Arrays.fill(x, -1);
		}
		
		int ans = 0;
		
		for(int i=1;i<=m;i++) {
			ans += solve(n, m, 1, i);
		}
		
		return ans;
	}
	
	public int solve(int n, int m, int index, int prev) {
		if(index == n) {
			return 1;
		}
		
		if(dp[index][prev] != -1) {
			return dp[index][prev];
		}
		
		int ans = 0;
		for(int curr = 1; curr <= m; curr++) {
			if(curr % prev == 0 || prev % curr == 0) {
				ans += solve(n, m, index+1, prev);
			}
		}
		
		return dp[index][prev] = ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Main mn = new Main();
		System.out.println("Output: " + mn.count(n, m));
		
		sc.close();
	}
}
