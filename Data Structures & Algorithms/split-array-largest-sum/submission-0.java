class Solution {
    public int splitArray(int[] nums, int k) {
        int right = 0;
        int left = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;

            int dayTotal = 0;
            int numDays = 1;
            for (int i = 0; i < nums.length; i++) {
                if (dayTotal + nums[i] > mid) {
                    numDays++;
                    dayTotal = nums[i];
                } else {
                    dayTotal += nums[i];
                }
            }

            if (numDays > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}