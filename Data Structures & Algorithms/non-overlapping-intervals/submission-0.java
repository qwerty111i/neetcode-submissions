class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int removals = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart < prevEnd) {
                removals++;
                prevEnd = Math.min(prevEnd, currEnd);
            } else {
                prevEnd = currEnd;
            }
        }

        return removals;
    }
}
