package Word_in_Grid_All_Occurrences;

import java.util.ArrayList;

public class Solution1 {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
    	int dx[] = {-1, -1, -1, 0, +1, +1, +1, 0,};
    	int dy[] = {-1, 0, +1, +1, +1, 0, -1, -1};
    	
    	int m = mat.length;
    	int n = mat[0].length;
    	
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			
    			if(mat[i][j] == word.charAt(0)) {
    				for(int k=0;k<8;k++) {
    					if(DFS(mat, m, n, word, 0, i, j, dx[k], dy[k])) {
    						ArrayList<Integer> ans = new ArrayList<>();
    						ans.add(i);
    						ans.add(j);
    						result.add(ans);
    						break;
    					}
    				}
    			}
    		}
    	}
    	
    	return result;
    }
    
    private boolean DFS(char[][] grid, int m, int n, String word, int sIdx, int x, int y, int dx, int dy) {
    	if(sIdx == word.length()) {
    		return true;
    	}
    	
    	if(x >= 0 && y >= 0 && x < m && y < n && word.charAt(sIdx) ==  grid[x][y]) {
    		return DFS(grid, m , n, word, sIdx+1, x + dx, y + dy, dx, dy);
    	}
    	
    	return false;
    }
    
    public static void main(String[] args) {
    	char mat[][] = {
    			{'a', 'b', 'a', 'b'},
    			{'a', 'b', 'e', 'b'},
    			{'e', 'b', 'e', 'b'}
    			};
    	String word = "abe";
    	
    	Solution1 sol1 = new Solution1();
    	ArrayList<ArrayList<Integer>> result = sol1.searchWord(mat, word);
    	
    	for(ArrayList<Integer> a: result) {
    		System.out.println(a);
    	}
	}
}
