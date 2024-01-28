/*

brute force

for each element with value x, create x copies
3 -> 3,3,3
then pick a random element

time: O(total sum)
space: O(total sum)

optimize

prefix sum

[1,2,3,4,5]
[1,3,6,10,15]
1-15

1->1
2->2
3->2
4->3
5->3
6->3
7->4
8->4
9->4
10->4
11->5
12->5
13->5
14->5
15->5

*/
class Solution {
    private int[] prefixSum;
    private int sum;

    public Solution(int[] w) {
        this.sum = 0;
        for (int i = 0; i < w.length; i++) {
            this.sum += w[i];
        }
        this.prefixSum = new int[w.length];
        this.prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            this.prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int target = (int) (Math.random() * sum) + 1;

        int index = binarySearch(prefixSum, target);

        return index;
    }
/**
target = 9

[1,3,6,10,15]
start=0,end=4
mid=2

start=3,end=4

 */
    private int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */