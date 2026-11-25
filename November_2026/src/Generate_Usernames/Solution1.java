package Generate_Usernames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution1 {
	public ArrayList<String> generateUsernames(String[] arr) {
		HashMap<String, Integer> map = new HashMap<>();
		HashSet<String> used = new HashSet<>();
		HashSet<String> reserved = new HashSet<>(Arrays.asList(arr));
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			if (!used.contains(s)) {
				result.add(s);
				used.add(s);
			} else {
				int k = map.getOrDefault(s, 1);
				while (reserved.contains(s + k) || used.contains(s + k)) {
					k++;
				}
				result.add(s + k);
				used.add(s + k);
				map.put(s, k + 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String arr[] = { "a", "a", "a1", "a" };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.generateUsernames(arr));
	}
}
