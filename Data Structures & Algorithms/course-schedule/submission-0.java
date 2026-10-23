class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> courseQueue = new ArrayDeque<>();
        int[] numPrereqs = new int[numCourses];
        ArrayList<ArrayList<Integer>> prereqList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            prereqList.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            numPrereqs[prereq[0]]++;
            prereqList.get(prereq[1]).add(prereq[0]);
        }

        int totalCourses = 0;
        for (int i = 0; i < numPrereqs.length; i++) {
            if (numPrereqs[i] == 0) courseQueue.offer(i);
            else totalCourses++;
        }

        while (!courseQueue.isEmpty()) {
            int nextCourse = courseQueue.poll();
            for (int course : prereqList.get(nextCourse)) {
                numPrereqs[course]--;
                if (numPrereqs[course] == 0) {
                    totalCourses--;
                    courseQueue.offer(course);
                }
            }
        }

        if (totalCourses == 0) return true;
        return false;
    }
}
