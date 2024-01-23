class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] remainingPrereqs = new int[numCourses];
        Map<Integer, Set<Integer>> prereqsToCourses = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            remainingPrereqs[course]++;
            if (!prereqsToCourses.containsKey(prereq)) {
                prereqsToCourses.put(prereq, new HashSet<>());
            }
            prereqsToCourses.get(prereq).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < remainingPrereqs.length; i++) {
            if (remainingPrereqs[i] == 0) {
                queue.add(i);
            }
        }

        int numCoursesExplored = 0;
        while (!queue.isEmpty()) {
            int prereq = queue.poll();
            Set<Integer> courses = prereqsToCourses.getOrDefault(prereq, new HashSet<>());
            for (int course : courses) {
                remainingPrereqs[course]--;
                if (remainingPrereqs[course] == 0) {
                    queue.add(course);
                }
            }
            numCoursesExplored++;
        }

        return numCoursesExplored == numCourses;
    }
}