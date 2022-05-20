/*
Problem Description
---------------------
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.



Problem Constraints
1 <= A <= 1000



Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements in spiral order.



Example Input
Input 1:

1
Input 2:

2


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2], [4, 3] ]


Example Explanation
Explanation 1:

 
Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3
*/

class Solution {
    public int[][] generateMatrix(int A) {

        int[][] B = new int[A][A];
        int N = A;
        int number = 1;
        int i = 0;
        int j = 0;

        //loop untill N>1
        while(N>1){
            
            //upper row
            for(int k=1; k<N; k++){
                B[i][j] = number;
                number++;
                j++;
            }
            
            //right column
            for(int k=1; k<N; k++){
                B[i][j] = number;
                number++;
                i++;
            }

            //lower row
            for(int k=1; k<N; k++){
                B[i][j] = number;
                number++;
                j--;
            }

            //left column
            for(int k=1; k<N; k++){
                B[i][j] = number;
                number++;
                i--;
            }
            
            //go for next square
            i++;
            j++;

            //decrease the length by 2
            N = N-2;

        }
        // if A is even, all values will be printed with the above loop
        // If A is odd, centre element will not be printed, so print it separately
        if(A%2 == 1){
            B[A/2][A/2] = A*A;
        }

        return B;   
    }
}

/*
T.C = O(N^2)
S.C = O(1)
*/