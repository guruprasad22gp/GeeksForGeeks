package Longest_Subsequence_with_Adjacent_Diff_as_1;

public class Solution3 {
    public static void main(String[] args) {
		int arr[] = {10, 9, 4, 5, 4, 8, 6};
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.longestSubseq(arr));
	}
    
    public int longestSubseq(int[] arr) {
    	int[] dp = new int[1000002];
    	int ans = 0;
    	
    	for(int x: arr) {
    		dp[x] = Math.max(dp[x-1], dp[x+2])+1;
    		ans = Math.max(ans, dp[x]);
    	}
    	
    	return ans;
    }
}
