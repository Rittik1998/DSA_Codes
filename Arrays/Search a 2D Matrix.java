/*
https://leetcode.com/problems/search-a-2d-matrix/ (Search in a row wise and column wise sorted matrix)
*/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int i = 0;
        int j = N-1;

        //start looking from matrix[0][N-1] element
        while(i<M && j>=0){

            //if that element is target only return true
            if(matrix[i][j]==target){
                return true;
            }

            //if it's greater than target,ignore that column (as col is sorted, below values will be more greater)
            else if(matrix[i][j]>target){
                j--;
            }

            //if it's less than target,ignore that row (as row is sorted, left values will be more lesser)
            else{
                i++;
            }
        }

        //if after iterating target not found return false
        return false;
    }
}
