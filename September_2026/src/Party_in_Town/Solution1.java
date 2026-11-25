package Party_in_Town;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(Arrays.asList(
    		    new ArrayList<>(Arrays.asList(2)),
    		    new ArrayList<>(Arrays.asList(1, 4, 3)),
    		    new ArrayList<>(Arrays.asList(2)),
    		    new ArrayList<>(Arrays.asList(2))
    	));
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.partyHouse(adj));
	}
	
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
    	int n = adj.size();
    	
    	if(n == 1) {
    		return 0;
    	}
    	
    	int[] distance = BFS(adj, 1);
    	int forNode = distance[0];
    	
    	int secondDistance[] = BFS(adj, forNode);
    	int diameter = secondDistance[1];
    	
    	return (diameter + 1) / 2;
    }
    
    private int[] BFS(ArrayList<ArrayList<Integer>> adj, int source) {
    	int n = adj.size();
    	
    	int[] distance = new int[n+1];
    	Arrays.fill(distance, -1);
    	
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(source);
    	distance[source] = 0;
    	
    	int farNode = source;
    	int farDistance = 0;
    	
    	while(!queue.isEmpty()) {
    		int u = queue.poll();
    		
    		for(int nextU: adj.get(u-1)) {
    			if(distance[nextU] == -1) {
    				distance[nextU] = distance[u] + 1;
    				queue.add(nextU);
    				
    				if(distance[nextU] > farDistance) {
    					farDistance = distance[nextU];
    					farNode = nextU;
    				}
    			}
    		}
    	}
    	
    	return new int[] {farNode, farDistance};
    }
}