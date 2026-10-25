class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Deque<int[]> queue = new ArrayDeque<>();

        int[] taskArr = new int[26];
        for (char task : tasks) {
            taskArr[task - 'A']++;
        }

        for (int task : taskArr) {
            if (task > 0) {
                heap.offer(task);
            }
        }

        int numCycles = 0;
        while (!heap.isEmpty() || !queue.isEmpty()) {
            numCycles++;

            while (!queue.isEmpty() && queue.peek()[1] + n < numCycles) {
                heap.offer(queue.poll()[0]);
            }

            if (!heap.isEmpty()) {
                int nextTask = heap.poll();
                if (nextTask - 1 > 0) {
                    queue.offer(new int[]{nextTask - 1, numCycles});
                }
            }
        }

        return numCycles;
    }
}
