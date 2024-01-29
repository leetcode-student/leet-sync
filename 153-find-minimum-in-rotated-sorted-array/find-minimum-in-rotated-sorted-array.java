/*
[4,5,6,7,0,1,2]

if nums[start] <= nums[end], then entire array is sorted, pick the lowest
*/
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] <= nums[end]) {
                return nums[start];
            }

            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }
}