class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int countNonOverlap = 1; 
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                countNonOverlap++;
                prevEnd = intervals[i][1];
            }
        }
        return intervals.length - countNonOverlap;
    }
}