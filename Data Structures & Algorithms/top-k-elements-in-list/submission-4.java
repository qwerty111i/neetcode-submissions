class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b)
        );

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int key : freqMap.keySet()) {
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }

        int[] returnArr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            returnArr[i] = pq.poll();
        }

        return returnArr;
    }
}
