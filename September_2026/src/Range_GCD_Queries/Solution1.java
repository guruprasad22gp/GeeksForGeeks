package Range_GCD_Queries;

import java.util.ArrayList;

public class Solution1 {
    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
    	ArrayList<Integer> result = new ArrayList<>();
    	
    	for(int[] x: queries) {
    		if(x[0] == 0) {
    			int startIndex = x[1];
    			int endIndex = x[2];
    			
    			int common = GCD(arr[startIndex], arr[startIndex+1]);
    			for(int i=startIndex+2; i<=endIndex; i++) {
    				common = Math.max(common, GCD(common, arr[i]));
    			}
    			
    			result.add(common);
    			
    		} else {
    			int index = x[1];
    			int val = x[2];
    			arr[index] = val;
    		}
    	}
    	
    	return result;
    }
    
    private int GCD(int a, int b) {
    	while(b != 0) {
    		int t = b;
    		b = a % b;
    		a = t;
    	}
    	
    	return a;
    }
    
    public static void main(String[] args) {
    	int arr[] = {2, 3, 4, 6, 8, 16};
    	int queries[][] = {
    			{0, 0, 2},
    			{1, 3, 8},
    			{0, 2, 5}
    	};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.processQueries(arr, queries));
	}
}
