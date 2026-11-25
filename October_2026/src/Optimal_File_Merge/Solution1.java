package Optimal_File_Merge;

import java.util.PriorityQueue;

public class Solution1 {
	public int minComputation(int[] files) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);

		for (int ele : files) {
			queue.add(ele);
		}

		int sum = 0;
		while (queue.size() > 1) {
			int s = queue.poll() + queue.poll();
			queue.add(s);
			sum += s;
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] files = { 2, 3, 6, 5, 7, 4 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minComputation(files));
	}
}
