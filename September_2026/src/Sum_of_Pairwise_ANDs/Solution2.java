package Sum_of_Pairwise_ANDs;

public class Solution2 {
    public long pairAndSum(int[] arr) {
    	long result = 0;
    	
    	for(int i=0;i<32;i++) {
    		long k = 0;
    		
    		for(int j=0;j<arr.length;j++) {
    			if((arr[j] & (1 << i)) != 0) {
    				k++;
    			}
    		}
    		
    		result += (1 << i) * (k * (k-1)/2);
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
    	int[] arr = {5, 10, 15};
    	Solution2 sol2 = new Solution2();
    	
    	System.out.println("Output: " + sol2.pairAndSum(arr));
	}
}
