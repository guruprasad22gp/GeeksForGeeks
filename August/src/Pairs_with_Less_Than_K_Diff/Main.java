package Pairs_with_Less_Than_K_Diff;

import java.util.Arrays;

public class Main {
	public static int countPairs(int arr[], int k) {
		Arrays.sort(arr);
		
		int count = 0;
		int left = 0;
		
		for(int right = 1; right < arr.length; right++) {
			while(arr[right] - arr[left] >= k) {
				left++;
			}
			
			count += right - left;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int k = 3;
		
		System.out.println("Output: " + countPairs(arr, k));
	}
}
