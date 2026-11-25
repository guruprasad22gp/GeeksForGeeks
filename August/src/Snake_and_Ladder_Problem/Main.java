package Snake_and_Ladder_Problem;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		 int n = 6;
		 int lad[] = {3, 22, 5, 8, 11, 35, 20, 32};
		 int sn[] = {17, 4, 19, 7, 34, 1, 21, 9};
		 
		 Main m = new Main();
		 
		 System.out.println("Output: " + m.minThrows(n, lad, sn));
	}
	
	public int minThrows(int n, int[] lad, int[] sn) {
		int total = n * n;
		
		int[] jump = new int[total + 1];
		
		for(int i=1;i<=total;i++) {
			jump[i] = i;
		}
		
		for(int i=0;i<lad.length;i += 2) {
			jump[lad[i]] = lad[i+1];
		}
		
		for(int i=0;i<sn.length; i+=2) {
			jump[sn[i]] = sn[i+1];
		}
		
//		BFS
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {1,0});
		
		boolean visited[] = new boolean[total+1];
		visited[1] = true;
		
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int u = temp[0];
			int v = temp[1];
			
			if(u == n*n) {
				return v;
			}
			
			for(int i=1;i<=6;i++) {
				int next = u + i;
				
				if(next <= total) {
					int nextV = jump[next];
					if(!visited[nextV]) {
						visited[nextV] = true;
						queue.add(new int[] {nextV, v+1});
					}
				}
			}
		}
		
		return -1;
    }
}