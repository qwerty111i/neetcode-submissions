class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> retList = new ArrayList<>();
        int[] firstInterval = {intervals[0][0], intervals[0][1]};
        retList.add(firstInterval);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = retList.get(retList.size() - 1);
            if (lastInterval[1] < intervals[i][0]) {
                retList.add(intervals[i]);
            } else {
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            }
        }

        return retList.toArray(new int[retList.size()][2]);
    }
}
