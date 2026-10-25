/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) return 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        heap.offer(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {
            Interval currInterval = intervals.get(i);
            if (heap.peek() <= currInterval.start) {
                heap.poll();
                heap.offer(currInterval.end);
            } else {
                heap.offer(currInterval.end);
            }
        }

        return heap.size();
    }
}
