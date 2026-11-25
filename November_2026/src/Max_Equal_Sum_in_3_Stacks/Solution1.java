package Max_Equal_Sum_in_3_Stacks;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
	public int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2, ArrayList<Integer> s3) {
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		for (int ele : s1) {
			sum1 += ele;
		}

		for (int ele : s2) {
			sum2 += ele;
		}

		for (int ele : s3) {
			sum3 += ele;
		}
		int i = 0;
		int j = 0;
		int k = 0;
		while (!(sum1 == sum2 && sum2 == sum3)) {
			if (sum1 >= sum2 && sum1 >= sum3) {
				sum1 -= s1.get(i);
				i++;
			} else if (sum2 >= sum1 && sum2 >= sum3) {
				sum2 -= s2.get(j);
				j++;
			} else {
				sum3 -= s3.get(k);
				k++;
			}
		}
		return sum1;

	}

	public static void main(String[] args) {
		ArrayList<Integer> s1 = new ArrayList<>(Arrays.asList(3, 2, 1, 1, 1));
		ArrayList<Integer> s2 = new ArrayList<>(Arrays.asList(4, 3, 2));
		ArrayList<Integer> s3 = new ArrayList<>(Arrays.asList(2, 5, 4, 1));

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxEqualSum(s1, s2, s3));
	}
}
