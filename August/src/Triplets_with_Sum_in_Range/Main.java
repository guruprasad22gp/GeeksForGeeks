package Triplets_with_Sum_in_Range;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 2};
		int l = 2, r = 13;
		
		Main m = new Main();
		System.out.println("Output: " + m.countTriplets(arr, l, r));
	}
	
	public int countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);
        
        return solve(arr, r) - solve(arr, l-1);
    }
	
	private int solve(int[] arr, int limit) {
		int count = 0;
		int n = arr.length;
		
		for(int i=0;i<n-2;i++) {
			int left = i+1;
			int right = n-1;
			
			while(left < right) {
				int sum = arr[left] + arr[right] + arr[i];
				
				if(sum <= limit) {
					count += (right - left);
					left++;
				} else {
					right--;
				}
			}
		}
		
		return count;
	}
}
