class Solution {
    public int[] solve(int[] A) {
        int result = 0;

        //iterate and XOR all elements
        for(int i: A){
            result ^= i;
        }
        
        //now result = Xa^Xb (Xa and Xb are the elements that occur once)

        /* i)Now our main task is to separate Xa and Xb.
           ii)If any ith bit in result is set, that means at that bit Xa and Xb has different bits,
              one of them has '0' and another has '1', as we from XOR property.(0^1 =1)
          iii)So we will divide all the elements of the array based on that ith bit
          iv)One part will have the elements which has 0 at the ith bit and another part will have the 
             elements which has 1 at the ith bit
        */

        //make a mask to divide element based on first set bit from lsb
        int mask = (result & (result-1)) ^ result;
        int Xa = 0;
        int Xb = 0;
        int[] val = new int[2];

        for(int i: A){
            int check = i&mask;

            //if ith bit has 0, put it in Xa part
            if(check == 0){
                Xa = Xa^i;
            }

            //if ith bit has 1, put it in Xa part
            else{
                Xb = Xb^i;
            }

            /*
            1)Actually we have combined 2 steps in the above step, putting elemnts in two parts,
            XOR all elements of each part separately
            ii)Xa contains all the elements with 0 at ith bit,in which all are repeating except that one
            iii)Similarly, Xb contains all the elements with 1 at ith bit,in which all are repeating except that one
            iv)So if we XOR all elements of Xa, we will get that one element and similarly XOR all elements of Xb 
               to get that one element
            */
        }

        //store the min in 0th index and max at 1st index
        val[0] = Math.min(Xa,Xb);
        val[1] = Math.max(Xa,Xb);

        return val;
    }
}

/*
T.C = O(N) + O(N) = O(N)
S.C = O(1)
*/
