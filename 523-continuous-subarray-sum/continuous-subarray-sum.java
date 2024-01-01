class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0] % k;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = (sum[i - 1] + nums[i]) % k;
        }

        Set<Integer> cache = new HashSet<>();
        cache.add((sum[0] - nums[0]) % k);
        for (int j = 1; j < nums.length; j++) {
            //System.out.println(cache);
            // sum[j] - sum[i] + nums[i] = 0 (mod k)
            // sum[j]                    = sum[i] - nums[i] (mod k)

            if (cache.contains(sum[j])) {
                return true;
            }

            int cacheValue = (sum[j] - nums[j]) % k;
            if (cacheValue < 0) {
                cacheValue += k;
            }

            cache.add(cacheValue);
        }

        return false;
    }
}