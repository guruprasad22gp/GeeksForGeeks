package Sum_of_Pairwise_ANDs;

public class Solution1 {
    public long pairAndSum(int[] arr) {
    	long result = 0;
    	
    	for(int i=0;i<arr.length-1;i++) {
    		for(int j=i+1;j<arr.length;j++) {
    			result += arr[i] & arr[j];
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
    	int[] arr = {5, 10, 15};
    	Solution1 sol1 = new Solution1();
    	
    	System.out.println("Output: " + sol1.pairAndSum(arr));
	}
}
