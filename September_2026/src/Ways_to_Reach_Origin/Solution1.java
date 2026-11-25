package Ways_to_Reach_Origin;

public class Solution1 {
	int MOD = 1_000_000_007;
	public static void main(String[] args) {
		int x = 2;
		int y = 2;
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.ways(x, y));
	}
	
    public int ways(int x, int y) {
    	return solve(x, y);
    }
    
    private int solve(int x, int  y) {
    	if(x == 0 && y == 0) {
    		return 1;
    	}
    	
    	if(x < 0 || y < 0) {
    		return 0;
    	}
    	return (solve(x-1, y) + solve(x, y-1))%MOD;
    }
}
