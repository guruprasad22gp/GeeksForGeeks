package Unoccupied_Computers;

public class Solution1 {
    public int solve(int n, String s) {
    	int[] state = new int[26];
    	int computers = n;
    	int ans = 0;
    	
    	for(char ch: s.toCharArray()) {
    		int index = ch - 'A';
    		if(state[index] == 0) {
    			if(computers > 0) {
    				computers--;
    				state[index] = 1;
    			} else {
    				ans++;
    				state[index] = 2;
    			}
    		} else if(state[index] == 1) {
    			state[index] = 0;
    			computers++;
    		} else {
    			state[index] = 0;
    		}
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	int n = 3;
    	String s = "GACCBDDBAGEE";
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.solve(n, s));
	}
}
