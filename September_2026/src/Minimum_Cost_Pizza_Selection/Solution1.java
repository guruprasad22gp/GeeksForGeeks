package Minimum_Cost_Pizza_Selection;

public class Solution1 {
	int S;
	int M;
	int L;
	int CS;
	int CM;
	int CL;
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
    	S = s;
    	M = m;
    	L = l;
    	CS = cs;
    	CM = cm;
    	CL = cl;
        return solve(x);
    }
    
    private int solve(int x) {
    	if(x <= 0) {
    		return 0;
    	}
    	
    	int tS = CS + solve(x - S);
    	int tM = CM + solve(x - M);
    	int tL = CL + solve(x - L);
    	
    	return Math.min(tS, Math.min(tM, tL));
    }
    
	public static void main(String[] args) {
		int x = 16;
		int s = 3;
		int m = 6;
		int l = 9;
		int cs = 50;
		int cm = 150;
		int cl = 300;
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minimumCost(x, s, m, l, cs, cm, cl));
	}
}
