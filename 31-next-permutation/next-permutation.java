/**

For sub array, permutation isn't possible if nums[i] > nums[j] for all i > j

1,2,3
1,3,2
2,1,3
2,3,1
3,1,2
3,2,1

1,3,2,1
2,1,2,3

3,2,1

7,2,8,5,1
7,8,5,2,1

**/
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int nextDecreasingIdx = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                nextDecreasingIdx = i;
                break;
            }
        }

        System.out.println("nextDecreasingIdx=" + nextDecreasingIdx);

        if (nextDecreasingIdx != -1) {
            int nextHighestIdx = nextDecreasingIdx + 1;
            for (int i = nextHighestIdx + 1; i < nums.length; i++) {
                if (nums[i] > nums[nextDecreasingIdx] && nums[i] <= nums[nextHighestIdx]) {
                    nextHighestIdx = i;
                }
            }

            System.out.println("nextHighestIdx=" + nextHighestIdx);

            swap(nums, nextDecreasingIdx, nextHighestIdx);
        }

        reverse(nums, nextDecreasingIdx + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}