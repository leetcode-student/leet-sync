/*
[4,5,6,7,0,1,2]

if nums[start] <= nums[end], then entire array is sorted, pick the lowest
*/
class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int start, int end) {
        
        int mid = start + (end - start) / 2;

        if (nums[start] <= nums[end]) {
            return nums[start];
        } else if (nums[mid] > nums[end]) {
            return findMin(nums, mid + 1, end);
        } else {
            return findMin(nums, start, mid);
        }
    }
}