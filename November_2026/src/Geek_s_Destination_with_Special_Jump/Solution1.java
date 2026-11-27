package Geek_s_Destination_with_Special_Jump;

public class Solution1 {
    public int minTime(int a, int b, int d, int l, int r) {
        long MOD = 1_000_000_007;
        long total = 0;
        
        for(int i=l;i<=r;i++) {
        	long target = d - i;
        	long current = 0;
        	long time = 0;
        	
        	while(current + a < target) {
        		current += a;
        		time +=a;
        		
        		current -= b;
        		time += b;
        	}
        	
        	long jumpTime = time + target - current + 1;
        	long p = a - b;
        	long k = (d - a + p - 1)/p;
        	long normalTime = a + (a+b) *k;
        	total = (total + Math.min(normalTime, jumpTime)) % MOD;
        }
        
        return (int)total;
    }
    
    public static void main(String[] args) {
		int a = 2;
		int b = 1;
		int d = 5;
		int l = 3;
		int r = 4;
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minTime(a, b, d, l, r));
	}
}