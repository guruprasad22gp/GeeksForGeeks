package Minimum_Increment_or_Double_Operations_to_Convert;

public class Main {
	public int countMinOperations(int arr[]) {
		int decrementCount = 0;
		int maxDivideCount = 0;
		
		for(int ele: arr) {
			int divideCount = 0;
			
			while(ele > 0) {
				if(ele % 2 == 0) {
					divideCount++;
					ele = ele/2;
				} else {
					decrementCount++;
					ele--;
				}
				
				maxDivideCount = Math.max(divideCount, maxDivideCount);
			}
		}
		
		return decrementCount + maxDivideCount;
	}
	
	public static void main(String[] args) {
		int[] arr = {16, 16, 16};
		
		Main m = new Main();
		System.out.println("Output: " + m.countMinOperations(arr));
	}
}
