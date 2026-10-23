class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqList = new List[nums.length + 1];
        for (int key : countMap.keySet()) {
            int freq = countMap.get(key);

            if (freqList[freq] == null) {
                freqList[freq] = new ArrayList<>();
            }
            freqList[freq].add(key);
        }

        int[] finalList = new int[k];
        int counter = 0;
        for (int i = freqList.length - 1; i >= 0 && counter < k; i--) {
            if (freqList[i] != null) {
                for (int num : freqList[i]) {
                    finalList[counter] = num;
                    counter++;
                    if (counter == k) return finalList;
                }
            }
        }

        return finalList;
    }
}
