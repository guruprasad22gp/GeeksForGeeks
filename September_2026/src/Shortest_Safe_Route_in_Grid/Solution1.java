package Shortest_Safe_Route_in_Grid;

import java.util.LinkedList;
import java.util.Queue;

class Cell {
	int x;
	int y;
	int dist;
	
	Cell(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class Solution1 {
    int shortestPath(int[][] mat) {
    	int m = mat.length;
    	int n = mat[0].length;
    	
    	boolean[][] unsafe = new boolean[m][n];
    	
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(mat[i][j] == 0) {
    				unsafe[i][j] = true;
    				if(i-1 >= 0) {
    					unsafe[i-1][j] = true;
    				}
    				
    				if(j-1 >= 0) {
    					unsafe[i][j-1] = true;
    				}
    				
    				if(i + 1 < m) {
    					unsafe[i+1][j] = true;
    				}
    				
    				if(j+1 < n) {
    					unsafe[i][j+1] = true;
    				}
    			}
    		}
    	}
    	
    	int[] dx = {-1, 1, 0, 0};
    	int[] dy = {0, 0, -1, 1};
    	
    	Queue<Cell> queue = new LinkedList<>();
    	boolean[][] visited = new boolean[m][n];
    	for(int i=0;i<m;i++) {
    		if(!unsafe[i][0]) {
    			queue.add(new Cell(i, 0, 1));
        		visited[i][0] = true;
    		}
    	}
    	
    	while(!queue.isEmpty()) {
    		Cell temp = queue.poll();
    		int x = temp.x;
    		int y = temp.y;
    		int dist = temp.dist;
    		
    		if(y == n-1) {
    			return dist;
    		}
    		
    		
    		for(int i=0;i<4;i++) {
    			int nx = dx[i] + x;
    			int ny = dy[i] + y;
    			
    			if(nx >= 0 && nx < m && ny >= 0 && ny < n && !unsafe[nx][ny] && !visited[nx][ny]) {
    				queue.add(new Cell(nx, ny, dist+1));
    				visited[nx][ny] = true;
    			}
    		}
    	}
    	
    	return -1;
    }
    
    public static void main(String[] args) {
    	int mat[][] = {{1, 0, 1, 1, 1},
    					{1, 1, 1, 1, 1},
    					{1, 1, 1, 1, 1},
    					{1, 1, 1, 0, 1},
    					{1, 1, 1, 1, 0}};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.shortestPath(mat));

	}
}
