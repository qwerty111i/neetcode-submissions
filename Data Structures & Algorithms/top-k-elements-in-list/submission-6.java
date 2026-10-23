class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int index = freqMap.get(key);
            if (freq[index] == null) {
                freq[index] = new ArrayList<>();
            }

            freq[index].add(key);
        }

        int[] returnArr = new int[k];
        int counter = k - 1;
        for (int i = nums.length; i >= 0; i--) {
            if (freq[i] == null) continue;

            for (int num : freq[i]) {
                if (counter < 0) return returnArr;

                returnArr[counter] = num;
                counter--;
            }
        }

        return returnArr;
    }
}
