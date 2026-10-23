class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> intMap = new HashMap<>();
        for (int num : nums) {
            int freq = intMap.getOrDefault(num, 0);
            intMap.put(num, freq + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        intMap.forEach((key, value) -> {
            List<Integer> currVal = buckets[value];
            if (currVal == null) {
                currVal = new ArrayList<>();
            }

            currVal.add(key);
            buckets[value] = currVal;
        });

        int[] returnList = new int[k];
        int count = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            List<Integer> currList = buckets[i];
            if (currList == null || currList.isEmpty()) continue;
            returnList[count] = currList.remove(0);

            count++;
            if (count == k) break;

            if (!currList.isEmpty()) i++;
        }

        return returnList;
    }
}
