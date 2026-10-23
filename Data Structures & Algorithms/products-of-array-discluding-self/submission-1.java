class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productArr = new int[nums.length];

        int prefixProduct = nums[0];
        productArr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            productArr[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            productArr[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return productArr;
    }
}  
