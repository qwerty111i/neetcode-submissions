class Solution {
    public class QueueItem {
        int numTasks;
        int readyTime;

        public QueueItem(int numTasks, int readyTime) {
            this.numTasks = numTasks;
            this.readyTime = readyTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int[] taskFreq = new int[26];
        for (char task : tasks) {
            taskFreq[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> b - a
        );

        for (int task : taskFreq) {
            if (task > 0) pq.offer(task);
        }

        Queue<QueueItem> queue = new ArrayDeque<>();
        int time = 0;

        while (!pq.isEmpty() || !queue.isEmpty()) {
            time++;

            while (!queue.isEmpty() && queue.peek().readyTime <= time) {
                pq.offer(queue.poll().numTasks);
            }

            if (!pq.isEmpty()) {
                int task = pq.poll();
                task--;

                if (task > 0) {
                    QueueItem newItem = new QueueItem(task, time + n + 1);
                    queue.offer(newItem);
                }
            }
        }

        return time;
    }
}
