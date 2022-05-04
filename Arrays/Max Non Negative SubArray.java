/*
Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.

The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array.

Find and return the required subarray.

NOTE:

    1. If there is a tie, then compare with segment's length and return segment which has maximum length.
    2. If there is still a tie, then return the segment with minimum starting index.


Input Format:

The first and the only argument of input contains an integer array A, of length N.
Output Format:

Return an array of integers, that is a subarray of A that satisfies the given conditions.
Constraints:

1 <= N <= 1e5
-INT_MAX < A[i] <= INT_MAX
Examples:

Input 1:
    A = [1, 2, 5, -7, 2, 3]

Output 1:
    [1, 2, 5]

Explanation 1:
    The two sub-arrays are [1, 2, 5] [2, 3].
    The answer is [1, 2, 5] as its sum is larger than [2, 3].

Input 2:
    A = [10, -1, 2, 3, -4, 100]

Output 2:
    [100]

Explanation 2:
    The three sub-arrays are [10], [2, 3], [100].
    The answer is [100] as its sum is larger than the other two.
*/




class Solution {
    public int[] maxset(int[] A) {
        int N = A.length;
        long sum = 0;
        long max = 0;
        int max_start = 0;
        int start = 0;
        int length = 0;

        for(int i=0; i<N; i++){

            //if ith element is +ve then add to the sum
            if(A[i]>=0){
                sum += A[i];

                //if sum greater than max, update max, length and store the max_start index
                if(sum>max){
                    max = sum;
                    length = i-start+1;
                    max_start = start;
                }

                /*if sum and max are equal check if current subarray has greater length, then update 
                  length and max_start index */
                if(sum == max){
                   if((i-start+1)>length){
                       length = i-start+1;
                       max_start = start;
                   }
                }
            }

            //if ith element is -ve, then start checking sum from the next index as we will not consider subarray with -ve element
            else{
                sum = 0;
                start=i+1;
            }
        }
        //in A store the reference of new array with copy of elements from max_start and end(max_start+length) 
        A = Arrays.copyOfRange(A,max_start,max_start+length);
        return A;
    }
}

/* T.C = O(N)
   S.C = O(1) --> as we are returning the array in output
*/
