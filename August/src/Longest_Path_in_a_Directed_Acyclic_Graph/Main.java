package Longest_Path_in_a_Directed_Acyclic_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
	int v;
	int w;
	
	Pair(int v, int w) {
		this.v = v;
		this.w = w;
	}
	
	public int compareTo(Pair other) {
		return Integer.compare(this.w, other.w);
	}
}

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		int V = 5;
		int src = 1;
		int[][] edges = {
			    {0, 1, 1},
			    {0, 2, 2},
			    {1, 4, 4},
			    {3, 2, -1},
			    {4, 2, 3},
			    {4, 3, 6}
			};
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int[] edge : edges) {
		    ArrayList<Integer> temp = new ArrayList<>();

		    for (int x : edge) {
		        temp.add(x);
		    }

		    list.add(temp);
		}
		
		int[] ans = m.maxDistance(V, src, list);
		for(int ele: ans) {
			System.out.print(ele + " ");
		}
	}
	
	public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
           List<List<Pair>> adjMatrix = new ArrayList<>();
           for(int i=0;i<V;i++) {
        	   adjMatrix.add(new ArrayList<>());
           }
           
           for(ArrayList<Integer> edge: edges) {
        	   int u = edge.get(0);
        	   int v = edge.get(1);
        	   int w = edge.get(2);
        	   
        	   adjMatrix.get(u).add(new Pair(v, w));
           }
           
           int[] distance = new int[V];
           Arrays.fill(distance, Integer.MIN_VALUE);
           
           distance[src] = 0;
           
           PriorityQueue<Pair> queue = new PriorityQueue<>();
           queue.add(new Pair(src, 0));
           
           while(!queue.isEmpty()) {
        	   Pair temp = queue.poll();
        	   int v = temp.v;
//        	   int w = temp.w;
        	   
        	   
        	   for(Pair neigh: adjMatrix.get(v)) {
        		   int ve = neigh.v;
        		   int weight = neigh.w;
        		   
        		   if(distance[ve] < distance[v] + weight) {
        			   distance[ve] = distance[v] + weight;
        			   queue.add(new Pair(ve, distance[ve]));
        		   }
        	   }
           }
           
           return distance;
    }
}
