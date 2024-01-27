/*

*/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new IntervalComparator());

        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            if (isOverlapping(lastMergedInterval, intervals[i])) {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], intervals[i][1]);
            } else {
                mergedIntervals.add(intervals[i]);
            }
        }

        int[][] mergedIntervalsArray = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            mergedIntervalsArray[i] = mergedIntervals.get(i);
        }

        return mergedIntervalsArray;
    }

    private static class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] interval1, int[] interval2) {
            return interval1[0] - interval2[0];
        }
    }

    /*
        [   ]
           [   ]

    */
    private boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[0] <= interval2[1] && interval1[1] >= interval2[0])
            || (interval2[0] <= interval1[1] && interval2[1] >= interval1[0]);
    }
}