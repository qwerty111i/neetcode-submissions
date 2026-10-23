class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] outputList = new int[nums.length - k + 1];

        Deque<Integer> stack = new ArrayDeque<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[right]) {
                stack.pollLast();
            }

            stack.offerLast(right);

            while (!stack.isEmpty() && stack.peek() < left) {
                stack.poll();
            }

            if (right - left + 1 == k) {
                outputList[left] = nums[stack.peek()];
                left++;
            }
        }

        return outputList;
    }
}
