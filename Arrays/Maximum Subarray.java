/* https://leetcode.com/problems/maximum-subarray/ */


class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int curSum = 0;
    
        for(int i=0; i<nums.length; i++){
            curSum = Math.max(nums[i],curSum+nums[i]);
            sum = Math.max(sum,curSum);
        }
        return sum;
    }
}

/* T.C = O(N)
   S.C = O(1) */ 