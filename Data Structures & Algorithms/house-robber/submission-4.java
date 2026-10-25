class Solution {
    public int rob(int[] nums) {
        int money = 0;

        int houseOne = 0;
        int houseTwo = 0;
        for (int i = 0; i < nums.length; i++) {
            money = Math.max(houseOne, houseTwo + nums[i]);
            houseTwo = houseOne;
            houseOne = money;
        }

        return money;
    }
}
