package Max_Digit_Sum_Number_in_1_to_n;

public class Solution1 {
	public int findMax(int n) {
		int result = 0;
		int max = -1;
		for(int i=1;i<=n;i++) {
			int temp = solve(i);
			if(result < temp) {
				result = Math.max(result, temp);
				max = i;
			}
		}
		
		return max;
    }
	
	private int solve(int n) {
		int sum = 0;
		
		while(n > 0) {
			sum += n % 10;
			n/=10;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Solution1 sol1 = new Solution1();
		int n = 1000000;
		System.out.println("Output: " + sol1.findMax(n));
	}
}
