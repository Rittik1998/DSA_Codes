/*
Problem Description
You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.

If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.



Problem Constraints
1 <= size of string <= 100000



Input Format
First and only argument is a string A.



Output Format
Return an array of integers denoting the answer.



Example Input
Input 1:

A = "010"
Input 2:

A = "111"


Example Output
Output 1:

[1, 1]
Output 2:

[]


Example Explanation
Explanation 1:

A = "010"

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | "110"
[1 2]          | "100"
[1 3]          | "101"
[2 2]          | "000"
[2 3]          | "001"

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Explanation 2:

No operation can give us more than three 1s in final string. So, we return empty array [].
*/

/* Answer
  -------------
  1) we need max no.s of 1 after flip, after flip '0' becomes '1' and '1' becomes '0'
  2) So if we calculate which subarray contains max no '0's, then our job is done
  3) so when we get '0', do currSum++ else(means if '1') do currSum--
  4) then apply improvised Kadanes's algo
*/

class Solution {
    public int[] flip(String A) {
        
        int N = A.length();
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int[] res = new int[2];

        // iterate through the string and check for 0 and 1
        for(int i=0; i<N; i++){

            //if it is '0', currSum--
            if(A.charAt(i) == '0'){
                currSum++;
            }

            //if it is '1', currSum++
            else{
                currSum--;
            }
            
            // if currSum greater than maxSum, update maxSum and right
            if(currSum>maxSum){
                maxSum = currSum;
                right = i;
                res[0] = left+1;  //we must return result with 1-based index so +1
                res[1] = right+1;
            }

            //if currSum<0, no need to continue the subarray and start new subarray from next index
            if(currSum<0){
                currSum = 0;
                left = i+1;
            }
        }
        
        //if maxSum<0 means there are more no.s of '1's than '0's, so no need to flip and return empty array as per question
        if(maxSum < 0){
            return new int[0];
        }

        return res;
    }
}

/* T.C = O(N)
   S.C = O(1) */