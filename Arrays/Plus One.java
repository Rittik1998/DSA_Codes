/*  https://leetcode.com/problems/plus-one/

Problem Description
Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :

Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
A: For the purpose of this question, YES
Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Problem Constraints
1 <= size of the array <= 1000000



Input Format
First argument is an array of digits.



Output Format
Return the array of digits after adding one.



Example Input
Input 1:

[1, 2, 3]


Example Output
Output 1:

[1, 2, 4]


Example Explanation
Explanation 1:

Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.

*/

class Solution {
    public int[] plusOne(int[] digits) {
        int N = digits.length;
        if(N>1){
            int j = 0;
            while(j<N){
                if(digits[j] != 0){
                    break;     // to get uptil which index front zeroes are there(in the scaler problem)
                }
                j++;
            }

            digits = Arrays.copyOfRange(digits,j,N); // then remove all the zeroes in front 
            N = digits.length;  
        }
    
        for(int i=N-1; i>=0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits; // from last any ith digit less than 9, digit++ and return
            }
            digits[i] = 0;   // if ith digit = 9, then put 0 in that place
        }
        
        // it is still not returned means all digits were 9 e.g 99999 
        int[] res = new int[N+1];  //so create another array of size 1 greater than the actual array
        res[0] = 1; //put 1 in the 1st index
        return res;
    }
}

/*
T.C = O(N)
S.C = O(1) -> as we are returning the array in output
*/