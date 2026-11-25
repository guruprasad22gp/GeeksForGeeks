package Pairs_with_Given_GCD_and_LCM;

public class Solution1 {
    public int pairCount(int x, int y) {
           if(y % x != 0) {
        	   return 0;
           }
           
           int product = x * y;
           int count = 0;
           
           for(int a = x; a <= y; a++) {
        	   if(product % a == 0) {
        		   int b = product / a;
        		   
        		   if(gcd(a, b) == x) {
        			   count++;
        		   }
        	   }
           }
           
           return count;
    }
    
    private int gcd(int a, int b) {
    	while(b != 0) {
    		int t = b;
    		b = a % b;
    		a = t;
    	}
    	
    	return a;
    }
    
    public static void main(String[] args) {
    	int x = 4;
    	int y = 12;
    	
    	Solution1 sol1 = new Solution1();
    	
    	System.out.println("Output: " + sol1.pairCount(x, y));
	}
}
