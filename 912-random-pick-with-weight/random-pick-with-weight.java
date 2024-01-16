/*

1,2,3
1,3,6

1,2,2,3,3,3

*/
class Solution {
    private int[] w;
    private int[] wDist;

    public Solution(int[] w) {
        this.w = w;

        this.wDist = new int[w.length];
        wDist[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            wDist[i] = wDist[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int start = 0;
        int end = wDist.length - 1;
        int target = (wDist[start] + wDist[end]) / 2;

        while (start < end) {
            int mid = (start + end) / 2;
            
            Integer leftSum = mid > 0 ? wDist[mid - 1] - wDist[start] + w[start] : null;
            int midSum = w[mid];
            Integer rightSum = mid < wDist.length ? wDist[end] - wDist[mid + 1] + w[mid + 1] : null;
            int totalSum = (leftSum != null ? leftSum : 0) + midSum + (rightSum != null ? rightSum : 0);

            int roll = (int)(totalSum * Math.random() + 1);

            if (roll <= midSum) {
                return mid;
            } else if (leftSum != null && roll <= midSum + leftSum) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */