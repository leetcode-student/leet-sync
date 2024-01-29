class Solution {
    public int maxProduct(int[] nums) {
        Integer maxProduct = nums[0];

        int currMaxProduct = nums[0];
        int currMinProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int nextMaxProduct = Math.max(currMinProduct * nums[i], currMaxProduct * nums[i]);
            nextMaxProduct = Math.max(nextMaxProduct, nums[i]);

            int nextMinProduct = Math.min(currMinProduct * nums[i], currMaxProduct * nums[i]);
            nextMinProduct = Math.min(nextMinProduct, nums[i]);

            //System.out.println("nextMaxProduct=" + nextMaxProduct);
            //System.out.println("nextMinProduct=" + nextMinProduct);
            //System.out.println();

            maxProduct = Math.max(maxProduct, nextMaxProduct);

            currMaxProduct = nextMaxProduct;
            currMinProduct = nextMinProduct;
        }

        return maxProduct;
    }
}