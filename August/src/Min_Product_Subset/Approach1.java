package Min_Product_Subset;


public class Approach1 {
	public static void main(String[] args) {
		int[] arr = {-5,-6};
		
		Main m = new Main();
		
		System.out.println("Output: " + m.minProd(arr));
	}
	
	public int minProd(int[] arr) {
		int negativeCount = 0;
		int smallestNegEle = Integer.MIN_VALUE;
		for(int ele: arr) {
			if(ele < 0) {
				negativeCount++;
				smallestNegEle = Math.max(ele, smallestNegEle);
			}
		}
		
		if(negativeCount % 2 != 0) {
			int ans = 1;
			for(int ele: arr) {
				if(ele == 0) {
					continue;
				}
				
				ans *= ele;
			}
			
			return ans;
		} else {
			
			if(negativeCount == 0) {
				int ans = Integer.MAX_VALUE;
				for(int ele: arr) {
					ans = Math.min(ele, ans);
				}
				
				return ans;
			} else {
				int ans = 1;
				for(int ele: arr) {
					if(ele == 0) {
						continue;
					}
					ans *= ele;
				}
				
				return ans/(-1 * smallestNegEle);
			}
		}
    }
}
