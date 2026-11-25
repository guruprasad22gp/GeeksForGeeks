package Numbers_Without_d_as_Digit;

public class Solution1 {
	public static void main(String[] args) {
		 int n = 222;
		 int d = 2;
		 
		 Solution1 m = new Solution1();
		 
		 System.out.println("Output: " + m.countWithout(n, d));
	}
	
	public int countWithout(int n, int d) {
		int count = 0;
		
		for(int i=1;i<=n;i++) {
			if(solve(i, d)) {
				count++;
			}
		}
		
		return count;
	}
	
	private boolean solve(int n, int d) {
		while(n > 0) {
			int temp = n % 10;
			if(temp == d) {
				return false;
			}
			
			n /= 10;
		}
		
		return true;
	}
}
