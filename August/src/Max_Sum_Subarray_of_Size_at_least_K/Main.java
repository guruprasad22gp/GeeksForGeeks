package Max_Sum_Subarray_of_Size_at_least_K;

public class Main {
    public int maxSumWithK(int[] arr, int k) {
    	int n = arr.length;
    	int[] bestSum = new int[n];
    	bestSum[0]= arr[0];
    	for(int i=1;i<n;i++) {
    		bestSum[i] = Math.max(arr[i], arr[i] + bestSum[i-1]);
    	}
    	
    	int windowSum = 0;
    	for(int i=0;i<k;i++) {
    		windowSum += arr[i];
    	}
    	
    	int maxSum = windowSum;
    	for(int i=k;i<n;i++) {
    		windowSum += arr[i] - arr[i-k];
    		maxSum = Math.max(windowSum, maxSum);
    		maxSum = Math.max(maxSum, windowSum+bestSum[i-k]);
    	}
    	
    	return maxSum;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,-2, 2, -3};
		int k = 3;
		
		Main m = new Main();
		System.out.println("Output: " + m.maxSumWithK(arr, k));
	}
}
