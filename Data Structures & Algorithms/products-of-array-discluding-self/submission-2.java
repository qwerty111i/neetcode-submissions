class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] finalProduct = new int[nums.length];

        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            finalProduct[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            finalProduct[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return finalProduct;
    }
}  
