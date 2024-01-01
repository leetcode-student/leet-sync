/*

case 1

if a end < b start
then move to the next a

case 1a

vice versa

case 2

if b start <= a end
then compute intersection

case 2a vice versa

case 3

a is within b
then compute intersection
move to next a

case 3a

vice versa

*/
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();

        int first = 0;
        int second = 0;

        while (first < firstList.length && second < secondList.length) {
            int firstStart = firstList[first][0];
            int firstEnd = firstList[first][1];
            int secondStart = secondList[second][0];
            int secondEnd = secondList[second][1];

            //System.out.println("first=" + firstStart + "," + firstEnd + " second=" + secondStart + "," + secondEnd);

            if (firstEnd < secondStart) {
                first++;
            } else if (secondEnd < firstStart) {
                second++;
            } else {
                int start = Math.max(firstStart, secondStart);
                int end = Math.min(firstEnd, secondEnd);
                intersections.add(new int[] {start, end});

                if (secondEnd >= firstEnd) {
                    first++;
                } else {
                    second++;
                }
            }
        }

        int[][] intersectionsArray = new int[intersections.size()][2];
        for (int i = 0; i < intersectionsArray.length; i++) {
            intersectionsArray[i][0] = intersections.get(i)[0];
            intersectionsArray[i][1] = intersections.get(i)[1];
        }

        return intersectionsArray;
    }
}