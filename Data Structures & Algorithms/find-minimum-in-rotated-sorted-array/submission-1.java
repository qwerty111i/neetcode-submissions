class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int minNum = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            minNum = Math.min(nums[mid], minNum);

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                right--;
            }
        }

        return minNum;
    }
}
