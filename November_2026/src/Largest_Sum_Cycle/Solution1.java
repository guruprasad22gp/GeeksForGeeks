package Largest_Sum_Cycle;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	int result = -1;

	public int largestSumCycle(int[] edge) {
		int n = edge.length;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			int u = i;
			int v = edge[i];
			if (v == -1) {
				continue;
			}

			adj.get(u).add(v);
		}

		int[] sum = new int[n];
		for (int i = 0; i < n; i++) {
			sum[i] = i;
		}
		boolean[] visited = new boolean[n];
		boolean[] recursion = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				DFS(i, adj, visited, recursion, sum);
			}
		}

		return result;
	}

	void DFS(int u, List<List<Integer>> adj, boolean[] visited, boolean[] recursion, int[] sum) {
		visited[u] = true;
		recursion[u] = true;

		for (int v : adj.get(u)) {
			if (!visited[v]) {
				sum[v] = sum[u] + v;
				DFS(v, adj, visited, recursion, sum);
			} else if (recursion[v]) {
				result = Math.max(result, sum[u] - sum[v] + v);
			}
		}

		recursion[u] = false;
	}

	public static void main(String[] args) {
		int[] edge = { 1, 2, 3, 0, -1, 4, 5, 0, 9, 8 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.largestSumCycle(edge));
	}
}