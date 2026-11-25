package Count_Indices_That_Escape_the_Array;

public class Solution1 {
	int[] visited;

	public int goodIndices(int[] arr) {
		int n = arr.length;
		visited = new int[n];

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				DFS(i, arr, visited, n);
			}
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == 1) {
				count++;
			}
		}

		return count;
	}

	private int DFS(int source, int[] arr, int[] visited, int n) {
		if (source < 0 || source >= n) {
			return 1;
		}

		if (visited[source] == 1 || visited[source] == 2) {
			return visited[source];
		}

		if (arr[source] == 0) {
			return visited[source] = 2;
		}

		if (visited[source] == 3) {
			return 3;
		}
		visited[source] = 3;

		int v = source + arr[source];
		return visited[source] = DFS(v, arr, visited, n);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 0, -3, 0, -5, 0 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.goodIndices(arr));
	}
}