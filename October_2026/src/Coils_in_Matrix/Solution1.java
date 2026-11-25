package Coils_in_Matrix;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1 {
	public ArrayList<ArrayList<Integer>> formCoils(int n) {
		int m = ((4 * n) * (4 * n)) / 2;

		ArrayList<Integer> ans1 = new ArrayList<>();
		ArrayList<Integer> ans2 = new ArrayList<>();
		int curr = 8 * n * n + 2 * n;
		ans2.add(curr);

		int flag = 1;
		int steps = 2;
		int index = 1;

		while (index < m) {
			for (int i = 0; i < steps && index < m; i++) {
				curr = curr - (4 * n * flag);
				ans2.add(curr);
				index++;
			}

			for (int i = 0; i < steps && index < m; i++) {
				curr = curr + flag;
				ans2.add(curr);
				index++;
			}

			steps += 2;
			flag *= -1;
		}

		for (int i = 0; i < m; i++) {
			int a = 16 * n * n + 1 - ans2.get(i);
			ans1.add(a);
		}

		Collections.reverse(ans1);
		Collections.reverse(ans2);

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(ans1);
		result.add(ans2);
		return result;
	}

	public static void main(String[] args) {
		int n = 1;

		Solution1 sol1 = new Solution1();
		ArrayList<ArrayList<Integer>> result = sol1.formCoils(n);
		for (ArrayList<Integer> ls : result) {
			System.out.println(ls);
		}
	}
}
