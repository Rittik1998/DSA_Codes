/* https://leetcode.com/problems/trapping-rain-water/ */

/* 
Answer
-------------------------------
1) to get the total unit of water we have to find unit of water stored on each building
2) to find unit of water on each building, we need left boundary and right boundary
   (so we will make a leftMax array and rightMax array )

3) then take min(leftMax,rightMax) because we have to find upto which height it has support from both side, then only we
   can store water.
4) unit of water on ith building = min(leftMax[i-1],rightMax[i+1])-(height of ith building)
5) total unit of water = Sum of unit of water on each building
6) edge case: if the (height of building) is greater than min(leftMax,rightMax), then unit of water will be -ve, 
   so we must not add that to the total unit of water(because if height of the building is greater than it's boundaries,
   then it can't store any water, therefore unit of water on that building = 0) 

*/
class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int[] leftMax = new int[N];

        leftMax[0] = height[0];
        for(int i=1; i<N; i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]); //creating leftMax array
        }

        int[] rightMax = new int[N];

        rightMax[N-1] = height[N-1];
        for(int i=N-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i]); //creating rightMax array
        }

        int res = 0;
        for(int i=1; i<N-1; i++){
            int water = Math.min(leftMax[i-1],rightMax[i+1]) - height[i];
            if(water>0){      //to handle the edge case
                res += water;
            }
        }
        return res;
    }
}

/* T.C = O(N)
   S.C = O(N) ----> for the leftmax and rightmax array */