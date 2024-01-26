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
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            System.out.println("mid=" + mid);
            
            if (target == nums[mid]) {
                return mid;
            }

            if (target >= nums[mid]) {
                if (target <= nums[j] || nums[mid] > nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                if (target >= nums[i] || nums[i] > nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }

        return -1;
    }
}