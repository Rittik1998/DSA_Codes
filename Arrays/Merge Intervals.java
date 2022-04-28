/* Problem Description
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.



Problem Constraints
0 <= |intervals| <= 105



Input Format
First argument is the vector of intervals

second argument is the new interval to be merged



Output Format
Return the vector of intervals after merging



Example Input
Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output
Output 1:

 [ [1, 5], [6, 9] ]
Output 2:

 [ [1, 9] ]


Example Explanation
Explanation 1:

(2,5) does not completely merge the given intervals
Explanation 2:

(2,6) completely merges the given intervals */


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
       int N = intervals.size();
       ArrayList<Interval> res = new ArrayList<>();
       boolean isMerged = false;
       int start = newInterval.start;
       int end = newInterval.end;
       for(int i=0; i<N; i++){
           //left of newInterval condition
           if(intervals.get(i).end<start){
               res.add(intervals.get(i));
           }
           
           //right of newInterval condition
           else if(intervals.get(i).start>end){

               /*if we get a greater(right) interval and if the newInterval is not merged yet, then we have to merge 
                the newInterval first */
               if(isMerged == false){
                    res.add(new Interval(start,end));
                    isMerged = true;
                }
                // if the newInterval is merged then just add all the greater(right) intervals in the res
               res.add(intervals.get(i));
           }
           //the interval overlapping with newInterval(middile) condition
           else{
               start = Math.min(intervals.get(i).start,start);
               end = Math.max(intervals.get(i).end,end);
               
           }
       }

       //even after traversal if it is not yet merged that means newInterval will be merged last
       if(isMerged == false){
            res.add(new Interval(start,end));
            isMerged = true;
        }
        return res;
    }
}

/*
T.C = O(N)
S.C = O(1) ---> because res array we are returning in output
*/