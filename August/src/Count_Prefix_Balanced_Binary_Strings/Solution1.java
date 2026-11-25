package Count_Prefix_Balanced_Binary_Strings;

public class Solution1 {
    public int prefixStrings(int n) {
    	if(n == 1) {
    		return 1;
    	}
    	
    	return solve(2 *n, 0, 0);
    }
    
    private int solve(int n, int index, int balance) {
    	if(index == n) {
    		if(balance == 0) {
    			return 1;
    		}
    		
    		return 0;
    	}
    	
    	if(balance < 0) {
    		return 0;
    	}
    	
    	return solve(n, index+1, balance+1) + solve(n, index+1, balance-1);
    }
    
    public static void main(String[] args) {
		int n = 4;
		
		Solution1 sol = new Solution1();
		System.out.println("Output: " + sol.prefixStrings(n));
	}
}

// n = 2 [1100, 1010]
