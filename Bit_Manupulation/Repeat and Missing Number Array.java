/* Problem Description
   --------------------------
 * There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
This is one of those problems.
Please take extra care to make sure that you are type-casting your ints to long properly and at all places. Try to verify if your solution works if number of elements is as large as 105

Food for thought :

Even though it might not be required in this problem, in some cases, you might be required to order the operations cleverly so that the numbers do not overflow.
For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to calculate factorial(n), factorial(k) and then divide them.
Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
Obviously approach 1 is more susceptible to overflows.
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4
 */
class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        int result = 0;
        int N = A.length;

        //xor elements of array with numbers from (1 o N-1)

        //Approach-1 for doing the above step
        for(int i = 0; i<A.length; i++){
            result ^= (A[i]^(i+1));
        }

        //Approach-2 for doing the above step
        for(int i: A){
            result ^= i;
        }

        int j=1;
        while(j<=N){
            result ^= j;
            j++;
        }

        /*So result with atlast contains, result = A^B  
         (where A = repeating element, B = missing element)
          e.g: A[] = [3 1 2 5 3], result = 3^4
        */

        //Calculate the mask, mask = right most set bit(basically but not literally)
        int mask = (result & (result-1)) ^ result;

        //segregate elements of A[] which has 1 at mask-th bit and which has 0 at that bit
        int Xa = 0;
        int Xb = 0;
        int[] val = new int[2];

        for(int i: A){
            int check = i&mask;
            if(check == 0){
                Xa = Xa^i; // Xa will contain xor of all elements with 0 at mask-th bit
            }
            else{
                Xb = Xb^i; // Xb will contain xor of all elements with 1 at mask-th bit
            }
        }

        for(int i=1; i<=N; i++){
            int check = i&mask;
            if(check == 0){
                Xa = Xa^i; // xor Xa with all the natural no.s from 1 to N-1 which have 0 at mask-th bit
            }
            else{
                Xb = Xb^i; // xor Xb with all the natural no.s from 1 to N-1 which have 1 at mask-th bit
            }
        }

        /*now Xa and Xb will contain repeating element and missing element, but which one contains which
          one, that we are not sure
        */

        //so check which one contains which one, because we have to put repeating element at index 0 of ans
        for(int i: A){
            if(i == Xa){ // if this condition is true, that means Xa contains repeating element
                val[0] = Xa; // so assign it to index 0 of ans
                val[1] = Xb; // then we can say, Xb contains missing element so assign it to index 1 of ans
                return val;
            }
        }

        //else vice-versa
        val[0] = Xb;
        val[1] = Xa;
        return val;

    }
}

/*
 * T.C = O(N) -> only iterating A[] and natural no.s from (1 to N-1)
 * S.C = O(1)
 */