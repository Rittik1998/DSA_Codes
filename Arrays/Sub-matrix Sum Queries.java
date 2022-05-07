/*
Problem Description
Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.

Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

NOTE:

Rows are numbered from top to bottom, and columns are numbered from left to right.
Sum may be large, so return the answer mod 109 + 7.


Problem Constraints
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
1 <= Q <= 100000
1 <= B[i] <= D[i] <= N
1 <= C[i] <= E[i] <= M



Input Format
The first argument given is the integer matrix A.
The second argument given is the integer array B.
The third argument given is the integer array C.
The fourth argument given is the integer array D.
The fifth argument given is the integer array E.
(B[i], C[i]) represents the top left corner of the i'th query.
(D[i], E[i]) represents the bottom right corner of the i'th query.



Output Format
Return an integer array containing the submatrix sum for each query.



Example Input
Input 1:

 A = [   [1, 2, 3]
         [4, 5, 6]
         [7, 8, 9]   ]
 B = [1, 2]
 C = [1, 2]
 D = [2, 3]
 E = [2, 3]
Input 2:

 A = [   [5, 17, 100, 11]
         [0, 0,  2,   8]    ]
 B = [1, 1]
 C = [1, 4]
 D = [2, 2]
 E = [2, 4]


Example Output
Output 1:

 [12, 28]
Output 2:

 [22, 19]


Example Explanation
Explanation 1:

 For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
Explanation 2:

 For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
*/




class Solution {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {

        prefixSumMatrix(A);
        int[] result = new int[B.length];
        for(int i=0; i < B.length; i++) {

            //top left corner of each query
            int a1 = B[i] - 1;
            int b1 = C[i] - 1;

            //right bottom corner of each query
            int a2 = D[i] - 1;
            int b2 = E[i] - 1;

            //A[a2][b2] = Sum of elements from index (0,0) to (a2,b2)
            int sum = A[a2][b2];

            /*but we want sum of elements from index (a1,b1) to (a2,b2), so we will subtract the extra 
            elements from sum */

            //subtract sum of elements from (0,0) to (a2,b1-1)
            if(b1 > 0) {
                sum -= A[a2][b1-1]; //consider the edge case (b1>0)
            }

            //subtract sum of elements from (0,0) to (a1-2,b2)
            if(a1 > 0) {
                sum -= A[a1-1][b2]; //consider the edge case (a1>0)
            }

            //we have subtracted sum of elements from (0,0) to (a1-1,b1-1) 2 times, so add that to the sum to handle it
            if(a1 > 0 && b1 > 0) {
                sum += A[a1-1][b1-1]; //consider the edge case (a1>0) and (b1>0)
            }
            

            //do mod of the sum and store in the result array
            result[i] = getMod(sum);

        }

        return result;
    }

    //function to calculate the prefix Sum Array(we are making the input array A only to Prefix Sum array)
    private void prefixSumMatrix(int[][] A) {

        //row-wise
        for(int  row =0; row < A.length; row++) {
            for(int col=1; col < A[row].length; col++) {
                A[row][col] = getMod(A[row][col-1] + A[row][col]);
            }
        }

        //column-wise
        for(int  col =0; col < A[0].length; col++) {
            for(int row=1; row < A.length; row++) {
                A[row][col] = getMod(A[row-1][col] + A[row][col]);;
            }
        }        
    }

    //function to calculate num%mod
    private int getMod(int num) {
        int mod = 1000000007;

        int res = num % mod;

        if(res < 0) {
            return (res + mod) % mod;
        }

        return res;
    }
}

/* T.C = O(N*M) -> for creating the prefix sum array + O(Q) -> for iterating all the queries and calculate result
       =O(NM + Q)  (N=rows, M=columns)
          
   S.C = O(1) 
*/