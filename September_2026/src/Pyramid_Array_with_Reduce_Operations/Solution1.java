package Pyramid_Array_with_Reduce_Operations;

public class Solution1 {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1;
        for(int i=1;i<n;i++) {
        	left[i] = Math.min(arr[i], 1 + left[i-1]); 
        }
        
        right[n-1] = 1;
        for(int i=n-2;i>=0;i--) {
        	right[i] = Math.min(arr[i], 1 + right[i+1]);
        }
        
        int maxSum = 0;
        int sum = 0;
        for(int i = 0; i<n;i++) {
        	int peakEle = Math.min(left[i], right[i]);
        	sum += arr[i];
        	if(maxSum < peakEle * peakEle) {
        		maxSum = peakEle * peakEle;
        	}
        }
        
        return sum - maxSum;
    }
    
    public static void main(String[] args) {
		int[] arr = {1, 2, 1};
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.formPyramid(arr));
	}
}
