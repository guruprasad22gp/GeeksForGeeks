package Box_Stacking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Box {
	int height;
	int width;
	int length;
	
	Box(int height, int width, int length) {
		this.height = height;
		this.width = width;
		this.length = length;
	}
}
public class Solution1 {
	int dp[];
    public int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;
        
        List<Box> boxes = new ArrayList<>();
        for(int i=0;i<n;i++) {
        	addBox(boxes, height[i], width[i], length[i]);
        	addBox(boxes, width[i], length[i], height[i]);
        	addBox(boxes, length[i], height[i], width[i]);
        }
        
        int boxSize = boxes.size();
        dp = new int[boxSize+1];
        Arrays.fill(dp, -1); 
        
        int ans = 0;
        
        for(int i=0;i<boxSize;i++) {
        	ans = Math.max(ans, solve(i, boxes));
        }
        
        return ans;
    }
    
    private int solve(int i, List<Box> boxes) {
    	if(dp[i] != -1) {
    		return dp[i];
    	}
    	Box curr = boxes.get(i);
    	
    	int maxHeight = curr.height;
    	
    	for(int j=0;j<boxes.size();j++) {
    		Box next = boxes.get(j);
    		
    		if(next.width < curr.width && next.length < curr.length) {
    			int height = curr.height + solve(j, boxes);
    			maxHeight = Math.max(maxHeight, height);
    		}
    	}
    	
    	return dp[i] = maxHeight;
    }
    
    private void addBox(List<Box> boxes, int a, int b, int c) {
    	if(b < c) {
    		int t = b;
    		b = c;
    		c = t;
    	}
    	
    	boxes.add(new Box(a, b, c));
    }
    
    public static void main(String[] args) {
    	int height[] = {4, 1, 4, 10};
    	int width[] = {6, 2, 5, 12};
    	int length[] = {7, 3, 6, 32};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.maxHeight(height, width, length));

	}
}