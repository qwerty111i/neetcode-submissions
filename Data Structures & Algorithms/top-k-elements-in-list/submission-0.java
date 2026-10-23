class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> countMap.get(a) - countMap.get(b)
        );
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            pq.offer(entry.getKey());

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] finalList = new int[k];
        for (int i = finalList.length - 1; i >= 0; i--) {
            finalList[i] = pq.poll();
        }

        return finalList;
    }
}
