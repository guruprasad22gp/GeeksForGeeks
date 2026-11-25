package Max_Adjacent_Diffs_Sum_with_1_Replacements;

public class Solution1 {
	int[][] dp;
    public int maxDiffSum(int[] arr) {
    	int index = 1;
    	
        int keep = solve(index, arr[0], arr);
        int replace = solve(index, 1, arr);
        
        return Math.max(replace, keep);
    }
    
    private int solve(int index, int prev, int[] arr) {
    	if(index == arr.length) {
    		return 0;
    	}
    	
    	int keep = Math.abs(arr[index] - prev) + solve(index+1, arr[index], arr);
    	int replace = Math.abs(prev - 1) + solve(index+1, 1, arr);
    	
    	return Math.max(keep, replace);
    }
    
    public static void main(String[] args) {
    	int arr[] = {3, 2, 1, 4, 5};

    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.maxDiffSum(arr));
	}
}
