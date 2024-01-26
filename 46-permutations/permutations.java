/*

generate all sub permutations
for each sub permutation
    insert first element in one position

*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permute(0, nums);
    }

    public List<List<Integer>> permute(int i, int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (i == nums.length - 1) {
            permutations.add(Arrays.asList(nums[i]));
            return permutations;
        }

        List<List<Integer>> subPermutations = permute(i + 1, nums);
        for (List<Integer> subPermutation : subPermutations) {
            for (int j = 0; j <= subPermutation.size(); j++) {
                List<Integer> permutation = new ArrayList<>(subPermutation);
                permutation.add(j, nums[i]);
                permutations.add(permutation);
            }
        }

        return permutations;
    }
}