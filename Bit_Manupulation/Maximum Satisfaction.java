/*
 * Problem Description
Given an array of integers A of size N denoting the quality of the fruits. A[i] represents the fruit quality of the ith fruit.

Shaun needs to pick four fruits, but he needs to pick them so that his satisfaction value will be maximum.

If a, b, c, and d are fruit quality of the four fruits picked, then the satisfaction value(a, b, c, d) = (a & b & c & d) where & is bitwise AND operator.

Find the maximum satisfaction value Shaun can obtain.



Problem Constraints
4 <= N <= 105

1 <= A[i] <= 2 * 109



Input Format
The only argument given is the integer array A.



Output Format
Return the maximum satisfaction value Shaun can obtain.



Example Input
Input 1:

 A = [10, 20, 15, 4, 14]
Input 2:

 A = [2, 2, 7, 15]


Example Output
Output 1:

 4
Output 2:

 2
 */

class Solution {
    public int solve(int[] A) {
        int ans = 0;
        //iterate over the bit from left i.e msb because if msb is set, it will make the ans maximun
        for(int j=30; j>=0; j--){
            int count = 0; //count of no. of elements in A[] which has 1 at jth bit
            for(int i=0; i<A.length; i++){
                int checkBit = A[i]>>j & 1;
                if(checkBit == 1){
                    count++; // if any elements has 1 at jth bit, incrementing count
                }

            }

            //if more than 4 elements have 1 at jth bit, then only we can have 1 at jth bit in ans else 0
            if(count>=4){ 
                ans += 1<<j; // add (2^J) in ans, as it will have 1 at jth bit

                /*those elements which have 0 at jth bit, that will not contribute in our ans in future
                as we are ignoring them, so making those elements as 0 in A[]
                */
                for(int i=0; i<A.length; i++){
                    int checkBit = A[i]>>j & 1;
                    if(checkBit == 0){
                        A[i] = 0;
                    }
                }
            }
            
        }
        return ans;
    }
}

/*
 * T.C = 31*O(N+N) = O(N)
 * S.C = O(1)
 */