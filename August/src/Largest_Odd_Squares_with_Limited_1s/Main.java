package Largest_Odd_Squares_with_Limited_1s;

import java.util.ArrayList;

public class Main {
	public  ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
		int m = mat.length;
		int n = mat[0].length;
		
		int[][] prefix = new int[m+1][n+1];
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				prefix[i][j] = mat[i-1][j-1] + prefix[i][j-1] + prefix[i-1][j] - prefix[i-1][j-1];
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int[] query: queries) {
			int first = query[0];
			int second = query[1];
			
			int maxRadius = Math.min(Math.min(first, second), Math.min(m-first-1, n-second-1));
			
			int low = 0;
			int high = maxRadius;
			
			int best = -1;
			
			while(low <= high) {
				int radius = low + (high-low)/2;
				int top = first - radius;
				int bottom = first + radius;
				int left = second - radius;
				int right = second + radius;
				
				int ones = prefix[bottom+1][right+1] - prefix[top][right+1] - prefix[bottom+1][left] + prefix[top][left];
				
				if(ones <= k) {
					best = radius;
					low = radius + 1;
				} else {
					high = radius - 1;
				}
			}
			
			if(best == -1) {
				result.add(-1);
			} else {
				result.add(2*best + 1);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		int[][] mat = {
				{1, 0, 1, 0, 0},
				{1, 0, 1, 1, 1}, 
				{1, 1, 1, 1, 1}, 
				{1, 0, 0, 1, 0}
		};
		
		int[][] queries = {
				{1, 2}
		};
		
		int k = 9;
		ArrayList<Integer> result = m.largestSquare(mat, queries, k);
		System.out.println("Output: " + result);
	}
}
