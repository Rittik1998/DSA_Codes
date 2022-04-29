/* https://leetcode.com/problems/first-missing-positive/ */

/* Answer
-----------------------
 youtube solution: https://youtu.be/9SnkdYXNIzM
 1) 1st loop to check 1 is present or not and convert all out of range elements in 1 -> O(N)
 2) if 1 is absent directly return 1
 3) 2nd loop to check if ith element is present make arr[i-1] val -ve for all elements -> O(N)
 4) 3rd loop to check if any ith element is positive then return i+1 -> O(N)
*/


class Solution {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        boolean one = false;  /* we made this variable so that we can figure out that actually 1 was present or not
        (so that when we replace out of range elements as 1, we can figure out previously 1 was there or not) */
        for(int i=0; i<N; i++){
            if(nums[i] == 1){
                one = true; // if we find 1, we will make it true
            }
            if(nums[i]<1 || nums[i]>N){  
                nums[i] = 1; //if the element is outside the range [1,N], we are replacing it by 1
            }
        }

        if(one==false) return 1; //if we didn't find 1, then 1 will be the minimum missing positive only so return 1
        
        /* Now again traverse the array, store the absolute value of ith element in index variable
           and store in arr[index - 1] = negative of the abs value of the element stored there
        */
        for(int i=0; i<N; i++){
            int index = Math.abs(nums[i]);
            nums[index-1] = -Math.abs(nums[index-1]);
        }
        
        /* traverse the array and if we find any ith index element positive that means i+1 element is missing
           in the array, if it would have been present we would have made ith element -ve
        */
        for(int i=0; i<N; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }

        // if all elements [1,N] is there, then N+1 is missing
        return N+1; 
    }
}

/* First Missing element can be in the range [1,N+1] only
  T.C = O(N) + O(N) + O(N) = O(N)
  S.C = O(1)
*/
