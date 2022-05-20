/*
Intuition
--------------
1)X^X = 0
2)0^X = X
3)if we XOR all elements of the array, all elements that are present twice will become 0, only element that
 is present once will remain in the ans
*/


class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    public int singleNumber(final int[] A) {
        int element = 0;

        //iterate and XOR all the elements
        for(int i: A){
            element = element^i;
        }
        return element;
    }
}

/*
T.C = O(N)
S.C = O(1)
*/
