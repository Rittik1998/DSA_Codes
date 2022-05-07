/*
https://leetcode.com/problems/find-pivot-index/
*/


class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0; // initialize sum of whole array
        int leftsum = 0; // initialize leftsum
        int n = nums.length;

        /* Find sum of the whole array */
        for (int i = 0; i < n; i++){
            sum += nums[i];
        }

        for (int i = 0; i < n; i++)
        {
            sum -= nums[i]; // sum is now right sum for index i

            if (leftsum == sum)
                return i;

            leftsum += nums[i];
        }

         /* If no equilibrium index found, then return -1 */
        return -1;
    }
}

/* T.C = O(N)
   S.C = O(1) 
*/