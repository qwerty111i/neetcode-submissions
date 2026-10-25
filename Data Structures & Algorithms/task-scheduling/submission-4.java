class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Deque<int[]> queue = new ArrayDeque<>();

        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        for (int i : freq) {
            if (i > 0) heap.offer(i);
        }

        int numCycles = 0;
        while (!heap.isEmpty() || !queue.isEmpty()) {
            numCycles++;

            while (!queue.isEmpty()) {
                int[] nextTask = queue.peek();
                if (nextTask[1] + n + 1 <= numCycles) {
                    queue.poll();
                    heap.offer(nextTask[0]);
                } else {
                    break;
                }
            }
            
            if (!heap.isEmpty()) {
                int nextTask = heap.poll();
                if (nextTask > 1) {
                    queue.offer(new int[]{nextTask - 1, numCycles});
                }
            }
        }

        return numCycles;
    }
}
