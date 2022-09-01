/*
 * Problem Description
Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.



Problem Constraints
0 <= A <= 109
0 <= B <= 30



Input Format
First argument contains a single integer A. Second argument contains a single integer B.



Output Format
Return a single integer X.



Example Input
Input 1:

 A = 3
 B = 3
Input 2:

 A = 15
 B = 2


Example Output
Output 1:

 7
Output 2:

 12


Example Explanation
Explanation 1:

 3 xor 7 = 4 which is minimum
Explanation 2:

 15 xor 12 = 3 which is minimum
 */

class Solution {
    public int solve(int A, int B) {
        
        int ans = 0; // initial value

        /* traversing the bits of A from MSB(left) -> starting from left because
           making msb 0 will give the most min
        * if number of bits in A is equal to B , then answer will be A. A^A=0 gives minimum
          so initial loop to match setbits of A to answer.
        * then second loop if B is greater than setbits in A. in that case adding setbits from LSB
        */

        for(int i=31; i>=0; --i) {
            if(B==0) return ans;
            if((A&(1<<i))>0) {
                ans += (1<<i);
                --B;
            }
        }
        /*
        * second loop , checking unset bit from LSB(right) and
        * changing it to setbit since B is greater than setbits in A
        */
        for(int i=0; i<=31; ++i) {
            if(B==0) return ans;
            if((ans&(1<<i))==0) {
                ans += (1<<i);
                --B;
            }
        }

        return ans;

        
    }
}

/*
 * T.C = 2* O(31) = O(31)
 * S.c = O(1)
 */
