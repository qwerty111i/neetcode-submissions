class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] outputList = new int[nums.length - k + 1];

        Deque<Integer> window = new ArrayDeque<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!window.isEmpty() && nums[window.peekLast()] < nums[right]) {
                window.pollLast();
            }

            window.offerLast(right);

            while (!window.isEmpty() && window.peekFirst() < left) {
                window.pollFirst();
            }

            if (right - left + 1 == k) {
                outputList[left] = nums[window.peekFirst()];
                left++;
            }
        }

        return outputList;
    }
}
