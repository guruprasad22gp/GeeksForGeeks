package Two_Pairs_with_Same_Sum;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution1 {
	public ArrayList<Integer> findPairs(int[] arr) {
		HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			res.add(-1);
		}
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = arr[i] + arr[j];
				ArrayList<int[]> index = map.computeIfAbsent(sum, k -> new ArrayList<>());
				for (int[] x : index) {
					int a = x[0];
					int b = x[1];

					if (a != i && a != j && b != i && b != j) {
						ArrayList<Integer> temp = new ArrayList<>();
						temp.add(a);
						temp.add(b);
						temp.add(i);
						temp.add(j);

						if (res.get(0) == -1 || compare(temp, res)) {
							res = temp;
						}
						break;
					}
				}
				index.add(new int[] { i, j });
			}
		}

		return res;
	}

	private boolean compare(ArrayList<Integer> temp, ArrayList<Integer> ans) {
		for (int i = 0; i < 4; i++) {
			if (!temp.get(i).equals(ans.get(i))) {
				return temp.get(i) < ans.get(i);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 7, 1, 2, 9, 8 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findPairs(arr));
	}
}