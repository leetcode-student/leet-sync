/*

        prefixSum[j] - prefixSum[i] + nums[i] = k
        prefixSum[j] -k = prefixSum[i] - nums[i];

*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int count = 0;
        Map<Integer, Integer> sumCounts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = prefixSum[i] - nums[i];
            sumCounts.put(key, sumCounts.getOrDefault(key, 0) + 1);

            int required = prefixSum[i] - k;
            if (sumCounts.containsKey(required)) {
                count += sumCounts.get(required);
            }
        }

        return count;
    }
}