/*
 * Problem Description
Given an integer A.
Two numbers, X and Y, are defined as follows:

X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
Find and return the XOR of X and Y.

NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

NOTE 2: Your code will be run against a maximum of 100000 Test Cases.



Problem Constraints
1 <= A <= 109



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the XOR of X and Y.



Example Input
A = 5


Example Output
10


Example Explanation
The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.
 */



/* Intuition
   -------------------
   1)To make A^B = A+B, we have to make A&B = 0 (so this is the first condition). So X and Y both must follow this.

   2)To get X and Y, follow the example and understand the logic

    X -->      0 1 0      X=2    flip the bits to get X (as we will flip the msb of A, so it will be always smaller  
                                 than A and as we are making all unset bit of A to set bit in X, so it will be the
         -----------------       greatest number smaller than A)
            A= 0 1 0 1 
        ------------------
    Y -->      1 0 0 0      Y=8  just take the i+1th set bit for Y(make (msb+1)th bit set and all other bit 0,
                                 so it will be the smallest number greater than A )
*/

class Solution {
    public int solve(int A) {
        int msb = (int)(Math.log(A)/Math.log(2));
        int X = 0;

        for(int i=msb; i>=0; i--){
            int checkBit = A>>i & 1;
            if(checkBit == 0){
                X += (1<<i); //calculate X
                //(as we are making unset bit of A to set bit in X, so automatically set bit of A are becoming unset in X)
            }                 
        }
        int Y = 1<<(msb+1);

        return X+Y;
    }
}

/*
 * T.C = O(msb) = O(31) -> max to max msb can be 31st bit 
 * S.C = O(1)
 */