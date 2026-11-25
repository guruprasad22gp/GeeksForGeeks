package XOR_of_Number_Range;

public class Solution1 {
	public int findXOR(int l, int r) {
		return find(r) ^ find(l - 1);
	}

	private int find(int n) {
		if (n < 0) {
			return 0;
		}

		switch (n % 4) {
		case 0:
			return n;
		case 1:
			return 1;
		case 2:
			return n + 1;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		int l = 4;
		int r = 8;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findXOR(l, r));
	}
}
