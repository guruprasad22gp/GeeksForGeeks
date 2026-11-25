package Marks_from_Ranks;

import java.util.ArrayList;

public class Solution2 {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
    	int n = l.length;
    	
    	int prefixSum[] = new int[n];
    	prefixSum[0] = r[0] - l[0] + 1;
    	for(int i=1;i<n;i++) {
    		prefixSum[i] = prefixSum[i-1] + (r[i] - l[i]+1);
    	}
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	for(int i=0;i<rank.length;i++) {
    		int index = binarySearch(0, prefixSum.length-1, rank[i], prefixSum);
    		
    		int rankFromindex = prefixSum[index] - rank[i];
    		result.add(r[index] - rankFromindex);
    	}
    	
    	return result;
    }
    
    private int binarySearch(int left, int right, int ele, int[] prefixSum) {
    	while(left < right) {
    		int mid = left + (right - left)/2;
    		
    		if(prefixSum[mid] < ele) {
    			left = mid + 1;
    		} else {
    			right = mid;
    		}
    	}
    	
    	return left;
    }
    
    public static void main(String[] args) {
    	int l[] = {1, 6, 14};
    	int r[] = {3, 9, 15};
    	int rank[] = {2, 5, 8};
    	
    	Solution2 sol2 = new Solution2();
    	System.out.println("Output: " + sol2.getMarks(l, r, rank));
	}
}
