/*

Brute force

Scan the entire list

O(n)
O(1)

[4,5,6,0,1,2,3]
target=6

if target > mid
    if target < end
        search right
    else
        search left
else
    if target > min
        search left
    else
        search right

[3,4,5,1,2]


*/
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] <= target) {
                if (nums[mid] > nums[right] || target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] > nums[mid] || target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}