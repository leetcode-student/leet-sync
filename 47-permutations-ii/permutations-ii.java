class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> permutations = permuteUnique(nums, 0);

        return new ArrayList<>(permutations);
    }

    private Set<List<Integer>> permuteUnique(int[] nums, int start) {
        Set<List<Integer>> permutations = new HashSet<>();

        if (start == nums.length - 1) {
            permutations.add(new ArrayList<>(Arrays.asList(nums[start])));
            return permutations;
        }

        Set<List<Integer>> subPermutations = permuteUnique(nums, start + 1);
        for (List<Integer> subPermutation : subPermutations) {
            for (int i = 0; i <= subPermutation.size(); i++) {
                List<Integer> permutation = new ArrayList<>(subPermutation);
                permutation.add(i, nums[start]);
                permutations.add(permutation);
            }
        }

        return permutations;
    }
}