/*

Brute force

Determine the smallest element
Perform a graph search, recording the longest sequence, and marking nodes as visited

Other approach

Sort the array
Iterate through the list, keeping track of the longest sequence

Time: O(n * log(n))



*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }

        Set<Integer> visitedNumbers = new HashSet<>();
        int longest = 0;
        for (int number : numbers) {
            int length = search(number, numbers, visitedNumbers);
            longest = Math.max(longest, length);
        }

        return longest;
    }

    private int search(int number, Set<Integer> numbers, Set<Integer> visitedNumbers) {
        if (!numbers.contains(number)) {
            return 0;
        }

        if (visitedNumbers.contains(number)) {
            return 0;
        }

        visitedNumbers.add(number);

        return 1 + search(number - 1, numbers, visitedNumbers) + search(number + 1, numbers, visitedNumbers);
    }
}