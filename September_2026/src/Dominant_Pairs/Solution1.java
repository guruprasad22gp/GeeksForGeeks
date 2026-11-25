package Dominant_Pairs;

import java.util.Arrays;

public class Solution1 {
    public int dominantPairs(int[] arr) {    
    	int n = arr.length;
    	int len = n/2;
    	
    	int[] sec = new int[len];
    	for(int i=len;i<n;i++) {
    		sec[i-len] = arr[i];
    	}
    	Arrays.sort(sec);
    	
    	int count = 0;
    	for(int i=0;i<len;i++) {
    		for(int j=len-1;j>=0;j--) {
    			if(arr[i] >= 5 * sec[j]) {
    				count += j+1;
    				break;
    			}
    		}
    	}
        return count;
    }
    
    public static void main(String[] args) {
		int[] arr = {10, 8, 2, 1, 1, 2};
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.dominantPairs(arr));
	}
}
