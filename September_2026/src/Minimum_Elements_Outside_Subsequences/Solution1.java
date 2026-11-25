package Minimum_Elements_Outside_Subsequences;

public class Solution1 {
    public int minCount(int[] arr) {
    	int n = arr.length;
    	int incr = Integer.MIN_VALUE;
    	int decr = Integer.MAX_VALUE;
    	int i = 0;
    	
    	return n - solve(i, incr, decr, arr);
    }
    
    private int solve(int index, int incr, int decr, int[] arr) {
    	if(index == arr.length) {
    		return 0;
    	}
    	
    	int skip = solve(index+1, incr, decr, arr);
    	
    	int takeInc = 0;
    	
    	if(arr[index] > incr) {
    		takeInc = 1 + solve(index+1, arr[index], decr, arr);
    	}
    	
    	int takeDecr = 0;
    	if(decr > arr[index]) {
    		takeDecr = 1 + solve(index+1, incr, arr[index], arr);
    	}
    	
    	return Math.max(skip, Math.max(takeInc, takeDecr));
    }
    
    public static void main(String[] args) {
    	int arr[] = {1, 3, 2};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.minCount(arr));
	}
}
