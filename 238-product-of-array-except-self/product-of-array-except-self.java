/*

[1,2,3,4,5]
[1,1,2,6,24]


*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        prefixProduct[0] = 1;
        int product = 1;
        for (int i = 1; i < nums.length; i++) {
            product = product * nums[i - 1];
            prefixProduct[i] = product;
        }

        product = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int leftProduct = prefixProduct[i];
            product = product * nums[i + 1];
            prefixProduct[i] = leftProduct * product;
        }

        return prefixProduct;
    }
}