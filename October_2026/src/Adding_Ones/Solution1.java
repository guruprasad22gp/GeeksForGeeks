package Adding_Ones;

import java.util.ArrayList;

public class Solution1 {
	public static void main(String[] args) {
		int n = 3;
		int updates[] = { 1, 1, 2, 3 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.update(n, updates));
	}

	public ArrayList<Integer> update(int n, int[] updates) {
		int[] diff = new int[n];
		for (int ele : updates) {
			diff[ele - 1]++;
		}

		int count = 0;
		ArrayList<Integer> result = new ArrayList<>();
		for (int ele : diff) {
			count += ele;
			result.add(count);
		}

		return result;
	}
}
