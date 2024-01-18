class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> histogram1 = histogram(nums1);
        Map<Integer, Integer> histogram2 = histogram(nums2);

        List<Integer> intersection = new ArrayList<>();
        for (Integer num : histogram1.keySet()) {
            if (histogram2.containsKey(num)) {
                int nums1Count = histogram1.get(num);
                int nums2Count = histogram2.get(num);
                int minCount = Math.min(nums1Count, nums2Count);
                for (int j = 0; j < minCount; j++) {
                    intersection.add(num);
                }
            }
        }
        
        int[] intersectionArray = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            intersectionArray[i] = intersection.get(i);
        }

        return intersectionArray;
    }

    private Map<Integer, Integer> histogram(int[] nums1) {
        Map<Integer, Integer> histogram = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            histogram.put(nums1[i], histogram.getOrDefault(nums1[i], 0) + 1);
        }
        return histogram;
    }
}