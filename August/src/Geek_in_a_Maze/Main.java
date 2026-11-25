package Geek_in_a_Maze;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
    	int row = mat.length;
    	int col = mat[0].length;
    	
    	if(mat[r][c] == '#') {
    		return 0;
    	}
    	
    	int[][] minUp = new int[row][col];
    	for(int i=0;i<row;i++) {
    		Arrays.fill(minUp[i], Integer.MAX_VALUE);
    	}
    	
    	Queue<int[]> queue = new LinkedList<>();
    	minUp[r][c] = 0;
    	queue.add(new int[] {r, c});
    	
    	int[] dr = {-1, 1, 0, 0};
    	int[] dc = {0, 0, -1, 1};
    	
    	while(!queue.isEmpty()) {
    		int[] a = queue.poll();
    		int x = a[0];
    		int y = a[1];
    		
    		
    		for(int k=0;k<4;k++) {
    			int nx = x + dr[k];
    			int ny = y + dc[k];
    			
    			if(nx < 0 || nx >= row || ny < 0 || ny >= col) {
    				continue;
    			}
    			
    			if( mat[nx][ny] == '#') {
    				continue;
    			}
    			
    			int newUp = minUp[x][y];
    			
    			if(nx < x) {
    				newUp++;
    			}
    			
    			if(newUp > u) {
    				continue;
    			}
    			
    			if(newUp < minUp[nx][ny]) {
    				minUp[nx][ny] = newUp;
    				queue.add(new int[] {nx, ny});
    			}
    		}
    	}
    	
    	int ans = 0;
    	
    	for(int i=0;i<row;i++) {
    		for(int j=0;j<col;j++) {
    			if(minUp[i][j] == Integer.MAX_VALUE) {
    				continue;
    			}
    			int up = minUp[i][j];
    			int down = up + i - r;
    			if(down <= d) {
    				ans++;
    			}
    		}
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	 int r = 1;
    	 int c = 0; 
    	 int u = 1; 
    	 int d = 1; 
    	 char[][] mat = {
    			 {'.', '.', '.'}, 
    			 {'.', '#', '.'}, 
    			 {'#', '.', '.'}
    	 };
    	 
    	 Main m = new Main();
    	 
    	 System.out.println("Output: " + m.numberOfCells(r, c, u, d, mat));
	}
}
 