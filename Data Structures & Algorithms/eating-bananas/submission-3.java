class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for (int p : piles) {
            right = Math.max(right, p);
        }

        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            int numHours = 0;
            for (int p : piles) {
                numHours += p / mid;
                if (p % mid > 0) numHours++;
            }

            if (numHours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
