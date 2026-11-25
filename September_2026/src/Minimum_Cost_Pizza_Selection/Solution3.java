package Minimum_Cost_Pizza_Selection;

public class Solution3 {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
    	int[] dp = new int[500];
    	
    	for(int i=1;i<=x;i++) {
    		int tS = cs + (i - s > 0? dp[i - s]: 0);
    		int tM = cm + (i - m > 0? dp[i - m]: 0);
    		int tL = cl + (i - l > 0? dp[i - l]: 0);
    		
    		dp[i] = Math.min(tS, Math.min(tM, tL));
    	}
    	
    	return dp[x];
    }
    
 	public static void main(String[] args) {
		int x = 16;
		int s = 3;
		int m = 6;
		int l = 9;
		int cs = 50;
		int cm = 150;
		int cl = 300;
		
		Solution3 sol3 = new Solution3();
		System.out.println("Output: " + sol3.minimumCost(x, s, m, l, cs, cm, cl));
	}
}
