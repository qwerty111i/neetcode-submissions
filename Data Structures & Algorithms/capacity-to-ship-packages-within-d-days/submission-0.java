class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int right = 0;
        int left = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;

            int dayTotal = 0;
            int numDays = 1;
            for (int i = 0; i < weights.length; i++) {
                if (dayTotal + weights[i] > mid) {
                    numDays++;
                    dayTotal = weights[i];
                } else {
                    dayTotal += weights[i];
                }
            }

            if (numDays > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}