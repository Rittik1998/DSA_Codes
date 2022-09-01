/*(Leetcode similar qstn: https://leetcode.com/problems/total-hamming-distance/submissions/)
 * Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.

For example,

HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).

Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array. Return the answer modulo 1000000007.

Example

Let f(x, y) be the hamming distance defined above.

A=[2, 4, 6]

We return,
f(2, 2) + f(2, 4) + f(2, 6) + 
f(4, 2) + f(4, 4) + f(4, 6) +
f(6, 2) + f(6, 4) + f(6, 6) = 

0 + 2 + 1
2 + 0 + 1
1 + 1 + 0 = 8
 */

class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int hammingDistance(final int[] A) {
        long Sum = 0;
        int mod = 1000000007;

        /*iterate over 0-30 bit positions as 31st bit position represent the sign of no.s. 
          (As it is given in question all elements are +ve, so we can ignore 31st bit position,
           anyway it will not matter even if we consider it) 
        */
        for(int j=0; j<31; j++){
            //set = count of elements of A[] which has 1 at jth bit
            //unset = count of elements of A[] which has 0 at jth bit
            long set = 0, unset = 0;
            for(int i=0; i<A.length; i++){
                int checkBit = A[i]>>j & 1;
                if(checkBit == 1){
                    set++;
                }
                else{
                    unset++;
                }
            }

            /*consider 2 buckets, 1 set bucket and another unset bucket,
              therefore no of pairs with 1 element from set bucket and 1 element from unset bucket = set*unset
              (same as ball and bucket problem approach)
            */
            Sum = (Sum%mod + (set%mod*unset%mod)%mod)%mod;
        }
        /*as we can considering hamming distance of both (a,b) and (b,a), but in the above step.
           it will calculate only 1 arrangement, so return 2*Sum, to consider both arrangements
        */
        return (int)(2*Sum)%mod;
    }
}

/*
 * T.C = 31*O(N) = O(N)
 * S.C = O(1);
 */