package Min_Steps_by_Knight;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int x;
	int y;
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution1 {
	public static void main(String[] args) {
		int n = 6;
		int knightPos[] = {1,3};
		int targetPos[]= {5,1};
		
		Solution1 sol1 = new Solution1();

		System.out.println("Output: " + sol1.minStepToReachTarget(knightPos, targetPos, n));
	}
	
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
    	int ux = knightPos[0]-1;
    	int uy = knightPos[1]-1;
    	int vx = targetPos[0]-1;
    	int vy = targetPos[1]-1;
    	
        boolean[][] visited = new boolean[n][n];
        
        int dx[] = {-2,-1,1,2,2,1,-1,-2};
        int dy[] = {1,2,2,1,-1,-2,-2,-1};
        
        int moves = 0;
        
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(ux, uy));
        visited[ux][uy] = true;
        
        
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	
        	while(size > 0) {
        		Pair temp = queue.poll();
        		int x = temp.x;
        		int y = temp.y;
        		
        		if(x == vx && y == vy) {
        			return moves;
        		}
        		
        		for(int k=0;k<8;k++) {
        			int nx = x + dx[k];
        			int ny = y + dy[k];
        			
        			if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
        				visited[nx][ny] = true;
        				queue.add(new Pair(nx, ny));
        			}
        		}
        		size--;
        	}
        	
        	moves++;
        }
        
        return -1;
    }
}
