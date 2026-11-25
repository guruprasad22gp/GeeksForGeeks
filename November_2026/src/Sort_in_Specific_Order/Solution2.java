package Sort_in_Specific_Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution2 {
	public void sortIt(int[] arr) {
		ArrayList<Integer> odd = new ArrayList<>();
		ArrayList<Integer> even = new ArrayList<>();
		for (int ele : arr) {
			if (ele % 2 == 0) {
				even.add(ele);
			} else {
				odd.add(ele);
			}
		}

		Collections.sort(odd, Collections.reverseOrder());
		Collections.sort(even);

		int i = 0;
		for (int ele : odd) {
			arr[i++] = ele;
		}

		for (int ele : even) {
			arr[i++] = ele;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 4, 7, 10 };
		Solution2 sol1 = new Solution2();
		System.out.println(Arrays.toString(arr));
		sol1.sortIt(arr);
		System.out.println(Arrays.toString(arr));

	}
}
