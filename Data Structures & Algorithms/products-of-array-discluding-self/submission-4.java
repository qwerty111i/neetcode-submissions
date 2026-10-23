class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] solArr = new int[nums.length];
        solArr[0] = 1;

        int nextMult = nums[0];
        for (int i = 1; i < nums.length; i++) {
            solArr[i] = nextMult;
            nextMult *= nums[i];
        }

        nextMult = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            solArr[i] *= nextMult;
            nextMult *= nums[i];
        }

        return solArr;
    }
}  
