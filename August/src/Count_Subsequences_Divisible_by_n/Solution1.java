package Count_Subsequences_Divisible_by_n;

public class Solution1 {
    public int countSubsequences(String s, int n) {
    	int index = 0;
    	int remainder = 0;
    	boolean isTaken = false;
    	return solve(s, n, index, remainder, isTaken);
    }
    
    private int solve(String s, int n, int index, int remainder, boolean isTaken) {
    	if(index == s.length()) {
    		if(isTaken & remainder == 0) {
    			return 1;
    		}
    		return 0;
    	}
    	
    	int d = s.charAt(index) - '0';
    	
    	int skip = solve(s, n, index+1, remainder, isTaken);
    	
    	int newRemainder = (remainder * 10 + d) % n;
    	int take = solve(s, n, index+1, newRemainder, true);
    	
    	return skip + take;
    }
    
    public static void main(String[] args) {
    	String s = "1234";
    	int n = 4;
    	
    	Solution1 m = new Solution1();
    	System.out.println("Output: " + m.countSubsequences(s, n));
	}
}
