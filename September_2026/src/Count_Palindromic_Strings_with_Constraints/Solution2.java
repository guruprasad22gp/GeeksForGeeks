package Count_Palindromic_Strings_with_Constraints;

public class Solution2 {
	public static void main(String[] args) {
		int n = 52;
		int k = 26;

		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.palindromicStrings(n, k));
	}
	
	int MOD = 1000000007;
//	933439718
	public int palindromicStrings(int n, int k) {
    	long result = 0;
    	
    	for(int i=1;i<=n;i++) {
    		int m = (i+1)/2;
    		
    		long ans = 1;
    		for(int j=0;j<m;j++) {
    			ans = (ans * (k - j)) % MOD;
    		}
    		
    		result = (result + ans) % MOD;
    	}
    	
    	return (int) result;
    }
}