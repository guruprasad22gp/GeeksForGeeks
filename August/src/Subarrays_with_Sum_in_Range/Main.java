package Subarrays_with_Sum_in_Range;

public class Main {
	public int countSubarray(int[] arr, int l, int r) {
		return sum(arr, r) - sum(arr, l-1);
	}
	
	private int sum(int[] arr, int target) {
		int count = 0;
		
		int left = 0;
		int currentSum = 0;
		
		for(int right=0;right<arr.length;right++) {
			currentSum += arr[right];
			
			while(currentSum > target && left <= right) {
				currentSum -= arr[left];
				left++;
			}
			
			count += right - left + 1;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		
		int[] arr = {1,4,6};
		
		System.out.println("Output: " + m.countSubarray(arr, 3, 8));
	}
}
