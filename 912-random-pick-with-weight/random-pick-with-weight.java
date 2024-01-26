/*

Brute force

Expand each number. For example, 3 will create [3,3,3]
Pick a random element

Time: O(1)
Space: O(n)

[1,2,3,4,5]

[1,3,6,10,15]
pick a random number [1,14]
1 -> 1
2 -> 3
3 -> 3
4 -> 6
5 -> 6
6 -> 6
7 -> 10
8 -> 10
9 -> 10
10 -> 10

*/
class Solution {
    private int[] w;
    private int[] prefixSum;

    public Solution(int[] w) {
        this.w = w;
        this.prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int value = (int) (prefixSum[prefixSum.length - 1] * Math.random()) + 1;

        int start = 0;
        int end = prefixSum.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (value == prefixSum[mid]) {
                return mid;
            } else if (value < prefixSum[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end + 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */