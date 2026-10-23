class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> courseQueue = new ArrayDeque<>();
        int[] numPrereqs = new int[numCourses];
        ArrayList<ArrayList<Integer>> prereqList = new ArrayList<>();
        int[] courseList = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            prereqList.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            numPrereqs[prereq[0]]++;
            prereqList.get(prereq[1]).add(prereq[0]);
        }

        for (int i = 0; i < numPrereqs.length; i++) {
            if (numPrereqs[i] == 0) courseQueue.offer(i);
        }

        int numCoursesTaken = 0;
        while (!courseQueue.isEmpty()) {
            int nextCourse = courseQueue.poll();
            courseList[numCoursesTaken] = nextCourse;
            numCoursesTaken++;
            for (int course : prereqList.get(nextCourse)) {
                numPrereqs[course]--;
                if (numPrereqs[course] == 0) {
                    courseQueue.offer(course);
                }
            }
        }

        if (numCoursesTaken == numCourses) return courseList;
        return new int[]{};
    }
}
