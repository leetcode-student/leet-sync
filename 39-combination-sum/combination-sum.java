/*

use current character up to target times
dont use current character

*/

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> combinationSumSet = combinationSum(candidates, 0, target);

        return new ArrayList<>(combinationSumSet);
    }

    private Set<List<Integer>> combinationSum(int[] candidates, int curr, int target) {
        Set<List<Integer>> combinations = new HashSet<>();

        if (curr == candidates.length) {
            return combinations;
        }

        for (int count = 0; count * candidates[curr] <= target; count++) {
            int currSum = count * candidates[curr];
            List<Integer> currCombination = createCombination(candidates[curr], count);

            if (currSum == target) {
                combinations.add(currCombination);
            } else {
                Set<List<Integer>> subCombinations = combinationSum(candidates, curr + 1, target - currSum);

                for (List<Integer> subCombination : subCombinations) {
                    List<Integer> combination = new ArrayList<>(currCombination);
                    combination.addAll(subCombination);
                    combinations.add(combination);
                }
            }
        }

        return combinations;
    }

    private List<Integer> createCombination(int candidate, int count) {
        List<Integer> combination = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            combination.add(candidate);
        }
        return combination;
    }
}