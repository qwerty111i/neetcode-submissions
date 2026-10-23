class KthLargest {
    PriorityQueue<Integer> pq;
    int topK;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(
            (a, b) -> a - b
        );
        topK = k;

        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > topK) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > topK) {
            pq.poll();
        }

        return pq.peek();
    }
}
