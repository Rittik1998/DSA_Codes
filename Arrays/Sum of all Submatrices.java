/*
Problem Description
Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.



Problem Constraints
1 <= N <=30

0 <= A[i][j] <= 10



Input Format
Single argument representing a 2-D array A of size N x N.



Output Format
Return an integer denoting the sum of all possible submatrices in the given matrix.



Example Input
A = [ [1, 1]
      [1, 1] ]


Example Output
16


Example Explanation
Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4 * 1 = 4
Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4 * 2 = 8
Number of submatrices with 3 elements = 0
Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
Total Sum = 4+8+4 = 16
*/


/*
Let us suppose the index of an element be (X, Y) in 0 based indexing, then the number of submatrices Sub(x,y) for this element
can be given by the formula Sub(x, y) = (X + 1) * (Y + 1) * (N – X) * (N – Y) .
This formula works because we just have to choose two different positions on the matrix that will create a submatrix that
envelopes the element. Thus, for each element, ‘sum’ can be updated as sum += Sub(x,y) * A[x][y].

More Formally,
Number of ways to choose from top-left elements (X + 1) * (Y + 1)
Number of ways to choose from bottom-right elements (N - X) * (N - Y)

More detailed explanation in copy notes : Advanced Arrays-3 
*/


class Solution {
    public int solve(int[][] A) {

        int N = A.length;
        int Sum = 0;

        //loop through all the elements in the matrix
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int contribution = (i+1)*(j+1)*(N-i)*(N-j); //contribution of each element
                Sum += contribution*A[i][j]; //(contrbution * element) and add to Sum
            }
        }
        return Sum;
    }
}

/* T.C = O(rows*columns) = O(N*N) = O(N^2)
   S.C = O(1) 
*/
