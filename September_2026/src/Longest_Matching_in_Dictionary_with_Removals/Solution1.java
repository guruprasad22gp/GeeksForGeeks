package Longest_Matching_in_Dictionary_with_Removals;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public String findLongestWord(String s, List<String> d) {		
		d.sort((a, b) -> {
			if(a.length() == b.length()) {
				return a.compareTo(b);
			}
			return b.length() - a.length();
		});
		
		for(String str: d) {
			int ans = longestCommonSubsequence(str, s);
			
			if(ans == str.length()) {
				return str;
			}
		}
		
		return "";
		
	}
	
	private int longestCommonSubsequence(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];
		
		for(int i=m-1;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				if(s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = 1 + dp[i+1][j+1];
				} else {
					int skipI = dp[i+1][j];
					int skipJ = dp[i][j+1];
					
					dp[i][j] = Math.max(skipI, skipJ);
				}
			}
		}
		
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		List<String> d = new ArrayList<>(List.of("ale", "apple", "monkey", "plea"));
//		List<String> d = new ArrayList<>(List.of("w","a", "b", "c"));

		
		String s = "abpcplea";
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findLongestWord(s, d));
	}
}
