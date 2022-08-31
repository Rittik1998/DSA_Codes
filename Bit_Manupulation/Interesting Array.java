/*
 * Problem Description
You have an array A with N elements. We have two types of operation available on this array :
We can split an element B into two elements, C and D, such that B = C + D.
We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after several splits and/or merge?



Problem Constraints
1 <= N <= 100000

1 <= A[i] <= 106



Input Format
The first argument is an integer array A of size N.



Output Format
Return "Yes" if it is possible otherwise return "No".



Example Input
Input 1:

 A = [9, 17]
Input 2:

 A = [1]


Example Output
Output 1:

 Yes
Output 2:

 No


Example Explanation
Explanation 1:

 Following is one possible sequence of operations -  
 1) Merge i.e 9 XOR 17 = 24  
 2) Split 24 into two parts each of size 12  
 3) Merge i.e 12 XOR 12 = 0  
 As there is only 1 element i.e 0. So it is possible.
Explanation 2:

 There is no possible way to make it 0.

 */

/*Approach-1
--------------------------
*/
class Solution1 {
    public String solve(int[] A) {
        int countOdd = 0;

        //count number of odd no.s
        for(int i: A){
            if(i%2 == 1) countOdd++;
        }

        /* Every even no.s can divided into 2 equal parts, e.g 10 -> 5,5 a (5+5=10), whose xor = 0 (5^5=0)
           so it can be merged to form 0
         * Every odd no.s can divided into 1+ even no. ,e.g 9 -> 1,8, Then as 8 is an even no., similarly it
           can be divided into 2 equal parts 4,4, it can merged to form 0 (4^4=0), so it will be left with 1
         * But if there are even number of odd no.s, then it will be left with even no.s of 1, so it can be
           merged to 0, as (1^1^1^1..even no. of time = 0)
           if odd number od odd no.s it will be left with 1 after merging
         */

        //check count of odd no.s is even or odd
         if(countOdd%2 == 0){
            return "Yes";
        }
        else{
            return "No";
        }
    }
}


/*Approach-2
--------------------------
*/
class Solution2 {
    public String solve(int[] A) {
        int res = 0;

        //xor all the elements
        for(int i: A){
            res = res^i;
        }

        //if the xor is even, we can split that in 2 equal parts, whose xor will be 0
        /*  A = [8,1,17], xor of all elements = 8^1^17 = 9^17 = 24 (following condition 2)
         * According to condition 1) of question, we can split a no. into 2 parts, so we will split
           24 in 2 parts -> 12,12 as 12+12 = 24
           Now according to condition 2) we can merge 2 no.s in 1 no. ,so we can merge 12 and 12 -> 0, as 12^12 = 0
           So ans will every "Yes" for every even res, as it will follow same logic
        */

        //check result is even or odd
        if(res%2 == 0){
            return "Yes";
        }
        else{
            return "No";
        }
    }
}



/*
 * T.C = O(N) --> for loop
 * S.C = O(1)
 */