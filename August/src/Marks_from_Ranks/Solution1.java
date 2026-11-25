package Marks_from_Ranks;

import java.util.ArrayList;

public class Solution1 {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
    	int n = l.length;
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	for(int i=0;i<n;i++) {
    		int left = l[i];
    		int right = r[i];
    		
    		for(int mark = left; mark <= right; mark++) {
    			list.add(mark);
    		}
    	}
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for(int k: rank) {
    		result.add(list.get(k-1));
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
    	int l[] = {1, 6, 14};
    	int r[] = {3, 9, 15};
    	int rank[] = {2, 5, 8};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.getMarks(l, r, rank));
	}
}
