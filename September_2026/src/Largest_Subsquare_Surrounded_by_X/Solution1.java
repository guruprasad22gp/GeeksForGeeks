package Largest_Subsquare_Surrounded_by_X;

public class Solution1 {
    public int largestSubsquare(char mat[][]) {
    	int n = mat.length;
    	
    	int[][] right = new int[n][n];
    	int[][] down = new int[n][n];
    	
    	for(int i=n-1;i>=0;i--) {
    		for(int j=n-1;j>=0;j--) {
    			if(mat[i][j] == 'X') {
    				right[i][j] = 1;
    				
    				if(j+1 < n) {
    					right[i][j] += right[i][j+1];
    				}
    			}
    		}
    	}
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			System.out.print(right[i][j] + " ");
    		}
    		System.out.println();
    	}
    	
    	for(int i=n-1;i>=0;i--) {
    		for(int j=n-1;j>=0;j--) {
    			if(mat[i][j] == 'X') {
    				down[i][j] = 1;
    				if(i+1 < n) {
    					down[i][j] += down[i+1][j];
    				}
    			}
    		}
    	}
    	
    	System.out.println("------------------");
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			System.out.print(down[i][j] + " ");
    		}
    		System.out.println();
    	}
    	
    	for(int size = n; size >= 1; size--) {
    		for(int i=0;i+size<=n;i++) {
    			for(int j=0;j+size <=n;j++) {
    				if(right[i][j] >= size && down[i][j] >= size && right[i+size-1][j] >= size && down[i][j+size-1] >= size) {
    					return size;
    				}
    			}
    		}
    	}
    	
    	return 0;
    }
    
    public static void main(String[] args) {
//    	char mat[][] = {
//    			{'X', 'X', 'X', 'X', 'O', 'O'},
//    			{'X', 'X', 'X', 'X', 'O', 'O'},
//    			{'X', 'X', 'O', 'O', 'O', 'O'}, 
//    			{'X', 'X', 'O', 'X', 'X', 'X'},
//    			{'O', 'O', 'O', 'X', 'X', 'X'}, 
//    			{'O', 'O', 'O', 'X', 'X', 'X'}
//    			};
    	
    	char[][] mat = {
    		    {'X', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O'},
    		    {'O', 'X', 'X', 'X', 'X', 'X', 'X', 'O', 'O', 'O'},
    		    {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'X'},
    		    {'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'O'},
    		    {'O', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O'},
    		    {'X', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X'},
    		    {'O', 'O', 'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O'},
    		    {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
    		    {'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'O'},
    		    {'X', 'X', 'X', 'O', 'O', 'X', 'X', 'X', 'X', 'O'}
    		};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.largestSubsquare(mat));
	}
}
