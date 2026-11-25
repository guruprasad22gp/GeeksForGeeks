package Longest_Subsequence_with_Adjacent_Diff_as_1;

public class Solution1 {
    public int longestSubseq(int[] arr) {
         int index = 0;
         int prevIndex = -1;
         
         return solve(index, prevIndex, arr);
    }
    
    private int solve(int index, int prevIndex, int[] arr) {
    	if(index == arr.length) {
    		return 0;
    	}
    	
    	int skip = solve(index+1, prevIndex, arr);
    	int take = 0;
    	if(prevIndex == -1 || Math.abs(arr[index] - arr[prevIndex]) == 1) {
    		take = 1 + solve(index+1, index, arr);
    	}
    	
    	return Math.max(take, skip);
    }
    
    public static void main(String[] args) {
		int arr[] = {10, 9, 4, 5, 4, 8, 6};
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.longestSubseq(arr));
	}
}
