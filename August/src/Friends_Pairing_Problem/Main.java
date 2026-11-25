package Friends_Pairing_Problem;

public class Main {
	public long countFriendsPairings(int n) {
        return solve(n);
    }
	
	private int solve(int n) {
		if(n == 1 || n == 2) {
			return n;
		} else {
			return solve(n-1) + (n - 1) * solve(n-2);
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		Main m = new Main();
		System.out.println("Output: "  + m.countFriendsPairings(n));
	}
}
