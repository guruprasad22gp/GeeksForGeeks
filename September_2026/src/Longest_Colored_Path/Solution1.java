package Longest_Colored_Path;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	int maxNodes;
    public int longestPath(String s, int[][] edges) {
        maxNodes = 0;
    	int totalNodes = s.length();
    	
    	if(totalNodes == 1) {
    		return 1;
    	}
    	
    	
        List<List<Integer>> graph = buildGraph(totalNodes, edges);
        DFS(s, graph, 1, 0);
        return maxNodes;
    }
    
    private List<List<Integer>> buildGraph(int n, int[][] edges) {
    	List<List<Integer>> graph = new ArrayList<>();
    	for(int i=0;i<=n;i++) {
    		graph.add(new ArrayList<>());
    	}
    	
    	for(int[] x: edges) {
    		int u = x[0];
    		int v = x[1];
    		graph.get(u).add(v);
    		graph.get(v).add(u);
    	}
    	
    	return graph;
    }
    
    private int[] DFS(String s, List<List<Integer>> graph, int source, int parent) {
    	int dp0 = 1;
    	int dp1 = 1;
    	
    	char currCol = s.charAt(source-1);
    	List<Integer> neigh = graph.get(source);
    	
    	for(int v: neigh) {
    		if(v == parent) {
    			continue;
    		}
    		
    		int child[] = DFS(s, graph, v, source);
    		int child0 = child[0];
//    		int child1 = child[1];
    		int remaining0;
    		int remaining1;
    		char childCol = s.charAt(v-1);
    		
    		if(currCol == childCol) {
    			remaining0 = child[0];
    			remaining1 = child[1];
    		} else {
    			remaining0 = 0;
    			remaining1 = child0;
    		}
    		
    		maxNodes = Math.max(maxNodes, dp0 + remaining1);
    		maxNodes = Math.max(maxNodes, dp1 + remaining0);
    		
    		
    		dp0 = Math.max(dp0, 1 + remaining0);
    		dp1 = Math.max(dp1, 1 + remaining1); 
    	}
    	
    	return new int[] {dp0, dp1};
    }

    public static void main(String[] args) {
    	String s = "RBB";
    	int[][] edges = {
    			{1, 2},
    			{1, 3}
    			};

    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.longestPath(s, edges));
	}
}
