class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {

        int ans = 0;

        //for each bit position calculate the no. of set bits of all the elements
        for(int j=0; j<32; j++){
            int Sum = 0;
            for(int i=0; i<A.length; i++){
                int temp = (A[i]>>j) & 1;
                if(temp == 1){
                    Sum++;
                }
            }

            /* if at any bit position, total no of set bits is not divisible by 3, that means at that bit
            position element which is present once  has set bit */
            if(Sum%3 == 1){
                //to calculate the actual no. add 2^j to the ans(where j is the bit position) using left shift
                ans += 1<<j;
            }
        }
        return ans;
    }
}

/*
T.C = 32*O(N) = O(N)
S.C = O(1)
*/
