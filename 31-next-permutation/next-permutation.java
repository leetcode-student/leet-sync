/**

1,2,3,4,5
nextperm=2,1,3,4,5

5,4,3,2,1
nextperm=none
-> reset to 1,2,3,4,5

find the last element such at an higher element exists to its right
swap it with the smallest element to the right that's larger (right most)
right side will be descending... reverse it

**/
class Solution {
    public void nextPermutation(int[] nums) {
        int highestIdx = nums.length - 1;
        int firstIdx = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[highestIdx]) {
                firstIdx = i;
                break;
            } else if (nums[i] > nums[highestIdx]) {
                highestIdx = i;
            }
        }

        System.out.println("firstIdx=" + firstIdx);

        if (firstIdx != -1) {
            int nextHighest = -1;

            for (int i = firstIdx + 1; i < nums.length; i++) {
                if (nums[i] > nums[firstIdx] && (nextHighest == -1 || nums[i] <= nums[nextHighest])) {
                    nextHighest = i;
                }
            }

            System.out.println("nextHighest=" + nextHighest);

            swap(nums, firstIdx, nextHighest);
        }

        reverse(nums, firstIdx + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}