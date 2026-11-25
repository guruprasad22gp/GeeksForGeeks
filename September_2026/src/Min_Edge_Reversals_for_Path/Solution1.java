package Min_Edge_Reversals_for_Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
	int v;
	int count;
	
	Pair(int v, int count) {
		this.v = v;
		this.count = count;
	}

	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.v, o.v);
	}
}

public class Solution1 {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
    	List<List<Pair>> adj = new ArrayList<>();
    	for(int i=0;i<=n;i++) {
    		adj.add(new ArrayList<>());
    	}
    	
    	for(int[] x: edges) {
    		int u = x[0];
    		int v = x[1];
    		
    		adj.get(u).add(new Pair(v, 0));
    		adj.get(v).add(new Pair(u, 1));
    	}
    	
    	int[] dist = new int[n+1];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	
    	PriorityQueue<Pair> queue = new PriorityQueue<>();
    	dist[src] = 0;
    	
    	queue.add(new Pair(0, src));
    	
    	while(!queue.isEmpty()) {
    		Pair temp = queue.poll();
    		int d = temp.v;
    		int u = temp.count;
    		
    		if(d != dist[u]) {
    			continue;
    		}
    		
    		for(Pair next: adj.get(u)) {
    			int v = next.v;
    			int cost = next.count;
    			
    			if(d + cost < dist[v]) {
    				dist[v] = d + cost;
    				queue.add(new Pair(dist[v], v));
    			}
    		}
    	}
    	
    	return dist[dst] == Integer.MAX_VALUE? -1: dist[dst];
    }
    
    public static void main(String[] args) {
    	int n = 3;
    	int edges[][] = {
    				{1, 2},
    				{3, 2}
    			};
    	int src = 1;
    	int dst = 3;
    	
    	Solution1 sol1 = new  Solution1();
    	System.out.println("Output: " + sol1.minimumEdgeReversal(edges, n, src, dst));

	}
}
