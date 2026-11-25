package Bird_and_Max_Fruit_Gathering;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(67, 65, 70, 27, 1, 46, 84, 94, 6, 86, 82, 58, 71, 59, 51, 67, 73, 51, 16, 92, 66, 2, 39, 66, 9, 66, 59, 3, 84, 93, 21, 77, 21, 15, 87, 60, 51, 64, 1, 17, 40, 60));
		int m = 38;
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxFruits(arr, m));
	}
	
    public int maxFruits(ArrayList<Integer> arr, int m) {
    	int len = arr.size();
    	int max = 0;
    	int currentSum = 0;
    	
    	for(int i=0;i<m;i++) {
    		currentSum += arr.get(i);
    	}
    	
    	max = Math.max(max, currentSum);
    	
    	for(int i=m;i<len+m;i++) {
    		currentSum = currentSum + arr.get(i%len) - arr.get((i-m)%len);
    		max = Math.max(max, currentSum);
    	}
    	
    	return max;
    }
}
