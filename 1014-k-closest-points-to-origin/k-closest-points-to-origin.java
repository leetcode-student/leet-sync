/*

Brute force

For each point
    Compare distance with top k distances

Time: O(k^n)
Space: O(k)

Alternate

Sort all the distances
Pick the top k

Time: O(n * log(n))
Space: O(n)

Optimized

Bottleneck is the comparison. Using a priority queue will save time

Time: O(n * log(k))
Space: O(k)

*/

class Solution {
    private static final int[] center = new int[] {0, 0};

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new DistanceComparator().reversed());

        for (int[] point : points) {
            minHeap.add(point);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[][] kClosest = new int[minHeap.size()][2];

        for (int i = 0; i < kClosest.length; i++) {
            kClosest[i] = minHeap.poll();
        }

        return kClosest;
    }

    private static double distance(int[] point1, int[] point2) {
        return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }

    private static class DistanceComparator implements Comparator<int[]> {
        public int compare(int[] point1, int[] point2) {
            double comparison = distance(center, point1) - distance(center, point2);
            if (comparison < 0) {
                return -1;
            } else if (comparison > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}