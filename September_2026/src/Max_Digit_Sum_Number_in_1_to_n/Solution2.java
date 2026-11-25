package Max_Digit_Sum_Number_in_1_to_n;

public class Solution2 {
	public int findMax(int n) {
		String num = String.valueOf(n);
		
		int ans = n;
		int bestSum = solve(n);
		
		for(int i=0;i<num.length();i++) {
			if(num.charAt(i) == '0') {
				continue;
			}
			
			StringBuilder sb = new StringBuilder(num);
			sb.setCharAt(i, (char)(sb.charAt(i) - 1));
			
			for(int j=i+1;j< num.length(); j++) {
				sb.setCharAt(j, (char)'9');
			}
			
			int candidate = Integer.parseInt(sb.toString());
			int sum = solve(candidate);
			
			if(sum > bestSum || (sum == bestSum && candidate > ans)) {
				bestSum = sum;
				ans = candidate;
			}
		}
		
		return ans;
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
		Solution2 sol2 = new Solution2();
		int n = 48;
		System.out.println("Output: " + sol2.findMax(n));
	}
}
