package Max_After_m_Range_Increments;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		int[] a = {0, 1, 2};
		int[] b = {1, 4, 3};
		int[] k = {100, 100, 100};
		int n = 5;
		
		System.out.println("Output: " + m.find_max(a, b, k, n));
	}
	
	public int find_max(int[] a, int[] b, int[] k, int n) {
		int diff[] = new int[n];
		
		for(int i=0;i<a.length;i++) {
			diff[a[i]] += k[i];
			
			if(b[i] + 1 < n) {
				diff[b[i]+1] -= k[i];
			}
		}
		
		int currSum = 0;
		int maxEle = 0;
		
		for(int ele: diff) {
			currSum += ele;
			maxEle = Math.max(currSum, maxEle);
		}
		
		return maxEle;
	}
}
