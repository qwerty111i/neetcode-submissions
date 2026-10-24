class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }

        int left = 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;

            long numHours = 0;
            for (int i = 0; i < piles.length; i++) {
                numHours += (piles[i] + mid - 1L) / mid;
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
