package Subset_Sum_on_Generated_Sequence;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int arr[] = {1, 2, 4, 2};
		int s = 1;
		int x = 7;
		
		Main m = new Main();
		System.out.println("Output: " + m.isPossible(arr, s, x));

	}
	
    public boolean isPossible(int[] arr, int s, int x) {
    	if(x == 0) {
    		return true;
    	}
    	
    	if(s > x) {
    		return false;
    	}
    	
    	ArrayList<Long> numbers = new ArrayList<>();
    	numbers.add((long)s);
    	long currentSum = s;
    	for(int ele: arr) {
    		long newNum = currentSum + ele;
    		
    		if(newNum > x) {
    			break;
    		}
    		
    		numbers.add(newNum);
    		currentSum += newNum;
    	}
    	
    	int target = x;
    	
    	for(int i=numbers.size()-1; i>= 0; i--) {
    		if(numbers.get(i) <= target) {
    			target -= numbers.get(i);
    		}
    	}
    	
    	return target == 0? true: false;
    }
}
