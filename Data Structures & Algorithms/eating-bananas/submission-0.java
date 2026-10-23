class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int largestPile = 0;
        for (int pile : piles) {
            if (pile > largestPile) largestPile = pile;
        }

        int left = 1;
        int result = largestPile;
        while (left <= largestPile) {
            int k = left + (largestPile - left) / 2;

            int hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += piles[i] / k;
                if (piles[i] % k > 0) hours++;
            }

            if (hours > h) left = k + 1;
            if (hours <= h) {
                largestPile = k - 1;
                result = k;
            }
        }

        return result;
    }
}
