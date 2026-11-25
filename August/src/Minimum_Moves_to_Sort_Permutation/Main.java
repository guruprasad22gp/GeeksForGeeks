package Minimum_Moves_to_Sort_Permutation;

public class Main {
	public int minMoves(int[] arr) {
		int n = arr.length;
		int[] pos = new int[n+1];
		for(int i=0;i<n;i++) {
			pos[arr[i]] = i;
		}
		
		int current = 1;
		int max = 0;
		
		for(int i=2;i<=n;i++) {
			if(pos[i-1] < pos[i]) {
				current++;
			} else {
				max = Math.max(max, current);
				current = 1;
			}
		}
		
		return n - Math.max(max, current);
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 3,1,2};
		
		Main m = new Main();
		System.out.println("Output: " + m.minMoves(arr));
	}
}
