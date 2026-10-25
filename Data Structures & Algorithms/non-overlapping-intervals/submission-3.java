class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int numErased = 0;
        int lastEndTime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (lastEndTime > intervals[i][0]) {
                lastEndTime = Math.min(lastEndTime, intervals[i][1]);
                numErased++;
            } else {
                lastEndTime = intervals[i][1];
            }
        }

        return numErased;
    }
}
