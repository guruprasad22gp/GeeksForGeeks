package Count_Palindromic_Strings_with_Constraints;

public class Solution1 {
	public static void main(String[] args) {
		int n = 5;
		int k = 3;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.palindromicStrings(n, k));
	}
	
	int ans = 0;
	int MOD = 1000000007;
    public int palindromicStrings(int n, int k) {
    	for(int i=1;i<=n;i++) {
        	StringBuilder sb = new StringBuilder();
    		solve(sb, i, k);
    	}
    	
    	return ans;
    }
    
    private void solve(StringBuilder sb, int len, int k) {
    	if(sb.length() == len) {
    		if(isPalindrome(sb.toString())) {
    			ans = (ans+1) % MOD;
    		}
    		
    		return;
    	}
    	
    	for(int i=0;i<k;i++) {
    		sb.append((char)('a'+i));
    		solve(sb, len, k);
    		sb.deleteCharAt(sb.length()-1);
    	}
     }
    
    private boolean isPalindrome(String str) {
    	int[] freq = new int[26];
    	for(char ch: str.toCharArray()) {
    		freq[ch-'a']++;
    	}
    	
    	for(int ele: freq) {
    		if(ele >2) {
    			return false;
    		}
    	}
    	
    	StringBuilder temp = new StringBuilder(str);
    	temp.reverse();
    	
    	return str.equals(temp.toString());
    }
}
