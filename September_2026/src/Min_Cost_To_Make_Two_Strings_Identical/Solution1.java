package Min_Cost_To_Make_Two_Strings_Identical;

public class Solution1 {
	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "acdb";
		int  costS1 = 10;
		int costS2 = 20;
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findMinCost(s1, s2, costS1, costS2));
	}
	
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
          int n = longestCommonSequence(s1, s2);
          
          int len1 = s2.length() - n;
          int len2 = s2.length() - n;
          
          int total = len1 * costS1 + len2 * costS2;
          return total;
    }
    
    private int longestCommonSequence(String s1, String s2) {
    	int m = s1.length();
    	int n = s2.length();
    	
    	int[][] dp = new int[m+1][n+1];
    	
    	for(int i=m-1;i>=0;i--) {
    		for(int j=n-1;j>=0;j--) {
    			if(s1.charAt(i) == s2.charAt(j)) {
    				dp[i][j] = 1 + dp[i+1][j+1];
    			} else {
    				dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
    			}
    		}
    	}
    	
    	return dp[0][0];
    }
}
