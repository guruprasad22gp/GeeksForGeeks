package Negative_Weight_Cycle;

public class Main {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
    	int[] distance = new int[V];
    	distance[0] = 0;
    	
    	for(int i=0;i<V;i++) {
    		for(int[] x: edges) {
    			int u = x[0];
    			int v = x[1];
    			int w = x[2];
    			
    			if(distance[v] > distance[u] + w) {
    				distance[v] = distance[u] + w;
    				
    				if(i == V-1) {
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    public static void main(String[] args) {
    	int edges[][] = {
    			{0, 3, 6}, 
    			{1, 0, 4}, 
    			{1, 2, 6},
    			{3, 1, 2}
    	};
    	
    	int v = 4;
    	
    	Main m = new Main();
    	
    	System.out.println("Output: " + m.isNegativeWeightCycle(v, edges));
	}
}
