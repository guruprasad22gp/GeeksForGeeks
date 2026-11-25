package Min_Edge_Movements_to_Connect_a_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		int n = 4;
		int[][] arr = {
				{0, 1}, {1, 2}, {0, 2}
		};
		
		System.out.println("Output: " + m.minEdgesReq(n, arr));
	}
	
    int minEdgesReq(int n, int[][] edges) {
    	int edge = edges.length;
    	
    	if(edge < n-1) {
    		return -1;
    	}
    	
    	List<List<Integer>> adjMatrix = new ArrayList<>();
    	
    	for(int i=0;i<n;i++) {
    		adjMatrix.add(new ArrayList<>());
    	}
    	
    	for(int[] x: edges) {
    		int u = x[0];
    		int v = x[1];
    		
    		adjMatrix.get(u).add(v);
    		adjMatrix.get(v).add(u);
    	}
    	
    	boolean[] visited = new boolean[n];
    	int component = 0;
    	int extraEdges = 0;
    	
    	for(int i=0;i<n;i++) {
    		if(!visited[i]) {
    			component++;
    			int vertices = 0;
    			int edgeCount = 0;
    			
    			Queue<Integer> queue = new LinkedList<>();
    			queue.add(i);
    			visited[i] = true;
    			
    			while(!queue.isEmpty()) {
    				int u = queue.poll();
    				vertices++;
    				edgeCount += adjMatrix.get(u).size();
    				
    				for(int v: adjMatrix.get(u)) {
    					if(!visited[v]) {
    						queue.add(v);
    						visited[v] = true;
    					}
    				}
    			}
    			
    			int actualEdges = edgeCount/2;
    			
    			extraEdges += actualEdges - (vertices - 1);
    		}
    	}
    	
    	
    	int required = component - 1;
    	
    	if(extraEdges >= required) {
    		return required;
    	}
    	
    	return -1;
	}
}
