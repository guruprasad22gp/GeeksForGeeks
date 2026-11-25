package Min_Product_Subset;

public class Main {
	public static void main(String[] args) {
		int[] arr = {1,2,3,-1};
		
		Main m = new Main();
		
		System.out.println("Output: " + m.minProd(arr));
	}
	
	public int minProd(int[] arr) {
		int product = 1;
		int size = 0;
		int index = 0;
		
		return generate(index, product, size, arr);
    }

	private int generate(int index, int product, int size, int[] arr) {
		if(index == arr.length) {
			if(size == 0) {
				return Integer.MAX_VALUE;
			}
			return product;
		}
		
		int take = generate(index+1, product * arr[index], size+1, arr);
		int skip = generate(index+1, product, size, arr);
		
		return Math.min(take, skip);
	}
}
