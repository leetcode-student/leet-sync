class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productLeftToRight = new int[nums.length];
        productLeftToRight[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            productLeftToRight[i] = productLeftToRight[i - 1] * nums[i];
        }

        int[] productRightToLeft = new int[nums.length];
        productRightToLeft[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            productRightToLeft[i] = nums[i] * productRightToLeft[i + 1];
        }

        int[] productExceptSelf = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int leftProduct = i > 0 ? productLeftToRight[i - 1] : 1;
            int rightProduct = i + 1 < nums.length ? productRightToLeft[i + 1] : 1;
            productExceptSelf[i] = leftProduct * rightProduct;
        }

        return productExceptSelf;
    }
}