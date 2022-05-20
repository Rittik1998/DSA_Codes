/*
Problem Description
-----------------------------
Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

Note: It is possible to swap any two elements, not necessarily consecutive.



Problem Constraints

1 <= length of the array <= 100000
-109 <= A[i], B <= 109



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.



Output Format

Return the minimum number of swaps.



Example Input

Input 1:

 A = [1, 12, 10, 3, 14, 10, 5]
 B = 8
Input 2:

 A = [5, 17, 100, 11]
 B = 20


Example Output

Output 1:

 2
Output 2:

 1

*/


/*
    Intution
   --------------
   1)count = number of elements <=B(good elements)
   2)make window size = count(so we want a window/subarray which will have only good elements, that only means
   good elements are together)
   3)bad elements = elements that are greater than B
   4)Now we have to traverse every window and calculate which window has min bad elements, because if bad elements
   are min, then swaps required to swap bad elements with good elements will be min, because we need all good
   elements in a subarray, i.e together 
*/

class Solution {
    public int solve(int[] A, int B) {
        
        int N = A.length;
        int count = 0;

        //count number of elements <=B
        for(int i=0; i<N; i++){
            if(A[i]<=B){
                count++;
            }
        }

        //bad = elements that are >B
        int bad = 0;

        //for the first window calculate number of bad elements
        for(int i=0; i<count; i++){
            if(A[i]>B){
                bad++;
            }
        }

        int i=1;
        //initialize ans with bad
        int ans = bad; 

        //follow sliding window technique and check all the windows and determine the min number of bad elements
        //i = start index of window, j = end index of window

        for(int j=count; j<N; j++){

            /*if the start of the previous window was bad, then do bad-- ,because in current window 
            it will not be there, so bad element count will reduce by 1 */
            if(A[i-1]>B){
                bad--;
            }

            /*if the end of the current window is bad, then do bad++ ,because in current window 
            it will be included, so bad element count will increase by 1 */
            if(A[j]>B){
                bad++;
            }

            //store the min number of bad elements in ans
            ans = Math.min(ans,bad);
            i++;
        }
        return ans;
    }
}



/*
T.C = O(N)
S.C = O(1)
*/